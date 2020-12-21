package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class numberActivity extends AppCompatActivity {

    public EditText totalNum;
    public TextView num1;
    LinearLayout ll;

    public Button btn_move1;
    private String[] getNName=new String[20];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number );

        num1=findViewById(R.id.num1);

        int numberOfPerson ;

        Intent intent=getIntent();
        String totalNumTmp=intent.getStringExtra("totalNNum");
        String ResTmp=intent.getStringExtra("Res");
        String totalHHTmp=intent.getStringExtra("totalHH");


        //int totalNumReal=Integer.parseInt(totalNumTmp);

       //num1.setText(totalNumTmp);

       ll = findViewById(R.id.ll);
       numberOfPerson=Integer.parseInt(totalNumTmp);
       int tmp=numberOfPerson;


       for(int i=0;i<numberOfPerson;i++)
       {
           final EditText et =new EditText(getApplicationContext());
           final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, getResources().getDisplayMetrics());

           LinearLayout.LayoutParams p =new LinearLayout.LayoutParams(width,ViewGroup.LayoutParams.WRAP_CONTENT);
           et.setLayoutParams(p);
           et.setId(i);
           et.setHint("No ."+i);
           ll.addView(et);
       }

        btn_move1=findViewById(R.id.btn_move1);
        btn_move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText[] getName =new EditText[20];
                for(int j=0;j<tmp;j++)
                {
                    getName[j]=findViewById(j);
                    getNName[j]=getName[j].getText().toString();
                }

                Intent intent2 =new Intent(numberActivity.this,tableActivity.class);
                intent2.putExtra("getNName",getNName);
                intent2.putExtra("ResTmp",ResTmp);
                intent2.putExtra("totalHHTmp",totalHHTmp);
                intent2.putExtra("totalNumTmp",totalNumTmp);





                startActivity(intent2);
            }
        });


    }
}


