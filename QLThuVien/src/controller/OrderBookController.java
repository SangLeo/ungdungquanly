package controller;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;
import utility.Date;

/**
 *
 * @author Quang
 */
public class OrderBookController {
    /**
     * cancel an order book
     * @param item 
     * 
     */
    public void cancelOrderBookItem(int idItem , String idBook,  int idBorrower){
        OrderBookItem item = new OrderBookItem();
        item.deleteOrderItem(idItem);
        Book book = Book.getBook(idBook);
        book.increaseCurrentQuantity(1);
    }
    
    /**
     * order a Book
     * @param book 
     */
    public void orderBook(Book book , BorrowerInfo borrower){
           if (book.getCurrentQuantity()>0)
               if (borrower.getStatus() == BorrowerStatus.activeCard){
                   OrderBook order = new OrderBook();
                   order = order.getOrderingOrder(borrower.getId());
                   if ( getQuantity(order.getIdBorrower())<3 ){
                       if ( !order.checkDuplicateItem(order.getId(), book.getId())){
                            OrderBookItem item = new OrderBookItem(order.getId(), book.getId(),Date.getDate());
                            item.addOrderItem(item);
                            book.decreaseCurrentQuantity(1);
                            int ret = JOptionPane.showConfirmDialog(null, "Đặt sách thành công", "THÔNG BÁO" , JOptionPane.YES_NO_OPTION); 
                       }
                       else {
                           int ret = JOptionPane.showConfirmDialog(null, "Bạn đã đặt sách này", "THÔNG BÁO" , JOptionPane.YES_NO_OPTION); 
                       }      
                   }
                   else {
                       int ret = JOptionPane.showConfirmDialog(null, "Danh sách đặt của bạn đã đầy", "THÔNG BÁO" , JOptionPane.YES_NO_OPTION); 
                   
                   }       
               } 
               else {
                   int ret = JOptionPane.showConfirmDialog(null, "Bạn chưa kích hoạt thẻ hoặc thẻ của bạn đã bị vô hiệu hóa", "THÔNG BÁO" , JOptionPane.YES_NO_OPTION); 
               }
           else {
           
               int ret = JOptionPane.showConfirmDialog(null, "Sách này đã hết", "THÔNG BÁO" , JOptionPane.YES_NO_OPTION); 
           }
    }
    
    /**
     * check an order and set status appropriate to it , status include full, notfull , incomplete , complete
     * @param order
     */
    public void updateStatusOrder(OrderBook order){
    
    }
    
    /**
     * get all order book item of a borrower
     * @param borrower 
     * @return an ArrayList of OrderBookItem
     */
    public ArrayList<OrderBookItem> getAllOrderBookItem(BorrowerInfo borrower){
        return null ;
    }
    
   
    public long getQuantity(int idBorrower){
        OrderBook order = new OrderBook();
        return order.getQuantity(idBorrower);
    }
}

