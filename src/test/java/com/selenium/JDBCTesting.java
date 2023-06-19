package com.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JDBCTesting {

    static Connection conn = null;
    private static Statement stmt;
    public static String DB_URL = "jdbc:mysql://localhost/emp";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "123456";

    @BeforeTest
    public void setUp() throws Exception {
        try {
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            String query = "Select * from emp";
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                System.out.println(res.getString(1));
                System.out.println("\t" + res.getString(2));
                System.out.println("\t" + res.getString(3));
                System.out.println("\t" + res.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
