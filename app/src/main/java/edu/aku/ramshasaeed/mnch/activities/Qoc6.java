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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc6Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc6 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc6);
        bi.setCallback(this);
        this.setTitle("Quality of Care 06");

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
                startActivity(new Intent(Qoc6.this, Qoc7.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }*/
        }

        finish();
        startActivity(new Intent(Qoc6.this, Qoc7.class));

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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc6);
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
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qb0408aa.isChecked()){
            bi.qb0408b.clearCheck();
            bi.qb0408c.setEnabled(false);
        } else {
            bi.qb0408c.setEnabled(true);
        }

        if (!bi.qb0409aa.isChecked()){
            bi.qb0409b.clearCheck();
            bi.qb0409c.setEnabled(false);
        } else {
            bi.qb0409c.setEnabled(true);
        }

        if (!bi.qb0410aa.isChecked()){
            bi.qb0410b.clearCheck();
            bi.qb0410c.setEnabled(false);
        } else {
            bi.qb0410c.setEnabled(true);
        }

        if (!bi.qb0411aa.isChecked()){
            bi.qb0411b.clearCheck();
            bi.qb0411c.setEnabled(false);
        } else {
            bi.qb0411c.setEnabled(true);
        }

        if (!bi.qb0412aa.isChecked()){
            bi.qb0412b.clearCheck();
            bi.qb0412c.setEnabled(false);
        } else {
            bi.qb0412c.setEnabled(true);
        }

        if (!bi.qb0413aa.isChecked()){
            bi.qb0413b.clearCheck();
            bi.qb0413c.setEnabled(false);
        } else {
            bi.qb0413c.setEnabled(true);
        }

    }


    void events_call() {
        
        bi.qb0408a.setOnCheckedChangeListener(this);
        bi.qb0409a.setOnCheckedChangeListener(this);
        bi.qb0410a.setOnCheckedChangeListener(this);
        bi.qb0411a.setOnCheckedChangeListener(this);
        bi.qb0412a.setOnCheckedChangeListener(this);
        bi.qb0413a.setOnCheckedChangeListener(this);
    }
}
