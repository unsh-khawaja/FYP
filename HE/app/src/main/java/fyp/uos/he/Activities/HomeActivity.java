package fyp.uos.he.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fyp.uos.he.R;

public class HomeActivity extends AppCompatActivity {
    Button mVoiceSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        mVoiceSearch=findViewById(R.id.search_voice_btn);
        mVoiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, VoiceSearchActivity.class));
            }
        });
    }
}
