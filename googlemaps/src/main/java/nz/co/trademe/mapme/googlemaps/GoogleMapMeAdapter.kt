package nz.co.trademe.mapme.googlemaps

import android.content.Context
import nz.co.trademe.mapme.MapMeAdapter
import org.m0skit0.android.mapswrapper.CommonMap

abstract class GoogleMapMeAdapter(context: Context) : MapMeAdapter<CommonMap>(context, GoogleMapAnnotationFactory()) {
}

