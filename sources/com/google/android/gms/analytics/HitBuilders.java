package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HitBuilders {

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzam.zzH(z));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static class HitBuilder<T extends HitBuilder> {
        ProductAction zzIC;
        private Map<String, String> zzIB = new HashMap();
        Map<String, List<Product>> zzID = new HashMap();
        List<Promotion> zzIE = new ArrayList();
        List<Product> zzIF = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzae.zzaC("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.zzID.containsKey(str)) {
                this.zzID.put(str, new ArrayList());
            }
            this.zzID.get(str).add(product);
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzaC("product should be non-null");
                return this;
            }
            this.zzIF.add(product);
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzaC("promotion should be non-null");
                return this;
            }
            this.zzIE.add(promotion);
            return this;
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap(this.zzIB);
            if (this.zzIC != null) {
                hashMap.putAll(this.zzIC.build());
            }
            Iterator<Promotion> it = this.zzIE.iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().zzaQ(zzc.zzT(i)));
                i++;
            }
            Iterator<Product> it2 = this.zzIF.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().zzaQ(zzc.zzR(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry : this.zzID.entrySet()) {
                List<Product> value = entry.getValue();
                String zzW = zzc.zzW(i3);
                Iterator<Product> it3 = value.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    hashMap.putAll(it3.next().zzaQ(zzW + zzc.zzV(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry.getKey())) {
                    hashMap.put(zzW + "nm", entry.getKey());
                }
                i3++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return this.zzIB.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zzIB.put(str, str2);
            } else {
                zzae.zzaC(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.zzIB.putAll(new HashMap(map));
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            String zzbk = zzam.zzbk(str);
            if (TextUtils.isEmpty(zzbk)) {
                return this;
            }
            Map<String, String> zzbi = zzam.zzbi(zzbk);
            set("&cc", zzbi.get("utm_content"));
            set("&cm", zzbi.get("utm_medium"));
            set("&cn", zzbi.get("utm_campaign"));
            set("&cs", zzbi.get("utm_source"));
            set("&ck", zzbi.get("utm_term"));
            set("&ci", zzbi.get("utm_id"));
            set("&anid", zzbi.get("anid"));
            set("&gclid", zzbi.get("gclid"));
            set("&dclid", zzbi.get("dclid"));
            set("&aclid", zzbi.get("aclid"));
            set("&gmob_t", zzbi.get("gmob_t"));
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzc.zzN(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzc.zzP(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzam.zzH(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzIC = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzIB.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", "social");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
