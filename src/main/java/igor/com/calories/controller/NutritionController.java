package igor.com.calories.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import igor.com.calories.Items.NutritionItem;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/nutrition")
public class NutritionController {


@Value("${API_KEY}")
String apiKey ;

    @GetMapping("/fetch")
    public String fetchNutritionData(@RequestParam("query") String query, Model model) {
        try {
            String api_url = "https://api.calorieninjas.com/v1/nutrition?query=";

            // URL-encode the query string
            String encodedQuery = URLEncoder.encode(query, "UTF-8");

            // Construct the full URL
            String fullUrl = api_url + encodedQuery;

            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(fullUrl);

            // Set the API key in the request header
            httpGet.setHeader("X-Api-Key", apiKey);

            HttpResponse response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> jsonResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });

                // Extract the "items" field from the JSON response
                List<NutritionItem> nutritionItems = objectMapper.convertValue(jsonResponse.get("items"), new TypeReference<List<NutritionItem>>() {
                });

                double totalCalories = 0;
                for (NutritionItem myItems : nutritionItems) {
                    double myCalories = myItems.getCalories();
                    totalCalories = totalCalories + myCalories;
                }


                model.addAttribute("nutritionItems", nutritionItems);
                model.addAttribute("totalCalories", totalCalories);
            } else {
                model.addAttribute("response", "Error: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("response", "An error occurred.");
        }

        return "nutrition";

    }

}


