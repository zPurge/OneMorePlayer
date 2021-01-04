package gg.zpurge.onemoreplayer.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.server.ServerPing;

public class IncomingPingListener {

    @Subscribe
    public void onServerlistPing(ProxyPingEvent event) {
        final ServerPing ping = event.getPing();
        event.setPing(ping.asBuilder().maximumPlayers(ping.asBuilder().getOnlinePlayers() + 1).build());
    }

}
