package com.prana.financial.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "year")
    private Long year;

    @Column(name = "month")
    private long month;

    @Column(name = "extra_work_hour")
    private Double extraWorkHour;

    @Column(name = "work_day")
    private Integer workDay;

    @Column(name = "impure_salary")
    private long impureSalary;

    @Column(name = "employee_id")
    private long employeeId;


    @Column(name = "work_day_to_get_total_salary_this_month")
    private long workDayToGetTotalSalary;

    @Column(name = "tax_pay")
    private Double taxPay;

    @Column(name = "benefit")
    private Double benefit;

    @Column(name = "company_id")
    private long companyId;

    @Column(name = "description")
    private String description;

    @Column(name = "employee_activity_for_this_month")
    private String employeeActivityForThisMonth;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id.equals(report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void initiatePatch(Report report) {
        this.extraWorkHour = report.getExtraWorkHour();
        this.impureSalary = report.getImpureSalary();
        preUpdate();
    }

    public void initiatePut(Report report) {
        initiatePatch(report);
        this.year = report.getYear();
        this.month = report.getMonth();
        this.employeeId = report.getEmployeeId();
        this.workDay = report.getWorkDay();
        this.workDayToGetTotalSalary = report.getWorkDayToGetTotalSalary();
        this.impureSalary = report.getImpureSalary();
        this.employeeActivityForThisMonth=report.getEmployeeActivityForThisMonth();
        this.description=report.getDescription();
        this.benefit=report.getBenefit();
    }



}
