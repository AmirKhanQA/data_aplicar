package io.aplicar.web.carina.automation.regression;

import java.io.*;
import java.util.*;
import org.json.*;

public class JsonToCsv {
    public static void main(String[] args) throws Exception {

        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\amir.khan1\\IdeaProjects\\data_aplicar\\src\\test\\resources\\xls\\data.json"));
            String jsonString = "";
            String line = reader.readLine();
            while (line != null) {
                jsonString += line;
                line = reader.readLine();
            }
            JSONArray jsonArray = new JSONArray(jsonString);
        // Load JSON data from file
        //JSONArray jsonArray = new JSONArray(new FileReader("C:\\Users\\amir.khan1\\IdeaProjects\\data_aplicar\\src\\test\\resources\\xls\\data.json"));

        // Open CSV file for writing
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\amir.khan1\\IdeaProjects\\data_aplicar\\src\\test\\resources\\xls\\data.csv"));

        // Write header row
        writer.write("campusURL,campusName,campusAddress\n");

        // Write data rows
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            String campusURL = item.getString("campusURL");
            String campusName = item.getString("campusName");
            String campusAddress = item.getString("campusAddress").replaceAll(",", " ");
            writer.write(String.format("%s,%s,%s\n", campusURL, campusName, campusAddress));
        }

        // Close writer
        writer.close();
    }

        catch (JSONException e) {
            System.err.println("Error parsing JSON data: " + e.getMessage());
        }
    }
}

