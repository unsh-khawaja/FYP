package fyp.uos.he.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fyp.uos.he.R;

public class MainActivity extends AppCompatActivity {


    TextView mloginTxtview,msignupTxtview;
    String loginStr, signupStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //from one MainPageActivity to Loginactivity we use intent //
        mloginTxtview=findViewById(R.id.loginmptextview);
        loginStr=mloginTxtview.getText().toString();
        mloginTxtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        //from one MainPageActivity to SignUpActivity we use intent //
        msignupTxtview=findViewById(R.id.signupmptextview);
        signupStr=msignupTxtview.getText().toString();
        msignupTxtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

    }
}
