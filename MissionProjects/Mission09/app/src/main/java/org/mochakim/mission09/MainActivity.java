package org.mochakim.mission09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    InputFragment inputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.inputFragment);
    }
}
