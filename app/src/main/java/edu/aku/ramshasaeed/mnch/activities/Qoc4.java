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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc4Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc4 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc4);
        bi.setCallback(this);
        this.setTitle("Quality of Care 04");

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
                startActivity(new Intent(Qoc4.this, Qoc5.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }*/
        }

        finish();
        startActivity(new Intent(Qoc4.this, Qoc5.class));
        
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc4);
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

        if (!bi.qb0115aa.isChecked()){
            bi.qb0115b.clearCheck();
            bi.qb0115c.setEnabled(false);
        } else {
            bi.qb0115c.setEnabled(true);
        }

        if (!bi.qb0116aa.isChecked()){
            bi.qb0116b.clearCheck();
            bi.qb0116c.setEnabled(false);
        } else {
            bi.qb0116c.setEnabled(true);
        }

        if (!bi.qb0117aa.isChecked()){
            bi.qb0117b.clearCheck();
            bi.qb0117c.setEnabled(false);
        } else {
            bi.qb0117c.setEnabled(true);
        }

        if (!bi.qb0118aa.isChecked()){
            bi.qb0118b.clearCheck();
            bi.qb0118c.setEnabled(false);
        } else {
            bi.qb0118c.setEnabled(true);
        }

        if (!bi.qb0119aa.isChecked()){
            bi.qb0119b.clearCheck();
            bi.qb0119c.setEnabled(false);
        } else {
            bi.qb0119c.setEnabled(true);
        }

        if (!bi.qb0120aa.isChecked()){
            bi.qb0120b.clearCheck();
            bi.qb0120c.setEnabled(false);
        } else {
            bi.qb0120c.setEnabled(true);
        }
        
        

        if (!bi.qb0201aa.isChecked()){
            bi.qb0201b.clearCheck();
            bi.qb0201c.setEnabled(false);
        } else {
            bi.qb0201c.setEnabled(true);
        }

        if (!bi.qb0202aa.isChecked()){
            bi.qb0202b.clearCheck();
            bi.qb0202c.setEnabled(false);
        } else {
            bi.qb0202c.setEnabled(true);
        }
        
        if (!bi.qb0203aa.isChecked()){
            bi.qb0203b.clearCheck();
            bi.qb0203c.setEnabled(false);
        } else {
            bi.qb0203c.setEnabled(true);
        }

        if (!bi.qb0204aa.isChecked()){
            bi.qb0204b.clearCheck();
            bi.qb0204c.setEnabled(false);
        } else {
            bi.qb0204c.setEnabled(true);
        }

        if (!bi.qb0205aa.isChecked()){
            bi.qb0205b.clearCheck();
            bi.qb0205c.setEnabled(false);
        } else {
            bi.qb0205c.setEnabled(true);
        }

        if (!bi.qb0206aa.isChecked()){
            bi.qb0206b.clearCheck();
            bi.qb0206c.setEnabled(false);
        } else {
            bi.qb0206c.setEnabled(true);
        }

        if (!bi.qb0207aa.isChecked()){
            bi.qb0207b.clearCheck();
            bi.qb0207c.setEnabled(false);
        } else {
            bi.qb0207c.setEnabled(true);
        }

        if (!bi.qb0208aa.isChecked()){
            bi.qb0208b.clearCheck();
            bi.qb0208c.setEnabled(false);
        } else {
            bi.qb0208c.setEnabled(true);
        }

        if (!bi.qb0209aa.isChecked()){
            bi.qb0209b.clearCheck();
            bi.qb0209c.setEnabled(false);
        } else {
            bi.qb0209c.setEnabled(true);
        }

        if (!bi.qb0210aa.isChecked()){
            bi.qb0210b.clearCheck();
            bi.qb0210c.setEnabled(false);
        } else {
            bi.qb0210c.setEnabled(true);
        }

        if (!bi.qb0211aa.isChecked()){
            bi.qb0211b.clearCheck();
            bi.qb0211c.setEnabled(false);
        } else {
            bi.qb0211c.setEnabled(true);
        }

        if (!bi.qb0212aa.isChecked()){
            bi.qb0212b.clearCheck();
            bi.qb0212c.setEnabled(false);
        } else {
            bi.qb0212c.setEnabled(true);
        }

        if (!bi.qb0213aa.isChecked()){
            bi.qb0213b.clearCheck();
            bi.qb0213c.setEnabled(false);
        } else {
            bi.qb0213c.setEnabled(true);
        }

        
        
        
        if (!bi.qb0301aa.isChecked()){
            bi.qb0301b.clearCheck();
            bi.qb0301c.setEnabled(false);
        } else {
            bi.qb0301c.setEnabled(true);
        }

        if (!bi.qb0302aa.isChecked()){
            bi.qb0302b.clearCheck();
            bi.qb0302c.setEnabled(false);
        } else {
            bi.qb0302c.setEnabled(true);
        }

        if (!bi.qb0303aa.isChecked()){
            bi.qb0303b.clearCheck();
            bi.qb0303c.setEnabled(false);
        } else {
            bi.qb0303c.setEnabled(true);
        }

        if (!bi.qb0304aa.isChecked()){
            bi.qb0304b.clearCheck();
            bi.qb0304c.setEnabled(false);
        } else {
            bi.qb0304c.setEnabled(true);
        }

        if (!bi.qb0305aa.isChecked()){
            bi.qb0305b.clearCheck();
            bi.qb0305c.setEnabled(false);
        } else {
            bi.qb0305c.setEnabled(true);
        }

    }


    void events_call() {

        bi.qb0115a.setOnCheckedChangeListener(this);
        bi.qb0116a.setOnCheckedChangeListener(this);
        bi.qb0117a.setOnCheckedChangeListener(this);
        bi.qb0118a.setOnCheckedChangeListener(this);
        bi.qb0119a.setOnCheckedChangeListener(this);
        bi.qb0120a.setOnCheckedChangeListener(this);

        bi.qb0201a.setOnCheckedChangeListener(this);
        bi.qb0202a.setOnCheckedChangeListener(this);
        bi.qb0203a.setOnCheckedChangeListener(this);
        bi.qb0204a.setOnCheckedChangeListener(this);
        bi.qb0205a.setOnCheckedChangeListener(this);
        bi.qb0206a.setOnCheckedChangeListener(this);
        bi.qb0207a.setOnCheckedChangeListener(this);
        bi.qb0208a.setOnCheckedChangeListener(this);
        bi.qb0209a.setOnCheckedChangeListener(this);
        bi.qb0210a.setOnCheckedChangeListener(this);
        bi.qb0211a.setOnCheckedChangeListener(this);
        bi.qb0212a.setOnCheckedChangeListener(this);
        bi.qb0213a.setOnCheckedChangeListener(this);

        bi.qb0301a.setOnCheckedChangeListener(this);
        bi.qb0302a.setOnCheckedChangeListener(this);
        bi.qb0303a.setOnCheckedChangeListener(this);
        bi.qb0304a.setOnCheckedChangeListener(this);
        bi.qb0305a.setOnCheckedChangeListener(this);

    }
}
