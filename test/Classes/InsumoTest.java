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
public class InsumoTest {
    
    public InsumoTest() {
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

    Insumo teste = new Insumo();
    
    @Test
    public void partIdInsumo1 () {
        assertEquals(true, teste.validaIdInsumo(22546));
    }
       
    @Test
    public void partIdInsumo2 () {
        assertEquals(false, teste.validaIdInsumo(2147483647));
    }
    
    @Test
    public void partIdInsumo3 () {
        assertEquals(false, teste.validaIdInsumo(-45));
    }
    
    @Test
    public void analiseIdInsumo1 () {
        assertEquals(false, teste.validaIdInsumo(0));
    }
    
    @Test
    public void analiseIdInsumo2 () {
        assertEquals(false, teste.validaIdInsumo(2147483646));
    }
    
    @Test
    public void partTipoInsumo1 () {
        assertEquals(true, teste.validaTipoInsumo("Fertilizante"));
    }
    
    @Test
    public void partTipoInsumo2 () {
        assertEquals(false, teste.validaTipoInsumo(null));
    }
    
    @Test
    public void partTipoInsumo3 () {
        assertEquals(false, teste.validaTipoInsumo("Fertilizantesemente aduboveneno"));
    }
        
    @Test
    public void analiseTipoInsumo1 () {
        assertEquals(false, teste.validaTipoInsumo("Fertilizantesementes"));
    }
    
    @Test
    public void analiseTipoInsumo2 () {
        assertEquals(false, teste.validaTipoInsumo(""));
    }
    
    @Test
    public void partCategoria1 () {
        assertEquals(true, teste.validaCategoria("Adubo foliar"));
    }
    
    @Test
    public void partCategoria2 () {
        assertEquals(false, teste.validaCategoria(null));
    }
    
    @Test
    public void partCategoria3 () {
        assertEquals(false, teste.validaCategoria("Legumes foliarinseticida pesticida"));
    }
        
    @Test
    public void analiseCategoria1 () {
        assertEquals(false, teste.validaCategoria("Legumesfoliarinsetic"));
    }
    
    @Test
    public void analiseCategoria2 () {
        assertEquals(false, teste.validaCategoria(""));
    }
    
    @Test
    public void partEspecificacoes1 () {
        assertEquals(true, teste.validaEspecificacoes("Utilizar com o tempo umido"));
    }
    
    @Test
    public void partEspecificacoes2 () {
        assertEquals(false, teste.validaEspecificacoes(null));
    }
    
    @Test
    public void partEspecificacoes3 () {
        assertEquals(false, teste.validaEspecificacoes("Nao utilizar com tempo umido chuvas secas deixar longe dos animais"));
    }
    
    @Test
    public void analiseEspecificacoes1 () {
        assertEquals(false, teste.validaEspecificacoes(""));
    }
    
    @Test
    public void analiseEspecificacoes2 () {
        assertEquals(false, teste.validaEspecificacoes("Naoutilizarcomtempoumidochuvassecasdeixarlongedose"));
    }
    
    @Test
    public void partQuantidadeInsumo1 () {
        assertEquals(true, teste.validaQuantidadeInsumo(2254));
    } 
        
    @Test
    public void partQuantidadeInsumo2 () {
        assertEquals(false, teste.validaQuantidadeInsumo(2147483647));
    }
        
    @Test
    public void partQuantidadeInsumo3 () {
        assertEquals(false, teste.validaQuantidadeInsumo(-64));
    }
    
    @Test
    public void analiseQuantidadeInsumo1 () {
        assertEquals(false, teste.validaQuantidadeInsumo(0));
    }
    
    @Test
    public void analiseQuantidadeInsumo2 () {
        assertEquals(false, teste.validaQuantidadeInsumo(2147483646));
    }
    
    @Test
    public void partMarca1 () {
        assertEquals(true, teste.validaMarca("Roundup"));
    }
    
    @Test
    public void partMarca2 () {
        assertEquals(false, teste.validaMarca(null));
    }
    
    @Test
    public void partMarca3 () {
        assertEquals(false, teste.validaMarca("Roundup cupofrix endosulfan vesper baygon"));
    }
        
    @Test
    public void analiseMarca1 () {
        assertEquals(false, teste.validaMarca("Roundupcupofrixendos"));
    }
    
    @Test
    public void analiseMarca2 () {
        assertEquals(false, teste.validaMarca(""));
    }
    
    @Test
    public void partPreco1 () {
        assertEquals(true, teste.validaPreco((float)53.20));
    }
        
    @Test
    public void partPreco2 () {
        assertEquals(false, teste.validaPreco((float)33333333299.222));
    }
         
    @Test
    public void partPreco3 () {
        assertEquals(false, teste.validaPreco((float)-36.00));
    }
    
    @Test
    public void analisePreco1 () {
        assertEquals(false, teste.validaPreco(2147483646));
    }
    
    @Test
    public void analisePreco2 () {
        assertEquals(false, teste.validaPreco(0));
    }
}
