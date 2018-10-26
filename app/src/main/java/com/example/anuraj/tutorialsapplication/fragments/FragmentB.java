package com.example.anuraj.tutorialsapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/14/2018.
 */

public class FragmentB extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) view.findViewById(R.id.text2);

        ((Button) view.findViewById(R.id.fragButton2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new FragmentC()).commit();
            }
        });
    }

    public void setMessage(String msg, int pos) {

        Toast.makeText(getActivity(), "Msg:" + msg + "\n" + "Pos:" + pos, Toast.LENGTH_SHORT).show();
        textView.setText("Msg:" + msg + "\n" + "Pos:" + pos);

    }

}
