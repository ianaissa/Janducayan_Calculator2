package com.example.janducayan_arithcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText resultEditText;
    private StringBuilder currentNumber;
    private double operand1, operand2;
    private String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultEditText = findViewById(R.id.resultEditText);
        currentNumber = new StringBuilder();

        setButtonListeners();
    }

    private void setButtonListeners() {
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);

        btn0.setOnClickListener(numberButtonClickListener);
        btn1.setOnClickListener(numberButtonClickListener);
        btn2.setOnClickListener(numberButtonClickListener);
        btn3.setOnClickListener(numberButtonClickListener);
        btn4.setOnClickListener(numberButtonClickListener);
        btn5.setOnClickListener(numberButtonClickListener);
        btn6.setOnClickListener(numberButtonClickListener);
        btn7.setOnClickListener(numberButtonClickListener);
        btn8.setOnClickListener(numberButtonClickListener);
        btn9.setOnClickListener(numberButtonClickListener);
        btnDot.setOnClickListener(numberButtonClickListener);

        btnEquals.setOnClickListener(equalsButtonClickListener);
        btnAdd.setOnClickListener(operatorButtonClickListener);
        btnSubtract.setOnClickListener(operatorButtonClickListener);
        btnMultiply.setOnClickListener(operatorButtonClickListener);
        btnDivide.setOnClickListener(operatorButtonClickListener);
    }

    private View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            currentNumber.append(button.getText().toString());
            resultEditText.setText(currentNumber.toString());
        }
    };

    private View.OnClickListener equalsButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (operator != null && !operator.isEmpty()) {
                operand2 = Double.parseDouble(currentNumber.toString());
                double result = performOperation(operand1, operand2, operator);
                resultEditText.setText(String.valueOf(result));

                currentNumber = new StringBuilder();
                operand1 = 0;
                operand2 = 0;
                operator = null;
            }
        }
    };

    private View.OnClickListener operatorButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            operator = button.getText().toString();

            if (currentNumber.length() > 0) {
                operand1 = Double.parseDouble(currentNumber.toString());
                currentNumber = new StringBuilder();
            }
        }
    };

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return Double.NaN; // Division by zero
                }
            default:
                return 0;
        }
    }
}

