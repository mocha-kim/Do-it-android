package org.mochakim.mission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;
    TextView textView;
    EditText nameText;
    EditText birthText;
    EditText phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        nameText = findViewById(R.id.editText);
        birthText = findViewById(R.id.editText2);
        phoneText = findViewById(R.id.editText3);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPersonItem();
            }
        });
    }

    private void addPersonItem() {
        String name = nameText.getText().toString();
        String birth = birthText.getText().toString();
        String phone = phoneText.getText().toString();

        if(name.isEmpty() || birth.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            adapter.addItem(new Person(name, birth, phone));
            recyclerView.setAdapter(adapter);
            int count = adapter.getItemCount();
            textView.setText(Integer.toString(count) + "명");
        }
    }
}
