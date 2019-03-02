package egovframework.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

  static final String JDBC_DRIVER = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
  static final String DB_URL = "";
  static final String USERNAME = "";
  static final String PASSWORD = "";

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try{
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
      System.out.println("\n- MySQL Connection");
      stmt = conn.createStatement();
      

      String sql;
      sql = "SELECT request FROM test";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
        String response = rs.getString("request");

        System.out.print("\n** response : " + response + "\n");
      }
      rs.close();
      stmt.close();
      conn.close();
    }catch(SQLException se1){
      se1.printStackTrace();
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
      try{
        if(stmt!=null)
          stmt.close();
      }catch(SQLException se2){
      }
      try{
        if(conn!=null)
          conn.close();
        System.out.println("\n\n- MySQL Connection Close");
      }catch(SQLException se){
        se.printStackTrace();
      }
    }
  }
}