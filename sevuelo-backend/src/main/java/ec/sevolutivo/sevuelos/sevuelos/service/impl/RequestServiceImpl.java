package ec.sevolutivo.sevuelos.sevuelos.service.impl;

import ec.sevolutivo.sevuelos.sevuelos.dto.RequestDTO;
import ec.sevolutivo.sevuelos.sevuelos.entity.Request;
import ec.sevolutivo.sevuelos.sevuelos.enumeration.RequestStatus;
import ec.sevolutivo.sevuelos.sevuelos.exception.RequestNotFoundException;
import ec.sevolutivo.sevuelos.sevuelos.mapper.RequestMapper;
import ec.sevolutivo.sevuelos.sevuelos.repository.RequestRepository;
import ec.sevolutivo.sevuelos.sevuelos.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;
    private final RequestMapper mapper;

    @Override
    public RequestDTO create(RequestDTO dto) {
        Request entity = mapper.toEntity(dto);

        entity.setStatus(RequestStatus.NEW);

        Request saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<RequestDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public RequestDTO findById(Long id) {
        Request entity = repository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException(id));

        return mapper.toDto(entity);
    }

    @Override
    public RequestDTO reserve(Long id) {
        Request entity = repository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException(id));

        entity.setStatus(RequestStatus.RESERVED);
        Request updated = repository.save(entity);

        return mapper.toDto(updated);
    }

}
