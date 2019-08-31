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
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd05Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd05 extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsd05Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd05);
        bi.setCallback(this);
        this.setTitle(getString(R.string.routineone));
        //EventsCall();


    }

    void EventsCall() {

        /*bi.rs3499.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3497.isChecked()) {
                    bi.rs3497.setChecked(false);
                }
                if (b) {
                    bi.rs34.setVisibility(View.GONE);
                    bi.rs34.setText(null);
                } else {
                    bi.rs34.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3497.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3499.isChecked()) {
                    bi.rs3499.setChecked(false);
                }
                if (b) {
                    bi.rs34.setVisibility(View.GONE);
                    bi.rs34.setText(null);
                } else {
                    bi.rs34.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3197.isChecked()) {
                    bi.rs3197.setChecked(false);
                }
                if (b) {
                    bi.rs31.setVisibility(View.GONE);
                    bi.rs31.setText(null);
                } else {
                    bi.rs31.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3197.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3199.isChecked()) {
                    bi.rs3199.setChecked(false);
                }
                if (b) {
                    bi.rs31.setVisibility(View.GONE);
                    bi.rs31.setText(null);
                } else {
                    bi.rs31.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4599.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4597.isChecked()) {
                    bi.rs4597.setChecked(false);
                }
                if (b) {
                    bi.rs45.setVisibility(View.GONE);
                    bi.rs45.setText(null);
                } else {
                    bi.rs45.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4597.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4599.isChecked()) {
                    bi.rs4599.setChecked(false);
                }
                if (b) {
                    bi.rs45.setVisibility(View.GONE);
                    bi.rs45.setText(null);
                } else {
                    bi.rs45.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3599.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3597.isChecked()) {
                    bi.rs3597.setChecked(false);
                }
                if (b) {
                    bi.rs35.setVisibility(View.GONE);
                    bi.rs35.setText(null);
                } else {
                    bi.rs35.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3597.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3599.isChecked()) {
                    bi.rs3599.setChecked(false);
                }
                if (b) {
                    bi.rs35.setVisibility(View.GONE);
                    bi.rs35.setText(null);
                } else {
                    bi.rs35.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4699.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4697.isChecked()) {
                    bi.rs4697.setChecked(false);
                }
                if (b) {
                    bi.rs46.setVisibility(View.GONE);
                    bi.rs46.setText(null);
                } else {
                    bi.rs46.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4697.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4699.isChecked()) {
                    bi.rs4699.setChecked(false);
                }
                if (b) {
                    bi.rs46.setVisibility(View.GONE);
                    bi.rs46.setText(null);
                } else {
                    bi.rs46.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3297.isChecked()) {
                    bi.rs3297.setChecked(false);
                }
                if (b) {
                    bi.rs32.setVisibility(View.GONE);
                    bi.rs32.setText(null);
                } else {
                    bi.rs32.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3297.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3299.isChecked()) {
                    bi.rs3299.setChecked(false);
                }
                if (b) {
                    bi.rs32.setVisibility(View.GONE);
                    bi.rs32.setText(null);
                } else {
                    bi.rs32.setVisibility(View.VISIBLE);
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


        if (!bi.rs3499.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs34, getString(R.string.rs34))) {
                return false;
            }
        }
        if (!bi.rs3199.isChecked()) {


            if (!validatorClass.EmptyTextBox(this, bi.rs31, getString(R.string.rs31))) {
                return false;
            }
        }
        if (!bi.rs2799.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs27, getString(R.string.rs27))) {
                return false;
            }
        }
        if (!bi.rs2899.isChecked()) {


            if (!validatorClass.EmptyTextBox(this, bi.rs28, getString(R.string.rs28))) {
                return false;
            }
        }
        if (!bi.rs3599.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs35, getString(R.string.rs35))) {
                return false;
            }
        }
        if (!bi.rs3299.isChecked()) {

            return validatorClass.EmptyTextBox(this, bi.rs32, getString(R.string.rs32));
        }

        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();

        f01.put("rs34", bi.rs3499.isChecked() ? "Mi" : bi.rs34.getText().toString());
        f01.put("rs31", bi.rs3199.isChecked() ? "Mi" : bi.rs31.getText().toString());
        f01.put("rs27", bi.rs2799.isChecked() ? "Mi" : bi.rs27.getText().toString());
        f01.put("rs28", bi.rs2899.isChecked() ? "Mi" : bi.rs28.getText().toString());
        f01.put("rs35", bi.rs3599.isChecked() ? "Mi" : bi.rs35.getText().toString());
        f01.put("rs32", bi.rs3299.isChecked() ? "Mi" : bi.rs32.getText().toString());

        fc.setSrsd5(String.valueOf(f01));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
