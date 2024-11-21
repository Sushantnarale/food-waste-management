package com.example.Services;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService {
    private static final String API_KEY = "your_google_maps_api_key";

    public String getNearbyNGOs(String latitude, String longitude) {
        String url = String.format(
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=5000&type=ngo&key=%s",
            latitude, longitude, API_KEY
        );
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Parse JSON response
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder ngos = new StringBuilder();
        try {
            JsonNode root = mapper.readTree(response);
            for (JsonNode result : root.path("results")) {
                String name = result.path("name").asText();
                String address = result.path("vicinity").asText();
                ngos.append("Name: ").append(name).append(", Address: ").append(address).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching NGOs";
        }
        return ngos.toString();
    }
}
