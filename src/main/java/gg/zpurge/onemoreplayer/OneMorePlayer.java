package gg.zpurge.onemoreplayer;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import gg.zpurge.onemoreplayer.listener.IncomingPingListener;
import org.slf4j.Logger;

@Plugin(
        id = "omp",
        name = "OneMorePlayer",
        version = "1.0-SNAPSHOT",
        description = "Gets players online and adds +1 to it, then sets it as max. slots.",
        authors = {"zPurge"}
)
public class OneMorePlayer {

    private final ProxyServer server;


    @Inject
    public OneMorePlayer(ProxyServer server, Logger logger) {
        this.server = server;
        logger.info("Plugin has loaded!");
    }


    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new IncomingPingListener());
    }
}
