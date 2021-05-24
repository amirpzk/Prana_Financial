package com.prana.financial.controller;

import com.prana.financial.domain.Company;
import com.prana.financial.model.request.CompanyRequest;
import com.prana.financial.model.response.CompanyResponse;
import com.prana.financial.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;



    @PostMapping("/export-database")
    public ResponseEntity<List<Company>> exportUserDatabase(@RequestBody List<CompanyRequest> companies,
                                                   @RequestHeader("token") String token){
        List<Company> companyList = new ArrayList<>();
        for (CompanyRequest company : companies) {
            companyList.add(new CompanyRequest().convertModelToDomain(company));
        }
        List<Company> saved = service.exportDataBase(companyList, token);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/import-database")
    public ResponseEntity<List<CompanyResponse>> importUserDatabase(@RequestHeader("token") String token){
        List<Company> companies = service.importDataBase(token);
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company : companies) {
            responses.add(new CompanyResponse().convertDomainToModel(company));
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
