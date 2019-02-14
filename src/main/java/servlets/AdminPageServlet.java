package servlets;

import etc.AlwFunc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminPageServlet extends HttpServlet {
    public static final String PAGE_URL = "/admin";
    private static final String PAGE_FILENAME = "admin.html";

    // обрабатываем админскую страничку
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(PageGenerator.CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("header", AlwFunc.FileToString(PageGenerator.HTML_DIR + File.separator + "pattern-header.html"));
        String timeString = request.getParameter("shutdown");
        if (timeString != null) {
            int timeMs = Integer.valueOf(timeString);
            System.out.println("Server will be down after: " + timeMs + " ms");
            try {
                Thread.sleep(timeMs);
            } catch (InterruptedException e) {
                System.out.println("ERROR (AdminPageServlet.sleepThread): " + e.toString());
            }
            System.out.println("Shutdown from web command");
            System.exit(0);
        }
        pageVariables.put("status", "run");
        try {
            response.getWriter().println(PageGenerator.getPage(PAGE_FILENAME, pageVariables));
        } catch (IOException e) {
            System.out.println("ERROR (AdminPageServlet.doGet): " + e.toString());
        }
    }
}
