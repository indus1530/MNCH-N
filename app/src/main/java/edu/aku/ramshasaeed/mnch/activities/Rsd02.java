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
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd02Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd02 extends AppCompatActivity {
    ActivityRsd02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd02);
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
        return Validator.emptyCheckingContainer(this, bi.llrsd02);
    }

    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs02_formdate", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        f01.put("rs07", bi.rs0799.isChecked() ? "Mi" : bi.rs07.getText().toString());
        f01.put("rs08", bi.rs0899.isChecked() ? "Mi" : bi.rs08.getText().toString());

        fc.setSB(String.valueOf(f01));

    }

}
