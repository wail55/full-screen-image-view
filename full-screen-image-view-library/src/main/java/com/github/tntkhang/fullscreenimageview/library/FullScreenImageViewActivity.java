package com.github.tntkhang.fullscreenimageview.library;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class FullScreenImageViewActivity extends AppCompatActivity {

    public static final String URI_LIST_DATA = "URI_LIST_DATA";
    public static final String IMAGE_FULL_SCREEN_CURRENT_POS = "IMAGE_FULL_SCREEN_CURRENT_POS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_touch_image_view);

        findViewById(R.id.ic_back).setOnClickListener(view -> finish());
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        ArrayList<String> imagePaths = getIntent().getStringArrayListExtra(URI_LIST_DATA);

        int currentPos = getIntent().getIntExtra(IMAGE_FULL_SCREEN_CURRENT_POS, 0);

        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager, imagePaths, getLifecycle());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPos);
    }
}
