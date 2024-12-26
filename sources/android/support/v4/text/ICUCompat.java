package android.support.v4.text;

import android.os.Build;

/* loaded from: classes.dex */
public class ICUCompat {
    private static final ICUCompatImpl IMPL;

    interface ICUCompatImpl {
        String addLikelySubtags(String str);

        String getScript(String str);
    }

    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String locale) {
            return null;
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String locale) {
            return locale;
        }
    }

    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String locale) {
            return ICUCompatIcs.getScript(locale);
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String locale) {
            return ICUCompatIcs.addLikelySubtags(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        IMPL = new ICUCompatImplIcs();
    }

    public static String getScript(String locale) {
        return IMPL.getScript(locale);
    }

    public static String addLikelySubtags(String locale) {
        return IMPL.addLikelySubtags(locale);
    }
}
