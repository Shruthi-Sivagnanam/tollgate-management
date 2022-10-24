/*
 * Record Model
 * 
 * customer name - varchar
 * vechile type - varchar
 * vechile number - varchar
 * trip type - varchar
 * fare - float
 * pmode - varchar
 * 
 */

package Backend.Record;

import java.sql.*;

public class RecordDetails {
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

    public int insertRecord(String name, String type, String number, String trip, float fare, String pmode) {
        int check = connection();
        if (check == 1) {
            try {
                Statement statement;
                statement = connection.createStatement();
                String querry = "VALUES(?,?,?,?,?,?) ";
                String querry1 = "insert into record (name,type,number,trip,fare,pmode) " + querry;
                PreparedStatement stmt = connection.prepareStatement(querry1);
                stmt.setString(1, name);
                stmt.setString(2, type);
                stmt.setString(3, number);
                stmt.setString(4, trip);
                stmt.setFloat(5, fare);
                stmt.setString(6, pmode);
                stmt.execute();
                connection.close();
                statement.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return 0;
        } else {
            return 0;
        }
    }
}
