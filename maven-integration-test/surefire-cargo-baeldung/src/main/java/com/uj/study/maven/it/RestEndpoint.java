package com.uj.study.maven.it;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/2 上午8:51
 * @description：
 */
@Path("/")
public class RestEndpoint {
    @GET
    public String hello() {
        return "Welcome to Baeldung!";
    }
}
