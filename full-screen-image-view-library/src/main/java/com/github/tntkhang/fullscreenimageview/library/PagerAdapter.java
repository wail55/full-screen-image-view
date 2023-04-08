package com.github.tntkhang.fullscreenimageview.library;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class PagerAdapter extends FragmentStateAdapter {

    private final List<Uri> imagesUri = new ArrayList<>();

    PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull List<String> images, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        for (String image : images) {
            this.imagesUri.add(Uri.parse(image));
        }
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
