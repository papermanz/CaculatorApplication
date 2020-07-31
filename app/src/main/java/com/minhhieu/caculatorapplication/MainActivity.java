package com.minhhieu.caculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private TextView tvResult;

    private Button btnnumber0;
    private Button btnnumber1;
    private Button btnnumber2;
    private Button btnnumber3;
    private Button btnnumber4;
    private Button btnnumber5;
    private Button btnnumber6;
    private Button btnnumber7;
    private Button btnnumber8;
    private Button btnnumber9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wiget();
        setEventClickViews();
    }
    public void Wiget(){

        tvResult = findViewById(R.id.tv_result);
        edtNumber = findViewById(R.id.edt_input);

        btnnumber0 = findViewById(R.id.btn0);
        btnnumber1 = findViewById(R.id.btn1);
        btnnumber2 = findViewById(R.id.btn2);
        btnnumber3 = findViewById(R.id.btn3);
        btnnumber4 = findViewById(R.id.btn4);
        btnnumber5 = findViewById(R.id.btn5);
        btnnumber6 = findViewById(R.id.btn6);
        btnnumber7 = findViewById(R.id.btn7);
        btnnumber8 = findViewById(R.id.btn8);
        btnnumber9 = findViewById(R.id.btn9);

        btnCong = findViewById(R.id.btncong);
        btnTru = findViewById(R.id.btntru);
        btnNhan = findViewById(R.id.btnnhan);
        btnChia = findViewById(R.id.btnchia);
        btnResult = findViewById(R.id.btnresult);

        btnClear = findViewById(R.id.btnclear);
        btnClearAll = findViewById(R.id.btnclearall);
        btnPoint = findViewById(R.id.btnpoint);

    }

    public void setEventClickViews(){

        btnnumber0.setOnClickListener(this);
        btnnumber1.setOnClickListener(this);
        btnnumber2.setOnClickListener(this);
        btnnumber3.setOnClickListener(this);
        btnnumber4.setOnClickListener(this);
        btnnumber5.setOnClickListener(this);
        btnnumber6.setOnClickListener(this);
        btnnumber7.setOnClickListener(this);
        btnnumber8.setOnClickListener(this);
        btnnumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnPoint.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                //TO DO
                edtNumber.append("0");
                break;
            case R.id.btn1:
                //TO DO
                edtNumber.append("1");
                break;
            case R.id.btn2:
                edtNumber.append("2");
                break;
            case R.id.btn3:
                edtNumber.append("3");
                break;
            case R.id.btn4:
                edtNumber.append("4");
                break;
            case R.id.btn5:
                edtNumber.append("5");
                break;
            case R.id.btn6:
                edtNumber.append("6");
                break;
            case R.id.btn7:
                edtNumber.append("7");
                break;
            case R.id.btn8:
                edtNumber.append("8");
                break;
            case R.id.btn9:
                edtNumber.append("9");
                break;
            case R.id.btncong:
                edtNumber.append("+");
                break;
            case R.id.btntru:
                edtNumber.append("-");
                break;
            case R.id.btnnhan:
                edtNumber.append("x");
                break;
            case R.id.btnchia:
                edtNumber.append("/");
                break;
            case R.id.btnclear:
                /*String numberAfterRemove = deleteNumber(edtNumber.getText().toString());
                edtNumber.setText(numberAfterRemove);*/
                //cách tối ưu gọi ra phím backspace trên bàn phím di động
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnclearall:
                edtNumber.setText("");
                break;
            case R.id.btnpoint:
                edtNumber.append(".");
                break;
            case R.id.btnresult:
                int numberA =Integer.parseInt(String.valueOf(edtNumber.getText()));
                break;
            default:
                break;





        }

    }
    // hàm xử lí nút clear
    /*public String deleteNumber(String number){
        int lenght = number.length();
        String temp = number.substring(0,lenght-1); // lấy các kí tự từ đầu đến gần cuối của chuỗi, ex: hieu -> hie
        return temp;
    }*/
}