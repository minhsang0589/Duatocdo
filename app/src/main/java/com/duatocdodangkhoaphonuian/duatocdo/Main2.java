package com.duatocdodangkhoaphonuian.duatocdo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;






public class Main2 extends AppCompatActivity {
    TextView tvdiemso;

    SeekBar seekBar2,seekBar3;
    ImageButton implay;
    int sodiem= 1000;
    Button btnoto,btnmaybay;
    MediaPlayer song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_main2);
        Anhxa();
        btnmaybay.setEnabled(false);
        btnoto.setEnabled(false);

        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        tvdiemso.setText(sodiem+"");
//        song.stop();
//        final CountDownTimer countDownTimer=new CountDownTimer(60000,200) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                int number =5;
//                Random random =new Random();
//
//                int hai =random.nextInt(number);
//                int ba =random.nextInt(number);
//
//
//                if (seekBar2.getProgress()>=seekBar2.getMax()){
//                    this.cancel();
//                    implay.setVisibility(View.VISIBLE);
//                    Toast.makeText(Main2.this, "MÔ TÔ THẮNG", Toast.LENGTH_SHORT).show();
//
//                    tvdiemso.setText(sodiem+"");
//
//
//                }
//                if (seekBar3.getProgress()>=seekBar3.getMax()){
//                    this.cancel();
//                    implay.setVisibility(View.VISIBLE);
//                    Toast.makeText(Main2.this, "MÁY BAY THẮNG", Toast.LENGTH_SHORT).show();
//
//                    tvdiemso.setText(sodiem+"");
//
//
//                }
//
//                seekBar2.setProgress(seekBar2.getProgress()+hai);
//                seekBar3.setProgress(seekBar3.getProgress()+ba);
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        };
        implay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);
                    btnmaybay.setEnabled(true);
                    btnoto.setEnabled(true);

                    implay.setVisibility(View.INVISIBLE);
                    song=MediaPlayer.create(getApplicationContext(),R.raw.duaxe);
                    song.start();



//                    countDownTimer.start();


            }



        });
        btnoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number =5;
                Random random =new Random();

                int hai =random.nextInt(number);

                seekBar2.setProgress(seekBar2.getProgress()+hai);
                if (seekBar2.getProgress()>=seekBar2.getMax()){
                    btnoto.setEnabled(false);
                    btnmaybay.setEnabled(false);
                    Toast.makeText(Main2.this, "Ô TÔ THẮNG", Toast.LENGTH_SHORT).show();
                    tvdiemso.setText("Ô TÔ THẮNG");
                    implay.setVisibility(View.VISIBLE);
                    song.stop();

                }
            }
        });
        btnmaybay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number =5;
                Random random =new Random();


                int ba =random.nextInt(number);
                seekBar3.setProgress(seekBar3.getProgress()+ba);
                if (seekBar3.getProgress()>=seekBar3.getMax()){
                    btnoto.setEnabled(false);
                    btnmaybay.setEnabled(false);
                    Toast.makeText(Main2.this, "MÁY BAY THẮNG", Toast.LENGTH_SHORT).show();
                    tvdiemso.setText("MÁY BAY THẮNG");
                    implay.setVisibility(View.VISIBLE);
                    song.stop();
                }


            }
        });







    }
    private void Anhxa(){
        tvdiemso=(TextView)findViewById(R.id.tvdiem);
        implay=(ImageButton)findViewById(R.id.btnplay);

        seekBar2=(SeekBar)findViewById(R.id.seekbar2);
        seekBar3=(SeekBar)findViewById(R.id.seekbar3);
        btnmaybay=(Button)findViewById(R.id.btnmaybay);
        btnoto=(Button)findViewById(R.id.btnoto);




    }
}

