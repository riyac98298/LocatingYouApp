package com.example.riyac.locatingyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button button;
    CheckBox checkBox;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=(Button)findViewById(R.id.button);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkBox.isChecked())
                        {
                            i=1;
                        }
                    }
                });
                if (i==1)
                {
                    Intent intent=new Intent(getApplicationContext(), Main3Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please accept the T&C.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
