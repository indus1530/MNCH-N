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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc6Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc6 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc6);
        bi.setCallback(this);
        this.setTitle("Quality of Care 06");

        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc7.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc6);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc6 = new JSONObject();

        qoc6.put("qb0408a", bi.qb0408aa.isChecked() ? "1" : bi.qb0408ab.isChecked() ? "2" : bi.qb0408a97.isChecked() ? "97" : "0");
        qoc6.put("qb0408b", bi.qb0408ba.isChecked() ? "1" : bi.qb0408bb.isChecked() ? "2" : bi.qb0408b98.isChecked() ? "98" : "0");
        qoc6.put("qb0408c", bi.qb0408c.getText().toString().trim().length() > 0 ? bi.qb0408c.getText().toString() : "0");

        qoc6.put("qb0409a", bi.qb0409aa.isChecked() ? "1" : bi.qb0409ab.isChecked() ? "2" : bi.qb0409a97.isChecked() ? "97" : "0");
        qoc6.put("qb0409b", bi.qb0409ba.isChecked() ? "1" : bi.qb0409bb.isChecked() ? "2" : bi.qb0409b98.isChecked() ? "98" : "0");
        qoc6.put("qb0409c", bi.qb0409c.getText().toString().trim().length() > 0 ? bi.qb0409c.getText().toString() : "0");

        qoc6.put("qb0410a", bi.qb0410aa.isChecked() ? "1" : bi.qb0410ab.isChecked() ? "2" : bi.qb0410a97.isChecked() ? "97" : "0");
        qoc6.put("qb0410b", bi.qb0410ba.isChecked() ? "1" : bi.qb0410bb.isChecked() ? "2" : bi.qb0410b98.isChecked() ? "98" : "0");
        qoc6.put("qb0410c", bi.qb0410c.getText().toString().trim().length() > 0 ? bi.qb0410c.getText().toString() : "0");

        qoc6.put("qb0411a", bi.qb0411aa.isChecked() ? "1" : bi.qb0411ab.isChecked() ? "2" : bi.qb0411a97.isChecked() ? "97" : "0");
        qoc6.put("qb0411b", bi.qb0411ba.isChecked() ? "1" : bi.qb0411bb.isChecked() ? "2" : bi.qb0411b98.isChecked() ? "98" : "0");
        qoc6.put("qb0411c", bi.qb0411c.getText().toString().trim().length() > 0 ? bi.qb0411c.getText().toString() : "0");

        qoc6.put("qb0412a", bi.qb0412aa.isChecked() ? "1" : bi.qb0412ab.isChecked() ? "2" : bi.qb0412a97.isChecked() ? "97" : "0");
        qoc6.put("qb0412b", bi.qb0412ba.isChecked() ? "1" : bi.qb0412bb.isChecked() ? "2" : bi.qb0412b98.isChecked() ? "98" : "0");
        qoc6.put("qb0412c", bi.qb0412c.getText().toString().trim().length() > 0 ? bi.qb0412c.getText().toString() : "0");

        qoc6.put("qb0413a", bi.qb0413aa.isChecked() ? "1" : bi.qb0413ab.isChecked() ? "2" : bi.qb0413a97.isChecked() ? "97" : "0");
        qoc6.put("qb0413b", bi.qb0413ba.isChecked() ? "1" : bi.qb0413bb.isChecked() ? "2" : bi.qb0413b98.isChecked() ? "98" : "0");
        qoc6.put("qb0413c", bi.qb0413c.getText().toString().trim().length() > 0 ? bi.qb0413c.getText().toString() : "0");




        qoc6.put("qc0101a", bi.qc0101aa.isChecked() ? "1" : bi.qc0101ab.isChecked() ? "2" : "0");
        qoc6.put("qc0101b", bi.qc0101ba.isChecked() ? "1" : bi.qc0101bb.isChecked() ? "2" : bi.qc0101bc.isChecked() ? "3" : "0");
        qoc6.put("qc0101c", bi.qc0101c.getText().toString().trim().length() > 0 ? bi.qc0101c.getText().toString() : "0");
        qoc6.put("qc0101d", bi.qc0101d.getText().toString().trim().length() > 0 ? bi.qc0101d.getText().toString() : "0");

        qoc6.put("qc0201a", bi.qc0201aa.isChecked() ? "1" : bi.qc0201ab.isChecked() ? "2" : "0");
        qoc6.put("qc0201b", bi.qc0201ba.isChecked() ? "1" : bi.qc0201bb.isChecked() ? "2" : bi.qc0201bc.isChecked() ? "3" : "0");
        qoc6.put("qc0201c", bi.qc0201c.getText().toString().trim().length() > 0 ? bi.qc0201c.getText().toString() : "0");
        qoc6.put("qc0201d", bi.qc0201d.getText().toString().trim().length() > 0 ? bi.qc0201d.getText().toString() : "0");

        qoc6.put("qc0301a", bi.qc0301aa.isChecked() ? "1" : bi.qc0301ab.isChecked() ? "2" : "0");
        qoc6.put("qc0301b", bi.qc0301ba.isChecked() ? "1" : bi.qc0301bb.isChecked() ? "2" : bi.qc0301bc.isChecked() ? "3" : "0");
        qoc6.put("qc0301c", bi.qc0301c.getText().toString().trim().length() > 0 ? bi.qc0301c.getText().toString() : "0");
        qoc6.put("qc0301d", bi.qc0301d.getText().toString().trim().length() > 0 ? bi.qc0301d.getText().toString() : "0");

        
        
        qoc6.put("qc0401a", bi.qc0401aa.isChecked() ? "1" : bi.qc0401ab.isChecked() ? "2" : "0");
        qoc6.put("qc0401b", bi.qc0401ba.isChecked() ? "1" : bi.qc0401bb.isChecked() ? "2" : bi.qc0401bc.isChecked() ? "3" : "0");
        qoc6.put("qc0401c", bi.qc0401c.getText().toString().trim().length() > 0 ? bi.qc0401c.getText().toString() : "0");
        qoc6.put("qc0401d", bi.qc0401d.getText().toString().trim().length() > 0 ? bi.qc0401d.getText().toString() : "0");

        qoc6.put("qc0402a", bi.qc0402aa.isChecked() ? "1" : bi.qc0402ab.isChecked() ? "2" : "0");
        qoc6.put("qc0402b", bi.qc0402ba.isChecked() ? "1" : bi.qc0402bb.isChecked() ? "2" : bi.qc0402bc.isChecked() ? "3" : "0");
        qoc6.put("qc0402c", bi.qc0402c.getText().toString().trim().length() > 0 ? bi.qc0402c.getText().toString() : "0");
        qoc6.put("qc0402d", bi.qc0402d.getText().toString().trim().length() > 0 ? bi.qc0402d.getText().toString() : "0");

        qoc6.put("qc0403a", bi.qc0403aa.isChecked() ? "1" : bi.qc0403ab.isChecked() ? "2" : "0");
        qoc6.put("qc0403b", bi.qc0403ba.isChecked() ? "1" : bi.qc0403bb.isChecked() ? "2" : bi.qc0403bc.isChecked() ? "3" : "0");
        qoc6.put("qc0403c", bi.qc0403c.getText().toString().trim().length() > 0 ? bi.qc0403c.getText().toString() : "0");
        qoc6.put("qc0403d", bi.qc0403d.getText().toString().trim().length() > 0 ? bi.qc0403d.getText().toString() : "0");

        qoc6.put("qc0404a", bi.qc0404aa.isChecked() ? "1" : bi.qc0404ab.isChecked() ? "2" : "0");
        qoc6.put("qc0404b", bi.qc0404ba.isChecked() ? "1" : bi.qc0404bb.isChecked() ? "2" : bi.qc0404bc.isChecked() ? "3" : "0");
        qoc6.put("qc0404c", bi.qc0404c.getText().toString().trim().length() > 0 ? bi.qc0404c.getText().toString() : "0");
        qoc6.put("qc0404d", bi.qc0404d.getText().toString().trim().length() > 0 ? bi.qc0404d.getText().toString() : "0");

        qoc6.put("qc0405a", bi.qc0405aa.isChecked() ? "1" : bi.qc0405ab.isChecked() ? "2" : "0");
        qoc6.put("qc0405b", bi.qc0405ba.isChecked() ? "1" : bi.qc0405bb.isChecked() ? "2" : bi.qc0405bc.isChecked() ? "3" : "0");
        qoc6.put("qc0405c", bi.qc0405c.getText().toString().trim().length() > 0 ? bi.qc0405c.getText().toString() : "0");
        qoc6.put("qc0405d", bi.qc0405d.getText().toString().trim().length() > 0 ? bi.qc0405d.getText().toString() : "0");

        qoc6.put("qc0406a", bi.qc0406aa.isChecked() ? "1" : bi.qc0406ab.isChecked() ? "2" : "0");
        qoc6.put("qc0406b", bi.qc0406ba.isChecked() ? "1" : bi.qc0406bb.isChecked() ? "2" : bi.qc0406bc.isChecked() ? "3" : "0");
        qoc6.put("qc0406c", bi.qc0406c.getText().toString().trim().length() > 0 ? bi.qc0406c.getText().toString() : "0");
        qoc6.put("qc0406d", bi.qc0406d.getText().toString().trim().length() > 0 ? bi.qc0406d.getText().toString() : "0");



        qoc6.put("qc0501a", bi.qc0501aa.isChecked() ? "1" : bi.qc0501ab.isChecked() ? "2" : "0");
        qoc6.put("qc0501b", bi.qc0501ba.isChecked() ? "1" : bi.qc0501bb.isChecked() ? "2" : bi.qc0501bc.isChecked() ? "3" : "0");
        qoc6.put("qc0501c", bi.qc0501c.getText().toString().trim().length() > 0 ? bi.qc0501c.getText().toString() : "0");
        qoc6.put("qc0501d", bi.qc0501d.getText().toString().trim().length() > 0 ? bi.qc0501d.getText().toString() : "0");

        qoc6.put("qc0502a", bi.qc0502aa.isChecked() ? "1" : bi.qc0502ab.isChecked() ? "2" : "0");
        qoc6.put("qc0502b", bi.qc0502ba.isChecked() ? "1" : bi.qc0502bb.isChecked() ? "2" : bi.qc0502bc.isChecked() ? "3" : "0");
        qoc6.put("qc0502c", bi.qc0502c.getText().toString().trim().length() > 0 ? bi.qc0502c.getText().toString() : "0");
        qoc6.put("qc0502d", bi.qc0502d.getText().toString().trim().length() > 0 ? bi.qc0502d.getText().toString() : "0");


        qoc6.put("qc0601a", bi.qc0601aa.isChecked() ? "1" : bi.qc0601ab.isChecked() ? "2" : "0");
        qoc6.put("qc0601b", bi.qc0601ba.isChecked() ? "1" : bi.qc0601bb.isChecked() ? "2" : bi.qc0601bc.isChecked() ? "3" : "0");
        qoc6.put("qc0601c", bi.qc0601c.getText().toString().trim().length() > 0 ? bi.qc0601c.getText().toString() : "0");
        qoc6.put("qc0601d", bi.qc0601d.getText().toString().trim().length() > 0 ? bi.qc0601d.getText().toString() : "0");

        qoc6.put("qc0701a", bi.qc0701aa.isChecked() ? "1" : bi.qc0701ab.isChecked() ? "2" : "0");
        qoc6.put("qc0701b", bi.qc0701ba.isChecked() ? "1" : bi.qc0701bb.isChecked() ? "2" : bi.qc0701bc.isChecked() ? "3" : "0");
        qoc6.put("qc0701c", bi.qc0701c.getText().toString().trim().length() > 0 ? bi.qc0701c.getText().toString() : "0");
        qoc6.put("qc0701d", bi.qc0701d.getText().toString().trim().length() > 0 ? bi.qc0701d.getText().toString() : "0");



        qoc6.put("qc0801a", bi.qc0801aa.isChecked() ? "1" : bi.qc0801ab.isChecked() ? "2" : "0");
        qoc6.put("qc0801b", bi.qc0801ba.isChecked() ? "1" : bi.qc0801bb.isChecked() ? "2" : bi.qc0801bc.isChecked() ? "3" : "0");
        qoc6.put("qc0801c", bi.qc0801c.getText().toString().trim().length() > 0 ? bi.qc0801c.getText().toString() : "0");
        qoc6.put("qc0801d", bi.qc0801d.getText().toString().trim().length() > 0 ? bi.qc0801d.getText().toString() : "0");

        qoc6.put("qc0802a", bi.qc0802aa.isChecked() ? "1" : bi.qc0802ab.isChecked() ? "2" : "0");
        qoc6.put("qc0802b", bi.qc0802ba.isChecked() ? "1" : bi.qc0802bb.isChecked() ? "2" : bi.qc0802bc.isChecked() ? "3" : "0");
        qoc6.put("qc0802c", bi.qc0802c.getText().toString().trim().length() > 0 ? bi.qc0802c.getText().toString() : "0");
        qoc6.put("qc0802d", bi.qc0802d.getText().toString().trim().length() > 0 ? bi.qc0802d.getText().toString() : "0");

        qoc6.put("qc0803a", bi.qc0803aa.isChecked() ? "1" : bi.qc0803ab.isChecked() ? "2" : "0");
        qoc6.put("qc0803b", bi.qc0803ba.isChecked() ? "1" : bi.qc0803bb.isChecked() ? "2" : bi.qc0803bc.isChecked() ? "3" : "0");
        qoc6.put("qc0803c", bi.qc0803c.getText().toString().trim().length() > 0 ? bi.qc0803c.getText().toString() : "0");
        qoc6.put("qc0803d", bi.qc0803d.getText().toString().trim().length() > 0 ? bi.qc0803d.getText().toString() : "0");

        qoc6.put("qc0804a", bi.qc0804aa.isChecked() ? "1" : bi.qc0804ab.isChecked() ? "2" : "0");
        qoc6.put("qc0804b", bi.qc0804ba.isChecked() ? "1" : bi.qc0804bb.isChecked() ? "2" : bi.qc0804bc.isChecked() ? "3" : "0");
        qoc6.put("qc0804c", bi.qc0804c.getText().toString().trim().length() > 0 ? bi.qc0804c.getText().toString() : "0");
        qoc6.put("qc0804d", bi.qc0804d.getText().toString().trim().length() > 0 ? bi.qc0804d.getText().toString() : "0");

        qoc6.put("qc0805a", bi.qc0805aa.isChecked() ? "1" : bi.qc0805ab.isChecked() ? "2" : "0");
        qoc6.put("qc0805b", bi.qc0805ba.isChecked() ? "1" : bi.qc0805bb.isChecked() ? "2" : bi.qc0805bc.isChecked() ? "3" : "0");
        qoc6.put("qc0805c", bi.qc0805c.getText().toString().trim().length() > 0 ? bi.qc0805c.getText().toString() : "0");
        qoc6.put("qc0805d", bi.qc0805d.getText().toString().trim().length() > 0 ? bi.qc0805d.getText().toString() : "0");

        qoc6.put("qc0806a", bi.qc0806aa.isChecked() ? "1" : bi.qc0806ab.isChecked() ? "2" : "0");
        qoc6.put("qc0806b", bi.qc0806ba.isChecked() ? "1" : bi.qc0806bb.isChecked() ? "2" : bi.qc0806bc.isChecked() ? "3" : "0");
        qoc6.put("qc0806c", bi.qc0806c.getText().toString().trim().length() > 0 ? bi.qc0806c.getText().toString() : "0");
        qoc6.put("qc0806d", bi.qc0806d.getText().toString().trim().length() > 0 ? bi.qc0806d.getText().toString() : "0");

        qoc6.put("qc0807a", bi.qc0807aa.isChecked() ? "1" : bi.qc0807ab.isChecked() ? "2" : "0");
        qoc6.put("qc0807b", bi.qc0807ba.isChecked() ? "1" : bi.qc0807bb.isChecked() ? "2" : bi.qc0807bc.isChecked() ? "3" : "0");
        qoc6.put("qc0807c", bi.qc0807c.getText().toString().trim().length() > 0 ? bi.qc0807c.getText().toString() : "0");
        qoc6.put("qc0807d", bi.qc0807d.getText().toString().trim().length() > 0 ? bi.qc0807d.getText().toString() : "0");
        

        fc.setSqoc6(String.valueOf(qoc6));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qb0408aa.isChecked()){
            bi.qb0408b.clearCheck();
            bi.qb0408c.setEnabled(false);
        } else {
            bi.qb0408c.setEnabled(true);
        }

        if (!bi.qb0409aa.isChecked()){
            bi.qb0409b.clearCheck();
            bi.qb0409c.setEnabled(false);
        } else {
            bi.qb0409c.setEnabled(true);
        }

        if (!bi.qb0410aa.isChecked()){
            bi.qb0410b.clearCheck();
            bi.qb0410c.setEnabled(false);
        } else {
            bi.qb0410c.setEnabled(true);
        }

        if (!bi.qb0411aa.isChecked()){
            bi.qb0411b.clearCheck();
            bi.qb0411c.setEnabled(false);
        } else {
            bi.qb0411c.setEnabled(true);
        }

        if (!bi.qb0412aa.isChecked()){
            bi.qb0412b.clearCheck();
            bi.qb0412c.setEnabled(false);
        } else {
            bi.qb0412c.setEnabled(true);
        }

        if (!bi.qb0413aa.isChecked()){
            bi.qb0413b.clearCheck();
            bi.qb0413c.setEnabled(false);
        } else {
            bi.qb0413c.setEnabled(true);
        }


        if (!bi.qc0101aa.isChecked()){
            bi.qc0101b.clearCheck();
            bi.qc0101c.setEnabled(true);
        } else {
            bi.qc0101c.setEnabled(false);
        }

        if (!bi.qc0201aa.isChecked()){
            bi.qc0201b.clearCheck();
            bi.qc0201c.setEnabled(true);
        } else {
            bi.qc0201c.setEnabled(false);
        }

        if (!bi.qc0301aa.isChecked()){
            bi.qc0301b.clearCheck();
            bi.qc0301c.setEnabled(true);
        } else {
            bi.qc0301c.setEnabled(false);
        }

        if (!bi.qc0401aa.isChecked()){
            bi.qc0401b.clearCheck();
            bi.qc0401c.setEnabled(true);
        } else {
            bi.qc0401c.setEnabled(false);
        }

        if (!bi.qc0402aa.isChecked()){
            bi.qc0402b.clearCheck();
            bi.qc0402c.setEnabled(true);
        } else {
            bi.qc0402c.setEnabled(false);
        }

        if (!bi.qc0403aa.isChecked()){
            bi.qc0403b.clearCheck();
            bi.qc0403c.setEnabled(true);
        } else {
            bi.qc0403c.setEnabled(false);
        }

        if (!bi.qc0404aa.isChecked()){
            bi.qc0404b.clearCheck();
            bi.qc0404c.setEnabled(true);
        } else {
            bi.qc0404c.setEnabled(false);
        }

        if (!bi.qc0405aa.isChecked()){
            bi.qc0405b.clearCheck();
            bi.qc0405c.setEnabled(true);
        } else {
            bi.qc0405c.setEnabled(false);
        }

        if (!bi.qc0406aa.isChecked()){
            bi.qc0406b.clearCheck();
            bi.qc0406c.setEnabled(true);
        } else {
            bi.qc0406c.setEnabled(false);
        }


        if (!bi.qc0501aa.isChecked()){
            bi.qc0501b.clearCheck();
            bi.qc0501c.setEnabled(true);
        } else {
            bi.qc0501c.setEnabled(false);
        }

        if (!bi.qc0502aa.isChecked()){
            bi.qc0502b.clearCheck();
            bi.qc0502c.setEnabled(true);
        } else {
            bi.qc0502c.setEnabled(false);
        }


        if (!bi.qc0601aa.isChecked()){
            bi.qc0601b.clearCheck();
            bi.qc0601c.setEnabled(true);
        } else {
            bi.qc0601c.setEnabled(false);
        }


        if (!bi.qc0701aa.isChecked()){
            bi.qc0701b.clearCheck();
            bi.qc0701c.setEnabled(true);
        } else {
            bi.qc0701c.setEnabled(false);
        }


        if (!bi.qc0801aa.isChecked()){
            bi.qc0801b.clearCheck();
            bi.qc0801c.setEnabled(true);
        } else {
            bi.qc0801c.setEnabled(false);
        }

        if (!bi.qc0802aa.isChecked()){
            bi.qc0802b.clearCheck();
            bi.qc0802c.setEnabled(true);
        } else {
            bi.qc0802c.setEnabled(false);
        }

        if (!bi.qc0803aa.isChecked()){
            bi.qc0803b.clearCheck();
            bi.qc0803c.setEnabled(true);
        } else {
            bi.qc0803c.setEnabled(false);
        }

        if (!bi.qc0804aa.isChecked()){
            bi.qc0804b.clearCheck();
            bi.qc0804c.setEnabled(true);
        } else {
            bi.qc0804c.setEnabled(false);
        }

        if (!bi.qc0805aa.isChecked()){
            bi.qc0805b.clearCheck();
            bi.qc0805c.setEnabled(true);
        } else {
            bi.qc0805c.setEnabled(false);
        }

        if (!bi.qc0806aa.isChecked()){
            bi.qc0806b.clearCheck();
            bi.qc0806c.setEnabled(true);
        } else {
            bi.qc0806c.setEnabled(false);
        }

        if (!bi.qc0807aa.isChecked()){
            bi.qc0807b.clearCheck();
            bi.qc0807c.setEnabled(true);
        } else {
            bi.qc0807c.setEnabled(false);
        }

    }


    void events_call() {
        
        bi.qb0408a.setOnCheckedChangeListener(this);
        bi.qb0409a.setOnCheckedChangeListener(this);
        bi.qb0410a.setOnCheckedChangeListener(this);
        bi.qb0411a.setOnCheckedChangeListener(this);
        bi.qb0412a.setOnCheckedChangeListener(this);
        bi.qb0413a.setOnCheckedChangeListener(this);

        bi.qc0101a.setOnCheckedChangeListener(this);

        bi.qc0201a.setOnCheckedChangeListener(this);

        bi.qc0301a.setOnCheckedChangeListener(this);

        bi.qc0401a.setOnCheckedChangeListener(this);
        bi.qc0402a.setOnCheckedChangeListener(this);
        bi.qc0403a.setOnCheckedChangeListener(this);
        bi.qc0404a.setOnCheckedChangeListener(this);
        bi.qc0405a.setOnCheckedChangeListener(this);
        bi.qc0406a.setOnCheckedChangeListener(this);

        bi.qc0501a.setOnCheckedChangeListener(this);
        bi.qc0502a.setOnCheckedChangeListener(this);

        bi.qc0601a.setOnCheckedChangeListener(this);

        bi.qc0701a.setOnCheckedChangeListener(this);

        bi.qc0801a.setOnCheckedChangeListener(this);
        bi.qc0802a.setOnCheckedChangeListener(this);
        bi.qc0803a.setOnCheckedChangeListener(this);
        bi.qc0804a.setOnCheckedChangeListener(this);
        bi.qc0805a.setOnCheckedChangeListener(this);
        bi.qc0806a.setOnCheckedChangeListener(this);
        bi.qc0807a.setOnCheckedChangeListener(this);
    }
}
