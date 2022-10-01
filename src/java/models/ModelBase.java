/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.yuyu.jdbc.SQLConnection;
import com.yuyu.jdbc.SQLServerModel;

/**
 *
 * @author Huu
 * @param <T>
 */
public abstract class ModelBase<T> extends SQLServerModel<T> {

    private static SQLConnection connection = null;

    static {
        final String serverName = "battleship.database.windows.net";
        final String databaseName = "Battleship";
        final String username = "su";
        final String password = "Battleship2022";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = new SQLConnection("jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true", username, password);
            System.out.println("connect sucessfully");
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
