package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Book;
import utility.MySqlConnection;

/**
 *
 * @author sanglv
 */
public class BookDao {
    List<String> ls = new ArrayList<String>();
    private ResultSet rs;
    /**
     * Get list Books in book table 
     * @return list Books in book table
     */
    public ArrayList<Book> getListBook(){
        ArrayList<Book> ls = new ArrayList<>(); 
        try {
            Connection con = MySqlConnection.getConnection();
            String query = "select * from book";
            PreparedStatement stat;
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            Book book;
            while(rs.next()){   
                String id = rs.getString("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publishingCompany = rs.getString("publishing_company");
                String publishingDate = rs.getString("publishing_date");
                int totalQuantity = rs.getInt("total_quantity");
                String ISBN = rs.getString("ISBN");
                int currentQuantity = rs.getInt("current_quantity");
                book = new Book(id, name, author, publishingCompany, publishingDate, ISBN, totalQuantity, currentQuantity);
                ls.add(book);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ls;
    }
    public ArrayList<Book> getBookFromId(String id){
        Book book;
        ArrayList<Book> list = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String query = "select * from book where id = ?";
            PreparedStatement stat;
            stat = con.prepareStatement(query);
            stat.setString(1, id);
            stat.execute();
            rs = stat.executeQuery();
            while(rs.next()){
                String idBook = rs.getString("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publishingCompany = rs.getString("publishing_company");
                String publishingDate = rs.getString("publishing_date");
                int totalQuantity = rs.getInt("total_quantity");
                String ISBN = rs.getString("ISBN");
                int currentQuantity = rs.getInt("current_quantity");
                book = new Book(id, name, author, publishingCompany, publishingDate, ISBN, totalQuantity, currentQuantity);
                list.add(book);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
        return list;
        
    }
    /**
     * add book
     * @param book is object of book to add into book table
     */
    public void addBook(Book book){
        Connection con = MySqlConnection.getConnection();
        String query = "insert into book value(?,?,?,?,?,?,?,?)";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, book.getId());
            stat.setString(2, book.getName());
            stat.setString(3, book.getAuthor());
            stat.setString(4,book.getPublishingCompany());
            stat.setString(5, book.getPublishingDate());
            stat.setString(6, book.getISBN());
            stat.setInt(7, book.getTotalQuantity());
            stat.setInt(8, book.getCurrentQuantity());
            stat.execute();
        } catch (Exception e) {
            System.out.println(e);
        }  
    }
    /**
     * get list current quantity in book table
     * @return list current quantity of copy
     */
    public List getListCurrentQuantity(){
        Connection con = MySqlConnection.getConnection();
        String query = "select current_quantity from book";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            while(rs.next()){
                String current_quantity = rs.getString("current_quantity");
                ls.add(current_quantity); 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ls;
    }
    /**
     * Update book by id
     * @param book is object need to update
     * @param id is position of book object
     */
    public void updateBook(Book book, String id){
        Connection con = MySqlConnection.getConnection();
        PreparedStatement stat;
        String query = "update book set name=?, author=?, publishing_company=?, publishing_date=?, ISBN=?,  total_quantity= ?, current_quantity=? where id = ?";
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, book.getName());
            stat.setString(2, book.getAuthor());
            stat.setString(3, book.getPublishingCompany());
            stat.setString(4, book.getPublishingDate());
            stat.setString(5, book.getISBN());
            stat.setInt(6, book.getTotalQuantity());
            stat.setInt(7, book.getCurrentQuantity());
            stat.setString(8, id);
            stat.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * update book 
     * @param book is object need to update
     */
    public void updateBook(Book book){
        Connection con = MySqlConnection.getConnection();
        String query = "UPDATE `tkxdpm`.`book` SET "
                + "`name`=?, "
                + "`author`=?, "
                + "`publishing_company`=?, "
                + "`publishing_date`=?, "
                + "`ISBN`=?, "
                + "`total_quantity`=?, "
                + "`current_quantity`=? "
                + "WHERE `id`=?;";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            
            stat.setString(1, book.getName());
            stat.setString(2, book.getAuthor());
            stat.setString(3,book.getPublishingCompany());
            stat.setString(4, book.getPublishingDate());
            stat.setString(5, book.getISBN());
            stat.setInt(6, book.getTotalQuantity());
            stat.setInt(7, book.getCurrentQuantity());
            stat.setString(8, book.getId());
            stat.execute();
        } catch (Exception e) {
            System.out.println(e);
        }  
        
    }
    /**
     * Get list id book in book table
     * @return list id of book in book table
     */
    public List getListId(){
        Connection con = MySqlConnection.getConnection();
        PreparedStatement stat;
        String query = "select id from book";
        
        try {
            stat = con.prepareStatement(query);
            rs = stat.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                ls.add(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ls;
    }
    /**
     * Get book by id book
     * @param idBook is position of book
     * @return 
     */
     public static Book getBook(String idBook){
        Connection con = MySqlConnection.getConnection();
        String query = "SELECT * from tkxdpm.book where id = ? ";
                
        PreparedStatement stat;
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            stat = con.prepareStatement(query);
            stat.setString(1, idBook);
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
        return changeDataToBook(data.get(0));
    }
     /**
      * Change data to book
      * @param vector is object of ArrayList
      * @return new book object
      */
    public static Book changeDataToBook(ArrayList<Object> vector){
        String id = vector.get(0).toString();
        String name = vector.get(1).toString();
        String author = vector.get(2).toString();
        String publishingCompany = vector.get(3).toString();
        String publishingDate = vector.get(4).toString();
        String ISBN = vector.get(5).toString();
        int totalQuantity =(int)vector.get(6);
        int currentQuangtity = (int) vector.get(7);
        return new Book(id, name, author, publishingCompany, publishingDate, ISBN, totalQuantity, currentQuangtity);
        
    }
    /**
     * Check book exists?
     * @param id is position of book need to check
     * @return true if book exists else false
     */
    public boolean checkBookExists(String id){
        List ls = getListId();
        for(int i = 0; i < ls.size();i ++){
            if(id.equalsIgnoreCase(ls.get(i).toString())){
                return true;
            }
        }
        return false;
    }
}
