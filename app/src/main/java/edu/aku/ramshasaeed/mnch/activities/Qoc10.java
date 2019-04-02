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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc10Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc10 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc10Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc10);
        bi.setCallback(this);
        this.setTitle("Quality of Care 10");
        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc10);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc10 = new JSONObject();

        qoc10.put("qd0301a", bi.qd0301aa.isChecked() ? "1" : bi.qd0301ab.isChecked() ? "2" : "0");
        qoc10.put("qd0301b", bi.qd0301ba.isChecked() ? "1" : bi.qd0301bb.isChecked() ? "2" : bi.qd0301bc.isChecked() ? "3" : "0");
        qoc10.put("qd0301c", bi.qd0301c.getText().toString().trim().length() > 0 ? bi.qd0301c.getText().toString() : "0");
        qoc10.put("qd0301d", bi.qd0301d.getText().toString().trim().length() > 0 ? bi.qd0301d.getText().toString() : "0");

        qoc10.put("qd0302a", bi.qd0302aa.isChecked() ? "1" : bi.qd0302ab.isChecked() ? "2" : "0");
        qoc10.put("qd0302b", bi.qd0302ba.isChecked() ? "1" : bi.qd0302bb.isChecked() ? "2" : bi.qd0302bc.isChecked() ? "3" : "0");
        qoc10.put("qd0302c", bi.qd0302c.getText().toString().trim().length() > 0 ? bi.qd0302c.getText().toString() : "0");
        qoc10.put("qd0302d", bi.qd0302d.getText().toString().trim().length() > 0 ? bi.qd0302d.getText().toString() : "0");

        qoc10.put("qd0303a", bi.qd0303aa.isChecked() ? "1" : bi.qd0303ab.isChecked() ? "2" : "0");
        qoc10.put("qd0303b", bi.qd0303ba.isChecked() ? "1" : bi.qd0303bb.isChecked() ? "2" : bi.qd0303bc.isChecked() ? "3" : "0");
        qoc10.put("qd0303c", bi.qd0303c.getText().toString().trim().length() > 0 ? bi.qd0303c.getText().toString() : "0");
        qoc10.put("qd0303d", bi.qd0303d.getText().toString().trim().length() > 0 ? bi.qd0303d.getText().toString() : "0");

        qoc10.put("qd0304a", bi.qd0304aa.isChecked() ? "1" : bi.qd0304ab.isChecked() ? "2" : "0");
        qoc10.put("qd0304b", bi.qd0304ba.isChecked() ? "1" : bi.qd0304bb.isChecked() ? "2" : bi.qd0304bc.isChecked() ? "3" : "0");
        qoc10.put("qd0304c", bi.qd0304c.getText().toString().trim().length() > 0 ? bi.qd0304c.getText().toString() : "0");
        qoc10.put("qd0304d", bi.qd0304d.getText().toString().trim().length() > 0 ? bi.qd0304d.getText().toString() : "0");

        qoc10.put("qd0305a", bi.qd0305aa.isChecked() ? "1" : bi.qd0305ab.isChecked() ? "2" : "0");
        qoc10.put("qd0305b", bi.qd0305ba.isChecked() ? "1" : bi.qd0305bb.isChecked() ? "2" : bi.qd0305bc.isChecked() ? "3" : "0");
        qoc10.put("qd0305c", bi.qd0305c.getText().toString().trim().length() > 0 ? bi.qd0305c.getText().toString() : "0");
        qoc10.put("qd0305d", bi.qd0305d.getText().toString().trim().length() > 0 ? bi.qd0305d.getText().toString() : "0");


        qoc10.put("qd0401a", bi.qd0401aa.isChecked() ? "1" : bi.qd0401ab.isChecked() ? "2" : "0");
        qoc10.put("qd0401b", bi.qd0401ba.isChecked() ? "1" : bi.qd0401bb.isChecked() ? "2" : bi.qd0401bc.isChecked() ? "3" : "0");
        qoc10.put("qd0401c", bi.qd0401c.getText().toString().trim().length() > 0 ? bi.qd0401c.getText().toString() : "0");
        qoc10.put("qd0401d", bi.qd0401d.getText().toString().trim().length() > 0 ? bi.qd0401d.getText().toString() : "0");

        qoc10.put("qd0402a", bi.qd0402aa.isChecked() ? "1" : bi.qd0402ab.isChecked() ? "2" : "0");
        qoc10.put("qd0402b", bi.qd0402ba.isChecked() ? "1" : bi.qd0402bb.isChecked() ? "2" : bi.qd0402bc.isChecked() ? "3" : "0");
        qoc10.put("qd0402c", bi.qd0402c.getText().toString().trim().length() > 0 ? bi.qd0402c.getText().toString() : "0");
        qoc10.put("qd0402d", bi.qd0402d.getText().toString().trim().length() > 0 ? bi.qd0402d.getText().toString() : "0");

        qoc10.put("qd0403a", bi.qd0403aa.isChecked() ? "1" : bi.qd0403ab.isChecked() ? "2" : "0");
        qoc10.put("qd0403b", bi.qd0403ba.isChecked() ? "1" : bi.qd0403bb.isChecked() ? "2" : bi.qd0403bc.isChecked() ? "3" : "0");
        qoc10.put("qd0403c", bi.qd0403c.getText().toString().trim().length() > 0 ? bi.qd0403c.getText().toString() : "0");
        qoc10.put("qd0403d", bi.qd0403d.getText().toString().trim().length() > 0 ? bi.qd0403d.getText().toString() : "0");

        qoc10.put("qd0404a", bi.qd0404aa.isChecked() ? "1" : bi.qd0404ab.isChecked() ? "2" : "0");
        qoc10.put("qd0404b", bi.qd0404ba.isChecked() ? "1" : bi.qd0404bb.isChecked() ? "2" : bi.qd0404bc.isChecked() ? "3" : "0");
        qoc10.put("qd0404c", bi.qd0404c.getText().toString().trim().length() > 0 ? bi.qd0404c.getText().toString() : "0");
        qoc10.put("qd0404d", bi.qd0404d.getText().toString().trim().length() > 0 ? bi.qd0404d.getText().toString() : "0");


        qoc10.put("qd0501a", bi.qd0501aa.isChecked() ? "1" : bi.qd0501ab.isChecked() ? "2" : "0");
        qoc10.put("qd0501b", bi.qd0501ba.isChecked() ? "1" : bi.qd0501bb.isChecked() ? "2" : bi.qd0501bc.isChecked() ? "3" : "0");
        qoc10.put("qd0501c", bi.qd0501c.getText().toString().trim().length() > 0 ? bi.qd0501c.getText().toString() : "0");
        qoc10.put("qd0501d", bi.qd0501d.getText().toString().trim().length() > 0 ? bi.qd0501d.getText().toString() : "0");

        qoc10.put("qd0502a", bi.qd0502aa.isChecked() ? "1" : bi.qd0502ab.isChecked() ? "2" : "0");
        qoc10.put("qd0502b", bi.qd0502ba.isChecked() ? "1" : bi.qd0502bb.isChecked() ? "2" : bi.qd0502bc.isChecked() ? "3" : "0");
        qoc10.put("qd0502c", bi.qd0502c.getText().toString().trim().length() > 0 ? bi.qd0502c.getText().toString() : "0");
        qoc10.put("qd0502d", bi.qd0502d.getText().toString().trim().length() > 0 ? bi.qd0502d.getText().toString() : "0");

        qoc10.put("qd0503a", bi.qd0503aa.isChecked() ? "1" : bi.qd0503ab.isChecked() ? "2" : "0");
        qoc10.put("qd0503b", bi.qd0503ba.isChecked() ? "1" : bi.qd0503bb.isChecked() ? "2" : bi.qd0503bc.isChecked() ? "3" : "0");
        qoc10.put("qd0503c", bi.qd0503c.getText().toString().trim().length() > 0 ? bi.qd0503c.getText().toString() : "0");
        qoc10.put("qd0503d", bi.qd0503d.getText().toString().trim().length() > 0 ? bi.qd0503d.getText().toString() : "0");


        qoc10.put("qd0601a", bi.qd0601aa.isChecked() ? "1" : bi.qd0601ab.isChecked() ? "2" : "0");
        qoc10.put("qd0601b", bi.qd0601ba.isChecked() ? "1" : bi.qd0601bb.isChecked() ? "2" : bi.qd0601bc.isChecked() ? "3" : "0");
        qoc10.put("qd0601c", bi.qd0601c.getText().toString().trim().length() > 0 ? bi.qd0601c.getText().toString() : "0");
        qoc10.put("qd0601d", bi.qd0601d.getText().toString().trim().length() > 0 ? bi.qd0601d.getText().toString() : "0");

        qoc10.put("qd0602a", bi.qd0602aa.isChecked() ? "1" : bi.qd0602ab.isChecked() ? "2" : "0");
        qoc10.put("qd0602b", bi.qd0602ba.isChecked() ? "1" : bi.qd0602bb.isChecked() ? "2" : bi.qd0602bc.isChecked() ? "3" : "0");
        qoc10.put("qd0602c", bi.qd0602c.getText().toString().trim().length() > 0 ? bi.qd0602c.getText().toString() : "0");
        qoc10.put("qd0602d", bi.qd0602d.getText().toString().trim().length() > 0 ? bi.qd0602d.getText().toString() : "0");

        qoc10.put("qd0603a", bi.qd0603aa.isChecked() ? "1" : bi.qd0603ab.isChecked() ? "2" : "0");
        qoc10.put("qd0603b", bi.qd0603ba.isChecked() ? "1" : bi.qd0603bb.isChecked() ? "2" : bi.qd0603bc.isChecked() ? "3" : "0");
        qoc10.put("qd0603c", bi.qd0603c.getText().toString().trim().length() > 0 ? bi.qd0603c.getText().toString() : "0");
        qoc10.put("qd0603d", bi.qd0603d.getText().toString().trim().length() > 0 ? bi.qd0603d.getText().toString() : "0");

        qoc10.put("qd0604a", bi.qd0604aa.isChecked() ? "1" : bi.qd0604ab.isChecked() ? "2" : "0");
        qoc10.put("qd0604b", bi.qd0604ba.isChecked() ? "1" : bi.qd0604bb.isChecked() ? "2" : bi.qd0604bc.isChecked() ? "3" : "0");
        qoc10.put("qd0604c", bi.qd0604c.getText().toString().trim().length() > 0 ? bi.qd0604c.getText().toString() : "0");
        qoc10.put("qd0604d", bi.qd0604d.getText().toString().trim().length() > 0 ? bi.qd0604d.getText().toString() : "0");


        qoc10.put("qd0701a", bi.qd0701aa.isChecked() ? "1" : bi.qd0701ab.isChecked() ? "2" : "0");
        qoc10.put("qd0701b", bi.qd0701ba.isChecked() ? "1" : bi.qd0701bb.isChecked() ? "2" : bi.qd0701bc.isChecked() ? "3" : "0");
        qoc10.put("qd0701c", bi.qd0701c.getText().toString().trim().length() > 0 ? bi.qd0701c.getText().toString() : "0");
        qoc10.put("qd0701d", bi.qd0701d.getText().toString().trim().length() > 0 ? bi.qd0701d.getText().toString() : "0");

        qoc10.put("qd0702a", bi.qd0702aa.isChecked() ? "1" : bi.qd0702ab.isChecked() ? "2" : "0");
        qoc10.put("qd0702b", bi.qd0702ba.isChecked() ? "1" : bi.qd0702bb.isChecked() ? "2" : bi.qd0702bc.isChecked() ? "3" : "0");
        qoc10.put("qd0702c", bi.qd0702c.getText().toString().trim().length() > 0 ? bi.qd0702c.getText().toString() : "0");
        qoc10.put("qd0702d", bi.qd0702d.getText().toString().trim().length() > 0 ? bi.qd0702d.getText().toString() : "0");

        qoc10.put("qd0703a", bi.qd0703aa.isChecked() ? "1" : bi.qd0703ab.isChecked() ? "2" : "0");
        qoc10.put("qd0703b", bi.qd0703ba.isChecked() ? "1" : bi.qd0703bb.isChecked() ? "2" : bi.qd0703bc.isChecked() ? "3" : "0");
        qoc10.put("qd0703c", bi.qd0703c.getText().toString().trim().length() > 0 ? bi.qd0703c.getText().toString() : "0");
        qoc10.put("qd0703d", bi.qd0703d.getText().toString().trim().length() > 0 ? bi.qd0703d.getText().toString() : "0");

        qoc10.put("qd0704a", bi.qd0704aa.isChecked() ? "1" : bi.qd0704ab.isChecked() ? "2" : "0");
        qoc10.put("qd0704b", bi.qd0704ba.isChecked() ? "1" : bi.qd0704bb.isChecked() ? "2" : bi.qd0704bc.isChecked() ? "3" : "0");
        qoc10.put("qd0704c", bi.qd0704c.getText().toString().trim().length() > 0 ? bi.qd0704c.getText().toString() : "0");
        qoc10.put("qd0704d", bi.qd0704d.getText().toString().trim().length() > 0 ? bi.qd0704d.getText().toString() : "0");

        qoc10.put("qd0705a", bi.qd0705aa.isChecked() ? "1" : bi.qd0705ab.isChecked() ? "2" : "0");
        qoc10.put("qd0705b", bi.qd0705ba.isChecked() ? "1" : bi.qd0705bb.isChecked() ? "2" : bi.qd0705bc.isChecked() ? "3" : "0");
        qoc10.put("qd0705c", bi.qd0705c.getText().toString().trim().length() > 0 ? bi.qd0705c.getText().toString() : "0");
        qoc10.put("qd0705d", bi.qd0705d.getText().toString().trim().length() > 0 ? bi.qd0705d.getText().toString() : "0");

        qoc10.put("qd0706a", bi.qd0706aa.isChecked() ? "1" : bi.qd0706ab.isChecked() ? "2" : "0");
        qoc10.put("qd0706b", bi.qd0706ba.isChecked() ? "1" : bi.qd0706bb.isChecked() ? "2" : bi.qd0706bc.isChecked() ? "3" : "0");
        qoc10.put("qd0706c", bi.qd0706c.getText().toString().trim().length() > 0 ? bi.qd0706c.getText().toString() : "0");
        qoc10.put("qd0706d", bi.qd0706d.getText().toString().trim().length() > 0 ? bi.qd0706d.getText().toString() : "0");

        qoc10.put("qd0707a", bi.qd0707aa.isChecked() ? "1" : bi.qd0707ab.isChecked() ? "2" : "0");
        qoc10.put("qd0707b", bi.qd0707ba.isChecked() ? "1" : bi.qd0707bb.isChecked() ? "2" : bi.qd0707bc.isChecked() ? "3" : "0");
        qoc10.put("qd0707c", bi.qd0707c.getText().toString().trim().length() > 0 ? bi.qd0707c.getText().toString() : "0");
        qoc10.put("qd0707d", bi.qd0707d.getText().toString().trim().length() > 0 ? bi.qd0707d.getText().toString() : "0");

        qoc10.put("qd0708a", bi.qd0708aa.isChecked() ? "1" : bi.qd0708ab.isChecked() ? "2" : "0");
        qoc10.put("qd0708b", bi.qd0708ba.isChecked() ? "1" : bi.qd0708bb.isChecked() ? "2" : bi.qd0708bc.isChecked() ? "3" : "0");
        qoc10.put("qd0708c", bi.qd0708c.getText().toString().trim().length() > 0 ? bi.qd0708c.getText().toString() : "0");
        qoc10.put("qd0708d", bi.qd0708d.getText().toString().trim().length() > 0 ? bi.qd0708d.getText().toString() : "0");

        qoc10.put("qd0709a", bi.qd0709aa.isChecked() ? "1" : bi.qd0709ab.isChecked() ? "2" : "0");
        qoc10.put("qd0709b", bi.qd0709ba.isChecked() ? "1" : bi.qd0709bb.isChecked() ? "2" : bi.qd0709bc.isChecked() ? "3" : "0");
        qoc10.put("qd0709c", bi.qd0709c.getText().toString().trim().length() > 0 ? bi.qd0709c.getText().toString() : "0");
        qoc10.put("qd0709d", bi.qd0709d.getText().toString().trim().length() > 0 ? bi.qd0709d.getText().toString() : "0");

        qoc10.put("qd0710a", bi.qd0710aa.isChecked() ? "1" : bi.qd0710ab.isChecked() ? "2" : "0");
        qoc10.put("qd0710b", bi.qd0710ba.isChecked() ? "1" : bi.qd0710bb.isChecked() ? "2" : bi.qd0710bc.isChecked() ? "3" : "0");
        qoc10.put("qd0710c", bi.qd0710c.getText().toString().trim().length() > 0 ? bi.qd0710c.getText().toString() : "0");
        qoc10.put("qd0710d", bi.qd0710d.getText().toString().trim().length() > 0 ? bi.qd0710d.getText().toString() : "0");

        qoc10.put("qd0711a", bi.qd0711aa.isChecked() ? "1" : bi.qd0711ab.isChecked() ? "2" : "0");
        qoc10.put("qd0711b", bi.qd0711ba.isChecked() ? "1" : bi.qd0711bb.isChecked() ? "2" : bi.qd0711bc.isChecked() ? "3" : "0");
        qoc10.put("qd0711c", bi.qd0711c.getText().toString().trim().length() > 0 ? bi.qd0711c.getText().toString() : "0");
        qoc10.put("qd0711d", bi.qd0711d.getText().toString().trim().length() > 0 ? bi.qd0711d.getText().toString() : "0");

        qoc10.put("qd0712a", bi.qd0712aa.isChecked() ? "1" : bi.qd0712ab.isChecked() ? "2" : "0");
        qoc10.put("qd0712b", bi.qd0712ba.isChecked() ? "1" : bi.qd0712bb.isChecked() ? "2" : bi.qd0712bc.isChecked() ? "3" : "0");
        qoc10.put("qd0712c", bi.qd0712c.getText().toString().trim().length() > 0 ? bi.qd0712c.getText().toString() : "0");
        qoc10.put("qd0712d", bi.qd0712d.getText().toString().trim().length() > 0 ? bi.qd0712d.getText().toString() : "0");

        qoc10.put("qd0713a", bi.qd0713aa.isChecked() ? "1" : bi.qd0713ab.isChecked() ? "2" : "0");
        qoc10.put("qd0713b", bi.qd0713ba.isChecked() ? "1" : bi.qd0713bb.isChecked() ? "2" : bi.qd0713bc.isChecked() ? "3" : "0");
        qoc10.put("qd0713c", bi.qd0713c.getText().toString().trim().length() > 0 ? bi.qd0713c.getText().toString() : "0");
        qoc10.put("qd0713d", bi.qd0713d.getText().toString().trim().length() > 0 ? bi.qd0713d.getText().toString() : "0");

        qoc10.put("qd0714a", bi.qd0714aa.isChecked() ? "1" : bi.qd0714ab.isChecked() ? "2" : "0");
        qoc10.put("qd0714b", bi.qd0714ba.isChecked() ? "1" : bi.qd0714bb.isChecked() ? "2" : bi.qd0714bc.isChecked() ? "3" : "0");
        qoc10.put("qd0714c", bi.qd0714c.getText().toString().trim().length() > 0 ? bi.qd0714c.getText().toString() : "0");
        qoc10.put("qd0714d", bi.qd0714d.getText().toString().trim().length() > 0 ? bi.qd0714d.getText().toString() : "0");

        qoc10.put("qd0715a", bi.qd0715aa.isChecked() ? "1" : bi.qd0715ab.isChecked() ? "2" : "0");
        qoc10.put("qd0715b", bi.qd0715ba.isChecked() ? "1" : bi.qd0715bb.isChecked() ? "2" : bi.qd0715bc.isChecked() ? "3" : "0");
        qoc10.put("qd0715c", bi.qd0715c.getText().toString().trim().length() > 0 ? bi.qd0715c.getText().toString() : "0");
        qoc10.put("qd0715d", bi.qd0715d.getText().toString().trim().length() > 0 ? bi.qd0715d.getText().toString() : "0");

        fc.setSqoc10(String.valueOf(qoc10));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qd0301aa.isChecked()){
            bi.qd0301b.clearCheck();
            bi.qd0301c.setEnabled(true);
        } else {
            bi.qd0301c.setEnabled(false);
        }

        if (!bi.qd0302aa.isChecked()){
            bi.qd0302b.clearCheck();
            bi.qd0302c.setEnabled(true);
        } else {
            bi.qd0302c.setEnabled(false);
        }

        if (!bi.qd0303aa.isChecked()){
            bi.qd0303b.clearCheck();
            bi.qd0303c.setEnabled(true);
        } else {
            bi.qd0303c.setEnabled(false);
        }

        if (!bi.qd0304aa.isChecked()){
            bi.qd0304b.clearCheck();
            bi.qd0304c.setEnabled(true);
        } else {
            bi.qd0304c.setEnabled(false);
        }

        if (!bi.qd0305aa.isChecked()){
            bi.qd0305b.clearCheck();
            bi.qd0305c.setEnabled(true);
        } else {
            bi.qd0305c.setEnabled(false);
        }



        if (!bi.qd0401aa.isChecked()){
            bi.qd0401b.clearCheck();
            bi.qd0401c.setEnabled(true);
        } else {
            bi.qd0401c.setEnabled(false);
        }

        if (!bi.qd0402aa.isChecked()){
            bi.qd0402b.clearCheck();
            bi.qd0402c.setEnabled(true);
        } else {
            bi.qd0402c.setEnabled(false);
        }

        if (!bi.qd0403aa.isChecked()){
            bi.qd0403b.clearCheck();
            bi.qd0403c.setEnabled(true);
        } else {
            bi.qd0403c.setEnabled(false);
        }

        if (!bi.qd0404aa.isChecked()){
            bi.qd0404b.clearCheck();
            bi.qd0404c.setEnabled(true);
        } else {
            bi.qd0404c.setEnabled(false);
        }



        if (!bi.qd0501aa.isChecked()){
            bi.qd0501b.clearCheck();
            bi.qd0501c.setEnabled(true);
        } else {
            bi.qd0501c.setEnabled(false);
        }

        if (!bi.qd0502aa.isChecked()){
            bi.qd0502b.clearCheck();
            bi.qd0502c.setEnabled(true);
        } else {
            bi.qd0502c.setEnabled(false);
        }

        if (!bi.qd0503aa.isChecked()){
            bi.qd0503b.clearCheck();
            bi.qd0503c.setEnabled(true);
        } else {
            bi.qd0503c.setEnabled(false);
        }



        if (!bi.qd0601aa.isChecked()){
            bi.qd0601b.clearCheck();
            bi.qd0601c.setEnabled(true);
        } else {
            bi.qd0601c.setEnabled(false);
        }

        if (!bi.qd0602aa.isChecked()){
            bi.qd0602b.clearCheck();
            bi.qd0602c.setEnabled(true);
        } else {
            bi.qd0602c.setEnabled(false);
        }

        if (!bi.qd0603aa.isChecked()){
            bi.qd0603b.clearCheck();
            bi.qd0603c.setEnabled(true);
        } else {
            bi.qd0603c.setEnabled(false);
        }

        if (!bi.qd0604aa.isChecked()){
            bi.qd0604b.clearCheck();
            bi.qd0604c.setEnabled(true);
        } else {
            bi.qd0604c.setEnabled(false);
        }



        if (!bi.qd0701aa.isChecked()){
            bi.qd0701b.clearCheck();
            bi.qd0701c.setEnabled(true);
        } else {
            bi.qd0701c.setEnabled(false);
        }

        if (!bi.qd0702aa.isChecked()){
            bi.qd0702b.clearCheck();
            bi.qd0702c.setEnabled(true);
        } else {
            bi.qd0702c.setEnabled(false);
        }

        if (!bi.qd0703aa.isChecked()){
            bi.qd0703b.clearCheck();
            bi.qd0703c.setEnabled(true);
        } else {
            bi.qd0703c.setEnabled(false);
        }

        if (!bi.qd0704aa.isChecked()){
            bi.qd0704b.clearCheck();
            bi.qd0704c.setEnabled(true);
        } else {
            bi.qd0704c.setEnabled(false);
        }

        if (!bi.qd0705aa.isChecked()){
            bi.qd0705b.clearCheck();
            bi.qd0705c.setEnabled(true);
        } else {
            bi.qd0705c.setEnabled(false);
        }

        if (!bi.qd0706aa.isChecked()){
            bi.qd0706b.clearCheck();
            bi.qd0706c.setEnabled(true);
        } else {
            bi.qd0706c.setEnabled(false);
        }

        if (!bi.qd0707aa.isChecked()){
            bi.qd0707b.clearCheck();
            bi.qd0707c.setEnabled(true);
        } else {
            bi.qd0707c.setEnabled(false);
        }

        if (!bi.qd0708aa.isChecked()){
            bi.qd0708b.clearCheck();
            bi.qd0708c.setEnabled(true);
        } else {
            bi.qd0708c.setEnabled(false);
        }

        if (!bi.qd0709aa.isChecked()){
            bi.qd0709b.clearCheck();
            bi.qd0709c.setEnabled(true);
        } else {
            bi.qd0709c.setEnabled(false);
        }

        if (!bi.qd0710aa.isChecked()){
            bi.qd0710b.clearCheck();
            bi.qd0710c.setEnabled(true);
        } else {
            bi.qd0710c.setEnabled(false);
        }

        if (!bi.qd0711aa.isChecked()){
            bi.qd0711b.clearCheck();
            bi.qd0711c.setEnabled(true);
        } else {
            bi.qd0711c.setEnabled(false);
        }

        if (!bi.qd0712aa.isChecked()){
            bi.qd0712b.clearCheck();
            bi.qd0712c.setEnabled(true);
        } else {
            bi.qd0712c.setEnabled(false);
        }

        if (!bi.qd0713aa.isChecked()){
            bi.qd0713b.clearCheck();
            bi.qd0713c.setEnabled(true);
        } else {
            bi.qd0713c.setEnabled(false);
        }

        if (!bi.qd0714aa.isChecked()){
            bi.qd0714b.clearCheck();
            bi.qd0714c.setEnabled(true);
        } else {
            bi.qd0714c.setEnabled(false);
        }

        if (!bi.qd0715aa.isChecked()){
            bi.qd0715b.clearCheck();
            bi.qd0715c.setEnabled(true);
        } else {
            bi.qd0715c.setEnabled(false);
        }

    }

    void events_call() {

        bi.qd0301a.setOnCheckedChangeListener(this);
        bi.qd0302a.setOnCheckedChangeListener(this);
        bi.qd0303a.setOnCheckedChangeListener(this);
        bi.qd0304a.setOnCheckedChangeListener(this);
        bi.qd0305a.setOnCheckedChangeListener(this);

        bi.qd0401a.setOnCheckedChangeListener(this);
        bi.qd0402a.setOnCheckedChangeListener(this);
        bi.qd0403a.setOnCheckedChangeListener(this);
        bi.qd0404a.setOnCheckedChangeListener(this);

        bi.qd0501a.setOnCheckedChangeListener(this);
        bi.qd0502a.setOnCheckedChangeListener(this);
        bi.qd0503a.setOnCheckedChangeListener(this);

        bi.qd0601a.setOnCheckedChangeListener(this);
        bi.qd0602a.setOnCheckedChangeListener(this);
        bi.qd0603a.setOnCheckedChangeListener(this);
        bi.qd0604a.setOnCheckedChangeListener(this);

        bi.qd0701a.setOnCheckedChangeListener(this);
        bi.qd0702a.setOnCheckedChangeListener(this);
        bi.qd0703a.setOnCheckedChangeListener(this);
        bi.qd0704a.setOnCheckedChangeListener(this);
        bi.qd0705a.setOnCheckedChangeListener(this);
        bi.qd0706a.setOnCheckedChangeListener(this);
        bi.qd0707a.setOnCheckedChangeListener(this);
        bi.qd0708a.setOnCheckedChangeListener(this);
        bi.qd0709a.setOnCheckedChangeListener(this);
        bi.qd0710a.setOnCheckedChangeListener(this);
        bi.qd0711a.setOnCheckedChangeListener(this);
        bi.qd0712a.setOnCheckedChangeListener(this);
        bi.qd0713a.setOnCheckedChangeListener(this);
        bi.qd0714a.setOnCheckedChangeListener(this);
        bi.qd0715a.setOnCheckedChangeListener(this);

    }
}
