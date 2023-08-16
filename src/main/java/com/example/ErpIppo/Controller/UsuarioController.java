package com.example.ErpIppo.Controller;

import com.example.ErpIppo.DTO.UsuarioDTO;
import com.example.ErpIppo.DTO.UsuarioResponseDTO;
import com.example.ErpIppo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/Usuario")
    public String view(){
        return "Controller/usuario/usuario";
    }

    @PostMapping("/CriarUsuario")
    @ResponseBody
    public UsuarioResponseDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.criarUsuario(usuarioDTO);
    }
}
