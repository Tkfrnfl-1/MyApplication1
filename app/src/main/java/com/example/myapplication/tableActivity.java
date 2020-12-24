package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class tableActivity extends AppCompatActivity {


    private  TextView title;
    private TableLayout tableLayout;
    public Button btn_move2;
    public Button btn_move3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        Intent intent = getIntent();
        String[] getNName = intent.getStringArrayExtra("getNName");
        String RRes = intent.getStringExtra("ResTmp");
        String totalHTmp = intent.getStringExtra("totalHHTmp");
        String totalNNum = intent.getStringExtra("totalNumTmp");
        String dayOf1 = intent.getStringExtra("dayOf1");

        int res;
        res = Integer.parseInt(RRes);
        int numTmp;
        numTmp = Integer.parseInt(totalNNum);
        int HolyTmp;
        HolyTmp = Integer.parseInt(totalHTmp);
        int dayOfTmp;
        dayOfTmp = Integer.parseInt(dayOf1);

        title = (TextView) findViewById(R.id.title1);
        title.setText("<시간표>");
        title.setTextSize(30);
        //TableLayout.LayoutParams layoutParams=new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rowLayout = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        tableLayout = (TableLayout) findViewById(R.id.stable);
        TableRow tableRow[] = new TableRow[numTmp + 4];
        TextView textView[][] = new TextView[numTmp + 7][res + 7];
        EditText eT[][] = new EditText[numTmp + 7][res + 7];


        for (int j = 0; j < numTmp + 4; j++) {
            // tableRow[j].setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            tableRow[j] = new TableRow(this);
            tableRow[j].setBackgroundResource(R.drawable.cell);
            for (int i = 0; i < res + 7; i++)       // 표의 입력값을 읽고 반영해주면서 빈 부분 자동으로 일정 짜주기.
            {
                textView[j][i] = new TextView(this);
                textView[j][i].setBackgroundResource(R.drawable.cell);
                if (j == 0) {
                    if (i == 0) {
                        textView[j][i].setText("");
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);
                    } else if (i > 0 && i < res + 1) {
                        textView[j][i].setText(String.valueOf(i));
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);
                    } else if (i >= res + 1) {
                        switch (i - res) {
                            case 1:
                                textView[j][i].setText("주간");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 2:
                                textView[j][i].setText("야간");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 3:
                                textView[j][i].setText("비번");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 4:
                                textView[j][i].setText("휴일");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 5:
                                textView[j][i].setText("연가");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 6:
                                textView[j][i].setText("합계");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                        }

                    }
                } else if (j == 1) {
                    if (i == 0) {
                        textView[j][i].setText("요일");
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);

                    } else if (i < res + 1) {
                        switch ((dayOfTmp - 1 + i) % 7) {
                            case 1:
                                textView[j][i].setText("일");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 2:
                                textView[j][i].setText("월");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 3:
                                textView[j][i].setText("화");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 4:
                                textView[j][i].setText("수");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 5:
                                textView[j][i].setText("목");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 6:
                                textView[j][i].setText("금");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;
                            case 0:
                                textView[j][i].setText("토");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i]);
                                break;

                        }
                    }
                   /* else
                    {
                        textView[j][i].setText("");
                        textView[j][i].setTextSize(30);
                       tableRow[j].addView(textView[j][i]);

                    }*/

                } else if (j > 1 && j < numTmp + 2) {
                    eT[j][i] = new EditText(this);
                    eT[j][i].setBackgroundResource(R.drawable.cell);
                    eT[j][i].setId(100 * j + i);

                    if (i == 0) {
                        textView[j][i].setText(getNName[j - 2]);
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);
                    } else {
                        //textView[j][i].setText("");

                        tableRow[j].addView(eT[j][i]);
                        textView[j][i].setTextSize(30);
                    }
                } else if (j == numTmp + 2) {
                    eT[j][i] = new EditText(this);
                    eT[j][i].setBackgroundResource(R.drawable.cell);
                    eT[j][i].setId(100 * j + i);
                    if (i == 0) {
                        textView[j][i].setText("주간 인원");
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);
                    } else {
                        tableRow[j].addView(eT[j][i]);
                        textView[j][i].setTextSize(30);
                    }
                } else if (j == numTmp + 3) {
                    eT[j][i] = new EditText(this);
                    eT[j][i].setBackgroundResource(R.drawable.cell);
                    eT[j][i].setId(100 * j + i);
                    if (i == 0) {
                        textView[j][i].setText("야간 인원");
                        textView[j][i].setTextSize(30);
                        tableRow[j].addView(textView[j][i]);
                    } else {
                        tableRow[j].addView(eT[j][i]);
                        textView[j][i].setTextSize(30);
                    }
                }
            }
            tableLayout.addView(tableRow[j], rowLayout);


        }
        btn_move2 = findViewById(R.id.btn_move2);
        btn_move3 = findViewById(R.id.btn_move3);

        int dayNum[] = new int[res + 1];
        int nigNum[] = new int[res + 1];
        int status[][] = new int[numTmp][6];
        int chkHoli[] = new int[numTmp];
        int chkwork[] = new int[numTmp];

        Arrays.fill(chkHoli, HolyTmp);
        Arrays.fill(chkwork, (res - HolyTmp));

        btn_move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 1; i < res + 1; i++) {
                    int randTmp = ((int) (Math.random() * 10)) % 3;
                    for (int j = 2; j < numTmp + 2; j++) {

                        if (eT[j][i].getText().toString().equals("주")) {
                            if (dayNum[i] <= numTmp / 2 && chkwork[j - 2] > 0) // 잔여 근무일수 확인및 한쪽에 쏠리지 않도록 제한
                            {
                                chkwork[j - 2]--;
                                dayNum[i]++;
                                status[j - 2][0]++;
                                status[j - 2][5]++;

                                textView[j][i].setText("주");
                                textView[j][i].bringToFront();
                                tableRow[j].addView(textView[j][i], i);
                            } else {
                                Toast.makeText(getApplicationContext(), getNName[j] + String.valueOf(i) + "day has problem", Toast.LENGTH_SHORT).show();
                            }

                        } else if (eT[j][i].getText().toString().equals("야")) {
                            if (nigNum[i] <= numTmp / 2 && chkwork[j - 2] > 0) {
                                chkwork[j - 2]--;
                                nigNum[i]++;
                                status[j - 2][1]++;
                                status[j - 2][5]++;       //합계도 증가
                                eT[j][i + 1].setText("비");   //야간 이후엔 비번으로 자동변경
                                textView[j][i].setText("야");
                                textView[j][i].bringToFront();
                                tableRow[j].addView(textView[j][i], i);
                            } else {
                                Toast.makeText(getApplicationContext(), getNName[j] + String.valueOf(i) + "day has problem", Toast.LENGTH_SHORT).show();
                            }
                        } else if (eT[j][i].getText().toString().equals("비")) {
                            if (chkwork[j - 2] > 0) {
                                chkwork[j - 2]--;
                                status[j - 2][2]++;
                                status[j - 2][5]++;
                                textView[j][i].setText("비");
                                textView[j][i].setTextSize(30);
                                tableRow[j].addView(textView[j][i], i);
                            }

                        } else if (eT[j][i].getText().toString().equals("휴")) {
                            if (chkHoli[j - 2] > 0) {
                                chkHoli[j - 2]--;   //잔여 휴일수 확인
                                status[j - 2][3]++;
                                status[j - 2][5]++;
                                textView[j][i].setText("휴");
                                textView[j][i].bringToFront();
                                tableRow[j].addView(textView[j][i], i);
                            } else {
                                Toast.makeText(getApplicationContext(), getNName[j] + String.valueOf(i) + "day has problem", Toast.LENGTH_SHORT).show();
                            }
                        } else if (eT[j][i].getText().toString().equals("연")) {
                            status[j - 2][4]++;
                            status[j - 2][5]++;
                            textView[j][i].setText("연");
                            textView[j][i].bringToFront();
                            tableRow[j].addView(textView[j][i], i);
                        } else if (eT[j][i].getText().toString().isEmpty()) //정해지지 않은경우 직접 프로그램이 정해준다.
                        {


                            if (randTmp == 0)      // 주간인 경우
                            {
                                if (dayNum[i] <= numTmp / 2 && chkwork[j - 2] > 0) {
                                    chkwork[j - 2]--;
                                    dayNum[i]++;
                                    status[j - 2][0]++;
                                    status[j - 2][5]++;
                                    textView[j][i].setText("주");
                                    tableRow[j].removeViewAt(i);
                                    tableRow[j].addView(textView[j][i], i);
                                } else if (chkwork[j - 2] <= 0)//조건에 맞지 않는경우 다른 형태로 바꾸고 다시 설정
                                {
                                    j--;
                                    randTmp = 2;
                                } else {
                                    j--;
                                    randTmp = 1;
                                }


                            } else if (randTmp == 1)      //야간인경우
                            {
                                if (nigNum[i] < numTmp / 2 && chkwork[j - 2] > 1 && eT[j][i + 1].getText().toString().isEmpty()) {
                                    chkwork[j - 2]--;
                                    nigNum[i]++;
                                    status[j - 2][1]++;
                                    status[j - 2][5]++;       //합계도 증가
                                    textView[j][i].setText("야");
                                    tableRow[j].removeViewAt(i);
                                    tableRow[j].addView(textView[j][i], i);
                                    eT[j][i + 1].setText("비");  //야간 이후엔 비번으로 자동변경

                                } else if (chkwork[j - 2] <= 0)//
                                {
                                    j--;
                                    randTmp = 2;
                                } else {
                                    j--;
                                    randTmp = 0;
                                }

                            } else if (randTmp == 2) //휴일인 경우
                            {
                                if (chkHoli[j - 2] > 0) {
                                    chkHoli[j - 2]--;   //잔여 휴일수 확인
                                    status[j - 2][3]++;
                                    status[j - 2][5]++;
                                    textView[j][i].setText("휴");
                                    tableRow[j].removeViewAt(i);
                                    tableRow[j].addView(textView[j][i], i);
                                } else //조건에 맞지 않는경우 다른 형태로 바꾸고 다시 설정
                                {
                                    j--;
                                    randTmp = 0;
                                }

                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Some words has problem", Toast.LENGTH_SHORT).show();
                            // finish();
                        }

                    }
                }

                // 짜여진 일정대로 결과값 수정후 출력

                for (int i = 1; i < res+1; i++) {
                    textView[numTmp + 2][i].setText(String.valueOf(dayNum[i]));
                    tableRow[numTmp + 2].removeViewAt(i);
                    tableRow[numTmp + 2].addView(textView[numTmp + 2][i], i);
                }

                for (int i = 1; i < res+1; i++) {
                    textView[numTmp + 3][i].setText(String.valueOf(nigNum[i]));
                    tableRow[numTmp + 3].removeViewAt(i);
                    tableRow[numTmp + 3].addView(textView[numTmp + 3][i], i);
                }

                for (int j = 2; j < numTmp + 2; j++) {
                    for (int i = res + 1; i < res + 7; i++) {
                        textView[j][i].setText(String.valueOf(status[j - 2][i - 1 - res]));
                        tableRow[j].removeViewAt(i);
                        tableRow[j].addView(textView[j][i], i);
                    }
                }
                btn_move2.setVisibility(View.INVISIBLE);
                btn_move3.setVisibility(View.VISIBLE);
            }
        });


        btn_move3.setOnClickListener(new View.OnClickListener() { // 다시 시간표 시도할때를 위한 버튼 조정
            @Override
            public void onClick(View v) {
                btn_move2.setVisibility(View.VISIBLE);
                tableLayout.removeAllViews();
               finish();
               startActivity(intent);
            }
        });
    }

}



