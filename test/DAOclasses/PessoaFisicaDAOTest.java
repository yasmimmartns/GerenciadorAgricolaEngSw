/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import Classes.Pessoa;
import Classes.PessoaFisica;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author LARISSA
 */
public class PessoaFisicaDAOTest {
   
    @Test
    public void testeConexaoPessoaFisicaDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
            pfdao.setaConexaoPessoaFisicaDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //Verifica possível retorno de exceção da inserção vazia do pessoa fisica
    @Test
    public void testeAdicionaPessoaFisicaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa fisica para o banco";
        PessoaFisica pf = new PessoaFisica();
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        try {
            pfdao.adiciona(pf);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //    Verifica se o pessoa fisica foi adicionado com sucesso
    @Test
    public void testeAdicionaPessoaFisicaDAOValido() throws Exception {
        
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pessoa.setEmail("abc@abc.com");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");

        pf.setCPF("35824711223");

        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nome");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        boolean resultAdiciona = pfdao.adiciona(pf);
        
        assertTrue(resultAdiciona);       
    }

    //    Verifica possível retorno de exceção da update vazio do pessoa fisica
    @Test
    public void testeAlteraPessoaFisicaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa fisica para o banco";
        PessoaFisica pf = new PessoaFisica();
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        try {
            pfdao.altera(pf);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    } 
    
    @Test
    public void testeAlteraPessoaFisicaDAOValida() throws Exception{
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setEmail("abc@abc.com");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");
        
        PessoaFisica pf = new PessoaFisica();
        pf.setCPF("45884218823");
        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nome");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        boolean resultAltera = pfdao.altera(pf);
        assertTrue(resultAltera);
        
    }
}