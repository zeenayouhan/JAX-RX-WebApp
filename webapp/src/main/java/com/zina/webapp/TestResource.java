package com.zina.webapp;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
@Singleton
public class TestResource {
    private int count;
    @GET
    @Produces("text/plain")
    public String hello() {
        count = count+1;
        return "Hello, World!"+ count;
    }
}