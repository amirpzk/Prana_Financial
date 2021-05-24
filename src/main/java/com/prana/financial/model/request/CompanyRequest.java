package com.prana.financial.model.request;

import com.prana.financial.domain.Company;
import com.prana.financial.domain.Employee;
import com.prana.financial.domain.Reward;
import com.prana.financial.domain.TaxConfig;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRequest {

    private String name;
    private String companyPhoneNumber;
    private String postalCode;
    private String companyAddress;
    private String managerName;
    private String managerPhoneNumber;
    private String managerBirthday;
    private List<EmployeeRequest> employees;
    private List<TaxConfigRequest> taxConfigs;
    private List<RewardRequest> rewards;


    public CompanyRequest() {
        employees = new ArrayList<>();
        taxConfigs = new ArrayList<>();
        rewards = new ArrayList<>();
    }

    public Company convertModelToDomain(CompanyRequest request){
        Company company = new Company();
        company.setName(request.getName());
        company.setCompanyPhoneNumber(request.getCompanyPhoneNumber());
        company.setPostalCode(request.getPostalCode());
        company.setCompanyAddress(request.getCompanyAddress());
        company.setManagerPhoneNumber(request.getManagerPhoneNumber());
        company.setManagerName(request.getManagerName());
        company.setManagerBirthday(request.getManagerBirthday());

        List<Employee> employeesList = new ArrayList<>();
        for (EmployeeRequest employee : request.getEmployees()) {
            employeesList.add(new EmployeeRequest().convertModelToDomain(employee));
        }
        company.setEmployees(employeesList);

        List<TaxConfig> taxConfigsList = new ArrayList<>();
        for (TaxConfigRequest taxConfig : request.getTaxConfigs()) {
            taxConfigsList.add(new TaxConfigRequest().convertModelToDomain(taxConfig));
        }
        company.setTaxConfigs(taxConfigsList);

        List<Reward> rewardList = new ArrayList<>();
        for (RewardRequest rewardRequest : request.getRewards()) {
            rewardList.add(new RewardRequest().convertModelToDomain(rewardRequest));
        }
        company.setRewards(rewardList);

        return company;
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

    public List<RewardRequest> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardRequest> rewards) {
        this.rewards = rewards;
    }

    public String getManagerBirthday() {
        return managerBirthday;
    }

    public void setManagerBirthday(String managerBirthday) {
        this.managerBirthday = managerBirthday;
    }

    public List<EmployeeRequest> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeRequest> employees) {
        this.employees = employees;
    }

    public List<TaxConfigRequest> getTaxConfigs() {
        return taxConfigs;
    }

    public void setTaxConfigs(List<TaxConfigRequest> taxConfigs) {
        this.taxConfigs = taxConfigs;
    }

}
