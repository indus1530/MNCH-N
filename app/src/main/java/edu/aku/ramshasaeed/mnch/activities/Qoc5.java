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
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc6.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc5);
    }


    private void SaveDraft() throws JSONException {

        JSONObject qoc5 = new JSONObject();

        qoc5.put("qb0306a", bi.qb0306aa.isChecked() ? "1" : bi.qb0306ab.isChecked() ? "2" : bi.qb0306a97.isChecked() ? "97" : "0");
        qoc5.put("qb0306b", bi.qb0306ba.isChecked() ? "1" : bi.qb0306bb.isChecked() ? "2" : bi.qb0306b98.isChecked() ? "98" : "0");
        qoc5.put("qb0306c", bi.qb0306c.getText().toString().trim().length() > 0 ? bi.qb0306c.getText().toString() : "0");

        qoc5.put("qb0307a", bi.qb0307aa.isChecked() ? "1" : bi.qb0307ab.isChecked() ? "2" : bi.qb0307a97.isChecked() ? "97" : "0");
        qoc5.put("qb0307b", bi.qb0307ba.isChecked() ? "1" : bi.qb0307bb.isChecked() ? "2" : bi.qb0307b98.isChecked() ? "98" : "0");
        qoc5.put("qb0307c", bi.qb0307c.getText().toString().trim().length() > 0 ? bi.qb0307c.getText().toString() : "0");

        qoc5.put("qb0308a", bi.qb0308aa.isChecked() ? "1" : bi.qb0308ab.isChecked() ? "2" : bi.qb0308a97.isChecked() ? "97" : "0");
        qoc5.put("qb0308b", bi.qb0308ba.isChecked() ? "1" : bi.qb0308bb.isChecked() ? "2" : bi.qb0308b98.isChecked() ? "98" : "0");
        qoc5.put("qb0308c", bi.qb0308c.getText().toString().trim().length() > 0 ? bi.qb0308c.getText().toString() : "0");

        qoc5.put("qb0309a", bi.qb0309aa.isChecked() ? "1" : bi.qb0309ab.isChecked() ? "2" : bi.qb0309a97.isChecked() ? "97" : "0");
        qoc5.put("qb0309b", bi.qb0309ba.isChecked() ? "1" : bi.qb0309bb.isChecked() ? "2" : bi.qb0309b98.isChecked() ? "98" : "0");
        qoc5.put("qb0309c", bi.qb0309c.getText().toString().trim().length() > 0 ? bi.qb0309c.getText().toString() : "0");

        qoc5.put("qb0310a", bi.qb0310aa.isChecked() ? "1" : bi.qb0310ab.isChecked() ? "2" : bi.qb0310a97.isChecked() ? "97" : "0");
        qoc5.put("qb0310b", bi.qb0310ba.isChecked() ? "1" : bi.qb0310bb.isChecked() ? "2" : bi.qb0310b98.isChecked() ? "98" : "0");
        qoc5.put("qb0310c", bi.qb0310c.getText().toString().trim().length() > 0 ? bi.qb0310c.getText().toString() : "0");

        qoc5.put("qb0311a", bi.qb0311aa.isChecked() ? "1" : bi.qb0311ab.isChecked() ? "2" : bi.qb0311a97.isChecked() ? "97" : "0");
        qoc5.put("qb0311b", bi.qb0311ba.isChecked() ? "1" : bi.qb0311bb.isChecked() ? "2" : bi.qb0311b98.isChecked() ? "98" : "0");
        qoc5.put("qb0311c", bi.qb0311c.getText().toString().trim().length() > 0 ? bi.qb0311c.getText().toString() : "0");
        
        qoc5.put("qb0312a", bi.qb0312aa.isChecked() ? "1" : bi.qb0312ab.isChecked() ? "2" : bi.qb0312a97.isChecked() ? "97" : "0");
        qoc5.put("qb0312b", bi.qb0312ba.isChecked() ? "1" : bi.qb0312bb.isChecked() ? "2" : bi.qb0312b98.isChecked() ? "98" : "0");
        qoc5.put("qb0312c", bi.qb0312c.getText().toString().trim().length() > 0 ? bi.qb0312c.getText().toString() : "0");

        qoc5.put("qb0313a", bi.qb0313aa.isChecked() ? "1" : bi.qb0313ab.isChecked() ? "2" : bi.qb0313a97.isChecked() ? "97" : "0");
        qoc5.put("qb0313b", bi.qb0313ba.isChecked() ? "1" : bi.qb0313bb.isChecked() ? "2" : bi.qb0313b98.isChecked() ? "98" : "0");
        qoc5.put("qb0313c", bi.qb0313c.getText().toString().trim().length() > 0 ? bi.qb0313c.getText().toString() : "0");

        qoc5.put("qb0314a", bi.qb0314aa.isChecked() ? "1" : bi.qb0314ab.isChecked() ? "2" : bi.qb0314a97.isChecked() ? "97" : "0");
        qoc5.put("qb0314b", bi.qb0314ba.isChecked() ? "1" : bi.qb0314bb.isChecked() ? "2" : bi.qb0314b98.isChecked() ? "98" : "0");
        qoc5.put("qb0314c", bi.qb0314c.getText().toString().trim().length() > 0 ? bi.qb0314c.getText().toString() : "0");

        qoc5.put("qb0315a", bi.qb0315aa.isChecked() ? "1" : bi.qb0315ab.isChecked() ? "2" : bi.qb0315a97.isChecked() ? "97" : "0");
        qoc5.put("qb0315b", bi.qb0315ba.isChecked() ? "1" : bi.qb0315bb.isChecked() ? "2" : bi.qb0315b98.isChecked() ? "98" : "0");
        qoc5.put("qb0315c", bi.qb0315c.getText().toString().trim().length() > 0 ? bi.qb0315c.getText().toString() : "0");

        qoc5.put("qb0316a", bi.qb0316aa.isChecked() ? "1" : bi.qb0316ab.isChecked() ? "2" : bi.qb0316a97.isChecked() ? "97" : "0");
        qoc5.put("qb0316b", bi.qb0316ba.isChecked() ? "1" : bi.qb0316bb.isChecked() ? "2" : bi.qb0316b98.isChecked() ? "98" : "0");
        qoc5.put("qb0316c", bi.qb0316c.getText().toString().trim().length() > 0 ? bi.qb0316c.getText().toString() : "0");

        qoc5.put("qb0317a", bi.qb0317aa.isChecked() ? "1" : bi.qb0317ab.isChecked() ? "2" : bi.qb0317a97.isChecked() ? "97" : "0");
        qoc5.put("qb0317b", bi.qb0317ba.isChecked() ? "1" : bi.qb0317bb.isChecked() ? "2" : bi.qb0317b98.isChecked() ? "98" : "0");
        qoc5.put("qb0317c", bi.qb0317c.getText().toString().trim().length() > 0 ? bi.qb0317c.getText().toString() : "0");

        qoc5.put("qb0318a", bi.qb0318aa.isChecked() ? "1" : bi.qb0318ab.isChecked() ? "2" : bi.qb0318a97.isChecked() ? "97" : "0");
        qoc5.put("qb0318b", bi.qb0318ba.isChecked() ? "1" : bi.qb0318bb.isChecked() ? "2" : bi.qb0318b98.isChecked() ? "98" : "0");
        qoc5.put("qb0318c", bi.qb0318c.getText().toString().trim().length() > 0 ? bi.qb0318c.getText().toString() : "0");

        qoc5.put("qb0319a", bi.qb0319aa.isChecked() ? "1" : bi.qb0319ab.isChecked() ? "2" : bi.qb0319a97.isChecked() ? "97" : "0");
        qoc5.put("qb0319b", bi.qb0319ba.isChecked() ? "1" : bi.qb0319bb.isChecked() ? "2" : bi.qb0319b98.isChecked() ? "98" : "0");
        qoc5.put("qb0319c", bi.qb0319c.getText().toString().trim().length() > 0 ? bi.qb0319c.getText().toString() : "0");

        qoc5.put("qb0320a", bi.qb0320aa.isChecked() ? "1" : bi.qb0320ab.isChecked() ? "2" : bi.qb0320a97.isChecked() ? "97" : "0");
        qoc5.put("qb0320b", bi.qb0320ba.isChecked() ? "1" : bi.qb0320bb.isChecked() ? "2" : bi.qb0320b98.isChecked() ? "98" : "0");
        qoc5.put("qb0320c", bi.qb0320c.getText().toString().trim().length() > 0 ? bi.qb0320c.getText().toString() : "0");

        qoc5.put("qb0321a", bi.qb0321aa.isChecked() ? "1" : bi.qb0321ab.isChecked() ? "2" : bi.qb0321a97.isChecked() ? "97" : "0");
        qoc5.put("qb0321b", bi.qb0321ba.isChecked() ? "1" : bi.qb0321bb.isChecked() ? "2" : bi.qb0321b98.isChecked() ? "98" : "0");
        qoc5.put("qb0321c", bi.qb0321c.getText().toString().trim().length() > 0 ? bi.qb0321c.getText().toString() : "0");

        qoc5.put("qb0322a", bi.qb0322aa.isChecked() ? "1" : bi.qb0322ab.isChecked() ? "2" : bi.qb0322a97.isChecked() ? "97" : "0");
        qoc5.put("qb0322b", bi.qb0322ba.isChecked() ? "1" : bi.qb0322bb.isChecked() ? "2" : bi.qb0322b98.isChecked() ? "98" : "0");
        qoc5.put("qb0322c", bi.qb0322c.getText().toString().trim().length() > 0 ? bi.qb0322c.getText().toString() : "0");
        
        
        
        
        qoc5.put("qb0401a", bi.qb0401aa.isChecked() ? "1" : bi.qb0401ab.isChecked() ? "2" : bi.qb0401a97.isChecked() ? "97" : "0");
        qoc5.put("qb0401b", bi.qb0401ba.isChecked() ? "1" : bi.qb0401bb.isChecked() ? "2" : bi.qb0401b98.isChecked() ? "98" : "0");
        qoc5.put("qb0401c", bi.qb0401c.getText().toString().trim().length() > 0 ? bi.qb0401c.getText().toString() : "0");

        qoc5.put("qb0402a", bi.qb0402aa.isChecked() ? "1" : bi.qb0402ab.isChecked() ? "2" : bi.qb0402a97.isChecked() ? "97" : "0");
        qoc5.put("qb0402b", bi.qb0402ba.isChecked() ? "1" : bi.qb0402bb.isChecked() ? "2" : bi.qb0402b98.isChecked() ? "98" : "0");
        qoc5.put("qb0402c", bi.qb0402c.getText().toString().trim().length() > 0 ? bi.qb0402c.getText().toString() : "0");

        qoc5.put("qb0403a", bi.qb0403aa.isChecked() ? "1" : bi.qb0403ab.isChecked() ? "2" : bi.qb0403a97.isChecked() ? "97" : "0");
        qoc5.put("qb0403b", bi.qb0403ba.isChecked() ? "1" : bi.qb0403bb.isChecked() ? "2" : bi.qb0403b98.isChecked() ? "98" : "0");
        qoc5.put("qb0403c", bi.qb0403c.getText().toString().trim().length() > 0 ? bi.qb0403c.getText().toString() : "0");

        qoc5.put("qb0404a", bi.qb0404aa.isChecked() ? "1" : bi.qb0404ab.isChecked() ? "2" : bi.qb0404a97.isChecked() ? "97" : "0");
        qoc5.put("qb0404b", bi.qb0404ba.isChecked() ? "1" : bi.qb0404bb.isChecked() ? "2" : bi.qb0404b98.isChecked() ? "98" : "0");
        qoc5.put("qb0404c", bi.qb0404c.getText().toString().trim().length() > 0 ? bi.qb0404c.getText().toString() : "0");

        qoc5.put("qb0405a", bi.qb0405aa.isChecked() ? "1" : bi.qb0405ab.isChecked() ? "2" : bi.qb0405a97.isChecked() ? "97" : "0");
        qoc5.put("qb0405b", bi.qb0405ba.isChecked() ? "1" : bi.qb0405bb.isChecked() ? "2" : bi.qb0405b98.isChecked() ? "98" : "0");
        qoc5.put("qb0405c", bi.qb0405c.getText().toString().trim().length() > 0 ? bi.qb0405c.getText().toString() : "0");

        qoc5.put("qb0406a", bi.qb0406aa.isChecked() ? "1" : bi.qb0406ab.isChecked() ? "2" : bi.qb0406a97.isChecked() ? "97" : "0");
        qoc5.put("qb0406b", bi.qb0406ba.isChecked() ? "1" : bi.qb0406bb.isChecked() ? "2" : bi.qb0406b98.isChecked() ? "98" : "0");
        qoc5.put("qb0406c", bi.qb0406c.getText().toString().trim().length() > 0 ? bi.qb0406c.getText().toString() : "0");

        qoc5.put("qb0407a", bi.qb0407aa.isChecked() ? "1" : bi.qb0407ab.isChecked() ? "2" : bi.qb0407a97.isChecked() ? "97" : "0");
        qoc5.put("qb0407b", bi.qb0407ba.isChecked() ? "1" : bi.qb0407bb.isChecked() ? "2" : bi.qb0407b98.isChecked() ? "98" : "0");
        qoc5.put("qb0407c", bi.qb0407c.getText().toString().trim().length() > 0 ? bi.qb0407c.getText().toString() : "0");


        /*preFix.equals("QOC");
        JSONObject json_qoc1 = GeneratorClass.getContainerJSON(bi.llqoc1, true, preFix);*/

        fc.setSqoc1(String.valueOf(qoc5));

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
