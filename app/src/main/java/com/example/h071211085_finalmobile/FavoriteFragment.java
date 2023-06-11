package com.example.h071211085_finalmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.contracts.Returns;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;

    private LinearLayout retryicon;

    private ImageView im2, im1;

    private ProgressBar progressBar;

    private Handler handler;

    private ImageView Retryy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        retryicon = view.findViewById(R.id.retryicon);
        recyclerView = view.findViewById(R.id.recyclerView3);
        progressBar = view.findViewById(R.id.pb1);
        Retryy = view.findViewById(R.id.retry);
        im2 = view.findViewById(R.id.imageView2);
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentShow thirdFragment = new FragmentShow();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, thirdFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        im1 = view.findViewById(R.id.imageView1);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMovie thirdFragment = new FragmentMovie();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, thirdFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void loading() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try { //simulate process in background thread
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(100);
                    int percentage = i * 10;
                    handler.post(() -> {
                        //update ui in main thread
                        if (percentage == 100) {
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.GONE);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void Retry() {
        retryicon.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Retryy.setOnClickListener(view -> {
            retryicon.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            handler.postDelayed(() -> {
                progressBar.setVisibility(View.VISIBLE);
//                recyclerView.setVisibility(View.VISIBLE);
            }, 500);

        });
    }
}
