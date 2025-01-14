package com.android.volley;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class Header {
    private final String mName;
    private final String mValue;

    public Header(String name, String value) {
        this.mName = name;
        this.mValue = value;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Header header = (Header) o;
        if (TextUtils.equals(this.mName, header.mName) && TextUtils.equals(this.mValue, header.mValue)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.mName.hashCode();
        return (result * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
    }
}
