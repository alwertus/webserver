package main;

import frontend.Frontend;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @author Alwertus
 * v1.2
 */
// ===== ===== ===== =====   S T A R T   ===== ===== ===== =====
public class Main {
    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();                                                                             // класс обработки GET, POST запросов

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/authform");

        Server server = new Server(8080);                                                                          // новый Jetty сервер
        server.setHandler(context);

        server.start();
        server.join();
    }
}