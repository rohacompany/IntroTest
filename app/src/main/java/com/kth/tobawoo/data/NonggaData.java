package com.kth.tobawoo.data;

import java.util.Arrays;

/**
 * Created by tommy on 2016-01-12.
 */
public class NonggaData {

    public final String[] data;

    public NonggaData(String...datas){
        this.data = datas;
    }

    @Override
    public String toString() {
        return "NonggaData{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
