package com.ecommerce.ibg.model.oracle;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
public class UserOracle {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
//    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false, precision = 10, scale = 0)
    String id;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "CREATED_TIME")
    private Date createDate;

    @Transient
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
