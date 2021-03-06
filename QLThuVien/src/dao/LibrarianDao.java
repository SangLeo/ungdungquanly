/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.BorrowerDao.changeDataToBorrower;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BorrowerInfo;
import model.BorrowerStatus;
import model.LibrarianInfo;
import utility.MySqlConnection;

/**
 *
 * @author Quang
 */
public class LibrarianDao {
    public static LibrarianInfo login(String username , String password){
        Connection con = MySqlConnection.getConnection();
        String query = "SELECT * FROM tkxdpm.librarian\n" +
                        "where username = ? and password = ?";
                
        PreparedStatement stat;
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                ArrayList<Object> vector = new ArrayList<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderBookItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (data.size() > 0 ) return changeDataToLibrarian(data.get(0));
        else return null;
    
    
    }
    public static LibrarianInfo changeDataToLibrarian(ArrayList<Object> vector){
        int id = (int) vector.get(0);
        String name = vector.get(1).toString();
        String birthday = vector.get(2).toString();
        String sex = vector.get(3).toString();
        String address = vector.get(4).toString();
        String email = vector.get(5).toString();
        String phone =vector.get(6).toString();
        String username =  vector.get(7).toString();
        String password = vector.get(8).toString();
        
        return new LibrarianInfo(id, name, birthday, sex, address, email, phone, username, password);
        
    }
}
