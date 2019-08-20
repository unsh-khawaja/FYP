package fyp.uos.he.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;

import fyp.uos.he.Models.getLocationModel;
import fyp.uos.he.R;

public class Location  extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

        private GoogleMap mMap;
        protected LocationManager locationManager;
        protected LocationListener locationListener;
        protected Context context;
        DatabaseReference AddLocation, mDatabase, mPostReference;
        ArrayList mLocationArr;
        private FirebaseAuth mAuth;
        Double latDouble, langDouble;
        TextView mLatitude, mLongitude;
        @SuppressLint("MissingPermission")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                getSupportActionBar().setTitle("Driver Current Location");
                mAuth = FirebaseAuth.getInstance();
                setContentView(R.layout.activity_location);
                mLatitude=findViewById(R.id.latitude);
                mLongitude=findViewById(R.id.longitude);
                AddLocation= FirebaseDatabase.getInstance().getReference("Locations");
                getDrivers();
                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);


                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

                }
        @Override
        public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                // Add a marker in Sydney and move the camera
                LatLng Sargodha = new LatLng(32.078665, 72.68051999999999);
                mMap.addMarker(new MarkerOptions().position(Sargodha).title("Marker in Sydney"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(32.078665, 72.68051999999999), 15.0f));
                }


        @Override
        public void onLocationChanged(android.location.Location location) {
                getLocationModel model=new getLocationModel(location.getLatitude(), location.getLongitude());

                AddLocation.setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {


                        }
                }).addOnFailureListener(new OnFailureListener() {

                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                });


                LatLng currentLocation=new LatLng(latDouble, langDouble);
                mMap.addMarker(new MarkerOptions().position(currentLocation).title("Driver position"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latDouble, langDouble), 15.0f));
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
        public void onConnected(@Nullable Bundle bundle) {



                }

        @Override
        public void onConnectionSuspended(int i) {

                }

        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                }


        private ArrayList<String> getDrivers(){
                mLocationArr=new ArrayList<>();
                AddLocation.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                latDouble = (Double) dataSnapshot.child("mLatitude").getValue();
                langDouble = (Double) dataSnapshot.child("mLongitude").getValue();
                String str=Double.toString(latDouble);
                String str1=Double.toString(langDouble);
                mLatitude.setText(str);
                mLongitude.setText(str1);
                }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

                }
                });
                return mLocationArr;
                }

        }
