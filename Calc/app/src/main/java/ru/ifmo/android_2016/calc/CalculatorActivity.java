package ru.ifmo.android_2016.calc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by alexey.nikitin on 13.09.16.
 */

public final class CalculatorActivity extends Activity implements OnClickListener {

    private Button add, sub, mul, div;
    private Button eqv, clear;
    private Button d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
    private TextView result;

    public int firstValue = 0;
    public int secondValue = 0;
    String tempValue = "";
    String operation = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        eqv = (Button) findViewById(R.id.eqv);
        clear = (Button) findViewById(R.id.clear);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);

        eqv.setOnClickListener(this);
        clear.setOnClickListener(this);


        d0 = (Button) findViewById(R.id.d0);
        d1 = (Button) findViewById(R.id.d1);
        d2 = (Button) findViewById(R.id.d2);
        d3 = (Button) findViewById(R.id.d3);
        d4 = (Button) findViewById(R.id.d4);
        d5 = (Button) findViewById(R.id.d5);
        d6 = (Button) findViewById(R.id.d6);
        d7 = (Button) findViewById(R.id.d7);
        d8 = (Button) findViewById(R.id.d8);
        d9 = (Button) findViewById(R.id.d9);

        d0.setOnClickListener(this);
        d1.setOnClickListener(this);
        d2.setOnClickListener(this);
        d3.setOnClickListener(this);
        d4.setOnClickListener(this);
        d5.setOnClickListener(this);
        d6.setOnClickListener(this);
        d7.setOnClickListener(this);
        d8.setOnClickListener(this);
        d9.setOnClickListener(this);

        result = (TextView) findViewById(R.id.result);


        if (savedInstanceState != null) {
            firstValue = savedInstanceState.getInt("firstValue");
            secondValue = savedInstanceState.getInt("secondValue");
            tempValue = savedInstanceState.getString("tempValue");
            operation = savedInstanceState.getString("operation");
            result.setText(savedInstanceState.getString("result"));
        }

    }

    public void onClick(View button) {

        switch (button.getId()) {
            case R.id.d0:
                addToNumber("0");
                break;

            case R.id.d1:
                addToNumber("1");
                break;

            case R.id.d2:
                addToNumber("2");
                break;

            case R.id.d3:
                addToNumber("3");
                break;

            case R.id.d4:
                addToNumber("4");
                break;

            case R.id.d5:
                addToNumber("5");
                break;

            case R.id.d6:
                addToNumber("6");
                break;

            case R.id.d7:
                addToNumber("7");
                break;

            case R.id.d8:
                addToNumber("8");
                break;

            case R.id.d9:
                addToNumber("9");
                break;

            case R.id.clear:
                clearData();
                break;

            case R.id.add:
                add();
                break;

            case R.id.sub:
                sub();
                break;

            case R.id.mul:
                mul();
                break;

            case R.id.div:
                div();
                break;

            case R.id.eqv:
                eqv();
                break;

        }

    }

    public void addToNumber(String number) {
        tempValue = tempValue + number;
        result.setText(tempValue);
    }

    public void clearData() {
        tempValue = "";
        firstValue = 0;
        secondValue = 0;
        result.setText("");

    }

    public void add() {

        if (tempValue != "") {
            firstValue = Integer.parseInt(tempValue);
            tempValue = "";
        }

        operation = "add";

        result.setText("+");
    }

    public void sub() {

        if (tempValue != "") {
            firstValue = Integer.parseInt(tempValue);
            tempValue = "";
        }

        operation = "sub";

        result.setText("-");
    }

    public void mul() {

        if (tempValue != "") {
            firstValue = Integer.parseInt(tempValue);
            tempValue = "";
        }

        operation = "mul";

        result.setText("*");
    }

    public void div() {

        if (tempValue != "") {
            firstValue = Integer.parseInt(tempValue);
            tempValue = "";
        }

        operation = "div";

        result.setText("/");
    }


    public void eqv() {

        if (tempValue != "") {

            secondValue = Integer.parseInt(tempValue);

            if (operation == "add") {
                secondValue = firstValue + secondValue;
                result.setText(Integer.toString(secondValue));
            }

            if (operation == "sub") {
                secondValue = firstValue - secondValue;
                result.setText(Integer.toString(secondValue));
            }

            if (operation == "mul") {
                secondValue = firstValue * secondValue;
                result.setText(Integer.toString(secondValue));
            }

            if (operation == "div") {
                secondValue = firstValue / secondValue;
                result.setText(Integer.toString(secondValue));
            }

            tempValue = Integer.toString(secondValue);

        }

    }

    protected void onSaveInstanceState(Bundle dataToSave) {
        super.onSaveInstanceState(dataToSave);
        dataToSave.putInt("firstValue", firstValue);
        dataToSave.putInt("secondValue", secondValue);
        dataToSave.putString("tempValue", tempValue);
        dataToSave.putString("operation", operation);
        dataToSave.putString("result", result.getText().toString());
    }

}

