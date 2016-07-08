import org.junit.Test;

import java.util.Date;


import java.sql.*;

/**
 * Created by wosyo on 2016/7/7.
 */
public class TestCase {
    @Test
    public void funcation() throws Exception {
        Date date = new Date();
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
                "    'fengfuyi1',\n" +
                "    '900.00',\n" +
                "    'cc'\n" +
                "  );";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
        Date date1 = new Date();
        System.out.println("success" + (date1.getTime() - date.getTime()));
    }

    @Test
    public void funQuery() throws SQLException {
        Date date = new Date();
        DriverManager.registerDriver((new com.mysql.jdbc.Driver()));
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "1234");
        Statement statement = conn.createStatement();
        String sql = "select * from t_emp;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
        statement.close();
        conn.close();
        Date date1 = new Date();
        System.out.println("success" + (date1.getTime() - date.getTime()));
    }

    @Test
    public void funQuerygrop() throws SQLException, ClassNotFoundException {
        Date date = new Date();

//        DriverManager.registerDriver((new com.mysql.jdbc.Driver()));
//      1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//      2.建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "1234");
//      3.创建Statement
        Statement statement = conn.createStatement();
//      4.书写Sql
        String sql = "SELECT deptno,COUNT(ename) FROM emp WHERE sal>1500 GROUP BY deptno ;";
//      5.执行
        ResultSet resultSet = statement.executeQuery(sql);
//        resultSet.afterLast();
//        while (resultSet.previous()) {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("deptno"));
        }
        statement.close();
        conn.close();
        Date date1 = new Date();
        System.out.println("success" + (date1.getTime() - date.getTime()));
    }


}
