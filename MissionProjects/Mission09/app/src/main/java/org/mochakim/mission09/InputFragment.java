package org.mochakim.mission09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputFragment extends Fragment {

    EditText name;
    EditText age;
    Button birthButton;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date selectedDate;
    Calendar calendar = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);

        name = rootView.findViewById(R.id.nameInput);

        age = rootView.findViewById(R.id.ageInput);

        birthButton = rootView.findViewById(R.id.birthButton);
        Date curDate = calendar.getTime();
        String dateStr = dateFormat.format(curDate);
        birthButton.setText(dateStr);
        birthButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                calendar.set(year, month, day);
                                Date curDate = calendar.getTime();
                                String dateStr = dateFormat.format(curDate);
                                birthButton.setText(dateStr);
                            }
                        }, year, month, day);
                dialog.show();
            }
        });

        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                String ageStr = age.getText().toString();
                String birthStr = birthButton.getText().toString();
                if (nameStr.isEmpty() && ageStr.isEmpty()) {
                    Toast.makeText(getContext(), "이름과 나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (nameStr.isEmpty()) {
                    Toast.makeText(getContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (ageStr.isEmpty()) {
                    Toast.makeText(getContext(), "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), nameStr + ", " + ageStr + ", " + birthStr, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

}
