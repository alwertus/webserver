package frontend.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

import java.io.IOException;
import java.util.Set;

public class ChatWebSocket {
    private Set<ChatWebSocket> users;
    static final Logger logger = LogManager.getLogger(ChatWebSocket.class);
    private Session session;

    // construcor
    public ChatWebSocket(Set<ChatWebSocket> users) {
        this.users = users;
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        for (ChatWebSocket user : users) {
            try {
                user.getSession().getRemote().sendString(data);
            } catch (IOException e) {
                logger.error(e);
            }
        }
        logger.info("onMessage: " + data);
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        users.add(this);
        setSession(session);
        logger.info("onOpen");
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        users.remove(this);
        logger.info("onClose");
    }

    public Session getSession() { return session; }

    public void setSession(Session session) { this.session = session; }
}
