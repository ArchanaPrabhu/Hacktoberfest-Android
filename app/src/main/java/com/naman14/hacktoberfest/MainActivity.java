package com.naman14.hacktoberfest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.naman14.hacktoberfest.fragment.AboutFragment;
import com.naman14.hacktoberfest.fragment.ExploreFragment;
import com.naman14.hacktoberfest.fragment.StatusFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomBar)
    BottomNavigationView bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        replaceFragment(new StatusFragment());

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_status:
                        replaceFragment(new StatusFragment());
                        break;
                    case R.id.tab_explore:
                        replaceFragment(new ExploreFragment());
                        break;
                    case R.id.tab_about:
                        replaceFragment(new AboutFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public BottomNavigationView getBottomBar() {
        return bottomBar;
    }
}
