import org.junit.Test;

import java.sql.*;

/**
 * Created by wosyo on 2016/7/7.
 */
public class TestCase {
    @Test
    public void funcation() throws Exception {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "1234");
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO `emp`.`t_emp` (\n" +
                "  `id`,\n" +
                "  `username`,\n" +
                "  `salary`,\n" +
                "  `job`\n" +
                ")\n" +
                "VALUES\n" +
                "  (\n" +
                "    NULL,\n" +
                "    'fengfuyi',\n" +
                "    '900.00',\n" +
                "    'cc'\n" +
                "  );";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("success");
    }

    @Test
    public void funQuery() throws SQLException {
        DriverManager.registerDriver((new com.mysql.jdbc.Driver()));
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "1234");
        Statement statement = conn.createStatement();
        String sql = "select * from t_emp;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
        statement.close();
        conn.close();
        System.out.println("success");
    }



}
