package com.example.ErpIppo.Service;

import com.example.ErpIppo.DTO.UsuarioDTO;
import com.example.ErpIppo.DTO.UsuarioResponseDTO;
import com.example.ErpIppo.Model.Usuario;
import com.example.ErpIppo.Repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        Usuario savedUsuario = usuarioRepository.save(usuario);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(responseDTO, savedUsuario);

        return responseDTO;
    }

    public String logar(UsuarioDTO usuarioDTO)
    {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        Usuario savedUsuario = usuarioRepository.logar(usuario.getUsuario(), usuario.getSenha());

        if(savedUsuario == null || savedUsuario.getCUsuario() == 0)
        {
            return "";
        }

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(savedUsuario, responseDTO);

        return generateJwtToken(usuarioDTO);
    }

    private String generateJwtToken(UsuarioDTO usuarioDTO) {
        return Jwts.builder()
                .setSubject(usuarioDTO.getUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
