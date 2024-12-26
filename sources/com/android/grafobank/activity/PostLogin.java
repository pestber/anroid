package com.android.grafobank.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.grafobank.R;
import com.android.grafobank.activity.PostLogin;
import com.android.grafobank.util.APIRequest;
import com.android.grafobank.util.CryptoUtils;
import com.android.grafobank.util.EnvironmentUtil;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PostLogin extends Activity {
    Button fool_button;
    Button getMyData_button;
    RequestQueue requestQueue;
    Button transfer_button;
    String uname;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestQueue = Volley.newRequestQueue(getApplicationContext());
        setContentView(R.layout.activity_post_login);
        Intent intent = getIntent();
        this.uname = intent.getStringExtra("uname");
        checkEnvironment();
        this.fool_button = (Button) findViewById(R.id.trf_buttonFool);
        this.fool_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.PostLogin$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.transfer_button = (Button) findViewById(R.id.trf_transferMoneys);
        this.transfer_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.PostLogin$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.getMyData_button = (Button) findViewById(R.id.button_GetMyData);
        this.getMyData_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.PostLogin$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        Toast.makeText(this, "Loading flag... Please retry in a few seconds", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View v) {
        runOnUiThread(new Runnable() { // from class: com.android.grafobank.activity.PostLogin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View v) {
        Intent dT = new Intent(getApplicationContext(), (Class<?>) DoTransfer.class);
        startActivity(dT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View v) {
        getMyData();
    }

    private void checkEnvironment() {
        if (EnvironmentUtil.isSuspiciousEnvironment()) {
            Log.e(PostLogin.class.getSimpleName(), "User is trying to hack the device! ALERT ALERT ALERT! Sending decoy message");
            Toast.makeText(this, "Unsupported phone, this app only runs on Android 42", 1).show();
            System.exit(-1);
            return;
        }
        Log.d(PostLogin.class.getSimpleName(), "Environment looks safe, second flag is: " + CryptoUtils.unprotect("Ex8eHtEqz9Mu6/zqgMjQk5rum7+4TktTQW6gdAc="));
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GetUserData extends APIRequest {
        private final String userIdentifier;

        public GetUserData(String userIdentifier) {
            super(1, "/getuserinfo", null, null, new Response.Listener() { // from class: com.android.grafobank.activity.PostLogin$GetUserData$$ExternalSyntheticLambda0
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    PostLogin.GetUserData.lambda$new$0(r1, (String) obj);
                }
            });
            this.userIdentifier = userIdentifier;
        }

        static /* synthetic */ void lambda$new$0(PostLogin com$android$grafobank$activity$PostLogin$this, String response) {
            String id;
            try {
                JSONObject obj = new JSONObject(response);
                String result = obj.getString("message");
                if (result.equals("Success")) {
                    String id2 = obj.getString("id");
                    String username = obj.getString("username");
                    String password = obj.getString("password").replaceAll(".", "*");
                    String first_name = obj.getString("first_name");
                    String last_name = obj.getString("last_name");
                    id = String.format("User id: %s\nFirst Name: %s\nLast Name: %s\nUsername: %s\nPassword: %s", id2, first_name, last_name, username, password);
                } else {
                    id = "API Error: " + result;
                }
            } catch (Exception e) {
                id = "Error while rendering output";
            }
            new AlertDialog.Builder(com$android$grafobank$activity$PostLogin$this).setMessage(id).show();
        }

        @Override // com.android.grafobank.util.APIRequest, com.android.volley.Request
        protected Map<String, String> getParams() {
            HashMap<String, String> params = new HashMap<>();
            params.put("id", this.userIdentifier);
            return params;
        }
    }

    protected void getMyData() {
        this.requestQueue.add(new GetUserData("3"));
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
