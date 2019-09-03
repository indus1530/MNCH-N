package edu.aku.ramshasaeed.mnch.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd06Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd06 extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsd06Binding bi;
    String rm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd06);
        bi.setCallback(this);
        rm = getIntent().getStringExtra("rm");
        this.setTitle(getString(R.string.routineone) + "(" + rm + ")");
        //EventsCall();

    }


    void EventsCall() {

       /* bi.rs2299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        });*/

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
                MainApp.endActivity(this, this, RsdMain.class, true, RSDInfoActivity.fc);

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

        if (!bi.rs0699.isChecked()) {
            return validatorClass.EmptyTextBox(this, bi.rs06, getString(R.string.rs06));
        }

        if (!bi.rs4799.isChecked()) {
            return validatorClass.EmptyTextBox(this, bi.rs47, getString(R.string.rs47));
        }

        if (!bi.rs4899.isChecked()) {
            return validatorClass.EmptyTextBox(this, bi.rs48, getString(R.string.rs48));
        }

        return validatorClass.EmptyTextBox(this, bi.rsrem, getString(R.string.rsrem));

    }


    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs06", bi.rs0699.isChecked() ? "Mi" : bi.rs06.getText().toString());
        f01.put("rs47", bi.rs4799.isChecked() ? "Mi" : bi.rs47.getText().toString());
        f01.put("rs48", bi.rs4899.isChecked() ? "Mi" : bi.rs48.getText().toString());

        f01.put("rsrem", bi.rsrem.getText().toString());

        fc.setSF(String.valueOf(f01));

    }

/*    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/

}
