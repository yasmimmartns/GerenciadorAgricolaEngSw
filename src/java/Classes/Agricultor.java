package Classes;


/**
 *
 * @author yasmim
 */
public class Agricultor {
    
    private PessoaFisica pf;
    private int idAgricultor;
    private String cadPro;

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public String getCadPro() {
        return cadPro;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    public void setCadPro(String cadPro) throws Exception{
        this.cadPro = cadPro;
    }
    
    public boolean validaIdAgricultor (int id) {
        return ((id > 0) && (id < 2147483646));
    }        
}
