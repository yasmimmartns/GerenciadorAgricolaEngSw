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
public class PessoaTest {
    
    public PessoaTest() {
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

    Pessoa teste = new Pessoa ();
    
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
    public void partLogradouro1 () {
        assertEquals(true, teste.validaLogradouro("apto 22rua primeiro de maio"));
    }
    
    @Test
    public void partLogradouro2 () {
        assertEquals(false, teste.validaLogradouro(null));
    }
    
    @Test
    public void partLogradouro3 () {
        assertEquals(false, teste.validaLogradouro("apto 22 rua primeiro de maio bairrocentro rua jardim bandeirantes ibipora"));
    }
    
    @Test
    public void analiseLogradouro1 () {
        assertEquals(false, teste.validaLogradouro(""));
    }
    
    @Test
    public void analiseLogradouro2 () {
        assertEquals(false, teste.validaLogradouro("abcdefghijklmopqrstuvwxyzabcdefghijklmnopqrstuvwxy"));
    }
    
    @Test
    public void partComplemento1 () {
        assertEquals(true, teste.validaComplemento("apto 22"));
    }
    
    @Test
    public void partComplemento2 () {
        assertEquals(false, teste.validaComplemento(null));
    }    
    
    @Test
    public void partComplemento3 () {
        assertEquals(false, teste.validaComplemento("fundos apartamento baixo alto"));
    }
    
    @Test
    public void analiseComplemento1 () {
        assertEquals(false, teste.validaComplemento(""));
    }
    
    @Test
    public void analiseComplemento2 () {
        assertEquals(false, teste.validaComplemento("abcdefghijklmopqrstu"));
    }
    
    @Test
    public void partNumero1 () {
        assertEquals(true, teste.validaNumero(1808));
    } 
        
    @Test
    public void partNumero2 () {
        assertEquals(false, teste.validaNumero(-5));
    }
        
    @Test
    public void partNumero3 () {
        assertEquals(false, teste.validaNumero(999999));
    }
    
    @Test
    public void analiseNumero1 () {
        assertEquals(false, teste.validaNumero(0));
    }
    
    @Test
    public void analiseNumero2 () {
        assertEquals(false, teste.validaNumero(99999));
    }
    
    @Test
    public void partBairro1 () {
        assertEquals(true, teste.validaBairro("Jd Santa Clara"));
    }
    
    @Test
    public void partBairro2 () {
        assertEquals(false, teste.validaBairro(null));
    }    
    
    @Test
    public void partBairro3 () {
        assertEquals(false, teste.validaBairro("bairro centro rua jardim bandeirantes ibipora brasil parana"));
    }
    
    @Test
    public void analiseBairro1 () {
        assertEquals(false, teste.validaBairro(""));
    } 
    
    @Test
    public void analiseBairro2 () {
        assertEquals(false, teste.validaBairro("abcdefghijklmopqrstuvwxyzabcdefghijklmnopqrstuvwxy"));
    } 
    
    @Test
    public void partCidade1 () {
        assertEquals(true, teste.validaCidade("Cornelio Procopio"));
    }
    
    @Test
    public void partCidade2 () {
        assertEquals(false, teste.validaCidade(null));
    }    
    
    @Test
    public void partCidade3 () {
        assertEquals(false, teste.validaCidade("Paranapiacaba sertanopolis pindamonhangaba"));
    }
    
    @Test
    public void partCidade4 () {
        assertEquals(false, teste.validaCidade("Ibipora!"));
    } 
    
    @Test
    public void partCidade5 () {
        assertEquals(false, teste.validaCidade("Ibipora2"));
    }
    
    @Test
    public void analiseCidade1 () {
        assertEquals(false, teste.validaCidade(""));
    }
    
    @Test
    public void analiseCidade2 () {
        assertEquals(false, teste.validaCidade("abcdefghijklmopqrstu"));
    }
    
    @Test
    public void partCEP1 () {
        assertEquals(true, teste.validaCEP("86.300-000"));
    } 
    
    @Test
    public void partCEP2 () {
        assertEquals(true, teste.validaCEP("86300-000"));
    }    
    
    @Test
    public void partCEP3 () {
        assertEquals(true, teste.validaCEP("86300000"));
    } 
        
    @Test
    public void partCEP4 () {
        assertEquals(false, teste.validaCEP("123456"));
    }
    
    @Test
    public void partCEP5 () {
        assertEquals(false, teste.validaCEP(null));
    }
        
    @Test
    public void partCEP6 () {
        assertEquals(false, teste.validaCEP("123456789123"));
    }
    
    @Test
    public void analiseCEP1 () {
        assertEquals(false, teste.validaCEP("1234567"));
    }
    
    @Test
    public void analiseCEP2 () {
        assertEquals(false, teste.validaCEP("12345678911"));
    }
    
    @Test
    public void partEstado1 () {
        assertEquals(true, teste.validaEstado("Parana"));
    }
    
    @Test
    public void partEstado2 () {
        assertEquals(false, teste.validaEstado(null));
    }    
    
    @Test
    public void partEstado3 () {
        assertEquals(false, teste.validaEstado("Paranapernambuco sergibeparaibasaopaulo"));
    }
    
    @Test
    public void partEstado4 () {
        assertEquals(false, teste.validaEstado("Parana!"));
    } 
    
    @Test
    public void partEstado5 () {
        assertEquals(false, teste.validaEstado("Parana2"));
    } 
    
    @Test
    public void analiseEstado1 () {
        assertEquals(false, teste.validaEstado("abcdefghijklmopqrstu"));
    }
    
    @Test
    public void analiseEstado2 () {
        assertEquals(false, teste.validaEstado(""));
    }
    
    @Test
    public void partPais1 () {
        assertEquals(true, teste.validaPais("Brasil"));
    }
    
    @Test
    public void partPais2 () {
        assertEquals(false, teste.validaPais(null));
    }    
    
    @Test
    public void partPais3 () {
        assertEquals(false, teste.validaPais("Brasil nova guine estados unidos da america"));
    }
    
    @Test
    public void partPais4 () {
        assertEquals(false, teste.validaPais("Brasil!"));
    }
    
    @Test
    public void partPais5 () {
        assertEquals(false, teste.validaPais("Brasil2"));
    } 
    
    @Test
    public void analisePais1 () {
        assertEquals(false, teste.validaPais("abcdefghijklmopqrstuvwxy"));
    }
    
    @Test
    public void analisePais2 () {
        assertEquals(false, teste.validaPais(""));
    }
    
    @Test
    public void partTelefone1 () {
        assertEquals(true, teste.validaTelefone("(43)99104-1670"));
    }
    
    @Test
    public void partTelefone2 () {
        assertEquals(true, teste.validaTelefone("4391041670"));
    }
    
    @Test
    public void partTelefone3 () {
        assertEquals(true, teste.validaTelefone("43991041670"));
    }
        
    @Test
    public void partTelefone4 () {
        assertEquals(false, teste.validaTelefone("4"));
    }
        
    @Test
    public void partTelefone5 () {
        assertEquals(false, teste.validaTelefone("1111111111111111"));
    }
        
    @Test
    public void analiseTelefone1 () {
        assertEquals(false, teste.validaTelefone("11111111111"));
    }
        
    @Test
    public void analiseTelefone2 () {
        assertEquals(false, teste.validaTelefone("111111111111111"));
    }
    @Test
    public void partEmail1 () {
        assertEquals(true, teste.validaEmail("hidemisennoteruya@gmail.com"));
    }
    
    @Test
    public void partEmail2 () {
        assertEquals(false, teste.validaEmail("h@a"));
    }
    
    @Test
    public void partEmail3 () {
        assertEquals(false, teste.validaEmail(null));
    }    
    
    @Test
    public void partEmail4 () {
        assertEquals(false, teste.validaEmail("hidemisennoteruyatatsuhirosennosennomatheusalbuquerque@gmail.com"));
    }
    
    @Test
    public void analiseEmail1 () {
        assertEquals(false, teste.validaEmail("abcd@aa.aaa"));
    }
    
    @Test
    public void analiseEmail2 () {
        assertEquals(false, teste.validaEmail("abcdefghijklmopqrstuvwxyzabcdefghijklmnopqrstuvwx@aa.aaa"));
    }
}
