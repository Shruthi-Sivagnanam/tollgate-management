/*
 * Trip Fare Details
 * 
 * VechileType   SingleTrip  RoundTrip
 * Car           100         150
 * Bus           200         300
 * Truck         300         450
 * 
 */

package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TripFare {

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

    public float getFare(String type, String trip) {
        int check = connection();
        if (check == 1) {
            try {
                Statement statement;
                statement = connection.createStatement();
                String query = "select " + trip + " from tollfare where type=?";
                PreparedStatement stmt = connection
                        .prepareStatement(query);
                stmt.setString(1, type);
                ResultSet resultSet;
                resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    // System.out.println(resultSet.getString(trip));
                    return Float.parseFloat(resultSet.getString(trip));
                }
                statement.close();
                resultSet.close();
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {

        }

        return 0;
    }
}
