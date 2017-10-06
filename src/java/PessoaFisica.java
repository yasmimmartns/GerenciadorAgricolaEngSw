import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yasmim
 */


public class PessoaFisica{
    private Pessoa pessoa;    
    private String CPF;
    private String nome;
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
    
}
