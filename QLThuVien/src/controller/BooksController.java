/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Copy;

/**
 *
 * @author sanglv
 */
public class BooksController {
    Book book = new Book();
    Copy copy = new Copy();
    /**
     * add a new copy, then save to database
     * @param copy is subject of copy
     */
   public void addCopy(Copy copy){
       copy.addCopy(copy);
   } 
   /**
    * search book with default mode - search book by name of book
    * @param book is subject of Book, the callback for info book, or null
    * @return book which searched, or null
    */
   public Book searchBookDefault(Book book){
       return book;
   }
   /**
    * search book with advance book mode - search book by name with author, type selection
    * @param book is subject of Book, the callback for info book, or null
    * @return book which searched, or null
    */
   public Book searchBookAdvance(Book book){
       return book;
   }
   /**
    * add a new book, then save to database
    * @param book is subject of book
    */
   public void addBook(Book book){
      book.addBook(book);
      
   }
   /**
    * update book by id
    * @param book is object of Book
    * @param id is id of object Book
    */
   public void updateBook(Book book, String id){
       book.updateBook(book, id);
   }
   /**
    * delete a book out from list
    * @param idCopy is id copy, with this id you can delete copy
    */
   public void deleteCopy(String idCopy){
       copy.deleteCopy(idCopy);
   }
   /**
    * update copy by id
    * @param copy is object to update
    * @param id to know position of copy 
    */
   public void updateCopy(Copy copy, String id){
       copy.updateCopy(copy, id);
   }
   /**
    * get list id of book in copy table
    * @return list id book in copy table
    */
      public List getListIdBookFromCopy(){
       return copy.getListIdBookFromCopy();
   }
      /**
       * Check book if book exists
       * @param id check book exist by id
       * @return true if book exists else false
       */
   public boolean checkBookExists(String id){
       return book.checkBookExists(id);
   }
   /**
    * This method to check book if exist?
    * @param id check copy exist by id
    * @return true if copy exists else false
    */
   public boolean checkCopyExists(String id){
       return copy.checkCopyExists(id);
   }
   /**
    * decrease current quantity of copy 
    * @param number is quantity need to decrease
    * @param idBook is id of book need to decrease 
    */
   public void decreaseTotalQuantity(int number, String idBook){
       Book book = Book.getBook(idBook);
       book.decreaseCurrentQuantity(number);
   }
   /**
    * increase current quantity of copy
    * @param number is quantity need to increase
    * @param idBook is id of book need to increase
    */
   public void increaseTotalQuantity(int number, String idBook){
       Book book = Book.getBook(idBook);
       book.increaseCurrentQuantity(number);
   }
   /**
    * get list id in book table
    * @return list id in book table
    */
    public List getListId(){
       return book.getListId();
    }
    /**
     * 
     * @param id is position need to get book
     * @return book by id
     */
    public ArrayList<Book> getBookFromId(String id){
        return book.getBookFromId(id);
    }
    /**
     * get list id copy in copy table
     * @return list id of copy in copy table
     */
    public List getListIdCopy(){
        return copy.getListIdCopy();
    }
    /**
     * 
     * @param id is position need to get book
     * @return copy by id
     */
    public ArrayList<Copy> getCopyFromId(String id){
       return copy.getCopyFromId(id);
    }
}
