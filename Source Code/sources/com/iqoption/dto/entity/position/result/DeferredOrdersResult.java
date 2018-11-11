package com.iqoption.dto.entity.position.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.position.Order;
import java.util.ArrayList;

public class DeferredOrdersResult {
    @SerializedName("orders")
    public ArrayList<Order> deferredOrders;
    @SerializedName("total")
    public Integer total;
}
