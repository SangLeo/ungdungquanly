/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Quang
 */
public class Date {
    public static String getDate(){
        java.util.Date myDate = Calendar.getInstance().getTime();
        String str = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
        return str;
    }
  
}
