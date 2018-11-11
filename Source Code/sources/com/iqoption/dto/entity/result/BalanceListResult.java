package com.iqoption.dto.entity.result;

import com.iqoption.dto.Balance;
import com.iqoption.util.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceListResult extends ArrayList<Balance> {
    public ConcurrentHashMap<Long, Balance> getMapBalance() {
        ConcurrentHashMap<Long, Balance> concurrentHashMap = new ConcurrentHashMap();
        if (!i.H(this)) {
            Iterator it = iterator();
            while (it.hasNext()) {
                Balance balance = (Balance) it.next();
                concurrentHashMap.put(balance.id, balance);
            }
        }
        return concurrentHashMap;
    }
}
