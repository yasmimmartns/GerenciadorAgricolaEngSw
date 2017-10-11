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
public class PessoaFisicaTest {
    
    public PessoaFisicaTest() {
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

    PessoaFisica teste = new PessoaFisica();
    
    @Test
    public void analiseNome1 () {
        assertEquals(false, teste.validaNome("Hi"));
    }
    
    @Test
    public void analiseNome2 () {
        assertEquals(false, teste.validaNome("abcdefghijklmopqrstuvwxyzabcdefghijklmnopqrstuvwxy"));
    }    
    
    @Test
    public void partSobrenome1 () {
        assertEquals(true, teste.validaSobrenome("Senno Teruya"));
    }
    
    @Test
    public void partSobrenome2 () {
        assertEquals(false, teste.validaSobrenome(null));
    }    
    
    @Test
    public void partSobrenome3 () {
        assertEquals(false, teste.validaSobrenome("Hidemisennoteruya matheusalbuquerquegoncalves larissasouzajacon"));
    }
    
    @Test
    public void partSobrenome4 () {
        assertEquals(false, teste.validaSobrenome("Senno!"));
    }
    
    @Test
    public void partSobrenome5 () {
        assertEquals(false, teste.validaSobrenome("Senno2"));
    }
    
    @Test
    public void analiseSobrenome1 () {
        assertEquals(false, teste.validaSobrenome("Sen"));
    }
    
    @Test
    public void analiseSobrenome2 () {
        assertEquals(false, teste.validaSobrenome("abcdefghijklmopqrstuvwxyzabcdefghijklmnopqrstuvwxy"));
    }
    
    @Test
    public void partSexo1 () {
        assertEquals(true, teste.validaSexo("m"));
    }
    
    @Test
    public void partSexo2 () {
        assertEquals(true, teste.validaSexo("f"));
    } 
        
    @Test
    public void partSexo3 () {
        assertEquals(false, teste.validaSexo("o"));
    }
        
    @Test
    public void partSexo4 () {
        assertEquals(false, teste.validaSexo(null));
    }
    
    @Test
    public void partCPF1 () {
        assertEquals(true, teste.validaCPF("123.456.789-12"));
    }
    
    @Test
    public void partCPF2 () {
        assertEquals(true, teste.validaCPF("123456789-12"));
    }
    
    @Test
    public void partCPF3 () {
        assertEquals(true, teste.validaCPF("12345678912"));
    }
        
    @Test
    public void partCPF4 () {
        assertEquals(false, teste.validaCPF("12345678"));
    }
        
    @Test
    public void partCPF5 () {
        assertEquals(false, teste.validaCPF("12345678912356789"));
    }
    
    @Test
    public void analiseCPF1 () {
        assertEquals(false, teste.validaCPF("1234567891"));
    }
    
    @Test
    public void analiseCPF2 () {
        assertEquals(false, teste.validaCPF("123456789123456"));
    }
}
