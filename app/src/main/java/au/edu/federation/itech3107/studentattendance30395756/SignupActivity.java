package au.edu.federation.itech3107.studentattendance30395756;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        SQLiteDatabase db = new LiteSQL(SignupActivity.this).getWritableDatabase();
        findViewById(R.id.btnSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("username", etUsername.getText().toString());
                values.put("password", etPassword.getText().toString());
                db.insert("ACCOUNT", null, values);
                Toast.makeText(SignupActivity.this, "success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}