package com.linwei.lw.tablayoutdemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.linwei.lw.tablayoutdemo.R;
import com.linwei.lw.tablayoutdemo.Utils.CommentUtils;
import com.linwei.lw.tablayoutdemo.ui.fragment.BaseFragment;
import com.linwei.lw.tablayoutdemo.ui.fragment.FragmentFactory;

public class LongTabActivity extends AppCompatActivity {
        private TabLayout mTab;
        private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_tab);
        initView();
        initData();
    }

    private void initData() {
        LongPagerAdapter adapter = new LongPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);

    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private class LongPagerAdapter extends FragmentPagerAdapter {
        public String[] mTilte;

        public LongPagerAdapter(FragmentManager fm) {
            super(fm);
            mTilte = getResources().getStringArray(R.array.tab_long_Title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTilte[position];
        }

        @Override
        public BaseFragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return CommentUtils.TAB_LONG_COUNT;
        }
    }
}