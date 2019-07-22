package javagda25.api_puppy_json.model.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipes {
    private String title;
    private String version;
    private String href;
    private List<Results> results;
}
