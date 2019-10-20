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

    private FloatingActionButton fab_add, fab_phone, fab_gps, fab_language, fab_England_Flag, fab_Thai_Flag, fab_China_Flag;
    private Animation fab_close1, fab_open1, fab_rotate_anticlock1, fab_rotate_clock1;
    private Animation fab_close2, fab_open2;
    TextView text_ViewEn, text_ViewTh, text_ViewCh;

    Boolean fab_add_isOpen = false;
    boolean fab_language_isOpen = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        fabOpenActivity();
        //fabLanguageActivity();

    }

    private void fabOpenActivity() {
        // Main floating action button
        fab_add = getView().findViewById(R.id.fab_add);

        // 1st sub floating action button
        fab_phone = getView().findViewById(R.id.fab_phone);
        fab_gps = getView().findViewById(R.id.fab_gps);
        fab_language = getView().findViewById(R.id.fab_language);

        // 2nd sub floating action button
        fab_Thai_Flag = getView().findViewById(R.id.fab_Thai_flag);
        fab_England_Flag = getView().findViewById(R.id.fab_English_flag);
        fab_China_Flag = getView().findViewById(R.id.fab_China_flag);

        //Animation control for 1st sub floating action button
        fab_close1 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        fab_open1 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        fab_rotate_anticlock1 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_rotate_anticlock);
        fab_rotate_clock1 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_rotate_clock);

        //Animation control for 2nd sub floating action button
        fab_close2 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        fab_open2 = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fab_add_isOpen) {
                    allSubFloatingButtonClose(fab_language_isOpen);
                }
                else {

                    fab_add.startAnimation(fab_rotate_clock1);

                    fab_phone.startAnimation(fab_open1);
                    fab_gps.startAnimation(fab_open1);
                    fab_language.startAnimation(fab_open1);

                    fab_phone.setClickable(true);
                    fab_gps.setClickable(true);
                    fab_language.setClickable(true);

                    fab_add_isOpen = true;
                }
            }
        });

                /* //Assign text display
                  text_ViewEn = getView().findViewById(R.id.textView_En);
                  text_ViewTh = getView().findViewById(R.id.textView_Th);
                  text_ViewCh = getView().findViewById(R.id.textView_Ch); */

        fab_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fab_language_isOpen) {

                    /*
                    text_ViewEn.setVisibility(View.INVISIBLE);
                    text_ViewTh.setVisibility(View.INVISIBLE);
                    text_ViewCh.setVisibility(View.INVISIBLE);
                     */

                    fab_Thai_Flag.startAnimation(fab_close2);
                    fab_England_Flag.startAnimation(fab_close2);
                    fab_China_Flag.startAnimation(fab_close2);

                    fab_Thai_Flag.setClickable(false);
                    fab_England_Flag.setClickable(false);
                    fab_China_Flag.setClickable(false);

                    fab_language_isOpen = false;
                }
                else {

                    /*
                    text_ViewEn.setVisibility(View.VISIBLE);
                    text_ViewTh.setVisibility(View.VISIBLE);
                    text_ViewCh.setVisibility(View.VISIBLE);
                     */

                    fab_Thai_Flag.startAnimation(fab_open2);
                    fab_England_Flag.startAnimation(fab_open2);
                    fab_China_Flag.startAnimation(fab_open2);

                    fab_Thai_Flag.setClickable(true);
                    fab_England_Flag.setClickable(true);
                    fab_China_Flag.setClickable(true);

                    fab_language_isOpen = true;
                }
            }
        });


        fab_England_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "English", Toast.LENGTH_SHORT).show();
                setHeader(getText(R.string.header01En).toString());
                allSubFloatingButtonClose(fab_language_isOpen);
            }
        });


        fab_Thai_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thai", Toast.LENGTH_SHORT).show();
                setHeader(getText(R.string.header01Th).toString());
                allSubFloatingButtonClose(fab_language_isOpen);
            }
        });


        fab_China_Flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cantonese", Toast.LENGTH_SHORT).show();
                setHeader(getText(R.string.header01Ch).toString());
                allSubFloatingButtonClose(fab_language_isOpen);
            }
        });
    }

    private void allSubFloatingButtonClose(boolean fab_language_logic) {
        fab_add.startAnimation(fab_rotate_anticlock1);

        fab_phone.startAnimation(fab_close1);
        fab_gps.startAnimation(fab_close1);
        fab_language.startAnimation(fab_close1);

        fab_phone.setClickable(false);
        fab_gps.setClickable(false);
        fab_language.setClickable(false);


        if(fab_language_logic) {
            fab_Thai_Flag.startAnimation(fab_close2);
            fab_England_Flag.startAnimation(fab_close2);
            fab_China_Flag.startAnimation(fab_close2);

            fab_Thai_Flag.setClickable(false);
            fab_England_Flag.setClickable(false);
            fab_China_Flag.setClickable(false);
        }

        fab_add_isOpen = false;
        fab_language_isOpen = false;
    }

    private void setHeader(String s) {
        TextView textViewHeader = getView().findViewById(R.id.textHeader);
        textViewHeader.setText(s);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
