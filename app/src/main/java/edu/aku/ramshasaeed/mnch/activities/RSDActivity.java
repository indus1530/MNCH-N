package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsdBinding;

public class RSDActivity extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsdBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd);
        bi.setCallback(this);

    }


    public void BtnContinue() {

    }
    public void BtnEnd() {

    }

}
