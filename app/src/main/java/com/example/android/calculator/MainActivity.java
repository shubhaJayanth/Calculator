package com.example.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private String readStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);

    }

    public void clear(View view) {
        textViewResult.setText("0");
        readStr="";
    }

    public void backspace(View view) {
        readStr = textViewResult.getText().toString();
        if (!readStr.isEmpty()) {
            readStr = removeLastChar(readStr);
            textViewResult.setText(readStr);
        }
    }

    private String removeLastChar(String readStr) {
        return readStr.substring(0, readStr.length() - 1);
    }

    public void divide(View view) {
        appendText("/");
    }

    public void multiply(View view) {
        appendText("*");
    }

    public void buttonSeven(View view) {
        appendText("7");
    }

    public void buttonEight(View view) {
        appendText("8");
    }

    public void buttonNine(View view) {
        appendText("9");
    }

    public void subtract(View view) {
        appendText("-");
    }

    public void buttonFour(View view) {
        appendText("4");
    }

    public void buttonFive(View view) {
        appendText("5");
    }

    public void buttonSix(View view) {
        appendText("6");
    }

    public void add(View view) {
        appendText("+");
    }

    public void buttonOne(View view) {
        appendText("1");
    }

    public void buttonTwo(View view) {
        appendText("2");
    }

    public void buttonThree(View view) {
        appendText("3");
    }

    public void computeEquals(View view) {
        try {
            Expression e = new Expression(readStr);
            Double v = e.calculate();
            readStr = v.toString();
            textViewResult.setText(readStr);
            readStr = "";
        }catch (ArithmeticException e){
            readStr = e.getMessage();
            textViewResult.setText(readStr);
            readStr = "";
        }
    }

    public void computePercent(View view) {
       if (readStr!=null) {
           readStr =readStr +"%";
           computeEquals(view);
       }
    }

    public void buttonZero(View view) {
        appendText("0");
    }

    public void buttonDot(View view) {
        try {

            String temp = readStr.charAt(readStr.length()-1)+"";
            Integer i = Integer.parseInt(temp);
            appendText(".");
        }catch (Exception e){
            appendText("0.");
        }
    }

    public void appendText(final String c){
        readStr+=c;
        textViewResult.setText(readStr);
    }

    public void calculateSquareRoot(View view) {
        if (readStr!=null) {
            double doubleStr = Double.parseDouble(readStr);
            double result = Math.sqrt(doubleStr);
            textViewResult.setText(String.valueOf(result));
            readStr = "";

        }

    }
}

   