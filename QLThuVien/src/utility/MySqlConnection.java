/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Quang
 */
public class MySqlConnection {
    
	private static Connection con=null;
        private static String user = "root";
        private static String password = "";
        // connect to database(mysql)
        public static void connection(){
            try
		{
			String strCon="jdbc:mysql://localhost/tkxdpm?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
			Properties pro = new Properties();
			pro.put("user", user);
			pro.put("password", password);
			con =  DriverManager.getConnection(strCon, pro);
			
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
        
        }
    
       public static Connection getConnection(){
           connection();
           return con;
       }
       
                
        
        
}
        
