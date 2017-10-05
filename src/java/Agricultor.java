/**
 *
 * @author yasmim
 */
public class Agricultor {
    
    private PessoaFisica pf;
    private String cadPro;

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
    
}
