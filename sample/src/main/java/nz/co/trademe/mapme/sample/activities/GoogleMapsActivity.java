package nz.co.trademe.mapme.sample.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.View;


import org.m0skit0.android.mapswrapper.CameraUpdateFactory;
import org.m0skit0.android.mapswrapper.CommonMap;
import org.m0skit0.android.mapswrapper.LatLng;
import org.m0skit0.android.mapswrapper.Marker;
import org.m0skit0.android.mapswrapper.OnMapReadyCallback;
import org.m0skit0.android.mapswrapper.SupportMapFragment;

import nz.co.trademe.mapme.googlemaps.GoogleMapAnnotationFactory;
import nz.co.trademe.mapme.sample.R;

public class GoogleMapsActivity extends MapActivity
        implements OnMapReadyCallback, CommonMap.OnMarkerClickListener {

    public static void start(@NonNull Context context) {
        Intent intent = new Intent(context, GoogleMapsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemaps_activity);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    View getMapView() {
        return ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getView();
    }

    @Override
    public void onMapReady(CommonMap map) {
        onMapReady(new GoogleMapAnnotationFactory(), map);
        map.moveCamera(CameraUpdateFactory.INSTANCE.newLatLngZoom(new LatLng(aucklandLatLng.getLatitude(), aucklandLatLng.getLongitude()), 14));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mapsAdapter.notifyAnnotatedMarkerClicked(marker);
        return true;
    }
}
