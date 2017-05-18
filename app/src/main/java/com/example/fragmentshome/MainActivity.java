package com.example.fragmentshome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment3.OnDataPass{
    TextView textView1, textView2, textView3, textView4;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment1, fragment2, fragment3, fragment4;
    String TAG1, TAG2, TAG3, TAG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment1 = new Fragment1();
        fragment2  = fragment3 = fragment4 = null;
        fragmentTransaction = fragmentManager.beginTransaction();
        TAG1 = Fragment1.TAG;
        TAG2 = Fragment2.TAG;
        TAG3 = Fragment3.TAG;
        TAG4 = Fragment4.TAG;
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_container, fragment1, TAG1);
        fragmentTransaction.commit();

        textView1 = (TextView)findViewById(R.id.main_btn1);
        textView2 = (TextView)findViewById(R.id.main_btn2);
        textView3 = (TextView)findViewById(R.id.main_btn3);
        textView4 = (TextView)findViewById(R.id.main_btn4);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(getVisibleFragment());
        setPassiveColors();
        Fragment fr;

        switch (v.getId()){
            case R.id.main_btn1:
                fr = fragmentManager.findFragmentByTag(TAG1);
                if(fr == null){
                    fragment1 = new Fragment1();
                    fragmentTransaction.addToBackStack(TAG1);
                    fragmentTransaction.add(R.id.main_container, fragment1, TAG1);
                } else {
                    fragmentTransaction.show(fragment1);
                }
                textView1.setBackgroundResource(R.color.colorActiveButton);
                break;
            case R.id.main_btn2:
                fr = fragmentManager.findFragmentByTag(TAG2);
                if(fr == null){
                    fragment2 = new Fragment2();
                    fragmentTransaction.addToBackStack(TAG2);
                    fragmentTransaction.add(R.id.main_container, fragment2, TAG2);
                } else {
                    fragmentTransaction.show(fragment2);
                }
                textView2.setBackgroundResource(R.color.colorActiveButton);
                break;
            case R.id.main_btn3:
                fr = fragmentManager.findFragmentByTag(TAG3);
                if(fr == null){
                    fragment3 = new Fragment3();
                    fragmentTransaction.addToBackStack(TAG3);
                    fragmentTransaction.add(R.id.main_container, fragment3, TAG3);
                } else {
                    fragmentTransaction.show(fragment3);
                }
                textView3.setBackgroundResource(R.color.colorActiveButton);
                break;
            case R.id.main_btn4:
                fr = fragmentManager.findFragmentByTag(TAG4);
                if(fr == null){
                    fragment4 = new Fragment4();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.add(R.id.main_container, fragment4, TAG4);
                    fragmentTransaction.addToBackStack(TAG4);
                } else {
                    fragmentTransaction.show(fragment4);
                }
                textView4.setBackgroundResource(R.color.colorActiveButton);
                break;
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
        Log.e("testt", "entry count "+ fragmentManager.getBackStackEntryCount());
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() == 1 ) finish();
        else fragmentManager.popBackStack();
    }

    public Fragment getVisibleFragment(){
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible()){
                    return fragment;
                }
            }
        }
        return null;
    }

    public void setPassiveColors(){
        textView1.setBackgroundResource(R.color.colorPassiveButton);
        textView2.setBackgroundResource(R.color.colorPassiveButton);
        textView3.setBackgroundResource(R.color.colorPassiveButton);
        textView4.setBackgroundResource(R.color.colorPassiveButton);
    }

    @Override
    public void onDataPass(String data) {
        Fragment fr = fragmentManager.findFragmentByTag(TAG4);
        if(fr != null  && (fr instanceof Fragment4))
            ((TextView)findViewById(R.id.fragment4_editableTextView)).setText(data);
    }
}
