package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzlk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzRJ;
    private float zzTc;
    private int zzTd;
    private int zzTe;
    private int zzTf;
    private int zzTg;
    private int zzTh;
    private int zzTi;
    private String zzTj;
    private int zzTk;
    private int zzTl;
    private int zzvc;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzTc = 1.0f;
        this.zzTd = 0;
        this.zzvc = 0;
        this.zzTe = -1;
        this.zzTf = 0;
        this.zzTg = -1;
        this.zzTh = 0;
        this.zzTi = 0;
        this.zzTj = null;
        this.zzTk = -1;
        this.zzTl = -1;
        this.zzRJ = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzlk.zzoX()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (!Typeface.SANS_SERIF.equals(typeface) && Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String zzG(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    private int zzbz(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.zzRJ == null) != (textTrackStyle.zzRJ == null)) {
            return false;
        }
        if (this.zzRJ == null || textTrackStyle.zzRJ == null || zzlh.zzd(this.zzRJ, textTrackStyle.zzRJ)) {
            return this.zzTc == textTrackStyle.zzTc && this.zzTd == textTrackStyle.zzTd && this.zzvc == textTrackStyle.zzvc && this.zzTe == textTrackStyle.zzTe && this.zzTf == textTrackStyle.zzTf && this.zzTg == textTrackStyle.zzTg && this.zzTi == textTrackStyle.zzTi && zzf.zza(this.zzTj, textTrackStyle.zzTj) && this.zzTk == textTrackStyle.zzTk && this.zzTl == textTrackStyle.zzTl;
        }
        return false;
    }

    public int getBackgroundColor() {
        return this.zzvc;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public int getEdgeColor() {
        return this.zzTf;
    }

    public int getEdgeType() {
        return this.zzTe;
    }

    public String getFontFamily() {
        return this.zzTj;
    }

    public int getFontGenericFamily() {
        return this.zzTk;
    }

    public float getFontScale() {
        return this.zzTc;
    }

    public int getFontStyle() {
        return this.zzTl;
    }

    public int getForegroundColor() {
        return this.zzTd;
    }

    public int getWindowColor() {
        return this.zzTh;
    }

    public int getWindowCornerRadius() {
        return this.zzTi;
    }

    public int getWindowType() {
        return this.zzTg;
    }

    public int hashCode() {
        return zzt.hashCode(Float.valueOf(this.zzTc), Integer.valueOf(this.zzTd), Integer.valueOf(this.zzvc), Integer.valueOf(this.zzTe), Integer.valueOf(this.zzTf), Integer.valueOf(this.zzTg), Integer.valueOf(this.zzTh), Integer.valueOf(this.zzTi), this.zzTj, Integer.valueOf(this.zzTk), Integer.valueOf(this.zzTl), this.zzRJ);
    }

    public void setBackgroundColor(int i) {
        this.zzvc = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzTf = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzTe = i;
    }

    public void setFontFamily(String str) {
        this.zzTj = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzTk = i;
    }

    public void setFontScale(float f) {
        this.zzTc = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzTl = i;
    }

    public void setForegroundColor(int i) {
        this.zzTd = i;
    }

    public void setWindowColor(int i) {
        this.zzTh = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzTi = i;
    }

    public void setWindowType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzTg = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7 A[Catch: JSONException -> 0x00d6, TryCatch #0 {JSONException -> 0x00d6, blocks: (B:3:0x0005, B:5:0x0011, B:6:0x001c, B:8:0x0020, B:9:0x002b, B:13:0x0037, B:17:0x0044, B:18:0x0047, B:20:0x004b, B:21:0x0056, B:24:0x0060, B:25:0x0066, B:26:0x006a, B:27:0x006d, B:29:0x0071, B:30:0x007c, B:32:0x0081, B:33:0x0088, B:35:0x008c, B:36:0x0093, B:40:0x009d, B:47:0x00b3, B:51:0x00bd, B:54:0x00c7, B:55:0x00ca, B:57:0x00ce), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce A[Catch: JSONException -> 0x00d6, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00d6, blocks: (B:3:0x0005, B:5:0x0011, B:6:0x001c, B:8:0x0020, B:9:0x002b, B:13:0x0037, B:17:0x0044, B:18:0x0047, B:20:0x004b, B:21:0x0056, B:24:0x0060, B:25:0x0066, B:26:0x006a, B:27:0x006d, B:29:0x0071, B:30:0x007c, B:32:0x0081, B:33:0x0088, B:35:0x008c, B:36:0x0093, B:40:0x009d, B:47:0x00b3, B:51:0x00bd, B:54:0x00c7, B:55:0x00ca, B:57:0x00ce), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject toJson() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.TextTrackStyle.toJson():org.json.JSONObject");
    }

    public void zzf(JSONObject jSONObject) throws JSONException {
        int i;
        clear();
        this.zzTc = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzTd = zzbz(jSONObject.optString("foregroundColor"));
        this.zzvc = zzbz(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzTe = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzTe = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzTe = 2;
            } else if ("RAISED".equals(string)) {
                this.zzTe = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzTe = 4;
            }
        }
        this.zzTf = zzbz(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzTg = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzTg = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzTg = 2;
            }
        }
        this.zzTh = zzbz(jSONObject.optString("windowColor"));
        if (this.zzTg == 2) {
            this.zzTi = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzTj = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzTk = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzTk = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzTk = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzTk = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzTk = 4;
            } else {
                if (!"CURSIVE".equals(string3)) {
                    i = "SMALL_CAPITALS".equals(string3) ? 6 : 5;
                }
                this.zzTk = i;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzTl = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzTl = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzTl = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzTl = 3;
            }
        }
        this.zzRJ = jSONObject.optJSONObject("customData");
    }
}
