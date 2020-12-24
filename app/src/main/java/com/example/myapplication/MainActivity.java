package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    public Button mDisplayDate;
    public Button btn_move;
    public EditText totalNum;
    public EditText totalHoliday;
    private String totalNNum;
    private String totalHH;
    public String Res;
    public String dayOf1;
    public  int chk=0;
   // public EditText
   public static boolean isNumeric(String s) {
       try {
           Double.parseDouble(s);
           return true;
       } catch(NumberFormatException e) {
           return false;
       }
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate=(Button) findViewById(R.id.pickDateBtn);

        totalNum=findViewById(R.id.totalNum);
        totalHoliday=findViewById(R.id.totalHoliday);


        mDisplayDate.setOnClickListener(new View.OnClickListener() { //날짜 받아오는 부분
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                chk=year;
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG,"onDateSet: date"+year+"/"+ month +"/"+dayOfMonth);

                Calendar cal1=Calendar.getInstance();
                cal1.set(Calendar.YEAR,year);
                cal1.set(Calendar.MONTH,month);

                int res=cal1.getActualMaximum(Calendar.DATE);
                Res=Integer.toString(res);

                int Tmp = dayOfMonth%7;
                int dateTmp=cal1.get(Calendar.DAY_OF_WEEK);
                int real1date=dateTmp-(Tmp-1);
                dayOf1=String.valueOf(real1date);
                // mDisplayDate.setText(String.valueOf(real1date));
                }
            } ;




        btn_move=findViewById(R.id.btn_move);
            btn_move.setOnClickListener(new View.OnClickListener() {  //입력된 데이터 넘기기
                @Override
                public void onClick(View v) {

                    totalHH=totalHoliday.getText().toString();
                    totalNNum=totalNum.getText().toString();

                    if(isNumeric(totalHH)&&isNumeric(totalNNum)&&chk!=0)
                    {
                        Intent intent =new Intent(MainActivity.this,numberActivity.class);
                        intent.putExtra("totalNNum",totalNNum);
                        intent.putExtra("Res",Res);
                        intent.putExtra("totalHH",totalHH);
                        intent.putExtra("dayOf1",dayOf1);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Some words has problem or select date",Toast.LENGTH_SHORT).show();
                    } //문제 발생시 오류 알림
                }
            });


        }
}


