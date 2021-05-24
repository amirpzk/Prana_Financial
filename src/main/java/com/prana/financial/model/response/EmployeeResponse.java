package com.prana.financial.model.response;

import com.prana.financial.domain.Employee;
import com.prana.financial.domain.Report;
import com.prana.financial.model.request.ReportRequest;
import com.prana.financial.model.request.RewardRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeResponse {

    private String name;
    private String nationalCode;
    private String identityNumber;
    private String fathersName;
    private String birthDay;
    private String cardNumber;
    private String shebaNumber;
    private String banksName;
    private String job;
    private boolean isFired;
    private List<ReportResponse> reports;
    private long companyId;
    private String accountNumber;
    private String insuranceNumber;
    private Date createdDate;
    private Date updatedDate;

    public EmployeeResponse convertDomainToModel(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setBanksName(employee.getBanksName());
        employeeResponse.setBirthDay(employee.getBirthDay());
        employeeResponse.setCardNumber(employee.getCardNumber());
        employeeResponse.setCompanyId(employee.getCompanyId());
        employeeResponse.setCreatedDate(employee.getCreatedDate());
        employeeResponse.setFathersName(employee.getFathersName());
        employeeResponse.setIdentityNumber(employee.getIdentityNumber());
        employeeResponse.setName(employee.getName());
        employeeResponse.setShebaNumber(employee.getShebaNumber());
        employeeResponse.setUpdatedDate(employee.getUpdatedDate());
        employeeResponse.setFired(employee.isFired());
        employeeResponse.setNationalCode(employee.getNationalCode());
        employeeResponse.setJob(employee.getJob());
        employeeResponse.setAccountNumber(employee.getAccountNumber());
        employeeResponse.setInsuranceNumber(employee.getInsuranceNumber());
        List<ReportResponse> reportResponses = new ArrayList<>();
        if (employee.getReports() != null) {
            for (Report report : employee.getReports()) {
                reportResponses.add(new ReportResponse().convertDomainToModel(report));
            }
            employeeResponse.setReports(reportResponses);
        }
        return employeeResponse;
    }

    public Page<EmployeeResponse> convertDomainToModel(Page<Employee> employeePage, Pageable pageable) {
        List<EmployeeResponse> employees = new ArrayList<>();
        for (Employee employee : employeePage) {
            employees.add(new EmployeeResponse().convertDomainToModel(employee));
        }
        return new PageImpl<>(employees, pageable, employeePage.getTotalElements());
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getShebaNumber() {
        return shebaNumber;
    }

    public void setShebaNumber(String shebaNumber) {
        this.shebaNumber = shebaNumber;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBanksName() {
        return banksName;
    }

    public void setBanksName(String banksName) {
        this.banksName = banksName;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public List<ReportResponse> getReports() {
        return reports;
    }

    public void setReports(List<ReportResponse> reports) {
        this.reports = reports;
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
