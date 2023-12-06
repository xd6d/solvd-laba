package com.solvd.laba.block1.oop.model.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EnterpriseType {
    PRIVATE("Private enterprise", 0.2),
    COLLECTIVE_OWNERSHIP("Enterprise of collective ownership", 0.2),
    COMMUNAL("Communal enterprise", 0.1),
    STATE("State enterprise", 0);

    final Logger LOGGER = LogManager.getLogger(EnterpriseType.class);

    final String fullName;

    final double commission;

    {
        LOGGER.debug("Initializing EnterpriseType: " + this);
    }

    EnterpriseType(String fullName, double commission) {
        this.fullName = fullName;
        this.commission = commission;
    }

    public String getFullName() {
        return fullName;
    }

    public double getCommission() {
        return commission;
    }
}
