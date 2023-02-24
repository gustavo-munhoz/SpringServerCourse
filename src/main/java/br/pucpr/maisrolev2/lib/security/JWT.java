package br.pucpr.maisrolev2.lib.security;

import br.pucpr.maisrolev2.rest.users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.mapping.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class JWT {
    private static long EXPIRATION_TIME = 5 * 24 * 60 * 60 * 1000; //5 dias

    private static String SECRET = "$C&F)J@NcRfUjXn2r4u7x!A%D*G-KaPd";
    private static final String PREFIX = "Bearer";

    public static String token(User user){
        var authorities = user.getRoles();

        return PREFIX + " " + Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(EXPIRATION_TIME))
                .setSubject(user.getUsername())
                .setIssuer("maisrole")
                .addClaims(Map.of("userId", user.getId()))
                .addClaims(Map.of("authorities", authorities))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static Authentication extract(HttpServletRequest req) {
        var header = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith(PREFIX)) return null;

        var token = header.replace(PREFIX, "").trim();
        var claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        var user = claims.getSubject();
        var authorities = claims.get("authorities", ArrayList.class)
                .stream().map(o -> new SimpleGrantedAuthority(o.toString()))
                .toList();
        return user == null? null :
                UsernamePasswordAuthenticationToken.authenticated(user, claims.get("userId", Long.class), authorities);
    }
}
