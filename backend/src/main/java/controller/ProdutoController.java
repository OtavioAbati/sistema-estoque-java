package controller;

import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EstoqueService;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Produto> listar() {
        return estoqueService.listarTodosParaAPI();
    }

    @PostMapping
    public void salvar(@RequestBody Produto produto) {
        estoqueService.adicionarProduto(produto);
    }
}