package com.example.mohmassoud.tictactoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean playerTurn=false;
    private int clickedButtons;
    private int player1Score;
    private int player2Score;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private Button[][] buttons=new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPlayer1=findViewById(R.id.p1);
        textViewPlayer2=findViewById(R.id.p2);
        Button resetBtn=findViewById(R.id.resetBtn);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "Btn" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
            }
        }
//        buttons[0][0]
    }

    public void clickedIt(View view) {
        if(!((Button) view).getText().toString().equals("")){
            Toast.makeText(this,"This button is clicked before.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(playerTurn){
            ((Button)view).setText("X");
        }else{
            ((Button)view).setText("O");
        }
        clickedButtons++;
        if(Wins()){
            if(playerTurn){
                player1Wins();
            }else {
                player2Wins();
            }
        }else if(clickedButtons==9){
            draw();
        }else{
            playerTurn=!playerTurn;
        }

    }

    private void draw() {
        Toast.makeText(this,"Draw!.",Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void player2Wins() {
        Toast.makeText(this,"Player2 Wins!!.",Toast.LENGTH_SHORT).show();
        player2Score++;
        textViewPlayer2.setText("Player2: "+player2Score);
        resetBoard();
    }

    private void player1Wins() {
        Toast.makeText(this,"Player1 Wins!!.",Toast.LENGTH_SHORT).show();
        player1Score++;
        textViewPlayer1.setText("Player1: "+player1Score);
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        clickedButtons = 0;
        playerTurn = true;
    }
    private boolean Wins() {
        String [][] board= new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[i][0].equals(board[i][1])&&board[i][0].equals(board[i][2])&&!board[i][0].equals("")){
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[0][i].equals(board[1][i])&&board[0][i].equals(board[2][i])&&!board[0][i].equals("")){
                return true;
            }
        }
        if(board[0][0].equals(board[1][1])&&board[0][0].equals(board[2][2])&&!board[0][0].equals("")){
            return true;
        }
        if(board[0][2].equals(board[1][1])&&board[0][2].equals(board[2][0])&&!board[0][2].equals("")){
            return true;
        }
        return false;
    }

    public void resetBtn(View view) {
        resetBoard();
        player2Score=0;
        player1Score=0;
        textViewPlayer1.setText("Player1: "+0);
        textViewPlayer2.setText("Player2: "+0);
    }
}
