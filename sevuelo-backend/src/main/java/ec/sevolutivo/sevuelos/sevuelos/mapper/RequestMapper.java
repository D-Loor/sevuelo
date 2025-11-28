package ec.sevolutivo.sevuelos.sevuelos.mapper;

import ec.sevolutivo.sevuelos.sevuelos.dto.RequestDTO;
import ec.sevolutivo.sevuelos.sevuelos.entity.Request;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    RequestDTO toDto(Request entity);

    Request toEntity(RequestDTO dto);

}
