package base;

import java.util.HashMap;
import java.util.Map;

/**
 * сохраняем в мап имя пользователя, сессию
 * получаем имя по сессии
 */

public class AuthService implements AuthServiceInterface {
    private Map<String, String> userSessions = new HashMap<>();

    @Override
    public String getUserName(String sessionId) {
        return userSessions.get(sessionId);
    }

    @Override
    public void savaUserName(String sessionId, String name) {
        userSessions.put(sessionId, name);
    }
}
