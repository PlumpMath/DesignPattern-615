
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by wosyo on 2016/7/8.
 * JDBC简单封装 连接，关闭
 */
public class JDBCUtils {
    private static String mDriver;
    private static String mUrl;
    private static String mUser;
    private static String mPassword;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        mDriver = resourceBundle.getString("driver");
        mUrl = resourceBundle.getString("url");
        mUser = resourceBundle.getString("user");
        mPassword = resourceBundle.getString("password");
        try {
            Class.forName(mDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(mUrl, mUser, mPassword);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建数据库连接失败");
        }
        return connection;
    }

    //2 释放资源
    //1> 参数可能为空
    //2> 调用close方法要抛出异常,确保即使出现异常也能继续关闭
    //3>关闭顺序,需要从小到大
    public static void closeJdbc(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (st != null)
                        st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null)
                            conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static ResultSet query(Connection conn, String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void main(String[] args) {

        testPrepareStatement();

    }

    private static void testPrepareStatement() {
        Date date = new Date();
        Connection connection = getConnection();
        String sql = "select * from t_emp where username=? and password=?";
        String sqlerror = "select * from t_emp where username='caohaikuan' or 1=1 --  'and password='1234';";
        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Statement preparedStatement = connection.createStatement();
//            preparedStatement.setString(1, "caohaikuan' or 1==1 -- ");
//            preparedStatement.setString(2, "1234");
            System.out.println(sqlerror);
            ResultSet resultSet = preparedStatement.executeQuery(sqlerror);
            if (resultSet.next()) {
                System.out.println("登陆陈宫");
            } else {
                System.out.println("登陆失败");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void fanxiangChange() throws Exception {
        Connection connection = getConnection();

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "select * from t_emp";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(3));
        resultSet.updateString(2, "hahah");
        resultSet.updateRow();
        closeJdbc(connection, statement, resultSet);
//        resultSet.updateString("","");

    }

}
