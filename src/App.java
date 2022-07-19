import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

    // fazer uma conexão HTTP e buscar os top 250 filmes  
    String url = "https://alura-imdb-api.herokuapp.com/movies";
    URI endereço= URI.create(url); 
    var client = HttpClient.newHttpClient(); 
    var request = HttpRequest.newBuilder(endereço).GET().build();
    HttpResponse<String> reponse = client.send(request, BodyHandlers.ofString());
    String body = reponse.body();

    // extrair só os dados pertimentes (titulo, poster, nota)
    var parser = new JsonParser();
    List<Map<String, String>> ListaDeFilmes= parser.parse(body);

    // exibir e manipular os dados
    estrelar notasEstrelas = new estrelar();
    ListaDeFilmes= notasEstrelas.set(ListaDeFilmes);
    for (Map<String,String> filme : ListaDeFilmes) {
        System.out.println("\u001B[45m Titulo: "+filme.get("title")+" \u001B[0m");
        System.out.println("Poster: "+filme.get("image"));
        System.out.println("\u001B[46m Nota:"+filme.get("imDbRating")+" \u001B[0m");
        System.out.println(filme.get("estrelas"));
    }
    }
}

