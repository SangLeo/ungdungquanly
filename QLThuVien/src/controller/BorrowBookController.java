/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.CopyDao;
import dao.OrderBookDao;
import dao.OrderBookItemDao;
import java.awt.List;
import java.util.ArrayList;
import model.*;
import utility.Date;

/**
 *
 * @author HUYQUANGPTN
 */
public class BorrowBookController {
    OrderBookDao orderBookDao = new OrderBookDao();
    OrderBookItemDao orderBookItemDao = new OrderBookItemDao();
    CopyDao copyDao = new CopyDao();
    /**
     * get order book by id card of borrower
     * @param idCard id card of borrower
     * @return OrderBook object query from database
     */
    public ArrayList<OrderBook> getOrderByCardNumber(int idCard,OrderStatus orderStatus){
        return orderBookDao.getOrderBookByCardNumber(idCard,orderStatus); 
    }
       
    /**
     * confirm order to status borrowing
     * @param order OrderBook object be updated
     */
    public String confirmOrderToBorrowed(OrderBook order){
        if(orderBookDao.checkAllItemBorrowed(order)){
            order.setStatus(OrderStatus.borrowing);
            orderBookDao.updateOrderBook(order);
            return "Xác nhận order cho mượn sách thành công";
        }else 
            return "Tất cả item trong order chưa được cho mượn hết";      
    }
    
    public String confirmOrderToComplete(OrderBook order){
        if(orderBookDao.checkAllItemReturn(order)){
            order.setStatus(OrderStatus.complete);
            orderBookDao.updateOrderBook(order);
            return "Xác nhận hoàn thành order thành công";
        }else 
            return "Tất cả item chưa được hoàn trả hết";      
    }
    
    /**
     * search order by any keyword
     * @param keyword for search
     * @return order related keyword
     */
    public OrderBook searchOrderDefault(String keyword){
        
        return new OrderBook();
    }
    
    /**
     * search order by advance form
     * @param idBorrower id of borrower
     * @param date day of borrow book
     * @param idBook id of book be borrowed
     * @param idCopy id of copy be borrowed
     * @return  order
     */
    public OrderBook searchOrderAdvance(int idBorrower,String date,String idBook,String idCopy){
        // search advance order;
        return new OrderBook();
    }
    
    /**
     * update OrderBook 
     * @param order will be update
     */
//    public void updateOrderBook(OrderBook order){
//        orderBookDao.updateOrderBook(order);
//    }
    
    public ArrayList<OrderBook> getAllOrderBook(OrderStatus orderStatus){
        return orderBookDao.getAllOrderBook(orderStatus);
    }
    /**
     * get all item in order
     * @param order OrderBook object be got item
     * @return list item of OrderBook
     */
    public ArrayList<OrderBookItem> getAllItemOfOrder(OrderBook order){
            // get item oforrder
            return orderBookItemDao.getAllItemOfOrder(order);
    }
    
    public String confirmBorrowItem(OrderBookItem item, String idCopy){
        Copy copy = copyDao.getCopyById(idCopy);
        if(copy == null){
            return "Mã copy không tồn tại!!";
        }else{
            if(copy.getStatus().equals("available")){
                item.setIdCopy(idCopy);
                item.setDateOrder(Date.getDate());
                item.setStatus(ItemStatus.borrowed);
                item.updateOrderItem(item);
                Book book = new Book(item.getIdBook());
                book.decreaseCurrentQuantity(1);
                copy.setStatus("not available");
                copy.updateCopy(copy, copy.getId());
                return "Xác nhận cho mượn item thành công";
            }else{
                return "Bản copy đang ở trạng thái không thể cho mượn";
            }
        }
    }
    
    public void confirmReturnItem(OrderBookItem item){
        Copy copy = copyDao.getCopyById(item.getIdCopy()); 
        item.setStatus(ItemStatus.returned);
        item.setDateReturn(Date.getDate());
        item.updateOrderItem(item);
        Book book = new Book(item.getIdBook());
        book.increaseCurrentQuantity(1);
        copy.setStatus("available");
        copy.updateCopy(copy,copy.getId());
    }
    
    
}
