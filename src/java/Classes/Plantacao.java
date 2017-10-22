package Classes;


import Classes.Regiao;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */

public class Plantacao {
    private int idPlantacao;
    private String tipo;
    private int quantidade;
    private Regiao regiao;

    public int getIdPlantacao() {
        return idPlantacao;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdPlantacao(int idPlatacao) {
        this.idPlantacao = idPlatacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
    
    Pattern PALAVRA = Pattern.compile ("^[A-z ]{1,19}");
    
    public boolean validaIdPlantacao (int id) {
        return ((id > 0) && (id < 2147483646));
    }
    
    public boolean validaTipoPlantacao (String tipo) {
        
        boolean verifica = false;
        if ((tipo != null) && (tipo.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(tipo);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaQuantidadePlantacao (int quant) {
        return ((quant > 0) && (quant < 2147483646));
    }
    
    public boolean validaArea (float area) {
        return ((area > 0) && (area < 2147483646));
    }
}
