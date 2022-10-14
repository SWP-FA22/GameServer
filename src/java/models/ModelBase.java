/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.yuyu.jdbc.SQLConnection;
import com.yuyu.jdbc.SQLServerModel;
import java.sql.DriverManager;

/**
 *
 * @author Huu
 * @param <T>
 */
public abstract class ModelBase<T> extends SQLServerModel<T> {

    private static SQLConnection connection = null;

    static void createConnection() {
        final String serverName = "QUANG"; // "battleship.database.windows.net";
        final String databaseName = "Battleship";
        final String username = "su";
        final String password = "Battleship2022";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = new SQLConnection("jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true", username, password);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static {
        connection();
    }
    
    public ModelBase(Class<T> entityClass) throws Exception {
        super(connection, entityClass);
        connection();
    }

    public static SQLConnection connection() {

        try {
            if (connection == null || connection.getConnection().isClosed()) {
                createConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return connection;
    }

}
