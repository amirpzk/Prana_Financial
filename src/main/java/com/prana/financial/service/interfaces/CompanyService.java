package com.prana.financial.service.interfaces;

import com.prana.financial.domain.Company;

import java.util.List;

public interface CompanyService {

    List<Company> saveAll(List<Company> companies);

    List<Company> exportDataBase(List<Company> companies, String token);

    List<Company> importDataBase(String token);

}
