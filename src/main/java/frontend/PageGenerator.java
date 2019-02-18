package frontend;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Передаём классу желаемую страницу и параметры
 * Класс выплёвывает страницу
 */

public class PageGenerator {
    private static final Configuration CFG = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    public static final String CONTENT_TYPE = "text/html;charset=utf-8";
    public static final String HTML_DIR = "html";

    // использование шаблонов страниц
    public static String getPage(String fileName, Map<String, Object> data) {
        Writer stringWriter = new StringWriter();

        // берём html файл (шаблон) и подставляем данные из data. Результат записываем на выход
        try {
            Template template = CFG.getTemplate(HTML_DIR + File.separator + fileName);
            template.process(data, stringWriter);
        } catch (IOException | TemplateException e) {
            System.out.println("ERROR (PageGenerator): " + e.toString());
        }
        return stringWriter.toString();
    }
}