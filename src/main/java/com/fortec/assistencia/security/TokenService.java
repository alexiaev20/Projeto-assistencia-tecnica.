package com.fortec.assistencia.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    // Em produção, isso deve vir de variável de ambiente
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 86400000; // 1 dia

    public String gerarToken(Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + expiration);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(key)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameUsuario(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
