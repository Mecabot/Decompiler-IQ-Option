package com.iqoption.dto.entity.position;

import com.iqoption.core.data.model.InstrumentType;

public final class PendingOrderWrapper {
    public static final String POSITION_ID = "position_id";
    public static final String PRICE = "price";
    public static final String SIDE = "side";
    public final int activeId;
    public final InstrumentType instrumentType;
    public final boolean isBuy;
    public final long positionId;
    public final double price;

    public PendingOrderWrapper(Order order) {
        this.activeId = order.getInstrumentActiveId().intValue();
        this.instrumentType = order.getInstrumentType();
        this.price = order.getPendingPrice();
        this.isBuy = Order.BUY.equalsIgnoreCase(order.getSide());
        this.positionId = order.getPositionId() == null ? 0 : order.getPositionId().longValue();
    }
}
