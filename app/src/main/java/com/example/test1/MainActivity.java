package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNum1;
    EditText editTextNum2;
    TextView textViewRs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.activity_main__editTextNum1);
        editTextNum2 = findViewById(R.id.activity_main__editTextNum2);
        textViewRs = findViewById(R.id.activity_main__textViewRs);
    }

    public boolean checkNumberInputs() {
        //혹시나 있을지 모를 양옆의 공백제거
        editTextNum1.setText(editTextNum1.getText().toString().trim());

        if (editTextNum1.getText().toString().length() == 0) {
            toastMsg("숫자1을 입력해주세요.");
            editTextNum1.requestFocus();//입력 안 되면 포커싱
            return false;//여기로 들어올 경우 false 반환
        }

        //Num1과 동일
        editTextNum2.setText(editTextNum2.getText().toString().trim());

        if (editTextNum2.getText().toString().length() == 0) {
            toastMsg("숫자2를 입력해주세요.");
            editTextNum2.requestFocus();
            return false;//여기로 들어올 경우 false 반환
        }

        return true;//위의 모든 trap에 안 걸리면 true 반환
    }

    public void btnAddClicked(View view) {
        if (checkNumberInputs() == false) {
            return;
        }
        int num1 = Integer.parseInt(editTextNum1.getText().toString());
        int num2 = Integer.parseInt(editTextNum2.getText().toString());
        int rs = num1 + num2;
        textViewRs.setText("결과 : " + rs);
    }


    public void btnMinusClicked(View view) {
        if (checkNumberInputs() == false) {
            return;
        }
        int num1 = Integer.parseInt(editTextNum1.getText().toString());
        int num2 = Integer.parseInt(editTextNum2.getText().toString());
        int rs = num1 - num2;
        textViewRs.setText("결과 : " + rs);
    }

    public void btnClearClicked(View view) {
        editTextNum1.setText("");
        editTextNum2.setText("");
        toastMsg("결과 초기화");
        textViewRs.setText("결과 : ");
    }

    void toastMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}