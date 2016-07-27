package com.basiccalc.ElecDocs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.basiccalc.myapplication.R;


public class MainActivity extends Activity implements View.OnClickListener

{
    private EditText voltage, power, pf;
    private TextView result;
    private Button btn,sbtn;
    private Spinner dynamicSpinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
        Spinner dynamicSpinner1 = (Spinner) findViewById(R.id.dynamic_spinner1);
        String[] items = new String[] { "Item.1", "Item.2", "Item.3" };
        String[] items1 = new String[] { "10", "20", "30" };
        String[][] items2 = new String[] []{ { "10", "20", "30" }, { "100", "200", "300" }, { "110", "220", "330" }};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items1);
        dynamicSpinner.setAdapter(adapter);
        dynamicSpinner1.setAdapter(adapter1);
        //String mn=items2[1][1];
        init();
    }

    private void init(){
        voltage=(EditText)findViewById(R.id.voltage);
        power=(EditText)findViewById(R.id.power);
        pf=(EditText)findViewById(R.id.pf);
        result=(TextView)findViewById(R.id.result);
        //result1=(TextView)findViewById(R.id.result1);
        //result2=(TextView)findViewById(R.id.result2);
        btn=(Button)findViewById(R.id.btn);
        sbtn=(Button)findViewById(R.id.sbtn);
        //dbtn=(Button)findViewById(R.id.dbtn);
       // dbtn1=(Button)findViewById(R.id.dbtn1);
        dynamicSpinner1=(Spinner) findViewById(R.id.dynamic_spinner1);

        btn.setOnClickListener(this);
        sbtn.setOnClickListener(this);
        //dbtn.setOnClickListener(this);
       //dbtn1.setOnClickListener(this);

    }


    public void onClick(View view){

        String v=voltage.getText().toString();
        String p=power.getText().toString();
        String p_f=pf.getText().toString();
        String num1=dynamicSpinner1.getSelectedItem().toString();
        int num2=dynamicSpinner1.getSelectedItemPosition()+1;

        switch(view.getId()){
            case R.id.btn:
                try{
                    double vd=Integer.parseInt(p)/Integer.parseInt(v)/Double.parseDouble(p_f);
                result.setText(String.valueOf(vd));
                 }catch(Exception e){
                    Toast.makeText(getBaseContext(), "Check inputs", Toast.LENGTH_LONG).show();
        }
                break;

            case R.id.sbtn:
                try{
                    double nvd=Integer.parseInt(p)/Integer.parseInt(v)/Double.parseDouble(p_f)*Integer.parseInt(num1);
                    result.setText(String.valueOf(nvd));
                }catch(Exception e){
                    Toast.makeText(getBaseContext(), "Check inputs", Toast.LENGTH_LONG).show();
                }
                break;



            /* case R.id.dbtn:
                result1.setText(String.valueOf(num1));
                break;

            case R.id.dbtn1:
                result2.setText(String.valueOf(num2));
                break;*/

        }

    }
    private void TestUpload(){
        int i=1+1;
    }
}
