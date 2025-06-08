


// Validador.java
import java.util.regex.*;

public class Validador {
    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public static boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }
}




