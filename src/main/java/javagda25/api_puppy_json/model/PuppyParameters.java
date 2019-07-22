package javagda25.api_puppy_json.model;

import lombok.Data;

@Data
public class PuppyParameters {
    private String ingredients;
    private int pageNumber = 1;
}
