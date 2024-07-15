import java.util.Date;
import java.util.List;
public interface ILivro {
    List<String> acessarLivro();
    String buscarCodigoAcesso(Usuario usuario);
}
