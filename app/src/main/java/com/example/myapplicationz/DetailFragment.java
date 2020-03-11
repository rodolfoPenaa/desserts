package com.example.myapplicationz;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String dessertName;
    private int dessertImage;

    private ImageView imageView;
    private TextView textViewName;



    public DetailFragment() {
        // Required empty public constructor
    }



    public static DetailFragment    newInstance(String param1, int param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dessertName = getArguments().getString(ARG_PARAM1);
            dessertImage = getArguments().getInt(ARG_PARAM2);
       }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

//        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);


        initializeView(view);

        textViewName.setText(dessertName);
        Glide.with(getContext())
                .load(dessertImage)
                .into(imageView);

        return view;
    }

    private void initializeView (View view){
        textViewName = view.findViewById(R.id.nameDessert);
        imageView = view.findViewById(R.id.imageViewFragment);

    }
}
