/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BorrowerDao;
import dao.LibrarianDao;

/**
 *
 * @author HUYQUANGPTN
 */
public class LibrarianInfo extends UserInfo{

    public LibrarianInfo(int id, String name, String birthday, String sex, String address, String email, String phone, String username, String password) {
        super(id, name, birthday, sex, address, email, phone, username, password);
    }
    
    public LibrarianInfo() {
        super();
    }
    
    public static LibrarianInfo login(String username , String password){
        return LibrarianDao.login(username ,password);
    }
}