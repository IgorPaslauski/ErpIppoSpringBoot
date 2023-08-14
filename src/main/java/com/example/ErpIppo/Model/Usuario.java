package com.example.ErpIppo.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CUsuario;
    private String Usuario;
    private String Senha;

    public int getCUsuario() {
        return CUsuario;
    }

    public void setCUsuario(int CUsuario) {
        this.CUsuario = CUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
