package javagda25.api_puppy_json.model;
import java.util.Scanner;

public class ScannerContentLoader {
    private Scanner scanner = new Scanner(System.in);

    public void loadIngredients(PuppyParameters puppyParameters) {
        boolean endLoading = false;
        StringBuilder stringBuilder = new StringBuilder();
        String ingredientsFromUser = null;
        do {
            System.out.println("Podaj składnik (ang.) lub zakończ (koniec):");
            String line = scanner.nextLine();
            if (!line.equalsIgnoreCase("koniec")) {
                ingredientsFromUser = stringBuilder.append(line).append(",").toString();
            }
            if (line.equalsIgnoreCase("koniec")) {
                if (ingredientsFromUser != null) {
                    ingredientsFromUser = ingredientsFromUser.substring(0, ingredientsFromUser.length() - 1);
                }
                endLoading = true;
            }
        } while (!endLoading);
        puppyParameters.setIngredients(ingredientsFromUser);
    }

    public void isInterestingRecipes(PuppyParameters puppyParameters, String requestURL) {
        System.out.println("Czy widzisz przepis który Ciebie interesuje?");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("nie")) {
            puppyParameters.setPageNumber(puppyParameters.getPageNumber() + 1);
        } else if (answer.equalsIgnoreCase("tak")) {
            System.out.println("Który przepis Cię interesuje:");
            int recipeIndex = scanner.nextInt() - 1;
            JSONProcessing.openURI(recipeIndex, requestURL);
        } else {
            System.err.println("Niepoprawna odpowiedź.");
        }
    }
}
