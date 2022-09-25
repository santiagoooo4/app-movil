package com.example.minticaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.minticaplication.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions




class LocationFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentLocationBinding? = null
    private val binding: FragmentLocationBinding get() = _binding!!
    private lateinit var mMap: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)        // Inflate the layout for this fragment
        return binding.root
    }



    override fun onStart() {
        super.onStart()
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_location_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

     override fun onMapReady(map: GoogleMap) {
         mMap = map
         mMap.uiSettings .isScrollGesturesEnabled = true
         mMap.uiSettings.isZoomControlsEnabled = true
         mMap.uiSettings.isZoomGesturesEnabled = true
         mMap.uiSettings.isCompassEnabled = true

         val latLng: LatLng = LatLng(3.425717420348647, -76.53372282859509)

         mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
         mMap.isTrafficEnabled = true

         mMap.addMarker(MarkerOptions().position(latLng).title("Doctor Design"))
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 24.0f))
     }
 }