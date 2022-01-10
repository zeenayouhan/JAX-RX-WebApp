package com.zina.webapp.rest.client;

import com.zina.webapp.messenger.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:8080/webapp_war_exploded/api/messages/1").request().get();

        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());
        System.out.println(message.getComments());
    }
}
