package com.example.mode1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView oneText;
    private EditText oneEd;
    private TextView twoText;
    private EditText twoEd;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        oneText = (TextView) findViewById(R.id.one_text);
        oneEd = (EditText) findViewById(R.id.one_ed);
        twoText = (TextView) findViewById(R.id.two_text);
        twoEd = (EditText) findViewById(R.id.two_ed);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
}
