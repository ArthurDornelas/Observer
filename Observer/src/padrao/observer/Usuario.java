package padrao.observer;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void adicionarProduto(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produto, Object arg) {
        this.ultimaNotificacao = this.nome + ", preco atualizado em " + produto.toString();
    }
}
