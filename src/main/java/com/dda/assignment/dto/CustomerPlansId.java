package com.dda.assignment.dto;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class CustomerPlansId implements Serializable {

    private BigInteger plan;

    private BigInteger customer;

    public BigInteger getPlan() {
        return plan;
    }

    public void setPlan(BigInteger plan) {
        this.plan = plan;
    }

    public BigInteger getCustomer() {
        return customer;
    }

    public void setCustomer(BigInteger customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPlansId that = (CustomerPlansId) o;

        if (!plan.equals(that.plan)) return false;
        return customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        int result = plan.hashCode();
        result = 31 * result + customer.hashCode();
        return result;
    }
}
