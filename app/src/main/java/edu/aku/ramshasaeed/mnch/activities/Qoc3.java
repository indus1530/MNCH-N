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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc3Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc3 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc3);
        bi.setCallback(this);
        this.setTitle("Quality of Care 03");

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
                startActivity(new Intent(Qoc3.this, Qoc4.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }*/
        }

        finish();
        startActivity(new Intent(Qoc3.this, Qoc4.class));

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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc3);
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

        if (!bi.qa0717aa.isChecked()){
            bi.qa0717b.clearCheck();
            bi.qa0717c.setEnabled(false);
        } else {
            bi.qa0717c.setEnabled(true);
        }

        if (!bi.qa0718aa.isChecked()){
            bi.qa0718b.clearCheck();
            bi.qa0718c.setEnabled(false);
        } else {
            bi.qa0718c.setEnabled(true);
        }

        if (!bi.qa0719aa.isChecked()){
            bi.qa0719b.clearCheck();
            bi.qa0719c.setEnabled(false);
        } else {
            bi.qa0719c.setEnabled(true);
        }

        if (!bi.qa0720aa.isChecked()){
            bi.qa0720b.clearCheck();
            bi.qa0720c.setEnabled(false);
        } else {
            bi.qa0720c.setEnabled(true);
        }

        if (!bi.qa0721aa.isChecked()){
            bi.qa0721b.clearCheck();
            bi.qa0721c.setEnabled(false);
        } else {
            bi.qa0721c.setEnabled(true);
        }



        if (!bi.qa0801aa.isChecked()){
            bi.qa0801b.clearCheck();
            bi.qa0801c.setEnabled(false);
        } else {
            bi.qa0801c.setEnabled(true);
        }

        if (!bi.qa0802aa.isChecked()){
            bi.qa0802b.clearCheck();
            bi.qa0802c.setEnabled(false);
        } else {
            bi.qa0802c.setEnabled(true);
        }

        if (!bi.qa0803aa.isChecked()){
            bi.qa0803b.clearCheck();
            bi.qa0803c.setEnabled(false);
        } else {
            bi.qa0803c.setEnabled(true);
        }
        
        if (!bi.qa0804aa.isChecked()){
            bi.qa0804b.clearCheck();
            bi.qa0804c.setEnabled(false);
        } else {
            bi.qa0804c.setEnabled(true);
        }

        if (!bi.qa0805aa.isChecked()){
            bi.qa0805b.clearCheck();
            bi.qa0805c.setEnabled(false);
        } else {
            bi.qa0805c.setEnabled(true);
        }

        if (!bi.qb0101aa.isChecked()){
            bi.qb0101b.clearCheck();
            bi.qb0101c.setEnabled(false);
        } else {
            bi.qb0101c.setEnabled(true);
        }

        if (!bi.qb0102aa.isChecked()){
            bi.qb0102b.clearCheck();
            bi.qb0102c.setEnabled(false);
        } else {
            bi.qb0102c.setEnabled(true);
        }

        if (!bi.qb0103aa.isChecked()){
            bi.qb0103b.clearCheck();
            bi.qb0103c.setEnabled(false);
        } else {
            bi.qb0103c.setEnabled(true);
        }

        if (!bi.qb0104aa.isChecked()){
            bi.qb0104b.clearCheck();
            bi.qb0104c.setEnabled(false);
        } else {
            bi.qb0104c.setEnabled(true);
        }

        if (!bi.qb0105aa.isChecked()){
            bi.qb0105b.clearCheck();
            bi.qb0105c.setEnabled(false);
        } else {
            bi.qb0105c.setEnabled(true);
        }

        if (!bi.qb0106aa.isChecked()){
            bi.qb0106b.clearCheck();
            bi.qb0106c.setEnabled(false);
        } else {
            bi.qb0106c.setEnabled(true);
        }

        if (!bi.qb0107aa.isChecked()){
            bi.qb0107b.clearCheck();
            bi.qb0107c.setEnabled(false);
        } else {
            bi.qb0107c.setEnabled(true);
        }

        if (!bi.qb0108aa.isChecked()){
            bi.qb0108b.clearCheck();
            bi.qb0108c.setEnabled(false);
        } else {
            bi.qb0108c.setEnabled(true);
        }

        if (!bi.qb0109aa.isChecked()){
            bi.qb0109b.clearCheck();
            bi.qb0109c.setEnabled(false);
        } else {
            bi.qb0109c.setEnabled(true);
        }

        if (!bi.qb0110aa.isChecked()){
            bi.qb0110b.clearCheck();
            bi.qb0110c.setEnabled(false);
        } else {
            bi.qb0110c.setEnabled(true);
        }

        if (!bi.qb0111aa.isChecked()){
            bi.qb0111b.clearCheck();
            bi.qb0111c.setEnabled(false);
        } else {
            bi.qb0111c.setEnabled(true);
        }

        if (!bi.qb0112aa.isChecked()){
            bi.qb0112b.clearCheck();
            bi.qb0112c.setEnabled(false);
        } else {
            bi.qb0112c.setEnabled(true);
        }

        if (!bi.qb0113aa.isChecked()){
            bi.qb0113b.clearCheck();
            bi.qb0113c.setEnabled(false);
        } else {
            bi.qb0113c.setEnabled(true);
        }

        if (!bi.qb0114aa.isChecked()){
            bi.qb0114b.clearCheck();
            bi.qb0114c.setEnabled(false);
        } else {
            bi.qb0114c.setEnabled(true);
        }

    }


    void events_call() {


        bi.qa0717a.setOnCheckedChangeListener(this);
        bi.qa0718a.setOnCheckedChangeListener(this);
        bi.qa0719a.setOnCheckedChangeListener(this);
        bi.qa0720a.setOnCheckedChangeListener(this);
        bi.qa0721a.setOnCheckedChangeListener(this);

        bi.qa0801a.setOnCheckedChangeListener(this);
        bi.qa0802a.setOnCheckedChangeListener(this);
        bi.qa0803a.setOnCheckedChangeListener(this);
        bi.qa0804a.setOnCheckedChangeListener(this);
        bi.qa0805a.setOnCheckedChangeListener(this);

        bi.qb0101a.setOnCheckedChangeListener(this);
        bi.qb0102a.setOnCheckedChangeListener(this);
        bi.qb0103a.setOnCheckedChangeListener(this);
        bi.qb0104a.setOnCheckedChangeListener(this);
        bi.qb0105a.setOnCheckedChangeListener(this);
        bi.qb0106a.setOnCheckedChangeListener(this);
        bi.qb0107a.setOnCheckedChangeListener(this);
        bi.qb0108a.setOnCheckedChangeListener(this);
        bi.qb0109a.setOnCheckedChangeListener(this);
        bi.qb0110a.setOnCheckedChangeListener(this);
        bi.qb0111a.setOnCheckedChangeListener(this);
        bi.qb0112a.setOnCheckedChangeListener(this);
        bi.qb0113a.setOnCheckedChangeListener(this);
        bi.qb0114a.setOnCheckedChangeListener(this);

    }
}
