package Classes;

import java.util.regex.Pattern;

/**
 *
 * @author yasmim
 */

public class Validacoes {
    private String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]{1,}+@[A-Za-z0-9+_.-]{1,}$";    
    private String SENHA_PATTERN = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,15}";
    
    public boolean validaSenha(String senha) {
        return senha.matches(SENHA_PATTERN);
    }
    
    public boolean validaEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }
    
}
