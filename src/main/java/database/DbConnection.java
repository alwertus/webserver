package database;

import java.sql.*;

public class DbConnection {
    private static final String CONNECTION_STRING = "jdbc:h2:tcp://localhost/~/webserver";
    private static final String DB_LOGIN = "sa";
    private static final String DB_PASSWORD = "tret";

    /*public static void connect() {
        try {
            ResultSet result = getResultSet("select * from cars");
            while (result.next()) {
                String name = result.getString("NAME");
                System.out.println(result.getString("ID") + " " + name);
            }
        } catch (Exception e) {
            System.out.println("ERROR, MZFK" + e.toString());
        }
    }*/

    public static ResultSet getResultSet(String query) {
        ResultSet rs = null;
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING, DB_LOGIN, DB_PASSWORD);
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("ERROR (DBConnection.getResultSet): " + query);
        }
        return rs;
    }

    static boolean executeQuery(String query) {
        boolean rs = false;
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING, DB_LOGIN, DB_PASSWORD);
            Statement st = conn.createStatement();
            rs = st.execute(query);
        } catch (Exception e) {
            System.out.println("ERROR (DBConnection.executeQuery): " + query);
        }
        return rs;
    }

}
