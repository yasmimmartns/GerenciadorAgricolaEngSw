package Classes;


import Classes.Regiao;
import java.util.Objects;

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
        this.regiao = Objects.requireNonNull(regiao);
    }
}
