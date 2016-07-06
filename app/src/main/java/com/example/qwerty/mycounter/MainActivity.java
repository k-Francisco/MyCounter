package com.example.qwerty.mycounter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String tag = "counterClicked";
    private Button mAddCounter, mClearCounter;
    private TextView mCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mAddCounter = (Button)findViewById(R.id.btnAdd);
        mClearCounter = (Button)findViewById(R.id.btnClear);
        mCounter = (TextView)findViewById(R.id.tvCounter);
        mAddCounter.setOnClickListener(this);
        mClearCounter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAdd:
                    Log.d(tag, "counter added by 1");
                    mCounter.setText(String.valueOf((Integer.parseInt(mCounter.getText().toString())+1)));
                    Toast.makeText(this, "Counter value increased", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.btnClear:
                new AlertDialog.Builder(this)
                        .setTitle("Confirm Action")
                        .setMessage("Do you really want to reset the counter to 0?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                reset();
                            }})
                        .setNegativeButton("No", null)
                        .setCancelable(false)
                        .show();
                    break;

        }
    }

    public void reset(){
        Log.d(tag, "Counter is set to 0");
        mCounter.setText("0");
        Toast.makeText(this, "Counter was reset to 0", Toast.LENGTH_SHORT).show();
    }
}
