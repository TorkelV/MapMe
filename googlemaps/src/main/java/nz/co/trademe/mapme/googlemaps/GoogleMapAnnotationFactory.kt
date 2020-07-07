package nz.co.trademe.mapme.googlemaps

import android.graphics.Bitmap
import nz.co.trademe.mapme.LatLng
import nz.co.trademe.mapme.annotations.AnnotationFactory
import nz.co.trademe.mapme.annotations.MarkerAnnotation
import org.m0skit0.android.mapswrapper.CommonMap
import org.m0skit0.android.mapswrapper.Marker

class GoogleMapAnnotationFactory : AnnotationFactory<CommonMap> {

    override fun createMarker(latLng: LatLng, icon: Bitmap?, title: String?): MarkerAnnotation {
        return GoogleMapMarkerAnnotation(latLng, title, icon)
    }

    override fun clear(map: CommonMap) {
        map.clear()
    }

    override fun setOnMarkerClickListener(map: CommonMap, onClick: (marker: Any) -> Boolean) {
        map.setOnMarkerClickListener { marker -> onClick(marker) }
    }

    override fun setOnInfoWindowClickListener(
            map: CommonMap,
            onClick: (marker: Any) -> Boolean
    ) {
        map.setOnInfoWindowClickListener(object : CommonMap.OnInfoWindowClickListener {
            override fun onInfoWindowClick(marker: Marker) {
                onClick(marker)
            }
        })
    }
}