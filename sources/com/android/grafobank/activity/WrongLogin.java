package com.android.grafobank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.grafobank.R;

/* loaded from: classes3.dex */
public class WrongLogin extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_login);
        Toast.makeText(getApplicationContext(), "Invalid Credentials!!", 1).show();
        Intent backtoLogin = new Intent(this, (Class<?>) LoginActivity.class);
        startActivity(backtoLogin);
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_exit) {
            Intent i = new Intent(getBaseContext(), (Class<?>) LoginActivity.class);
            i.addFlags(67108864);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
