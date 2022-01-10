package com.zina.webapp.rest.client;

import com.zina.webapp.messenger.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        List<Message> messages = client.target("http://localhost:8080/webapp_war_exploded/api/")
                .path("messages")
                .queryParam("year",2022)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List< Message >>(){});
        System.out.println(messages);
    }
}
