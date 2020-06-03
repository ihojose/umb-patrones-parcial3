package com.ihojose.umb.parcial.singleton;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AnimeMethods {

    ResultSet getAnimes() throws SQLException;
}
