package com.prana.financial.model.request;

import com.prana.financial.domain.TaxConfig;

import javax.persistence.Column;

public class TaxConfigRequest {

    private Long min;
    private Long max;
    private Long year;
    private Double percent;
    private long companyId;
    private Double benefit;



    public TaxConfig convertModelToDomain(TaxConfigRequest request) {
        TaxConfig taxConfig = new TaxConfig();
        taxConfig.setMin(request.getMin());
        taxConfig.setMax(request.getMax());
        taxConfig.setYear(request.getYear());
        taxConfig.setPercent(request.getPercent());
        taxConfig.setCompanyId(request.getCompanyId());
        taxConfig.setBenefit(request.getBenefit());
        return taxConfig;
    }

    public Long getMin() {
        return min;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}