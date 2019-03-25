 package amin.mauneel.project5;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> fin= new ArrayList<String>();
   private ListView o;
   private Button add;
   private Button auto;

    static private int poso;
void setAdapter(String c[]){
    ArrayAdapter obj=new ArrayAdapter(this,android.R.layout.simple_list_item_1,c);
    o.setAdapter(obj);
}


void setListItem(){
    String[] c = new String[fin.size()];

    for (int i=0;i<c.length;i++){
        c[i] = fin.get(i);
    }


   setAdapter(c);
}


void incrementValue(int i){
    String cc= fin.get(i).substring(fin.get(i).lastIndexOf(' ')+1, fin.get(i).length());

    Log.d("","strValue: "+cc);
    int ss=Integer.parseInt(cc);
    ss++;
    String cs=fin.get(i).substring(0,fin.get(i).lastIndexOf(' '));
    cs=cs+" "+ss;
    fin.set(i, cs);

    setListItem();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add= findViewById(R.id.button);
        auto= findViewById(R.id.button2);
        o=findViewById(R.id.list);

        if(fin.size()==0)
        {
            fin.add("New Counter: 0");
        }
        if(getIntent()!=null && getIntent().getExtras()!=null) {
            if (getIntent().getExtras().getString("sok") != null) {
                final String toAdd = (getIntent().getExtras().getString("sok"));
                fin.add(toAdd);

            }
        }


       /* String[] c = new String[fin.size()];

        for (int i=0;i<c.length;i++){
            c[i] = fin.get(i);
        }


        ArrayAdapter obj=new ArrayAdapter(this,android.R.layout.simple_list_item_1,c);
        o.setAdapter(obj);
*/

       setListItem();


        o.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("","pos: " + position);

                poso=position;
                Intent intent = new Intent(MainActivity.this,Complex_Counter.class);
                //intent.putExtra();
                intent.putExtra("pos",position+","+fin.get(poso).substring(fin.get(poso).lastIndexOf(" ")+1,fin.get(poso).length()));
                startActivity(intent);
            }
        });
        if(getIntent()!=null && getIntent().getExtras()!=null) {
            if (getIntent().getExtras().getString("mod") != null) {
                String indexPos = (getIntent().getExtras().getString("mod"));
                Log.d("",indexPos);
                String[] mod_list = indexPos.split(",");
Log.d("POSO", String.valueOf(poso));
                //    fin.set(Integer.parseInt(mod_list[0]),fin.get(Integer.parseInt(mod_list[0])).substring(0,fin.get(Integer.parseInt(mod_list[0])).lastIndexOf(' '))+" "+mod_list[1]);
                fin.set(poso, fin.get(poso).substring(0, fin.get(poso).lastIndexOf(" ")) + " " + mod_list[1]);

            }
            setListItem();
        }

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SET.class);
                startActivity(intent);
            }
        });

       auto.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {

              for(int i=0;i<fin.size();i++)
              {
                  if(fin.get(i) !=null)
                  {

                      incrementValue(i);

                      /*
                      String cc= fin.get(i).substring(fin.get(i).lastIndexOf(' ')+1, fin.get(i).length());

                      Log.d("","strValue: "+cc);
                        int ss=Integer.parseInt(cc);
                        ss++;
                        String cs=fin.get(i).substring(0,fin.get(i).lastIndexOf(' '));
                        cs=cs+" "+ss;
                        fin.set(i, cs);

                        setListItem();
*/
                  }
              }

               Log.d("","");
           }
       });


    }




}