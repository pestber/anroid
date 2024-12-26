package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
    String mName;
    final int zzCY;
    String zzEl;
    String zzF;
    String zzKI;
    final Set<Integer> zzaHQ;
    ItemScopeEntity zzaHR;
    List<String> zzaHS;
    ItemScopeEntity zzaHT;
    String zzaHU;
    String zzaHV;
    String zzaHW;
    List<ItemScopeEntity> zzaHX;
    int zzaHY;
    List<ItemScopeEntity> zzaHZ;
    String zzaIA;
    String zzaIB;
    ItemScopeEntity zzaIC;
    String zzaID;
    String zzaIE;
    String zzaIF;
    ItemScopeEntity zzaIG;
    String zzaIH;
    String zzaII;
    String zzaIJ;
    String zzaIK;
    ItemScopeEntity zzaIa;
    List<ItemScopeEntity> zzaIb;
    String zzaIc;
    String zzaId;
    ItemScopeEntity zzaIe;
    String zzaIf;
    String zzaIg;
    List<ItemScopeEntity> zzaIh;
    String zzaIi;
    String zzaIj;
    String zzaIk;
    String zzaIl;
    String zzaIm;
    String zzaIn;
    String zzaIo;
    String zzaIp;
    ItemScopeEntity zzaIq;
    String zzaIr;
    String zzaIs;
    String zzaIt;
    ItemScopeEntity zzaIu;
    ItemScopeEntity zzaIv;
    ItemScopeEntity zzaIw;
    List<ItemScopeEntity> zzaIx;
    String zzaIy;
    String zzaIz;
    String zzakM;
    double zzaxB;
    double zzaxC;
    String zzsB;

    static {
        zzaHP.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
        zzaHP.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
        zzaHP.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
        zzaHP.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
        zzaHP.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
        zzaHP.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
        zzaHP.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzaHP.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzaHP.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzaHP.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
        zzaHP.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
        zzaHP.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
        zzaHP.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
        zzaHP.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzaHP.put("caption", FastJsonResponse.Field.zzl("caption", 16));
        zzaHP.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
        zzaHP.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
        zzaHP.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzaHP.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
        zzaHP.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
        zzaHP.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
        zzaHP.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzaHP.put("duration", FastJsonResponse.Field.zzl("duration", 24));
        zzaHP.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
        zzaHP.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
        zzaHP.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
        zzaHP.put("gender", FastJsonResponse.Field.zzl("gender", 28));
        zzaHP.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
        zzaHP.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
        zzaHP.put("height", FastJsonResponse.Field.zzl("height", 31));
        zzaHP.put("id", FastJsonResponse.Field.zzl("id", 32));
        zzaHP.put("image", FastJsonResponse.Field.zzl("image", 33));
        zzaHP.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzaHP.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
        zzaHP.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
        zzaHP.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
        zzaHP.put("name", FastJsonResponse.Field.zzl("name", 39));
        zzaHP.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzaHP.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
        zzaHP.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
        zzaHP.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzaHP.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
        zzaHP.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
        zzaHP.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzaHP.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
        zzaHP.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
        zzaHP.put("text", FastJsonResponse.Field.zzl("text", 49));
        zzaHP.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzaHP.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzaHP.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzaHP.put("type", FastJsonResponse.Field.zzl("type", 53));
        zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzaHP.put("width", FastJsonResponse.Field.zzl("width", 55));
        zzaHP.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    ItemScopeEntity(Set<Integer> set, int i, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i2, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzaHQ = set;
        this.zzCY = i;
        this.zzaHR = itemScopeEntity;
        this.zzaHS = list;
        this.zzaHT = itemScopeEntity2;
        this.zzaHU = str;
        this.zzaHV = str2;
        this.zzaHW = str3;
        this.zzaHX = list2;
        this.zzaHY = i2;
        this.zzaHZ = list3;
        this.zzaIa = itemScopeEntity3;
        this.zzaIb = list4;
        this.zzaIc = str4;
        this.zzaId = str5;
        this.zzaIe = itemScopeEntity4;
        this.zzaIf = str6;
        this.zzaIg = str7;
        this.zzsB = str8;
        this.zzaIh = list5;
        this.zzaIi = str9;
        this.zzaIj = str10;
        this.zzaIk = str11;
        this.zzakM = str12;
        this.zzaIl = str13;
        this.zzaIm = str14;
        this.zzaIn = str15;
        this.zzaIo = str16;
        this.zzaIp = str17;
        this.zzaIq = itemScopeEntity5;
        this.zzaIr = str18;
        this.zzaIs = str19;
        this.zzKI = str20;
        this.zzaIt = str21;
        this.zzaIu = itemScopeEntity6;
        this.zzaxB = d;
        this.zzaIv = itemScopeEntity7;
        this.zzaxC = d2;
        this.mName = str22;
        this.zzaIw = itemScopeEntity8;
        this.zzaIx = list6;
        this.zzaIy = str23;
        this.zzaIz = str24;
        this.zzaIA = str25;
        this.zzaIB = str26;
        this.zzaIC = itemScopeEntity9;
        this.zzaID = str27;
        this.zzaIE = str28;
        this.zzaIF = str29;
        this.zzaIG = itemScopeEntity10;
        this.zzaIH = str30;
        this.zzaII = str31;
        this.zzEl = str32;
        this.zzF = str33;
        this.zzaIJ = str34;
        this.zzaIK = str35;
    }

    public ItemScopeEntity(Set<Integer> set, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzaHQ = set;
        this.zzCY = 1;
        this.zzaHR = itemScopeEntity;
        this.zzaHS = list;
        this.zzaHT = itemScopeEntity2;
        this.zzaHU = str;
        this.zzaHV = str2;
        this.zzaHW = str3;
        this.zzaHX = list2;
        this.zzaHY = i;
        this.zzaHZ = list3;
        this.zzaIa = itemScopeEntity3;
        this.zzaIb = list4;
        this.zzaIc = str4;
        this.zzaId = str5;
        this.zzaIe = itemScopeEntity4;
        this.zzaIf = str6;
        this.zzaIg = str7;
        this.zzsB = str8;
        this.zzaIh = list5;
        this.zzaIi = str9;
        this.zzaIj = str10;
        this.zzaIk = str11;
        this.zzakM = str12;
        this.zzaIl = str13;
        this.zzaIm = str14;
        this.zzaIn = str15;
        this.zzaIo = str16;
        this.zzaIp = str17;
        this.zzaIq = itemScopeEntity5;
        this.zzaIr = str18;
        this.zzaIs = str19;
        this.zzKI = str20;
        this.zzaIt = str21;
        this.zzaIu = itemScopeEntity6;
        this.zzaxB = d;
        this.zzaIv = itemScopeEntity7;
        this.zzaxC = d2;
        this.mName = str22;
        this.zzaIw = itemScopeEntity8;
        this.zzaIx = list6;
        this.zzaIy = str23;
        this.zzaIz = str24;
        this.zzaIA = str25;
        this.zzaIB = str26;
        this.zzaIC = itemScopeEntity9;
        this.zzaID = str27;
        this.zzaIE = str28;
        this.zzaIF = str29;
        this.zzaIG = itemScopeEntity10;
        this.zzaIH = str30;
        this.zzaII = str31;
        this.zzEl = str32;
        this.zzF = str33;
        this.zzaIJ = str34;
        this.zzaIK = str35;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field) || !zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAbout() {
        return this.zzaHR;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<String> getAdditionalName() {
        return this.zzaHS;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAddress() {
        return this.zzaHT;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressCountry() {
        return this.zzaHU;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressLocality() {
        return this.zzaHV;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressRegion() {
        return this.zzaHW;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzaHX;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public int getAttendeeCount() {
        return this.zzaHY;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzaHZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAudio() {
        return this.zzaIa;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzaIb;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBestRating() {
        return this.zzaIc;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBirthDate() {
        return this.zzaId;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getByArtist() {
        return this.zzaIe;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getCaption() {
        return this.zzaIf;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentSize() {
        return this.zzaIg;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentUrl() {
        return this.zzsB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzaIh;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateCreated() {
        return this.zzaIi;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateModified() {
        return this.zzaIj;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDatePublished() {
        return this.zzaIk;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDuration() {
        return this.zzaIl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEmbedUrl() {
        return this.zzaIm;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEndDate() {
        return this.zzaIn;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getFamilyName() {
        return this.zzaIo;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGender() {
        return this.zzaIp;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getGeo() {
        return this.zzaIq;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGivenName() {
        return this.zzaIr;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getHeight() {
        return this.zzaIs;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getImage() {
        return this.zzaIt;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getInAlbum() {
        return this.zzaIu;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLatitude() {
        return this.zzaxB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getLocation() {
        return this.zzaIv;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLongitude() {
        return this.zzaxC;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getPartOfTVSeries() {
        return this.zzaIw;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzaIx;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPlayerType() {
        return this.zzaIy;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostOfficeBoxNumber() {
        return this.zzaIz;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostalCode() {
        return this.zzaIA;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getRatingValue() {
        return this.zzaIB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getReviewRating() {
        return this.zzaIC;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStartDate() {
        return this.zzaID;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStreetAddress() {
        return this.zzaIE;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getText() {
        return this.zzaIF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getThumbnail() {
        return this.zzaIG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getThumbnailUrl() {
        return this.zzaIH;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getTickerSymbol() {
        return this.zzaII;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getType() {
        return this.zzEl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWidth() {
        return this.zzaIJ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWorstRating() {
        return this.zzaIK;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAbout() {
        return this.zzaHQ.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAdditionalName() {
        return this.zzaHQ.contains(3);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddress() {
        return this.zzaHQ.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressCountry() {
        return this.zzaHQ.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressLocality() {
        return this.zzaHQ.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressRegion() {
        return this.zzaHQ.contains(7);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAssociated_media() {
        return this.zzaHQ.contains(8);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendeeCount() {
        return this.zzaHQ.contains(9);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendees() {
        return this.zzaHQ.contains(10);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAudio() {
        return this.zzaHQ.contains(11);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAuthor() {
        return this.zzaHQ.contains(12);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBestRating() {
        return this.zzaHQ.contains(13);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBirthDate() {
        return this.zzaHQ.contains(14);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasByArtist() {
        return this.zzaHQ.contains(15);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasCaption() {
        return this.zzaHQ.contains(16);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentSize() {
        return this.zzaHQ.contains(17);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentUrl() {
        return this.zzaHQ.contains(18);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContributor() {
        return this.zzaHQ.contains(19);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateCreated() {
        return this.zzaHQ.contains(20);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateModified() {
        return this.zzaHQ.contains(21);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDatePublished() {
        return this.zzaHQ.contains(22);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDescription() {
        return this.zzaHQ.contains(23);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDuration() {
        return this.zzaHQ.contains(24);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEmbedUrl() {
        return this.zzaHQ.contains(25);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEndDate() {
        return this.zzaHQ.contains(26);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasFamilyName() {
        return this.zzaHQ.contains(27);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGender() {
        return this.zzaHQ.contains(28);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGeo() {
        return this.zzaHQ.contains(29);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGivenName() {
        return this.zzaHQ.contains(30);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasHeight() {
        return this.zzaHQ.contains(31);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasId() {
        return this.zzaHQ.contains(32);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasImage() {
        return this.zzaHQ.contains(33);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasInAlbum() {
        return this.zzaHQ.contains(34);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLatitude() {
        return this.zzaHQ.contains(36);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLocation() {
        return this.zzaHQ.contains(37);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLongitude() {
        return this.zzaHQ.contains(38);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasName() {
        return this.zzaHQ.contains(39);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPartOfTVSeries() {
        return this.zzaHQ.contains(40);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPerformers() {
        return this.zzaHQ.contains(41);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPlayerType() {
        return this.zzaHQ.contains(42);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostOfficeBoxNumber() {
        return this.zzaHQ.contains(43);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostalCode() {
        return this.zzaHQ.contains(44);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasRatingValue() {
        return this.zzaHQ.contains(45);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasReviewRating() {
        return this.zzaHQ.contains(46);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStartDate() {
        return this.zzaHQ.contains(47);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStreetAddress() {
        return this.zzaHQ.contains(48);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasText() {
        return this.zzaHQ.contains(49);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnail() {
        return this.zzaHQ.contains(50);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnailUrl() {
        return this.zzaHQ.contains(51);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasTickerSymbol() {
        return this.zzaHQ.contains(52);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasType() {
        return this.zzaHQ.contains(53);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasUrl() {
        return this.zzaHQ.contains(54);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWidth() {
        return this.zzaHQ.contains(55);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWorstRating() {
        return this.zzaHQ.contains(56);
    }

    public int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
            if (zza(field)) {
                i = i + field.zzot() + zzb(field).hashCode();
            }
        }
        return i;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzaHR;
            case 3:
                return this.zzaHS;
            case 4:
                return this.zzaHT;
            case 5:
                return this.zzaHU;
            case 6:
                return this.zzaHV;
            case 7:
                return this.zzaHW;
            case 8:
                return this.zzaHX;
            case 9:
                return Integer.valueOf(this.zzaHY);
            case 10:
                return this.zzaHZ;
            case 11:
                return this.zzaIa;
            case 12:
                return this.zzaIb;
            case 13:
                return this.zzaIc;
            case 14:
                return this.zzaId;
            case 15:
                return this.zzaIe;
            case 16:
                return this.zzaIf;
            case 17:
                return this.zzaIg;
            case 18:
                return this.zzsB;
            case 19:
                return this.zzaIh;
            case 20:
                return this.zzaIi;
            case 21:
                return this.zzaIj;
            case 22:
                return this.zzaIk;
            case 23:
                return this.zzakM;
            case 24:
                return this.zzaIl;
            case 25:
                return this.zzaIm;
            case 26:
                return this.zzaIn;
            case 27:
                return this.zzaIo;
            case 28:
                return this.zzaIp;
            case 29:
                return this.zzaIq;
            case 30:
                return this.zzaIr;
            case 31:
                return this.zzaIs;
            case 32:
                return this.zzKI;
            case 33:
                return this.zzaIt;
            case 34:
                return this.zzaIu;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            case 36:
                return Double.valueOf(this.zzaxB);
            case 37:
                return this.zzaIv;
            case 38:
                return Double.valueOf(this.zzaxC);
            case 39:
                return this.mName;
            case 40:
                return this.zzaIw;
            case 41:
                return this.zzaIx;
            case 42:
                return this.zzaIy;
            case 43:
                return this.zzaIz;
            case 44:
                return this.zzaIA;
            case 45:
                return this.zzaIB;
            case 46:
                return this.zzaIC;
            case 47:
                return this.zzaID;
            case 48:
                return this.zzaIE;
            case 49:
                return this.zzaIF;
            case 50:
                return this.zzaIG;
            case 51:
                return this.zzaIH;
            case 52:
                return this.zzaII;
            case 53:
                return this.zzEl;
            case 54:
                return this.zzF;
            case 55:
                return this.zzaIJ;
            case 56:
                return this.zzaIK;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
        return zzaHP;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxG, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity freeze() {
        return this;
    }
}
