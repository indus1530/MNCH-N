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
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc5.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc4);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc4 = new JSONObject();

        qoc4.put("qb0115a", bi.qb0115aa.isChecked() ? "1" : bi.qb0115ab.isChecked() ? "2" : bi.qb0115a97.isChecked() ? "97" : "0");
        qoc4.put("qb0115b", bi.qb0115ba.isChecked() ? "1" : bi.qb0115bb.isChecked() ? "2" : bi.qb0115b98.isChecked() ? "98" : "0");
        qoc4.put("qb0115c", bi.qb0115c.getText().toString().trim().length() > 0 ? bi.qb0115c.getText().toString() : "0");

        qoc4.put("qb0116a", bi.qb0116aa.isChecked() ? "1" : bi.qb0116ab.isChecked() ? "2" : bi.qb0116a97.isChecked() ? "97" : "0");
        qoc4.put("qb0116b", bi.qb0116ba.isChecked() ? "1" : bi.qb0116bb.isChecked() ? "2" : bi.qb0116b98.isChecked() ? "98" : "0");
        qoc4.put("qb0116c", bi.qb0116c.getText().toString().trim().length() > 0 ? bi.qb0116c.getText().toString() : "0");

        qoc4.put("qb0117a", bi.qb0117aa.isChecked() ? "1" : bi.qb0117ab.isChecked() ? "2" : bi.qb0117a97.isChecked() ? "97" : "0");
        qoc4.put("qb0117b", bi.qb0117ba.isChecked() ? "1" : bi.qb0117bb.isChecked() ? "2" : bi.qb0117b98.isChecked() ? "98" : "0");
        qoc4.put("qb0117c", bi.qb0117c.getText().toString().trim().length() > 0 ? bi.qb0117c.getText().toString() : "0");

        qoc4.put("qb0118a", bi.qb0118aa.isChecked() ? "1" : bi.qb0118ab.isChecked() ? "2" : bi.qb0118a97.isChecked() ? "97" : "0");
        qoc4.put("qb0118b", bi.qb0118ba.isChecked() ? "1" : bi.qb0118bb.isChecked() ? "2" : bi.qb0118b98.isChecked() ? "98" : "0");
        qoc4.put("qb0118c", bi.qb0118c.getText().toString().trim().length() > 0 ? bi.qb0118c.getText().toString() : "0");

        qoc4.put("qb0119a", bi.qb0119aa.isChecked() ? "1" : bi.qb0119ab.isChecked() ? "2" : bi.qb0119a97.isChecked() ? "97" : "0");
        qoc4.put("qb0119b", bi.qb0119ba.isChecked() ? "1" : bi.qb0119bb.isChecked() ? "2" : bi.qb0119b98.isChecked() ? "98" : "0");
        qoc4.put("qb0119c", bi.qb0119c.getText().toString().trim().length() > 0 ? bi.qb0119c.getText().toString() : "0");
        
        qoc4.put("qb0120a", bi.qb0120aa.isChecked() ? "1" : bi.qb0120ab.isChecked() ? "2" : bi.qb0120a97.isChecked() ? "97" : "0");
        qoc4.put("qb0120b", bi.qb0120ba.isChecked() ? "1" : bi.qb0120bb.isChecked() ? "2" : bi.qb0120b98.isChecked() ? "98" : "0");
        qoc4.put("qb0120c", bi.qb0120c.getText().toString().trim().length() > 0 ? bi.qb0120c.getText().toString() : "0");

        
        
        qoc4.put("qb0201a", bi.qb0201aa.isChecked() ? "1" : bi.qb0201ab.isChecked() ? "2" : bi.qb0201a97.isChecked() ? "97" : "0");
        qoc4.put("qb0201b", bi.qb0201ba.isChecked() ? "1" : bi.qb0201bb.isChecked() ? "2" : bi.qb0201b98.isChecked() ? "98" : "0");
        qoc4.put("qb0201c", bi.qb0201c.getText().toString().trim().length() > 0 ? bi.qb0201c.getText().toString() : "0");

        qoc4.put("qb0202a", bi.qb0202aa.isChecked() ? "1" : bi.qb0202ab.isChecked() ? "2" : bi.qb0202a97.isChecked() ? "97" : "0");
        qoc4.put("qb0202b", bi.qb0202ba.isChecked() ? "1" : bi.qb0202bb.isChecked() ? "2" : bi.qb0202b98.isChecked() ? "98" : "0");
        qoc4.put("qb0202c", bi.qb0202c.getText().toString().trim().length() > 0 ? bi.qb0202c.getText().toString() : "0");

        qoc4.put("qb0203a", bi.qb0203aa.isChecked() ? "1" : bi.qb0203ab.isChecked() ? "2" : bi.qb0203a97.isChecked() ? "97" : "0");
        qoc4.put("qb0203b", bi.qb0203ba.isChecked() ? "1" : bi.qb0203bb.isChecked() ? "2" : bi.qb0203b98.isChecked() ? "98" : "0");
        qoc4.put("qb0203c", bi.qb0203c.getText().toString().trim().length() > 0 ? bi.qb0203c.getText().toString() : "0");

        qoc4.put("qb0204a", bi.qb0204aa.isChecked() ? "1" : bi.qb0204ab.isChecked() ? "2" : bi.qb0204a97.isChecked() ? "97" : "0");
        qoc4.put("qb0204b", bi.qb0204ba.isChecked() ? "1" : bi.qb0204bb.isChecked() ? "2" : bi.qb0204b98.isChecked() ? "98" : "0");
        qoc4.put("qb0204c", bi.qb0204c.getText().toString().trim().length() > 0 ? bi.qb0204c.getText().toString() : "0");

        qoc4.put("qb0205a", bi.qb0205aa.isChecked() ? "1" : bi.qb0205ab.isChecked() ? "2" : bi.qb0205a97.isChecked() ? "97" : "0");
        qoc4.put("qb0205b", bi.qb0205ba.isChecked() ? "1" : bi.qb0205bb.isChecked() ? "2" : bi.qb0205b98.isChecked() ? "98" : "0");
        qoc4.put("qb0205c", bi.qb0205c.getText().toString().trim().length() > 0 ? bi.qb0205c.getText().toString() : "0");

        qoc4.put("qb0206a", bi.qb0206aa.isChecked() ? "1" : bi.qb0206ab.isChecked() ? "2" : bi.qb0206a97.isChecked() ? "97" : "0");
        qoc4.put("qb0206b", bi.qb0206ba.isChecked() ? "1" : bi.qb0206bb.isChecked() ? "2" : bi.qb0206b98.isChecked() ? "98" : "0");
        qoc4.put("qb0206c", bi.qb0206c.getText().toString().trim().length() > 0 ? bi.qb0206c.getText().toString() : "0");

        qoc4.put("qb0207a", bi.qb0207aa.isChecked() ? "1" : bi.qb0207ab.isChecked() ? "2" : bi.qb0207a97.isChecked() ? "97" : "0");
        qoc4.put("qb0207b", bi.qb0207ba.isChecked() ? "1" : bi.qb0207bb.isChecked() ? "2" : bi.qb0207b98.isChecked() ? "98" : "0");
        qoc4.put("qb0207c", bi.qb0207c.getText().toString().trim().length() > 0 ? bi.qb0207c.getText().toString() : "0");

        qoc4.put("qb0208a", bi.qb0208aa.isChecked() ? "1" : bi.qb0208ab.isChecked() ? "2" : bi.qb0208a97.isChecked() ? "97" : "0");
        qoc4.put("qb0208b", bi.qb0208ba.isChecked() ? "1" : bi.qb0208bb.isChecked() ? "2" : bi.qb0208b98.isChecked() ? "98" : "0");
        qoc4.put("qb0208c", bi.qb0208c.getText().toString().trim().length() > 0 ? bi.qb0208c.getText().toString() : "0");

        qoc4.put("qb0209a", bi.qb0209aa.isChecked() ? "1" : bi.qb0209ab.isChecked() ? "2" : bi.qb0209a97.isChecked() ? "97" : "0");
        qoc4.put("qb0209b", bi.qb0209ba.isChecked() ? "1" : bi.qb0209bb.isChecked() ? "2" : bi.qb0209b98.isChecked() ? "98" : "0");
        qoc4.put("qb0209c", bi.qb0209c.getText().toString().trim().length() > 0 ? bi.qb0209c.getText().toString() : "0");

        qoc4.put("qb0210a", bi.qb0210aa.isChecked() ? "1" : bi.qb0210ab.isChecked() ? "2" : bi.qb0210a97.isChecked() ? "97" : "0");
        qoc4.put("qb0210b", bi.qb0210ba.isChecked() ? "1" : bi.qb0210bb.isChecked() ? "2" : bi.qb0210b98.isChecked() ? "98" : "0");
        qoc4.put("qb0210c", bi.qb0210c.getText().toString().trim().length() > 0 ? bi.qb0210c.getText().toString() : "0");

        qoc4.put("qb0211a", bi.qb0211aa.isChecked() ? "1" : bi.qb0211ab.isChecked() ? "2" : bi.qb0211a97.isChecked() ? "97" : "0");
        qoc4.put("qb0211b", bi.qb0211ba.isChecked() ? "1" : bi.qb0211bb.isChecked() ? "2" : bi.qb0211b98.isChecked() ? "98" : "0");
        qoc4.put("qb0211c", bi.qb0211c.getText().toString().trim().length() > 0 ? bi.qb0211c.getText().toString() : "0");

        qoc4.put("qb0212a", bi.qb0212aa.isChecked() ? "1" : bi.qb0212ab.isChecked() ? "2" : bi.qb0212a97.isChecked() ? "97" : "0");
        qoc4.put("qb0212b", bi.qb0212ba.isChecked() ? "1" : bi.qb0212bb.isChecked() ? "2" : bi.qb0212b98.isChecked() ? "98" : "0");
        qoc4.put("qb0212c", bi.qb0212c.getText().toString().trim().length() > 0 ? bi.qb0212c.getText().toString() : "0");

        qoc4.put("qb0213a", bi.qb0213aa.isChecked() ? "1" : bi.qb0213ab.isChecked() ? "2" : bi.qb0213a97.isChecked() ? "97" : "0");
        qoc4.put("qb0213b", bi.qb0213ba.isChecked() ? "1" : bi.qb0213bb.isChecked() ? "2" : bi.qb0213b98.isChecked() ? "98" : "0");
        qoc4.put("qb0213c", bi.qb0213c.getText().toString().trim().length() > 0 ? bi.qb0213c.getText().toString() : "0");

        
        
        qoc4.put("qb0301a", bi.qb0301aa.isChecked() ? "1" : bi.qb0301ab.isChecked() ? "2" : bi.qb0301a97.isChecked() ? "97" : "0");
        qoc4.put("qb0301b", bi.qb0301ba.isChecked() ? "1" : bi.qb0301bb.isChecked() ? "2" : bi.qb0301b98.isChecked() ? "98" : "0");
        qoc4.put("qb0301c", bi.qb0301c.getText().toString().trim().length() > 0 ? bi.qb0301c.getText().toString() : "0");

        qoc4.put("qb0302a", bi.qb0302aa.isChecked() ? "1" : bi.qb0302ab.isChecked() ? "2" : bi.qb0302a97.isChecked() ? "97" : "0");
        qoc4.put("qb0302b", bi.qb0302ba.isChecked() ? "1" : bi.qb0302bb.isChecked() ? "2" : bi.qb0302b98.isChecked() ? "98" : "0");
        qoc4.put("qb0302c", bi.qb0302c.getText().toString().trim().length() > 0 ? bi.qb0302c.getText().toString() : "0");

        qoc4.put("qb0303a", bi.qb0303aa.isChecked() ? "1" : bi.qb0303ab.isChecked() ? "2" : bi.qb0303a97.isChecked() ? "97" : "0");
        qoc4.put("qb0303b", bi.qb0303ba.isChecked() ? "1" : bi.qb0303bb.isChecked() ? "2" : bi.qb0303b98.isChecked() ? "98" : "0");
        qoc4.put("qb0303c", bi.qb0303c.getText().toString().trim().length() > 0 ? bi.qb0303c.getText().toString() : "0");

        qoc4.put("qb0304a", bi.qb0304aa.isChecked() ? "1" : bi.qb0304ab.isChecked() ? "2" : bi.qb0304a97.isChecked() ? "97" : "0");
        qoc4.put("qb0304b", bi.qb0304ba.isChecked() ? "1" : bi.qb0304bb.isChecked() ? "2" : bi.qb0304b98.isChecked() ? "98" : "0");
        qoc4.put("qb0304c", bi.qb0304c.getText().toString().trim().length() > 0 ? bi.qb0304c.getText().toString() : "0");

        qoc4.put("qb0305a", bi.qb0305aa.isChecked() ? "1" : bi.qb0305ab.isChecked() ? "2" : bi.qb0305a97.isChecked() ? "97" : "0");
        qoc4.put("qb0305b", bi.qb0305ba.isChecked() ? "1" : bi.qb0305bb.isChecked() ? "2" : bi.qb0305b98.isChecked() ? "98" : "0");
        qoc4.put("qb0305c", bi.qb0305c.getText().toString().trim().length() > 0 ? bi.qb0305c.getText().toString() : "0");


        /*preFix.equals("QOC");
        JSONObject json_qoc1 = GeneratorClass.getContainerJSON(bi.llqoc1, true, preFix);*/

        fc.setSqoc4(String.valueOf(qoc4));

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
