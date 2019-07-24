package com.kotlin.xhb;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    public static HomeFragment create(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("FM_TEXT", text);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            Log.e(getClass().getSimpleName(), getArguments().getString("FM_TEXT") + " --->  savedInstanceState");
        }

        final TextView textView = view.findViewById(R.id.fg_text);
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText(getArguments().getString("FM_TEXT"));

            }
        }, 1000);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(getClass().getSimpleName(), getArguments().getString("FM_TEXT") + " --->  onCreate");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(getClass().getSimpleName(), getArguments().getString("FM_TEXT") + " --->  onAttach");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getSimpleName(), getArguments().getString("FM_TEXT") + " --->  onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(getClass().getSimpleName(), getArguments().getString("FM_TEXT") + " --->  onDetach");
    }
}
