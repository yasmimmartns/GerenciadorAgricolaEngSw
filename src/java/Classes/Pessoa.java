package Classes;


import Classes.Validacoes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */

public class Pessoa{
    private int id;
    private String telefone;
    private String email;
    private String CEP;
    private String logradouro;
    private String complemento;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    
    // Instância para validações de senha e e-mail
    Validacoes valida = new Validacoes();

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id >= 0)
            this.id = id;
        else
            throw new Exception("ID Invalido");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        telefone = telefone.replaceAll("\\D+","");
        if((telefone.length() == 10) || (telefone.length() == 11))
            this.telefone = telefone;
        else
            throw new Exception("Telefone Invalido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(valida.validaEmail(email)){
            this.email = email;
        }
        else
            throw new Exception("E-mail Invalido");
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) throws Exception {
        CEP = CEP.replaceAll("\\D+","");
        if(CEP.length() == 8)
            this.CEP = CEP;
        else
            throw new Exception("CEP Invalido");
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws Exception {
        if(logradouro.isEmpty())
            throw new Exception("Logradouro Invalido");
        else if(logradouro.length() < 45)
            this.logradouro = logradouro;
        else
            throw new Exception("Logradouro maior que 45 caracteres");
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws Exception {
        if(complemento.isEmpty() || complemento.length() < 45)
            this.complemento = complemento;
        else
            throw new Exception("Complemento maior que 45 caracteres");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if(numero > 0)
            this.numero = numero;
        else
            throw new Exception("Numero Invalido");
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        if(bairro.isEmpty())
            throw new Exception("Bairro Invalido");
        else if(bairro.length() < 45)
            this.bairro = bairro;
        else
            throw new Exception("Bairro maior que 45 caracteres");
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if(cidade.isEmpty())
            throw new Exception("Cidade Invalida");
        else if(cidade.length() < 45)
            this.cidade = cidade;
        else
            throw new Exception("Cidade maior que 45 caracteres");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if(estado.isEmpty())
            throw new Exception("Estado Invalido");
        else if(estado.length() < 45)
            this.estado = estado;
        else
            throw new Exception("Estado maior que 45 caracteres");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    Pattern PALAVRA = Pattern.compile ("^[A-z ]{1,19}");
    Pattern PALAVRA2 = Pattern.compile ("^[A-Z a-z]{1,49}");
    Pattern PALAVRA3 = Pattern.compile ("^[A-z 0-9]{1,19}");
    Pattern PALAVRA4 = Pattern.compile ("^[A-Z a-z0-9]{1,49}"); 
    
    public boolean validaEndereco (String end) {
        boolean verifica = false;
        if ((end != null) && (end.length() > 0)) {
            Matcher matcher = PALAVRA2.matcher(end);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaLogradouro (String log) {
        boolean verifica = false;
        if ((log != null) && (log.length() > 0)) {
            Matcher matcher = PALAVRA4.matcher(log);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaComplemento (String comp) {
        boolean verifica = false;
        if ((comp != null) && (comp.length() > 0)) {
            Matcher matcher = PALAVRA3.matcher(comp);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaNumero (int num) {
        return ((num > 0) && (num < 99999));
    }
    
    public boolean validaBairro (String bairro) {
        boolean verifica = false;
        if ((bairro != null) && (bairro.length() > 0)) {
            Matcher matcher = PALAVRA2.matcher(bairro);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaCidade (String cidade) {
        boolean verifica = false;
        if ((cidade != null) && (cidade.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(cidade);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaCEP (String cep) {
        boolean verifica = false;
        if ((cep != null) && (cep.length() > 7) && (cep.length() < 11)) {
            String CEP1 = "^[0-9]{2}\\.[0-9]{3}\\-[0-9]{3}$";
            String CEP2 = "^[0-9]{5}\\-[0-9]{3}$";
            String CEP3 = "^[0-9]{8}$";
            Pattern pattern1 = Pattern.compile(CEP1, Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = pattern1.matcher(cep);
            Pattern pattern2 = Pattern.compile(CEP2, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(cep);
            Pattern pattern3 = Pattern.compile(CEP3, Pattern.CASE_INSENSITIVE);
            Matcher matcher3 = pattern3.matcher(cep);
            
            if (matcher1.matches())
                verifica = true;
            else if (matcher2.matches())
                verifica = true;
            else if (matcher3.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaEstado (String estado) {
        boolean verifica = false;
        if ((estado != null) && (estado.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(estado);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaPais (String pais) {
        
        boolean verifica = false;
        if ((pais != null) && (pais.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(pais);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaTelefone (String tel) {
        boolean verifica = false;
        if ((tel != null) && (tel.length() > 0)) {
            String exp1 = "^\\([1-9]{2}\\)[9]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}$";
            String exp2 = "^[1-9]{2}[9]{0,1}[6-9]{1}[0-9]{7}$";
            Pattern TELEFONE1 = Pattern.compile(exp1, Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = TELEFONE1.matcher(tel);
            Pattern TELEFONE2 = Pattern.compile(exp2, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = TELEFONE2.matcher(tel);

            if (matcher1.matches()) {
                verifica = true;
            }
            else if (matcher2.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaEmail(String email) {
        
        boolean verifica = false;
        if (email != null && email.length() > 0) {
            String exp = "^[A-Za-z0-9+_.-]{5,30}+@[A-Za-z0-9+_.-]{2,}\\.[A-Za-z0-9+_.-]{3}$";
            Pattern EMAIL = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
            Matcher matcher = EMAIL.matcher(email);
            if (matcher.matches()) {
                verifica = true;
            }
        }
        return verifica;
    }
}