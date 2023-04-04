package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playeractive = 0;
    int GameState[]={2,2,2,2,2,2,2,2,2};
    public static int count =0;
    boolean gameActive = true;

    int[][] winningPosition ={{0,1,2},{3,4,5},{6,7,8},
                              { 1,4,7},{2,5,8},
                             {0,3,6},{0,4,8},{2,4,6}};

    public void OnImageTap(View view) {
        ImageView imageView = (ImageView) view;
        imageView.setTranslationY(-1000);
        // here player 0= zero
        // and player 1= cross

        int ImageTapped = Integer.parseInt(imageView.getTag().toString());
        if (GameState[ImageTapped] == 2 && gameActive) {
            count++;
            if(count == 9){
                gameActive = false;
            }
            GameState[ImageTapped]=playeractive;
            if (playeractive == 0) {
                imageView.setImageResource(R.drawable.zero);
                playeractive = 1;
                TextView status=findViewById(R.id.textView2);
                status.setText("Player 2's Turn");
//

            } else {
                imageView.setImageResource(R.drawable.cross);
                playeractive = 0;
//
                TextView status=findViewById(R.id.textView2);
                status.setText("Player 1's Turn");
            }

            imageView.animate().translationYBy(1000).setDuration(200);

            int draw=1;
            for(int[] winningposition :winningPosition){
                if(GameState[winningposition[0]]== GameState[winningposition[1]]
                && GameState[winningposition[1]]== GameState[winningposition[2]]
                && GameState[winningposition[0]] !=2){
                    draw=0; // not a draw
                    String winner;
                    if(GameState[winningposition[0]]==0){
                        winner= "Player 1 Won";

                    }else {
                        winner = "Player 2 Won";
                    }
                        TextView status=findViewById(R.id.textView2);
                        status.setText(winner);

                        Button playAgainButton =findViewById(R.id.button);
                        playAgainButton.setVisibility(View.VISIBLE);

                }

            }

            //draw condition
            if (count==9 && draw==1) {
                TextView status = findViewById(R.id.textView2);
                status.setText("Match Draw ");

                Button playAgainButton = findViewById(R.id.button);
                playAgainButton.setVisibility(View.VISIBLE);

            }


        }
    }

    public void Playagain(View view){

        TextView status = findViewById(R.id.textView2);
        status.setText("Player 1's Turn");

        Button playAgainButton = findViewById(R.id.button);
        playAgainButton.setVisibility(View.INVISIBLE);

        gameActive= true;
        playeractive=0;
        count=0;

        //setting gamestate to empty
        for (int i = 0; i < GameState.length; i++) {
            GameState[i]=2;
        }


        ((ImageView)findViewById(R.id.imageView0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView8)).setImageDrawable(null);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button PlayAgainbutton = findViewById(R.id.button);
        PlayAgainbutton.setVisibility(View.INVISIBLE);
    }
}