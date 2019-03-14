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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc2Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc2);
        bi.setCallback(this);
        this.setTitle("Quality of Care 02");

        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc3.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc2);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc2 = new JSONObject();

        qoc2.put("qa0601a", bi.qa0601aa.isChecked() ? "1" : bi.qa0601ab.isChecked() ? "2" : bi.qa0601a97.isChecked() ? "97" : "0");
        qoc2.put("qa0601b", bi.qa0601ba.isChecked() ? "1" : bi.qa0601bb.isChecked() ? "2" : bi.qa0601b98.isChecked() ? "98" : "0");
        qoc2.put("qa0601c", bi.qa0601c.getText().toString().trim().length() > 0 ? bi.qa0601c.getText().toString() : "0");

        qoc2.put("qa0602a", bi.qa0602aa.isChecked() ? "1" : bi.qa0602ab.isChecked() ? "2" : bi.qa0602a97.isChecked() ? "97" : "0");
        qoc2.put("qa0602b", bi.qa0602ba.isChecked() ? "1" : bi.qa0602bb.isChecked() ? "2" : bi.qa0602b98.isChecked() ? "98" : "0");
        qoc2.put("qa0602c", bi.qa0602c.getText().toString().trim().length() > 0 ? bi.qa0602c.getText().toString() : "0");

        qoc2.put("qa0603a", bi.qa0603aa.isChecked() ? "1" : bi.qa0603ab.isChecked() ? "2" : bi.qa0603a97.isChecked() ? "97" : "0");
        qoc2.put("qa0603b", bi.qa0603ba.isChecked() ? "1" : bi.qa0603bb.isChecked() ? "2" : bi.qa0603b98.isChecked() ? "98" : "0");
        qoc2.put("qa0603c", bi.qa0603c.getText().toString().trim().length() > 0 ? bi.qa0603c.getText().toString() : "0");

        qoc2.put("qa0604a", bi.qa0604aa.isChecked() ? "1" : bi.qa0604ab.isChecked() ? "2" : bi.qa0604a97.isChecked() ? "97" : "0");
        qoc2.put("qa0604b", bi.qa0604ba.isChecked() ? "1" : bi.qa0604bb.isChecked() ? "2" : bi.qa0604b98.isChecked() ? "98" : "0");
        qoc2.put("qa0604c", bi.qa0604c.getText().toString().trim().length() > 0 ? bi.qa0604c.getText().toString() : "0");

        qoc2.put("qa0605a", bi.qa0605aa.isChecked() ? "1" : bi.qa0605ab.isChecked() ? "2" : bi.qa0605a97.isChecked() ? "97" : "0");
        qoc2.put("qa0605b", bi.qa0605ba.isChecked() ? "1" : bi.qa0605bb.isChecked() ? "2" : bi.qa0605b98.isChecked() ? "98" : "0");
        qoc2.put("qa0605c", bi.qa0605c.getText().toString().trim().length() > 0 ? bi.qa0605c.getText().toString() : "0");

        qoc2.put("qa0606a", bi.qa0606aa.isChecked() ? "1" : bi.qa0606ab.isChecked() ? "2" : bi.qa0606a97.isChecked() ? "97" : "0");
        qoc2.put("qa0606b", bi.qa0606ba.isChecked() ? "1" : bi.qa0606bb.isChecked() ? "2" : bi.qa0606b98.isChecked() ? "98" : "0");
        qoc2.put("qa0606c", bi.qa0606c.getText().toString().trim().length() > 0 ? bi.qa0606c.getText().toString() : "0");

        qoc2.put("qa0607a", bi.qa0607aa.isChecked() ? "1" : bi.qa0607ab.isChecked() ? "2" : bi.qa0607a97.isChecked() ? "97" : "0");
        qoc2.put("qa0607b", bi.qa0607ba.isChecked() ? "1" : bi.qa0607bb.isChecked() ? "2" : bi.qa0607b98.isChecked() ? "98" : "0");
        qoc2.put("qa0607c", bi.qa0607c.getText().toString().trim().length() > 0 ? bi.qa0607c.getText().toString() : "0");

        qoc2.put("qa0608a", bi.qa0608aa.isChecked() ? "1" : bi.qa0608ab.isChecked() ? "2" : bi.qa0608a97.isChecked() ? "97" : "0");
        qoc2.put("qa0608b", bi.qa0608ba.isChecked() ? "1" : bi.qa0608bb.isChecked() ? "2" : bi.qa0608b98.isChecked() ? "98" : "0");
        qoc2.put("qa0608c", bi.qa0608c.getText().toString().trim().length() > 0 ? bi.qa0608c.getText().toString() : "0");

        
        
        
        qoc2.put("qa0701a", bi.qa0701aa.isChecked() ? "1" : bi.qa0701ab.isChecked() ? "2" : bi.qa0701a97.isChecked() ? "97" : "0");
        qoc2.put("qa0701b", bi.qa0701ba.isChecked() ? "1" : bi.qa0701bb.isChecked() ? "2" : bi.qa0701b98.isChecked() ? "98" : "0");
        qoc2.put("qa0701c", bi.qa0701c.getText().toString().trim().length() > 0 ? bi.qa0701c.getText().toString() : "0");
        
        qoc2.put("qa0702a", bi.qa0702aa.isChecked() ? "1" : bi.qa0702ab.isChecked() ? "2" : bi.qa0702a97.isChecked() ? "97" : "0");
        qoc2.put("qa0702b", bi.qa0702ba.isChecked() ? "1" : bi.qa0702bb.isChecked() ? "2" : bi.qa0702b98.isChecked() ? "98" : "0");
        qoc2.put("qa0702c", bi.qa0702c.getText().toString().trim().length() > 0 ? bi.qa0702c.getText().toString() : "0");

        qoc2.put("qa0703a", bi.qa0703aa.isChecked() ? "1" : bi.qa0703ab.isChecked() ? "2" : bi.qa0703a97.isChecked() ? "97" : "0");
        qoc2.put("qa0703b", bi.qa0703ba.isChecked() ? "1" : bi.qa0703bb.isChecked() ? "2" : bi.qa0703b98.isChecked() ? "98" : "0");
        qoc2.put("qa0703c", bi.qa0703c.getText().toString().trim().length() > 0 ? bi.qa0703c.getText().toString() : "0");
        
        qoc2.put("qa0704a", bi.qa0704aa.isChecked() ? "1" : bi.qa0704ab.isChecked() ? "2" : bi.qa0704a97.isChecked() ? "97" : "0");
        qoc2.put("qa0704b", bi.qa0704ba.isChecked() ? "1" : bi.qa0704bb.isChecked() ? "2" : bi.qa0704b98.isChecked() ? "98" : "0");
        qoc2.put("qa0704c", bi.qa0704c.getText().toString().trim().length() > 0 ? bi.qa0704c.getText().toString() : "0");

        qoc2.put("qa0705a", bi.qa0705aa.isChecked() ? "1" : bi.qa0705ab.isChecked() ? "2" : bi.qa0705a97.isChecked() ? "97" : "0");
        qoc2.put("qa0705b", bi.qa0705ba.isChecked() ? "1" : bi.qa0705bb.isChecked() ? "2" : bi.qa0705b98.isChecked() ? "98" : "0");
        qoc2.put("qa0705c", bi.qa0705c.getText().toString().trim().length() > 0 ? bi.qa0705c.getText().toString() : "0");

        qoc2.put("qa0706a", bi.qa0706aa.isChecked() ? "1" : bi.qa0706ab.isChecked() ? "2" : bi.qa0706a97.isChecked() ? "97" : "0");
        qoc2.put("qa0706b", bi.qa0706ba.isChecked() ? "1" : bi.qa0706bb.isChecked() ? "2" : bi.qa0706b98.isChecked() ? "98" : "0");
        qoc2.put("qa0706c", bi.qa0706c.getText().toString().trim().length() > 0 ? bi.qa0706c.getText().toString() : "0");

        qoc2.put("qa0707a", bi.qa0707aa.isChecked() ? "1" : bi.qa0707ab.isChecked() ? "2" : bi.qa0707a97.isChecked() ? "97" : "0");
        qoc2.put("qa0707b", bi.qa0707ba.isChecked() ? "1" : bi.qa0707bb.isChecked() ? "2" : bi.qa0707b98.isChecked() ? "98" : "0");
        qoc2.put("qa0707c", bi.qa0707c.getText().toString().trim().length() > 0 ? bi.qa0707c.getText().toString() : "0");

        qoc2.put("qa0708a", bi.qa0708aa.isChecked() ? "1" : bi.qa0708ab.isChecked() ? "2" : bi.qa0708a97.isChecked() ? "97" : "0");
        qoc2.put("qa0708b", bi.qa0708ba.isChecked() ? "1" : bi.qa0708bb.isChecked() ? "2" : bi.qa0708b98.isChecked() ? "98" : "0");
        qoc2.put("qa0708c", bi.qa0708c.getText().toString().trim().length() > 0 ? bi.qa0708c.getText().toString() : "0");
        
        qoc2.put("qa0709a", bi.qa0709aa.isChecked() ? "1" : bi.qa0709ab.isChecked() ? "2" : bi.qa0709a97.isChecked() ? "97" : "0");
        qoc2.put("qa0709b", bi.qa0709ba.isChecked() ? "1" : bi.qa0709bb.isChecked() ? "2" : bi.qa0709b98.isChecked() ? "98" : "0");
        qoc2.put("qa0709c", bi.qa0709c.getText().toString().trim().length() > 0 ? bi.qa0709c.getText().toString() : "0");

        qoc2.put("qa0710a", bi.qa0710aa.isChecked() ? "1" : bi.qa0710ab.isChecked() ? "2" : bi.qa0710a97.isChecked() ? "97" : "0");
        qoc2.put("qa0710b", bi.qa0710ba.isChecked() ? "1" : bi.qa0710bb.isChecked() ? "2" : bi.qa0710b98.isChecked() ? "98" : "0");
        qoc2.put("qa0710c", bi.qa0710c.getText().toString().trim().length() > 0 ? bi.qa0710c.getText().toString() : "0");

        qoc2.put("qa0711a", bi.qa0711aa.isChecked() ? "1" : bi.qa0711ab.isChecked() ? "2" : bi.qa0711a97.isChecked() ? "97" : "0");
        qoc2.put("qa0711b", bi.qa0711ba.isChecked() ? "1" : bi.qa0711bb.isChecked() ? "2" : bi.qa0711b98.isChecked() ? "98" : "0");
        qoc2.put("qa0711c", bi.qa0711c.getText().toString().trim().length() > 0 ? bi.qa0711c.getText().toString() : "0");

        qoc2.put("qa0712a", bi.qa0712aa.isChecked() ? "1" : bi.qa0712ab.isChecked() ? "2" : bi.qa0712a97.isChecked() ? "97" : "0");
        qoc2.put("qa0712b", bi.qa0712ba.isChecked() ? "1" : bi.qa0712bb.isChecked() ? "2" : bi.qa0712b98.isChecked() ? "98" : "0");
        qoc2.put("qa0712c", bi.qa0712c.getText().toString().trim().length() > 0 ? bi.qa0712c.getText().toString() : "0");

        qoc2.put("qa0713a", bi.qa0713aa.isChecked() ? "1" : bi.qa0713ab.isChecked() ? "2" : bi.qa0713a97.isChecked() ? "97" : "0");
        qoc2.put("qa0713b", bi.qa0713ba.isChecked() ? "1" : bi.qa0713bb.isChecked() ? "2" : bi.qa0713b98.isChecked() ? "98" : "0");
        qoc2.put("qa0713c", bi.qa0713c.getText().toString().trim().length() > 0 ? bi.qa0713c.getText().toString() : "0");

        qoc2.put("qa0714a", bi.qa0714aa.isChecked() ? "1" : bi.qa0714ab.isChecked() ? "2" : bi.qa0714a97.isChecked() ? "97" : "0");
        qoc2.put("qa0714b", bi.qa0714ba.isChecked() ? "1" : bi.qa0714bb.isChecked() ? "2" : bi.qa0714b98.isChecked() ? "98" : "0");
        qoc2.put("qa0714c", bi.qa0714c.getText().toString().trim().length() > 0 ? bi.qa0714c.getText().toString() : "0");

        qoc2.put("qa0715a", bi.qa0715aa.isChecked() ? "1" : bi.qa0715ab.isChecked() ? "2" : bi.qa0715a97.isChecked() ? "97" : "0");
        qoc2.put("qa0715b", bi.qa0715ba.isChecked() ? "1" : bi.qa0715bb.isChecked() ? "2" : bi.qa0715b98.isChecked() ? "98" : "0");
        qoc2.put("qa0715c", bi.qa0715c.getText().toString().trim().length() > 0 ? bi.qa0715c.getText().toString() : "0");

        qoc2.put("qa0716a", bi.qa0716aa.isChecked() ? "1" : bi.qa0716ab.isChecked() ? "2" : bi.qa0716a97.isChecked() ? "97" : "0");
        qoc2.put("qa0716b", bi.qa0716ba.isChecked() ? "1" : bi.qa0716bb.isChecked() ? "2" : bi.qa0716b98.isChecked() ? "98" : "0");
        qoc2.put("qa0716c", bi.qa0716c.getText().toString().trim().length() > 0 ? bi.qa0716c.getText().toString() : "0");


        /*preFix.equals("QOC");
        JSONObject json_qoc1 = GeneratorClass.getContainerJSON(bi.llqoc1, true, preFix);*/

        fc.setSqoc1(String.valueOf(qoc2));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qa0601aa.isChecked()){
            bi.qa0601b.clearCheck();
            bi.qa0601c.setEnabled(false);
        } else {
            bi.qa0601c.setEnabled(true);
        }

        if (!bi.qa0602aa.isChecked()){
            bi.qa0602b.clearCheck();
            bi.qa0602c.setEnabled(false);
        } else {
            bi.qa0602c.setEnabled(true);
        }

        if (!bi.qa0603aa.isChecked()){
            bi.qa0603b.clearCheck();
            bi.qa0603c.setEnabled(false);
        } else {
            bi.qa0603c.setEnabled(true);
        }

        if (!bi.qa0604aa.isChecked()){
            bi.qa0604b.clearCheck();
            bi.qa0604c.setEnabled(false);
        } else {
            bi.qa0604c.setEnabled(true);
        }

        if (!bi.qa0605aa.isChecked()){
            bi.qa0605b.clearCheck();
            bi.qa0605c.setEnabled(false);
        } else {
            bi.qa0605c.setEnabled(true);
        }

        if (!bi.qa0606aa.isChecked()){
            bi.qa0606b.clearCheck();
            bi.qa0606c.setEnabled(false);
        } else {
            bi.qa0606c.setEnabled(true);
        }

        if (!bi.qa0607aa.isChecked()){
            bi.qa0607b.clearCheck();
            bi.qa0607c.setEnabled(false);
        } else {
            bi.qa0607c.setEnabled(true);
        }

        if (!bi.qa0608aa.isChecked()){
            bi.qa0608b.clearCheck();
            bi.qa0608c.setEnabled(false);
        } else {
            bi.qa0608c.setEnabled(true);
        }



        if (!bi.qa0701aa.isChecked()){
            bi.qa0701b.clearCheck();
            bi.qa0701c.setEnabled(false);
        } else {
            bi.qa0701c.setEnabled(true);
        }

        if (!bi.qa0702aa.isChecked()){
            bi.qa0702b.clearCheck();
            bi.qa0702c.setEnabled(false);
        } else {
            bi.qa0702c.setEnabled(true);
        }

        if (!bi.qa0703aa.isChecked()){
            bi.qa0703b.clearCheck();
            bi.qa0703c.setEnabled(false);
        } else {
            bi.qa0703c.setEnabled(true);
        }

        if (!bi.qa0704aa.isChecked()){
            bi.qa0704b.clearCheck();
            bi.qa0704c.setEnabled(false);
        } else {
            bi.qa0704c.setEnabled(true);
        }

        if (!bi.qa0705aa.isChecked()){
            bi.qa0705b.clearCheck();
            bi.qa0705c.setEnabled(false);
        } else {
            bi.qa0705c.setEnabled(true);
        }

        if (!bi.qa0706aa.isChecked()){
            bi.qa0706b.clearCheck();
            bi.qa0706c.setEnabled(false);
        } else {
            bi.qa0706c.setEnabled(true);
        }

        if (!bi.qa0707aa.isChecked()){
            bi.qa0707b.clearCheck();
            bi.qa0707c.setEnabled(false);
        } else {
            bi.qa0707c.setEnabled(true);
        }

        if (!bi.qa0708aa.isChecked()){
            bi.qa0708b.clearCheck();
            bi.qa0708c.setEnabled(false);
        } else {
            bi.qa0708c.setEnabled(true);
        }

        if (!bi.qa0709aa.isChecked()){
            bi.qa0709b.clearCheck();
            bi.qa0709c.setEnabled(false);
        } else {
            bi.qa0709c.setEnabled(true);
        }

        if (!bi.qa0710aa.isChecked()){
            bi.qa0710b.clearCheck();
            bi.qa0710c.setEnabled(false);
        } else {
            bi.qa0710c.setEnabled(true);
        }

        if (!bi.qa0711aa.isChecked()){
            bi.qa0711b.clearCheck();
            bi.qa0711c.setEnabled(false);
        } else {
            bi.qa0711c.setEnabled(true);
        }

        if (!bi.qa0712aa.isChecked()){
            bi.qa0712b.clearCheck();
            bi.qa0712c.setEnabled(false);
        } else {
            bi.qa0712c.setEnabled(true);
        }

        if (!bi.qa0713aa.isChecked()){
            bi.qa0713b.clearCheck();
            bi.qa0713c.setEnabled(false);
        } else {
            bi.qa0713c.setEnabled(true);
        }

        if (!bi.qa0714aa.isChecked()){
            bi.qa0714b.clearCheck();
            bi.qa0714c.setEnabled(false);
        } else {
            bi.qa0714c.setEnabled(true);
        }

        if (!bi.qa0715aa.isChecked()){
            bi.qa0715b.clearCheck();
            bi.qa0715c.setEnabled(false);
        } else {
            bi.qa0715c.setEnabled(true);
        }
        
        if (!bi.qa0716aa.isChecked()){
            bi.qa0716b.clearCheck();
            bi.qa0716c.setEnabled(false);
        } else {
            bi.qa0716c.setEnabled(true);
        }
        
    }


    void events_call() {

        bi.qa0601a.setOnCheckedChangeListener(this);
        bi.qa0602a.setOnCheckedChangeListener(this);
        bi.qa0603a.setOnCheckedChangeListener(this);
        bi.qa0604a.setOnCheckedChangeListener(this);
        bi.qa0605a.setOnCheckedChangeListener(this);
        bi.qa0606a.setOnCheckedChangeListener(this);
        bi.qa0607a.setOnCheckedChangeListener(this);
        bi.qa0608a.setOnCheckedChangeListener(this);


        bi.qa0701a.setOnCheckedChangeListener(this);
        bi.qa0702a.setOnCheckedChangeListener(this);
        bi.qa0703a.setOnCheckedChangeListener(this);
        bi.qa0704a.setOnCheckedChangeListener(this);
        bi.qa0705a.setOnCheckedChangeListener(this);
        bi.qa0706a.setOnCheckedChangeListener(this);
        bi.qa0707a.setOnCheckedChangeListener(this);
        bi.qa0708a.setOnCheckedChangeListener(this);
        bi.qa0709a.setOnCheckedChangeListener(this);
        bi.qa0710a.setOnCheckedChangeListener(this);
        bi.qa0711a.setOnCheckedChangeListener(this);
        bi.qa0712a.setOnCheckedChangeListener(this);
        bi.qa0713a.setOnCheckedChangeListener(this);
        bi.qa0714a.setOnCheckedChangeListener(this);
        bi.qa0715a.setOnCheckedChangeListener(this);
        bi.qa0716a.setOnCheckedChangeListener(this);

    }
}
