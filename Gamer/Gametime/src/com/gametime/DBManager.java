package com.gametime;

import java.sql.*;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/snakegame";
    private static final String USER = "root";
    private static final String PASSWORD = "MySQLBoi@69";

    public static void saveScore(int score) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO players (score) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, score);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
