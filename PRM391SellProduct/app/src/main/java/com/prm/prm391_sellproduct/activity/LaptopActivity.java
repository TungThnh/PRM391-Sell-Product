package com.prm.prm391_sellproduct.activity;

import android.widget.Toolbar;

import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.retrofit.APISell;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LaptopActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    APISell apiSell;
    CompositeDisposable compositeDisposable;
    int page = 1;
    int type;

}
