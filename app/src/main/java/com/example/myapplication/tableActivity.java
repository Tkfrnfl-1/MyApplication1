package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tableActivity extends AppCompatActivity {


    public TextView num2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        Intent intent = getIntent();
        String[] getNName = intent.getStringArrayExtra("getNName");
        String RRes=intent.getStringExtra("ResTmp");
        String totalHTmp = intent.getStringExtra("totalHHTmp");
        String totalNNum =intent.getStringExtra("totalNumTmp");


        int res;
        res=Integer.parseInt(RRes);
        int numTmp;
        numTmp=Integer.parseInt(totalNNum);
        int HolyTmp;
        HolyTmp=Integer.parseInt(totalHTmp);

        num2 = findViewById(R.id.num2);

        num2.setText(RRes);


        TableRow.LayoutParams rowLayout = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT);

/*
        int trCt =numTmp+6;
        int tdCt=res+7;


            TableLayout table = new TableLayout(this); // 테이블 생성

            TableRow row[] = new TableRow[trCt];     // 테이블 ROW 생성

            TextView text[][] = new TextView[trCt][tdCt]; // 데이터


             row[0] = new TableRow(this);
            for (int tr = 1; tr < trCt; tr++) {                  // for문을 이용한 줄수 (TR)


                row[tr] = new TableRow(this);

                if(tr>2) {
                    text[tr][0].setText(getNName[tr - 1]);
                }
                if(tr==1) {
                    for (int td = 1; td < tdCt - 6; td++) {              // for문을 이용한 칸수 (TD)


                        text[tr][td] = new TextView(this);

                        text[tr][td].setText(td);                   // 데이터삽입

                        text[tr][td].setTextSize(5);                     // 폰트사이즈

                        text[tr][td].setTextColor(Color.BLACK);     // 폰트컬러

                        text[tr][td].setGravity(Gravity.CENTER);    // 폰트정렬


                        row[tr].addView(text[tr][td]);


                    } // td for end
                }

                table.addView(row[tr], rowLayout);


            } // tr for end */
        }
    }


