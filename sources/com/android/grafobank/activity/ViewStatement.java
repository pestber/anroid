package com.android.grafobank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.android.grafobank.MyWebViewClient;
import com.android.grafobank.R;
import java.io.File;

/* loaded from: classes3.dex */
public class ViewStatement extends Activity {
    String uname;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_statement);
        Intent intent = getIntent();
        this.uname = intent.getStringExtra("uname");
        String FILENAME = "Statements_" + this.uname + ".html";
        File fileToCheck = new File(Environment.getExternalStorageDirectory(), FILENAME);
        System.out.println(fileToCheck);
        if (fileToCheck.exists()) {
            WebView mWebView = (WebView) findViewById(R.id.webView1);
            mWebView.loadUrl("file://" + Environment.getExternalStorageDirectory() + "/Statements_" + this.uname + ".html");
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setSaveFormData(true);
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.setWebViewClient(new MyWebViewClient());
            WebChromeClient cClient = new WebChromeClient();
            mWebView.setWebChromeClient(cClient);
            return;
        }
        Intent gobacktoPostLogin = new Intent(this, (Class<?>) PostLogin.class);
        startActivity(gobacktoPostLogin);
        Toast.makeText(this, "Statement does not Exist!!", 0).show();
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
