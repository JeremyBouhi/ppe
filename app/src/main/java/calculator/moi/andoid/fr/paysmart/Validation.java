package calculator.moi.andoid.fr.paysmart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jerem on 14/04/2018.
 */

public class Validation extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button toutEffacer;
    Button effacer;
    EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.validation);

        button0 = (Button) findViewById(R.id.zero);
        button1 = (Button) findViewById(R.id.un);
        button2 = (Button) findViewById(R.id.deux);
        button3 = (Button) findViewById(R.id.trois);
        button4 = (Button) findViewById(R.id.quatre);
        button5 = (Button) findViewById(R.id.cinq);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.sept);
        button8 = (Button) findViewById(R.id.huit);
        button9 = (Button) findViewById(R.id.neuf);
        toutEffacer = (Button) findViewById(R.id.toutEffacer);
        effacer = (Button) findViewById(R.id.effacer);
        code = (EditText) findViewById(R.id.editTextCode);


        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(check())
                {
                    chiffreClick("0");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check())
                    chiffreClick("9");
            }
        });

        toutEffacer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    resetClick();
            }
        });

        effacer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteClick();
            }
        });

    }

    public void chiffreClick(String str) {

            if(!code.getText().equals("0"))
                str = code.getText() + str;

        code.setText(str);
    }

    public void resetClick(){
        code.setText("");
    }

    public void deleteClick(){

        if(!code.getText().equals("0"))
        {
            String text = code.getText().toString();
            code.setText(text.substring(0, text.length() - 1));
        }
    }

    public boolean check(){
        if(code.length()<=3)
        {
            return true;
        }
        return false;
    }

}