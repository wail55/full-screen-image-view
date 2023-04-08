package com.github.tntkhang.fullscreenimageview.library;

import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class PagerAdapter extends FragmentStateAdapter {

    private final List<Uri> imagesUri;

    PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull List<Uri> images, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.imagesUri=images;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Uri item = imagesUri.get(position);
        return ImageFragment.newInstance(item);
    }

    @Override
    public int getItemCount() {
        return imagesUri.size();
    }
}
