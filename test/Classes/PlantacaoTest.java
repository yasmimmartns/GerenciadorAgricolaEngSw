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
public class PlantacaoTest {
    
    public PlantacaoTest() {
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

    Plantacao teste = new Plantacao();
    
    @Test
    public void partIdPlantacao1 () {
        assertEquals(true, teste.validaIdPlantacao(1235));
    }
    
    @Test
    public void partIdPlantacao2 () {
        assertEquals(false, teste.validaIdPlantacao(2147483647));
    }
    
    @Test
    public void partIdPlantacao3 () {
        assertEquals(false, teste.validaIdPlantacao(-1235));
    }
    
    @Test
    public void analiseIdPlantacao1 () {
        assertEquals(false, teste.validaIdPlantacao(2147483646));
    }
    
    @Test
    public void analiseIdPlantacao2 () {
        assertEquals(false, teste.validaIdPlantacao(0));
    }
    
    @Test
    public void partTipoPlantacao1 () {
        assertEquals(true, teste.validaTipoPlantacao("Repolho"));
    }
    
    @Test
    public void partTipoPlantacao2 () {
        assertEquals(false, teste.validaTipoPlantacao(null));
    }
    
    @Test
    public void partTipoPlantacao3 () {
        assertEquals(false, teste.validaTipoPlantacao("repolhoalfacecenourabatatacebola"));
    }
    
    @Test
    public void partTipoPlantacao4 () {
        assertEquals(false, teste.validaTipoPlantacao("Alface!"));
    }
    
    @Test
    public void partTipoPlantacao5 () {
        assertEquals(false, teste.validaTipoPlantacao("Alface2"));
    }
    
    @Test
    public void analiseTipoPlantacao1 () {
        assertEquals(false, teste.validaTipoPlantacao("repolhoalfacecenoura"));
    }
    
    @Test
    public void analiseTipoPlantacao2 () {
        assertEquals(false, teste.validaTipoPlantacao(""));
    }
        
    @Test
    public void partQuantidadePlantacao1 () {
        assertEquals(true, teste.validaQuantidadePlantacao(1000));
    } 
        
    @Test
    public void partQuantidadePlantacao2 () {
        assertEquals(false, teste.validaQuantidadePlantacao(2147483647));
    }
        
    @Test
    public void partQuantidadePlantacao3 () {
        assertEquals(false, teste.validaQuantidadePlantacao(-23));
    }
    
    @Test
    public void analiseQuantidadePlantacao1 () {
        assertEquals(false, teste.validaQuantidadePlantacao(0));
    }
    
    @Test
    public void analiseQuantidadePlantacao2 () {
        assertEquals(false, teste.validaQuantidadePlantacao(2147483646));
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
