package com.prana.financial.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "insurance_and_reward")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "sum_day_of_work")
    private long sumDayOfWork;

    @Column(name = "year")
    private long year;


    @Column(name = "impure_salary")
    private long impureSalary;

    @Column(name = "lowest_salary_for_this_year")
    private double lowestSalaryForThisYear;

    @Column(name = "impure_reward")
    private Double impureReward;

    @Column(name = "sanawat")
    private Double sanawat;


    @Column(name = "reward_tax")
    private Double rewardTax;


    @Column(name = "sum_of_pureReward_sanawat")
    private Double sumOfPureRewardAndSanawat;

    @Column(name = "company_id" )
    private long companyId;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getSumDayOfWork() {
        return sumDayOfWork;
    }

    public void setSumDayOfWork(long sumDayOfWork) {
        this.sumDayOfWork = sumDayOfWork;
    }

    public long getImpureSalary() {
        return impureSalary;
    }

    public void setImpureSalary(long impureSalary) {
        this.impureSalary = impureSalary;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Double getImpureReward() {
        return impureReward;
    }

    public void setImpureReward(Double impureReward) {
        this.impureReward = impureReward;
    }

    public Double getSanawat() {
        return sanawat;
    }

    public void setSanawat(Double sanawat) {
        this.sanawat = sanawat;
    }

    public Double getRewardTax() {
        return rewardTax;
    }

    public void setRewardTax(Double rewardTax) {
        this.rewardTax = rewardTax;
    }

    public double getLowestSalaryForThisYear() {
        return lowestSalaryForThisYear;
    }

    public void setLowestSalaryForThisYear(double lowestSalaryForThisYear) {
        this.lowestSalaryForThisYear = lowestSalaryForThisYear;
    }

    public Double getSumOfPureRewardAndSanawat() {
        return sumOfPureRewardAndSanawat;
    }

    public void setSumOfPureRewardAndSanawat(Double sumOfPureRewardAndSanawat) {
        this.sumOfPureRewardAndSanawat = sumOfPureRewardAndSanawat;
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

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward that = (Reward) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public void initiatePatch(Reward reward) {

        this.employeeId = reward.getEmployeeId();
        this.sumDayOfWork = reward.getSumDayOfWork();
        this.year = reward.getYear();
        preUpdate();
    }

    public void initiatePut(Reward reward) {
        initiatePatch(reward);
        this.impureReward = reward.getImpureReward();
        this.lowestSalaryForThisYear = reward.getLowestSalaryForThisYear();
        this.sanawat = reward.getSanawat();
        this.rewardTax = reward.getRewardTax();
        this.sumOfPureRewardAndSanawat = reward.getSumOfPureRewardAndSanawat();
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
