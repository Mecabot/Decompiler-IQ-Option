package com.iqoption.dto.entity.video;

import java.util.ArrayList;
import java.util.Iterator;

public class SorterObj {
    public Integer number;
    public Integer order;

    public static class List extends ArrayList<SorterObj> {
        public Integer getOrderPosition(Integer num) {
            Iterator it = iterator();
            while (it.hasNext()) {
                SorterObj sorterObj = (SorterObj) it.next();
                if (sorterObj.number.equals(num)) {
                    return sorterObj.order;
                }
            }
            return Integer.valueOf(-1);
        }
    }
}
