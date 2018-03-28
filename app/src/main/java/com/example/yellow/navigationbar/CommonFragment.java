package com.example.yellow.navigationbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yellow on 2018-3-28.
 */

public class CommonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_common,viewGroup,false);
        TextView textView=(TextView)view.findViewById(R.id.message_textview);
        textView.setText(getArguments().getString("msg","Home"));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(null, "MSG Hit!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public static CommonFragment newInstance(String msg){
        Bundle args=new Bundle();
        CommonFragment fragment=new CommonFragment();
        args.putString("msg",msg);
        fragment.setArguments(args);
        return fragment;
    }

}
