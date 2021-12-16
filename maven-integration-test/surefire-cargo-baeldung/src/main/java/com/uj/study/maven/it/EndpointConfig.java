package com.uj.study.maven.it;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/2 上午8:50
 * @description：
 */
public class EndpointConfig extends ResourceConfig {
    public EndpointConfig() {
        register(RestEndpoint.class);
    }
}