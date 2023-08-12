package Controller;

import Model.Company;
import Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("company")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;
    @GetMapping("ListCompany")
    public List<Company> ListCompany()
    {
        return repository.findAll();
    }
}
