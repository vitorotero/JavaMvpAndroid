package br.com.tecapp.mvparchitecture.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class NavigationUtils {

    public static void openActivity(Context context, Intent intent, @Nullable Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void openActivity(Context context, Intent intent) {
        openActivity(context, intent, null);
    }

}
