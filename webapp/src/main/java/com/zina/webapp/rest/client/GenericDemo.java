package com.zina.webapp.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        List response = client.target("http://localhost:8080/webapp_war_exploded/api/")
                .path("messages")
                .queryParam("year",2021)
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);
        System.out.println();
    }
}
