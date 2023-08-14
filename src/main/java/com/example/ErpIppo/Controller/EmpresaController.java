package com.example.ErpIppo.Controller;

import com.example.ErpIppo.Model.Empresa;
import com.example.ErpIppo.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("Empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;
    @GetMapping("ListarEmpresa")
    public List<Empresa> ListarEmpresa()
    {
        return repository.findAll();
    }
}
