package fyp.uos.he.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fyp.uos.he.R;

public class HomeActivity extends AppCompatActivity {
    Button mVoiceSearch;
    ImageView mOD, mContact, mAlarm, mLocation, mAboutus, mSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mOD=findViewById(R.id.odhexa);
        mContact=findViewById(R.id.contacthexa);
        mAlarm=findViewById(R.id.alarmhexa);
        mLocation=findViewById(R.id.locationhexa);
        mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Location.class));
            }
        });
        mAboutus=findViewById(R.id.abouthexa);
        mAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AboutUs.class));
            }
        });

        mSearch=findViewById(R.id.searchhexa);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));
            }
        });
        mVoiceSearch=findViewById(R.id.search_voice_btn);
        mVoiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, VoiceSearchActivity.class));
            }
        });
    }
}
