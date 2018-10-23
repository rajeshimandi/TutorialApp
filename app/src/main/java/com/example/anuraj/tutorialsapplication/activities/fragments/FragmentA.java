package com.example.anuraj.tutorialsapplication.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/14/2018.
 */

public class FragmentA extends Fragment {

    CustomClickListener customClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            customClickListener = (CustomClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement CustomClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Toast.makeText(getActivity(), "Version:" + bundle.getInt("version"), Toast.LENGTH_SHORT).show();
        }


        ((Button) view.findViewById(R.id.fragButton1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for portrait
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,new FragmentB()).addToBackStack(null).commit();

                //Portrait
                //customClickListener.onButtonClick("Clicked button here", 5);

                //Dialog
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag("dialog");

                if (fragment != null) {
                    ft.remove(fragment);
                }

                SampleDialogFrag dialogFrag = new SampleDialogFrag();
                dialogFrag.show(ft, "dialog");
            }
        });

    }
}
