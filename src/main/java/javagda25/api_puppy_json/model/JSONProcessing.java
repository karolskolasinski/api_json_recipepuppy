package javagda25.api_puppy_json.model;

import com.google.gson.Gson;
import javagda25.api_puppy_json.model.api.Recipes;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class JSONProcessing {

    public static void openURI(int recipeNumber, String requestURL) {

        String content = JSONProcessing.loadContentFromURL(requestURL);
        Gson gson = new Gson();
        Recipes results = gson.fromJson(content, Recipes.class);
        for (int i = 0; i < results.getResults().size(); i++) {
            if (results.getResults().indexOf(results.getResults().get(i)) == recipeNumber) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(results.getResults().get(i).getHref()));
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /*przetworzenie JSON na obiekty wg Recipes.class*/
    public static void przetwarzanieJSON(String requestURL) {
        System.out.println("Szukam przepisów...");
        String content = JSONProcessing.loadContentFromURL(requestURL);
        Gson gson = new Gson();
        Recipes results = gson.fromJson(content, Recipes.class);
        System.out.println("Twoje przepisy to: ");
        /*wypisanie przepisów na ekran wraz z ich numerami*/
        for (int i = 0; i < results.getResults().size(); i++) {
            System.out.println(results.getResults().indexOf(results.getResults().get(i)) + 1 + ": " + results.getResults().get(i).getTitle());
        }




    }

    /*przeczytanie z JSON ze strony*/
    public static String loadContentFromURL(String requestURL) {
        String apiContent = null;
        try {
            URL url = new URL(requestURL);
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String liniaTekstuZReadera;

            while ((liniaTekstuZReadera = bufferedReader.readLine()) != null) {
                builder.append(liniaTekstuZReadera);
            }
            bufferedReader.close();
            apiContent = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiContent;
    }
}
