package br.com.tecapp.mvparchitecture.ui.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.ui.basedrawer.DrawerNavigation;
import br.com.tecapp.mvparchitecture.ui.login.LoginActivity;

public class HomeActivity extends DrawerNavigation {

    public static Intent getIntent(Context from) {
        Intent intent = new Intent(from, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return intent;
    }

    @Override
    protected int contentLayout() {
        return R.layout.home;
    }

    @Override
    protected void create() {
        super.create();


        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.frame_container, HomeFragment.newInstance(), HomeFragment.class.getSimpleName())
                .addToBackStack(HomeFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void destroy() {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
