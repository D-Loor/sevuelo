package ec.sevolutivo.sevuelos.sevuelos.controller;

import ec.sevolutivo.sevuelos.sevuelos.dto.RequestDTO;
import ec.sevolutivo.sevuelos.sevuelos.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO dto) {
        RequestDTO result = requestService.create(dto);
        return ResponseEntity
                .created(URI.create("/api/requests/" + result.getId()))
                .body(result);
    }

    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        return ResponseEntity.ok(requestService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDTO> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.findById(id));
    }

    @PutMapping("/reserve/{id}")
    public ResponseEntity<RequestDTO> reserve(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.reserve(id));
    }

}
