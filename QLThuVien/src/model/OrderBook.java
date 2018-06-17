/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.OrderBookDao;
import java.util.ArrayList;

/**
 *
 * @author HUYQUANGPTN
 */
public class OrderBook {
    private int id;
    private int idBorrower;
    private String date;
    private int deposits;
    private OrderStatus status;
    
    OrderBookDao dao = new OrderBookDao();
    public OrderBook(){}
    

    public OrderBook( int id, int idBorrower, String date, int deposits, OrderStatus status) {
        this.id = id;
        this.idBorrower = idBorrower;
        this.date = date;
        this.deposits = deposits;
        this.status = status;       
    }
    
    
    
    public OrderBook getOrderingOrder(int idBorrower ){
        if(dao.getOrderingOrder(idBorrower)==null){
            OrderBook order = new OrderBook(generateId(), idBorrower, null   , 0, OrderStatus.ordering);
            order.addOrder(order);
            return getOrderingOrder(idBorrower);
        }
        return dao.getOrderingOrder(idBorrower);
    }
    public void addOrder(OrderBook order){
        dao.addOrder(order);
    }
    
    public int generateId(){
        
        return 0;
    }
    
    public void updateOrder(){
    
    }
    public long getQuantity(int idBorrower){
        
        return dao.getQuantity(idBorrower);
    }
  
    public boolean checkDuplicateItem(int idOrder , String idBook){
        return dao.checkDuplicateItem(idOrder , idBook);
        
    }
    
   
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
     * @return the idBorrower
     */
    public int getIdBorrower() {
        return idBorrower;
    }

    /**
     * @param idBorrower the idBorrower to set
     */
    public void setIdBorrower(int idBorrower) {
        this.idBorrower = idBorrower;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the deposits
     */
    public int getDeposits() {
        return deposits;
    }

    /**
     * @param deposits the deposits to set
     */
    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

