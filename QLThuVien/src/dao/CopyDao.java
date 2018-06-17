package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Copy;
import utility.MySqlConnection;

/**
 *
 * @author sanglv
 */
public class CopyDao {
    private ResultSet rs;
    /**
     * Get list copy from copy table
     */
    public void getlistCopy(){
        Connection con = MySqlConnection.getConnection();
        String query = "select * from copy";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            System.out.println("Record from database");
            while(rs.next()){
                String id = rs.getString("id");
                String idBook = rs.getString("id_book");
                String catalog = rs.getString("category");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                System.out.println(id + "|" + idBook + "|" + catalog+"|" + price + "|" + status);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * add copy
     * @param copy is copy object to add
     */
    public void addCopy(Copy copy){
        Connection con = MySqlConnection.getConnection();
        String query = "insert into copy value(?,?,?,?,?)";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, copy.getId());
            stat.setString(2, copy.getIdBook());
            stat.setString(3, copy.getCategory());
            stat.setInt(4, copy.getPrice());
            stat.setString(5, copy.getStatus());
            stat.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    /**
     * delete copy by id
     * @param id is position of copy need to delete
     */
    public void deleteCopy(String id){
        
        Connection con = MySqlConnection.getConnection();
        String query2 = "delete from copy where id = ?";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query2); 
            stat.setString(1, id);
            stat.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Get list id book from copy table
     * @return list current id book from copy table
     */
    public List getListIdBookFromCopy(){
        List<String> ls = new ArrayList<String>(); 
        Connection con = MySqlConnection.getConnection();
        String query = "select id_book from copy";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id_book");
                ls.add(id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ls;
    }
    /**
     * Get list id copy in copy table
     * @return list current id copy in copy table
     */
    public List getListIdCopy(){
        List<String> ls = new ArrayList<String>(); 
        Connection con = MySqlConnection.getConnection();
        String query = "select id from copy";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                ls.add(id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ls;
    }
    /**
     * Get copy by id
     * @param id is position of copy 
     * @return copy by id
     */
    public ArrayList<Copy> getCopyFromId(String id){
        Copy copy;
        ArrayList<Copy> list = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String query = "select * from copy where id = ?";
            PreparedStatement stat;
            stat = con.prepareStatement(query);
            stat.setString(1, id);
            stat.execute();
            rs = stat.executeQuery();
            while(rs.next()){
                String idCopy = rs.getString("id");
                String idBook = rs.getString("id_book");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                copy = new Copy(id, idBook, category, price, status);
                list.add(copy);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    /**
     * Update copy by id
     * @param copy is copy object need to update
     * @param idCopy is position of copy need to update
     */
    public void updateCopy(Copy copy, String idCopy){
        Connection con = MySqlConnection.getConnection();
        PreparedStatement stat;
        String query = "update copy set id_book=?, category=?, price=?, status=? where id = ?";
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, copy.getIdBook());
            stat.setString(2, copy.getCategory());
            stat.setInt(3, copy.getPrice());
            stat.setString(4, copy.getStatus());
            stat.setString(5, idCopy);
            stat.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Get copy by id
     * @param idCopy is position of copy
     * @return 
     */
    public Copy getCopyById(String idCopy){
        Copy copy = null;
        Connection con = MySqlConnection.getConnection();
        String query = "select * from copy where id = ?";
        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, idCopy);
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
               copy =  new Copy(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
           }
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return copy;
    }
    /**
     * Check copy if copy exists
     * @param id is position of copy need to check
     * @return true if copy exists else false
     */
    public boolean checkCopyExists(String id){        
        List ls = getListIdCopy();
        for(int i = 0; i < ls.size();i ++){
            if(id.equalsIgnoreCase(ls.get(i).toString())){
                return true;
            }
        }
        return false;
    }
}
