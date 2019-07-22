package javagda25.api_puppy_json.model.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Results {
    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;
}
