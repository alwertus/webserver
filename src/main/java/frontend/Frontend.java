package frontend;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alwertus
 *
 * Класс-обработчик GET-POST запросов
 */
public class Frontend extends HttpServlet {

    private String login = "";

    // обработка GET запросов. Параметры передаются в строке URL
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> pageVariables = new HashMap<>();                                                            // карта хранит lastLogin (уникальный)
        pageVariables.put("lastLogin", login == null ? "" : login);
        response.getWriter().println(PageGenerator.getPage("authform.html", pageVariables));                   // ответ = отдаём нашему PageGeneratorу параметры, получаем страницу, и запуливаем её пользователю
        response.setContentType("text/html;charset=utf-8");                                                             // параметры и результат
        response.setStatus(HttpServletResponse.SC_OK);

    }

    // обработка POST запросов. Параметры передаются отдельно
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        login = request.getParameter("login");                                                                       // выковыриваем login из запроса
        response.setContentType("text/html;charset=utf-8");                                                             // установка параметров
        if (login == null || login.isEmpty()) {                                                                         // логин пустой -> ответ = FORBIDDEN, иначе OK
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        Map<String, Object> pageVariables = new HashMap<>();                                                            // заполняем карту с lastLogin
        pageVariables.put("lastLogin", login == null ? "" : login);
        response.getWriter().println(PageGenerator.getPage("authform.html", pageVariables));                   // ответ = отдаём нашему PageGeneratorу параметры, получаем страницу, и запуливаем её пользователю
    }
}