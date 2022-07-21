import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

  enum Color {
    BLUE("\u001B[34m"),
    CYAN("\u001B[36m");

    Color(String code) {
      this.code = code;
    }

    private final String code;

    @Override
    public String toString() {
      return code;
    }
  }

  public static void main(String[] args) throws Exception {
    String url = "https://api.mocki.io/v2/549a5d8b";

    var http = new ClienteHttp();
    var json = http.buscarDados(url);

    var parser = new JsonParser();
    List<Map<String, String>> listaDeFilmes = parser.parse((json));

    Filme filme;
    for (var item : listaDeFilmes.subList(0, 2)) {
      filme = new Filme(item.get("title"), item.get("image"), Float.parseFloat(item.get("imDbRating")));
      gerarImagem(filme);
      exbirInformacao(filme);
    }
  }

  private static void gerarImagem(Filme filme) throws Exception {
    var geradorImagem = new GeradoraDeFigurinhas();
    InputStream inputStream = new URL(filme.imagem()).openStream();
    String nomeArquivo = filme.titulo() + ".png";
    geradorImagem.cria(inputStream, nomeArquivo, filme.rating());
  }

  private static void exbirInformacao(Filme filme) {
    System.out.println(Color.BLUE + "Filme..: " + Color.CYAN + filme.titulo());
    System.out.print(Color.BLUE + "Rating.: " + Color.CYAN + "\u2B50".repeat(Math.round(filme.rating())));
    System.out.println(" (" + filme.rating() + ")");
    System.out.println(Color.BLUE + "Poster.: " + Color.CYAN + filme.imagem());
    System.out.println();
  }
}