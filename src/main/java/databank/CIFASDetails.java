package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserialize.LocalDateDeserialize;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CIFASDetails {
    @JsonProperty("MatchDetails")
    private CIFASMatchDetails matchDetails;
    @JsonProperty("InformationSource")
    private String informationSource;
    @JsonProperty("CIFASReference")
    private String cifasReference;
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
    @JsonProperty("Product")
    private String product;
    @JsonProperty("Name")
    private Name name;
    @JsonProperty("Location")
    private Location location;
}
