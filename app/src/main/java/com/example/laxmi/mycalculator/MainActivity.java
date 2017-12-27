package com.example.laxmi.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText first;
    EditText second;
    TextView result;
    double num1,num2,res,ang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (EditText)findViewById(R.id.num1);
        second = (EditText)findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.res);

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
        Button sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(this);
        Button mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(this);

        Button sin = (Button)findViewById(R.id.sin);
        sin.setOnClickListener(this);
        Button cos = (Button)findViewById(R.id.cos);
        cos.setOnClickListener(this);
        Button tan = (Button)findViewById(R.id.tan);
        tan.setOnClickListener(this);

        Button sinh = (Button)findViewById(R.id.sinh);
        sinh.setOnClickListener(this);
        Button cosh = (Button)findViewById(R.id.cosh);
        cosh.setOnClickListener(this);
        Button tanh = (Button)findViewById(R.id.tanh);
        tanh.setOnClickListener(this);

        Button sq = (Button)findViewById(R.id.sq);
        sq.setOnClickListener(this);
        Button sqrt = (Button)findViewById(R.id.sqrt);
        sqrt.setOnClickListener(this);
        Button fact = (Button)findViewById(R.id.fact);
        fact.setOnClickListener(this);

        Button ms = (Button)findViewById(R.id.ms);
        ms.setOnClickListener(this);
        Button mr = (Button)findViewById(R.id.mr);
        mr.setOnClickListener(this);
        Button clr = (Button)findViewById(R.id.clr);
        clr.setOnClickListener(this);
        Button mc = (Button)findViewById(R.id.mc);
        mc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        File myFile = new File("/storage/emulated/0/newFile.txt");

        switch (v.getId()){
            case R.id.add:
                num1 = Double.parseDouble(first.getText().toString());
                num2 = Double.parseDouble(second.getText().toString());
                res = num1+num2;
                result.setText(Double.toString(res));
                break;
            case R.id.sub:
                num1 = Double.parseDouble(first.getText().toString());
                num2 = Double.parseDouble(second.getText().toString());
                res = num1-num2;
                result.setText(Double.toString(res));
                break;
            case R.id.mul:
                num1 = Double.parseDouble(first.getText().toString());
                num2 = Double.parseDouble(second.getText().toString());
                res = num1*num2;
                result.setText(Double.toString(res));
                break;



            case R.id.sin:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.sin(ang);
                result.setText(Double.toString(res));
                break;
            case R.id.cos:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.cos(ang);
                result.setText(Double.toString(res));
                break;
            case R.id.tan:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.tan(ang);
                result.setText(Double.toString(res));
                break;


            case R.id.sinh:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.sinh(ang);
                result.setText(Double.toString(res));
                break;
            case R.id.cosh:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.cosh(ang);
                result.setText(Double.toString(res));
                break;
            case R.id.tanh:
                num1 = Double.parseDouble(first.getText().toString());
                ang = Math.toRadians(num1);
                res = Math.tanh(ang);
                result.setText(Double.toString(res));
                break;


            case R.id.sq:
                num1 = Double.parseDouble(first.getText().toString());
                res = num1*num1;
                result.setText(Double.toString(res));
                break;
            case R.id.sqrt:
                num1 = Double.parseDouble(first.getText().toString());
                res = Math.sqrt(num1);
                result.setText(Double.toString(res));
                break;
            case R.id.fact:
                num1 = Double.parseDouble(first.getText().toString());
                double i,number,fact = 1;
                number = num1;
                for (i=1;i<number;i++){
                    fact = fact*i;
                }
                res = fact;
                result.setText(Double.toString(res));
                break;



            case R.id.ms:
                if (myFile.exists()){
                    try{
                        FileOutputStream fOut = new FileOutputStream(myFile,true);
                        OutputStreamWriter myWriter = new OutputStreamWriter(fOut);
                        myWriter.append(result.getText());
                        myWriter.append("\n");
                        myWriter.close();
                        fOut.close();
                        Toast.makeText(getBaseContext(),"Writing results to file",Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }else{
                    try{
                        myFile.createNewFile();
                    }catch (Exception e){
                        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.mr:
                try{
                    FileInputStream fIs = new FileInputStream(myFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fIs));

                    String aDataRow = "";
                    String aBuffer = "";
                    while ((aDataRow = br.readLine()) != null){
                        aBuffer += aDataRow + "\n";
                    }
                    result.setText(aBuffer);
                    fIs.close();
                    Toast.makeText(getBaseContext(),"Reading results from file",Toast.LENGTH_SHORT).show();


                }catch (Exception e){
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.clr:
                first.setText(" ");
                second.setText(" ");
                result.setText(" ");
                break;
            case R.id.mc:
                myFile.delete();
                break;

        }
    }
}
