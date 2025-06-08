



// ClienteApp.java
import java.util.Scanner;

public class ClienteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteRepository repo = new ClienteRepository();

        while (true) {
            System.out.println("\n1. Criar novo registro\n2. Listar todos\n3. Buscar por ID\n4. Editar\n5. Excluir\n6. Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (###.###.###-##): ");
                        String cpf = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        int id = repo.gerarProximoId();
                        repo.adicionar(new Cliente(id, nome, cpf, email, endereco));
                        break;
                    case 2:
                        for (Cliente c : repo.listar()) System.out.println(c);
                        break;
                    case 3:
                        System.out.print("ID: ");

                        int idBusca = Integer.parseInt(sc.nextLine());
                        Cliente cliente = repo.buscarPorId(idBusca);
                        System.out.println(cliente != null ? cliente : "Não encontrado");
                        break;
                    case 4:
                        System.out.print("ID para editar: ");
                        int idEdit = Integer.parseInt(sc.nextLine());
                        Cliente c = repo.buscarPorId(idEdit);
                        if (c != null) {
                            System.out.print("Novo nome: ");
                            c.setNome(sc.nextLine());
                            System.out.print("Novo CPF: ");
                            c.setCpf(sc.nextLine());
                            System.out.print("Novo Email: ");
                            c.setEmail(sc.nextLine());
                            System.out.print("Novo Endereço: ");
                            c.setEndereco(sc.nextLine());
                            repo.editar(c);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.print("ID para excluir: ");
                        repo.excluir(Integer.parseInt(sc.nextLine()));
                        break;
                    case 6:
                        System.exit(0);
                  
