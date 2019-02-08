package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AdminPageServlet;
import servlets.Frontend;

// ===== ===== ===== =====   S T A R T   ===== ===== ===== =====
public class Main {
    static private Integer port = 8080;
    public static void main(String[] args) throws Exception {
//         Если порт указан - запустить на этом порту
        if (args.length == 1)
            port = Integer.valueOf(args[0]);
        System.out.append("Starting at port: ").append(port.toString()).append('\n');

//        Создание отдельных сервлетов для разных ссылок
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new AdminPageServlet()), AdminPageServlet.adminPageURL);   // страничка админа
        context.addServlet(new ServletHolder(new Frontend()), Frontend.frontendPageURL);                // главная страница

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("static");  // папка с html файлами

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {resourceHandler, context});

        Server server = new Server(port);   // новый Jetty сервер
        server.setHandler(handlers);        // ранее сюда передавал context

        server.start();
        server.join();
    }
}