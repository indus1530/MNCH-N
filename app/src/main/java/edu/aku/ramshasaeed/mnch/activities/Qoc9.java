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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc9Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc9 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc9);
        bi.setCallback(this);
        this.setTitle("Quality of Care 09");
        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc10.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc9);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc9 = new JSONObject();

        qoc9.put("qc2101a", bi.qc2101aa.isChecked() ? "1" : bi.qc2101ab.isChecked() ? "2" : "0");
        qoc9.put("qc2101b", bi.qc2101ba.isChecked() ? "1" : bi.qc2101bb.isChecked() ? "2" : bi.qc2101bc.isChecked() ? "3" : "0");
        qoc9.put("qc2101c", bi.qc2101c.getText().toString().trim().length() > 0 ? bi.qc2101c.getText().toString() : "0");
        qoc9.put("qc2101d", bi.qc2101d.getText().toString().trim().length() > 0 ? bi.qc2101d.getText().toString() : "0");

        qoc9.put("qc2102a", bi.qc2102aa.isChecked() ? "1" : bi.qc2102ab.isChecked() ? "2" : "0");
        qoc9.put("qc2102b", bi.qc2102ba.isChecked() ? "1" : bi.qc2102bb.isChecked() ? "2" : bi.qc2102bc.isChecked() ? "3" : "0");
        qoc9.put("qc2102c", bi.qc2102c.getText().toString().trim().length() > 0 ? bi.qc2102c.getText().toString() : "0");
        qoc9.put("qc2102d", bi.qc2102d.getText().toString().trim().length() > 0 ? bi.qc2102d.getText().toString() : "0");

        qoc9.put("qc2103a", bi.qc2103aa.isChecked() ? "1" : bi.qc2103ab.isChecked() ? "2" : "0");
        qoc9.put("qc2103b", bi.qc2103ba.isChecked() ? "1" : bi.qc2103bb.isChecked() ? "2" : bi.qc2103bc.isChecked() ? "3" : "0");
        qoc9.put("qc2103c", bi.qc2103c.getText().toString().trim().length() > 0 ? bi.qc2103c.getText().toString() : "0");
        qoc9.put("qc2103d", bi.qc2103d.getText().toString().trim().length() > 0 ? bi.qc2103d.getText().toString() : "0");

        qoc9.put("qc2104a", bi.qc2104aa.isChecked() ? "1" : bi.qc2104ab.isChecked() ? "2" : "0");
        qoc9.put("qc2104b", bi.qc2104ba.isChecked() ? "1" : bi.qc2104bb.isChecked() ? "2" : bi.qc2104bc.isChecked() ? "3" : "0");
        qoc9.put("qc2104c", bi.qc2104c.getText().toString().trim().length() > 0 ? bi.qc2104c.getText().toString() : "0");
        qoc9.put("qc2104d", bi.qc2104d.getText().toString().trim().length() > 0 ? bi.qc2104d.getText().toString() : "0");

        qoc9.put("qc2105a", bi.qc2105aa.isChecked() ? "1" : bi.qc2105ab.isChecked() ? "2" : "0");
        qoc9.put("qc2105b", bi.qc2105ba.isChecked() ? "1" : bi.qc2105bb.isChecked() ? "2" : bi.qc2105bc.isChecked() ? "3" : "0");
        qoc9.put("qc2105c", bi.qc2105c.getText().toString().trim().length() > 0 ? bi.qc2105c.getText().toString() : "0");
        qoc9.put("qc2105d", bi.qc2105d.getText().toString().trim().length() > 0 ? bi.qc2105d.getText().toString() : "0");

        qoc9.put("qc2106a", bi.qc2106aa.isChecked() ? "1" : bi.qc2106ab.isChecked() ? "2" : "0");
        qoc9.put("qc2106b", bi.qc2106ba.isChecked() ? "1" : bi.qc2106bb.isChecked() ? "2" : bi.qc2106bc.isChecked() ? "3" : "0");
        qoc9.put("qc2106c", bi.qc2106c.getText().toString().trim().length() > 0 ? bi.qc2106c.getText().toString() : "0");
        qoc9.put("qc2106d", bi.qc2106d.getText().toString().trim().length() > 0 ? bi.qc2106d.getText().toString() : "0");


        qoc9.put("qc2201a", bi.qc2201aa.isChecked() ? "1" : bi.qc2201ab.isChecked() ? "2" : "0");
        qoc9.put("qc2201b", bi.qc2201ba.isChecked() ? "1" : bi.qc2201bb.isChecked() ? "2" : bi.qc2201bc.isChecked() ? "3" : "0");
        qoc9.put("qc2201c", bi.qc2201c.getText().toString().trim().length() > 0 ? bi.qc2201c.getText().toString() : "0");
        qoc9.put("qc2201d", bi.qc2201d.getText().toString().trim().length() > 0 ? bi.qc2201d.getText().toString() : "0");


        qoc9.put("qc2301a", bi.qc2301aa.isChecked() ? "1" : bi.qc2301ab.isChecked() ? "2" : "0");
        qoc9.put("qc2301b", bi.qc2301ba.isChecked() ? "1" : bi.qc2301bb.isChecked() ? "2" : bi.qc2301bc.isChecked() ? "3" : "0");
        qoc9.put("qc2301c", bi.qc2301c.getText().toString().trim().length() > 0 ? bi.qc2301c.getText().toString() : "0");
        qoc9.put("qc2301d", bi.qc2301d.getText().toString().trim().length() > 0 ? bi.qc2301d.getText().toString() : "0");

        
        qoc9.put("qd0101a", bi.qd0101aa.isChecked() ? "1" : bi.qd0101ab.isChecked() ? "2" : "0");
        qoc9.put("qd0101b", bi.qd0101ba.isChecked() ? "1" : bi.qd0101bb.isChecked() ? "2" : bi.qd0101bc.isChecked() ? "3" : "0");
        qoc9.put("qd0101c", bi.qd0101c.getText().toString().trim().length() > 0 ? bi.qd0101c.getText().toString() : "0");
        qoc9.put("qd0101d", bi.qd0101d.getText().toString().trim().length() > 0 ? bi.qd0101d.getText().toString() : "0");

        qoc9.put("qd0102a", bi.qd0102aa.isChecked() ? "1" : bi.qd0102ab.isChecked() ? "2" : "0");
        qoc9.put("qd0102b", bi.qd0102ba.isChecked() ? "1" : bi.qd0102bb.isChecked() ? "2" : bi.qd0102bc.isChecked() ? "3" : "0");
        qoc9.put("qd0102c", bi.qd0102c.getText().toString().trim().length() > 0 ? bi.qd0102c.getText().toString() : "0");
        qoc9.put("qd0102d", bi.qd0102d.getText().toString().trim().length() > 0 ? bi.qd0102d.getText().toString() : "0");

        qoc9.put("qd0103a", bi.qd0103aa.isChecked() ? "1" : bi.qd0103ab.isChecked() ? "2" : "0");
        qoc9.put("qd0103b", bi.qd0103ba.isChecked() ? "1" : bi.qd0103bb.isChecked() ? "2" : bi.qd0103bc.isChecked() ? "3" : "0");
        qoc9.put("qd0103c", bi.qd0103c.getText().toString().trim().length() > 0 ? bi.qd0103c.getText().toString() : "0");
        qoc9.put("qd0103d", bi.qd0103d.getText().toString().trim().length() > 0 ? bi.qd0103d.getText().toString() : "0");

        qoc9.put("qd0104a", bi.qd0104aa.isChecked() ? "1" : bi.qd0104ab.isChecked() ? "2" : "0");
        qoc9.put("qd0104b", bi.qd0104ba.isChecked() ? "1" : bi.qd0104bb.isChecked() ? "2" : bi.qd0104bc.isChecked() ? "3" : "0");
        qoc9.put("qd0104c", bi.qd0104c.getText().toString().trim().length() > 0 ? bi.qd0104c.getText().toString() : "0");
        qoc9.put("qd0104d", bi.qd0104d.getText().toString().trim().length() > 0 ? bi.qd0104d.getText().toString() : "0");

        qoc9.put("qd0105a", bi.qd0105aa.isChecked() ? "1" : bi.qd0105ab.isChecked() ? "2" : "0");
        qoc9.put("qd0105b", bi.qd0105ba.isChecked() ? "1" : bi.qd0105bb.isChecked() ? "2" : bi.qd0105bc.isChecked() ? "3" : "0");
        qoc9.put("qd0105c", bi.qd0105c.getText().toString().trim().length() > 0 ? bi.qd0105c.getText().toString() : "0");
        qoc9.put("qd0105d", bi.qd0105d.getText().toString().trim().length() > 0 ? bi.qd0105d.getText().toString() : "0");

        qoc9.put("qd0106a", bi.qd0106aa.isChecked() ? "1" : bi.qd0106ab.isChecked() ? "2" : "0");
        qoc9.put("qd0106b", bi.qd0106ba.isChecked() ? "1" : bi.qd0106bb.isChecked() ? "2" : bi.qd0106bc.isChecked() ? "3" : "0");
        qoc9.put("qd0106c", bi.qd0106c.getText().toString().trim().length() > 0 ? bi.qd0106c.getText().toString() : "0");
        qoc9.put("qd0106d", bi.qd0106d.getText().toString().trim().length() > 0 ? bi.qd0106d.getText().toString() : "0");

        qoc9.put("qd0107a", bi.qd0107aa.isChecked() ? "1" : bi.qd0107ab.isChecked() ? "2" : "0");
        qoc9.put("qd0107b", bi.qd0107ba.isChecked() ? "1" : bi.qd0107bb.isChecked() ? "2" : bi.qd0107bc.isChecked() ? "3" : "0");
        qoc9.put("qd0107c", bi.qd0107c.getText().toString().trim().length() > 0 ? bi.qd0107c.getText().toString() : "0");
        qoc9.put("qd0107d", bi.qd0107d.getText().toString().trim().length() > 0 ? bi.qd0107d.getText().toString() : "0");

        qoc9.put("qd0108a", bi.qd0108aa.isChecked() ? "1" : bi.qd0108ab.isChecked() ? "2" : "0");
        qoc9.put("qd0108b", bi.qd0108ba.isChecked() ? "1" : bi.qd0108bb.isChecked() ? "2" : bi.qd0108bc.isChecked() ? "3" : "0");
        qoc9.put("qd0108c", bi.qd0108c.getText().toString().trim().length() > 0 ? bi.qd0108c.getText().toString() : "0");
        qoc9.put("qd0108d", bi.qd0108d.getText().toString().trim().length() > 0 ? bi.qd0108d.getText().toString() : "0");

        qoc9.put("qd0109a", bi.qd0109aa.isChecked() ? "1" : bi.qd0109ab.isChecked() ? "2" : "0");
        qoc9.put("qd0109b", bi.qd0109ba.isChecked() ? "1" : bi.qd0109bb.isChecked() ? "2" : bi.qd0109bc.isChecked() ? "3" : "0");
        qoc9.put("qd0109c", bi.qd0109c.getText().toString().trim().length() > 0 ? bi.qd0109c.getText().toString() : "0");
        qoc9.put("qd0109d", bi.qd0109d.getText().toString().trim().length() > 0 ? bi.qd0109d.getText().toString() : "0");

        qoc9.put("qd0110a", bi.qd0110aa.isChecked() ? "1" : bi.qd0110ab.isChecked() ? "2" : "0");
        qoc9.put("qd0110b", bi.qd0110ba.isChecked() ? "1" : bi.qd0110bb.isChecked() ? "2" : bi.qd0110bc.isChecked() ? "3" : "0");
        qoc9.put("qd0110c", bi.qd0110c.getText().toString().trim().length() > 0 ? bi.qd0110c.getText().toString() : "0");
        qoc9.put("qd0110d", bi.qd0110d.getText().toString().trim().length() > 0 ? bi.qd0110d.getText().toString() : "0");

        qoc9.put("qd0111a", bi.qd0111aa.isChecked() ? "1" : bi.qd0111ab.isChecked() ? "2" : "0");
        qoc9.put("qd0111b", bi.qd0111ba.isChecked() ? "1" : bi.qd0111bb.isChecked() ? "2" : bi.qd0111bc.isChecked() ? "3" : "0");
        qoc9.put("qd0111c", bi.qd0111c.getText().toString().trim().length() > 0 ? bi.qd0111c.getText().toString() : "0");
        qoc9.put("qd0111d", bi.qd0111d.getText().toString().trim().length() > 0 ? bi.qd0111d.getText().toString() : "0");

        qoc9.put("qd0112a", bi.qd0112aa.isChecked() ? "1" : bi.qd0112ab.isChecked() ? "2" : "0");
        qoc9.put("qd0112b", bi.qd0112ba.isChecked() ? "1" : bi.qd0112bb.isChecked() ? "2" : bi.qd0112bc.isChecked() ? "3" : "0");
        qoc9.put("qd0112c", bi.qd0112c.getText().toString().trim().length() > 0 ? bi.qd0112c.getText().toString() : "0");
        qoc9.put("qd0112d", bi.qd0112d.getText().toString().trim().length() > 0 ? bi.qd0112d.getText().toString() : "0");

        qoc9.put("qd0113a", bi.qd0113aa.isChecked() ? "1" : bi.qd0113ab.isChecked() ? "2" : "0");
        qoc9.put("qd0113b", bi.qd0113ba.isChecked() ? "1" : bi.qd0113bb.isChecked() ? "2" : bi.qd0113bc.isChecked() ? "3" : "0");
        qoc9.put("qd0113c", bi.qd0113c.getText().toString().trim().length() > 0 ? bi.qd0113c.getText().toString() : "0");
        qoc9.put("qd0113d", bi.qd0113d.getText().toString().trim().length() > 0 ? bi.qd0113d.getText().toString() : "0");

        qoc9.put("qd0114a", bi.qd0114aa.isChecked() ? "1" : bi.qd0114ab.isChecked() ? "2" : "0");
        qoc9.put("qd0114b", bi.qd0114ba.isChecked() ? "1" : bi.qd0114bb.isChecked() ? "2" : bi.qd0114bc.isChecked() ? "3" : "0");
        qoc9.put("qd0114c", bi.qd0114c.getText().toString().trim().length() > 0 ? bi.qd0114c.getText().toString() : "0");
        qoc9.put("qd0114d", bi.qd0114d.getText().toString().trim().length() > 0 ? bi.qd0114d.getText().toString() : "0");

        qoc9.put("qd0115a", bi.qd0115aa.isChecked() ? "1" : bi.qd0115ab.isChecked() ? "2" : "0");
        qoc9.put("qd0115b", bi.qd0115ba.isChecked() ? "1" : bi.qd0115bb.isChecked() ? "2" : bi.qd0115bc.isChecked() ? "3" : "0");
        qoc9.put("qd0115c", bi.qd0115c.getText().toString().trim().length() > 0 ? bi.qd0115c.getText().toString() : "0");
        qoc9.put("qd0115d", bi.qd0115d.getText().toString().trim().length() > 0 ? bi.qd0115d.getText().toString() : "0");

        qoc9.put("qd0116a", bi.qd0116aa.isChecked() ? "1" : bi.qd0116ab.isChecked() ? "2" : "0");
        qoc9.put("qd0116b", bi.qd0116ba.isChecked() ? "1" : bi.qd0116bb.isChecked() ? "2" : bi.qd0116bc.isChecked() ? "3" : "0");
        qoc9.put("qd0116c", bi.qd0116c.getText().toString().trim().length() > 0 ? bi.qd0116c.getText().toString() : "0");
        qoc9.put("qd0116d", bi.qd0116d.getText().toString().trim().length() > 0 ? bi.qd0116d.getText().toString() : "0");


        qoc9.put("qd0201a", bi.qd0201aa.isChecked() ? "1" : bi.qd0201ab.isChecked() ? "2" : "0");
        qoc9.put("qd0201b", bi.qd0201ba.isChecked() ? "1" : bi.qd0201bb.isChecked() ? "2" : bi.qd0201bc.isChecked() ? "3" : "0");
        qoc9.put("qd0201c", bi.qd0201c.getText().toString().trim().length() > 0 ? bi.qd0201c.getText().toString() : "0");
        qoc9.put("qd0201d", bi.qd0201d.getText().toString().trim().length() > 0 ? bi.qd0201d.getText().toString() : "0");

        qoc9.put("qd0202a", bi.qd0202aa.isChecked() ? "1" : bi.qd0202ab.isChecked() ? "2" : "0");
        qoc9.put("qd0202b", bi.qd0202ba.isChecked() ? "1" : bi.qd0202bb.isChecked() ? "2" : bi.qd0202bc.isChecked() ? "3" : "0");
        qoc9.put("qd0202c", bi.qd0202c.getText().toString().trim().length() > 0 ? bi.qd0202c.getText().toString() : "0");
        qoc9.put("qd0202d", bi.qd0202d.getText().toString().trim().length() > 0 ? bi.qd0202d.getText().toString() : "0");

        qoc9.put("qd0203a", bi.qd0203aa.isChecked() ? "1" : bi.qd0203ab.isChecked() ? "2" : "0");
        qoc9.put("qd0203b", bi.qd0203ba.isChecked() ? "1" : bi.qd0203bb.isChecked() ? "2" : bi.qd0203bc.isChecked() ? "3" : "0");
        qoc9.put("qd0203c", bi.qd0203c.getText().toString().trim().length() > 0 ? bi.qd0203c.getText().toString() : "0");
        qoc9.put("qd0203d", bi.qd0203d.getText().toString().trim().length() > 0 ? bi.qd0203d.getText().toString() : "0");


        fc.setSqoc9(String.valueOf(qoc9));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qc2101aa.isChecked()){
            bi.qc2101b.clearCheck();
            bi.qc2101c.setEnabled(true);
        } else {
            bi.qc2101c.setEnabled(false);
        }

        if (!bi.qc2102aa.isChecked()){
            bi.qc2102b.clearCheck();
            bi.qc2102c.setEnabled(true);
        } else {
            bi.qc2102c.setEnabled(false);
        }

        if (!bi.qc2103aa.isChecked()){
            bi.qc2103b.clearCheck();
            bi.qc2103c.setEnabled(true);
        } else {
            bi.qc2103c.setEnabled(false);
        }

        if (!bi.qc2104aa.isChecked()){
            bi.qc2104b.clearCheck();
            bi.qc2104c.setEnabled(true);
        } else {
            bi.qc2104c.setEnabled(false);
        }

        if (!bi.qc2105aa.isChecked()){
            bi.qc2105b.clearCheck();
            bi.qc2105c.setEnabled(true);
        } else {
            bi.qc2105c.setEnabled(false);
        }

        if (!bi.qc2106aa.isChecked()){
            bi.qc2106b.clearCheck();
            bi.qc2106c.setEnabled(true);
        } else {
            bi.qc2106c.setEnabled(false);
        }


        if (!bi.qc2201aa.isChecked()){
            bi.qc2201b.clearCheck();
            bi.qc2201c.setEnabled(true);
        } else {
            bi.qc2201c.setEnabled(false);
        }


        if (!bi.qc2301aa.isChecked()){
            bi.qc2301b.clearCheck();
            bi.qc2301c.setEnabled(true);
        } else {
            bi.qc2301c.setEnabled(false);
        }


        if (!bi.qd0101aa.isChecked()){
            bi.qd0101b.clearCheck();
            bi.qd0101c.setEnabled(true);
        } else {
            bi.qd0101c.setEnabled(false);
        }

        if (!bi.qd0102aa.isChecked()){
            bi.qd0102b.clearCheck();
            bi.qd0102c.setEnabled(true);
        } else {
            bi.qd0102c.setEnabled(false);
        }

        if (!bi.qd0103aa.isChecked()){
            bi.qd0103b.clearCheck();
            bi.qd0103c.setEnabled(true);
        } else {
            bi.qd0103c.setEnabled(false);
        }

        if (!bi.qd0104aa.isChecked()){
            bi.qd0104b.clearCheck();
            bi.qd0104c.setEnabled(true);
        } else {
            bi.qd0104c.setEnabled(false);
        }

        if (!bi.qd0105aa.isChecked()){
            bi.qd0105b.clearCheck();
            bi.qd0105c.setEnabled(true);
        } else {
            bi.qd0105c.setEnabled(false);
        }

        if (!bi.qd0106aa.isChecked()){
            bi.qd0106b.clearCheck();
            bi.qd0106c.setEnabled(true);
        } else {
            bi.qd0106c.setEnabled(false);
        }

        if (!bi.qd0107aa.isChecked()){
            bi.qd0107b.clearCheck();
            bi.qd0107c.setEnabled(true);
        } else {
            bi.qd0107c.setEnabled(false);
        }

        if (!bi.qd0108aa.isChecked()){
            bi.qd0108b.clearCheck();
            bi.qd0108c.setEnabled(true);
        } else {
            bi.qd0108c.setEnabled(false);
        }

        if (!bi.qd0109aa.isChecked()){
            bi.qd0109b.clearCheck();
            bi.qd0109c.setEnabled(true);
        } else {
            bi.qd0109c.setEnabled(false);
        }

        if (!bi.qd0110aa.isChecked()){
            bi.qd0110b.clearCheck();
            bi.qd0110c.setEnabled(true);
        } else {
            bi.qd0110c.setEnabled(false);
        }

        if (!bi.qd0111aa.isChecked()){
            bi.qd0111b.clearCheck();
            bi.qd0111c.setEnabled(true);
        } else {
            bi.qd0111c.setEnabled(false);
        }

        if (!bi.qd0112aa.isChecked()){
            bi.qd0112b.clearCheck();
            bi.qd0112c.setEnabled(true);
        } else {
            bi.qd0112c.setEnabled(false);
        }

        if (!bi.qd0113aa.isChecked()){
            bi.qd0113b.clearCheck();
            bi.qd0113c.setEnabled(true);
        } else {
            bi.qd0113c.setEnabled(false);
        }

        if (!bi.qd0114aa.isChecked()){
            bi.qd0114b.clearCheck();
            bi.qd0114c.setEnabled(true);
        } else {
            bi.qd0114c.setEnabled(false);
        }

        if (!bi.qd0115aa.isChecked()){
            bi.qd0115b.clearCheck();
            bi.qd0115c.setEnabled(true);
        } else {
            bi.qd0115c.setEnabled(false);
        }

        if (!bi.qd0116aa.isChecked()){
            bi.qd0116b.clearCheck();
            bi.qd0116c.setEnabled(true);
        } else {
            bi.qd0116c.setEnabled(false);
        }
        
        

        if (!bi.qd0201aa.isChecked()){
            bi.qd0201b.clearCheck();
            bi.qd0201c.setEnabled(true);
        } else {
            bi.qd0201c.setEnabled(false);
        }

        if (!bi.qd0202aa.isChecked()){
            bi.qd0202b.clearCheck();
            bi.qd0202c.setEnabled(true);
        } else {
            bi.qd0202c.setEnabled(false);
        }

        if (!bi.qd0203aa.isChecked()){
            bi.qd0203b.clearCheck();
            bi.qd0203c.setEnabled(true);
        } else {
            bi.qd0203c.setEnabled(false);
        }

    }

    void events_call() {

        bi.qc2101a.setOnCheckedChangeListener(this);
        bi.qc2102a.setOnCheckedChangeListener(this);
        bi.qc2103a.setOnCheckedChangeListener(this);
        bi.qc2104a.setOnCheckedChangeListener(this);
        bi.qc2105a.setOnCheckedChangeListener(this);
        bi.qc2106a.setOnCheckedChangeListener(this);

        bi.qc2201a.setOnCheckedChangeListener(this);

        bi.qc2301a.setOnCheckedChangeListener(this);

        bi.qd0101a.setOnCheckedChangeListener(this);
        bi.qd0102a.setOnCheckedChangeListener(this);
        bi.qd0103a.setOnCheckedChangeListener(this);
        bi.qd0104a.setOnCheckedChangeListener(this);
        bi.qd0105a.setOnCheckedChangeListener(this);
        bi.qd0106a.setOnCheckedChangeListener(this);
        bi.qd0107a.setOnCheckedChangeListener(this);
        bi.qd0108a.setOnCheckedChangeListener(this);
        bi.qd0109a.setOnCheckedChangeListener(this);
        bi.qd0110a.setOnCheckedChangeListener(this);
        bi.qd0111a.setOnCheckedChangeListener(this);
        bi.qd0112a.setOnCheckedChangeListener(this);
        bi.qd0113a.setOnCheckedChangeListener(this);
        bi.qd0114a.setOnCheckedChangeListener(this);
        bi.qd0115a.setOnCheckedChangeListener(this);
        bi.qd0116a.setOnCheckedChangeListener(this);

        bi.qd0201a.setOnCheckedChangeListener(this);
        bi.qd0202a.setOnCheckedChangeListener(this);
        bi.qd0203a.setOnCheckedChangeListener(this);

    }

}
