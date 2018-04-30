package info.devexchanges.bluetoothchatapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

    Button chatButton,fileButton;

    public static ChooseActivity ActivityContext =null;

    private static final int REQUEST_BLUETOOTH = 1, REQUEST_BLUETOOTH_ADMIN = 2, REQUEST_ACCESS_COARSE_LOCATION = 3,
            REQUEST_READ_EXTERNAL_STORAGE = 4, REQUEST_WRITE_EXTERNAL_STORAGE = 5;

    private static String[] PERMISSIONS_BLUETOOTH = {
            android.Manifest.permission.BLUETOOTH
    };
    private static String[] PERMISSIONS_BLUETOOTH_ADMIN = {
            android.Manifest.permission.BLUETOOTH_ADMIN
    };
    private static String[] PERMISSIONS_ACCESS_COARSE_LOCATION = {
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private static String[] PERMISSIONS_READ_EXTERNAL_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private static String[] PERMISSIONS_WRITE_EXTERNAL_STORAGE = {
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        chatButton = (Button)findViewById(R.id.chat);
        fileButton = (Button)findViewById(R.id.file);
        TextView textView = (TextView) findViewById(R.id.textView);

        Typeface tf = Typeface.createFromAsset(this.getAssets(),"nexa_rust.otf");
        textView.setTypeface(tf);
        ActivityContext = this;
        verifyRuntimePermissions(ActivityContext);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(ChooseActivity.this,FileExchangeActivity.class);
                   startActivity(intent);
            }
        });
    }

    public static void verifyRuntimePermissions(Activity activity) {
        // Check if we have write permission
        int permission1 = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.BLUETOOTH);
        int permission2 = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.BLUETOOTH_ADMIN);
        int permission3 = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permission4 = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.READ_EXTERNAL_STORAGE);
        int permission5 = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission1 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_BLUETOOTH,
                    REQUEST_BLUETOOTH
            );
        }

        if (permission2 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_BLUETOOTH_ADMIN,
                    REQUEST_BLUETOOTH_ADMIN
            );
        }

        if (permission3 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_ACCESS_COARSE_LOCATION,
                    REQUEST_ACCESS_COARSE_LOCATION
            );
        }

        if (permission4 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_READ_EXTERNAL_STORAGE,
                    REQUEST_READ_EXTERNAL_STORAGE
            );
        }

        if (permission5 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_WRITE_EXTERNAL_STORAGE,
                    REQUEST_WRITE_EXTERNAL_STORAGE
            );
        }
    }
}
