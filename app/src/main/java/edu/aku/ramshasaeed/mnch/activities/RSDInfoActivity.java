package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsdinfoBinding;

public class RSDInfoActivity extends AppCompatActivity {
    ActivityRsdinfoBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsdinfo);
        bi.setCallback(this);

        tempVisible();
    }

    private void tempVisible() {
        bi.fldGrphfDistrict.setVisibility(View.VISIBLE);
        bi.fldGrphfTehsil.setVisibility(View.VISIBLE);
        bi.fldGrphfUen.setVisibility(View.VISIBLE);


      /*  bi.hf_district.setAdapter();
        bi.hf_tehsil.setAdapter();*/
    }


    public void BtnContinue() {
        startActivity(new Intent(RSDInfoActivity.this, RSDActivity.class));
    }

    public void BtnEnd() {

    }

    public void BtnCheck() {

    }
}
