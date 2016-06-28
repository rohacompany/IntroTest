package com.tobawoo.nh2016.ui.fragment.old;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobawoo.nh2016.R;

/**
 * Created by tommy on 2016-04-14.
 */
public class EmptyFrag extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_simple_w_text , container , false);

        return view;
    }
}
