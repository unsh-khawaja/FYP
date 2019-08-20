package fyp.uos.he.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fyp.uos.he.R;

public class HomeActivity extends AppCompatActivity {
    Button mVoiceSearch, call, msg;
    TextView txt;
    ImageView mOD, mContact, mAlarm, mLocation, mAboutus, mSearch;
    Dialog dialog = new Dialog(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mOD=findViewById(R.id.odhexa);
        mContact=findViewById(R.id.contacthexa);
        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();


                txt =  dialog.findViewById(R.id.textViewMessage);


                call =dialog.findViewById(R.id.btn_call);
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent();
                        i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
                        i.setAction("android.intent.action.MAIN");
                        i.addCategory("android.intent.category.LAUNCHER");
                        i.addCategory("android.intent.category.DEFAULT");
                        startActivity(i);
                    }
                });
                msg = dialog.findViewById(R.id.btn_msg);
                msg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                        smsIntent.setType("vnd.android-dir/mms-sms");
                        smsIntent.putExtra("address","phoneNumber");
                        smsIntent.putExtra("sms_body","message");
                        startActivity(smsIntent);
                    }
                });
                dialog.show();
            }
        });
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
