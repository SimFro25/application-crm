package com.simon.application.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DBHelper {
    private static DBHelper instance;

    Connection connection;

    private DBHelper() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/railway", "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println("Can't connection to the database");
        }
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }
}
