package com.mpc;

import net.lvsq.jgossip.core.GossipService;
import net.lvsq.jgossip.core.GossipSettings;
import net.lvsq.jgossip.model.GossipState;
import net.lvsq.jgossip.model.SeedMember;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GossipMain {

    private static final int PORT = Integer.parseInt(System.getProperty("port", "60001"));

    public static void main(String[] args) {
        int gossip_port = PORT;
        String cluster = "gossip_cluster";

        GossipSettings settings = new GossipSettings();
        settings.setGossipInterval(2000);

        try {
            String myIpAddress = InetAddress.getLocalHost().getHostAddress();
            List<SeedMember> seedNodes = new ArrayList<>();
            SeedMember seed = new SeedMember();
            seed.setCluster(cluster);
            seed.setIpAddress(myIpAddress);
            seed.setPort(60001);
            seedNodes.add(seed);

            final GossipService gossipService = new GossipService(cluster, myIpAddress, gossip_port, null, seedNodes, settings, (member, state, payload) -> {
                if (state == GossipState.UP) {
                    System.out.println("[[[[[[[[[member:" + member + "  was up!!! ]]]]]]]]]");
                }
                if (state == GossipState.RCV) {
                    System.out.println("member:" + member + "  state: " + state + " payload: " + payload);
                }
                if (state == GossipState.JOIN) {
                    System.out.println("[[[[[[[[[member:" + member + "  was join!!! ]]]]]]]]]");
                }
                if (state == GossipState.DOWN) {
                    System.out.println("[[[[[[[[[member:" + member + "  was down!!! ]]]]]]]]]");
                }});
            new Thread(() -> {

                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    gossipService.getGossipManager().publish("hello: " + PORT);
                    break;
                }
            }).start();

            gossipService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
