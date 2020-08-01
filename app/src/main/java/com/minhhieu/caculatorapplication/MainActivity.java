package com.minhhieu.caculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String display="";
    private EditText inputtext;
    private TextView displaytext;
    private String currentOperator="";
    private String result="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button deletevar = (Button) findViewById(R.id.btnclear);
        deletevar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletenumber();
            }
        });


        screen = (TextView)findViewById(R.id.edt_input);
        screen.setText(display);
        inputtext = findViewById(R.id.edt_input);
        displaytext = findViewById(R.id.tv_result);
    }

    private void appendToLast(String str) {
        this.inputtext.getText().append(str);
    }

    //click vào số
    public void onClickNumber(View v) {
        Button b = (Button) v;
        display += b.getText();
        appendToLast(display);
        display="";
    }
    // click vào phép tính
    public void onClickOperator(View v) {
        Button b = (Button) v;
        display += b.getText();
        if(endsWithOperatore())
        {
            replace(display);
            currentOperator = b.getText().toString();
            display = "";
        }
        else {
            appendToLast(display);
            currentOperator = b.getText().toString();

            display = "";
        }

    }
    //AC xoá màn hình
    public void onClearButton(View v) {
        inputtext.getText().clear();
        displaytext.setText("");
    }
    //nút del xoá kí tự cuối của chuỗi
    public void deletenumber() {
        this.inputtext.getText().delete(getinput().length() - 1, getinput().length());
    }

    private String getinput() {
        return this.inputtext.getText().toString();
    }

    //fix bug toán tử ở cuối chuỗi
    private boolean endsWithOperatore() {
        return getinput().endsWith("+") || getinput().endsWith("-") || getinput().endsWith("/") || getinput().endsWith("x");
    }

    private void replace(String str) {
        inputtext.getText().replace(getinput().length() - 1, getinput().length(), str);
    }

    private double operate(String a,String b,String cp)
    {
        switch(cp) {
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "x": return Double.valueOf(a) * Double.valueOf(b);
            case "\u00F7": return Double.valueOf(a) / Double.valueOf(b);
            default: return -1;
        }
    }
    // trường hợp UI x -> *
    public void equalresult(View v) {
        String input = getinput();

        if(!endsWithOperatore()) {

            if (input.contains("x")) {
                input = input.replaceAll("x", "*");
            }

            if (input.contains("\u00F7")) {
                input = input.replaceAll("\u00F7", "/");
            }

            Expression expression = new ExpressionBuilder(input).build();
            double result = expression.evaluate();

            displaytext.setText(String.valueOf(result));
        }
        else displaytext.setText("");

        System.out.println(result);
    }

}
