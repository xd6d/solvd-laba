package com.solvd.laba.block1.oop.model.order;

import com.solvd.laba.block1.oop.exceptions.AccessDeniedException;
import com.solvd.laba.block1.oop.model.enums.PaymentMethod;
import com.solvd.laba.block1.oop.model.enums.Status;
import com.solvd.laba.block1.oop.model.interfaces.Countable;
import com.solvd.laba.block1.oop.model.users.UserAccount;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Order implements Countable {
    private static long nextId = 0;
    private final long id = nextId++;
    private final UserAccount user;
    private final Bucket bucket;
    private Set<String> contactPhones;
    private String address;
    private Status status;
    private PaymentMethod paymentMethod;
    private PromoCode promoCode;

    public Order(UserAccount user, Bucket bucket, String contactPhone, String address, PaymentMethod paymentMethod,
                 PromoCode promoCode) throws AccessDeniedException {
        this(user, bucket, new HashSet<>(), address, paymentMethod, promoCode);
        contactPhones.add(contactPhone);
    }

    public Order(UserAccount user, Bucket bucket, String contactPhone, String address, PaymentMethod paymentMethod)
            throws AccessDeniedException {
        this(user, bucket, contactPhone, address, paymentMethod, null);
    }

    public Order(UserAccount user, Bucket bucket, Set<String> contactPhones, String address, PaymentMethod paymentMethod,
                 PromoCode promoCode) throws AccessDeniedException {
        if (user.isBlocked())
            throw new AccessDeniedException("User %s %s is blocked. You can not order"
                    .formatted(user.getName(), user.getLastName()));
        this.user = user;
        this.bucket = bucket;
        this.contactPhones = contactPhones;
        this.address = address;
        this.status = Status.CREATED;
        this.paymentMethod = paymentMethod;
        this.promoCode = promoCode;
    }

    @Override
    public double getTotal() {
        double discount = 1;
        if (promoCode != null && !promoCode.isExpired())
            discount = promoCode.getPriceChange();
        return bucket.getTotal() * discount;
    }

    public UserAccount getUser() {
        return user;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public Set<String> getContactPhone() {
        return contactPhones;
    }

    public void setContactPhones(Set<String> contactPhones) {
        this.contactPhones = contactPhones;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", user=" + user + ", bucket=" + bucket + ", total=" + getTotal() +
                ", address='" + address + "', status=" + status + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public PromoCode getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromoCode promoCode) {
        this.promoCode = promoCode;
    }
}
