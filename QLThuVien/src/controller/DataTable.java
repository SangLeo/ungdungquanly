/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.ItemStatus;
import model.OrderStatus;
import utility.MySqlConnection;
import view.BorrowerMenuInterface;

/**
 *
 * @author Quang
 */
public class DataTable {
    String tableBook_query = "select * from tkxdpm.book";
    String tableOrder_query = " SELECT oi.id, oi.id_book , oi.date_order , oi.status  \n" +
                                "FROM tkxdpm.orderbook_item oi, tkxdpm.order_book ob\n" +
                                " where ob.id_borrower= ? \n" +
                                " and oi.id_order = ob.id \n" +
                                " and ob.status = ? ";
    String tableBorrow_query ="SELECT oi.id, oi.id_book  , oi.status ,oi.id_copy , oi.date_return\n" +
                                "from tkxdpm.orderbook_item oi , tkxdpm.order_book ob\n" +
                                "where ob.id_borrower= ? \n" +
                                "and oi.id_order = ob.id \n" +
                                "and oi.status not like ? ";
    
    
    public void fillTableBook( JTable table  ) {
              
            try {
                Connection con = MySqlConnection.getConnection();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                PreparedStatement stat = con.prepareStatement(tableBook_query);
                ResultSet rs = stat.executeQuery();
                int n = model.getRowCount();
                for ( int i = 0 ; i< n ; i++)
                    model.removeRow(0);
                
                int columnCount = rs.getMetaData().getColumnCount();
                
                
                // take data
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);
                    model.addRow(vector);
                }
                table.setModel(model);
                
            }
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

   public void findBook( JTable table , String name ) {
            String findBook_query = "SELECT * FROM tkxdpm.book where book.name like \"%"+name+"%\"";  
            try {
                Connection con = MySqlConnection.getConnection();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                PreparedStatement stat = con.prepareStatement(findBook_query);
                ResultSet rs = stat.executeQuery();
               
                int n = model.getRowCount();
                for ( int i = 0 ; i< n ; i++)
                    model.removeRow(0);
                
                int columnCount = rs.getMetaData().getColumnCount();
                
                
                // take data
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);
                    model.addRow(vector);
                }
                table.setModel(model);
                
            }
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
    
   public void fillTableOrder(JTable table){
        try {
                Connection con = MySqlConnection.getConnection();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                PreparedStatement stat = con.prepareStatement(tableOrder_query);
                stat.setInt(1, BorrowerMenuInterface.idBorrower);
                stat.setString(2, OrderStatus.ordering.toString());
                ResultSet rs = stat.executeQuery();
                int n = model.getRowCount();
                for ( int i = 0 ; i< n ; i++)
                    model.removeRow(0);
                
                int columnCount = rs.getMetaData().getColumnCount();
                
                
                // take data
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);
                    model.addRow(vector);
                }
                table.setModel(model);
                
            }
		catch (Exception ex) {
			ex.printStackTrace();
		}	
        
   }
   
   public void fillTableBorrow(JTable table){
       try {
                Connection con = MySqlConnection.getConnection();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                PreparedStatement stat = con.prepareStatement(tableBorrow_query);
                stat.setInt(1, BorrowerMenuInterface.idBorrower);
                stat.setString(2, ItemStatus.ordered.toString());
                ResultSet rs = stat.executeQuery();
                int n = model.getRowCount();
                for ( int i = 0 ; i< n ; i++)
                    model.removeRow(0);
                
                int columnCount = rs.getMetaData().getColumnCount();
                
                
                // take data
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);
                    model.addRow(vector);
                }
                table.setModel(model);
                
            }
	catch (Exception ex) {
		ex.printStackTrace();
	}	
   
   }
}
