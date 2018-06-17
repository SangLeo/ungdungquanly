/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CopyDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanglv
 */
public class Copy {
    private String id;
    private String idBook;
    private String category;
    private int price;
    private String status;
    CopyDao dao = new CopyDao();
    //constructor copy
    public Copy(){
    }
    public Copy(String id,String idBook, String catalog, int price, String status){
        this.id = id;
        this.idBook = idBook;
        this.category = catalog;
        this.price = price;
        this.status = status;
    }
    public void addCopy(Copy copy){
        dao.addCopy(copy);
    }
    public void updateCopy(Copy copy, String id){
        dao.updateCopy(copy, id);
    }
    public void deleteCopy(String idCopy){
        dao.deleteCopy(idCopy);
    }
    public List getListIdBookFromCopy(){
        return dao.getListIdBookFromCopy();
    }
    public boolean checkCopyExists(String id){
        return dao.checkCopyExists(id);
    }
    public List getListIdCopy(){
        return dao.getListIdCopy();
    }
    public ArrayList<Copy> getCopyFromId(String id){
        return dao.getCopyFromId(id);
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
