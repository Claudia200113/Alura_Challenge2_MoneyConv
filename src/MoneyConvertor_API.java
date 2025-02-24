import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MoneyConvertor_API {
    public CoinData convertCoin (String base_code,
                                 String target_code,
                                 double quantity){

        URI direction = URI.create("https://v6.exchangerate-api.com/v6/b30468b9f1a7f8a3e343feb8/pair/" + base_code
                + "/" + target_code + "/" + quantity);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CoinData.class);
        } catch (Exception e) {
            throw new RuntimeException("Error in the request");
        }
    }
}
