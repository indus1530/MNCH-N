package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
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
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsd01Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Rsd01 extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsd01Binding bi;
    String rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd01);
        bi.setCallback(this);
        rm = getIntent().getStringExtra("rm");
        this.setTitle(getString(R.string.routineone) + "(" + rm + ")");
        //EventsCall();

    }


    void EventsCall() {

        /*bi.rs2299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        });*/

        /*bi.rs3999.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3997.isChecked()) {
                    bi.rs3997.setChecked(false);
                }
                if (b) {
                    bi.rs39.setVisibility(View.GONE);
                    bi.rs39.setText(null);
                } else {
                    bi.rs39.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs3997.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs3999.isChecked()) {
                    bi.rs3999.setChecked(false);
                }
                if (b) {
                    bi.rs39.setVisibility(View.GONE);
                    bi.rs39.setText(null);
                } else {
                    bi.rs39.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4099.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4097.isChecked()) {
                    bi.rs4097.setChecked(false);
                }
                if (b) {
                    bi.rs40.setVisibility(View.GONE);
                    bi.rs40.setText(null);
                } else {
                    bi.rs40.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.rs4097.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && bi.rs4099.isChecked()) {
                    bi.rs4099.setChecked(false);
                }
                if (b) {
                    bi.rs40.setVisibility(View.GONE);
                    bi.rs40.setText(null);
                } else {
                    bi.rs40.setVisibility(View.VISIBLE);
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
        });

        bi.rs3499.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
//                MainApp.endActivity(this, this, RsdMain.class, true, RSDInfoActivity.fc);
                finish();
                startActivity(new Intent(this, RsdMain.class).putExtra("complete", true).putExtra("rm", rm).putExtra(MainApp.FORM_SUB_TYPE, "f1"));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {
//        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false).putExtra("rm", rm));

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

        if (!bi.rs0199.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.rs01, getString(R.string.rs01))) {
                return false;
            }
        }

        if (!bi.rs0299.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.rs02, getString(R.string.rs02))) {
                return false;
            }
        }


        if (!bi.rs0399.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs03, getString(R.string.rs03))) {
                return false;
            }
        }

        if (!bi.rs0499.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs04, getString(R.string.rs04))) {
                return false;
            }
        }
        if (!bi.rs0599.isChecked()) {

            return validatorClass.EmptyTextBox(this, bi.rs05, getString(R.string.rs05));
        }
        
        /*if (!bi.rs0699.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs06, getString(R.string.rs06))) {
                return false;
            }
        }*/
        
        /*if (!bi.rs0799.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs07, getString(R.string.rs07))) {
                return false;
            }
        }
        if (!bi.rs0899.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.rs08, getString(R.string.rs08))) {
                return false;
            }
        }*/

        return true;
    }


    private void SaveDraft() throws JSONException {

        fc.setFormSubType(MainApp.FORM_SUB_TYPE);

        JSONObject f01 = new JSONObject();

        f01.put("rs01", bi.rs0199.isChecked() ? "Mi" : bi.rs01.getText().toString());
        f01.put("rs02", bi.rs0299.isChecked() ? "Mi" : bi.rs02.getText().toString());
        f01.put("rs03", bi.rs0399.isChecked() ? "Mi" : bi.rs03.getText().toString());
        f01.put("rs04", bi.rs0499.isChecked() ? "Mi" : bi.rs04.getText().toString());
        f01.put("rs05", bi.rs0599.isChecked() ? "Mi" : bi.rs05.getText().toString());

        fc.setSrsd1(String.valueOf(f01));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
