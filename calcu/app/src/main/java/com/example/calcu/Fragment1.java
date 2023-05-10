package com.example.calcu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    Button plus, less, reset;
    TextView counter;
    SharedPreferences sharedPref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        plus = view.findViewById(R.id.bt_plusplus);
        less = view.findViewById(R.id.bt_lessless);
        reset = view.findViewById(R.id.bt_reset);
        counter = view.findViewById(R.id.tv_counter);
        sharedPref = getActivity().getSharedPreferences("counter", Context.MODE_PRIVATE);
        counter.setText(sharedPref.getString("counter", ""));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = counter.getText().toString();
                int n = Integer.valueOf(str);
                ++n;
                str = String.valueOf(n);
                counter.setText(str);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = counter.getText().toString();
                int n = Integer.valueOf(str);
                --n;
                str = String.valueOf(n);
                counter.setText(str);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.setText("0");
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("counter", "0");
                editor.apply();
            }
        });

    }
}