import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
  public List<Conteudo> extraiConteudos(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse((json));
    List<Conteudo> conteudos = new ArrayList<>();

    Conteudo conteudo;
    for (var item : listaDeAtributos) {
      conteudo = new Conteudo(item.get("title"), item.get("url"));
      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
