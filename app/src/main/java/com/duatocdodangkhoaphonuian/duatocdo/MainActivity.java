package com.duatocdodangkhoaphonuian.duatocdo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvdiemso;
    CheckBox checkBox1,checkBox2,checkBox3;
    SeekBar seekBar1,seekBar2,seekBar3;
    ImageButton implay;
    int sodiem= 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        tvdiemso.setText(sodiem+"");
        final CountDownTimer countDownTimer=new CountDownTimer(60000,200) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number =5;
                Random random =new Random();
                int mot =random.nextInt(number);
                int hai =random.nextInt(number);
                int ba =random.nextInt(number);
                if (seekBar1.getProgress()>=seekBar1.getMax()){
                    this.cancel();
                    implay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Ô TÔ THẮNG", Toast.LENGTH_SHORT).show();
                    if (checkBox1.isChecked()){
                        sodiem=sodiem+100;
                        Toast.makeText(MainActivity.this, "bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sodiem=sodiem-100;
                        Toast.makeText(MainActivity.this, "bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    tvdiemso.setText(sodiem+"");
                    EnableCheckbox();
                }
                if (seekBar2.getProgress()>=seekBar2.getMax()){
                    this.cancel();
                    implay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "MÔ TÔ THẮNG", Toast.LENGTH_SHORT).show();
                    if (checkBox2.isChecked()){
                        sodiem=sodiem+100;
                        Toast.makeText(MainActivity.this, "bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sodiem=sodiem-100;
                        Toast.makeText(MainActivity.this, "bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    tvdiemso.setText(sodiem+"");
                    EnableCheckbox();

                }
                if (seekBar3.getProgress()>=seekBar3.getMax()){
                    this.cancel();
                    implay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "MÁY BAY THẮNG", Toast.LENGTH_SHORT).show();
                    if (checkBox3.isChecked()){
                        sodiem=sodiem+100;
                        Toast.makeText(MainActivity.this, "bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sodiem=sodiem-100;
                        Toast.makeText(MainActivity.this, "bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    tvdiemso.setText(sodiem+"");
                    EnableCheckbox();

                }
                seekBar1.setProgress(seekBar1.getProgress()+mot);
                seekBar2.setProgress(seekBar2.getProgress()+hai);
                seekBar3.setProgress(seekBar3.getProgress()+ba);
            }

            @Override
            public void onFinish() {

            }
        };
        implay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);

                    implay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckbox();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược chọn xe nào?", Toast.LENGTH_SHORT).show();
                }
            }

        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
    }
    private void  EnableCheckbox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    private void DisableCheckbox(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
    private void Anhxa(){
        tvdiemso=(TextView)findViewById(R.id.tvdiemso);
        implay=(ImageButton)findViewById(R.id.btnplay);
        checkBox1=(CheckBox)findViewById(R.id.checkbox1);
        checkBox2=(CheckBox)findViewById(R.id.checkbox2);
        checkBox3=(CheckBox)findViewById(R.id.checkbox3);
        seekBar1=(SeekBar)findViewById(R.id.seekbar1);
        seekBar2=(SeekBar)findViewById(R.id.seekbar2);
        seekBar3=(SeekBar)findViewById(R.id.seekbar3);




    }
}
