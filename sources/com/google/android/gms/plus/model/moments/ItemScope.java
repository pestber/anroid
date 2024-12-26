package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzEl;
        private String zzF;
        private String zzKI;
        private final Set<Integer> zzaHQ = new HashSet();
        private ItemScopeEntity zzaHR;
        private List<String> zzaHS;
        private ItemScopeEntity zzaHT;
        private String zzaHU;
        private String zzaHV;
        private String zzaHW;
        private List<ItemScopeEntity> zzaHX;
        private int zzaHY;
        private List<ItemScopeEntity> zzaHZ;
        private String zzaIA;
        private String zzaIB;
        private ItemScopeEntity zzaIC;
        private String zzaID;
        private String zzaIE;
        private String zzaIF;
        private ItemScopeEntity zzaIG;
        private String zzaIH;
        private String zzaII;
        private String zzaIJ;
        private String zzaIK;
        private ItemScopeEntity zzaIa;
        private List<ItemScopeEntity> zzaIb;
        private String zzaIc;
        private String zzaId;
        private ItemScopeEntity zzaIe;
        private String zzaIf;
        private String zzaIg;
        private List<ItemScopeEntity> zzaIh;
        private String zzaIi;
        private String zzaIj;
        private String zzaIk;
        private String zzaIl;
        private String zzaIm;
        private String zzaIn;
        private String zzaIo;
        private String zzaIp;
        private ItemScopeEntity zzaIq;
        private String zzaIr;
        private String zzaIs;
        private String zzaIt;
        private ItemScopeEntity zzaIu;
        private ItemScopeEntity zzaIv;
        private ItemScopeEntity zzaIw;
        private List<ItemScopeEntity> zzaIx;
        private String zzaIy;
        private String zzaIz;
        private String zzakM;
        private double zzaxB;
        private double zzaxC;
        private String zzsB;

        public ItemScope build() {
            return new ItemScopeEntity(this.zzaHQ, this.zzaHR, this.zzaHS, this.zzaHT, this.zzaHU, this.zzaHV, this.zzaHW, this.zzaHX, this.zzaHY, this.zzaHZ, this.zzaIa, this.zzaIb, this.zzaIc, this.zzaId, this.zzaIe, this.zzaIf, this.zzaIg, this.zzsB, this.zzaIh, this.zzaIi, this.zzaIj, this.zzaIk, this.zzakM, this.zzaIl, this.zzaIm, this.zzaIn, this.zzaIo, this.zzaIp, this.zzaIq, this.zzaIr, this.zzaIs, this.zzKI, this.zzaIt, this.zzaIu, this.zzaxB, this.zzaIv, this.zzaxC, this.mName, this.zzaIw, this.zzaIx, this.zzaIy, this.zzaIz, this.zzaIA, this.zzaIB, this.zzaIC, this.zzaID, this.zzaIE, this.zzaIF, this.zzaIG, this.zzaIH, this.zzaII, this.zzEl, this.zzF, this.zzaIJ, this.zzaIK);
        }

        public Builder setAbout(ItemScope itemScope) {
            this.zzaHR = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(2);
            return this;
        }

        public Builder setAdditionalName(List<String> list) {
            this.zzaHS = list;
            this.zzaHQ.add(3);
            return this;
        }

        public Builder setAddress(ItemScope itemScope) {
            this.zzaHT = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(4);
            return this;
        }

        public Builder setAddressCountry(String str) {
            this.zzaHU = str;
            this.zzaHQ.add(5);
            return this;
        }

        public Builder setAddressLocality(String str) {
            this.zzaHV = str;
            this.zzaHQ.add(6);
            return this;
        }

        public Builder setAddressRegion(String str) {
            this.zzaHW = str;
            this.zzaHQ.add(7);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAssociated_media(List<ItemScope> list) {
            this.zzaHX = list;
            this.zzaHQ.add(8);
            return this;
        }

        public Builder setAttendeeCount(int i) {
            this.zzaHY = i;
            this.zzaHQ.add(9);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAttendees(List<ItemScope> list) {
            this.zzaHZ = list;
            this.zzaHQ.add(10);
            return this;
        }

        public Builder setAudio(ItemScope itemScope) {
            this.zzaIa = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(11);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAuthor(List<ItemScope> list) {
            this.zzaIb = list;
            this.zzaHQ.add(12);
            return this;
        }

        public Builder setBestRating(String str) {
            this.zzaIc = str;
            this.zzaHQ.add(13);
            return this;
        }

        public Builder setBirthDate(String str) {
            this.zzaId = str;
            this.zzaHQ.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope itemScope) {
            this.zzaIe = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(15);
            return this;
        }

        public Builder setCaption(String str) {
            this.zzaIf = str;
            this.zzaHQ.add(16);
            return this;
        }

        public Builder setContentSize(String str) {
            this.zzaIg = str;
            this.zzaHQ.add(17);
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zzsB = str;
            this.zzaHQ.add(18);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setContributor(List<ItemScope> list) {
            this.zzaIh = list;
            this.zzaHQ.add(19);
            return this;
        }

        public Builder setDateCreated(String str) {
            this.zzaIi = str;
            this.zzaHQ.add(20);
            return this;
        }

        public Builder setDateModified(String str) {
            this.zzaIj = str;
            this.zzaHQ.add(21);
            return this;
        }

        public Builder setDatePublished(String str) {
            this.zzaIk = str;
            this.zzaHQ.add(22);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzakM = str;
            this.zzaHQ.add(23);
            return this;
        }

        public Builder setDuration(String str) {
            this.zzaIl = str;
            this.zzaHQ.add(24);
            return this;
        }

        public Builder setEmbedUrl(String str) {
            this.zzaIm = str;
            this.zzaHQ.add(25);
            return this;
        }

        public Builder setEndDate(String str) {
            this.zzaIn = str;
            this.zzaHQ.add(26);
            return this;
        }

        public Builder setFamilyName(String str) {
            this.zzaIo = str;
            this.zzaHQ.add(27);
            return this;
        }

        public Builder setGender(String str) {
            this.zzaIp = str;
            this.zzaHQ.add(28);
            return this;
        }

        public Builder setGeo(ItemScope itemScope) {
            this.zzaIq = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(29);
            return this;
        }

        public Builder setGivenName(String str) {
            this.zzaIr = str;
            this.zzaHQ.add(30);
            return this;
        }

        public Builder setHeight(String str) {
            this.zzaIs = str;
            this.zzaHQ.add(31);
            return this;
        }

        public Builder setId(String str) {
            this.zzKI = str;
            this.zzaHQ.add(32);
            return this;
        }

        public Builder setImage(String str) {
            this.zzaIt = str;
            this.zzaHQ.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope itemScope) {
            this.zzaIu = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(34);
            return this;
        }

        public Builder setLatitude(double d) {
            this.zzaxB = d;
            this.zzaHQ.add(36);
            return this;
        }

        public Builder setLocation(ItemScope itemScope) {
            this.zzaIv = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(37);
            return this;
        }

        public Builder setLongitude(double d) {
            this.zzaxC = d;
            this.zzaHQ.add(38);
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            this.zzaHQ.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemScope) {
            this.zzaIw = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(40);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setPerformers(List<ItemScope> list) {
            this.zzaIx = list;
            this.zzaHQ.add(41);
            return this;
        }

        public Builder setPlayerType(String str) {
            this.zzaIy = str;
            this.zzaHQ.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String str) {
            this.zzaIz = str;
            this.zzaHQ.add(43);
            return this;
        }

        public Builder setPostalCode(String str) {
            this.zzaIA = str;
            this.zzaHQ.add(44);
            return this;
        }

        public Builder setRatingValue(String str) {
            this.zzaIB = str;
            this.zzaHQ.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope itemScope) {
            this.zzaIC = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(46);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzaID = str;
            this.zzaHQ.add(47);
            return this;
        }

        public Builder setStreetAddress(String str) {
            this.zzaIE = str;
            this.zzaHQ.add(48);
            return this;
        }

        public Builder setText(String str) {
            this.zzaIF = str;
            this.zzaHQ.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope itemScope) {
            this.zzaIG = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String str) {
            this.zzaIH = str;
            this.zzaHQ.add(51);
            return this;
        }

        public Builder setTickerSymbol(String str) {
            this.zzaII = str;
            this.zzaHQ.add(52);
            return this;
        }

        public Builder setType(String str) {
            this.zzEl = str;
            this.zzaHQ.add(53);
            return this;
        }

        public Builder setUrl(String str) {
            this.zzF = str;
            this.zzaHQ.add(54);
            return this;
        }

        public Builder setWidth(String str) {
            this.zzaIJ = str;
            this.zzaHQ.add(55);
            return this;
        }

        public Builder setWorstRating(String str) {
            this.zzaIK = str;
            this.zzaHQ.add(56);
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
