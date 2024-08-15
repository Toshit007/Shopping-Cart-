//NAME - Toshit Narwal
//STUDENT NO. - 20056512

package ca.georgian.test2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonParser {
    public static ArrayList<Customer> parseCustomersJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON object
            JsonObject jsonObject = com.google.gson.JsonParser.parseReader(reader).getAsJsonObject();

            // Extract Customers array from the object
            JsonArray jsonArray = jsonObject.getAsJsonArray("Customers");

            Type customerListType = new TypeToken<ArrayList<Customer>>() {}.getType();

            // Parse Customers array into a list
            return gson.fromJson(jsonArray, customerListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
