package com.shadow.customradiogroup;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);

        radioGroup1.setOnCheckedChangeListener(this);
        radioGroup2.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.radioGroup1:
                Snackbar.make(findViewById(R.id.layout), "RG 1: " + radioGroup1.getCheckedRadioButtonId(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.radioGroup2:
                Snackbar.make(findViewById(R.id.layout), "RG 2: " + radioGroup2.getCheckedRadioButtonId(), Snackbar.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
