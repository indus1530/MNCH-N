package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.data.entities.Forms;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsdBinding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class RSDActivity extends AppCompatActivity {
    //Routine Service Delivery
    ActivityRsdBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsd);
        bi.setCallback(this);

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

                finish();
                startActivity(new Intent(RSDActivity.this, EndingActivity.class));

//                startActivity(new Intent(this, SectionA2Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void BtnEnd() {

    }
    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "insertForm").get();

            if (longID != 0) {
                fc.setId(longID.intValue());
                fc.setUid(MainApp.deviceId + fc.getId());

                longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }
    public boolean formValidation() {
        if (!validatorClass.EmptyTextBox(this, bi.rs01, getString(R.string.rs01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs02, getString(R.string.rs02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs03, getString(R.string.rs03))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs04, getString(R.string.rs04))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs05, getString(R.string.rs05))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs06, getString(R.string.rs06))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs07, getString(R.string.rs07))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs08, getString(R.string.rs08))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs09, getString(R.string.rs09))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs10, getString(R.string.rs10))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs11, getString(R.string.rs11))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs12, getString(R.string.rs12))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs13, getString(R.string.rs13))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs14, getString(R.string.rs14))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs15, getString(R.string.rs15))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs16, getString(R.string.rs16))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs17, getString(R.string.rs17))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs18, getString(R.string.rs18))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs19, getString(R.string.rs19))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs10, getString(R.string.rs20))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs21, getString(R.string.rs21))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs22, getString(R.string.rs22))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs23, getString(R.string.rs23))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs24, getString(R.string.rs24))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs25, getString(R.string.rs25))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs26, getString(R.string.rs26))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs27, getString(R.string.rs27))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs28, getString(R.string.rs28))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs29, getString(R.string.rs29))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs30, getString(R.string.rs30))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs31, getString(R.string.rs31))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs32, getString(R.string.rs32))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs33, getString(R.string.rs33))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs34, getString(R.string.rs34))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs35, getString(R.string.rs35))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs36, getString(R.string.rs36))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs37, getString(R.string.rs37))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs38, getString(R.string.rs38))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs39, getString(R.string.rs39))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.rs40, getString(R.string.rs40))) {
            return false;
        }



        return true;
    }
    private void SaveDraft() throws JSONException {

        JSONObject f01 = new JSONObject();
        f01.put("rs01",bi.rs01.getText().toString());
        f01.put("rs02",bi.rs02.getText().toString());
        f01.put("rs03",bi.rs03.getText().toString());
        f01.put("rs04",bi.rs04.getText().toString());
        f01.put("rs05",bi.rs05.getText().toString());
        f01.put("rs06",bi.rs06.getText().toString());
        f01.put("rs07",bi.rs07.getText().toString());
        f01.put("rs08",bi.rs08.getText().toString());
        f01.put("rs09",bi.rs09.getText().toString());
        f01.put("rs10",bi.rs10.getText().toString());
        f01.put("rs11",bi.rs11.getText().toString());
        f01.put("rs12",bi.rs12.getText().toString());
        f01.put("rs13",bi.rs13.getText().toString());
        f01.put("rs14",bi.rs14.getText().toString());
        f01.put("rs15",bi.rs15.getText().toString());
        f01.put("rs16",bi.rs16.getText().toString());
        f01.put("rs17",bi.rs17.getText().toString());
        f01.put("rs18",bi.rs18.getText().toString());
        f01.put("rs19",bi.rs19.getText().toString());
        f01.put("rs20",bi.rs20.getText().toString());
        f01.put("rs21",bi.rs21.getText().toString());
        f01.put("rs22",bi.rs22.getText().toString());
        f01.put("rs23",bi.rs23.getText().toString());
        f01.put("rs24",bi.rs24.getText().toString());
        f01.put("rs25",bi.rs25.getText().toString());
        f01.put("rs26",bi.rs26.getText().toString());
        f01.put("rs27",bi.rs27.getText().toString());
        f01.put("rs28",bi.rs28.getText().toString());
        f01.put("rs29",bi.rs29.getText().toString());
        f01.put("rs30",bi.rs30.getText().toString());
        f01.put("rs31",bi.rs31.getText().toString());
        f01.put("rs32",bi.rs32.getText().toString());
        f01.put("rs33",bi.rs33.getText().toString());
        f01.put("rs34",bi.rs34.getText().toString());
        f01.put("rs35",bi.rs35.getText().toString());
        f01.put("rs36",bi.rs36.getText().toString());
        f01.put("rs37",bi.rs37.getText().toString());
        f01.put("rs38",bi.rs38.getText().toString());
        f01.put("rs39",bi.rs39.getText().toString());
        f01.put("rs40",bi.rs40.getText().toString());

        fc.setSrsd(String.valueOf(f01));

    }

}
