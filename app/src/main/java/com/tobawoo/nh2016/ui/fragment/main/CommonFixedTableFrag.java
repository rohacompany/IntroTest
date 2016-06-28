package com.tobawoo.nh2016.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobawoo.nh2016.R;

/**
 * Created by tommy on 2016-06-23.
 */
public class CommonFixedTableFrag extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_common_fixed_layout , container , false);
        return view;
    }
}
