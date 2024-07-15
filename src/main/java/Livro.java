import java.util.Arrays;
import java.util.List;

public class Livro implements ILivro {
    private Integer codigo;
    private String titulo;
    private String ano;
    private String editora;
    private String accessCode;

    public Livro(Integer codigo) {
        this.codigo = codigo;
        Livro objeto = BD.getLivro(codigo);
        this.titulo = objeto.titulo;
        this.ano = objeto.ano;
        this.editora = objeto.editora;
        this.accessCode = objeto.accessCode;
    }

    public Livro(Integer codigo, String titulo, String ano, String editora, String accessCode) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.accessCode = accessCode;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> acessarLivro() {
        return Arrays.asList(this.titulo, this.ano, this.editora);
    }
    @Override
    public String buscarCodigoAcesso(Usuario usuario) {
        return this.accessCode;
    }
}
