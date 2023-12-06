package com.solvd.laba.block1.oop.model.users;

import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.NumberGenerator;
import com.solvd.laba.block1.oop.model.interfaces.Person;
import com.solvd.laba.block1.oop.model.interfaces.UnaryCoder;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractAccount implements Person {
    private static final UnaryCoder<String, Integer> UNARY_CODER = Defaults.STRING_UNARY_CODER;
    protected String name;
    protected String lastName;
    protected String email;
    protected String contactPhone;
    private int key;
    private String password;

    {
        Random random = new Random();
        key = random.nextInt((int) (Math.pow(2, 16) - 1));
    }

    public AbstractAccount(String name, String lastName, String email, String contactPhone, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.contactPhone = contactPhone;
        this.password = password;
    }

    public AbstractAccount(String name, String lastName, String email, String contactPhone, String password,
                           NumberGenerator<Integer> numberGenerator) {
        this(name, lastName, email, contactPhone, password);
        key = numberGenerator.generate();
    }

    public String codePassword() {
        return UNARY_CODER.code(password, Defaults.STRING_TO_INT_CODER.code(Defaults.SECRET_ENCRYPTION_KEY, this.key));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setRandomPassword() {
        this.password = Defaults.RELIABLE_PASSWORD_GENERATOR.get();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Account{name='" + name + "', lastName='" + lastName + "', email='" + email +
                "', contactPhone='" + contactPhone + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAccount account = (AbstractAccount) o;
        return Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
