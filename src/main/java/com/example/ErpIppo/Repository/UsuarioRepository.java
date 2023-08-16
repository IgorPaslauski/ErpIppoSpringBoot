package com.example.ErpIppo.Repository;

import com.example.ErpIppo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM Usuario U WHERE U.USUARIO = ?1 AND U.SENHA = ?2", nativeQuery = true)
    Usuario logar(String usuario, String senha);
}
