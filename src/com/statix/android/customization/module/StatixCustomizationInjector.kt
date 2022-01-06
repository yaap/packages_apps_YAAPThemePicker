package com.statix.android.customization.module

import android.content.Context

import androidx.fragment.app.Fragment

import com.android.wallpaper.model.WallpaperInfo
import com.android.wallpaper.picker.MonetPreviewFragment

import com.android.customization.module.DefaultCustomizationInjector

public class StatixCustomizationInjector : DefaultCustomizationInjector() {

    override fun getPreviewFragment(
            context: Context,
            wallpaperInfo: WallpaperInfo,
            mode: Int,
            viewAsHome: Boolean,
            viewFullScreen: Boolean,
            testingModeEnabled: Boolean): Fragment {
        return MonetPreviewFragment.newInstance(wallpaperInfo, mode, viewAsHome, viewFullScreen, testingModeEnabled);
    }
}
