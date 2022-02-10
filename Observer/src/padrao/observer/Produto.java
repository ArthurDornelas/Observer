package padrao.observer;

import java.util.Observable;

public class Produto extends Observable {
    private String nome;
    private Double preco;
    private String loja;

    public Produto(String nome, Double preco, String loja) {
        this.nome = nome;
        this.preco = preco;
        this.loja = loja;
    }

    public void atualizarProduto(double novoPreco) {
        double precoAntigo = preco;
        preco = novoPreco;
        if(novoPreco < precoAntigo) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome=" + nome +
                ", preco=" + preco +
                ", loja=" + loja +
                '}';
    }
}
