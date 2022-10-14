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

    static {
//        final String serverName = "battleship.database.windows.net";
        final String serverName = "localhost";
        final String databaseName = "battleship";
        final String username = "sa";
        final String password = "123";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = new SQLConnection("jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true", username, password);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ModelBase(Class<T> entityClass) throws Exception {
        super(connection, entityClass);
    }

    public static SQLConnection connection() {
        return connection;
    }
}
