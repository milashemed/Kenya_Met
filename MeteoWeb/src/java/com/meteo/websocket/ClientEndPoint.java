/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.websocket;

import java.io.IOException;
import java.net.URI;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author SALIM
 */
@javax.websocket.ClientEndpoint
public class ClientEndPoint {
Session userSession  = null;
private MessageHandler handler;
public ClientEndPoint(URI endpointURI) throws RuntimeException, DeploymentException, IOException{
WebSocketContainer container = ContainerProvider.getWebSocketContainer();
container.connectToServer(this, endpointURI);
}
@OnOpen
public void onOpen(Session userSession){
this.userSession = userSession;
}
@OnClose
public void onClose(Session userSession,CloseReason reason){

}
@OnMessage
public void onMessage(String message){
if (this.handler != null){
this.handler.handleMessage(message);
}
}
public void addMessageHandler(MessageHandler msghandler){
this.handler = msghandler;
}
public void sendMessage(String message){
this.userSession.getAsyncRemote().sendText(message);
}
public interface MessageHandler{
public void handleMessage(String message);
}
}

