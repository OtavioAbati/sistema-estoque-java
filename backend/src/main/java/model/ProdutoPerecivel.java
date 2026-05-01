package model;

public class ProdutoPerecivel extends Produto{

    private String dataValidade;

    public ProdutoPerecivel(int id, String nome, double preco, int quantidade, String dataValidade){
        super(id, nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {return dataValidade;}
    public void setDataValidade(String dataValidade) {this.dataValidade = dataValidade;}

    @Override
    public String toString(){
        return super.toString() + String.format(" | Validade: %s [PERECIVEL]", dataValidade);
    }
}
