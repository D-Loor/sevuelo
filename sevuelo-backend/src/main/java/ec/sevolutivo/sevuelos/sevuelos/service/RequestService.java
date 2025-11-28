package ec.sevolutivo.sevuelos.sevuelos.service;

import ec.sevolutivo.sevuelos.sevuelos.dto.RequestDTO;

import java.util.List;

public interface RequestService {

    RequestDTO create(RequestDTO dto);

    List<RequestDTO> findAll();

    RequestDTO findById(Long id);

    RequestDTO reserve(Long id);

}
