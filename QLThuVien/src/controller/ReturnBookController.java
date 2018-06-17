/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.OrderBookDao;
import dao.OrderBookItemDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.*;
/**
 *
 * @author HUYQUANGPTN
 */
public class ReturnBookController {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    OrderBookItemDao itemDao = new OrderBookItemDao();
    OrderBookDao orderDao = new OrderBookDao();
    /**
     * update date return item
     * @param item will be updated
     */
    public void updateReturnDateItem(OrderBookItem item){
        Date date = new Date();
        item.setDateReturn(dateFormat.format(date));
        itemDao.updateItem(item);
    }
    
    /**
     * update status of item in order to returned
     * @param item will be updated 
     */
    public void confirmReturnBookItem(OrderBookItem item){
        item.setStatus(ItemStatus.returned);
        itemDao.updateItem(item);
    }
    
    /**
     * confirm all item of order is returned
     * @param order will be confirmed
     */
    public void confirmReturnAllBook(OrderBook order){
        ArrayList<OrderBookItem> itemList = itemDao.getAllItemOfOrder(order);
        for(OrderBookItem item : itemList){
            if(item.getStatus() != ItemStatus.returned){
                item.setStatus(ItemStatus.returned);
                itemDao.updateItem(item);
            }
        }
        order.setStatus(OrderStatus.complete);
        orderDao.updateOrderBook(order);
    }
}
