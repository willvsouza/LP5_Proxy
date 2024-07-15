import java.util.List;

public class LivroProxy implements ILivro {
    private Livro livro;

    private Integer codigo;

    public LivroProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> acessarLivro() {
        if (this.livro == null) {
            this.livro = new Livro(this.codigo);
        }
        return this.livro.acessarLivro();
    }

    public String buscarCodigoAcesso(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário não tem permissão de administrador para esta ação");
        }
        if (this.livro == null) {
            this.livro = new Livro(this.codigo);
        }
        return this.livro.buscarCodigoAcesso(usuario);
    }
}
