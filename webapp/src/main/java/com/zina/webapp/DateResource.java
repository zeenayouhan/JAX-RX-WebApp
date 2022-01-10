package com.zina.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("date/{dateString}")
public class DateResource {

    @GET
    @Produces("text/plain")
    public String getRequestedDate(@PathParam("dateString") MyDate myDate){
        return "day "+ myDate.toString();

    }
}
