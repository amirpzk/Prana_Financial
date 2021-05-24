package com.prana.financial.model.response;

import com.prana.financial.domain.Reward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RewardResponse {

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



    public RewardResponse convertDomainToModel(Reward reward) {
        RewardResponse rewardResponse = new RewardResponse();
        rewardResponse.setEmployeeId(reward.getEmployeeId());
        rewardResponse.setSumDayOfWork(reward.getSumDayOfWork());
        rewardResponse.setYear(reward.getYear());
        rewardResponse.setImpureSalary(reward.getImpureSalary());
        rewardResponse.setImpureReward(reward.getImpureReward());
        rewardResponse.setSanawat(reward.getSanawat());
        rewardResponse.setSumDayOfWork(reward.getSumDayOfWork());
        rewardResponse.setSumOfPureRewardAndSanawat(reward.getSumOfPureRewardAndSanawat());
        rewardResponse.setCompanyId(reward.getCompanyId());
        rewardResponse.setLowestSalaryForThisYear(reward.getLowestSalaryForThisYear());
        rewardResponse.setRewardTax(reward.getRewardTax());
        return rewardResponse;
    }

    public Page<RewardResponse> convertDomainToModel(Page<Reward> rewardPage, Pageable pageable) {
        List<RewardResponse> rewards = new ArrayList<>();
        for (Reward reward : rewardPage) {
            rewards.add(new RewardResponse().convertDomainToModel(reward));
        }
        return new PageImpl<>(rewards, pageable, rewardPage.getTotalElements());

    }



    public Iterable<RewardResponse> convertDomainToModel(Iterable<Reward> rewards) {
        List<RewardResponse> rewardResponses = new ArrayList<>();
        rewards.forEach(d -> rewardResponses.add(convertDomainToModel(d)));
        return rewardResponses;
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

    public void setSanawat(Double sanawat) {
        this.sanawat = sanawat;
    }

    public Double getSumOfPureRewardAndSanawat() {
        return sumOfPureRewardAndSanawat;
    }

    public void setSumOfPureRewardAndSanawat(Double sumOfPureRewardAndSanawat) {
        this.sumOfPureRewardAndSanawat = sumOfPureRewardAndSanawat;
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
}
