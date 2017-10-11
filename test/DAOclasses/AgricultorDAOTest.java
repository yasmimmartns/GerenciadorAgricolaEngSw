/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Agricultor;
import Classes.Pessoa;
import Classes.PessoaFisica;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author LARISSA
 */
public class AgricultorDAOTest {

    @Test
    public void testeConexaoAgricultorDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            AgricultorDAO cdao = new AgricultorDAO();
            cdao.setaConexaoAgricultorDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //    Verifica possível retorno de exceção da inserção vazia do cliente
    @Test
    public void testeAdicionaAgricultorDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o cliente para o banco";
        Agricultor c = new Agricultor();
        AgricultorDAO cdao = new AgricultorDAO();
        try {
            cdao.adiciona(c);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //    Verifica se o retorno foi realizado com sucesso
    @Test
    public void testeListaAgricultorDAOValido() throws Exception {
        AgricultorDAO cdao = new AgricultorDAO();
        List lista = cdao.getLista();
        assertTrue(lista instanceof java.util.List);
    }
    
    //    Verifica possível retorno de exceção da update vazio do fornecedor
    @Test
    public void testeAlteraAgricultorDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o cliente para o banco";
        Agricultor cliente = new Agricultor();
        AgricultorDAO cdao = new AgricultorDAO();
        try {
            cdao.altera(cliente);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
 
    //    Verifica se o fornecedor foi alterado com sucesso
    @Test
    public void testeAlteraAgricultorDAOValido() throws Exception {
        Agricultor cliente = new Agricultor();
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        AgricultorDAO cdao = new AgricultorDAO();
        
        pessoa.setId(48);
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

        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nomedo jura");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setCPF("45884718823");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        cliente.setIdAgricultor(9);
        //cliente.setFidelidade(true);
        //cliente.setCodFidelidade("11252");
        cliente.setPf(pf);

        boolean resultAltera = cdao.altera(cliente);
        assertTrue(resultAltera);        
    }
}
