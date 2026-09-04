package com.fortec.assistencia.controllers;

import com.fortec.assistencia.controllers.dtos.LoginRequestDTO;
import com.fortec.assistencia.controllers.dtos.RegisterRequestDTO;
import com.fortec.assistencia.controllers.dtos.TokenResponseDTO;
import com.fortec.assistencia.domain.Usuario;
import com.fortec.assistencia.repositories.UsuarioRepository;
import com.fortec.assistencia.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha())
        );
        String jwt = tokenService.gerarToken(authentication);
        return ResponseEntity.ok(new TokenResponseDTO(jwt, "Bearer"));
    }

    @PostMapping("/registro")
    public ResponseEntity<Void> registro(@Valid @RequestBody RegisterRequestDTO request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("O e-mail informado já está em uso.");
        }
        
        Usuario novo = new Usuario();
        novo.setNome(request.getNome());
        novo.setEmail(request.getEmail());
        novo.setCpf(request.getCpf());
        novo.setTelefone(request.getTelefone());
        novo.setSenha(passwordEncoder.encode(request.getSenha()));
        
        usuarioRepository.save(novo);
        return ResponseEntity.ok().build();
    }
}
