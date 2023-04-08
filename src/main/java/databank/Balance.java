package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Balance {
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("Narrative")
    private String narrative;
}
