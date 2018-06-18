package com.example.vitormachado.mvparchitecture.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author vitor.machado on 08/06/18.
 */
public class NavigationUtils {

    public static void openActivity(Context context, Intent intent, @Nullable Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void openActivity(Context context, Intent intent) {
        openActivity(context, intent, null);
    }

}
