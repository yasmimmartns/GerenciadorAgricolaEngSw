package Classes;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */

public class PessoaFisica{
    private Pessoa pessoa;    
    private String CPF;
    private String nome;
    private String sobrenome;
    private String RG;
    private String sexo;
    private Date dataNascimento;

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getRG() {
        return RG;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setCPF(String cpf) throws Exception {
        cpf = cpf.replaceAll("\\D+","");
        if(cpf.length() == 11)
            this.CPF = cpf;
        else
            throw new Exception("CPF Invalido");
    }

    public void setNome(String nome) throws Exception {
        if(nome.isEmpty())
            throw new Exception("Nome Invalido");
        else if(nome.length() < 45)
            this.nome = nome;
        else
            throw new Exception("Nome maior que 45 caracteres");          
    }

    public void setRG(String rg) throws Exception {
        rg = rg.replaceAll("\\D+","");
        if((rg.length() > 8) && (rg.length() < 13))
            this.RG = rg;
        else
            throw new Exception("RG Inválido");
    }

    public void setSexo(String sexo) throws Exception {
        sexo = sexo.toUpperCase();
        if((sexo.equals("M")) || (sexo.equals("F")))
            this.sexo = sexo;
        else
            throw new Exception("Sexo Inválido");
    }

    public void setDataNascimento(Date data) throws Exception {
        Date dt = new Date();
        if(data.after(dt))
            throw new Exception("Data Invaálida");
        else
            this.dataNascimento = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = Objects.requireNonNull(pessoa);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    Pattern PALAVRA1 = Pattern.compile ("^[A-Z a-z]{4,49}");

    public boolean validaNome (String nome) {
        boolean verifica = false;
        String aux = nome;
        if ((nome != null) && (nome.length() > 0) && (aux.trim().length() != 0)) {
            Matcher matcher = PALAVRA1.matcher(nome);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaSobrenome (String sobrenome) {
       
        boolean verifica = false;
        if ((sobrenome != null) && (sobrenome.length() > 0)) {
            Matcher matcher = PALAVRA1.matcher(sobrenome);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaSexo (String sexo) {
        
        boolean verifica = false;
        if ((sexo != null) && (sexo.length() == 1)) {
            if ((sexo.equalsIgnoreCase("m")) || (sexo.equalsIgnoreCase("f")))
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaRG (int rg) {
        return ((rg > 0) && (rg < 1111999999));
    }
    
    public boolean validaCPF (String cpf) {
        boolean verifica = false;
        if ((cpf != null) && (cpf.length() > 10) && (cpf.length() < 15)) {
            String CPF1 = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$";
            String CPF2 = "^[0-9]{9}\\-[0-9]{2}$";
            String CPF3 = "^[0-9]{11}$";
            Pattern pattern1 = Pattern.compile(CPF1, Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = pattern1.matcher(cpf);
            Pattern pattern2 = Pattern.compile(CPF2, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(cpf);
            Pattern pattern3 = Pattern.compile(CPF3, Pattern.CASE_INSENSITIVE);
            Matcher matcher3 = pattern3.matcher(cpf);
            
            if (matcher1.matches())
                verifica = true;
            else if (matcher2.matches())
                verifica = true;
            else if (matcher3.matches())
                verifica = true;
        }
        return verifica;
    }
    
}
