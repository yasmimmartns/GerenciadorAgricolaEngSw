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
    private String data;
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

    public String getData() {
        return data;
    }

    public float getPreco() {
        return preco;
    }

    public void setIdInsumo(int idInsumo) throws Exception{
        if(idInsumo<0){
            throw new Exception("Id invalido");
        }
        this.idInsumo = idInsumo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public void setData(String data) {
        this.data = data;
    }

    public void setPreco(float preco) throws Exception{
        if(preco < 0){
            throw new Exception("Preco invalido");
        }
        this.preco = preco;
    }
    
    
}
