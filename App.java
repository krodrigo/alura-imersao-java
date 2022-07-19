import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
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
    URI endereco = URI.create(url);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

    var parser = new JsonParser();
    List<Map<String, String>> listaDeFilmes = parser.parse((body));

    for (var filme : listaDeFilmes) {
      System.out.println(Color.BLUE + "Filme..: " + Color.CYAN + filme.get("title"));

      var rate = Float.parseFloat(filme.get("imDbRating"));
      System.out.print(Color.BLUE + "Rating.: " + Color.CYAN + "\u2B50".repeat(Math.round(rate)));
      System.out.println(" (" + rate + ")");
      System.out.println(Color.BLUE + "Poster.: " + Color.CYAN + filme.get("image"));
      System.out.println();
    }
  }
}