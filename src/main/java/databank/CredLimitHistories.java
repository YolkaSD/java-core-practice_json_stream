package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CredLimitHistories {
    @JsonProperty("CreditLimitChange")
    private String creditLimitChange;
    @JsonProperty("CreditLimitDate")
    private CreditLimitDate creditLimitDate;
}
