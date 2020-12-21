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
   // public EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate=(Button) findViewById(R.id.pickDateBtn);

        totalNum=findViewById(R.id.totalNum);
        totalHoliday=findViewById(R.id.totalHoliday);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

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

                String date=month +"/"+ res +"/"+ year;
                Res=Integer.toString(res);
                 //mDisplayDate.setText(date);
                }
            } ;



            btn_move=findViewById(R.id.btn_move);
            btn_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    totalHH=totalHoliday.getText().toString();
                    totalNNum=totalNum.getText().toString();
                    Intent intent =new Intent(MainActivity.this,numberActivity.class);
                    intent.putExtra("totalNNum",totalNNum);
                    intent.putExtra("Res",Res);
                    intent.putExtra("totalHH",totalHH);
                    startActivity(intent);



                }
            });


        }
}


