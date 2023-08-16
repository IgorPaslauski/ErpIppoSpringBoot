package com.example.ErpIppo.Controller;

import ch.qos.logback.core.util.AggregationType;
import com.example.ErpIppo.DTO.UsuarioDTO;
import com.example.ErpIppo.DTO.UsuarioResponseDTO;
import com.example.ErpIppo.Service.UsuarioService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/Logar")
    public String getView(){
        return "controller/login/login";
    }

    @PostMapping("/Logar")
    @ResponseBody
    public ResponseEntity<?> logar(@RequestBody UsuarioDTO usuarioDTO)
    {
        String token = usuarioService.logar(usuarioDTO);

        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //return !(response.getUsuario() == null || response.getUsuario().isEmpty());
    }
}
