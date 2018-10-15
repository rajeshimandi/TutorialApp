package com.example.anuraj.tutorialsapplication.activities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/14/2018.
 */

public class FragmentC extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Bundle bundle = getArguments();

        if (bundle != null) {
            Toast.makeText(getActivity(), "Version:" + bundle.getInt("version"), Toast.LENGTH_SHORT).show();
        }*/

        ((Button)view.findViewById(R.id.fragButton3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,new FragmentD()).addToBackStack(null).commit();
            }
        });


    }
}
