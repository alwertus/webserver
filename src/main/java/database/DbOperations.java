package database;

public class DbOperations {
    public static void createTable() {
        boolean result = DbConnection.executeQuery("CREATE TABLE IF NOT EXISTS alw_users(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), pass VARCHAR(30));");
        System.out.println("Таблица alw_users " + (result ? "создана" : "уже существует"));
    }

    public static void fillTestData() {
        DbConnection.executeQuery("INSERT INTO alw_users(id, name, pass) VALUES('0', 'test', 'test');");
        DbConnection.executeQuery("INSERT INTO alw_users(id, name, pass) VALUES('1', 'test1', 'test1');");
        DbConnection.executeQuery("INSERT INTO alw_users(id, name, pass) VALUES('2', 'test2', 'test2');");
        System.out.println("(Возможно) Добавлено 3 тестовых пользователя");
    }
}
