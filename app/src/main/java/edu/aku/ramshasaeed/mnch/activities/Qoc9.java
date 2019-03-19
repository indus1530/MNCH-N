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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc9Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc9 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc9);
        bi.setCallback(this);
        this.setTitle("Quality of Care 09");
        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc9);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc9 = new JSONObject();

        qoc9.put("qc2101a", bi.qc2101aa.isChecked() ? "1" : bi.qc2101ab.isChecked() ? "2" : "0");
        qoc9.put("qc2101b", bi.qc2101ba.isChecked() ? "1" : bi.qc2101bb.isChecked() ? "2" : bi.qc2101bc.isChecked() ? "3" : "0");
        qoc9.put("qc2101c", bi.qc2101c.getText().toString().trim().length() > 0 ? bi.qc2101c.getText().toString() : "0");
        qoc9.put("qc2101d", bi.qc2101d.getText().toString().trim().length() > 0 ? bi.qc2101d.getText().toString() : "0");

        qoc9.put("qc2102a", bi.qc2102aa.isChecked() ? "1" : bi.qc2102ab.isChecked() ? "2" : "0");
        qoc9.put("qc2102b", bi.qc2102ba.isChecked() ? "1" : bi.qc2102bb.isChecked() ? "2" : bi.qc2102bc.isChecked() ? "3" : "0");
        qoc9.put("qc2102c", bi.qc2102c.getText().toString().trim().length() > 0 ? bi.qc2102c.getText().toString() : "0");
        qoc9.put("qc2102d", bi.qc2102d.getText().toString().trim().length() > 0 ? bi.qc2102d.getText().toString() : "0");

        qoc9.put("qc2103a", bi.qc2103aa.isChecked() ? "1" : bi.qc2103ab.isChecked() ? "2" : "0");
        qoc9.put("qc2103b", bi.qc2103ba.isChecked() ? "1" : bi.qc2103bb.isChecked() ? "2" : bi.qc2103bc.isChecked() ? "3" : "0");
        qoc9.put("qc2103c", bi.qc2103c.getText().toString().trim().length() > 0 ? bi.qc2103c.getText().toString() : "0");
        qoc9.put("qc2103d", bi.qc2103d.getText().toString().trim().length() > 0 ? bi.qc2103d.getText().toString() : "0");

        qoc9.put("qc2104a", bi.qc2104aa.isChecked() ? "1" : bi.qc2104ab.isChecked() ? "2" : "0");
        qoc9.put("qc2104b", bi.qc2104ba.isChecked() ? "1" : bi.qc2104bb.isChecked() ? "2" : bi.qc2104bc.isChecked() ? "3" : "0");
        qoc9.put("qc2104c", bi.qc2104c.getText().toString().trim().length() > 0 ? bi.qc2104c.getText().toString() : "0");
        qoc9.put("qc2104d", bi.qc2104d.getText().toString().trim().length() > 0 ? bi.qc2104d.getText().toString() : "0");

        qoc9.put("qc2105a", bi.qc2105aa.isChecked() ? "1" : bi.qc2105ab.isChecked() ? "2" : "0");
        qoc9.put("qc2105b", bi.qc2105ba.isChecked() ? "1" : bi.qc2105bb.isChecked() ? "2" : bi.qc2105bc.isChecked() ? "3" : "0");
        qoc9.put("qc2105c", bi.qc2105c.getText().toString().trim().length() > 0 ? bi.qc2105c.getText().toString() : "0");
        qoc9.put("qc2105d", bi.qc2105d.getText().toString().trim().length() > 0 ? bi.qc2105d.getText().toString() : "0");

        qoc9.put("qc2106a", bi.qc2106aa.isChecked() ? "1" : bi.qc2106ab.isChecked() ? "2" : "0");
        qoc9.put("qc2106b", bi.qc2106ba.isChecked() ? "1" : bi.qc2106bb.isChecked() ? "2" : bi.qc2106bc.isChecked() ? "3" : "0");
        qoc9.put("qc2106c", bi.qc2106c.getText().toString().trim().length() > 0 ? bi.qc2106c.getText().toString() : "0");
        qoc9.put("qc2106d", bi.qc2106d.getText().toString().trim().length() > 0 ? bi.qc2106d.getText().toString() : "0");


        qoc9.put("qc2201a", bi.qc2201aa.isChecked() ? "1" : bi.qc2201ab.isChecked() ? "2" : "0");
        qoc9.put("qc2201b", bi.qc2201ba.isChecked() ? "1" : bi.qc2201bb.isChecked() ? "2" : bi.qc2201bc.isChecked() ? "3" : "0");
        qoc9.put("qc2201c", bi.qc2201c.getText().toString().trim().length() > 0 ? bi.qc2201c.getText().toString() : "0");
        qoc9.put("qc2201d", bi.qc2201d.getText().toString().trim().length() > 0 ? bi.qc2201d.getText().toString() : "0");


        qoc9.put("qc2301a", bi.qc2301aa.isChecked() ? "1" : bi.qc2301ab.isChecked() ? "2" : "0");
        qoc9.put("qc2301b", bi.qc2301ba.isChecked() ? "1" : bi.qc2301bb.isChecked() ? "2" : bi.qc2301bc.isChecked() ? "3" : "0");
        qoc9.put("qc2301c", bi.qc2301c.getText().toString().trim().length() > 0 ? bi.qc2301c.getText().toString() : "0");
        qoc9.put("qc2301d", bi.qc2301d.getText().toString().trim().length() > 0 ? bi.qc2301d.getText().toString() : "0");


        fc.setSqoc9(String.valueOf(qoc9));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qc2101aa.isChecked()){
            bi.qc2101b.clearCheck();
            bi.qc2101c.setEnabled(true);
        } else {
            bi.qc2101c.setEnabled(false);
        }

        if (!bi.qc2102aa.isChecked()){
            bi.qc2102b.clearCheck();
            bi.qc2102c.setEnabled(true);
        } else {
            bi.qc2102c.setEnabled(false);
        }

        if (!bi.qc2103aa.isChecked()){
            bi.qc2103b.clearCheck();
            bi.qc2103c.setEnabled(true);
        } else {
            bi.qc2103c.setEnabled(false);
        }

        if (!bi.qc2104aa.isChecked()){
            bi.qc2104b.clearCheck();
            bi.qc2104c.setEnabled(true);
        } else {
            bi.qc2104c.setEnabled(false);
        }

        if (!bi.qc2105aa.isChecked()){
            bi.qc2105b.clearCheck();
            bi.qc2105c.setEnabled(true);
        } else {
            bi.qc2105c.setEnabled(false);
        }

        if (!bi.qc2106aa.isChecked()){
            bi.qc2106b.clearCheck();
            bi.qc2106c.setEnabled(true);
        } else {
            bi.qc2106c.setEnabled(false);
        }


        if (!bi.qc2201aa.isChecked()){
            bi.qc2201b.clearCheck();
            bi.qc2201c.setEnabled(true);
        } else {
            bi.qc2201c.setEnabled(false);
        }


        if (!bi.qc2301aa.isChecked()){
            bi.qc2301b.clearCheck();
            bi.qc2301c.setEnabled(true);
        } else {
            bi.qc2301c.setEnabled(false);
        }

    }

    void events_call() {

        bi.qc2101a.setOnCheckedChangeListener(this);
        bi.qc2102a.setOnCheckedChangeListener(this);
        bi.qc2103a.setOnCheckedChangeListener(this);
        bi.qc2104a.setOnCheckedChangeListener(this);
        bi.qc2105a.setOnCheckedChangeListener(this);
        bi.qc2106a.setOnCheckedChangeListener(this);

        bi.qc2201a.setOnCheckedChangeListener(this);

        bi.qc2301a.setOnCheckedChangeListener(this);

    }
}
