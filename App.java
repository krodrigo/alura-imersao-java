import java.io.InputStream;
import java.net.URL;

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

    var extrator = new ExtratorDeConteudoDoImdb();
    var conteudos = extrator.extraiConteudos(json);

    for (var item : conteudos) {
      gerarImagem(item);
      exbirInformacao(item);
    }
  }

  private static void gerarImagem(Conteudo conteudo) throws Exception {
    var geradorImagem = new GeradoraDeFigurinhas();
    InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
    String nomeArquivo = conteudo.getTitulo() + ".png";
    geradorImagem.cria(inputStream, nomeArquivo);
  }

  private static void exbirInformacao(Conteudo conteudo) {
    System.out.println(Color.BLUE + "Filme..: " + Color.CYAN + conteudo.getTitulo());
    System.out.println();
  }
}