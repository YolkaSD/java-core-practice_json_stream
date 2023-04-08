package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    @JsonProperty("HouseNumber")
    private String houseNumber;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("PostTown")
    private String postTown;
    @JsonProperty("County")
    private String county;
    @JsonProperty("Postcode")
    private String postcode;

}
