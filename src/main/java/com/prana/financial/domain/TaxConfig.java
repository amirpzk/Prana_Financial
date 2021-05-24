package com.prana.financial.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tax_config")
public class TaxConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "min")
    private Long min;

    @Column(name = "max")
    private Long max;

    @Column(name = "year")
    private Long year;

    @Column(name = "percent")
    private Double percent;

    @Column(name = "company_id")
    private long companyId;

    @Column(name = "benefit")
    private Double benefit;

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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxConfig taxConfig = (TaxConfig) o;
        return id.equals(taxConfig.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void initiatePatch(TaxConfig taxConfig) {

        this.max = taxConfig.getMax();
        this.min = taxConfig.getMin();
        this.year = taxConfig.getYear();
        this.percent = taxConfig.getPercent();
        this.benefit = taxConfig.getBenefit();
        preUpdate();

    }

    public void initiatePut(TaxConfig taxConfig) {
        initiatePatch(taxConfig);
        this.companyId = taxConfig.getCompanyId();


    }
}
