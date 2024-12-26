package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class PlayerColumnNames {
    public final String zzasV;
    public final String zzasW;
    public final String zzasX;
    public final String zzasY;
    public final String zzasZ;
    public final String zzata;
    public final String zzatb;
    public final String zzatc;
    public final String zzatd;
    public final String zzate;
    public final String zzatf;
    public final String zzatg;
    public final String zzath;
    public final String zzati;
    public final String zzatj;
    public final String zzatk;
    public final String zzatl;
    public final String zzatm;
    public final String zzatn;
    public final String zzato;
    public final String zzatp;
    public final String zzatq;
    public final String zzatr;
    public final String zzats;
    public final String zzatt;
    public final String zzatu;

    public PlayerColumnNames(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzasV = "external_player_id";
            this.zzasW = "profile_name";
            this.zzasX = "profile_icon_image_uri";
            this.zzasY = "profile_icon_image_url";
            this.zzasZ = "profile_hi_res_image_uri";
            this.zzata = "profile_hi_res_image_url";
            this.zzatb = "last_updated";
            this.zzatc = "is_in_circles";
            this.zzatd = "played_with_timestamp";
            this.zzate = "current_xp_total";
            this.zzatf = "current_level";
            this.zzatg = "current_level_min_xp";
            this.zzath = "current_level_max_xp";
            this.zzati = "next_level";
            this.zzatj = "next_level_max_xp";
            this.zzatk = "last_level_up_timestamp";
            this.zzatl = "player_title";
            this.zzatm = "has_all_public_acls";
            this.zzatn = "is_profile_visible";
            this.zzato = "most_recent_external_game_id";
            this.zzatp = "most_recent_game_name";
            this.zzatq = "most_recent_activity_timestamp";
            this.zzatr = "most_recent_game_icon_uri";
            this.zzats = "most_recent_game_hi_res_uri";
            this.zzatt = "most_recent_game_featured_uri";
            this.zzatu = "has_debug_access";
            return;
        }
        this.zzasV = str + "external_player_id";
        this.zzasW = str + "profile_name";
        this.zzasX = str + "profile_icon_image_uri";
        this.zzasY = str + "profile_icon_image_url";
        this.zzasZ = str + "profile_hi_res_image_uri";
        this.zzata = str + "profile_hi_res_image_url";
        this.zzatb = str + "last_updated";
        this.zzatc = str + "is_in_circles";
        this.zzatd = str + "played_with_timestamp";
        this.zzate = str + "current_xp_total";
        this.zzatf = str + "current_level";
        this.zzatg = str + "current_level_min_xp";
        this.zzath = str + "current_level_max_xp";
        this.zzati = str + "next_level";
        this.zzatj = str + "next_level_max_xp";
        this.zzatk = str + "last_level_up_timestamp";
        this.zzatl = str + "player_title";
        this.zzatm = str + "has_all_public_acls";
        this.zzatn = str + "is_profile_visible";
        this.zzato = str + "most_recent_external_game_id";
        this.zzatp = str + "most_recent_game_name";
        this.zzatq = str + "most_recent_activity_timestamp";
        this.zzatr = str + "most_recent_game_icon_uri";
        this.zzats = str + "most_recent_game_hi_res_uri";
        this.zzatt = str + "most_recent_game_featured_uri";
        this.zzatu = str + "has_debug_access";
    }
}
