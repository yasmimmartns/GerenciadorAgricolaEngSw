package Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */

public class Insumo {
    private int idInsumo;
    private String tipo;
    private String categoria;
    private String especificacoes;
    private int quantidade;
    private String marca;    
    private String dataValidade;
    private float preco;

    public int getIdInsumo() {
        return idInsumo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public float getPreco() {
        return preco;
    }
    
    Pattern PALAVRA = Pattern.compile ("^[A-z ]{1,19}");
    Pattern PALAVRA2 = Pattern.compile ("^[A-Z a-z]{1,49}");
    Pattern PALAVRA3 = Pattern.compile ("^[A-z 0-9]{1,19}");
    Pattern PALAVRA4 = Pattern.compile ("^[A-Z a-z0-9]{1,49}"); 
    Pattern PALAVRA5 = Pattern.compile ("^[A-Z a-z]{4,49}");

    public void setIdInsumo(int idInsumo) throws Exception{
        if(idInsumo<0){
            throw new Exception("Id invalido");
        }
        this.idInsumo = idInsumo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setData(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPreco(float preco) throws Exception{
        if(preco < 0){
            throw new Exception("Preco invalido");
        }
        this.preco = preco;
    }
    
    public boolean validaIdInsumo (int id) {
        return ((id > 0) && (id < 2147483646));
    }
    
    public boolean validaTipoInsumo (String tipo) {
        boolean verifica = false;
        if ((tipo != null) && (tipo.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(tipo);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaCategoria (String categ) {
        boolean verifica = false;
        if ((categ != null) && (categ.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(categ);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaEspecificacoes (String espec) {
        boolean verifica = false;
        if ((espec != null) && (espec.length() > 0)) {
            Matcher matcher = PALAVRA2.matcher(espec);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaQuantidadeInsumo (int quant) {
        return ((quant > 0) && (quant < 2147483646));
    }
    
    public boolean validaMarca (String marca) {
        boolean verifica = false;
        if ((marca != null) && (marca.length() > 0)) {
            Matcher matcher = PALAVRA.matcher(marca);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaPreco (float preco) {
        return ((preco > 0) && (preco < 2147483646));
    }
}
