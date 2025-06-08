
// ClienteRepository.java
import java.io.*;
import java.util.*;

public class ClienteRepository {
    private static final String ARQUIVO = "clientes.txt";
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        carregar();
    }

    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
        salvar();
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void editar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
        salvar();
    }

    public void excluir(int id) {
        clientes.removeIf(c -> c.getId() == id);
        salvar();
    }

    public int gerarProximoId() {
        return clientes.stream().mapToInt(Cliente::getId).max().orElse(0) + 1;
    }

    private void carregar() {
        clientes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                clientes.add(Cliente.fromCSV(linha));
            }
        } catch (IOException | ClienteException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    private void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Cliente c : clientes) {
                bw.write(c.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
}

