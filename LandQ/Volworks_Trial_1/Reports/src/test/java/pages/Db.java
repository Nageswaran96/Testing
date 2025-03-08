package pages;

import junit.framework.Assert;

import java.sql.*;

public class Db {

    public Connection connection;
    String dbUrl ="jdbc:mysql://localhost:3306/Local instance MySQL80";
    String dbUser = "root";
    String dbPwd = "root";

    public void connectDatabase() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            System.out.println("DB connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery() {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("use volworks; ");
            ResultSet rs = statement.executeQuery("select * from final_booster_processed_lq where symbol = 'AAPL'");
            System.out.println(rs);
            Assert.assertTrue(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
