package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.model.enums.EnterpriseType;
import com.solvd.laba.block1.oop.model.users.UserAccount;

public class Organization {
    private String name;
    private UserAccount creator;
    private EnterpriseType enterpriseType;

    public Organization(String name, UserAccount creator, EnterpriseType enterpriseType) {
        this.name = name;
        this.creator = creator;
        this.enterpriseType = enterpriseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getCreator() {
        return creator;
    }

    public void setCreator(UserAccount user) {
        this.creator = user;
    }

    @Override
    public String toString() {
        return "Organization{name='" + name + "'}";
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
}
