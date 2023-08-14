package com.example.ErpIppo.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="EMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IDEmpresa;
    private String Nome;
    private String RazaoSocial;
    private String NomeFantasia;

    public UUID getIDEmpresa() {
        return IDEmpresa;
    }

    public void setIDEmpresa(UUID IDEmpresa) {
        this.IDEmpresa = IDEmpresa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        NomeFantasia = nomeFantasia;
    }
}
