package ec.sevolutivo.sevuelos.sevuelos.dto;

import ec.sevolutivo.sevuelos.sevuelos.enumeration.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO implements Serializable {
    private Long id;
    private String passenger;
    private String destination;
    private RequestStatus status;
}
