package balaji.ch.balaji_jav1001_basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String editTextString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Initializing all the buttons
//        EditText editTextTV = findViewById(R.id.numberEditText);
        Button buttonZero = findViewById(R.id.buttonZero);
        Button buttonOne = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        Button buttonThree = findViewById(R.id.buttonThree);
        Button buttonFour = findViewById(R.id.buttonFour);
        Button buttonFive = findViewById(R.id.buttonFive);
        Button buttonSix = findViewById(R.id.buttonSix);
        Button buttonSeven = findViewById(R.id.buttonSeven);
        Button buttonEight = findViewById(R.id.buttonEight);
        Button buttonNine = findViewById(R.id.buttonNine);
        Button buttonDecimal = findViewById(R.id.buttonDecimal);

        Button buttonAddition = findViewById(R.id.buttonAddition);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonPercentile = findViewById(R.id.buttonPercentile);
        Button buttonNegation = findViewById(R.id.buttonNegation);

        Button buttonAC = findViewById(R.id.buttonAC);
        Button buttonResult = findViewById(R.id.buttonResult);


        buttonZero.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);

        buttonAddition.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonPercentile.setOnClickListener(this);
        buttonNegation.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        EditText editTextTV = findViewById(R.id.numberEditText);
        Button buttonDecimal = findViewById(R.id.buttonDecimal);
        editTextString = String.valueOf(editTextTV.getText());

//        Letting the decimal value to be clicked only once

        if(editTextString.contains(".")){
            int indexOfPriorChar = editTextString.indexOf('.') - 1;
            if (indexOfPriorChar<0){ indexOfPriorChar = 0;}

            if (Character.isDigit(editTextString.charAt(indexOfPriorChar)) && editTextString.charAt(indexOfPriorChar) != '.'){
                buttonDecimal.setEnabled(true);
            }
            else{
                buttonDecimal.setEnabled(false);
            }
        } else{
            buttonDecimal.setEnabled(true);
        }

//Calculate when buttons are clicked
        switch(view.getId()){
            case R.id.buttonZero:
                editTextString += "0";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonOne:
                editTextString += "1";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonTwo:
                editTextString += "2";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonThree:
                editTextString += "3";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonFour:
                editTextString += "4";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonFive:
                editTextString += "5";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonSix:
                editTextString += "6";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonSeven:
                editTextString += "7";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonEight:
                editTextString += "8";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonNine:
                editTextString += "9";
                editTextTV.setText(editTextString);
                break;

            case R.id.buttonDecimal:
                editTextString += ".";
                editTextTV.setText(editTextString);
                break;

            case R.id.buttonAddition:
                if (!editTextString.isEmpty() && Character.isDigit(editTextString.charAt(editTextString.length()-1))){
                    editTextString += "+";
                    editTextTV.setText(editTextString);
                }
                break;
            case R.id.buttonSubtract:
                if (!editTextString.isEmpty() && Character.isDigit(editTextString.charAt(editTextString.length()-1))){
                    editTextString += "-";
                    editTextTV.setText(editTextString);
                }
                break;
            case R.id.buttonMultiply:
                if (!editTextString.isEmpty() && Character.isDigit(editTextString.charAt(editTextString.length()-1))){
                    editTextString += "x";
                    editTextTV.setText(editTextString);
                }
                break;
            case R.id.buttonDivide:
                if (!editTextString.isEmpty() && Character.isDigit(editTextString.charAt(editTextString.length()-1))){
                    editTextString += "/";
                    editTextTV.setText(editTextString);
                }
                break;
            case R.id.buttonPercentile:
//                if (!editTextString.isEmpty() && Character.isDigit(editTextString.charAt(editTextString.length()-1))){
//                    editTextString += "%";
//                    editTextTV.setText(editTextString);
//                    editTextTV.setText(String.valueOf(Float.parseFloat(String.valueOf(editTextString.charAt(0))) / 100));
//                }
                editTextString += "%";
                editTextTV.setText(editTextString);
                break;
            case R.id.buttonNegation:
                if (editTextString.charAt(0) == '-'){
                    editTextString = editTextString.substring(1);
                } else{
                    if (Character.isDigit(editTextString.charAt(editTextString.length()-1)) && editTextString.length() == 1){
                        editTextString = "-" + editTextString;
                    }
                }
                break;

            case R.id.buttonAC:
                editTextString = "";
                editTextTV.setText(editTextString);
                buttonDecimal.setEnabled(true);
                break;
            case R.id.buttonResult:
                BigDecimal result = updateResult(editTextString);
                int roundOffSum = result.intValue();

                if(result.equals(roundOffSum)){
                    editTextTV.setText(String.valueOf(roundOffSum));
                }else{
                    editTextTV.setText(String.valueOf(result));
                }
                break;
            default:
                break;
        }
    }

    public BigDecimal updateResult(String editTextString){
        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal currentValue = BigDecimal.valueOf(0);
        char operator = '+';
        char[] charArray = editTextString.toCharArray();

        Stack<BigDecimal> stackElements = new Stack<>();
        for (int i=0;i<charArray.length;i++){
            if(Character.isDigit(charArray[i])){
                currentValue = currentValue.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(charArray[i] - '0'));
            }

            if(!Character.isDigit(charArray[i]) && charArray[i] != ' ' || i == charArray.length - 1){
                if(operator=='+'){
                    stackElements.push(currentValue);
                }else if(operator=='-'){
                    stackElements.push(currentValue.negate());
                }else if(operator=='x'){
                    stackElements.push(currentValue.multiply(stackElements.pop()));
                }else if(operator=='/'){
                    stackElements.push(currentValue.multiply(stackElements.pop()));
                }else if(operator=='%'){
                    stackElements.push((stackElements.pop().multiply(currentValue)).divide(BigDecimal.valueOf(100)));
                } else if (operator=='.'){

                    String tempString = String.valueOf(stackElements.pop());
                    stackElements.push(new BigDecimal(tempString + "." + currentValue.toString()));
                }
                currentValue = BigDecimal.valueOf(0);
                operator = charArray[i];
            }
        }

        while(!stackElements.isEmpty()){
            sum = sum.add(stackElements.pop());
        }

        return sum;
    }
}