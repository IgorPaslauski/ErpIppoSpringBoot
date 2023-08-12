package com.example.ErpIppo.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="COMPANY")
public class Company implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IdCompany;
    private String Name;
    private String SocialName;

    public UUID getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(UUID idCompany) {
        IdCompany = idCompany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSocialName() {
        return SocialName;
    }

    public void setSocialName(String socialName) {
        SocialName = socialName;
    }
}
