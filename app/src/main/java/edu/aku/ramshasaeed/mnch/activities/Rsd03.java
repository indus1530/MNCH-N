package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.CrudOperations;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd03Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd03 extends AppCompatActivity {
    ActivityRsd03Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd03);
        bi.setCallback(this);
        this.setTitle(getString(R.string.routineone) + "(" + fc.getReportingMonth() + ")");


    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, RsdMain.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

    }

    private boolean UpdateDB() {

        try {

            Long longID = new CrudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.llrsd03);
    }

    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs03_formdate", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
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
        f01.put("rs41", bi.rs4199.isChecked() ? "Mi" : bi.rs41.getText().toString());
        f01.put("rs21", bi.rs2199.isChecked() ? "Mi" : bi.rs21.getText().toString());
        f01.put("rs22", bi.rs2299.isChecked() ? "Mi" : bi.rs22.getText().toString());
        f01.put("rs23", bi.rs2399.isChecked() ? "Mi" : bi.rs23.getText().toString());
        f01.put("rs24", bi.rs2499.isChecked() ? "Mi" : bi.rs24.getText().toString());
        f01.put("rs25", bi.rs2599.isChecked() ? "Mi" : bi.rs25.getText().toString());
        f01.put("rs26", bi.rs2699.isChecked() ? "Mi" : bi.rs26.getText().toString());
        f01.put("rs29", bi.rs2999.isChecked() ? "Mi" : bi.rs29.getText().toString());
        f01.put("rs42", bi.rs4299.isChecked() ? "Mi" : bi.rs42.getText().toString());

        fc.setSC(String.valueOf(f01));

    }

}
