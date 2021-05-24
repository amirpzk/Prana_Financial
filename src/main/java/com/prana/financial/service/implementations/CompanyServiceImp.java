package com.prana.financial.service.implementations;

import com.prana.financial.domain.Company;
import com.prana.financial.jwt.JwtFactory;
import com.prana.financial.repository.CompanyRepository;
import com.prana.financial.service.interfaces.CompanyService;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyRepository repository;
    @Autowired
    private JwtFactory jwtFactory;
    @Autowired
    private Environment environment;

    @Override
    public List<Company> saveAll(List<Company> companies) {
        return repository.saveAll(companies);
    }

    @Override
    public List<Company> exportDataBase(List<Company> companies, String token) {
        String userId = jwtFactory.parseToken(token);
        List<Company> lastCompanies = repository.findAllByUserId(Long.parseLong(userId));
        for (Company lastCompany : lastCompanies) {
            repository.delete(lastCompany);
        }
        for (Company company : companies) {
            company.setUserId(Long.parseLong(userId));
        }
        return this.saveAll(companies);
    }

    @Override
    public List<Company> importDataBase(String token) {
        String userId = jwtFactory.parseToken(token);
        List<Company> companies = repository.findAllByUserId(Long.parseLong(userId));
        return companies;
    }
}
