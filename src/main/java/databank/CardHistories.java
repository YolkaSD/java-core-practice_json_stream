package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardHistories {
    @JsonProperty("PrevStatementBal")
    private String prevStatementBal;
    @JsonProperty("PromotionalRate")
    private String promotionalRate;
    @JsonProperty("PaymentAmount")
    private String paymentAmount;
    @JsonProperty("NumCashAdvances")
    private String numCashAdvances;
    @JsonProperty("CashAdvanceAmount")
    private String numCashAdvanceAmount;

}
