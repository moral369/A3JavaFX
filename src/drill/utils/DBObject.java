package drill.utils;

/**
 * Created by Chan-Ju on 2015-08-23.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Chan-Ju on 2015-08-23.
 */
public class DBObject {

    private Connection m_db_conn = null;
    private final String jdbc_url = "jdbc:oracle:thin:@a3security.iptime.org:1521:orcl";
    private final String db_id = "c##moral"; //�����ͺ��̽� ����
    private final String db_pwd = "dufwjd"; //�����ͺ��̽� ��� ��ȣ

    private final String DB_USER    = "c##moral"; // DB USER��
    private final String DB_PASSWORD = "dufwjd"; // �н�����
    private final String DB_URL = "jdbc:oracle:thin:@a3security.iptime.org:1521:orcl";


    // private���� SinletonŬ������ ������ �ν��Ͻ��� �����ϱ� ���� ���� ������ ����
    private volatile static DBObject uniqueInstance;

    // �����ڸ� private�� �����߱� ������ Singleton������ Ŭ������ ���� �� �ִ�.
    private DBObject() throws ClassNotFoundException, SQLException {
        init();
    }

    // Ŭ������ �ν��Ͻ��� ���� ������ �ش�.
    public static DBObject getInstance() throws ClassNotFoundException, SQLException {
        if (uniqueInstance == null) {
            // �̷��� �ϸ� ó������ ����ȭ �ȴ�
            synchronized (DBObject.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DBObject();
                }
            }
        }
        return uniqueInstance;
    }


    public Connection getConnection()
    {
        System.out.println("[debug] oracle driver handle = "+ m_db_conn);

        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                m_db_conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("database driver connection success^^");  //���������� �ε��Ǿ���
            } catch (ClassNotFoundException e) {
                System.out.println("[ERROR] oracle driver connection fail - ClassNotFoundException"); //�ش� ����̹��� ã�� �� �����ϴ�.
            } catch (SQLException se) {
                System.out.println("[ERROR] oracle driver connection fail - SQLException");
        }

        return m_db_conn;
    }

    private  void init() throws ClassNotFoundException, SQLException {

        connect();
    }

    private void connect() throws ClassNotFoundException, SQLException {
        try {
            Class.forName( "oracle.jdbc.driver.OracleDriver");
            m_db_conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println( "database driver connection success^^" );  //���������� �ε��Ǿ���
        } catch( ClassNotFoundException e ) {
            System.out.println( "[ERROR] oracle driver connection fail - ClassNotFoundException" ); //�ش� ����̹��� ã�� �� �����ϴ�.
        } catch( SQLException se) {
            System.out.println( "[ERROR] oracle driver connection fail - SQLException" );
        }
    }

    public double getInfecteeCount() {
        try (Connection con = getConnection()) {
            //���̺��� �������� ������ ���� ����
            if (!infecteeSchemaExists(con)) {
                MyLog.i("");
                createInfecteeSchema(con);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 6;
    }


    public boolean infecteeSchemaExists(Connection con) {
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeQuery("select count(*) from infectee");
            MyLog.i("select count(*) from infectee = "+st.executeQuery("select count(*) from infectee"));
        } catch (SQLException e) {
            e.printStackTrace();
            MyLog.i("return false");
            return false;
        }
        MyLog.i("return true");
        return true;
    }

    public void createInfecteeSchema(Connection con) throws SQLException {
        Statement st = null;
        try {
            MyLog.i("createSchema");
            st = con.createStatement();
//            String table = "create table infectee(counting integer(10) NOT NULL)";
//            st.executeUpdate(table);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean urlClickSchemaExists(Connection con) {
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeQuery("select count(*) from urlclick");
//            MyLog.i(""+st.executeQuery("select count(*) from urlclick"));
        } catch (SQLException e) {
            e.printStackTrace();
            MyLog.i("return false");
            return false;
        }
        return true;
    }

    public void createUrlClickSchema(Connection con) throws SQLException {
        Statement st = null;
        try {
            MyLog.i("createSchema");
            st = con.createStatement();
//            String table = "create table bank(counting integer(10) NOT NULL)";
//            st.executeUpdate(table);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean appExecuteSchemaExists(Connection con) {
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeQuery("select count(*) from info");
//            MyLog.i(""+st.executeQuery("select count(*) from info"));
        } catch (SQLException e) {
            e.printStackTrace();
            MyLog.i("return false");
            return false;
        }
        return true;
    }

    public void createAppExecuteSchema(Connection con) throws SQLException {
        Statement st = null;
        try {
            MyLog.i("createSchema");
            st = con.createStatement();
            String table = "create table info(counting integer(10) NOT NULL)";
            st.executeUpdate(table);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean appInstallSchemaExists(Connection con) {
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeQuery("select count(*) from install");
//            MyLog.i(""+st.executeQuery("select count(*) from install"));
        } catch (SQLException e) {
            e.printStackTrace();
            MyLog.i("return false");
            return false;
        }
        return true;
    }

    public void createAppInstallSchema(Connection con) throws SQLException {
        Statement st = null;
        try {
            MyLog.i("createSchema");
            st = con.createStatement();
            String table = "create table install(counting integer(10) NOT NULL)";
            st.executeUpdate(table);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}