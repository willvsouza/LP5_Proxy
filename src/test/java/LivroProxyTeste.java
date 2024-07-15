import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LivroProxyTest {
    @BeforeEach
    void setUp() {
        BD.addLivro(new Livro(1, "Harry Potter e a Pedra Filosofal", "1997", "Bloomsbury", "MB3232"));
        BD.addLivro(new Livro(2, "A Guerra dos Tronos : As Crônicas de Gelo e Fogo", "1996", "Bantam Spectra", "IS32DS32"));
        BD.addLivro(new Livro(3, "A Dança dos Dragões", "2011", "Bantam Spectra", "IS373DD2"));
    }

    @Test
    void deveRetornarDadosDoLivro() {
        LivroProxy livro = new LivroProxy(1);

        assertEquals(Arrays.asList("Harry Potter e a Pedra Filosofal", "1997", "Bloomsbury"), livro.acessarLivro());
    }

    @Test
    void deveRetornarCodigoDeAcessoDoLivro() {
        Usuario usuario = new Usuario("William", true);
        LivroProxy livro = new LivroProxy(2);

        assertEquals("IS32DS32", livro.buscarCodigoAcesso(usuario));
    }

    @Test
    void deveRetornarExcecaoDeUsuarioSemPermissao() {
        try {
            Usuario usuario = new Usuario("Guilherme", false);
            LivroProxy livro = new LivroProxy(2);

            livro.buscarCodigoAcesso(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não tem permissão de administrador para esta ação", e.getMessage());
        }
    }

}