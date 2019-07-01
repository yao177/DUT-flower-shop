package flowershop.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	private static String driver;// 数据库驱动字符串
	private static String url;// 连接URL字符串
	private static String user; // 数据库用户名
	private static String password; // 用户密码
    //Connection conn = null;				// 数据连接对象
    static {
    	init();
    }
    /**
     * 获取数据库连接对象
     */
    public static void init() {
    	Properties params=new Properties();
		String configFile = "database.properties";//配置文件路径
		//加载配置文件到输入流中
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		
		try {
			//从输入流中读取属性列表
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//根据指定的获取对应的值
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("user");
		password=params.getProperty("password");
    }
    public Connection getConnection() {
    	Connection conn = null;
        if(conn==null) {
            // 获取连接并捕获异常
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();				// 异常处理
            }
        }
        return conn;							// 返回连接对象
    }
    /**
     * 关闭数据库连接
     * @param conn 数据库连接
     * @param stmt Statement对象
     * @param rs 结果集
     */
    public void closeAll(Connection conn, Statement stmt, 
                   ResultSet rs) {
        // 若结果集对象不为空,则关闭
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 若Statement对象不为空,则关闭
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 若数据库连接对象不为空,则关闭
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
