package com.prana.financial.model.response;

import com.prana.financial.domain.TaxConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaxConfigResponse {

    private Long min;

    private Long max;

    private Long year;

    private Double percent;

    private long companyId;
    private Double benefit;


    private Date createdDate;

    private Date updatedDate;


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMin() {
        return min;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public TaxConfigResponse convertDomainToModel(TaxConfig taxConfig) {
        TaxConfigResponse taxConfigResponse = new TaxConfigResponse();
        taxConfigResponse.setCompanyId(taxConfig.getCompanyId());
        taxConfigResponse.setCreatedDate(taxConfig.getCreatedDate());
        taxConfigResponse.setMax(taxConfig.getMax());
        taxConfigResponse.setMin(taxConfig.getMin());
        taxConfigResponse.setPercent(taxConfig.getPercent());
        taxConfigResponse.setUpdatedDate(taxConfig.getUpdatedDate());
        taxConfigResponse.setYear(taxConfig.getYear());
        taxConfigResponse.setBenefit(taxConfig.getBenefit());
        return taxConfigResponse;
    }

    public Page<TaxConfigResponse> convertDomainToModel(Page<TaxConfig> taxConfigPage, Pageable pageable) {
        List<TaxConfigResponse> taxConfigs = new ArrayList<>();
        for (TaxConfig taxConfig : taxConfigPage) {
            taxConfigs.add(new TaxConfigResponse().convertDomainToModel(taxConfig));
        }
        return new PageImpl<>(taxConfigs, pageable, taxConfigPage.getTotalElements());
    }



    public Iterable<TaxConfigResponse> convertDomainToModel(Iterable<TaxConfig> taxConfigs) {
        List<TaxConfigResponse> taxConfigResponses = new ArrayList<>();
        taxConfigs.forEach(d -> taxConfigResponses.add(convertDomainToModel(d)));
        return taxConfigResponses;
    }
}
