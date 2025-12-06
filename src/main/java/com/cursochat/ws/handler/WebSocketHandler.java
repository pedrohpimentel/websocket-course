package com.cursochat.ws.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
* A classe WebSocketHandler foi criada para gerenciar o ciclo de vida e a interação com as conexões WebSocket.
* Ele irá atuar como um ponto de entrada para as minhas mensagens WebSocket,
* separando essa lógica do meu código RESTful(controladores/@Controller).
* Servirá também para fornecer os três métodos callback que instanciei.

* Eu utilizei o @Component para marcar a classe como componente gerenciado por ela mesma, um Bean (Objeto)
*
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    /*É chamado após o Handshake WebSocket for concluído com sucesso e a conexão estiver aberta.*/
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("afterConnectionEstablished session id : " + session.getId());
    }

    /*É chamado toda vez que o servidor receber uma mensagem de texto de um cliente conectado*/
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)  {
        System.out.println("handleTextMessage Message : " + message.getPayload());
    }

    /*È chamado após a conexão ser fechada pelo cliente ou servidor.*/
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("afterConnectionClosed session id :  " + session.getId());
    }
}
