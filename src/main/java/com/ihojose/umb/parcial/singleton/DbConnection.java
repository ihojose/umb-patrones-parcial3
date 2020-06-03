package com.ihojose.umb.parcial.singleton;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class DbConnection {
    private String url;
    private String user;
    private String password;
    private Connection dbConnection;
    private static DbConnection DB_CONNECTION;

    /**
     * Singleton instantiation connection to database by Jose Buelvas Santos
     *
     * @param url      Database URL
     * @param user     Database User
     * @param password Database Password
     * @return Connection
     * @throws ClassNotFoundException Class not found
     * @throws SQLException           SQL Exception
     */
    public static DbConnection getDbConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        if (DB_CONNECTION == null) {
            DB_CONNECTION = new DbConnection(url, user, password);
        }

        return DB_CONNECTION;
    }

    /**
     * Private constructor by Jose Buelvas
     *
     * @param url      Database URL
     * @param user     Database user
     * @param password Database password
     * @throws ClassNotFoundException Class not found
     * @throws SQLException           SQL Exception
     */
    private DbConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        this.url = url;
        this.user = user;
        this.password = password;

        // Checking if postgres Driver is in dependencies
        Class.forName("org.postgresql.Driver");

        this.dbConnection = DriverManager.getConnection(this.url, this.user, this.password);
    }
}
