package amin.mauneel.project5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Complex_Counter extends AppCompatActivity {

    EditText counter;

    Button count;
    Button done;
    String s1;
    static String s2="0";
    static int INDEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex__counter);

        if(getIntent()!=null && getIntent().getExtras()!=null) {
            if (getIntent().getExtras().getString("pos") != null) {


               String s1= (getIntent().getExtras().getString("pos"));
                String indexPos=s1.substring(0,s1.lastIndexOf(","));
                s2=s1.substring(s1.lastIndexOf(",")+1,s1.length());
               try{ counter.setText(s2);}
               catch (NullPointerException d)
               {}
               Log.d("s2=",s2);
               INDEX =  Integer.parseInt(indexPos);


            }
        }

        counter=findViewById(R.id.editText3);
        counter.setText(s2);
        count=findViewById(R.id.count);
        done=findViewById(R.id.done);

        count.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               int a=Integer.parseInt(String.valueOf(counter.getText()));
                a++;
                counter.setText(String.valueOf(a));

                Log.d("","a: " + a);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Complex_Counter.this,MainActivity.class);
                intent.putExtra("mod",INDEX+","+Integer.parseInt(String.valueOf(counter.getText())));
                startActivity(intent);
            }
        });


    }
}
