/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.OrderBookItemDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUYQUANGPTN
 */
public class OrderBookItem {
    private int id;
    private int idOrder;
    private String idBook;
    private String dateOrder;
    private ItemStatus status;
    private String idCopy;
    private String dateReturn;
    OrderBookItemDao dao = new OrderBookItemDao();

    public OrderBookItem() {
    }

    
    public OrderBookItem(int id, int idOrder, String idBook, String dateOrder, ItemStatus status, String idCopy, String dateReturn) {
        this.id = id;
        this.idOrder = idOrder;
        this.idBook = idBook;
        this.dateOrder = dateOrder;
        this.status = status;
        this.idCopy = idCopy;
        this.dateReturn = dateReturn;
    }
    
    

    public OrderBookItem( int idOrder, String idBook, String dateOrder ) {
        this.idOrder = idOrder;
        this.idBook = idBook;
        this.dateOrder = dateOrder;
        this.status = ItemStatus.ordered;
        this.idCopy= null;
        this.dateReturn = null ;
    }

    
    public void addOrderItem(OrderBookItem item){
        
        dao.addItem(item);
                    
            
        
    }
    
    public void deleteOrderItem(int id){
        dao.deleteItem(id);
        
    }
    
    public void updateOrderItem(OrderBookItem item){
        dao.updateItem(item);
    }
    
    public ArrayList<OrderBookItem> getAllOrderItem(int idBorrower){
        return dao.getAllOrderBookItem(idBorrower);
    }
    
    //public void get
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idBook
     */
    public String getIdBook() {
        return idBook;
    }

    /**
     * @param idBook the idBook to set
     */
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    /**
     * @return the idCopy
     */
    public String getIdCopy() {
        return idCopy;
    }

    /**
     * @param idCopy the idCopy to set
     */
    public void setIdCopy(String idCopy) {
        this.idCopy = idCopy;
    }

    /**
     * @return the dateOrder
     */
    public String getDateOrder() {
        return dateOrder;
    }

    /**
     * @param dateOrder the dateOrder to set
     */
    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * @return the dateReturn
     */
    public String getDateReturn() {
        return dateReturn;
    }

    /**
     * @param dateReturn the dateReturn to set
     */
    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    /**
     * @return the status
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /**
     * @return the idOrder
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * @param idOrder the idOrder to set
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}

