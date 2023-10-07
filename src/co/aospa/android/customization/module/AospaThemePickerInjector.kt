package co.aospa.android.customization.module

import android.app.Activity

import android.content.Context

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.android.wallpaper.model.WallpaperInfo
import com.android.wallpaper.module.CustomizationSections
import com.android.wallpaper.picker.MonetPreviewFragment

import com.android.customization.picker.clock.ui.view.ClockViewFactory
import com.android.customization.picker.clock.ui.viewmodel.ClockCarouselViewModel
import com.android.customization.picker.notifications.ui.viewmodel.NotificationSectionViewModel

import com.android.customization.model.mode.DarkModeSnapshotRestorer
import com.android.customization.model.themedicon.domain.interactor.ThemedIconInteractor
import com.android.customization.model.themedicon.domain.interactor.ThemedIconSnapshotRestorer
import com.android.customization.module.ThemePickerInjector

public class AospaThemePickerInjector : ThemePickerInjector() {

    private var customizationSections: CustomizationSections? = null

    override fun getPreviewFragment(
            context: Context,
            wallpaperInfo: WallpaperInfo,
            mode: Int,
            viewAsHome: Boolean,
            viewFullScreen: Boolean,
            testingModeEnabled: Boolean): Fragment {
        return MonetPreviewFragment.newInstance(wallpaperInfo, mode, viewAsHome, viewFullScreen, testingModeEnabled);
    }

    override fun getCustomizationSections(activity: ComponentActivity): CustomizationSections {
        return customizationSections
            ?: AospaCustomizationSections(
                    getColorPickerViewModelFactory(
                        context = activity,
                        wallpaperColorsViewModel = getWallpaperColorsViewModel(),
                    ),
                    getKeyguardQuickAffordancePickerInteractor(activity),
                    getKeyguardQuickAffordancePickerViewModelFactory(activity),
                    getNotificationSectionViewModelFactory(activity),
                    getFlags(),
                    getClockCarouselViewModelFactory(
                        getClockPickerInteractor(activity.applicationContext),
                    ),
                    getClockViewFactory(activity),
                    getDarkModeSnapshotRestorer(activity),
                    getThemedIconSnapshotRestorer(activity),
                    getThemedIconInteractor(),
                )
                .also { customizationSections = it }
    }
}
