package com.adkr38.app.filters;

import org.springframework.security.web.authentication.*;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
// import com.adkr38.app.models.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.fasterxml.jackson.databind.ObjectMapper;

class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

  private final AuthenticationManager authenticationManager;

  public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
    this.authenticationManager = authenticationManager;
  }
  
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

    return authenticationManager.authenticate(authenticationToken);

  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,FilterChain chain, Authentication authResult) throws IOException,ServletException{

    User user = (User) authResult.getPrincipal();
    Algorithm algorithm = Algorithm.HMAC256("secret");
    String accessToken= JWT.create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 10000))
            .withIssuer(request.getRequestURL().toString())
            .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
            .sign(algorithm);

    Map<String, String> tokens = new HashMap<>();
    tokens.put("access_token", accessToken);
    // Setting the response type to application/json
    response.setContentType(APPLICATION_JSON_VALUE);
    // Writing the token as response
    new ObjectMapper().writeValue(response.getOutputStream(), tokens);

  }




}
