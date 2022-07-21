import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo {
  public List<Conteudo> extraiConteudos(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse((json));
    List<Conteudo> conteudos = new ArrayList<>();

    for (var item : listaDeAtributos.subList(0, 2)) {
      String titulo = item.get("title");
      String urlImagem = item.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

      conteudos.add(new Conteudo(titulo, urlImagem));
    }

    return conteudos;
  }
}
