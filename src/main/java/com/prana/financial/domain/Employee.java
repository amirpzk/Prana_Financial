package com.prana.financial.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "national_code")
    private String nationalCode;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "job")
    private String job;

    @Column(name = "is_Fired")
    private boolean isFired;

    @Column(name = "father_name")
    private String fathersName;

    @Column(name = "birthday")
    private String birthDay;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "sheba_number")
    private String shebaNumber;

    @Column(name = "bank_name")
    private String banksName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "company_id")
    private long companyId;

    @JoinColumn(name = "employee_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;

    @JoinColumn(name = "employee_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reward> rewards;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getShebaNumber() {
        return shebaNumber;
    }

    public void setShebaNumber(String shebaNumber) {
        this.shebaNumber = shebaNumber;
    }

    public String getBanksName() {
        return banksName;
    }

    public void setBanksName(String banksName) {
        this.banksName = banksName;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void initiatePatch(Employee employee) {
        this.name = employee.getName();
        this.accountNumber = employee.getAccountNumber();
        this.insuranceNumber = employee.getInsuranceNumber();
        this.birthDay = employee.getBirthDay();
        this.fathersName = employee.getFathersName();
        preUpdate();
    }

    public void initiatePut(Employee employee) {
        initiatePatch(employee);
        this.banksName = employee.getBanksName();
        this.nationalCode = employee.getNationalCode();
        this.identityNumber = employee.getIdentityNumber();
        this.shebaNumber = employee.getShebaNumber();
        this.cardNumber = employee.getCardNumber();
        this.companyId = employee.getCompanyId();
        this.job = employee.getJob();
    }
}
