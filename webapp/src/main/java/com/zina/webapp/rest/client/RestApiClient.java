package com.zina.webapp.rest.client;

import com.zina.webapp.messenger.model.Message;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.NoSuchElementException;

public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/webapp_war_exploded/api/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messageId}");




        Message message = singleMessageTarget
                .resolveTemplate("messageId","2")
                .request(MediaType.APPLICATION_JSON).get(Message.class);

        Message message1= new Message(4,"New","Zenna");
        Response postResponse= messagesTarget
                .request()
                .post(Entity.json(message1));
        Message createMessage = postResponse.readEntity(Message.class);
        if(postResponse.getStatus() != 201){
            throw new NoSuchElementException();
        }
//        WebTarget target = client.target("http://localhost:8080/webapp_war_exploded/api/messages/1");
//        Invocation.Builder builder =target.request();
//        Response response = builder.get();
//        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());
        System.out.println(createMessage.getMessage());


    }
}
