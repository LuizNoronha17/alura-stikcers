import java.util.List;
import java.util.Map;

public class estrelar {
    public List<Map<String, String>> set( List<Map<String, String>> notas) {
        String estrelas;
        for (Map<String,String> map : notas) {
            estrelas= "";
            Float n =Float.parseFloat(map.get("imDbRating"));
            if (n%1<0.5) {
                n-=n%1;
            }
            for (int i = 0; i < n; i++) {
                estrelas= estrelas + " \u2B50";
            }
            map.put("estrelas", estrelas);
        }
        
        return notas;
    }
}
