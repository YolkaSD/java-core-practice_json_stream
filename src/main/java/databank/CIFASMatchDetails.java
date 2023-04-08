package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CIFASMatchDetails {
    @JsonProperty("StreetMatchLevel")
    private String streetMatchLevel;
    @JsonProperty("HouseMatchLevel")
    private String houseMatchLevel;
    @JsonProperty("BureauRefCategory")
    private String bureauRefCategory;
    @JsonProperty("MatchTo")
    private String matchTo;
    @JsonProperty("MatchType")
    private String matchType;
}
