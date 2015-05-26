//package se.leanbit.sats;
//
//import android.app.ActionBar;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//
//import java.util.Map;
//
//import se.leanbit.sats.R;
//import se.leanbit.sats.repositories.services.SatsActivitiesService;
//
///**
// * Created by gina on 2015-05-22.
// */
//public class MapViewActivity extends ActionBarActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, LocationListener, GoogleMap.OnCameraChangeListener
//{
//    private GoogleMap mMap = null;
//    private Location mLastLocation;
//    private Map<String, Marker> mSatsMarkers;
//    private LatLng mCameraPosition;
//    private final static String CAMERA_LAT = "lat_coords";
//    private final static String CAMERA_LANG = "lang_coords";
//    private SatsActivitiesService mSatsActivitiesService;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.map_view);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
//        setupLocation();
//        drawMap();
//        mSatsActivitiesService = new SatsActivitiesService();
//    }
//
//    private void drawMap()
//    {
//        MapFragment mMapFragment = MapFragment.newInstance();
//        FragmentTransaction fragmentTransaction =
//                getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.map_view, mMapFragment);
//        fragmentTransaction.commit();
//        mMapFragment.getMapAsync(this);
//    }
//    @Override
//    public void onMapReady(GoogleMap map)
//    {
//        mMap = map;
//        LatLng mLatLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
//        mMap.setMyLocationEnabled(true);
//        mMap.setOnCameraChangeListener(this);
//        if (mCameraPosition != null) {
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mCameraPosition, 15));
//        } else {
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 15));
//        }
//        //Log.d(mCameraPosition.toString(), "onMapReady fired ..............");
//    }
//    private void setupLocation() {
//        if (!isGooglePlayServicesAvailable()) {
//            finish();
//        }
//        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        String bestProvider = locationManager.getBestProvider(criteria, true);
//        mLastLocation = locationManager.getLastKnownLocation(bestProvider);
//        if (mLastLocation != null) {
//            onLocationChanged(mLastLocation);
//        }
//        locationManager.requestLocationUpdates(bestProvider, 60000, 0, (android.location.LocationListener) this);
//    }
//    private boolean isGooglePlayServicesAvailable() {
//        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
//        if (ConnectionResult.SUCCESS == status) {
//            return true;
//        } else {
//            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
//            return false;
//        }
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
//        LatLng latLng = new LatLng(latitude, longitude);
//        Log.d("onLocationChanged", "onLocationChanged fired ..............");
//
//    }
//    @Override
//    public void onMapClick(LatLng latLng) {
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
//        Log.d("onMapClick", "onMapClick fired ..............");
//    }
//    @Override
//    public void onCameraChange(CameraPosition cameraPosition) {
//       // mCameraPosition = mMap.getCameraPosition().target;
//    }
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
//
//}
