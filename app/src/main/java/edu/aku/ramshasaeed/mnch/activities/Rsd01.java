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
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd01Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd01 extends AppCompatActivity {
    ActivityRsd01Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd01);
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
        return Validator.emptyCheckingContainer(this, bi.llrsd01);
    }


    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs01_formdate", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        f01.put("rs01", bi.rs0199.isChecked() ? "Mi" : bi.rs01.getText().toString());
        f01.put("rs02", bi.rs0299.isChecked() ? "Mi" : bi.rs02.getText().toString());
        f01.put("rs03", bi.rs0399.isChecked() ? "Mi" : bi.rs03.getText().toString());
        f01.put("rs04", bi.rs0499.isChecked() ? "Mi" : bi.rs04.getText().toString());
        f01.put("rs05", bi.rs0599.isChecked() ? "Mi" : bi.rs05.getText().toString());

        fc.setSA(String.valueOf(f01));

    }

}
