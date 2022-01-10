package com.zina.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world7")
public class TestResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}