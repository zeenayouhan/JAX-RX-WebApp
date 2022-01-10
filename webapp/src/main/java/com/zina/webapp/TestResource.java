package com.zina.webapp;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.Calendar;
import java.util.Date;

@Path("/test")
//@Path("{pathParam}/hello-world")
//@Singleton
public class TestResource {
    @GET
    @Produces("text/plain")
    public Date hello( ) {
        return Calendar.getInstance().getTime();
    }



//    @PathParam("pathParam") private String pathParamExample;
//    @QueryParam("query") private String queryParamExample;
//
//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Path Param " + pathParamExample + queryParamExample;
//    }


//    private int count;
//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        count = count+1;
//        return "Hello, World!"+ count;
//    }
}