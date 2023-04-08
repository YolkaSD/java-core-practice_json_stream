package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserialize.LocalDateDeserialize;
import lombok.Data;
import org.example.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class CAISDetails {
    @JsonProperty("MatchDetails")
    private CAISMatchDetails matchDetails;
    @JsonProperty("InformationSource")
    private String informationSource;
    @JsonProperty("CreditLimit")
    private CreditLimit creditLimit;
    @JsonProperty("Balance")
    private Balance balance;
    @JsonProperty("AccountStatusCodes")
    private String accountStatusCodes;
    @JsonProperty("Status1To2")
    private String status1To2;
    @JsonProperty("StatusTo3")
    private String statusTo3;
    @JsonProperty("NumOfMonthsHistory")
    private int numOfMonthsHistory;
    @JsonProperty("CAISAccStartDate")
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate cAISAccSwtartDate;
    @JsonProperty("SettlementDate")
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate settlementDate;
    @JsonProperty("SettleDateCaption")
    private String settleDateCaption;
    @JsonProperty("LastUpdatedDate")
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate lastUpdatedDate;
    @JsonProperty("BankFlag")
    private String bankFlag;
    @JsonProperty("WorstStatus")
    private String worstStatus;
    @JsonProperty("OwnData")
    private String ownData;
    @JsonProperty("RepaymentPeriod")
    private int repaymentPeriod;
    @JsonProperty("Payment")
    private String payment;
    @JsonProperty("FraudCategory")
    private String fraudCategory;
    @JsonProperty("SupplyDate")
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate supplyDate;
    @JsonProperty("AndOtherLocations")
    private String andOtherLocations;
    @JsonProperty("SupplyCompanyName")
    private String supplyCompanyName;
    @JsonProperty("SubCategories")
    private String subCategories;
    @JsonProperty("DateOfBirth")
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate dateOfBirth;
    @JsonProperty("Sex")
    private String sex;
    @JsonProperty("PaymentFrequency")
    private String paymentFrequency;
    @JsonProperty("AccountStatus")
    private String accountStatus;
    @JsonProperty("NumAddInfoBlocks")
    private int numAddInfoBlocks;
    @JsonProperty("NumAccountBalances")
    private int numAccountBalances;
    @JsonProperty("AccountBalances")
    private List<AccountBalances> accountBalances;
    @JsonProperty("NumCardHistories")
    private int numCardHistories;
    @JsonProperty("CardHistories")
    private List<CardHistories> cardHistories;
    @JsonProperty("NumCreditLimChngs")
    private int numCreditLimChngs;
    @JsonProperty("CredLimitHistories")
    private List<CredLimitHistories> credLimitHistories;
    @JsonProperty("NumStatuses")
    private int numStatuses;
    @JsonProperty("CompanyType")
    private String CompanyType;
    @JsonProperty("AccountType")
    private String accountType;
    @JsonProperty("Product")
    private String product;
    @JsonProperty("Name")
    private Name name;
    @JsonProperty("Location")
    private Location location;
}
