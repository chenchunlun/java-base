package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2016/6/4 0004.
 */
public class Test {
    public static void test() {
        Connection con = JDBCUtils.getCon();
        System.out.println(con);

        for(Object[] objArray:JDBCUtils.resultSetToObject()){
            for(Object obj:objArray){
                System.out.print(obj+"   ");
            }
            System.out.println();
        }

        for(Map<String,Object>map:JDBCUtils.resultSetToMap()){
            for(Iterator<Map.Entry<String,Object>> iterator = map.entrySet().iterator() ;iterator.hasNext();){
                Map.Entry entry = iterator.next();
                System.out.print(entry.getKey()+":"+entry.getValue()+"   ");
            }
            System.out.println();
        }
    }

    public static void test01() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ybwh", "root", "qazwsx");
            long end = System.currentTimeMillis();
            System.out.println(con);
            System.out.println(end - start);

            System.out.println("**********************************************");

            //Statement statement = con.createStatement();
            //statement.execute("delete from general_rule");

          /*  PreparedStatement preparedStatement = con.prepareStatement("insert into general_rule (bqrochureurl,type) values (?,?)");
            preparedStatement.setObject(1,"hhhh");
            preparedStatement.setObject(2,"type");
            System.out.println(preparedStatement.executeUpdate());
            preparedStatement.close();

            preparedStatement = con.prepareStatement("select * from  general_rule where id = ?");
            preparedStatement.setObject(1,55);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ResultSetMetaData resultSetMetaData =rs.getMetaData();
                for(int i = 1;i<=resultSetMetaData.getColumnCount();i++){
                    System.out.println(resultSetMetaData.getColumnName(i)+"--->"+rs.getObject(i));
                }
            }
            preparedStatement.close();*/

            //con.setAutoCommit(false);
            /*Statement stmt = con.createStatement();

            for(int i = 0;i<200;i++){
                stmt.addBatch("insert into general_rule (bqrochureurl) values ('test"+i+"')");
            }*/

            /*PreparedStatement preparedStatement = con.prepareStatement("insert into general_rule (bqrochureurl,type,time) values (?,?,?)");
            preparedStatement.setObject(1,"hhhh");
            preparedStatement.setObject(2,"type");
            preparedStatement.setObject(3,new java.sql.Time(System.currentTimeMillis()));
            System.out.println(preparedStatement.executeUpdate());
            preparedStatement.close();

            for(int i = 0;i<200;i++) {
                long rand = 999999999*1000000000+new Random().nextInt(999999999*100000000);
                preparedStatement = con.prepareStatement("insert into general_rule (bqrochureurl,type,time) values (?,?,?)");
                preparedStatement.setObject(1, "hhhh");
                preparedStatement.setObject(2, "type");
                preparedStatement.setObject(3, new java.sql.Time(System.currentTimeMillis()-rand));
                System.out.println(preparedStatement.executeUpdate());
                preparedStatement.close();
            }
            //stmt.executeBatch();
            con.commit();
            //stmt.close();*/
            /*PreparedStatement preparedStatement = con.prepareStatement("select * from  general_rule d where d.time >= ? and d.time <=?");
            preparedStatement.setObject(1,new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-06-05 00:42:58").getTime()));
            preparedStatement.setObject(2,new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-06-05 11:31:06").getTime()));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ResultSetMetaData resultSetMetaData =rs.getMetaData();
                for(int i = 1;i<=resultSetMetaData.getColumnCount();i++){
                    System.out.print(resultSetMetaData.getColumnName(i)+"---"+rs.getObject(i)+"   ");
                }
                System.out.println();
            }
            preparedStatement.close();
            */


          /* PreparedStatement preparedStatement = con.prepareStatement("insert into general_rule (type) values (?)");
            preparedStatement.setBlob(1,new FileInputStream("C:\\Users\\hp\\Desktop\\135664405414393084.jpg"));
            preparedStatement.executeUpdate();
            preparedStatement.close();*/
            PreparedStatement preparedStatement = con.prepareStatement("select * from  general_rule");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                InputStream r = rs.getBlob("type").getBinaryStream();
                OutputStream os = new FileOutputStream("d:\\1.jpg");
                byte[] c = new byte[1024];
                int len = -1;
                while (-1 != (len = r.read(c))) {
                    System.out.print(new String(c, 0, len));
                    os.write(c, 0, len);
                }
                os.close();
                r.close();
                System.out.println();
            }
            preparedStatement.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}