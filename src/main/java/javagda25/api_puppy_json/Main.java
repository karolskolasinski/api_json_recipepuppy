package javagda25.api_puppy_json;

import javagda25.api_puppy_json.model.APIPupppyURLBuilder;
import javagda25.api_puppy_json.model.JSONProcessing;
import javagda25.api_puppy_json.model.PuppyParameters;
import javagda25.api_puppy_json.model.ScannerContentLoader;


public class Main {
    public static void main(String[] args) {
        boolean czyPracowacDalej = true;
        APIPupppyURLBuilder builder = new APIPupppyURLBuilder();
        PuppyParameters puppyParameters = new PuppyParameters();
        ScannerContentLoader scannerContentLoader = new ScannerContentLoader();

        scannerContentLoader.loadIngredients(puppyParameters);
        builder.loadParameters(puppyParameters);

        String requestURL = builder.compileURL();
        System.out.println("your requested ULR is: " + requestURL);

        JSONProcessing.przetwarzanieJSON(requestURL);


        do {
            APIPupppyURLBuilder newBuilder = new APIPupppyURLBuilder();
            scannerContentLoader.isInterestingRecipes(puppyParameters, requestURL);
            newBuilder.loadParameters(puppyParameters);
            String newRequestURL = newBuilder.compileURL();
            System.out.println("your new requested ULR is: " + newRequestURL);
            JSONProcessing.przetwarzanieJSON(newRequestURL);
            if (JSONProcessing.isCloseURI()) {
                czyPracowacDalej = false;
            }
        } while (czyPracowacDalej);
    }
}
