package com.example.yarasaadaldin_assignment_1_imd4008a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class MainActivity extends AppCompatActivity {



//Declaring the main variables
    TextView CalculationsTextView;
    TextView HistoryTextView1;
    TextView HistoryTextView2;
    TextView HistoryTextView3;
    TextView HistoryTextView4;
    TextView HistoryTextView5;
    String input = "";



//Starts the app
    //Tells the program what to show on the screen when the app runs
        //Shows the layouts that were created in the xml files
        //Shows all the operations (input and output) made by the user
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViews();
    }



//TextViews method
    //Defines the main variables
    private void TextViews() {
        CalculationsTextView   = (TextView)findViewById(R.id.CalculationResult);
        HistoryTextView1       = (TextView)findViewById(R.id.CalculationHistory1);
        HistoryTextView2       = (TextView)findViewById(R.id.CalculationHistory2);
        HistoryTextView3       = (TextView)findViewById(R.id.CalculationHistory3);
        HistoryTextView4       = (TextView)findViewById(R.id.CalculationHistory4);
        HistoryTextView5       = (TextView)findViewById(R.id.CalculationHistory5);
    }



//Output method
    //Gets called when buttons are pressed (so that the program knows what to output)
        //Defines what input and CalculationsTextView are
    private void Output(String InputValue){
        input =  input + InputValue;
        CalculationsTextView.setText(input);
    }



//Clear button method
    //Tells the program to clear the user input and also the calculation results whenever the user presses the clear button
    public void Clear(View view) {
        input = "";
        CalculationsTextView.setText("");
    }



//Back button method
    //Tells the program to delete the most recent entered input
    public void Back(View view) {
        String RecentInputtedText = input.substring(0, CalculationsTextView.length()-1);
        input = RecentInputtedText;
        CalculationsTextView.setText(RecentInputtedText);
    }



//Divide button method
    //Tells the program to output "/" when the divide button is pressed
    public void Divide(View view) {
        Output("/");
    }



//Seven button method
    //Tells the program to output "7" when the seven button is pressed
    public void Seven(View view) {
        Output("7");
    }



//Eight button method
    //Tells the program to output "8" when the eight button is pressed
    public void Eight(View view) {
        Output("8");
    }



//Nine button method
    //Tells the program to output "9" when the nine button is pressed
    public void Nine(View view) {
        Output("9");
    }



//Multiply button method
    //Tells the program to output "*" when the multiply button is pressed
    public void Multiply(View view) {
        Output("*");
    }



//Four button method
    //Tells the program to output "4" when the four button is pressed
    public void Four(View view) {
        Output("4");
    }



//Five button method
    //Tells the program to output "5" when the five button is pressed
    public void Five(View view) {
        Output("5");
    }



//Six button method
    //Tells the program to output "6" when the six button is pressed
    public void Six(View view) {
        Output("6");
    }



//Minus button method
    //Tells the program to output "-" when the minus button is pressed
    public void Minus(View view) {
        Output("-");
    }



//One button method
    //Tells the program to output "1" when the one button is pressed
    public void One(View view) {
        Output("1");
    }



//Two button method
    //Tells the program to output "2" when the two button is pressed
    public void Two(View view) {
        Output("2");
    }



//Three button method
    //Tells the program to output "3" when the three button is pressed
    public void Three(View view) {
        Output("3");
    }



//Plus button method
    //Tells the program to output "+" when the plus button is pressed
    public void Plus(View view) {
        Output("+");
    }



//PlusMinus button method
    //Tells the program to look at the sign of the number displayed on the screen
        //If the number is positive then make it negative
        //If the number is negative then make it positive
    public void PlusMinus(View view) {

    }



//Zero button method
    //Tells the program to output "0" when the zero button is pressed
    public void Zero(View view) {
        Output("0");
    }



//Point button method
    //Tells the program to output "." when the point button is pressed
    public void Point(View view) {
        Output(".");
    }



//Equal button method
    //Tells the program that when this button is pressed, then it should calculate the operation that was inputted using the rhino plugin
        //If the user entered an invalid input then display that on the screen
        //After the calculation is done
            //Output the result onto the calculation result layout
            //Output the recent calculation operation onto the history layout
    public void Equal(View view) {
        Double result= null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(input);
        } catch (ScriptException e){
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
        if(result != null)
            CalculationsTextView.setText(String.valueOf(result.doubleValue()));
            HistoryTextView1.setText(input + " = " + String.valueOf(result.doubleValue()));
    }



//onSaveInstanceState & onRestoreInstanceState
    //Makes the program function in a way where the values entered are not lost upon rotation
        //onSaveInstanceState saves operations on the screen
        //onRestoreInstanceState restores the saved operations when the screen is rotated
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("userInput", input);
        outState.putString("calculationOutput", input);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input = savedInstanceState.getString("userInput");
        CalculationsTextView.setText(input);
        HistoryTextView1.setText(input);
    }



}