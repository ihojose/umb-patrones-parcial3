package com.ihojose.umb.parcial.singleton;

import com.ihojose.umb.parcial.Credentials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Anime implements AnimeMethods {

    public static DbConnection CONNECTION = null;

    static {
        try {
            CONNECTION = DbConnection.getDbConnection(Credentials.URL, Credentials.USER, Credentials.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet getAnimes() throws SQLException {
        return CONNECTION.getDbConnection().prepareStatement("SELECT * FROM animes").executeQuery();
    }
}
