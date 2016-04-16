/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author SALIM
 */
@ServerEndpoint("/endpoint")
public class RealtimeWebsocket {
private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public String onMessage(Session session,String message) {
       if (message.trim().isEmpty()){
       return null;
       }
       else {
           try {
               session.getBasicRemote().sendText(message);
           } catch (IOException ex) {
               Logger.getLogger(RealtimeWebsocket.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return message;
    }

    @OnOpen
    public void onOpen(Session peer) {
    peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
    peers.remove(peer);
    }
    
}
