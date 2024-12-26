package com.android.grafobank.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.android.grafobank.R;
import com.android.grafobank.activity.DoLogin;
import com.android.grafobank.util.APIRequest;
import com.android.grafobank.util.CryptoUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/* loaded from: classes3.dex */
public class DoLogin extends Activity {
    public static final String MYPREFS = "mySharedPreferences";
    String password;
    String rememberme_password;
    String rememberme_username;
    RequestQueue requestQueue;
    String superSecurePassword;
    String username;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.requestQueue = Volley.newRequestQueue(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_login);
        finish();
        Intent data = getIntent();
        this.username = data.getStringExtra("passed_username");
        this.password = data.getStringExtra("passed_password");
        LoginRequest loginReq = new LoginRequest(this.username, this.password);
        this.requestQueue.add(loginReq);
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

    /* JADX INFO: Access modifiers changed from: private */
    class LoginRequest extends APIRequest {
        public LoginRequest(String username, String password) {
            super(1, "/login", username, password, new Response.Listener() { // from class: com.android.grafobank.activity.DoLogin$LoginRequest$$ExternalSyntheticLambda0
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    DoLogin.LoginRequest.handleRespose(r1, (String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleRespose(DoLogin doLogin, String response) {
            if (response.contains("Correct Credentials")) {
                Log.d("Successful Login:", ", account=" + doLogin.username + ":" + doLogin.password);
                SharedPreferences mySharedPreferences = doLogin.getSharedPreferences("mySharedPreferences", 0);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                doLogin.rememberme_username = doLogin.username;
                doLogin.rememberme_password = doLogin.password;
                String base64Username = Base64.encodeToString(doLogin.rememberme_username.getBytes(), 4);
                doLogin.superSecurePassword = CryptoUtils.aesEncryptedString(doLogin.rememberme_password);
                editor.putString("EncryptedUsername", base64Username);
                editor.putString("superSecurePassword", doLogin.superSecurePassword);
                editor.apply();
                Intent pL = new Intent(doLogin.getApplicationContext(), (Class<?>) PostLogin.class);
                pL.putExtra("uname", doLogin.username);
                doLogin.startActivity(pL);
                return;
            }
            Intent xi = new Intent(doLogin.getApplicationContext(), (Class<?>) WrongLogin.class);
            doLogin.startActivity(xi);
        }
    }
}
