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
public class OrderBookItemDao {
    Connection con = MySqlConnection.getConnection();
    
    // không cần id , csdl tự sinh id
    public void addItem(OrderBookItem item) {
        String query = "INSERT INTO `tkxdpm`.`orderbook_item` (`id_order`, `id_book`, `date_order`, `status`, `id_copy`, `date_return`) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            stat.setInt(1, item.getIdOrder());
            stat.setString(2, item.getIdBook());
            stat.setString(3, item.getDateOrder());
            stat.setString(4, item.getStatus().toString());
            stat.setString(5, null);
            stat.setString(6, null);
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderBookItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void deleteItem(int id){
        Connection con = MySqlConnection.getConnection();
        String query = "delete from tkxdpm.orderbook_item  where orderbook_item.id = ? ";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            stat.setInt(1, id);
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderBookItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateItem(OrderBookItem item){
        Connection con = MySqlConnection.getConnection();
        String query = "update orderbook_item set "
                + "id_order = ? , id_book= ? , `date_order`=?, `status`=? , id_copy= ? , date_return = ?  WHERE `id`= ?;";
                
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(query);
            
            stat.setInt(1, item.getIdOrder());
            stat.setString(2, item.getIdBook());
            stat.setString(3, item.getDateOrder());
            stat.setString(4, item.getStatus().name());
            stat.setString(5, item.getIdCopy());
            stat.setString(6, item.getDateReturn());
            stat.setInt(7, item.getId());
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderBookItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public ArrayList<OrderBookItem> getAllOrderBookItem(int idBorrower){
        Connection con = MySqlConnection.getConnection();
        String query = "SELECT * FROM tkxdpm.orderbook_item oi , tkxdpm.order_book ob\n" +
                        "where ob.id = oi.id_order and ob.id_borrower = ?";
                
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
        ArrayList<OrderBookItem> list = new ArrayList<>();
        for (ArrayList<Object> vector : data){
            OrderBookItem item = changeDataToItem(vector);
            list.add(item);
        }
        return list;
    }
      
    public  void updateReturnDateItem(OrderBookItem item, String date){
        String query = "update orderbook_item set date_return = ? where id = ?";
         try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, date);
           stm.setInt(2, item.getId());
           stm.execute();
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
    
    public  void confirmReturnBookItem(OrderBookItem item){
        String query = "update orderbook_item set status  = ? where id = ?";

        try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, ItemStatus.returned.toString());
           stm.setInt(2, item.getId());
           stm.execute();
           stm.close();
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
    
    public ArrayList<OrderBookItem> getAllItemOfOrder(OrderBook order){
        ArrayList<OrderBookItem> itemList = new ArrayList<>();
        String query = "select * from orderbook_item where id_order = ?";
         try {
           PreparedStatement stm = con.prepareStatement(query);
           stm.setInt(1, order.getId());
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               itemList.add(new OrderBookItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), ItemStatus.valueOf(rs.getString(5)), rs.getString(6), rs.getString(7)));
           }
           stm.close();
           
        } catch (Exception e) {
            e.printStackTrace();   
        }
         return itemList;
    }
    public OrderBookItem getOrderBookItem(int id){
        String query = "select * from tkxdpm.orderbook_item where orderbook_item.id = ?";
        PreparedStatement stat;
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try {
            stat = con.prepareStatement(query);
            stat.setInt(1, id);
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
        
      
        return changeDataToItem(data.get(0));
    }
    
    public OrderBookItem changeDataToItem(ArrayList<Object> data){
        int id = (int) data.get(0);
        int idOrder = (int) data.get(1);
        String idBook = data.get(2).toString();
        String dateOrder = data.get(3).toString();
        ItemStatus status = ItemStatus.valueOf(data.get(4).toString());
        String idCopy = data.get(5).toString();
        String dateReturn = data.get(6).toString();
        return new OrderBookItem(id, idOrder   , idBook, dateOrder, status, idCopy, dateReturn);
    }
    public static void main(String[] args) {
        OrderBookItemDao test = new OrderBookItemDao();
        ArrayList<OrderBookItem> itemList = test.getAllItemOfOrder(new OrderBook(4, 0, "asc", 0, OrderStatus.ordering));
        for(OrderBookItem item : itemList){
            System.out.println(item.getId());
        }
    }
}

