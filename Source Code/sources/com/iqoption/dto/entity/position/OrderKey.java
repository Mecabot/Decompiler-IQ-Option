package com.iqoption.dto.entity.position;

import com.google.common.base.f;

public class OrderKey {
    public Long positionId;

    public OrderKey(Long l) {
        this.positionId = l;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof OrderKey) && f.equal(this.positionId, ((OrderKey) obj).positionId));
    }

    public int hashCode() {
        return this.positionId.hashCode();
    }
}
