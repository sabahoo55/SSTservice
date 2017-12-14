package sahatara.com.sstservice;

import android.bluetooth.le.AdvertiseData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sahatara.com.sstservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // เมนหลัก ทำก่อน เสมอ
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //       Add Fragment To Activity
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();
        }
    }   // Main Method



}   // Main Class
