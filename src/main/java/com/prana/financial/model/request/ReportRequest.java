package com.prana.financial.model.request;

import com.prana.financial.domain.Report;

import javax.persistence.Column;

public class ReportRequest {

    private Long year;
    private long month;
    private Double extraWorkHour;
    private Integer workDay;
    private long impureSalary;
    private long workDayToGetTotalSalary;
    private long employeeId;
    private Double taxPay;
    private Double benefit;
    private long companyId;
    private String description;
    private String employeeActivityForThisMonth;


    public Report convertModelToDomain(ReportRequest request){
        Report report = new Report();
        report.setYear(request.getYear());
        report.setMonth(request.getMonth());
        report.setExtraWorkHour(request.getExtraWorkHour());
        report.setWorkDay(request.getWorkDay());
        report.setImpureSalary(request.getImpureSalary());
        report.setWorkDayToGetTotalSalary(request.getWorkDayToGetTotalSalary());
        report.setTaxPay(request.getTaxPay());
        report.setBenefit(request.getBenefit());
        report.setCompanyId(request.getCompanyId());
        report.setDescription(request.getDescription());
        report.setEmployeeActivityForThisMonth(request.getEmployeeActivityForThisMonth());
        report.setEmployeeId(request.getEmployeeId());
        return report;
    }



    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public Double getExtraWorkHour() {
        return extraWorkHour;
    }

    public void setExtraWorkHour(Double extraWorkHour) {
        this.extraWorkHour = extraWorkHour;
    }

    public Integer getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Integer workDay) {
        this.workDay = workDay;
    }

    public long getImpureSalary() {
        return impureSalary;
    }

    public void setImpureSalary(long impureSalary) {
        this.impureSalary = impureSalary;
    }

    public long getWorkDayToGetTotalSalary() {
        return workDayToGetTotalSalary;
    }

    public void setWorkDayToGetTotalSalary(long workDayToGetTotalSalary) {
        this.workDayToGetTotalSalary = workDayToGetTotalSalary;
    }

    public Double getTaxPay() {
        return taxPay;
    }

    public void setTaxPay(Double taxPay) {
        this.taxPay = taxPay;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployeeActivityForThisMonth() {
        return employeeActivityForThisMonth;
    }

    public void setEmployeeActivityForThisMonth(String employeeActivityForThisMonth) {
        this.employeeActivityForThisMonth = employeeActivityForThisMonth;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
