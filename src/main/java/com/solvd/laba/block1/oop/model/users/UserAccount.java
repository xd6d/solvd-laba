package com.solvd.laba.block1.oop.model.users;

import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.NumberGenerator;
import com.solvd.laba.block1.oop.model.order.Bucket;

import java.util.Calendar;

public class UserAccount extends AbstractAccount {
    protected Bucket bucket;
    protected boolean blocked = false;
    protected Calendar birthDate;

    public UserAccount(String name, String lastName, String email, String contactPhone, String password, Calendar birthDate) {
        super(name, lastName, email, contactPhone, password);
        this.birthDate = birthDate;
    }

    public UserAccount(String name, String lastName, String email, String contactPhone, String password, Calendar birthDate,
                       NumberGenerator<Integer> numberGenerator) {
        super(name, lastName, email, contactPhone, password, numberGenerator);
        this.birthDate = birthDate;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAdult() {
        return System.currentTimeMillis() - birthDate.getTimeInMillis() > Defaults.YEARS_IN_MILLIS_18;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', lastName='" + lastName + "', email='" + email +
                "', contactPhone='" + contactPhone + "', blocked=" + blocked + "}";
    }
}
