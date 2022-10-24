/*
 * The Database Model for Login for Employees
 * 
 * Username - Varchar
 * 
 * password - Varchar- 4 numbered password
 * 
 */

package Backend.Employee;

import java.sql.*;

public class LoginDetail {
    Connection connection = null;

    int connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tollgate",
                    "root", "");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int loginDetail(String username, String password) {
        int check = connection();
        if (check == 1) {
            try {
                Statement statement;
                statement = connection.createStatement();
                PreparedStatement stmt = connection
                        .prepareStatement("select * from user where username=? && password=?");
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet resultSet;
                resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    // System.out.println(resultSet.getString("username"));
                    resultSet.close();
                    statement.close();
                    connection.close();

                    return 1;
                } else {
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
}
