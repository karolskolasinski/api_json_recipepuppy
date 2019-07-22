package javagda25.api_puppy_json.model;

public class APIPupppyURLBuilder {
    private static final String BASE_URL = "http://www.recipepuppy.com/api/?i={ingredients}&p={pageNumber}";
    private final StringBuilder builder;


    public APIPupppyURLBuilder() {
        builder = new StringBuilder(BASE_URL);
    }


    public void loadParameters(PuppyParameters parameters) {
        appendIngredientsAndPageNumber(parameters.getIngredients(), parameters.getPageNumber());
    }


    private void appendIngredientsAndPageNumber(String ingredients, int pageNumber) {
        if (builder.toString().contains("{ingredients}")) {
            int pozycjaIngredients = builder.indexOf("{ingredients}");
            builder.replace(pozycjaIngredients, pozycjaIngredients + 13, ingredients);
        }
        if (builder.toString().contains("{pageNumber}")) {
            int pozycjaPageNumber = builder.indexOf("{pageNumber}");
            builder.replace(pozycjaPageNumber, pozycjaPageNumber + 12, String.valueOf(pageNumber));
        }
    }


    public String compileURL() {
        return builder.toString();
    }
}
