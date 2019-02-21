package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc2Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc2);
        bi.setCallback(this);
        this.setTitle("Quality of Care 02");

        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            /*if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();
                startActivity(new Intent(Qoc2.this, Qoc3.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }*/


        }

        finish();
        startActivity(new Intent(Qoc2.this, Qoc3.class));

    }


    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);

    }


    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }


    public boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc2);
    }

    private void SaveDraft() throws JSONException {

        /*JSONObject f01 = new JSONObject();
        f01.put("rs01", bi.rs0199.isChecked() ? "99" : bi.rs01.getText().toString());
        f01.put("rs02", bi.rs0299.isChecked() ? "99" : bi.rs02.getText().toString());

        f01.put("rs21", bi.rs2199.isChecked() ? "99" : bi.rs21.getText().toString());
        f01.put("rs22", bi.rs2299.isChecked() ? "99" : bi.rs22.getText().toString());

        f01.put("rsrem", bi.rsrem.getText().toString());

        fc.setSrsd(String.valueOf(f01));*/

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qa0601aa.isChecked()){
            bi.qa0601b.clearCheck();
            bi.qa0601c.setEnabled(false);
        } else {
            bi.qa0601c.setEnabled(true);
        }

        if (!bi.qa0602aa.isChecked()){
            bi.qa0602b.clearCheck();
            bi.qa0602c.setEnabled(false);
        } else {
            bi.qa0602c.setEnabled(true);
        }

        if (!bi.qa0603aa.isChecked()){
            bi.qa0603b.clearCheck();
            bi.qa0603c.setEnabled(false);
        } else {
            bi.qa0603c.setEnabled(true);
        }

        if (!bi.qa0604aa.isChecked()){
            bi.qa0604b.clearCheck();
            bi.qa0604c.setEnabled(false);
        } else {
            bi.qa0604c.setEnabled(true);
        }

        if (!bi.qa0605aa.isChecked()){
            bi.qa0605b.clearCheck();
            bi.qa0605c.setEnabled(false);
        } else {
            bi.qa0605c.setEnabled(true);
        }

        if (!bi.qa0606aa.isChecked()){
            bi.qa0606b.clearCheck();
            bi.qa0606c.setEnabled(false);
        } else {
            bi.qa0606c.setEnabled(true);
        }

        if (!bi.qa0607aa.isChecked()){
            bi.qa0607b.clearCheck();
            bi.qa0607c.setEnabled(false);
        } else {
            bi.qa0607c.setEnabled(true);
        }

        if (!bi.qa0608aa.isChecked()){
            bi.qa0608b.clearCheck();
            bi.qa0608c.setEnabled(false);
        } else {
            bi.qa0608c.setEnabled(true);
        }



        if (!bi.qa0701aa.isChecked()){
            bi.qa0701b.clearCheck();
            bi.qa0701c.setEnabled(false);
        } else {
            bi.qa0701c.setEnabled(true);
        }

        if (!bi.qa0702aa.isChecked()){
            bi.qa0702b.clearCheck();
            bi.qa0702c.setEnabled(false);
        } else {
            bi.qa0702c.setEnabled(true);
        }

        if (!bi.qa0703aa.isChecked()){
            bi.qa0703b.clearCheck();
            bi.qa0703c.setEnabled(false);
        } else {
            bi.qa0703c.setEnabled(true);
        }

        if (!bi.qa0704aa.isChecked()){
            bi.qa0704b.clearCheck();
            bi.qa0704c.setEnabled(false);
        } else {
            bi.qa0704c.setEnabled(true);
        }

        if (!bi.qa0705aa.isChecked()){
            bi.qa0705b.clearCheck();
            bi.qa0705c.setEnabled(false);
        } else {
            bi.qa0705c.setEnabled(true);
        }

        if (!bi.qa0706aa.isChecked()){
            bi.qa0706b.clearCheck();
            bi.qa0706c.setEnabled(false);
        } else {
            bi.qa0706c.setEnabled(true);
        }

        if (!bi.qa0707aa.isChecked()){
            bi.qa0707b.clearCheck();
            bi.qa0707c.setEnabled(false);
        } else {
            bi.qa0707c.setEnabled(true);
        }

        if (!bi.qa0708aa.isChecked()){
            bi.qa0708b.clearCheck();
            bi.qa0708c.setEnabled(false);
        } else {
            bi.qa0708c.setEnabled(true);
        }

        if (!bi.qa0709aa.isChecked()){
            bi.qa0709b.clearCheck();
            bi.qa0709c.setEnabled(false);
        } else {
            bi.qa0709c.setEnabled(true);
        }

        if (!bi.qa0710aa.isChecked()){
            bi.qa0710b.clearCheck();
            bi.qa0710c.setEnabled(false);
        } else {
            bi.qa0710c.setEnabled(true);
        }

        if (!bi.qa0711aa.isChecked()){
            bi.qa0711b.clearCheck();
            bi.qa0711c.setEnabled(false);
        } else {
            bi.qa0711c.setEnabled(true);
        }

        if (!bi.qa0712aa.isChecked()){
            bi.qa0712b.clearCheck();
            bi.qa0712c.setEnabled(false);
        } else {
            bi.qa0712c.setEnabled(true);
        }

        if (!bi.qa0713aa.isChecked()){
            bi.qa0713b.clearCheck();
            bi.qa0713c.setEnabled(false);
        } else {
            bi.qa0713c.setEnabled(true);
        }

        if (!bi.qa0714aa.isChecked()){
            bi.qa0714b.clearCheck();
            bi.qa0714c.setEnabled(false);
        } else {
            bi.qa0714c.setEnabled(true);
        }

        if (!bi.qa0715aa.isChecked()){
            bi.qa0715b.clearCheck();
            bi.qa0715c.setEnabled(false);
        } else {
            bi.qa0715c.setEnabled(true);
        }
        
        if (!bi.qa0716aa.isChecked()){
            bi.qa0716b.clearCheck();
            bi.qa0716c.setEnabled(false);
        } else {
            bi.qa0716c.setEnabled(true);
        }
        
    }


    void events_call() {

        bi.qa0601a.setOnCheckedChangeListener(this);
        bi.qa0602a.setOnCheckedChangeListener(this);
        bi.qa0603a.setOnCheckedChangeListener(this);
        bi.qa0604a.setOnCheckedChangeListener(this);
        bi.qa0605a.setOnCheckedChangeListener(this);
        bi.qa0606a.setOnCheckedChangeListener(this);
        bi.qa0607a.setOnCheckedChangeListener(this);
        bi.qa0608a.setOnCheckedChangeListener(this);


        bi.qa0701a.setOnCheckedChangeListener(this);
        bi.qa0702a.setOnCheckedChangeListener(this);
        bi.qa0703a.setOnCheckedChangeListener(this);
        bi.qa0704a.setOnCheckedChangeListener(this);
        bi.qa0705a.setOnCheckedChangeListener(this);
        bi.qa0706a.setOnCheckedChangeListener(this);
        bi.qa0707a.setOnCheckedChangeListener(this);
        bi.qa0708a.setOnCheckedChangeListener(this);
        bi.qa0709a.setOnCheckedChangeListener(this);
        bi.qa0710a.setOnCheckedChangeListener(this);
        bi.qa0711a.setOnCheckedChangeListener(this);
        bi.qa0712a.setOnCheckedChangeListener(this);
        bi.qa0713a.setOnCheckedChangeListener(this);
        bi.qa0714a.setOnCheckedChangeListener(this);
        bi.qa0715a.setOnCheckedChangeListener(this);
        bi.qa0716a.setOnCheckedChangeListener(this);

    }
}
