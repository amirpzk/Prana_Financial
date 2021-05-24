package com.prana.financial.model.response;

import com.prana.financial.domain.Company;
import com.prana.financial.domain.Employee;
import com.prana.financial.domain.Reward;
import com.prana.financial.domain.TaxConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyResponse {


    private String name;
    private String companyPhoneNumber;
    private String postalCode;
    private String companyAddress;
    private String managerName;
    private String managerPhoneNumber;
    private String managerBirthday;

    private List<EmployeeResponse> employees;

    private List<TaxConfigResponse> taxConfigs;

    private List<RewardResponse> rewards;

    private Date createdDate;

    private Date updatedDate;


    public CompanyResponse convertDomainToModel(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setCompanyAddress(company.getCompanyAddress());
        companyResponse.setCompanyPhoneNumber(company.getCompanyPhoneNumber());
        companyResponse.setCreatedDate(company.getCreatedDate());
        companyResponse.setManagerBirthday(company.getManagerBirthday());
        companyResponse.setManagerName(company.getManagerName());
        companyResponse.setName(company.getName());
        companyResponse.setPostalCode(company.getPostalCode());
        companyResponse.setUpdatedDate(company.getUpdatedDate());
        companyResponse.setManagerPhoneNumber(company.getManagerPhoneNumber());
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        if (company.getEmployees() != null) {
            for (Employee employee : company.getEmployees()) {
                employeeResponses.add(new EmployeeResponse().convertDomainToModel(employee));
            }
            companyResponse.setEmployees(employeeResponses);
        }
        List<TaxConfigResponse> taxConfigResponses = new ArrayList<>();
        if (company.getTaxConfigs() != null) {
            for (TaxConfig taxConfig : company.getTaxConfigs()) {
                taxConfigResponses.add(new TaxConfigResponse().convertDomainToModel(taxConfig));
            }
            companyResponse.setTaxConfigs(taxConfigResponses);
        }
        List<RewardResponse> rewardResponses = new ArrayList<>();
        if (company.getRewards() != null){
            for (Reward reward : company.getRewards()) {
                rewardResponses.add(new RewardResponse().convertDomainToModel(reward));
            }
            companyResponse.setRewards(rewardResponses);
        }

        return companyResponse;
    }

    public Page<CompanyResponse> convertDomainToModel(Page<Company> companyPage, Pageable pageable) {
        List<CompanyResponse> companies = new ArrayList<>();
        for (Company company : companyPage) {
            companies.add(new CompanyResponse().convertDomainToModel(company));
        }
        return new PageImpl<>(companies, pageable, companyPage.getTotalElements());
    }



    public Iterable<CompanyResponse> convertDomainToModel(Iterable<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        companies.forEach(d -> companyResponses.add(convertDomainToModel(d)));
        return companyResponses;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public List<RewardResponse> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardResponse> rewards) {
        this.rewards = rewards;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public String getManagerBirthday() {
        return managerBirthday;
    }

    public void setManagerBirthday(String managerBirthday) {
        this.managerBirthday = managerBirthday;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    public List<TaxConfigResponse> getTaxConfigs() {
        return taxConfigs;
    }

    public void setTaxConfigs(List<TaxConfigResponse> taxConfigs) {
        this.taxConfigs = taxConfigs;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
