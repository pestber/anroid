package com.android.grafobank.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.grafobank.R;
import com.android.grafobank.util.CryptoUtils;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class LoginActivity extends Activity {
    public static final String MYPREFS = "mySharedPreferences";
    EditText Password_Text;
    EditText Username_Text;
    Button createuser_buttons;
    Button login_buttons;
    String usernameBase64ByteString;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_main);
        View button_CreateUser = findViewById(R.id.button_getAccounts);
        button_CreateUser.setVisibility(8);
        this.login_buttons = (Button) findViewById(R.id.login_button);
        this.login_buttons.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.LoginActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.createuser_buttons = (Button) findViewById(R.id.button_getAccounts);
        this.createuser_buttons.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.LoginActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        fillData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View v) {
        performlogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View v) {
        createUser();
    }

    protected void createUser() {
        Toast.makeText(this, "Create User functionality is still Work-In-Progress!!", 0).show();
    }

    protected void fillData() {
        SharedPreferences settings = getSharedPreferences("mySharedPreferences", 0);
        String username = settings.getString("EncryptedUsername", null);
        String password = settings.getString("superSecurePassword", null);
        if (username != null && password != null) {
            byte[] usernameBase64Byte = Base64.decode(username, 0);
            this.usernameBase64ByteString = new String(usernameBase64Byte, StandardCharsets.UTF_8);
            this.Username_Text = (EditText) findViewById(R.id.loginscreen_username);
            this.Password_Text = (EditText) findViewById(R.id.loginscreen_password);
            this.Username_Text.setText(this.usernameBase64ByteString);
            String decryptedPassword = CryptoUtils.aesDeccryptedString(password);
            this.Password_Text.setText(decryptedPassword);
        }
    }

    protected void performlogin() {
        this.Username_Text = (EditText) findViewById(R.id.loginscreen_username);
        this.Password_Text = (EditText) findViewById(R.id.loginscreen_password);
        Intent i = new Intent(this, (Class<?>) DoLogin.class);
        i.putExtra("passed_username", this.Username_Text.getText().toString());
        i.putExtra("passed_password", this.Password_Text.getText().toString());
        startActivity(i);
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
