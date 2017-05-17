package com.example.fragmentshome;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {
    private static final String KEY_STRING_EXTRA = "str";
    public static final String TAG = "Fragment2";
    private String mParam1;
//    TextView textView/;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String param1) {
        Fragment2 fragment = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_STRING_EXTRA, param1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(KEY_STRING_EXTRA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
//        textView = (TextView)view.findViewById(R.id.text2);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        textView.setText(mParam1);
    }
}