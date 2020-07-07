package nz.co.trademe.mapme.googlemaps

import android.content.Context
import android.graphics.Bitmap
import nz.co.trademe.mapme.LatLng
import nz.co.trademe.mapme.annotations.MarkerAnnotation
import org.m0skit0.android.mapswrapper.CommonMap
import org.m0skit0.android.mapswrapper.Marker
import org.m0skit0.android.mapswrapper.MarkerOptions

class GoogleMapMarkerAnnotation(latLng: LatLng,
                                title: String?,
                                icon: Bitmap? = null) : MarkerAnnotation(latLng, title, icon) {

    override fun onUpdateIcon(icon: Bitmap?) {
        icon?.toBitmapDescriptor()?.let {
            nativeMarker?.setIcon(it)
        }
    }

    override fun onUpdateTitle(title: String?) {
        title?.let {
            nativeMarker?.title = it
        }
    }

    override fun onUpdatePosition(position: LatLng) {
        nativeMarker?.position = position.toGoogleMapsLatLng()
    }

    override fun onUpdateZIndex(index: Float) {
        nativeMarker?.zIndex = index
    }

    override fun onUpdateAlpha(alpha: Float) {
        nativeMarker?.alpha = alpha
    }

    override fun onUpdateAnchor(anchorUV: Pair<Float, Float>) {
        nativeMarker?.setAnchor(anchorUV.first, anchorUV.second)
    }

    private var nativeMarker: Marker? = null

    override fun annotatesObject(nativeObject: Any): Boolean {
        return nativeMarker?.equals(nativeObject) ?: false
    }

    override fun removeFromMap(map: Any, context: Context) {
        nativeMarker?.remove()
        nativeMarker = null
    }

    override fun addToMap(map: Any, context: Context) {
        val googleMap = map as CommonMap

        val options = MarkerOptions()
                .position(latLng.toGoogleMapsLatLng()).apply {
                    this@GoogleMapMarkerAnnotation.icon?.toBitmapDescriptor()?.let {
                        icon(it)
                    }
                    this@GoogleMapMarkerAnnotation.title?.let { title(it) }
                }
                .alpha(alpha)
                .zIndex(zIndex)

        nativeMarker = googleMap.addMarker(options)
    }

}
