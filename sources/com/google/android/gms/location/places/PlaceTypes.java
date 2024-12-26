package com.google.android.gms.location.places;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class PlaceTypes {
    public static final Set<Integer> ALL;
    public static final Set<Integer> zzazO;
    public static final Set<Integer> zzazP;

    static {
        Integer valueOf = Integer.valueOf(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3);
        Integer valueOf2 = Integer.valueOf(Place.TYPE_COUNTRY);
        Integer valueOf3 = Integer.valueOf(Place.TYPE_LOCALITY);
        Integer valueOf4 = Integer.valueOf(Place.TYPE_POSTAL_CODE);
        Integer valueOf5 = Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX);
        Integer valueOf6 = Integer.valueOf(Place.TYPE_POSTAL_TOWN);
        zzazO = Collections.unmodifiableSet(new HashSet(Arrays.asList(1001, 1002, valueOf, valueOf2, Integer.valueOf(Place.TYPE_FLOOR), valueOf3, Integer.valueOf(Place.TYPE_POST_BOX), valueOf4, valueOf5, valueOf6, Integer.valueOf(Place.TYPE_PREMISE), Integer.valueOf(Place.TYPE_ROOM), Integer.valueOf(Place.TYPE_ROUTE), Integer.valueOf(Place.TYPE_STREET_ADDRESS), Integer.valueOf(Place.TYPE_SUBLOCALITY), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_1), 1024, Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_3), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_4), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_5), Integer.valueOf(Place.TYPE_SUBPREMISE))));
        zzazP = Collections.unmodifiableSet(new HashSet(Arrays.asList(1001, 1002, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6)));
        ALL = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 1001, 1002, valueOf, Integer.valueOf(Place.TYPE_COLLOQUIAL_AREA), valueOf2, Integer.valueOf(Place.TYPE_FLOOR), Integer.valueOf(Place.TYPE_GEOCODE), Integer.valueOf(Place.TYPE_INTERSECTION), valueOf3, Integer.valueOf(Place.TYPE_NATURAL_FEATURE), Integer.valueOf(Place.TYPE_NEIGHBORHOOD), Integer.valueOf(Place.TYPE_POLITICAL), Integer.valueOf(Place.TYPE_POINT_OF_INTEREST), Integer.valueOf(Place.TYPE_POST_BOX), valueOf4, valueOf5, valueOf6, Integer.valueOf(Place.TYPE_PREMISE), Integer.valueOf(Place.TYPE_ROOM), Integer.valueOf(Place.TYPE_ROUTE), Integer.valueOf(Place.TYPE_STREET_ADDRESS), Integer.valueOf(Place.TYPE_SUBLOCALITY), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_1), 1024, Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_3), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_4), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_5), Integer.valueOf(Place.TYPE_SUBPREMISE), Integer.valueOf(Place.TYPE_TRANSIT_STATION))));
    }

    private PlaceTypes() {
    }
}
