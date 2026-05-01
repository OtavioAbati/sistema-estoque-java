package service;

import model.Produto;
import repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository repository;

    // -------------------------
    //  MÉTODO PARA A API (VS CODE)
    // -------------------------
    public List<Produto> listarTodosParaAPI() {
        return repository.findAll(); // Retorna a lista para o Controller
    }

    // -------------------------
    //  ADICIONAR
    // -------------------------
    public void adicionarProduto(Produto produto) {
        repository.save(produto); // Salva no PostgreSQL
        System.out.println("\n✔ Produto \"" + produto.getNome() + "\" salvo no banco de dados!");
    }

    // -------------------------
    //  LISTAR (CONSOLE)
    // -------------------------
    public void listarTodos() {
        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty()) {
            System.out.println("\n⚠ Nenhum produto cadastrado no banco de dados.");
            return;
        }
        System.out.println("\n========== PRODUTOS NO POSTGRESQL ==========");
        produtos.forEach(System.out::println);
        System.out.println("Total de produtos: " + produtos.size());
        System.out.println("============================================");
    }

    // -------------------------
    //  BUSCAR POR ID
    // -------------------------
    public Produto buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    // -------------------------
    //  BUSCAR POR NOME
    // -------------------------
    public void buscarPorNome(String termo) {
        List<Produto> encontrados = repository.findAll().stream()
                .filter(p -> p.getNome().toLowerCase().contains(termo.toLowerCase()))
                .toList();

        if (encontrados.isEmpty()) {
            System.out.println("\n⚠ Nenhum produto encontrado com o termo: \"" + termo + "\"");
        } else {
            System.out.println("\n===== RESULTADO DA BUSCA NO BANCO =====");
            encontrados.forEach(System.out::println);
        }
    }

    // -------------------------
    //  ATUALIZAR
    // -------------------------
    public void atualizarProduto(int id, String novoNome, double novoPreco, int novaQuantidade) {
        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto p = produtoExistente.get();
            p.setNome(novoNome);
            p.setPreco(novoPreco);
            p.setQuantidade(novaQuantidade);
            repository.save(p);
            System.out.println("\n✔ Produto atualizado com sucesso no banco!");
        } else {
            System.out.println("\n✖ Produto com ID " + id + " nao encontrado.");
        }
    }

    // -------------------------
    //  REMOVER
    // -------------------------
    public void removerProduto(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            System.out.println("\n✔ Produto ID " + id + " removido do banco.");
        } else {
            System.out.println("\n✖ Produto com ID " + id + " nao encontrado.");
        }
    }

    // -------------------------
    //  VALOR TOTAL DO ESTOQUE
    // -------------------------
    public void exibirValorTotal() {
        double total = repository.findAll().stream()
                .mapToDouble(Produto::getValorTotal)
                .sum();
        System.out.printf("%n💰 Valor total em estoque (Banco): R$ %.2f%n", total);
    }
}