package com.android.grafobank.util;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class APIRequest extends StringRequest {
    protected final String password;
    protected final String username;

    public APIRequest(int method, String endpoint, String username, String password, Response.Listener<String> listener) {
        super(method, Constants.API_URL + endpoint, listener, new Response.ErrorListener() { // from class: com.android.grafobank.util.APIRequest$$ExternalSyntheticLambda0
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                Log.e("APIRequest", "API Error: " + volleyError);
            }
        });
        this.username = username;
        this.password = password;
    }

    @Override // com.android.volley.Request
    protected Map<String, String> getParams() {
        Map<String, String> pars = new HashMap<>();
        pars.put("username", this.username);
        pars.put("password", this.password);
        return pars;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> pars = new HashMap<>();
        pars.put(HttpHeaderParser.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded");
        return pars;
    }
}
