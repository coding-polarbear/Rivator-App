package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.SearchPagerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

public class SearchViewActivity extends AppCompatActivity {

    private ActionBar actionBar = null;

    private ViewPager mViewPager = null;

    private TabLayout mTabLayout = null;

    private EditText searchText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
        pagetInit();
        setCustomActionbar();
        setSearchView();

    }

    private void setSearchView() {
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void init(){
        mViewPager = (ViewPager)findViewById(R.id.search_viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.search_tab);
    }
    private void pagetInit() {
        SearchPagerAdapter mHomeWorkPagerAdapter = new SearchPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mHomeWorkPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_search, view -> {
            searchText = view.findViewById(R.id.searchbiew_edittext);
        });

    }



}