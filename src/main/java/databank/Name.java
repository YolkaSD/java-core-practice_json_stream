package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Name {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Forename")
    private String forename;
    @JsonProperty("Surname")
    private String surname;
}
