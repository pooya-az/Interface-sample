package com.example.woods.interface_sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment1 extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";

    private Activity activity = null;
    private String mParam1 = null;
    private DataInterface dataInterface = null;

    public BlankFragment1() {
    }

    public static BlankFragment1 newInstance(String param1) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Inflate", "Fragment1 inflate view");
        Log.v("Parameter", "Fragment1 parameter static send: " + mParam1);

        View inflaterView = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);

        inflaterView.findViewById(R.id.btn1).setOnClickListener(this);
        inflaterView.findViewById(R.id.btn2).setOnClickListener(this);

        return inflaterView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
        this.dataInterface = (DataInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
        this.dataInterface = null;
    }

    @Override
    public void onClick(View v) {
        Bundle data = new Bundle();
        data.putString("key1", "value1");
        data.putString("key2", "value2");

        switch (v.getId()) {
            case R.id.btn1:
                this.dataInterface.sendData(data, 1);
                break;
            case R.id.btn2:
                this.dataInterface.sendData(data, 2);
                break;
        }
    }
}
