package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc7Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc7 extends AppCompatActivity {

    ActivityQoc7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc7);
        bi.setCallback(this);
        this.setTitle("Quality of Care 07");
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
//                MainApp.endActivity(this, this, EndingActivity.class, true, RSDInfoActivity.fc);
                finish();
                startActivity(new Intent(Qoc7.this, Qoc8.class));


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }


    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);

    }


    private boolean UpdateDB() {

        /*try {

            Long longID = new crudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        return true;

    }


    public boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc7);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc7 = new JSONObject();

        qoc7.put("qc0901a", bi.qc0901aa.isChecked() ? "1" : bi.qc0901ab.isChecked() ? "2" : "0");
        qoc7.put("qc0901b", bi.qc0901ba.isChecked() ? "1" : bi.qc0901bb.isChecked() ? "2" : bi.qc0901bc.isChecked() ? "3" : "0");
        qoc7.put("qc0901c", bi.qc0901c.getText().toString().trim().length() > 0 ? bi.qc0901c.getText().toString() : "0");
        qoc7.put("qc0901d", bi.qc0901d.getText().toString().trim().length() > 0 ? bi.qc0901d.getText().toString() : "0");

        qoc7.put("qc0902a", bi.qc0902aa.isChecked() ? "1" : bi.qc0902ab.isChecked() ? "2" : "0");
        qoc7.put("qc0902b", bi.qc0902ba.isChecked() ? "1" : bi.qc0902bb.isChecked() ? "2" : bi.qc0902bc.isChecked() ? "3" : "0");
        qoc7.put("qc0902c", bi.qc0902c.getText().toString().trim().length() > 0 ? bi.qc0902c.getText().toString() : "0");
        qoc7.put("qc0902d", bi.qc0902d.getText().toString().trim().length() > 0 ? bi.qc0902d.getText().toString() : "0");

        qoc7.put("qc0903a", bi.qc0903aa.isChecked() ? "1" : bi.qc0903ab.isChecked() ? "2" : "0");
        qoc7.put("qc0903b", bi.qc0903ba.isChecked() ? "1" : bi.qc0903bb.isChecked() ? "2" : bi.qc0903bc.isChecked() ? "3" : "0");
        qoc7.put("qc0903c", bi.qc0903c.getText().toString().trim().length() > 0 ? bi.qc0903c.getText().toString() : "0");
        qoc7.put("qc0903d", bi.qc0903d.getText().toString().trim().length() > 0 ? bi.qc0903d.getText().toString() : "0");

        qoc7.put("qc0904a", bi.qc0904aa.isChecked() ? "1" : bi.qc0904ab.isChecked() ? "2" : "0");
        qoc7.put("qc0904b", bi.qc0904ba.isChecked() ? "1" : bi.qc0904bb.isChecked() ? "2" : bi.qc0904bc.isChecked() ? "3" : "0");
        qoc7.put("qc0904c", bi.qc0904c.getText().toString().trim().length() > 0 ? bi.qc0904c.getText().toString() : "0");
        qoc7.put("qc0904d", bi.qc0904d.getText().toString().trim().length() > 0 ? bi.qc0904d.getText().toString() : "0");

        qoc7.put("qc0905a", bi.qc0905aa.isChecked() ? "1" : bi.qc0905ab.isChecked() ? "2" : "0");
        qoc7.put("qc0905b", bi.qc0905ba.isChecked() ? "1" : bi.qc0905bb.isChecked() ? "2" : bi.qc0905bc.isChecked() ? "3" : "0");
        qoc7.put("qc0905c", bi.qc0905c.getText().toString().trim().length() > 0 ? bi.qc0905c.getText().toString() : "0");
        qoc7.put("qc0905d", bi.qc0905d.getText().toString().trim().length() > 0 ? bi.qc0905d.getText().toString() : "0");

        qoc7.put("qc0906a", bi.qc0906aa.isChecked() ? "1" : bi.qc0906ab.isChecked() ? "2" : "0");
        qoc7.put("qc0906b", bi.qc0906ba.isChecked() ? "1" : bi.qc0906bb.isChecked() ? "2" : bi.qc0906bc.isChecked() ? "3" : "0");
        qoc7.put("qc0906c", bi.qc0906c.getText().toString().trim().length() > 0 ? bi.qc0906c.getText().toString() : "0");
        qoc7.put("qc0906d", bi.qc0906d.getText().toString().trim().length() > 0 ? bi.qc0906d.getText().toString() : "0");

        qoc7.put("qc0907a", bi.qc0907aa.isChecked() ? "1" : bi.qc0907ab.isChecked() ? "2" : "0");
        qoc7.put("qc0907b", bi.qc0907ba.isChecked() ? "1" : bi.qc0907bb.isChecked() ? "2" : bi.qc0907bc.isChecked() ? "3" : "0");
        qoc7.put("qc0907c", bi.qc0907c.getText().toString().trim().length() > 0 ? bi.qc0907c.getText().toString() : "0");
        qoc7.put("qc0907d", bi.qc0907d.getText().toString().trim().length() > 0 ? bi.qc0907d.getText().toString() : "0");

        qoc7.put("qc0908a", bi.qc0908aa.isChecked() ? "1" : bi.qc0908ab.isChecked() ? "2" : "0");
        qoc7.put("qc0908b", bi.qc0908ba.isChecked() ? "1" : bi.qc0908bb.isChecked() ? "2" : bi.qc0908bc.isChecked() ? "3" : "0");
        qoc7.put("qc0908c", bi.qc0908c.getText().toString().trim().length() > 0 ? bi.qc0908c.getText().toString() : "0");
        qoc7.put("qc0908d", bi.qc0908d.getText().toString().trim().length() > 0 ? bi.qc0908d.getText().toString() : "0");



        qoc7.put("qc1001a", bi.qc1001aa.isChecked() ? "1" : bi.qc1001ab.isChecked() ? "2" : "0");
        qoc7.put("qc1001b", bi.qc1001ba.isChecked() ? "1" : bi.qc1001bb.isChecked() ? "2" : bi.qc1001bc.isChecked() ? "3" : "0");
        qoc7.put("qc1001c", bi.qc1001c.getText().toString().trim().length() > 0 ? bi.qc1001c.getText().toString() : "0");
        qoc7.put("qc1001d", bi.qc1001d.getText().toString().trim().length() > 0 ? bi.qc1001d.getText().toString() : "0");

        qoc7.put("qc1002a", bi.qc1002aa.isChecked() ? "1" : bi.qc1002ab.isChecked() ? "2" : "0");
        qoc7.put("qc1002b", bi.qc1002ba.isChecked() ? "1" : bi.qc1002bb.isChecked() ? "2" : bi.qc1002bc.isChecked() ? "3" : "0");
        qoc7.put("qc1002c", bi.qc1002c.getText().toString().trim().length() > 0 ? bi.qc1002c.getText().toString() : "0");
        qoc7.put("qc1002d", bi.qc1002d.getText().toString().trim().length() > 0 ? bi.qc1002d.getText().toString() : "0");



        qoc7.put("qc1101a", bi.qc1101aa.isChecked() ? "1" : bi.qc1101ab.isChecked() ? "2" : "0");
        qoc7.put("qc1101b", bi.qc1101ba.isChecked() ? "1" : bi.qc1101bb.isChecked() ? "2" : bi.qc1101bc.isChecked() ? "3" : "0");
        qoc7.put("qc1101c", bi.qc1101c.getText().toString().trim().length() > 0 ? bi.qc1101c.getText().toString() : "0");
        qoc7.put("qc1101d", bi.qc1101d.getText().toString().trim().length() > 0 ? bi.qc1101d.getText().toString() : "0");

        qoc7.put("qc1102a", bi.qc1102aa.isChecked() ? "1" : bi.qc1102ab.isChecked() ? "2" : "0");
        qoc7.put("qc1102b", bi.qc1102ba.isChecked() ? "1" : bi.qc1102bb.isChecked() ? "2" : bi.qc1102bc.isChecked() ? "3" : "0");
        qoc7.put("qc1102c", bi.qc1102c.getText().toString().trim().length() > 0 ? bi.qc1102c.getText().toString() : "0");
        qoc7.put("qc1102d", bi.qc1102d.getText().toString().trim().length() > 0 ? bi.qc1102d.getText().toString() : "0");

        qoc7.put("qc1103a", bi.qc1103aa.isChecked() ? "1" : bi.qc1103ab.isChecked() ? "2" : "0");
        qoc7.put("qc1103b", bi.qc1103ba.isChecked() ? "1" : bi.qc1103bb.isChecked() ? "2" : bi.qc1103bc.isChecked() ? "3" : "0");
        qoc7.put("qc1103c", bi.qc1103c.getText().toString().trim().length() > 0 ? bi.qc1103c.getText().toString() : "0");
        qoc7.put("qc1103d", bi.qc1103d.getText().toString().trim().length() > 0 ? bi.qc1103d.getText().toString() : "0");

        qoc7.put("qc1104a", bi.qc1104aa.isChecked() ? "1" : bi.qc1104ab.isChecked() ? "2" : "0");
        qoc7.put("qc1104b", bi.qc1104ba.isChecked() ? "1" : bi.qc1104bb.isChecked() ? "2" : bi.qc1104bc.isChecked() ? "3" : "0");
        qoc7.put("qc1104c", bi.qc1104c.getText().toString().trim().length() > 0 ? bi.qc1104c.getText().toString() : "0");
        qoc7.put("qc1104d", bi.qc1104d.getText().toString().trim().length() > 0 ? bi.qc1104d.getText().toString() : "0");



        qoc7.put("qc1201a", bi.qc1201aa.isChecked() ? "1" : bi.qc1201ab.isChecked() ? "2" : "0");
        qoc7.put("qc1201b", bi.qc1201ba.isChecked() ? "1" : bi.qc1201bb.isChecked() ? "2" : bi.qc1201bc.isChecked() ? "3" : "0");
        qoc7.put("qc1201c", bi.qc1201c.getText().toString().trim().length() > 0 ? bi.qc1201c.getText().toString() : "0");
        qoc7.put("qc1201d", bi.qc1201d.getText().toString().trim().length() > 0 ? bi.qc1201d.getText().toString() : "0");

        qoc7.put("qc1202a", bi.qc1202aa.isChecked() ? "1" : bi.qc1202ab.isChecked() ? "2" : "0");
        qoc7.put("qc1202b", bi.qc1202ba.isChecked() ? "1" : bi.qc1202bb.isChecked() ? "2" : bi.qc1202bc.isChecked() ? "3" : "0");
        qoc7.put("qc1202c", bi.qc1202c.getText().toString().trim().length() > 0 ? bi.qc1202c.getText().toString() : "0");
        qoc7.put("qc1202d", bi.qc1202d.getText().toString().trim().length() > 0 ? bi.qc1202d.getText().toString() : "0");

        qoc7.put("qc1203a", bi.qc1203aa.isChecked() ? "1" : bi.qc1203ab.isChecked() ? "2" : "0");
        qoc7.put("qc1203b", bi.qc1203ba.isChecked() ? "1" : bi.qc1203bb.isChecked() ? "2" : bi.qc1203bc.isChecked() ? "3" : "0");
        qoc7.put("qc1203c", bi.qc1203c.getText().toString().trim().length() > 0 ? bi.qc1203c.getText().toString() : "0");
        qoc7.put("qc1203d", bi.qc1203d.getText().toString().trim().length() > 0 ? bi.qc1203d.getText().toString() : "0");




        qoc7.put("qc1301a", bi.qc1301aa.isChecked() ? "1" : bi.qc1301ab.isChecked() ? "2" : "0");
        qoc7.put("qc1301b", bi.qc1301ba.isChecked() ? "1" : bi.qc1301bb.isChecked() ? "2" : bi.qc1301bc.isChecked() ? "3" : "0");
        qoc7.put("qc1301c", bi.qc1301c.getText().toString().trim().length() > 0 ? bi.qc1301c.getText().toString() : "0");
        qoc7.put("qc1301d", bi.qc1301d.getText().toString().trim().length() > 0 ? bi.qc1301d.getText().toString() : "0");

        qoc7.put("qc1302a", bi.qc1302aa.isChecked() ? "1" : bi.qc1302ab.isChecked() ? "2" : "0");
        qoc7.put("qc1302b", bi.qc1302ba.isChecked() ? "1" : bi.qc1302bb.isChecked() ? "2" : bi.qc1302bc.isChecked() ? "3" : "0");
        qoc7.put("qc1302c", bi.qc1302c.getText().toString().trim().length() > 0 ? bi.qc1302c.getText().toString() : "0");
        qoc7.put("qc1302d", bi.qc1302d.getText().toString().trim().length() > 0 ? bi.qc1302d.getText().toString() : "0");



        qoc7.put("qc1401a", bi.qc1401aa.isChecked() ? "1" : bi.qc1401ab.isChecked() ? "2" : "0");
        qoc7.put("qc1401b", bi.qc1401ba.isChecked() ? "1" : bi.qc1401bb.isChecked() ? "2" : bi.qc1401bc.isChecked() ? "3" : "0");
        qoc7.put("qc1401c", bi.qc1401c.getText().toString().trim().length() > 0 ? bi.qc1401c.getText().toString() : "0");
        qoc7.put("qc1401d", bi.qc1401d.getText().toString().trim().length() > 0 ? bi.qc1401d.getText().toString() : "0");


        qoc7.put("qc1501a", bi.qc1501aa.isChecked() ? "1" : bi.qc1501ab.isChecked() ? "2" : "0");
        qoc7.put("qc1501b", bi.qc1501ba.isChecked() ? "1" : bi.qc1501bb.isChecked() ? "2" : bi.qc1501bc.isChecked() ? "3" : "0");
        qoc7.put("qc1501c", bi.qc1501c.getText().toString().trim().length() > 0 ? bi.qc1501c.getText().toString() : "0");
        qoc7.put("qc1501d", bi.qc1501d.getText().toString().trim().length() > 0 ? bi.qc1501d.getText().toString() : "0");


        qoc7.put("qc1601a", bi.qc1601aa.isChecked() ? "1" : bi.qc1601ab.isChecked() ? "2" : "0");
        qoc7.put("qc1601b", bi.qc1601ba.isChecked() ? "1" : bi.qc1601bb.isChecked() ? "2" : bi.qc1601bc.isChecked() ? "3" : "0");
        qoc7.put("qc1601c", bi.qc1601c.getText().toString().trim().length() > 0 ? bi.qc1601c.getText().toString() : "0");
        qoc7.put("qc1601d", bi.qc1601d.getText().toString().trim().length() > 0 ? bi.qc1601d.getText().toString() : "0");


        fc.setSqoc1(String.valueOf(qoc7));

    }
    
    
}
