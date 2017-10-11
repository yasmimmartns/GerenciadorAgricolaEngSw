/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LARISSA
 */
public class AgricultorTest {
    
    public AgricultorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    Agricultor teste = new Agricultor();
    
    @Test
    public void partIdAgricultor1 () {
        assertEquals(true, teste.validaIdAgricultor(2254654));
    } 
        
    @Test
    public void partIdAgricultor2 () {
        assertEquals(false, teste.validaIdAgricultor(2147483647));
    }
        
    @Test
    public void partIdAgricultor3 () {
        assertEquals(false, teste.validaIdAgricultor(-73));
    }
    
    @Test
    public void analiseIdAgricultor1 () {
        assertEquals(false, teste.validaIdAgricultor(0));
    }
    
    @Test
    public void analiseIdAgricultor2 () {
        assertEquals(false, teste.validaIdAgricultor(2147483646));
    }
}
