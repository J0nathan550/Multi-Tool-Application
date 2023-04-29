package com.j0nathan550.multitoolapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;


public class CalculatorFragment extends Fragment {

    private String firstNumber = "", secondNumber = "";
    private String mathOperation = "";
    private boolean isFirstNumber = true;
    private boolean hasComma = false;

    public CalculatorFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        LoadUI(view);
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void LoadUI(View view) {
        TextInputEditText resultTab = view.findViewById(R.id.resultTab);
        Button buttonOne = view.findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "1";
                } else {
                    firstNumber += "1";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "1";
                } else {
                    secondNumber += "1";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonTwo = view.findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "2";
                } else {
                    firstNumber += "2";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "2";
                } else {
                    secondNumber += "2";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonThree = view.findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "3";
                } else {
                    firstNumber += "3";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "3";
                } else {
                    secondNumber += "3";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonFour = view.findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "4";
                } else {
                    firstNumber += "4";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "4";
                } else {
                    secondNumber += "4";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonFive = view.findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "5";
                } else {
                    firstNumber += "5";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "5";
                } else {
                    secondNumber += "5";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonSix = view.findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "6";
                } else {
                    firstNumber += "6";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "6";
                } else {
                    secondNumber += "6";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonSeven = view.findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "7";
                } else {
                    firstNumber += "7";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "7";
                } else {
                    secondNumber += "7";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonEight = view.findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "8";
                } else {
                    firstNumber += "8";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "8";
                } else {
                    secondNumber += "8";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonNine = view.findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    firstNumber = "9";
                } else {
                    firstNumber += "9";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    secondNumber = "9";
                } else {
                    secondNumber += "9";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button buttonZero = view.findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(v -> {
            if(isFirstNumber) {
                if (firstNumber.length() == 0) {
                    return;
                } else {
                    firstNumber += "0";
                }
                resultTab.setText(firstNumber);
            }
            else {
                if (secondNumber.length() == 0) {
                    return;
                } else {
                    secondNumber += "0";
                }
                resultTab.setText(secondNumber);
            }
        });
        Button clearEverything = view.findViewById(R.id.clearButton);
        clearEverything.setOnClickListener(v -> {
            firstNumber = "";
            secondNumber = "";
            mathOperation = "";
            isFirstNumber = true;
            hasComma = false;
            resultTab.setText(firstNumber);
        });
        Button removeCharacterButton = view.findViewById(R.id.removeCharacterButton);
        removeCharacterButton.setOnClickListener(v -> {
            if(isFirstNumber){
                if(firstNumber.length() != 0) {
                    String temp = firstNumber;
                    if(temp.charAt(temp.length() - 1) == '.')
                    {
                        hasComma = false;
                    }
                    firstNumber = temp.substring(0, temp.length() - 1);
                    resultTab.setText(firstNumber);
                }
            }
            else {
                if(secondNumber.length() != 0) {
                    String temp = secondNumber;
                    if(temp.charAt(temp.length() - 1) == '.')
                    {
                        hasComma = false;
                    }
                    secondNumber = temp.substring(0, temp.length() - 1);
                    resultTab.setText(secondNumber);
                }
            }
        });
        Button buttonPercentage = view.findViewById(R.id.percentageButton);
        buttonPercentage.setOnClickListener(v -> {
            if(firstNumber.length() == 0 || secondNumber.length() == 0) return;
            double secondNum = Double.parseDouble(secondNumber);
            double firstNum = Double.parseDouble(firstNumber);
            secondNum = (firstNum * secondNum) / 100;
            secondNumber = Double.toString(secondNum);
            resultTab.setText(secondNumber);
        });
        Button buttonComma = view.findViewById(R.id.buttonComma);
        buttonComma.setOnClickListener(v -> {
            if(isFirstNumber){
                if (firstNumber.contains(".")){
                    hasComma = true;
                    return;
                }
                if(firstNumber.length() != 0 && !hasComma) {
                    firstNumber += ".";
                    hasComma = true;
                    resultTab.setText(firstNumber);
                }
            }
            else {
                if (secondNumber.contains(".")){
                    hasComma = true;
                    return;
                }
                if(secondNumber.length() != 0 && !hasComma) {
                    secondNumber += ".";
                    hasComma = true;
                    resultTab.setText(secondNumber);
                }
            }
        });
        Button absoluteButton = view.findViewById(R.id.absoluteButton);
        absoluteButton.setOnClickListener(v -> {
            if (isFirstNumber){
                if(firstNumber.length() != 0){
                    if(firstNumber.startsWith("-")){
                        firstNumber = firstNumber.substring(1);
                    }
                    else {
                        firstNumber = "-" + firstNumber;
                    }
                    resultTab.setText(firstNumber);
                }
            }
            else {
                if(secondNumber.length() != 0){
                    if(secondNumber.startsWith("-")){
                        secondNumber = secondNumber.substring(0, 1);
                    }
                    else {
                        secondNumber = "-" + secondNumber;
                    }
                    resultTab.setText(secondNumber);
                }
            }
        });
        Button plusButton = view.findViewById(R.id.plusButton);
        plusButton.setOnClickListener(v -> {
            if(isFirstNumber && firstNumber.length() != 0) {
                mathOperation = "+";
                resultTab.setText(mathOperation);
                hasComma = false;
                isFirstNumber = false;
            }
        });
        Button minusButton = view.findViewById(R.id.minusButton);
        minusButton.setOnClickListener(v -> {
            if(isFirstNumber && firstNumber.length() != 0) {
                mathOperation = "-";
                resultTab.setText(mathOperation);
                hasComma = false;
                isFirstNumber = false;
            }
        });
        Button divideButton = view.findViewById(R.id.divideButton);
        divideButton.setOnClickListener(v -> {
            if(isFirstNumber && firstNumber.length() != 0) {
                mathOperation = "÷";
                resultTab.setText(mathOperation);
                hasComma = false;
                isFirstNumber = false;
            }
        });
        Button multiplyButton = view.findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(v -> {
            if(isFirstNumber && firstNumber.length() != 0) {
                mathOperation = "×";
                resultTab.setText(mathOperation);
                hasComma = false;
                isFirstNumber = false;
            }
        });
        Button equalsButton = view.findViewById(R.id.equalsButton);
        equalsButton.setOnClickListener(v -> {
            if(firstNumber.length() == 0 || secondNumber.length() == 0) return;
            double firstNum = Double.parseDouble(firstNumber);
            double secondNum = Double.parseDouble(secondNumber);
            double result = 0;
            switch (mathOperation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "×":
                    result = firstNum * secondNum;
                    break;
                case "÷":
                    result = firstNum / secondNum;
                    break;
            }
            resultTab.setText(Double.toString(result));
            firstNumber = Double.toString(result);
            mathOperation = "";
            secondNumber = "";
            isFirstNumber = true;
        });
    }
}