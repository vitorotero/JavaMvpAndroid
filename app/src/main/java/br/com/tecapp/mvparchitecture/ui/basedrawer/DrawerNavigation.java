package br.com.tecapp.mvparchitecture.ui.basedrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.base.BaseActivity;
import butterknife.BindView;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class DrawerNavigation extends BaseActivity implements OnNavigationItemSelectedListener {

    @BindView(R.id.navigation_view) NavigationView navigationView;
    @BindView(R.id.navigation_toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void create() {
        setSupportActionBar(toolbar);
        initNavigationView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void initNavigationView() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open_text,
                R.string.navigation_drawer_close_text);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        navigationView.setNavigationItemSelectedListener(this);
    }
}
