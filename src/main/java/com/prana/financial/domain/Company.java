package com.prana.financial.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_phoneNumber")
    private String companyPhoneNumber;


    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "company_address")
    private String companyAddress;


    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_phoneNumber")
    private String managerPhoneNumber;

    @Column(name = "manager_birthday")
    private String managerBirthday;


    @JoinColumn(name = "company_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;


    @JoinColumn(name = "company_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<TaxConfig> taxConfigs;

    @JoinColumn(name = "company_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reward> rewards;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "user_id", columnDefinition = "bigint")
    private long userId;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
    }

    public String getManagerBirthday() {
        return managerBirthday;
    }

    public void setManagerBirthday(String managerBirthday) {
        this.managerBirthday = managerBirthday;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<TaxConfig> getTaxConfigs() {
        return taxConfigs;
    }

    public void setTaxConfigs(List<TaxConfig> taxConfigs) {
        this.taxConfigs = taxConfigs;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id.equals(company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public void initiatePatch(Company company) {
        this.companyAddress = company.getCompanyAddress();
        this.companyPhoneNumber = company.getCompanyPhoneNumber();
        this.name = company.getName();
        this.managerName = company.getManagerName();
        preUpdate();
        this.managerPhoneNumber = company.getManagerPhoneNumber();
        this.postalCode = company.getPostalCode();
        this.managerBirthday = company.getManagerBirthday();
        this.userId = company.getUserId();
    }


    public void initiatePut(Company company) {

        initiatePatch(company);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
}
