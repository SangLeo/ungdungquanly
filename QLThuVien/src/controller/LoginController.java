/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BorrowerInfo;
import model.LibrarianInfo;

/**
 *
 * @author Quang
 */
public class LoginController {
    
    
    public BorrowerInfo loginAsBorrower(String username , String password ){
        
        return BorrowerInfo.login(username, password);
        
    }
    public LibrarianInfo loginAsLibrarian(String username , String password ){
        
        return LibrarianInfo.login(username, password);
        
    }
}
    
