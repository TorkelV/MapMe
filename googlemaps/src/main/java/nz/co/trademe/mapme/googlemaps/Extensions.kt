@file:JvmName("GoogleMapUtils")
package nz.co.trademe.mapme.googlemaps

import android.graphics.Bitmap
import com.google.android.libraries.maps.model.BitmapDescriptor
import com.google.android.libraries.maps.model.BitmapDescriptorFactory
import nz.co.trademe.mapme.LatLng


fun LatLng.toGoogleMapsLatLng(): com.google.android.libraries.maps.model.LatLng {
    return com.google.android.libraries.maps.model.LatLng(this.latitude, this.longitude)
}

fun Bitmap.toBitmapDescriptor(): BitmapDescriptor {
    return BitmapDescriptorFactory.fromBitmap(this)
}