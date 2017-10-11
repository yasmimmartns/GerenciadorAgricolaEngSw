package Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */
public class Regiao {
    private int idRegiao;
    private String endereco;
    private float area;

    public int getIdRegiao() {
        return idRegiao;
    }

    public String getEndereco() {
        return endereco;
    }

    public float getArea() {
        return area;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setArea(float area) {
        this.area = area;
    }
    
    Pattern PALAVRA2 = Pattern.compile ("^[A-Z a-z]{1,49}");
        
    public boolean validaIdRegiao (int regiao) {
        return ((regiao > 0) && (regiao < 2147483646));
    }
    
    public boolean validaEndereco (String end) {
        boolean verifica = false;
        if ((end != null) && (end.length() > 0)) {
            Matcher matcher = PALAVRA2.matcher(end);
            if (matcher.matches())
                verifica = true;
        }
        return verifica;
    }
    
    public boolean validaArea (float area) {
        return ((area > 0) && (area < 2147483646));
    }
}
