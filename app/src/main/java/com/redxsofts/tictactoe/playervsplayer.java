package com.redxsofts.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class playervsplayer extends AppCompatActivity {
    int player=0;

    //2 can play
    int[] boardState={2,2,2,2,2,2,2,2,2};
    boolean isContinue=true;
    int[][] positionWinnings={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void drapIn(View view)
    {
        ImageView chess=(ImageView) view;
        int postion=Integer.parseInt(chess.getTag().toString());


        if(boardState[postion]==2 && isContinue) {
            chess.setTranslationY(-1000f);
            boardState[postion]=player;
            if (player == 0)
            {
                chess.setImageResource(R.drawable.cross);
                player = 1;
            }
            else {
                chess.setImageResource(R.drawable.o);
                player = 0;
            }
            chess.animate().translationYBy(1000f).rotationYBy(360).setDuration(300);
            for(int[] positionWinning:positionWinnings)
            {
                if(boardState[positionWinning[0]]==boardState[positionWinning[1]] &&
                        boardState[positionWinning[1]]==boardState[positionWinning[2]] &&
                        boardState[positionWinning[2]]!=2)
                {

                    String Winner;
                    if(boardState[positionWinning[2]]==0)
                    {
                        Winner="Red";
                    }else
                    {
                        Winner="Blue";
                    }
                    Toast.makeText(this, "winner"+Winner, Toast.LENGTH_SHORT).show();
                    isContinue=false;

                }else
                {
                    boolean isover=true;

                    for(int i=0;i<boardState.length;i++)
                    {
                        if(boardState[i]==2)
                        {
                            isover=false;
                        }
                    }
                    if(isover)
                    {
                        Toast.makeText(this, "Game Over Draw Match...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playervsplayer);
    }
}