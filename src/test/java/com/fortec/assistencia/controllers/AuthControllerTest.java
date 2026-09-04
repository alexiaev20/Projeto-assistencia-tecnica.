package com.fortec.assistencia.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortec.assistencia.controllers.dtos.LoginRequestDTO;
import com.fortec.assistencia.controllers.dtos.RegisterRequestDTO;
import com.fortec.assistencia.domain.Usuario;
import com.fortec.assistencia.repositories.UsuarioRepository;
import com.fortec.assistencia.security.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void deveRetornarBadRequestQuandoRegistroEstiverInvalido() throws Exception {
        RegisterRequestDTO request = new RegisterRequestDTO();
        request.setNome(""); 

        mockMvc.perform(post("/api/auth/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deveRegistrarUsuarioComSucesso() throws Exception {
        RegisterRequestDTO request = new RegisterRequestDTO();
        request.setNome("Maria Silva");
        request.setEmail("maria@email.com");
        request.setSenha("123456");
        request.setCpf("12345678900");

        Mockito.when(usuarioRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());
        Mockito.when(passwordEncoder.encode(request.getSenha())).thenReturn("hashedSenha");

        mockMvc.perform(post("/api/auth/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
