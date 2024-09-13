package com.example.some_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
        // 0.1 starts here

        // Variables to hold the values
        private TextView display;
        private String currentInput = "";
        private String operator = "";
        private double firstOperand = 0;
        private double secondOperand = 0;
        private boolean isOperatorPressed = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            display = findViewById(R.id.display);

            // Number buttons
            Button button0 = findViewById(R.id.button0);
            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);
            Button button6 = findViewById(R.id.button6);
            Button button7 = findViewById(R.id.button7);
            Button button8 = findViewById(R.id.button8);
            Button button9 = findViewById(R.id.button9);

            // Operator buttons
            Button buttonAdd = findViewById(R.id.buttonAdd);
            Button buttonSubtract = findViewById(R.id.buttonSubtract);
            Button buttonMultiply = findViewById(R.id.buttonMultiply);
            Button buttonDivide = findViewById(R.id.buttonDivide);
            Button buttonEqual = findViewById(R.id.buttonEqual);
            Button buttonClear = findViewById(R.id.buttonC);
            Button buttonDot = findViewById(R.id.buttonDot);

            // Set onClickListeners for number buttons
            View.OnClickListener numberClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    currentInput += button.getText().toString();
                    display.setText(currentInput);
                }
            };

            button0.setOnClickListener(numberClickListener);
            button1.setOnClickListener(numberClickListener);
            button2.setOnClickListener(numberClickListener);
            button3.setOnClickListener(numberClickListener);
            button4.setOnClickListener(numberClickListener);
            button5.setOnClickListener(numberClickListener);
            button6.setOnClickListener(numberClickListener);
            button7.setOnClickListener(numberClickListener);
            button8.setOnClickListener(numberClickListener);
            button9.setOnClickListener(numberClickListener);

            // Dot button
            buttonDot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!currentInput.contains(".")) {
                        currentInput += ".";
                        display.setText(currentInput);
                    }
                }
            });

            // Operator buttons
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOperator("+");
                }
            });

            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOperator("-");
                }
            });

            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOperator("*");
                }
            });

            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOperator("/");
                }
            });

            // Equals button
            buttonEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isOperatorPressed) return;

                    secondOperand = Double.parseDouble(currentInput);
                    double result = calculateResult(firstOperand, secondOperand, operator);
                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    isOperatorPressed = false;
                }
            });

            // Clear button
            buttonClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearCalculator();
                }
            });
        }

        // Method to set operator
        private void setOperator(String op) {
            if (!currentInput.isEmpty()) {
                firstOperand = Double.parseDouble(currentInput);
                operator = op;
                currentInput = "";
                isOperatorPressed = true;
            }
        }

        // Method to calculate the result
        private double calculateResult(double first, double second, String operator) {
            switch (operator) {
                case "+":
                    return first + second;
                case "-":
                    return first - second;
                case "*":
                    return first * second;
                case "/":
                    if (second != 0) return first / second;
                    else return 0; // Handle divide by zero case
                default:
                    return 0;
            }
        }

        // Method to clear the calculator
        private void clearCalculator() {
            currentInput = "";
            firstOperand = 0;
            secondOperand = 0;
            operator = "";
            isOperatorPressed = false;
            display.setText("0");
        }
    }
