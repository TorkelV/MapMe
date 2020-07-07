@file:JvmName("GoogleMapUtils")

package nz.co.trademe.mapme.googlemaps

import android.graphics.Bitmap
import nz.co.trademe.mapme.LatLng
import org.m0skit0.android.mapswrapper.BitmapDescriptor
import org.m0skit0.android.mapswrapper.BitmapDescriptorFactory


fun LatLng.toGoogleMapsLatLng(): org.m0skit0.android.mapswrapper.LatLng {
    return org.m0skit0.android.mapswrapper.LatLng(this.latitude, this.longitude)
}

fun Bitmap.toBitmapDescriptor(): BitmapDescriptor {
    return BitmapDescriptorFactory.fromBitmap(this)
}