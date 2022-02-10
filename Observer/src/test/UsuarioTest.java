package test;

import org.junit.jupiter.api.Test;
import padrao.observer.Produto;
import padrao.observer.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    void deveNotificarUmUsuario() {
        Produto produto = new Produto("Monitor Dell", 800.00, "Kabum");
        Usuario usuario = new Usuario("Jack");
        usuario.adicionarProduto(produto);
        produto.atualizarProduto(780.00);
        assertEquals("Jack, preco atualizado em Produto{nome=Monitor Dell, preco=780.0, loja=Kabum}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        Produto produto = new Produto("Monitor Dell", 800.00, "Kabum");
        Usuario usuario1 = new Usuario("Jack");
        Usuario usuario2 = new Usuario("James");
        usuario1.adicionarProduto(produto);
        usuario2.adicionarProduto(produto);
        produto.atualizarProduto(780.00);
        assertEquals("Jack, preco atualizado em Produto{nome=Monitor Dell, preco=780.0, loja=Kabum}", usuario1.getUltimaNotificacao());
        assertEquals("James, preco atualizado em Produto{nome=Monitor Dell, preco=780.0, loja=Kabum}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        Produto produto = new Produto("Monitor Dell", 800.00, "Kabum");
        Usuario usuario1 = new Usuario("Jack");
        produto.atualizarProduto(780.00);
        assertEquals(null, usuario1.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuarioPrecoMaisAltoQueAnterior() {
        Produto produto = new Produto("Monitor Dell", 800.00, "Kabum");
        Usuario usuario1 = new Usuario("Jack");
        usuario1.adicionarProduto(produto);
        produto.atualizarProduto(820.00);
        assertEquals(null, usuario1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioProdutoA() {
        Produto produtoA = new Produto("A", 800.00, "Kabum");
        Produto produtoB = new Produto("B", 500.00, "Kabum");
        Usuario usuario1 = new Usuario("Jack");
        Usuario usuario2 = new Usuario("James");
        usuario1.adicionarProduto(produtoA);
        usuario2.adicionarProduto(produtoB);
        produtoA.atualizarProduto(780.00);
        assertEquals("Jack, preco atualizado em Produto{nome=A, preco=780.0, loja=Kabum}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}
