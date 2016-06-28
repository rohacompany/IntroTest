package com.tobawoo.nh2016.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016-01-12.
 */
public class CommonResultType {
    public final String name;
    public final List<CommonInter> list;

    public CommonResultType() {
        this.name = "";
        list = new ArrayList<CommonInter>();
    }

    public CommonResultType(String name) {
        this.name = name;
        list = new ArrayList<CommonInter>();
    }

    public int size() {
        return list.size();
    }

    public CommonInter get(int i) {
        return list.get(i);
    }
}
