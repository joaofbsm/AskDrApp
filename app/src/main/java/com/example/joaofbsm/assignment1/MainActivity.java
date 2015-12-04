package com.example.joaofbsm.assignment1;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * App Main Activity and functions core
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    // Variables used to manage Google Maps API
    protected static final String TAG = "MainActivity";
    protected GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get shared preferences
        SharedPreferences preferences = getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE);

        // Check if someone is already logged in
        if(preferences.getString("user_email", null) == null && preferences.getString("user_password", null) == null) {
            // Calls the login activity if no user is logged in
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            // Finishes the current activity so the user can't get here by using the Back button
            finish();
        }
        else {
            // Starts toolbar which contains the Navigation Drawer and other items
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // Instantiates the Navigation Drawer
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            // Instantiates NavigationView
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            // Calls necessary function to start Google API
            buildGoogleApiClient();

            // Supply the user information(received through SharedPreferences) to complete the NavDrawer header
            View headerView = navigationView.getHeaderView(0);
            TextView user_name = (TextView) headerView.findViewById(R.id.textView_username);
            user_name.setText(preferences.getString("user_name", "Default"));
            TextView user_email = (TextView) headerView.findViewById(R.id.textView_useremail);
            user_email.setText(preferences.getString("user_email", "default@default"));

            // Starts the default fragment
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new HomeFragment());
            ft.commit();
            getSupportActionBar().setTitle("Home");
            // Check the first item(Home) from the NavDrawer for design purposes only
            navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    // Starts Google API
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    // Starts Google API Connection
    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    // Stops Google API Connection
    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    // Runs when a GoogleApiClient object successfully connects.
    @Override
    public void onConnected(Bundle connectionHint) {
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }

    // Runs when a GoogleApiClient object fail to connect.
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    // Runs when a GoogleApiClient object connection is suspended.
    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    // Closes drawer if Back is pressed and the drawer is open
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Handle action bar item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Complete actions when a NavDrawer item is selected
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        boolean fragmentItem = false;

        Fragment fragment = null;

        // Get the SharedPreferences once again
        SharedPreferences preferences = getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE);
        // Creates a SharedPreferences editor
        SharedPreferences.Editor editor = preferences.edit();

        // If selected item was "Home", calls HomeFragment
        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            fragmentItem = true;
        }
        // If selected item was "Diseases", calls DiseaseFragment
        else if(id == R.id.nav_diseases) {
            fragment = new DiseaseFragment();
            fragmentItem = true;
        }
        // If selected item was "Medications", calls MedicationFragment
        else if (id == R.id.nav_medications) {
            fragment = new MedicationFragment();
            fragmentItem = true;
        }
        // Through GoogleAPI calls the Google Maps Application, if it is installed, and search for "medical centre" using last know location
        else if (id == R.id.nav_centres) {
            if(mLastLocation != null) {
                // Parse URI with the query and the location
                Uri gmmIntentUri = Uri.parse("geo:"+mLastLocation.getLatitude()+","+mLastLocation.getLongitude()+"?q=medical centre");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                // Checks if Google Maps App is installed on user device
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
            // If the last location was not found, says to the user to turn his Location on(Might need some time to get location after that).
            else {
                Toast.makeText(this, "No location detected. Please turn GPS on", Toast.LENGTH_LONG).show();
            }

        }
        // Logout and remove user information from SharedPreferences using SharedPreferences.Editor
        else if (id == R.id.nav_logout) {
            editor.remove("user_name");
            editor.remove("user_email");
            editor.remove("user_password");
            editor.commit();

            // Calls the login activity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            // Finishes the current activity so the user can't get here by using the Back button
            finish();
        }

        // Checks if the option selected calls for a fragment
        if(fragmentItem && fragment != null) {
            // Calls for the specified fragment
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
            // Set the title to match the corresponding fragment
            getSupportActionBar().setTitle(item.getTitle());
        }

        // After the action is taken, closes the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
