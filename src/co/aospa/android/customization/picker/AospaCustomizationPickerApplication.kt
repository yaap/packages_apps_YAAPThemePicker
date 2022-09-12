package co.aospa.android.customization.picker

import android.app.Application;

import com.android.wallpaper.module.InjectorProvider;

import co.aospa.android.customization.module.AospaCustomizationInjector;

public class AospaCustomizationPickerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        InjectorProvider.setInjector(AospaCustomizationInjector());
    }

}
