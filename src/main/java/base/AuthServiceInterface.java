package base;

public interface AuthServiceInterface {
    String getUserName(String sessionId);

    void savaUserName(String sessionId, String name);
}
