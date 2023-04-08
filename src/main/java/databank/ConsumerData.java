package databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConsumerData {
    @JsonProperty("CIFAS")
    private List<CIFAS> cifas;
    @JsonProperty("CAIS")
    private List<CAIS> cais;

}
