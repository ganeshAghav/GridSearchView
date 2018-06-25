package com.example.administrator.gridsearchview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragment= (Button) findViewById(R.id.btnnext);
        btnfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(new BlankFragment());
                btnfragment.setVisibility(View.GONE);

            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        try
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if (fragmentManager.getBackStackEntryCount()>0)
            {
                Fragment fragment1 = fragmentManager.getFragments().get(fragmentManager.getBackStackEntryCount()-1);

                if (fragment1.getClass().getName().equalsIgnoreCase(fragment.getClass().getName()))
                {

                }
                else
                {
                    fragmentTransaction.replace(R.id.framemain, fragment, null);

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
                Log.d("test"," top fragment:"+fragment1.getClass().getName());
            }
            else
            {
                fragmentTransaction.replace(R.id.framemain, fragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        }
        catch (Exception er)
        {

        }
    }
}
