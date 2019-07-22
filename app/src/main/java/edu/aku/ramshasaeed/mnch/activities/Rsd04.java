package edu.aku.ramshasaeed.mnch.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd04Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd04 extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsd04Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd04);
        bi.setCallback(this);
        this.setTitle(getString(R.string.routineone));
        EventsCall();


    }

    void EventsCall() {

        bi.rs2299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs2297.isChecked()) {
                    bi.rs2297.setChecked(false);
                }
                if (b) {
                    bi.rs22.setVisibility(View.GONE);
                    bi.rs22.setText(null);
                } else {
                    bi.rs22.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs2297.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs2299.isChecked()) {
                    bi.rs2299.setChecked(false);
                }
                if (b) {
                    bi.rs22.setVisibility(View.GONE);
                    bi.rs22.setText(null);
                } else {
                    bi.rs22.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();
                MainApp.endActivity(this, this, Rsd05.class, true, RSDInfoActivity.fc);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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

        if (!bi.rs0999.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs09, getString(R.string.rs09))) {
                return false;
            }
        }
        if (!bi.rs1099.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs10, getString(R.string.rs10))) {
                return false;
            }
        }
        if (!bi.rs1199.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs11, getString(R.string.rs11))) {
                return false;
            }
        }
        if (!bi.rs1299.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs12, getString(R.string.rs12))) {
                return false;
            }
        }
        if (!bi.rs1399.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs13, getString(R.string.rs13))) {
                return false;
            }
        }
        if (!bi.rs1499.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs14, getString(R.string.rs14))) {
                return false;
            }
        }
        if (!bi.rs1599.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs15, getString(R.string.rs15))) {
                return false;
            }
        }
        if (!bi.rs1699.isChecked()) {


            if (!validatorClass.EmptyTextBox(this, bi.rs16, getString(R.string.rs16))) {
                return false;
            }
        }
        if (!bi.rs1799.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs17, getString(R.string.rs17))) {
                return false;
            }
        }
        if (!bi.rs1899.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs18, getString(R.string.rs18))) {
                return false;
            }
        }
        if (!bi.rs1999.isChecked()) {


            if (!validatorClass.EmptyTextBox(this, bi.rs19, getString(R.string.rs19))) {
                return false;
            }
        }
        if (!bi.rs2099.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs20, getString(R.string.rs20))) {
                return false;
            }
        }
        if (!bi.rs2199.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs21, getString(R.string.rs21))) {
                return false;
            }
        }
        if (!bi.rs2299.isChecked() && !bi.rs2297.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.rs22, getString(R.string.rs22))) {
                return false;
            }
        }
        if (!bi.rs2399.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs23, getString(R.string.rs23))) {
                return false;
            }
        }
        if (!bi.rs2499.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs24, getString(R.string.rs24))) {
                return false;
            }
        }
        if (!bi.rs2599.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs25, getString(R.string.rs25))) {
                return false;
            }
        }
        if (!bi.rs2699.isChecked()) {


            if (!validatorClass.EmptyTextBox(this, bi.rs26, getString(R.string.rs26))) {
                return false;
            }
        }
        if (!bi.rs2999.isChecked()) {

            return validatorClass.EmptyTextBox(this, bi.rs29, getString(R.string.rs29));
        }

        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs09", bi.rs0999.isChecked() ? "Mi" : bi.rs09.getText().toString());
        f01.put("rs10", bi.rs1099.isChecked() ? "Mi" : bi.rs10.getText().toString());
        f01.put("rs11", bi.rs1199.isChecked() ? "Mi" : bi.rs11.getText().toString());
        f01.put("rs12", bi.rs1299.isChecked() ? "Mi" : bi.rs12.getText().toString());
        f01.put("rs13", bi.rs1399.isChecked() ? "Mi" : bi.rs13.getText().toString());
        f01.put("rs14", bi.rs1499.isChecked() ? "Mi" : bi.rs14.getText().toString());
        f01.put("rs15", bi.rs1599.isChecked() ? "Mi" : bi.rs15.getText().toString());
        f01.put("rs16", bi.rs1699.isChecked() ? "Mi" : bi.rs16.getText().toString());
        f01.put("rs17", bi.rs1799.isChecked() ? "Mi" : bi.rs17.getText().toString());
        f01.put("rs18", bi.rs1899.isChecked() ? "Mi" : bi.rs18.getText().toString());
        f01.put("rs19", bi.rs1999.isChecked() ? "Mi" : bi.rs19.getText().toString());
        f01.put("rs20", bi.rs2099.isChecked() ? "Mi" : bi.rs20.getText().toString());

        f01.put("rs21", bi.rs2199.isChecked() ? "Mi" : bi.rs21.getText().toString());
        f01.put("rs22", bi.rs2299.isChecked() ? "Mi" : bi.rs2297.isChecked() ? "NA" : bi.rs22.getText().toString());
        f01.put("rs23", bi.rs2399.isChecked() ? "Mi" : bi.rs23.getText().toString());
        f01.put("rs24", bi.rs2499.isChecked() ? "Mi" : bi.rs24.getText().toString());
        f01.put("rs25", bi.rs2599.isChecked() ? "Mi" : bi.rs25.getText().toString());
        f01.put("rs26", bi.rs2699.isChecked() ? "Mi" : bi.rs26.getText().toString());
        f01.put("rs29", bi.rs2999.isChecked() ? "Mi" : bi.rs29.getText().toString());

//        f01.put("rsrem", bi.rsrem.getText().toString());

        fc.setSrsd(String.valueOf(f01));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
