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

        JSONObject qoc3 = new JSONObject();

        qoc3.put("qa0717a", bi.qa0717aa.isChecked() ? "1" : bi.qa0717ab.isChecked() ? "2" : bi.qa0717a97.isChecked() ? "97" : "0");
        qoc3.put("qa0717b", bi.qa0717ba.isChecked() ? "1" : bi.qa0717bb.isChecked() ? "2" : bi.qa0717b98.isChecked() ? "98" : "0");
        qoc3.put("qa0717c", bi.qa0717c.getText().toString().trim().length() > 0 ? bi.qa0717c.getText().toString() : "0");

        qoc3.put("qa0718a", bi.qa0718aa.isChecked() ? "1" : bi.qa0718ab.isChecked() ? "2" : bi.qa0718a97.isChecked() ? "97" : "0");
        qoc3.put("qa0718b", bi.qa0718ba.isChecked() ? "1" : bi.qa0718bb.isChecked() ? "2" : bi.qa0718b98.isChecked() ? "98" : "0");
        qoc3.put("qa0718c", bi.qa0718c.getText().toString().trim().length() > 0 ? bi.qa0718c.getText().toString() : "0");

        qoc3.put("qa0719a", bi.qa0719aa.isChecked() ? "1" : bi.qa0719ab.isChecked() ? "2" : bi.qa0719a97.isChecked() ? "97" : "0");
        qoc3.put("qa0719b", bi.qa0719ba.isChecked() ? "1" : bi.qa0719bb.isChecked() ? "2" : bi.qa0719b98.isChecked() ? "98" : "0");
        qoc3.put("qa0719c", bi.qa0719c.getText().toString().trim().length() > 0 ? bi.qa0719c.getText().toString() : "0");

        qoc3.put("qa0720a", bi.qa0720aa.isChecked() ? "1" : bi.qa0720ab.isChecked() ? "2" : bi.qa0720a97.isChecked() ? "97" : "0");
        qoc3.put("qa0720b", bi.qa0720ba.isChecked() ? "1" : bi.qa0720bb.isChecked() ? "2" : bi.qa0720b98.isChecked() ? "98" : "0");
        qoc3.put("qa0720c", bi.qa0720c.getText().toString().trim().length() > 0 ? bi.qa0720c.getText().toString() : "0");

        qoc3.put("qa0721a", bi.qa0721aa.isChecked() ? "1" : bi.qa0721ab.isChecked() ? "2" : bi.qa0721a97.isChecked() ? "97" : "0");
        qoc3.put("qa0721b", bi.qa0721ba.isChecked() ? "1" : bi.qa0721bb.isChecked() ? "2" : bi.qa0721b98.isChecked() ? "98" : "0");
        qoc3.put("qa0721c", bi.qa0721c.getText().toString().trim().length() > 0 ? bi.qa0721c.getText().toString() : "0");

        
        
        qoc3.put("qa0801a", bi.qa0801aa.isChecked() ? "1" : bi.qa0801ab.isChecked() ? "2" : bi.qa0801a97.isChecked() ? "97" : "0");
        qoc3.put("qa0801b", bi.qa0801ba.isChecked() ? "1" : bi.qa0801bb.isChecked() ? "2" : bi.qa0801b98.isChecked() ? "98" : "0");
        qoc3.put("qa0801c", bi.qa0801c.getText().toString().trim().length() > 0 ? bi.qa0801c.getText().toString() : "0");

        qoc3.put("qa0802a", bi.qa0802aa.isChecked() ? "1" : bi.qa0802ab.isChecked() ? "2" : bi.qa0802a97.isChecked() ? "97" : "0");
        qoc3.put("qa0802b", bi.qa0802ba.isChecked() ? "1" : bi.qa0802bb.isChecked() ? "2" : bi.qa0802b98.isChecked() ? "98" : "0");
        qoc3.put("qa0802c", bi.qa0802c.getText().toString().trim().length() > 0 ? bi.qa0802c.getText().toString() : "0");

        qoc3.put("qa0803a", bi.qa0803aa.isChecked() ? "1" : bi.qa0803ab.isChecked() ? "2" : bi.qa0803a97.isChecked() ? "97" : "0");
        qoc3.put("qa0803b", bi.qa0803ba.isChecked() ? "1" : bi.qa0803bb.isChecked() ? "2" : bi.qa0803b98.isChecked() ? "98" : "0");
        qoc3.put("qa0803c", bi.qa0803c.getText().toString().trim().length() > 0 ? bi.qa0803c.getText().toString() : "0");

        qoc3.put("qa0804a", bi.qa0804aa.isChecked() ? "1" : bi.qa0804ab.isChecked() ? "2" : bi.qa0804a97.isChecked() ? "97" : "0");
        qoc3.put("qa0804b", bi.qa0804ba.isChecked() ? "1" : bi.qa0804bb.isChecked() ? "2" : bi.qa0804b98.isChecked() ? "98" : "0");
        qoc3.put("qa0804c", bi.qa0804c.getText().toString().trim().length() > 0 ? bi.qa0804c.getText().toString() : "0");

        qoc3.put("qa0805a", bi.qa0805aa.isChecked() ? "1" : bi.qa0805ab.isChecked() ? "2" : bi.qa0805a97.isChecked() ? "97" : "0");
        qoc3.put("qa0805b", bi.qa0805ba.isChecked() ? "1" : bi.qa0805bb.isChecked() ? "2" : bi.qa0805b98.isChecked() ? "98" : "0");
        qoc3.put("qa0805c", bi.qa0805c.getText().toString().trim().length() > 0 ? bi.qa0805c.getText().toString() : "0");

        
        
        
        qoc3.put("qb0101a", bi.qb0101aa.isChecked() ? "1" : bi.qb0101ab.isChecked() ? "2" : bi.qb0101a97.isChecked() ? "97" : "0");
        qoc3.put("qb0101b", bi.qb0101ba.isChecked() ? "1" : bi.qb0101bb.isChecked() ? "2" : bi.qb0101b98.isChecked() ? "98" : "0");
        qoc3.put("qb0101c", bi.qb0101c.getText().toString().trim().length() > 0 ? bi.qb0101c.getText().toString() : "0");

        qoc3.put("qb0102a", bi.qb0102aa.isChecked() ? "1" : bi.qb0102ab.isChecked() ? "2" : bi.qb0102a97.isChecked() ? "97" : "0");
        qoc3.put("qb0102b", bi.qb0102ba.isChecked() ? "1" : bi.qb0102bb.isChecked() ? "2" : bi.qb0102b98.isChecked() ? "98" : "0");
        qoc3.put("qb0102c", bi.qb0102c.getText().toString().trim().length() > 0 ? bi.qb0102c.getText().toString() : "0");

        qoc3.put("qb0103a", bi.qb0103aa.isChecked() ? "1" : bi.qb0103ab.isChecked() ? "2" : bi.qb0103a97.isChecked() ? "97" : "0");
        qoc3.put("qb0103b", bi.qb0103ba.isChecked() ? "1" : bi.qb0103bb.isChecked() ? "2" : bi.qb0103b98.isChecked() ? "98" : "0");
        qoc3.put("qb0103c", bi.qb0103c.getText().toString().trim().length() > 0 ? bi.qb0103c.getText().toString() : "0");

        qoc3.put("qb0104a", bi.qb0104aa.isChecked() ? "1" : bi.qb0104ab.isChecked() ? "2" : bi.qb0104a97.isChecked() ? "97" : "0");
        qoc3.put("qb0104b", bi.qb0104ba.isChecked() ? "1" : bi.qb0104bb.isChecked() ? "2" : bi.qb0104b98.isChecked() ? "98" : "0");
        qoc3.put("qb0104c", bi.qb0104c.getText().toString().trim().length() > 0 ? bi.qb0104c.getText().toString() : "0");

        qoc3.put("qb0105a", bi.qb0105aa.isChecked() ? "1" : bi.qb0105ab.isChecked() ? "2" : bi.qb0105a97.isChecked() ? "97" : "0");
        qoc3.put("qb0105b", bi.qb0105ba.isChecked() ? "1" : bi.qb0105bb.isChecked() ? "2" : bi.qb0105b98.isChecked() ? "98" : "0");
        qoc3.put("qb0105c", bi.qb0105c.getText().toString().trim().length() > 0 ? bi.qb0105c.getText().toString() : "0");

        qoc3.put("qb0106a", bi.qb0106aa.isChecked() ? "1" : bi.qb0106ab.isChecked() ? "2" : bi.qb0106a97.isChecked() ? "97" : "0");
        qoc3.put("qb0106b", bi.qb0106ba.isChecked() ? "1" : bi.qb0106bb.isChecked() ? "2" : bi.qb0106b98.isChecked() ? "98" : "0");
        qoc3.put("qb0106c", bi.qb0106c.getText().toString().trim().length() > 0 ? bi.qb0106c.getText().toString() : "0");

        qoc3.put("qb0107a", bi.qb0107aa.isChecked() ? "1" : bi.qb0107ab.isChecked() ? "2" : bi.qb0107a97.isChecked() ? "97" : "0");
        qoc3.put("qb0107b", bi.qb0107ba.isChecked() ? "1" : bi.qb0107bb.isChecked() ? "2" : bi.qb0107b98.isChecked() ? "98" : "0");
        qoc3.put("qb0107c", bi.qb0107c.getText().toString().trim().length() > 0 ? bi.qb0107c.getText().toString() : "0");

        qoc3.put("qb0108a", bi.qb0108aa.isChecked() ? "1" : bi.qb0108ab.isChecked() ? "2" : bi.qb0108a97.isChecked() ? "97" : "0");
        qoc3.put("qb0108b", bi.qb0108ba.isChecked() ? "1" : bi.qb0108bb.isChecked() ? "2" : bi.qb0108b98.isChecked() ? "98" : "0");
        qoc3.put("qb0108c", bi.qb0108c.getText().toString().trim().length() > 0 ? bi.qb0108c.getText().toString() : "0");

        qoc3.put("qb0109a", bi.qb0109aa.isChecked() ? "1" : bi.qb0109ab.isChecked() ? "2" : bi.qb0109a97.isChecked() ? "97" : "0");
        qoc3.put("qb0109b", bi.qb0109ba.isChecked() ? "1" : bi.qb0109bb.isChecked() ? "2" : bi.qb0109b98.isChecked() ? "98" : "0");
        qoc3.put("qb0109c", bi.qb0109c.getText().toString().trim().length() > 0 ? bi.qb0109c.getText().toString() : "0");

        qoc3.put("qb0110a", bi.qb0110aa.isChecked() ? "1" : bi.qb0110ab.isChecked() ? "2" : bi.qb0110a97.isChecked() ? "97" : "0");
        qoc3.put("qb0110b", bi.qb0110ba.isChecked() ? "1" : bi.qb0110bb.isChecked() ? "2" : bi.qb0110b98.isChecked() ? "98" : "0");
        qoc3.put("qb0110c", bi.qb0110c.getText().toString().trim().length() > 0 ? bi.qb0110c.getText().toString() : "0");

        qoc3.put("qb0111a", bi.qb0111aa.isChecked() ? "1" : bi.qb0111ab.isChecked() ? "2" : bi.qb0111a97.isChecked() ? "97" : "0");
        qoc3.put("qb0111b", bi.qb0111ba.isChecked() ? "1" : bi.qb0111bb.isChecked() ? "2" : bi.qb0111b98.isChecked() ? "98" : "0");
        qoc3.put("qb0111c", bi.qb0111c.getText().toString().trim().length() > 0 ? bi.qb0111c.getText().toString() : "0");

        qoc3.put("qb0112a", bi.qb0112aa.isChecked() ? "1" : bi.qb0112ab.isChecked() ? "2" : bi.qb0112a97.isChecked() ? "97" : "0");
        qoc3.put("qb0112b", bi.qb0112ba.isChecked() ? "1" : bi.qb0112bb.isChecked() ? "2" : bi.qb0112b98.isChecked() ? "98" : "0");
        qoc3.put("qb0112c", bi.qb0112c.getText().toString().trim().length() > 0 ? bi.qb0112c.getText().toString() : "0");

        qoc3.put("qb0113a", bi.qb0113aa.isChecked() ? "1" : bi.qb0113ab.isChecked() ? "2" : bi.qb0113a97.isChecked() ? "97" : "0");
        qoc3.put("qb0113b", bi.qb0113ba.isChecked() ? "1" : bi.qb0113bb.isChecked() ? "2" : bi.qb0113b98.isChecked() ? "98" : "0");
        qoc3.put("qb0113c", bi.qb0113c.getText().toString().trim().length() > 0 ? bi.qb0113c.getText().toString() : "0");

        qoc3.put("qb0114a", bi.qb0114aa.isChecked() ? "1" : bi.qb0114ab.isChecked() ? "2" : bi.qb0114a97.isChecked() ? "97" : "0");
        qoc3.put("qb0114b", bi.qb0114ba.isChecked() ? "1" : bi.qb0114bb.isChecked() ? "2" : bi.qb0114b98.isChecked() ? "98" : "0");
        qoc3.put("qb0114c", bi.qb0114c.getText().toString().trim().length() > 0 ? bi.qb0114c.getText().toString() : "0");


        /*preFix.equals("QOC");
        JSONObject json_qoc1 = GeneratorClass.getContainerJSON(bi.llqoc1, true, preFix);*/

        fc.setSqoc1(String.valueOf(qoc3));

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
