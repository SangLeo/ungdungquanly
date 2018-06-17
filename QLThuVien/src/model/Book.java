package model;

import dao.BookDao;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sanglv, huyquang
 */
public class Book {
    private String id;
    private String name;
    private String author;
    private String publishingCompany;
    private String publishingDate;
    private int totalQuantity;
    private String ISBN;
    private int currentQuantity;
    BookDao dao = new BookDao();
    public Book(){
    }
    public Book(String id, String name, String author, String publishingCompany, String publishingDate,String ISBN, int totalQuantity,int currentQuantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.publishingDate = publishingDate;
        this.totalQuantity = totalQuantity;
        this.ISBN = ISBN;
        this.currentQuantity = currentQuantity;
        
    }
    public Book(String id){
        this.id = id ;
    }
    // dùng khi search book, các tham số đầu vào là các tham số khi search
    public static  Book getBook(String idBook){
    
        return BookDao.getBook(idBook);
    }
    /**
     * add a book to database
     * @param book is a subject of book
     */
    public void addBook(Book book){
        dao.addBook(book);
    }
    /**
     * update book to database
     */
    public void updateBook(Book book, String id){
        dao.updateBook(book, id);
    }
   
    public void decreaseCurrentQuantity(int number){
        Book book = getBook(this.getId());
        book.setCurrentQuantity(book.getCurrentQuantity()-number);
        dao.updateBook(book);
    }
    
    public void increaseCurrentQuantity(int number){
        Book book = getBook(this.getId());
        book.setCurrentQuantity(book.getCurrentQuantity()+number);
        dao.updateBook(book);
    }
    
    public List getListId(){
        return dao.getListId();
    }
    public ArrayList<Book> getBookFromId(String id){
        return dao.getBookFromId(id);
    }
    /**
     * the callback for BookExists
     * @return true if exist book else false
     */
    public boolean checkBookExists(String id){
        return dao.checkBookExists(id);
    }
    /**
     * increase quantity of book
     */
    public void increaseQuantity(){
    
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(int TotalQuantity) {
        this.totalQuantity = TotalQuantity;
    }
    public int getCurrentQuantity() {
        return currentQuantity;
    }
    public void setCurrentQuantity(int CurrentQuantity) {
        this.currentQuantity = CurrentQuantity;
    }
    public String getId() {
        return id;
    }
    public void setIdBook(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublishingCompany() {
        return publishingCompany;
    }
    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }
    public String getPublishingDate() {
        return publishingDate;
    }
    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void getStatus(){
    
    }
}
