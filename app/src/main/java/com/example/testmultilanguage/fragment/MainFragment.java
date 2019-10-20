package com.example.testmultilanguage.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testmultilanguage.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainFragment extends Fragment {

    private  FloatingActionButton fab_add, fab_England_Flag, fab_Thai_Flag , fab_China_Flag;
    private Animation fab_close,fab_open,fab_rotate_anticlock, fab_rotate_clock;
    TextView text_ViewEn,text_ViewTh,text_ViewCh;

    Boolean isOpen = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        fabActivity();

    }

    private void fabActivity() {
        //Assign floating action button
        fab_add = getView().findViewById(R.id.fab_add);
        fab_Thai_Flag = getView().findViewById(R.id.fab_Thai_flag);
        fab_England_Flag = getView().findViewById(R.id.fab_English_flag);
        fab_China_Flag = getView().findViewById(R.id.fab_China_flag);

        //Assign animation control
        fab_close = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        fab_rotate_anticlock = AnimationUtils.loadAnimation(getContext(), R.anim.fab_rotate_anticlock);
        fab_rotate_clock = AnimationUtils.loadAnimation(getContext(), R.anim.fab_rotate_clock);

        //Assign text display
        text_ViewEn = getView().findViewById(R.id.textView_En);
        text_ViewTh = getView().findViewById(R.id.textView_Th);
        text_ViewCh = getView().findViewById(R.id.textView_Ch);


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {

                    text_ViewEn.setVisibility(View.INVISIBLE);
                    text_ViewTh.setVisibility(View.INVISIBLE);
                    text_ViewCh.setVisibility(View.INVISIBLE);

                    fab_add.startAnimation(fab_rotate_anticlock);

                    fab_England_Flag.startAnimation(fab_close);
                    fab_Thai_Flag.startAnimation(fab_close);
                    fab_China_Flag.startAnimation(fab_close);

                    fab_England_Flag.setClickable(false);
                    fab_Thai_Flag.setClickable(false);
                    fab_China_Flag.setClickable(false);

                    isOpen = false;

                } else {

                    text_ViewEn.setVisibility(View.VISIBLE);
                    text_ViewTh.setVisibility(View.VISIBLE);
                    text_ViewCh.setVisibility(View.VISIBLE);

                    fab_add.startAnimation(fab_rotate_clock);

                    fab_England_Flag.startAnimation(fab_open);
                    fab_Thai_Flag.startAnimation(fab_open);
                    fab_China_Flag.startAnimation(fab_open);

                    fab_England_Flag.setClickable(true);
                    fab_Thai_Flag.setClickable(true);
                    fab_China_Flag.setClickable(true);

                    isOpen = true;
                }
            }
        });

        fab_England_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "English", Toast.LENGTH_SHORT).show();
            }
        });


        fab_Thai_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thai", Toast.LENGTH_SHORT).show();
            }
        });



        fab_China_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cantonese", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
