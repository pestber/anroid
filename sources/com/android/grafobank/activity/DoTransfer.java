package com.android.grafobank.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.grafobank.R;
import com.android.grafobank.activity.DoTransfer;
import com.android.grafobank.util.APIRequest;
import com.android.grafobank.util.CryptoUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.actions.SearchIntents;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DoTransfer extends Activity {
    public static final String MYPREFS2 = "mySharedPreferences";
    String acc1;
    String acc2;
    EditText amount;
    EditText from;
    Button getAccounts;
    JSONObject jsonObject;
    String passNormalized;
    RequestQueue requestQueue;
    SharedPreferences serverDetails;
    EditText to;
    Button transfer;
    String usernameBase64ByteString;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestQueue = Volley.newRequestQueue(getApplicationContext());
        setContentView(R.layout.activity_do_transfer);
        this.serverDetails = PreferenceManager.getDefaultSharedPreferences(this);
        this.transfer = (Button) findViewById(R.id.button_Transfer);
        this.transfer.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.DoTransfer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.getAccounts = (Button) findViewById(R.id.button_getAccounts);
        this.getAccounts.setOnClickListener(new View.OnClickListener() { // from class: com.android.grafobank.activity.DoTransfer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View v) {
        this.from = (EditText) findViewById(R.id.editText_from);
        this.to = (EditText) findViewById(R.id.editText_to);
        SharedPreferences settings = getSharedPreferences("mySharedPreferences", 0);
        String username = settings.getString("EncryptedUsername", null);
        byte[] usernameBase64Byte = Base64.decode(username, 0);
        this.usernameBase64ByteString = new String(usernameBase64Byte, StandardCharsets.UTF_8);
        String password = settings.getString("superSecurePassword", null);
        this.passNormalized = CryptoUtils.aesDeccryptedString(password);
        TransferRequest transferRequest = new TransferRequest(this.usernameBase64ByteString, this.passNormalized, this.from.getText().toString(), this.to.getText().toString(), this.amount.getText().toString());
        this.requestQueue.add(transferRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View v) {
        SharedPreferences settings = getSharedPreferences("mySharedPreferences", 0);
        String username = settings.getString("EncryptedUsername", null);
        byte[] usernameBase64Byte = Base64.decode(username, 0);
        this.usernameBase64ByteString = new String(usernameBase64Byte, StandardCharsets.UTF_8);
        String password = settings.getString("superSecurePassword", null);
        this.passNormalized = CryptoUtils.aesDeccryptedString(password);
        GetAccountsRequest request = new GetAccountsRequest(this.usernameBase64ByteString, this.passNormalized);
        this.requestQueue.add(request);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_exit /* 2131165192 */:
                Intent i = new Intent(getBaseContext(), (Class<?>) LoginActivity.class);
                i.addFlags(67108864);
                startActivity(i);
                return true;
            case R.id.action_settings /* 2131165198 */:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class TransferRequest extends APIRequest {
        private final String from_acc;
        private final String to_acc;
        private final String transfer_amount;

        public TransferRequest(String user, String password, final String from, String to_acc, final String amount) {
            super(1, "/dotransfer", user, password, new Response.Listener() { // from class: com.android.grafobank.activity.DoTransfer$TransferRequest$$ExternalSyntheticLambda0
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    DoTransfer.TransferRequest.lambda$new$0(from, amount, r3, (String) obj);
                }
            });
            this.from_acc = from;
            this.to_acc = to_acc;
            this.transfer_amount = amount;
        }

        static /* synthetic */ void lambda$new$0(String from, String amount, DoTransfer com$android$grafobank$activity$DoTransfer$this, String response) {
            if (response.contains("Success")) {
                Toast.makeText(com$android$grafobank$activity$DoTransfer$this, "Transfer Successful!!", 0).show();
                try {
                    com$android$grafobank$activity$DoTransfer$this.jsonObject = new JSONObject(response);
                    com$android$grafobank$activity$DoTransfer$this.acc1 = com$android$grafobank$activity$DoTransfer$this.jsonObject.getString("from");
                    com$android$grafobank$activity$DoTransfer$this.acc2 = com$android$grafobank$activity$DoTransfer$this.jsonObject.getString("to");
                    System.out.println("Message:" + com$android$grafobank$activity$DoTransfer$this.jsonObject.getString("message") + " From:" + from + " To:" + com$android$grafobank$activity$DoTransfer$this.to.getText().toString() + " Amount:" + amount);
                    String status = "\nMessage:Success From:" + from + " To:" + com$android$grafobank$activity$DoTransfer$this.to.getText().toString() + " Amount:" + amount + "\n";
                    String MYFILE = Environment.getExternalStorageDirectory() + "/Statements_" + com$android$grafobank$activity$DoTransfer$this.usernameBase64ByteString + ".html";
                    BufferedWriter out2 = new BufferedWriter(new FileWriter(MYFILE, true));
                    out2.write(status);
                    out2.write("<hr>");
                    out2.close();
                    return;
                } catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            Toast.makeText(com$android$grafobank$activity$DoTransfer$this, "Transfer Failed!", 0).show();
        }

        @Override // com.android.grafobank.util.APIRequest, com.android.volley.Request
        protected Map<String, String> getParams() {
            Map<String, String> pars = super.getParams();
            pars.put("from_acc", this.from_acc);
            pars.put("to_acc", this.to_acc);
            pars.put("amount", this.transfer_amount);
            return pars;
        }
    }

    public class GetAccountsRequest extends APIRequest {
        public GetAccountsRequest(String username, String password) {
            super(1, "/getaccounts", username, password, new Response.Listener() { // from class: com.android.grafobank.activity.DoTransfer$GetAccountsRequest$$ExternalSyntheticLambda0
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    DoTransfer.GetAccountsRequest.lambda$new$0(r1, (String) obj);
                }
            });
        }

        static /* synthetic */ void lambda$new$0(DoTransfer com$android$grafobank$activity$DoTransfer$this, String response) {
            String msg;
            try {
                try {
                    JSONObject obj = new JSONObject(response);
                    String result = obj.getString("message");
                    if (result.equals("Success")) {
                        StringBuilder sb = new StringBuilder();
                        JSONArray data = obj.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject account = data.getJSONObject(i);
                            String id = account.getString("id");
                            String account_number = account.getString("account_number");
                            String type = account.getString("type");
                            String balance = account.getString("balance");
                            String user_id = account.getString("user_id");
                            String user = account.getString("user");
                            sb.append("Id: ").append(id).append("\n");
                            sb.append("Account Number: ").append(account_number).append("\n");
                            sb.append("Type: ").append(type).append("\n");
                            sb.append("Balance: ").append(balance).append("\n");
                            sb.append("User ID: ").append(user_id).append("\n");
                            sb.append("Username: ").append(user).append("\n");
                            if (i < data.length() - 1) {
                                sb.append("------------\n");
                            }
                        }
                        msg = sb.toString();
                    } else {
                        msg = "API Error: " + result;
                    }
                } catch (Exception e) {
                    e = e;
                    String msg2 = "Android Error: " + e.getMessage();
                    msg = msg2;
                    new AlertDialog.Builder(com$android$grafobank$activity$DoTransfer$this).setMessage(msg).show();
                }
            } catch (Exception e2) {
                e = e2;
            }
            new AlertDialog.Builder(com$android$grafobank$activity$DoTransfer$this).setMessage(msg).show();
        }

        @Override // com.android.grafobank.util.APIRequest, com.android.volley.Request
        protected Map<String, String> getParams() {
            Map<String, String> params = super.getParams();
            String query = buildQuery(this.username);
            params.put(SearchIntents.EXTRA_QUERY, query);
            params.put("signature", calculateSignature(query));
            return params;
        }

        private static String buildQuery(String username) {
            return String.format("SELECT * FROM accounts WHERE user = '%s'", username);
        }

        private static String calculateSignature(String query) {
            CRC32 crc = new CRC32();
            crc.update(query.getBytes());
            return String.valueOf(crc.getValue());
        }
    }
}
