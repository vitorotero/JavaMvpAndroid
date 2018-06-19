package br.com.tecapp.mvparchitecture.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DeviceUtils {

    public DeviceUtils() {
    }

    public static Point getScreenSizeInPixel(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm != null ? wm.getDefaultDisplay() : null;
        Point size = new Point();
        if (display != null) {
            display.getSize(size);
        }
        return size;
    }

}
