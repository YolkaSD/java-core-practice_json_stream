package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserialize.LocalMMDeserialize;
import deserialize.LocalYYDeserialize;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditLimitDate {
    @JsonProperty("CreditLimitDateMM")
    @JsonDeserialize(using = LocalMMDeserialize.class)
    private LocalDate creditLimitDateMM;
    @JsonProperty("CreditLimitDateYY")
    @JsonDeserialize(using = LocalYYDeserialize.class)
    private LocalDate creditLimitDateYY;
}
