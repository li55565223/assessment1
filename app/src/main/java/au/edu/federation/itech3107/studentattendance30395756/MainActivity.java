package au.edu.federation.itech3107.studentattendance30395756;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bo = findViewById(R.id.btnLogin);
        Button bt = findViewById(R.id.btnSignin);
        bin(bo);
        bt.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }

    public void bin(Button bo) {
        bo.setOnClickListener(view -> {
            EditText ei = findViewById(R.id.etUsername);
            EditText ep = findViewById(R.id.etPassword);
            String usernameStr = ei.getText().toString();
            String passwordStr = ep.getText().toString();
            SQLiteDatabase db = new LiteSQL(this).getReadableDatabase();
            String query = "SELECT username, password FROM ACCOUNT where username = ? and password = ?";
            Cursor cursor = db.rawQuery(query, new String[]{usernameStr, passwordStr});
            if (cursor.moveToFirst()) {
                Intent intent = new Intent(MainActivity.this, CouQuActy.class);
                startActivity(intent);
                return;
            }
            Toast.makeText(MainActivity.this, "username or password error", Toast.LENGTH_SHORT).show();
        });
    }
}