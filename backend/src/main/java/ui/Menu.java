package ui;

import model.Produto;
import service.EstoqueService;
import java.util.Scanner;

public class Menu {
    private final EstoqueService estoqueService;
    private final Scanner scanner;

    // Construtor que recebe o service gerenciado pelo Spring
    public Menu(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n========== SISTEMA DE ESTOQUE - JAVA & POSTGRES ==========");
            System.out.println("1. Listar todos os produtos");
            System.out.println("2. Adicionar produto");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Alertas de estoque baixo");
            System.out.println("7. Valor total do estoque");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um numero valido.");
                continue;
            }

            switch (opcao) {
                case 1 -> estoqueService.listarTodos();
                case 2 -> cadastrarProduto();
                case 3 -> buscarPorNome();
                case 4 -> atualizarProduto();
                case 5 -> removerProduto();
                case 6 -> alertarEstoqueBaixo();
                case 7 -> estoqueService.exibirValorTotal();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preco: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        // Criamos o objeto sem ID, pois o Postgres gerará automaticamente
        Produto p = new Produto(0, nome, preco, qtd);
        estoqueService.adicionarProduto(p);
    }

    private void buscarPorNome() {
        System.out.print("Digite o nome ou parte dele: ");
        String termo = scanner.nextLine();
        estoqueService.buscarPorNome(termo);
    }

    private void atualizarProduto() {
        System.out.print("ID do produto que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Preco: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Nova Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        estoqueService.atualizarProduto(id, nome, preco, qtd);
    }

    private void removerProduto() {
        System.out.print("ID do produto para remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        estoqueService.removerProduto(id);
    }

    private void alertarEstoqueBaixo() {
        System.out.print("Defina o limite minimo de estoque: ");
        int limite = Integer.parseInt(scanner.nextLine());
        // Se desejar, você pode implementar este método no service usando o repository
        System.out.println("Funcionalidade em integracao com o banco...");
    }
}