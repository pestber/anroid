package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
    final int zzCY;
    String zzF;
    String zzKI;
    String zzRA;
    final Set<Integer> zzaHQ;
    String zzaIO;
    AgeRangeEntity zzaIP;
    String zzaIQ;
    String zzaIR;
    int zzaIS;
    CoverEntity zzaIT;
    String zzaIU;
    ImageEntity zzaIV;
    boolean zzaIW;
    NameEntity zzaIX;
    String zzaIY;
    int zzaIZ;
    List<OrganizationsEntity> zzaJa;
    List<PlacesLivedEntity> zzaJb;
    int zzaJc;
    int zzaJd;
    String zzaJe;
    List<UrlsEntity> zzaJf;
    boolean zzaJg;
    String zzadI;
    int zzsC;

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        final int zzCY;
        final Set<Integer> zzaHQ;
        int zzaJh;
        int zzaJi;

        static {
            zzaHP.put("max", FastJsonResponse.Field.zzi("max", 2));
            zzaHP.put("min", FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        AgeRangeEntity(Set<Integer> set, int i, int i2, int i3) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaJh = i2;
            this.zzaJi = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!ageRangeEntity.zza(field) || !zzb(field).equals(ageRangeEntity.zzb(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMax() {
            return this.zzaJh;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMin() {
            return this.zzaJi;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMax() {
            return this.zzaHQ.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMin() {
            return this.zzaHQ.contains(3);
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
            zzb.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            int i;
            switch (field.zzot()) {
                case 2:
                    i = this.zzaJh;
                    break;
                case 3:
                    i = this.zzaJi;
                    break;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
            return Integer.valueOf(i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxK, reason: merged with bridge method [inline-methods] */
        public AgeRangeEntity freeze() {
            return this;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        final int zzCY;
        final Set<Integer> zzaHQ;
        CoverInfoEntity zzaJj;
        CoverPhotoEntity zzaJk;
        int zzaJl;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
            final int zzCY;
            final Set<Integer> zzaHQ;
            int zzaJm;
            int zzaJn;

            static {
                zzaHP.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
                zzaHP.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.zzCY = 1;
                this.zzaHQ = new HashSet();
            }

            CoverInfoEntity(Set<Integer> set, int i, int i2, int i3) {
                this.zzaHQ = set;
                this.zzCY = i;
                this.zzaJm = i2;
                this.zzaJn = i3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                    if (zza(field)) {
                        if (!coverInfoEntity.zza(field) || !zzb(field).equals(coverInfoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getLeftImageOffset() {
                return this.zzaJm;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getTopImageOffset() {
                return this.zzaJn;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasLeftImageOffset() {
                return this.zzaHQ.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasTopImageOffset() {
                return this.zzaHQ.contains(3);
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
                zzd.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean zza(FastJsonResponse.Field field) {
                return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object zzb(FastJsonResponse.Field field) {
                int i;
                switch (field.zzot()) {
                    case 2:
                        i = this.zzaJm;
                        break;
                    case 3:
                        i = this.zzaJn;
                        break;
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
                }
                return Integer.valueOf(i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
                return zzaHP;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: zzxM, reason: merged with bridge method [inline-methods] */
            public CoverInfoEntity freeze() {
                return this;
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
            final int zzCY;
            String zzF;
            final Set<Integer> zzaHQ;
            int zznM;
            int zznN;

            static {
                zzaHP.put("height", FastJsonResponse.Field.zzi("height", 2));
                zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzaHP.put("width", FastJsonResponse.Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.zzCY = 1;
                this.zzaHQ = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzaHQ = set;
                this.zzCY = i;
                this.zznN = i2;
                this.zzF = str;
                this.zznM = i3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                    if (zza(field)) {
                        if (!coverPhotoEntity.zza(field) || !zzb(field).equals(coverPhotoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getHeight() {
                return this.zznN;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public String getUrl() {
                return this.zzF;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getWidth() {
                return this.zznM;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasHeight() {
                return this.zzaHQ.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasUrl() {
                return this.zzaHQ.contains(3);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasWidth() {
                return this.zzaHQ.contains(4);
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
                zze.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean zza(FastJsonResponse.Field field) {
                return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object zzb(FastJsonResponse.Field field) {
                int i;
                switch (field.zzot()) {
                    case 2:
                        i = this.zznN;
                        break;
                    case 3:
                        return this.zzF;
                    case 4:
                        i = this.zznM;
                        break;
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
                }
                return Integer.valueOf(i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
                return zzaHP;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: zzxN, reason: merged with bridge method [inline-methods] */
            public CoverPhotoEntity freeze() {
                return this;
            }
        }

        static {
            zzaHP.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzaHP.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzaHP.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        CoverEntity(Set<Integer> set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaJj = coverInfoEntity;
            this.zzaJk = coverPhotoEntity;
            this.zzaJl = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!coverEntity.zza(field) || !zzb(field).equals(coverEntity.zzb(field))) {
                        return false;
                    }
                } else if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverInfo getCoverInfo() {
            return this.zzaJj;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.zzaJk;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public int getLayout() {
            return this.zzaJl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverInfo() {
            return this.zzaHQ.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverPhoto() {
            return this.zzaHQ.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasLayout() {
            return this.zzaHQ.contains(4);
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
            zzc.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaJj;
                case 3:
                    return this.zzaJk;
                case 4:
                    return Integer.valueOf(this.zzaJl);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxL, reason: merged with bridge method [inline-methods] */
        public CoverEntity freeze() {
            return this;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        final int zzCY;
        String zzF;
        final Set<Integer> zzaHQ;

        static {
            zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        public ImageEntity(String str) {
            this.zzaHQ = new HashSet();
            this.zzCY = 1;
            this.zzF = str;
            this.zzaHQ.add(2);
        }

        ImageEntity(Set<Integer> set, int i, String str) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzF = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!imageEntity.zza(field) || !zzb(field).equals(imageEntity.zzb(field))) {
                        return false;
                    }
                } else if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public String getUrl() {
            return this.zzF;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public boolean hasUrl() {
            return this.zzaHQ.contains(2);
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
            zzf.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxO, reason: merged with bridge method [inline-methods] */
        public ImageEntity freeze() {
            return this;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        final int zzCY;
        final Set<Integer> zzaHQ;
        String zzaIo;
        String zzaIr;
        String zzaJo;
        String zzaJp;
        String zzaJq;
        String zzaJr;

        static {
            zzaHP.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
            zzaHP.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
            zzaHP.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
            zzaHP.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzaHP.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzaHP.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        NameEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaIo = str;
            this.zzaJo = str2;
            this.zzaIr = str3;
            this.zzaJp = str4;
            this.zzaJq = str5;
            this.zzaJr = str6;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!nameEntity.zza(field) || !zzb(field).equals(nameEntity.zzb(field))) {
                        return false;
                    }
                } else if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFamilyName() {
            return this.zzaIo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFormatted() {
            return this.zzaJo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getGivenName() {
            return this.zzaIr;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificPrefix() {
            return this.zzaJp;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificSuffix() {
            return this.zzaJq;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getMiddleName() {
            return this.zzaJr;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFamilyName() {
            return this.zzaHQ.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFormatted() {
            return this.zzaHQ.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasGivenName() {
            return this.zzaHQ.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificPrefix() {
            return this.zzaHQ.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificSuffix() {
            return this.zzaHQ.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasMiddleName() {
            return this.zzaHQ.contains(7);
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
            zzg.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaIo;
                case 3:
                    return this.zzaJo;
                case 4:
                    return this.zzaIr;
                case 5:
                    return this.zzaJp;
                case 6:
                    return this.zzaJq;
                case 7:
                    return this.zzaJr;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxP, reason: merged with bridge method [inline-methods] */
        public NameEntity freeze() {
            return this;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        String mName;
        final int zzCY;
        int zzSq;
        final Set<Integer> zzaHQ;
        String zzaID;
        String zzaIn;
        String zzaJs;
        String zzaJt;
        boolean zzaJu;
        String zzadv;
        String zzakM;

        static {
            zzaHP.put("department", FastJsonResponse.Field.zzl("department", 2));
            zzaHP.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzaHP.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
            zzaHP.put("location", FastJsonResponse.Field.zzl("location", 5));
            zzaHP.put("name", FastJsonResponse.Field.zzl("name", 6));
            zzaHP.put("primary", FastJsonResponse.Field.zzk("primary", 7));
            zzaHP.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
            zzaHP.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzaHP.put("type", FastJsonResponse.Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        OrganizationsEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaJs = str;
            this.zzakM = str2;
            this.zzaIn = str3;
            this.zzaJt = str4;
            this.mName = str5;
            this.zzaJu = z;
            this.zzaID = str6;
            this.zzadv = str7;
            this.zzSq = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!organizationsEntity.zza(field) || !zzb(field).equals(organizationsEntity.zzb(field))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDepartment() {
            return this.zzaJs;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDescription() {
            return this.zzakM;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getEndDate() {
            return this.zzaIn;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getLocation() {
            return this.zzaJt;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getStartDate() {
            return this.zzaID;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getTitle() {
            return this.zzadv;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public int getType() {
            return this.zzSq;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDepartment() {
            return this.zzaHQ.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDescription() {
            return this.zzaHQ.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasEndDate() {
            return this.zzaHQ.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasLocation() {
            return this.zzaHQ.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasName() {
            return this.zzaHQ.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasPrimary() {
            return this.zzaHQ.contains(7);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasStartDate() {
            return this.zzaHQ.contains(8);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasTitle() {
            return this.zzaHQ.contains(9);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasType() {
            return this.zzaHQ.contains(10);
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

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean isPrimary() {
            return this.zzaJu;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzh.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaJs;
                case 3:
                    return this.zzakM;
                case 4:
                    return this.zzaIn;
                case 5:
                    return this.zzaJt;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzaJu);
                case 8:
                    return this.zzaID;
                case 9:
                    return this.zzadv;
                case 10:
                    return Integer.valueOf(this.zzSq);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxQ, reason: merged with bridge method [inline-methods] */
        public OrganizationsEntity freeze() {
            return this;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        String mValue;
        final int zzCY;
        final Set<Integer> zzaHQ;
        boolean zzaJu;

        static {
            zzaHP.put("primary", FastJsonResponse.Field.zzk("primary", 2));
            zzaHP.put("value", FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> set, int i, boolean z, String str) {
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaJu = z;
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!placesLivedEntity.zza(field) || !zzb(field).equals(placesLivedEntity.zzb(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasPrimary() {
            return this.zzaHQ.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasValue() {
            return this.zzaHQ.contains(3);
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

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean isPrimary() {
            return this.zzaJu;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzi.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 2:
                    return Boolean.valueOf(this.zzaJu);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxR, reason: merged with bridge method [inline-methods] */
        public PlacesLivedEntity freeze() {
            return this;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
        String mValue;
        final int zzCY;
        int zzSq;
        String zzaEH;
        final Set<Integer> zzaHQ;
        private final int zzaJv;

        static {
            zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzaHP.put("type", FastJsonResponse.Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzaHP.put("value", FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzaJv = 4;
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        UrlsEntity(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzaJv = 4;
            this.zzaHQ = set;
            this.zzCY = i;
            this.zzaEH = str;
            this.zzSq = i2;
            this.mValue = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
                if (zza(field)) {
                    if (!urlsEntity.zza(field) || !zzb(field).equals(urlsEntity.zzb(field))) {
                        return false;
                    }
                } else if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getLabel() {
            return this.zzaEH;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public int getType() {
            return this.zzSq;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasLabel() {
            return this.zzaHQ.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasType() {
            return this.zzaHQ.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasValue() {
            return this.zzaHQ.contains(4);
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
            zzj.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzot()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaEH;
                case 6:
                    return Integer.valueOf(this.zzSq);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
            return zzaHP;
        }

        @Deprecated
        public int zzxS() {
            return 4;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzxT, reason: merged with bridge method [inline-methods] */
        public UrlsEntity freeze() {
            return this;
        }
    }

    public static class zza {
        public static int zzdY(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        zzaHP.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
        zzaHP.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzaHP.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
        zzaHP.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
        zzaHP.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
        zzaHP.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
        zzaHP.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
        zzaHP.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
        zzaHP.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzaHP.put("id", FastJsonResponse.Field.zzl("id", 14));
        zzaHP.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
        zzaHP.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzaHP.put("language", FastJsonResponse.Field.zzl("language", 18));
        zzaHP.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
        zzaHP.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
        zzaHP.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzaHP.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzaHP.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzaHP.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzaHP.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzaHP.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
        zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzaHP.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
        zzaHP.put("verified", FastJsonResponse.Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    public PersonEntity(String str, String str2, ImageEntity imageEntity, int i, String str3) {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
        this.zzadI = str;
        this.zzaHQ.add(9);
        this.zzKI = str2;
        this.zzaHQ.add(14);
        this.zzaIV = imageEntity;
        this.zzaHQ.add(15);
        this.zzaIZ = i;
        this.zzaHQ.add(21);
        this.zzF = str3;
        this.zzaHQ.add(27);
    }

    PersonEntity(Set<Integer> set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List<OrganizationsEntity> list, List<PlacesLivedEntity> list2, int i5, int i6, String str9, String str10, List<UrlsEntity> list3, boolean z2) {
        this.zzaHQ = set;
        this.zzCY = i;
        this.zzaIO = str;
        this.zzaIP = ageRangeEntity;
        this.zzaIQ = str2;
        this.zzaIR = str3;
        this.zzaIS = i2;
        this.zzaIT = coverEntity;
        this.zzaIU = str4;
        this.zzadI = str5;
        this.zzsC = i3;
        this.zzKI = str6;
        this.zzaIV = imageEntity;
        this.zzaIW = z;
        this.zzRA = str7;
        this.zzaIX = nameEntity;
        this.zzaIY = str8;
        this.zzaIZ = i4;
        this.zzaJa = list;
        this.zzaJb = list2;
        this.zzaJc = i5;
        this.zzaJd = i6;
        this.zzaJe = str9;
        this.zzF = str10;
        this.zzaJf = list3;
        this.zzaJg = z2;
    }

    public static PersonEntity zzp(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
            if (zza(field)) {
                if (!personEntity.zza(field) || !zzb(field).equals(personEntity.zzb(field))) {
                    return false;
                }
            } else if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getAboutMe() {
        return this.zzaIO;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.AgeRange getAgeRange() {
        return this.zzaIP;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBirthday() {
        return this.zzaIQ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBraggingRights() {
        return this.zzaIR;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getCircledByCount() {
        return this.zzaIS;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Cover getCover() {
        return this.zzaIT;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getCurrentLocation() {
        return this.zzaIU;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getDisplayName() {
        return this.zzadI;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getGender() {
        return this.zzsC;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Image getImage() {
        return this.zzaIV;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getLanguage() {
        return this.zzRA;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Name getName() {
        return this.zzaIX;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getNickname() {
        return this.zzaIY;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getObjectType() {
        return this.zzaIZ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.zzaJa;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzaJb;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getPlusOneCount() {
        return this.zzaJc;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getRelationshipStatus() {
        return this.zzaJd;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getTagline() {
        return this.zzaJe;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Urls> getUrls() {
        return (ArrayList) this.zzaJf;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAboutMe() {
        return this.zzaHQ.contains(2);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAgeRange() {
        return this.zzaHQ.contains(3);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBirthday() {
        return this.zzaHQ.contains(4);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBraggingRights() {
        return this.zzaHQ.contains(5);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCircledByCount() {
        return this.zzaHQ.contains(6);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCover() {
        return this.zzaHQ.contains(7);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCurrentLocation() {
        return this.zzaHQ.contains(8);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasDisplayName() {
        return this.zzaHQ.contains(9);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasGender() {
        return this.zzaHQ.contains(12);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasId() {
        return this.zzaHQ.contains(14);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasImage() {
        return this.zzaHQ.contains(15);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasIsPlusUser() {
        return this.zzaHQ.contains(16);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasLanguage() {
        return this.zzaHQ.contains(18);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasName() {
        return this.zzaHQ.contains(19);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasNickname() {
        return this.zzaHQ.contains(20);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasObjectType() {
        return this.zzaHQ.contains(21);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasOrganizations() {
        return this.zzaHQ.contains(22);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlacesLived() {
        return this.zzaHQ.contains(23);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlusOneCount() {
        return this.zzaHQ.contains(24);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasRelationshipStatus() {
        return this.zzaHQ.contains(25);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasTagline() {
        return this.zzaHQ.contains(26);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrl() {
        return this.zzaHQ.contains(27);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrls() {
        return this.zzaHQ.contains(28);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasVerified() {
        return this.zzaHQ.contains(29);
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

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isPlusUser() {
        return this.zzaIW;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isVerified() {
        return this.zzaJg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzaIO;
            case 3:
                return this.zzaIP;
            case 4:
                return this.zzaIQ;
            case 5:
                return this.zzaIR;
            case 6:
                return Integer.valueOf(this.zzaIS);
            case 7:
                return this.zzaIT;
            case 8:
                return this.zzaIU;
            case 9:
                return this.zzadI;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            case 12:
                return Integer.valueOf(this.zzsC);
            case 14:
                return this.zzKI;
            case 15:
                return this.zzaIV;
            case 16:
                return Boolean.valueOf(this.zzaIW);
            case 18:
                return this.zzRA;
            case 19:
                return this.zzaIX;
            case 20:
                return this.zzaIY;
            case 21:
                return Integer.valueOf(this.zzaIZ);
            case 22:
                return this.zzaJa;
            case 23:
                return this.zzaJb;
            case 24:
                return Integer.valueOf(this.zzaJc);
            case 25:
                return Integer.valueOf(this.zzaJd);
            case 26:
                return this.zzaJe;
            case 27:
                return this.zzF;
            case 28:
                return this.zzaJf;
            case 29:
                return Boolean.valueOf(this.zzaJg);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
        return zzaHP;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxJ, reason: merged with bridge method [inline-methods] */
    public PersonEntity freeze() {
        return this;
    }
}
