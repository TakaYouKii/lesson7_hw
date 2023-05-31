package com.example.lesson7;

import static com.example.lesson7.R.id.btn_0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button next_page;
    private Boolean isOperationClick;

    private Double first, second, result;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        next_page = findViewById(R.id.next_page);
        next_page.setVisibility(View.GONE);

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("result", result);
                startActivity(i);
                finish();
            }
        });
    }



    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view){
        next_page.setVisibility(View.GONE);
        if(view.getId() == R.id.btn_1){
            setNumber("1");

        }
        else if (view.getId() == R.id.btn_2) {
            setNumber("2");

        }
        else if (view.getId() == R.id.btn_3) {
            setNumber("3");

        }
        else if (view.getId() == R.id.btn_4) {
            setNumber("4");

        }
        else if (view.getId() == R.id.btn_5) {
            setNumber("5");
        }
        else if (view.getId() == R.id.btn_5) {
            setNumber("5");
        }
        else if (view.getId() == R.id.btn_6) {
            setNumber("6");
        }
        else if (view.getId() == R.id.btn_7) {
            setNumber("7");
        }
        else if (view.getId() == R.id.btn_8) {
            setNumber("8");
        }
        else if (view.getId() == R.id.btn_9) {
            setNumber("9");
        }
        else if (view.getId() == btn_0) {
            setNumber("0");
        }
        else if (view.getId() == R.id.btn_dot) {
            setNumber(".");
        }


    }

    public void onOperationClick(View view){
        next_page.setVisibility(View.GONE);
        if(view.getId() == R.id.btn_ac){
            textView.setText("0");
            first = 0.0;
            second = 0.0;
        }
        else if (view.getId() == R.id.btn_plus) {
            operation = "+";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }
        else if (view.getId() == R.id.btn_equal) {
            second = Double.parseDouble(textView.getText().toString());
            if(operation.equals("+")){
                result = first+second;
                textView.setText(cancelDouble(result));
            } else if (operation.equals("-")) {
                result = first-second;
                textView.setText(cancelDouble(result));
            }else if (operation.equals("/")) {
                if(second == 0){
                    textView.setText("На 0 нельзя");
                }else{
                result = first/second;
                    textView.setText(cancelDouble(result));}
            }else if (operation.equals("*")) {
                result = first*second;
                textView.setText(cancelDouble(result));
            }
            else if (operation.equals("%")) {
                result = (first/100)*second;
                textView.setText(cancelDouble(result));
            }
            isOperationClick = true;
            next_page.setVisibility(View.VISIBLE);


        }
        else if (view.getId() == R.id.btn_minus) {
            operation = "-";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;

        }
        else if (view.getId() == R.id.btn_multiplication) {
            operation = "*";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;

        }
        else if (view.getId() == R.id.btn_division) {
            operation = "/";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;

        }
        else if (view.getId() == R.id.btn_percent) {
            operation = "%";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;

        }

    }

    public String cancelDouble(Double number){
        String text = number.toString();
        if(text.substring(text.length() - 2).equals(".0")){
            return text.substring(0,text.length() - 2);
        }
        else{
            return number.toString();
        }
    }

    public void setNumber(String number){
        if(textView.getText().toString().equals("0")){
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);
        } else{
            textView.append(number);

        }
        isOperationClick = false;
    }



}