package models;

import com.yuyu.jdbc.SQLConnection;
import com.yuyu.jdbc.SQLServerModel;
import java.sql.SQLException;

/**
 *
 * @author Huu
 * @param <T>
 */
public abstract class ModelBase<T> extends SQLServerModel<T> {

    private static SQLConnection connection = null;

    static void createConnection() {
        final String serverName = "battleship2022.database.windows.net";
        final String databaseName = "BattleShip";
        final String username = "su";
        final String password = "Battleship2022";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = new SQLConnection("jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true", username, password);
        } catch (ClassNotFoundException | SQLException e) {
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
        } catch (SQLException e) {
            return null;
        }
        return connection;
    }
}
