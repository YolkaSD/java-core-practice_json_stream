package databank;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class CAIS {
    @JsonProperty("LocationIndicator")
    private String locationIndicator;
    @JsonProperty("ApplicantIndicator")
    private String applicantIndicator;
    @JsonProperty("CAISDetails")
    private List<CAISDetails> cAISDetails;
}
