package com.example.riyac.locatingyou;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements LocationListener {
    int i = 0;
    String num;
    Button button;
    EditText editText;
    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                textView.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);

                String num = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "Submission Successfully Accepted.", Toast.LENGTH_SHORT).show();

                LocationManager locationManager;
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

        double lat = location.getLatitude();
        double lon = location.getLongitude();
        double lat1 = 26.8719766;
        double lon1 = 80.9757233;
        double lat2 = 26.8720300;
        double lon2 = 80.9758333;
        String latitude = lat + "";
        String longitude = lon + "";
        textView2.setText("Your latitude is " + latitude + " and your longitude is " + longitude);

        if (lat > lat1 && lat < lat2)
        {
            textView3.setText("Call will not be made.");
            i = 1;
        } else
        {
            textView3.setText("Call will be made.");
        }
        if (i == 1)
        {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + num));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(intent);

        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


}



