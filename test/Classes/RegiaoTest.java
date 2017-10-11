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
public class RegiaoTest {
    
    public RegiaoTest() {
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

    Regiao teste = new Regiao();
    
    @Test
    public void partIdRegiao1 () {
        assertEquals(true, teste.validaIdRegiao(22546));
    }
       
    @Test
    public void partIdRegiao2 () {
        assertEquals(false, teste.validaIdRegiao(2147483647));
    }
    
    @Test
    public void partIdRegiao3 () {
        assertEquals(false, teste.validaIdRegiao(-25));
    }
    
    @Test
    public void analiseIdRegiao1 () {
        assertEquals(false, teste.validaIdRegiao(0));
    }
    
    @Test
    public void analiseIdRegiao2 () {
        assertEquals(false, teste.validaIdRegiao(2147483646));
    }
    
    @Test
    public void partEndereco1 () {
        assertEquals(true, teste.validaEndereco("Rua dos Bandeirantes"));
    }
    
    @Test
    public void partEndereco2 () {
        assertEquals(false, teste.validaEndereco(null));
    }
    
    @Test
    public void partEndereco3 () {
        assertEquals(false, teste.validaEndereco("Rua dos bandeirantes primeiro de maio xavier da silva massud amim francisco beltrao "));
    }
    
    @Test
    public void analiseEndereco1 () {
        assertEquals(false, teste.validaEndereco("Ruadosbandeirantesprimeirodemaioxavierdasilvamassu"));
    }
    
    @Test
    public void analiseEndereco2 () {
        assertEquals(false, teste.validaEndereco(""));
    }
    
    @Test
    public void partArea1 () {
        assertEquals(true, teste.validaArea((float)12354.63));
    }
        
    @Test
    public void partArea2 () {
        assertEquals(false, teste.validaArea((float)33333333299.22));
    }
         
    @Test
    public void partArea3 () {
        assertEquals(false, teste.validaArea((float)-23.9));
    }
    
    @Test
    public void analiseArea1 () {
        assertEquals(false, teste.validaArea(0));
    }
    
    @Test
    public void analiseArea2 () {
        assertEquals(false, teste.validaArea((float)2147483646.00));
    }
}
