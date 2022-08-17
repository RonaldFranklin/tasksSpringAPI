package br.com.five.tasks.controller;

import br.com.five.tasks.controller.dto.TokenDto;
import br.com.five.tasks.service.TokenService;
import br.com.five.tasks.user.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form){

        UsernamePasswordAuthenticationToken loginData = form.convertObject();

        try {
            Authentication authentication = authenticationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
