package calculator.moi.andoid.fr.paysmart;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by jerem on 20/04/2018.
 */

public class MapDuTurfu extends AppCompatActivity implements LocationListener, GoogleMap.OnMapClickListener, OnMapReadyCallback {
    private LocationManager locationManager;
    private String provider;
    GoogleMap mMap = null;
    Marker marker = null;
    double lat,lng;
    Location loc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_du_turfu);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        System.out.println("Provider " + provider + " has been selected.");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            mMap.setMyLocationEnabled(true);
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //latituteField.setText("Location not available");
            return;
        }

        Location location = locationManager.getLastKnownLocation(provider);
        lat = location.getLatitude();
        lng = location.getLongitude();
        loc = location;

        // Initialize the location fields
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");

        }

    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        /*mMap = googleMap;
        LatLng now = new LatLng(lat, lng);
        loc.setLatitude(lat);
        loc.setLongitude(lng);
        System.out.println("coucou: "+ lat+" "+lng);
        marker = mMap.addMarker(new MarkerOptions().position(now).title("Ma position"));
        //String lieux = getLocationName(this, loc);
        //TextView localisation = (TextView) findViewById(R.id.lieux);
        //localisation.setText(lieux);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(now));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(now, zoomLevel));
        mMap.setOnMapClickListener(this);*/

        mMap = googleMap;
        LatLng now = new LatLng(lat, lng);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("Ma position"));

        float zoomLevel = 15.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(now, zoomLevel));
    }
}
