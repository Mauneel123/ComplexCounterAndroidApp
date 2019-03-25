package amin.mauneel.project5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SET extends AppCompatActivity {

    EditText name;
    Button set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        name=findViewById(R.id.editText);
        set=findViewById(R.id.button5);


        set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                final String s = name.getText().toString()+": 0";
                Intent intent = new Intent(SET.this,MainActivity.class);
                intent.putExtra("sok",s).getStringExtra(s);
                startActivity(intent);
            }
        });
    }







}
