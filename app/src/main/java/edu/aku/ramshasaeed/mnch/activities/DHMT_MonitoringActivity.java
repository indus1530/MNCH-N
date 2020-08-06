package edu.aku.ramshasaeed.mnch.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.CrudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityDhmtMonitoringBinding;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class DHMT_MonitoringActivity extends AppCompatActivity {
ActivityDhmtMonitoringBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_dhmt_monitoring);
        bi.setCallback(this);
        this.setTitle(getString(R.string.routinethree) + "(" + fc.getReportingMonth() + ")");

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                MainApp.endActivity(this, this, EndingActivity.class, true, RSDInfoActivity.fc);

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

            Long longID = new CrudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.lldhmt);
    }


    private void SaveDraft() throws JSONException {

        JSONObject dhmt = new JSONObject();

        dhmt.put("dh01", bi.dh01a.isChecked() ? "1" : bi.dh01b.isChecked() ? "2" : "0");
        dhmt.put("dh01Ap", bi.dh01Ap.getText().toString().trim().length() > 0 ? bi.dh01Ap.getText().toString() : "0");

        dhmt.put("dh02", bi.dh02a.isChecked() ? "1" : bi.dh02b.isChecked() ? "2" : "0");
        dhmt.put("dh02Ap", bi.dh02Ap.getText().toString().trim().length() > 0 ? bi.dh02Ap.getText().toString() : "0");

        dhmt.put("dh03", bi.dh03a.isChecked() ? "1" : bi.dh03b.isChecked() ? "2" : "0");
        dhmt.put("dh03Ap", bi.dh03Ap.getText().toString().trim().length() > 0 ? bi.dh03Ap.getText().toString() : "0");

        dhmt.put("dh04", bi.dh04a.isChecked() ? "1" : bi.dh04b.isChecked() ? "2" : "0");
        dhmt.put("dh04Ap", bi.dh04Ap.getText().toString().trim().length() > 0 ? bi.dh04Ap.getText().toString() : "0");

        dhmt.put("dh05", bi.dh05a.isChecked() ? "1" : bi.dh05b.isChecked() ? "2" : "0");
        dhmt.put("dh05Ap", bi.dh05Ap.getText().toString().trim().length() > 0 ? bi.dh05Ap.getText().toString() : "0");

        dhmt.put("dh06", bi.dh06a.isChecked() ? "1" : bi.dh06b.isChecked() ? "2" : "0");
        dhmt.put("dh06Ap", bi.dh06Ap.getText().toString().trim().length() > 0 ? bi.dh06Ap.getText().toString() : "0");

        dhmt.put("dh07", bi.dh07a.isChecked() ? "1" : bi.dh07b.isChecked() ? "2" : "0");
        dhmt.put("dh07Ap", bi.dh07Ap.getText().toString().trim().length() > 0 ? bi.dh07Ap.getText().toString() : "0");

        dhmt.put("dhmtSum", bi.dhmtSum.getText().toString().trim().length() > 0 ? bi.dhmtSum.getText().toString() : "0");

        fc.setSA(String.valueOf(dhmt));

    }

}
