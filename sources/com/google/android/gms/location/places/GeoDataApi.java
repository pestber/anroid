package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes.dex */
public interface GeoDataApi {
    PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, AddPlaceRequest addPlaceRequest);

    PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter);

    PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, String... strArr);
}
