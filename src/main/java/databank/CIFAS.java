package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CIFAS {
    @JsonProperty("LocationIndicator")
    private String locationIndicator;
    @JsonProperty("ApplicantIndicator")
    private String applicantIndicator;
    @JsonProperty("CIFASDetails")
    private List<CIFASDetails> cifasDetails;
}
