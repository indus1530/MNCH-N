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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc5Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc5 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc5);
        bi.setCallback(this);
        this.setTitle("Quality of Care 05");

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
                startActivity(new Intent(Qoc5.this, Qoc6.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }*/
        }

        finish();
        startActivity(new Intent(Qoc5.this, Qoc6.class));

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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc5);
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

        if (!bi.qb0306aa.isChecked()){
            bi.qb0306b.clearCheck();
            bi.qb0306c.setEnabled(false);
        } else {
            bi.qb0306c.setEnabled(true);
        }

        if (!bi.qb0307aa.isChecked()){
            bi.qb0307b.clearCheck();
            bi.qb0307c.setEnabled(false);
        } else {
            bi.qb0307c.setEnabled(true);
        }

        if (!bi.qb0308aa.isChecked()){
            bi.qb0308b.clearCheck();
            bi.qb0308c.setEnabled(false);
        } else {
            bi.qb0308c.setEnabled(true);
        }

        if (!bi.qb0309aa.isChecked()){
            bi.qb0309b.clearCheck();
            bi.qb0309c.setEnabled(false);
        } else {
            bi.qb0309c.setEnabled(true);
        }

        if (!bi.qb0310aa.isChecked()){
            bi.qb0310b.clearCheck();
            bi.qb0310c.setEnabled(false);
        } else {
            bi.qb0310c.setEnabled(true);
        }

        
        if (!bi.qb0311aa.isChecked()){
            bi.qb0311b.clearCheck();
            bi.qb0311c.setEnabled(false);
        } else {
            bi.qb0311c.setEnabled(true);
        }


        if (!bi.qb0312aa.isChecked()){
            bi.qb0312b.clearCheck();
            bi.qb0312c.setEnabled(false);
        } else {
            bi.qb0312c.setEnabled(true);
        }

        if (!bi.qb0313aa.isChecked()){
            bi.qb0313b.clearCheck();
            bi.qb0313c.setEnabled(false);
        } else {
            bi.qb0313c.setEnabled(true);
        }

        if (!bi.qb0314aa.isChecked()){
            bi.qb0314b.clearCheck();
            bi.qb0314c.setEnabled(false);
        } else {
            bi.qb0314c.setEnabled(true);
        }

        if (!bi.qb0315aa.isChecked()){
            bi.qb0315b.clearCheck();
            bi.qb0315c.setEnabled(false);
        } else {
            bi.qb0315c.setEnabled(true);
        }

        if (!bi.qb0316aa.isChecked()){
            bi.qb0316b.clearCheck();
            bi.qb0316c.setEnabled(false);
        } else {
            bi.qb0316c.setEnabled(true);
        }

        if (!bi.qb0317aa.isChecked()){
            bi.qb0317b.clearCheck();
            bi.qb0317c.setEnabled(false);
        } else {
            bi.qb0317c.setEnabled(true);
        }

        if (!bi.qb0318aa.isChecked()){
            bi.qb0318b.clearCheck();
            bi.qb0318c.setEnabled(false);
        } else {
            bi.qb0318c.setEnabled(true);
        }

        if (!bi.qb0319aa.isChecked()){
            bi.qb0319b.clearCheck();
            bi.qb0319c.setEnabled(false);
        } else {
            bi.qb0319c.setEnabled(true);
        }

        if (!bi.qb0320aa.isChecked()){
            bi.qb0320b.clearCheck();
            bi.qb0320c.setEnabled(false);
        } else {
            bi.qb0320c.setEnabled(true);
        }

        if (!bi.qb0321aa.isChecked()){
            bi.qb0321b.clearCheck();
            bi.qb0321c.setEnabled(false);
        } else {
            bi.qb0321c.setEnabled(true);
        }

        if (!bi.qb0322aa.isChecked()){
            bi.qb0322b.clearCheck();
            bi.qb0322c.setEnabled(false);
        } else {
            bi.qb0322c.setEnabled(true);
        }
        
        

        if (!bi.qb0401aa.isChecked()){
            bi.qb0401b.clearCheck();
            bi.qb0401c.setEnabled(false);
        } else {
            bi.qb0401c.setEnabled(true);
        }

        if (!bi.qb0402aa.isChecked()){
            bi.qb0402b.clearCheck();
            bi.qb0402c.setEnabled(false);
        } else {
            bi.qb0402c.setEnabled(true);
        }

        if (!bi.qb0403aa.isChecked()){
            bi.qb0403b.clearCheck();
            bi.qb0403c.setEnabled(false);
        } else {
            bi.qb0403c.setEnabled(true);
        }

        if (!bi.qb0404aa.isChecked()){
            bi.qb0404b.clearCheck();
            bi.qb0404c.setEnabled(false);
        } else {
            bi.qb0404c.setEnabled(true);
        }

        if (!bi.qb0405aa.isChecked()){
            bi.qb0405b.clearCheck();
            bi.qb0405c.setEnabled(false);
        } else {
            bi.qb0405c.setEnabled(true);
        }

        if (!bi.qb0406aa.isChecked()){
            bi.qb0406b.clearCheck();
            bi.qb0406c.setEnabled(false);
        } else {
            bi.qb0406c.setEnabled(true);
        }

        if (!bi.qb0407aa.isChecked()){
            bi.qb0407b.clearCheck();
            bi.qb0407c.setEnabled(false);
        } else {
            bi.qb0407c.setEnabled(true);
        }

    }


    void events_call() {

        bi.qb0306a.setOnCheckedChangeListener(this);
        bi.qb0307a.setOnCheckedChangeListener(this);
        bi.qb0308a.setOnCheckedChangeListener(this);
        bi.qb0309a.setOnCheckedChangeListener(this);
        bi.qb0310a.setOnCheckedChangeListener(this);
        bi.qb0311a.setOnCheckedChangeListener(this);
        bi.qb0312a.setOnCheckedChangeListener(this);
        bi.qb0313a.setOnCheckedChangeListener(this);
        bi.qb0314a.setOnCheckedChangeListener(this);
        bi.qb0315a.setOnCheckedChangeListener(this);
        bi.qb0316a.setOnCheckedChangeListener(this);
        bi.qb0317a.setOnCheckedChangeListener(this);
        bi.qb0318a.setOnCheckedChangeListener(this);
        bi.qb0319a.setOnCheckedChangeListener(this);
        bi.qb0320a.setOnCheckedChangeListener(this);
        bi.qb0321a.setOnCheckedChangeListener(this);
        bi.qb0322a.setOnCheckedChangeListener(this);

        bi.qb0401a.setOnCheckedChangeListener(this);
        bi.qb0402a.setOnCheckedChangeListener(this);
        bi.qb0403a.setOnCheckedChangeListener(this);
        bi.qb0404a.setOnCheckedChangeListener(this);
        bi.qb0405a.setOnCheckedChangeListener(this);
        bi.qb0406a.setOnCheckedChangeListener(this);
        bi.qb0407a.setOnCheckedChangeListener(this);



    }
}
