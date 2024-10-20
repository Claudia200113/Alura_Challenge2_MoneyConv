import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class JsonRecordGenerator {
    public JsonRecordGenerator() {
    }

    public static void saveJson(CoinData coinData) throws IOException {
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        String var10002 = coinData.base_code();

        FileWriter fileWriter = new FileWriter(coinData.base_code() +
                                                        coinData.target_code() +
                                                        ".json");
        fileWriter.write(gson.toJson(coinData));
        fileWriter.close();
    }
}
