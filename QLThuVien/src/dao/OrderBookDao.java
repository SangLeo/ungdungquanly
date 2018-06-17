/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemStatus;
import model.OrderBook;
import model.OrderBookItem;
import model.OrderStatus;
import utility.MySqlConnection;

/**
 *
 * @author Quang
 */
public class OrderBookDao {
    Connection con = MySqlConnection.getConnection();
    
    // lấy order mà độc giả đang đặt sách , nếu không có thì tạo order mới cho độc giả đặt sách
    public OrderBook getOrderingOrder(int idBorrower){
        
        String query = "select * from order_book where id_borrower = ? and status = ?";
        PreparedStatement stat;
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            
            stat = con.prepareStatement(query);
            stat.setInt(1, idBorrower);
            stat.setString(2, OrderStatus.ordering.toString());
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
       
        if (data.size()>0) {

            int id = (int)data.get(0).get(0) ;           
            String date = (String)data.get(0).get(2);
            int deposits = (int)data.get(0).get(3);
            
            return new OrderBook(id, idBorrower, date, deposits, OrderStatus.ordering);
        }
        return null;
    }
    
    // lấy số lượng item trong một order qua id

    public long getQuantity(int idBorrower ){

        String query =  "select count(*)\n" +
                        "from tkxdpm.orderbook_item oi, tkxdpm.order_book ob\n" +
                        "where oi.id_order = ob.id and ob.id_borrower= ? \n" +
                        "group by oi.id_order";
        PreparedStatement stat;
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            
            stat = con.prepareStatement(query);

            stat.setInt(1, idBorrower);
            
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
            if(data.size()>0){
                long quantity = (long)data.get(0).get(0) ; 
                return quantity;
            }
            else return 0;
    }
    
    public  ArrayList<OrderBook> getOrderBookByCardNumber(int idCard,OrderStatus orderStatus){
        ArrayList<OrderBook> orderList = new ArrayList<>();
        String query = "select * from order_book,borrower,card where order_book.id_borrower = borrower.id and card.id_user = borrower.id and card.id_card = ? and order_book.status = ?";

        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setInt(1, idCard);
           stm.setString(2 , orderStatus.name());
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               orderList.add(new OrderBook(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),OrderStatus.valueOf(rs.getString(5))));
           }
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return orderList;
    }
    
    public void updateOrderBook(OrderBook order){
        String query = "update order_book set date  = ?, deposits  = ?, status = ? where order_book.id = ?";

        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, order.getDate());
           stm.setInt(2,order.getDeposits());
           stm.setString(3, order.getStatus().name());
           stm.setInt(4, order.getId());
           stm.execute();
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
    // kiem tra tat ca cac item trong order da them id copy hay chua
    // neu roi tra ve true neu chua tra ve false
    public boolean checkItemOfOrder(OrderBook order){
        String query = "select * from orderbook_item where id_order = ? and id_copy is null";
        boolean flag = true;
        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setInt(1, order.getId());
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
               flag = false;
           }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return flag;
    }
    
    public boolean checkAllItemReturn(OrderBook order){
        ArrayList<OrderBookItem> itemList = new ArrayList<>();
        String query = "select * from orderbook_item where id_order = ? and status != \"cancel\" ";
        boolean flag = true;
        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setInt(1, order.getId());
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
               itemList.add(new OrderBookItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), ItemStatus.valueOf(rs.getString(5)), rs.getString(6), rs.getString(7)));
           }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        for(OrderBookItem item : itemList){
            if(item.getStatus() != ItemStatus.returned){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    public boolean checkAllItemBorrowed(OrderBook order){
        ArrayList<OrderBookItem> itemList = new ArrayList<>();
        String query = "select * from orderbook_item where id_order = ? and status != \"cancel\" ";
        boolean flag = true;
        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setInt(1, order.getId());
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
               itemList.add(new OrderBookItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), ItemStatus.valueOf(rs.getString(5)), rs.getString(6), rs.getString(7)));
           }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        for(OrderBookItem item : itemList){
            if(item.getStatus() != ItemStatus.borrowed){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    public ArrayList<OrderBook> getAllOrderBook(OrderStatus orderStatus){
        ArrayList<OrderBook> orderList = new ArrayList<>();
        String query = "select * from order_book where status = ?";

        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, orderStatus.name());
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               orderList.add(new OrderBook(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),OrderStatus.valueOf(rs.getString(5))));
           }
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return orderList;
    }
   
    public static void main(String[] args) {
        OrderBookDao test = new OrderBookDao();
        System.out.println(test.checkAllItemReturn(new OrderBook(6, 0, "asc", 0, OrderStatus.ordering))); 
    }
  
    // id order tự sinh không cần thêm id
    public void addOrder(OrderBook order) {
        String query = "INSERT INTO `tkxdpm`.`order_book` ( `id_borrower`, `date`, `deposits`, `status`) VALUES ( ?, ?, ?, ?);";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            stat.setInt(1, order.getIdBorrower());
            stat.setString(2, order.getDate());
            stat.setInt(3, order.getDeposits());
            stat.setString(4, order.getStatus().toString());
            
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderBookItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkDuplicateItem(int idOrder , String idBook){
        String query = "select * from tkxdpm.orderbook_item where id_order = ? and id_book = ? and status = ?";
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            PreparedStatement stat = con.prepareStatement(query);
            stat.setInt(1, idOrder);
            stat.setString(2, idBook);
            stat.setString(3, ItemStatus.ordered.toString());
            ResultSet rs = stat.executeQuery();
           
            int columnCount = rs.getMetaData().getColumnCount();
            
            while (rs.next()) {
                return true;
            }
           
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return false;
        
    }
}


