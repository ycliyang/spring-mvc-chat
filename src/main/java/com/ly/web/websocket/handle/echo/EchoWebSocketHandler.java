package com.ly.web.websocket.handle.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Echo messages by implementing a Spring {@link org.springframework.web.socket.WebSocketHandler} abstraction.
 */
public class EchoWebSocketHandler extends TextWebSocketHandler {

	private final EchoService echoService;


	@Autowired
	public EchoWebSocketHandler(EchoService echoService) {
		this.echoService = echoService;
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String reply = this.echoService.getMessage(message.getPayload());
		session.sendMessage(new TextMessage(reply));
        session.sendMessage(new TextMessage(session.getRemoteAddress().getHostName() + " : " + session.getRemoteAddress().getAddress()));
	}

}
