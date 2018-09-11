/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

/**
 *
 * @author Mark Ferguson
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/sqlite/names.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * select all rows in the table
     */
    public void selectAll(String tablename) {
        String sql = "SELECT * FROM " + tablename;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectOne(String tablename, int num) {
        String sql = "SELECT * FROM " + tablename;
        int count = 0;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            rs.next();
            while (count < num) {
                if (count == (num - 1)) {
                    System.out.println(rs.getString("name"));
                }
                count += 1;
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String randomOne(String tablename) {
        String sql = "SELECT * FROM " + tablename + " ORDER BY RANDOM() LIMIT 1";
        int count = 0;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            //System.out.println(rs.getString("name"));
            return (rs.getString("name"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 3;
        SelectApp app = new SelectApp();
//        app.selectAll("humaniti_male_first");
//        app.selectOne("humaniti_female_first", num);
//        app.randomOne("humaniti_female_first");
        System.out.println(app.getCouple("humaniti"));
    }

    private String getCouple(String race) {
        String first = race + "_male_first";
        String second = race + "_female_first";
        String third = race + "_last";
        String[] tables = {first, second, third};

        String manfirst = "";
        String femfirst = "";
        String surname = "";
        String[] names = {manfirst, femfirst, surname};

        for (int i = 0; i < 3; i++) {
            String tablename = tables[i];
            String sql = "SELECT * FROM " + tablename + " ORDER BY RANDOM() LIMIT 1";
            names[i] = randomOne(tables[i]);
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        String Couple = names[0] + " & " + names[1] + " " + names[2];
        return Couple;
    }
}
