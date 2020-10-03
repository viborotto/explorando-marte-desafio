package com.viborotto.explorandomarte;

import com.viborotto.explorandomarte.controller.SondaController;
import com.viborotto.explorandomarte.model.Sonda;
import com.viborotto.explorandomarte.repository.SondaRepository;
import com.viborotto.explorandomarte.service.SondaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@AutoConfigurationPackage
@SpringBootTest(classes = ExplorandoMarteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExplorandoMarteApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private MockMvc mockMvc;

    @InjectMocks
    private SondaController sondaController;

    @Mock
    private SondaRepository sondaRepository;

    @Mock
    private SondaService sondaService;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    // TODO testar logica do serviceImpl
//    @Test
//    public void sondaServiceTest(){
//        Sonda sondaRequest = new Sonda(1L,"sonda_teste", "5,5", 1, 2,"N", "LMLMLMLMM");
//        Sonda sondaResponse = new Sonda(1L,"sonda_teste", "5,5", 1, 3,"N", "LMLMLMLMM");
//
//        assertEquals(sondaResponse,sondaService.criarSonda(sondaRequest));
//    }

    @Test
    public void testGetAllSondas() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/sondas",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateSonda() {
        Sonda sonda = new Sonda();
        sonda.setNome("sonda_test");
        sonda.setTamanhoSuperficieX(5);
        sonda.setTamanhoSuperficieY(5);
        sonda.setCoordenadaX(1);
        sonda.setCoordenadaY(2);
        sonda.setDirecao("N");
        sonda.setInstrucoes("LMLMLMLMM");
        ResponseEntity<Sonda> postResponse = restTemplate.postForEntity(getRootUrl() + "/salvarSonda", sonda, Sonda.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testDeleteSonda() {
        int id = 2;
        Sonda sonda = restTemplate.getForObject(getRootUrl() + "/sondas/" + id, Sonda.class);
        assertNotNull(sonda);
        restTemplate.delete(getRootUrl() + "/deletarSonda/" + id);
        try {
            sonda = restTemplate.getForObject(getRootUrl() + "/sondas/" + id, Sonda.class);
        } catch (final Exception e) {
            assertEquals(e, HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void textIndex() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(sondaController).build();
        mockMvc.perform(get("/api/v1/sondas"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void textIndexDeleteSonda() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(sondaController).build();
        mockMvc.perform(get("/deleteSonda/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void textIndexSalvarSonda() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(sondaController).build();
        mockMvc.perform(post("/savedSonda", 1))
                .andExpect(status().isCreated())
                .andExpect(view().name("index"));
    }

}
