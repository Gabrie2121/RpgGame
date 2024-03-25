package com.game.rpg.commom;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.game.rpg.service.AuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class JwtTokenProvider {

	private static final long EXPIRATION_TIME = 4 * 60 * 60 * 1000; // 4 horas

	private static final String key64 = "oFt3J+GfoOXZvET2hTmz7VKBj2w+Pu0RlbFq+1irnc0PTgNfZCgHjByGKdkYMZGCqcWGBwQ3sJMYMItiUUyKgQ==";
	// private static final SecretKey SECRET_KEY2 =
	// Keys.secretKeyFor(SignatureAlgorithm.HS512);
	static byte[] decodedKey = Decoders.BASE64.decode(key64);
	private static final SecretKey SECRET_KEY2 = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA512");

	private final AuthenticationService autenticacaoService;

	public JwtTokenProvider(AuthenticationService autenticacaoService) {
		this.autenticacaoService = autenticacaoService;
	}

	public String criarToken(UserDetails usuario) {
		Claims claims = Jwts.claims().setSubject(usuario.getUsername());
		claims.put("roles", usuario.getAuthorities());
		System.out.println(Encoders.BASE64.encode(SECRET_KEY2.getEncoded()));
		return Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SECRET_KEY2).compact();
	}

	public Authentication pegarAutenticacao(String token) throws Exception {
		String username = pegarUsuarioDoToken(token);
		UserDetails user = autenticacaoService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(user, user.getAuthorities());
	}

	public String pegarUsuarioDoToken(String token) {
		String nome = Jwts.parserBuilder().setSigningKey(SECRET_KEY2).build().parseClaimsJws(token).getBody()
				.getSubject();
		return nome;
	}

	public boolean validarToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(SECRET_KEY2).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String resolverToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

}