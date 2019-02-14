package servlets;

import etc.AlwFunc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * класс обработчик GET-POST запросов
 */
public class AuthenticationPageServlet extends HttpServlet {
    public static final String PAGE_URL = "/authform";
    private static final String PAGE_FILENAME = "authform.html";
    private static final String PARAMETERNAME_LOGIN = "login";
    private String login = "";

    private String fillPageParameters() {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login == null ? "" : login);
        pageVariables.put("header", AlwFunc.FileToString(PageGenerator.HTML_DIR + File.separator + "pattern-header.html"));
        return PageGenerator.getPage(PAGE_FILENAME, pageVariables);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println(fillPageParameters());
        } catch (IOException e) {
            System.out.println("ERROR (AuthenticationPageServlet.doGet): " + e.toString());
        }
        response.setContentType(PageGenerator.CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        login = request.getParameter(PARAMETERNAME_LOGIN);
        response.setContentType(PageGenerator.CONTENT_TYPE);
        response.setStatus((login == null || login.isEmpty()) ?
                HttpServletResponse.SC_FORBIDDEN :
                HttpServletResponse.SC_OK);
        try {
            response.getWriter().println(fillPageParameters());
        } catch (IOException e) {
            System.out.println("ERROR (AuthenticationPageServlet.doPost): " + e.toString());
        }
    }
}
