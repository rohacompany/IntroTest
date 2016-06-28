package com.tobawoo.nh2016.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016-01-12.
 */
public class NonggaType {
    public final String name;
    public final List<NonggaData> list;

    public NonggaType() {
        this.name = "";
        list = new ArrayList<NonggaData>();
    }

    public NonggaType(String name) {
        this.name = name;
        list = new ArrayList<NonggaData>();
    }

    public int size() {
        return list.size();
    }

    public NonggaData get(int i) {
        return list.get(i);
    }
}
