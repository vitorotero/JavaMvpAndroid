package br.com.tecapp.mvparchitecture.shared.base;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.util.DeviceUtils;
import butterknife.ButterKnife;
import dagger.android.DaggerDialogFragment;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BaseDialog extends DaggerDialogFragment {

    private static final float NORMAL_DENSITY = 0.75f;
    private Context context;

    protected abstract int contentLayout();

    protected abstract void create(View view);

    private Window window;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        window = getDialog().getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            window.getDecorView().setBackgroundResource(R.drawable.rounded_base_dialog);
        }

        int layout = contentLayout();
        return inflater.inflate(layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        context = view.getContext();
        create(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (window != null) {
            boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
            Point point = DeviceUtils.getScreenSizeInPixel(context);
            int width = isTablet ? ((int) (point.x * NORMAL_DENSITY)) : ViewGroup.LayoutParams.MATCH_PARENT;
            window.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

}
