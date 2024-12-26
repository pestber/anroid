package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.location.places.Place;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzlh {
    private static final Pattern zzacL = Pattern.compile("\\\\.");
    private static final Pattern zzacM = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String zzcr(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zzacM.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case '\b':
                    str2 = "\\\\b";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '\t':
                    str2 = "\\\\t";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '\n':
                    str2 = "\\\\n";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '\f':
                    str2 = "\\\\f";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '\r':
                    str2 = "\\\\r";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '\"':
                    str2 = "\\\\\\\"";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case '/':
                    str2 = "\\\\/";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
                case Place.TYPE_TRAIN_STATION /* 92 */:
                    str2 = "\\\\\\\\";
                    matcher.appendReplacement(stringBuffer, str2);
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean zzd(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                try {
                    if (!zzd(jSONObject.get(next), jSONObject2.get(next))) {
                        return false;
                    }
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        }
        JSONArray jSONArray = (JSONArray) obj;
        JSONArray jSONArray2 = (JSONArray) obj2;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!zzd(jSONArray.get(i), jSONArray2.get(i))) {
                    return false;
                }
            } catch (JSONException e2) {
                return false;
            }
        }
        return true;
    }
}
