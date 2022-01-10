package com.zina.webapp.rest.client;

import com.zina.webapp.messenger.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/webapp_war_exploded/api/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messageId}");




        Message message = singleMessageTarget
                .resolveTemplate("messageId","2")
                .request(MediaType.APPLICATION_JSON).get(Message.class);

//        WebTarget target = client.target("http://localhost:8080/webapp_war_exploded/api/messages/1");
//        Invocation.Builder builder =target.request();
//        Response response = builder.get();
//        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());
        System.out.println(message.getComments());


    }
}
