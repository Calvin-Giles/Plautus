import java.sql.Connection;
import java.sql.SQLException;

import com.example.DatabaseUtil;

public class testconnect {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            System.out.println("Connection successful!");
            DatabaseUtil.closeConnection();
        } catch (SQLException e) {
            System.err.println("Connection failed:");
            e.printStackTrace();
        }
    }

}
