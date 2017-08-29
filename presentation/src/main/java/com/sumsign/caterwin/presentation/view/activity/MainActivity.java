package com.sumsign.caterwin.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.sumsign.caterwin.presentation.R;
import com.sumsign.caterwin.presentation.view.activity.base.CleanActivity;

public class MainActivity extends CleanActivity {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        this.showLoader();
    }

    @Override
    protected boolean useBackToolbar() {
        return false;
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.getToolbar().setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_settings) {
                MainActivity.this.displaySettings();
                return true;
            }
            return false;
        });
        return true;
    }

    public void displaySettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

}
