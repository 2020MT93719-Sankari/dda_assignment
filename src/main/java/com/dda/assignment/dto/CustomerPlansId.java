package com.dda.assignment.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class CustomerPlansId implements Serializable {
    @Column(name = "customerId")
    BigInteger customerId;

    @Column(name = "planId")
    BigInteger planId;

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigInteger getPlanId() {
        return planId;
    }

    public void setPlanId(BigInteger planId) {
        this.planId = planId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPlansId that = (CustomerPlansId) o;

        if (!customerId.equals(that.customerId)) return false;
        return planId.equals(that.planId);
    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + planId.hashCode();
        return result;
    }
}
