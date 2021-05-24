package com.prana.financial.model.request;

import com.prana.financial.domain.Employee;
import com.prana.financial.domain.Report;
import com.prana.financial.domain.Reward;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRequest {

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
    private List<ReportRequest> reports;
    private List<RewardRequest> rewards;
    private long companyId;
    private String accountNumber;
    private String insuranceNumber;


    public EmployeeRequest() {
        reports = new ArrayList<>();
        rewards = new ArrayList<>();
    }

    public Employee convertModelToDomain(EmployeeRequest request){
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setNationalCode(request.getNationalCode());
        employee.setIdentityNumber(request.getIdentityNumber());
        employee.setFathersName(request.getFathersName());
        employee.setBirthDay(request.getBirthDay());
        employee.setCardNumber(request.getCardNumber());
        employee.setShebaNumber(request.getShebaNumber());
        employee.setBanksName(request.getBanksName());
        employee.setCompanyId(request.getCompanyId());
        employee.setJob(request.getJob());
        employee.setFired(request.isFired);
        employee.setAccountNumber(request.accountNumber);
        employee.setInsuranceNumber(request.insuranceNumber);

        List<Report> reportsList = new ArrayList<>();
        for (ReportRequest report : request.getReports()) {
            reportsList.add(new ReportRequest().convertModelToDomain(report));
        }
        employee.setReports(reportsList);

        List<Reward> rewardsList = new ArrayList<>();
        for (RewardRequest reward : request.getRewards()) {
            rewardsList.add(new RewardRequest().convertModelToDomain(reward));
        }
        employee.setRewards(rewardsList);

        return employee;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
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

    public String getNationalCode() {
        return nationalCode;
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

    public String getBanksName() {
        return banksName;
    }

    public void setBanksName(String banksName) {
        this.banksName = banksName;
    }

    public List<ReportRequest> getReports() {
        return reports;
    }

    public void setReports(List<ReportRequest> reports) {
        this.reports = reports;
    }

    public List<RewardRequest> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardRequest> rewards) {
        this.rewards = rewards;
    }
}
