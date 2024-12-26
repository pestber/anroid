package com.android.grafobank.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.util.Base64;
import com.android.grafobank.util.CryptoUtils;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class MyBroadCastReceiver extends BroadcastReceiver {
    public static final String MYPREFS = "mySharedPreferences";
    String usernameBase64ByteString;

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String phn = intent.getStringExtra("phonenumber");
        String newpass = intent.getStringExtra("newpass");
        if (phn != null) {
            try {
                SharedPreferences settings = context.getSharedPreferences("mySharedPreferences", 1);
                String username = settings.getString("EncryptedUsername", null);
                byte[] usernameBase64Byte = Base64.decode(username, 0);
                try {
                    this.usernameBase64ByteString = new String(usernameBase64Byte, StandardCharsets.UTF_8);
                    String password = settings.getString("superSecurePassword", null);
                    String decryptedPassword = CryptoUtils.aesDeccryptedString(password);
                    String textMessage = "Updated Password from: " + decryptedPassword + " to: " + newpass;
                    SmsManager smsManager = SmsManager.getDefault();
                    System.out.println("For the changepassword - phonenumber: " + phn + " password is: " + textMessage);
                    smsManager.sendTextMessage(phn, null, textMessage, null, null);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            System.out.println("Phone number is null");
        }
    }
}
