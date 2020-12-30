package br.com.henriquelacerda.springbootjwt.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/usuarios/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/usuarios/1").accept(MediaType.APPLICATION_JSON)
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"nome\":\"Usuario Teste\",\"precoCusto\":123.45,\"precoVenda\":432.1}")));
    }

    @Test
    public void save() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/usuarios/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nome\":\"Usuario Teste\",\"login\":\"teste\",\"senha\":\"1234\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/usuarios/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nome\":\"Usuario Teste\",\"login\":\"teste\",\"senha\":\"1234\"}"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void delete() throws Exception {

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/usuarios/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nome\":\"Usuario Teste\",\"login\":\"teste\",\"senha\":\"1234\"}"))
                .andExpect(status().isCreated()).andReturn();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode usuarioJson = mapper.readTree(result.getResponse().getContentAsString());
        String novoId = usuarioJson.get("id").asText();
        mvc.perform(MockMvcRequestBuilders.delete("/usuarios/" + novoId).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .param("id", novoId))
                .andExpect(status().isNoContent());
    }

}
