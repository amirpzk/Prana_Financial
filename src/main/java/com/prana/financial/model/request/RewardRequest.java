package com.prana.financial.model.request;

import com.prana.financial.domain.Reward;

import javax.persistence.Column;

public class RewardRequest {

    private long employeeId;
    private long sumDayOfWork;
    private long year;
    private long impureSalary;
    private Double impureReward;
    private Double sanawat;
    private Double sumOfPureRewardAndSanawat;
    private long companyId;
    private double lowestSalaryForThisYear;
    private Double rewardTax;



    public Reward convertModelToDomain(RewardRequest request){
        Reward reward = new Reward();
        reward.setEmployeeId(request.getEmployeeId());
        reward.setSumDayOfWork(request.getSumDayOfWork());
        reward.setYear(request.getYear());
        reward.setImpureSalary(request.getImpureSalary());
        reward.setImpureReward(request.getImpureReward());
        reward.setSanawat(request.getSanawat());
        reward.setLowestSalaryForThisYear(request.getLowestSalaryForThisYear());
        reward.setRewardTax(request.getRewardTax());
        reward.setSumOfPureRewardAndSanawat(request.getSumOfPureRewardAndSanawat());
        reward.setCompanyId(request.getCompanyId());
        return reward;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
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

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getImpureSalary() {
        return impureSalary;
    }

    public void setImpureSalary(long impureSalary) {
        this.impureSalary = impureSalary;
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

    public double getLowestSalaryForThisYear() {
        return lowestSalaryForThisYear;
    }

    public void setLowestSalaryForThisYear(double lowestSalaryForThisYear) {
        this.lowestSalaryForThisYear = lowestSalaryForThisYear;
    }

    public Double getRewardTax() {
        return rewardTax;
    }

    public void setRewardTax(Double rewardTax) {
        this.rewardTax = rewardTax;
    }

    public void setSanawat(Double sanawat) {
        this.sanawat = sanawat;
    }

    public Double getSumOfPureRewardAndSanawat() {
        return sumOfPureRewardAndSanawat;
    }

    public void setSumOfPureRewardAndSanawat(Double sumOfPureRewardAndSanawat) {
        this.sumOfPureRewardAndSanawat = sumOfPureRewardAndSanawat;
    }
}
