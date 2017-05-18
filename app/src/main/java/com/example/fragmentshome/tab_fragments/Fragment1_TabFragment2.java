package com.example.fragmentshome.tab_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentshome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1_TabFragment2 extends Fragment {


    public Fragment1_TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1__tab_fragment2, container, false);
    }

}
