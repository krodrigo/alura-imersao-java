public class App {

  public static void main(String[] args) throws Exception {
    String url = "https://api.mocki.io/v2/549a5d8b";
    url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

    var http = new ClienteHttp();
    var json = http.buscarDados(url);

    ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
    var conteudos = extrator.extraiConteudos(json);

    for (var item : conteudos) {
      GeradoraDeFigurinhas.cria(item);
      exbirInformacao(item);
    }
  }

  private static void exbirInformacao(Conteudo conteudo) {
    System.out.println(Color.BLUE + "Título..: " + Color.CYAN + conteudo.titulo());
    System.out.println();
  }
}