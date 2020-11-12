package com.example.sea.ui.map

import android.location.Location
import android.view.animation.Animation
import com.example.sea.data.remote.model.LocationData
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.data.geojson.GeoJsonLayer

interface MapContract {
    interface View {
        fun getMarker() : Marker?
        fun getStartMarker() : Marker?
        fun setTitle(text: String)
        fun showCameraAnimation(currentLatLng: LatLng, zoomLevel: Float)
        fun changeTab()
        fun showMarkers(data: String, lat: Double, long: Double, type: String)
        fun hideMarkers()

        fun showButtons()
        fun showTextView()
        fun showHarbors()
        fun showAnimation(showButton: Animation?)
        fun hideButtons()
        fun hideTextView()
        fun hideHarbors()
        fun hideAnimation(hideButton: Animation?)
        fun onFailure(t: String?)

        fun showProgress()
        fun hideProgress()
        fun showMessage(text: String)
        fun removeMarker(marker: Marker?)
        fun setMarkerOnStart(markerOptions: MarkerOptions?)
    }

    interface Presenter {
        fun onFABClick()
        fun onHarborButtonClick()
        fun onRainClick()
        fun onWindClick()
        fun setUpHarborMarkers(harborsLayer: GeoJsonLayer)
        fun onSuccess(location: Location?)
        fun findLastLocation()
        fun getAddress(latitude: Double?, longitude: Double?) : String
        fun createInfoWindowAdapter(position: LatLng?, locationName: String) : CustomInfoWindowAdapter
        fun onInfoWindowClick(marker: Marker?)
        fun createStartMarker() : MarkerOptions?
    }

    interface Interactor{
        fun getFoundAddress() : Boolean
        fun setFoundAddress(value: Boolean)
        fun getLocationData(finished: OnFinished, latitude: Float, longitude: Float)

        interface OnFinished {
            fun onFinished(data: LocationData?)
            fun onFailure(t: String?)
        }
    }
}