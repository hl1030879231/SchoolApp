package com.example.schoolapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.schoolapp.Activity.personal.Activity_aboutus;
import com.example.schoolapp.Activity.personal.Activity_collection;
import com.example.schoolapp.Activity.personal.Activity_editinformation;
import com.example.schoolapp.Activity.personal.Activity_feedback;
import com.example.schoolapp.Activity.personal.Activity_message;
import com.example.schoolapp.Activity.personal.Activity_set;
import com.example.schoolapp.Activity.personal.Activity_studentinformation;
import com.example.schoolapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by $HL on 2017/8/14.
 */

public class Me_fragment extends android.support.v4.app.Fragment {
    private LinearLayout head_layout;
    private LinearLayout message_layout;
    private LinearLayout collection_layout;
    private LinearLayout stu_information_layout;
    private LinearLayout set_layout;
    private LinearLayout feedback_layout;
    private LinearLayout about_us_layout;
    private RoundedImageView roundedImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        click();
    }


    public  void init(){
        head_layout = (LinearLayout)getActivity().findViewById(R.id.head);
        message_layout = (LinearLayout)getActivity().findViewById(R.id.message);
        collection_layout = (LinearLayout)getActivity().findViewById(R.id.collection);
        stu_information_layout = (LinearLayout)getActivity().findViewById(R.id.stu_information);
        set_layout = (LinearLayout)getActivity().findViewById(R.id.set);
        feedback_layout = (LinearLayout)getActivity().findViewById(R.id.feedback);
        about_us_layout = (LinearLayout)getActivity().findViewById(R.id.about_us);
        roundedImageView = (RoundedImageView)getActivity().findViewById(R.id.roundedImageView);
        roundedImageView.setImageResource(R.drawable.one);
    }

    public void click(){
        head_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Activity_editinformation.class);
                startActivity(intent);
            }
        });
        collection_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(getContext(), Activity_collection.class);
                startActivity(intent2);
            }
        });

        stu_information_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                        intent3.setClass(getContext(), Activity_studentinformation.class);
                startActivity(intent3);
            }
        });

        set_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.setClass(getContext(), Activity_set.class);
                startActivity(intent4);
            }
        });

        message_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent();
                intent5.setClass(getContext(), Activity_message.class);
                startActivity(intent5);
            }
        });

       /* feedback_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent();
                intent6.setClass(getContext(), Activity_feedback.class);
                startActivity(intent6);
            }
        });*/

        about_us_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent();
                intent7.setClass(getContext(), Activity_aboutus.class);
                startActivity(intent7);
            }
        });
    }
}
