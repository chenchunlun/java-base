package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2016/6/6 0006.
 */
public class JDBCUtils {
    static Connection getCon(){
        Connection con = null ;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ybwh","root","qazwsx");
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    static List<Object[]> resultSetToObject(){
        List<Object[]> objList = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement("select * from  general_rule");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            Object[] objArray = new Object[rsmd.getColumnCount()];
            while(rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    objArray[i] = rs.getObject(i + 1);
                }
                objList.add(objArray);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objList;
    }

    static List<Map<String,Object>> resultSetToMap(){
        List<Map<String,Object>> objMap = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement("select * from  general_rule");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            Map<String,Object> map = new HashMap<String,Object>();
            while(rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    map.put(rsmd.getColumnName(i+1),rs.getObject(i+1));
                }
                objMap.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objMap;
    }
}
