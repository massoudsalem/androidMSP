package com.msp.msp.simplecalculator;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

import static java.lang.Double.NaN;

public class calculator extends AppCompatActivity {
    public boolean displayResult=false;
    double value1=NaN;
    double value2=NaN;
    String display="";
    String operation="";
    TextView screen;
    TextView calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen= findViewById(R.id.screen);
        calc= findViewById(R.id.calc);
    }
    public void updateScreen(String s){
        screen.setText(s);
    }
    public void updateCalc(String s){
        calc.setText(s);
    }
    public void onClickDot(View v){
        String currentDisplay = screen.getText().toString();
        if(currentDisplay.indexOf('.')==-1) {
            Button num = (Button) v;
            updateCalc(calc.getText().toString()
                            + num.getText().toString());
            display += num.getText().toString();
            updateScreen(display);
        }
    }
    public void onClickNumber(View v){
        Button num = (Button) v;
        display+=num.getText().toString();
        updateScreen(display);
    }
    public void onClickClear(View v){
        display="";
        value1=NaN;
        value2=NaN;
        updateScreen(display);
        updateCalc(display);
    }
    public void onClickOperator(View v){
        Button op= (Button) v;
        operation=op.getText().toString();
        value1=Double.valueOf(screen.getText().toString());
        display="";
        updateScreen(display);
        updateCalc(String.valueOf(value1));
    }
    private double operateArithmetic(Double a, Double b, String op){
        switch (op){
            case "+":
                return(a + b);
            case "-":
                return(a - b);
            case "*":
                return(a * b);
            case "/": try{
                return(a / b);
            } catch(Exception e){
                Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }
    public void onClickEqual(View view) {
        if(calc.getText().toString()!=""){
        display=screen.getText().toString();
        value2=Double.valueOf(display);
        String newValue=String.valueOf(operateArithmetic(value1,value2,operation));
        updateScreen(newValue);
        value1=Double.valueOf(newValue);
        if(operation=="+"||operation=="-"){
            value2=0;
        }else{
            value1=1;
        }
        display="";
        updateCalc(display);
        }
    }
}
