package frontend.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends WebSocketServlet {
    private static final int LOGOUT_TIME = 10 * 60 * 1000;  // 10 min
    public static final String PAGE_URL = "/chat";
    static final Logger logger = LogManager.getLogger(ChatServlet.class);

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        //factory.setCreator(new );
        logger.info("ChatServlet configured");

    }
}