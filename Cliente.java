// Cliente.java
import java.util.regex.*;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;

    public Cliente(int id, String nome, String cpf, String email, String endereco) throws ClienteException {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setEndereco(endereco);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) throws ClienteException {
        if (nome == null || nome.trim().isEmpty())
            throw new ClienteException("Nome não pode ser vazio, tente novamente!");
        this.nome = nome;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) throws ClienteException {
        if (!Validador.validarCPF(cpf))
            throw new ClienteException("CPF inválido, tente novamente!");
        this.cpf = cpf;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) throws ClienteException {
        if (!Validador.validarEmail(email))
            throw new ClienteException("Email não poder ser vazio, tente novamente!");
        this.email = email;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) throws ClienteException {
        if (endereco == null || endereco.trim().isEmpty())
            throw new ClienteException("Endereço não pode ser vazio, tente novamente!");
        this.endereco = endereco;
    }

    public String toCSV() {
        return id + "," + nome + "," + cpf + "," + email + "," + endereco;
    }

    public static Cliente fromCSV(String csv) throws ClienteException {
        String[] partes = csv.split(",");
        return new Cliente(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                partes[4]
        );
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Endereço: " + endereco;
    }
}





