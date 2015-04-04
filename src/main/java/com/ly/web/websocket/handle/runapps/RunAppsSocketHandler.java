package com.ly.web.websocket.handle.runapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by liyang on 15/3/28.
 */
public class RunAppsSocketHandler extends TextWebSocketHandler {


    private final DefaultRunAppsService runAppsService;


    @Autowired
    public RunAppsSocketHandler(DefaultRunAppsService defaultRunAppsService) {
        this.runAppsService = defaultRunAppsService;
    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String reply = this.runAppsService.getMessage(message.getPayload());
        session.sendMessage(new TextMessage(reply));
//        session.sendMessage(new TextMessage(session.getRemoteAddress().getHostName() + " : " + session.getRemoteAddress().getAddress()));
    }
}
