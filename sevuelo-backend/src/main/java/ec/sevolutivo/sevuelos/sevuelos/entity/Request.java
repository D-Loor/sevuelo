package ec.sevolutivo.sevuelos.sevuelos.entity;

import ec.sevolutivo.sevuelos.sevuelos.enumeration.RequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Request {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "request_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "passenger", length = 100, nullable = false)
    private String passenger;

    @NotNull
    @Size(max = 100)
    @Column(name = "destination", length = 100, nullable = false)
    private String destination;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RequestStatus status;

}
