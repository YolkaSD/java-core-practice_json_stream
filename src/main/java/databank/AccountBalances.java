package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountBalances {
    @JsonProperty("AccountBalance")
    private String accountBalance;
    @JsonProperty("Status")
    private String status;
}
