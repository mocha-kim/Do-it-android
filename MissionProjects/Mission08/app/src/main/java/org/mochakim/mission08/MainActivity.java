package org.mochakim.mission08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;
    EditText idEditText;
    EditText pwEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.editText);
        pwEditText = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String pw = pwEditText.getText().toString();
                if(id.isEmpty() && pw.isEmpty()) {
                    Toast.makeText(getBaseContext(), "아이디와 비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(id.isEmpty()) {
                    Toast.makeText(getBaseContext(), "아이디를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(pw.isEmpty()) {
                    Toast.makeText(getBaseContext(), "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            }
        });
    }
}
