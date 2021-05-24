package com.prana.financial.model.response;

import com.prana.financial.domain.Report;
import com.prana.financial.model.request.ReportRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportResponse {

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


    public ReportResponse convertDomainToModel(Report report){
        ReportResponse response = new ReportResponse();
        response.setYear(report.getYear());
        response.setMonth(report.getMonth());
        response.setExtraWorkHour(report.getExtraWorkHour());
        response.setWorkDay(report.getWorkDay());
        response.setImpureSalary(report.getImpureSalary());
        response.setWorkDayToGetTotalSalary(report.getWorkDayToGetTotalSalary());
        response.setTaxPay(report.getTaxPay());
        response.setBenefit(report.getBenefit());
        response.setCompanyId(report.getCompanyId());
        response.setDescription(report.getDescription());
        response.setEmployeeActivityForThisMonth(report.getEmployeeActivityForThisMonth());
        response.setEmployeeId(report.getEmployeeId());
        return response;
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


