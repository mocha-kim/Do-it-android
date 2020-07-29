package org.mochakim.mission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;
    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_SALES = 202;
    public static final int REQUEST_CODE_PRODUCT = 203;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            if(requestCode == REQUEST_CODE_CUSTOMER) {
                String menu = data.getStringExtra("menu");
                Toast.makeText(getBaseContext(), menu, Toast.LENGTH_LONG).show();
            } else if(requestCode == REQUEST_CODE_SALES) {
                String menu = data.getStringExtra("menu");
                Toast.makeText(getBaseContext(), menu, Toast.LENGTH_LONG).show();
            } else if(requestCode == REQUEST_CODE_PRODUCT) {
                String menu = data.getStringExtra("menu");
                Toast.makeText(getBaseContext(), menu, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button Button1 = (Button) findViewById(R.id.button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                intent.putExtra("menu", "고객 관리");

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
            }
        });

        Button Button2 = (Button) findViewById(R.id.button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
                intent.putExtra("menu", "매출 관리");

                startActivityForResult(intent, REQUEST_CODE_SALES);
            }
        });

        Button Button3 = (Button) findViewById(R.id.button3);
        Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("menu", "상품 관리");

                startActivityForResult(intent, REQUEST_CODE_PRODUCT);
            }
        });
    }
}
