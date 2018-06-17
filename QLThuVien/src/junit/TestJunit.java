/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Quang
 */
public class TestJunit {
    @Test
    public void testSetup(){
        String str ="hello";
        assertEquals("hello",str);
    }
}
