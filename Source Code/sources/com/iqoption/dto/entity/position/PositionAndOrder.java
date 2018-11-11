package com.iqoption.dto.entity.position;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class PositionAndOrder extends Position {
    @SerializedName("orders")
    public ArrayList<Order> orders;
}
