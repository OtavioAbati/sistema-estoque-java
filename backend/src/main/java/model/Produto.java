package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private double preco;
    private int quantidade;

    // Construtor vazio (Obrigatório para o Spring Boot/JPA)
    public Produto() {
    }

    // Construtor completo (Mantenha o seu original para facilitar a criação de objetos)
    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // GETTERS
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    // SETTERS
    public void setId(int id) { this.id = id; } // Adicionado setter para o ID
    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorTotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Nome: %-25s | Preco: R$ %8.2f | Qtd: %4d | Total: R$ %10.2f",
                id, nome, preco, quantidade, getValorTotal()
        );
    }
}