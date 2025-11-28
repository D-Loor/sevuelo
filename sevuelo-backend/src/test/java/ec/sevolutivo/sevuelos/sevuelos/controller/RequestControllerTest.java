package ec.sevolutivo.sevuelos.sevuelos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.sevolutivo.sevuelos.sevuelos.dto.RequestDTO;
import ec.sevolutivo.sevuelos.sevuelos.enumeration.RequestStatus;
import ec.sevolutivo.sevuelos.sevuelos.entity.Request;
import ec.sevolutivo.sevuelos.sevuelos.repository.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class RequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RequestRepository requestRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private RequestDTO requestDTO;
    private Request completeRequest;

    @BeforeEach
    void setUp() {
        requestRepository.deleteAll();

        requestDTO = new RequestDTO();
        requestDTO.setPassenger("Johanan");
        requestDTO.setDestination("Quito");

        completeRequest = new Request();
        completeRequest.setPassenger("Nicolas");
        completeRequest.setDestination("Cuenca");
        completeRequest.setStatus(RequestStatus.NEW);
    }

    @Test
    void shouldCreateARequest() throws Exception {
        int sizeBefore = requestRepository.findAll().size();

        mockMvc.perform(post("/requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated());

        List<Request> list = requestRepository.findAll();
        assertThat(list).hasSize(sizeBefore + 1);

        Request last = list.get(list.size() - 1);

        assertEquals(requestDTO.getPassenger(), last.getPassenger());
        assertEquals(requestDTO.getDestination(), last.getDestination());
        assertEquals(RequestStatus.NEW, last.getStatus());
    }

    @Test
    void shouldGetAllRequests() throws Exception {
        Request saved = requestRepository.saveAndFlush(completeRequest);

        mockMvc.perform(get("/requests")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(hasItem(saved.getId().intValue())))
                .andExpect(jsonPath("$[*].passenger").value(hasItem(saved.getPassenger())))
                .andExpect(jsonPath("$[*].destination").value(hasItem(saved.getDestination())))
                .andExpect(jsonPath("$[*].status").value(hasItem(saved.getStatus().toString())));
    }

    @Test
    void shouldGetRequestById() throws Exception {
        Request saved = requestRepository.saveAndFlush(completeRequest);

        mockMvc.perform(get("/requests/{id}", saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(saved.getId()))
                .andExpect(jsonPath("$.passenger").value(saved.getPassenger()))
                .andExpect(jsonPath("$.destination").value(saved.getDestination()))
                .andExpect(jsonPath("$.status").value(saved.getStatus().toString()));
    }

    @Test
    void shouldChangeStatusToReserve() throws Exception {
        Request saved = requestRepository.saveAndFlush(completeRequest);

        RequestDTO dto = new RequestDTO(
                saved.getId(),
                saved.getPassenger(),
                saved.getDestination(),
                saved.getStatus()
        );

        mockMvc.perform(put("/requests/reserve/{id}", saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        Request updated = requestRepository.findById(saved.getId()).orElseThrow();
        assertEquals(RequestStatus.RESERVED, updated.getStatus());
    }

}
