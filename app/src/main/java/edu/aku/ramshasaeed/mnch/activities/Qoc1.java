package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc1Binding;
import edu.aku.ramshasaeed.mnch.validation.ExRunnable;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;



public class Qoc1 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener  {

    ActivityQoc1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc1);
        bi.setCallback(this);
        this.setTitle("Quality of Care 01");
        events_call();
    }


    public void BtnContinue() {
        if (!formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc2.class));
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

        validatorClass.EmptyCheckingContainer(this, bi.llqoc1);
        return false;
    }




    private void SaveDraft() throws JSONException {

        JSONObject qoc1 = new JSONObject();
        
        qoc1.put("qa0101a", bi.qa0101aa.isChecked() ? "1" : bi.qa0101ab.isChecked() ? "2" : bi.qa0101a97.isChecked() ? "97" : "0");
        qoc1.put("qa0101b", bi.qa0101ba.isChecked() ? "1" : bi.qa0101bb.isChecked() ? "2" : bi.qa0101b98.isChecked() ? "98" : "0");
        qoc1.put("qa0101c", bi.qa0101c.getText().toString().trim().length() > 0 ? bi.qa0101c.getText().toString() : "0");

        qoc1.put("qa0102a", bi.qa0102aa.isChecked() ? "1" : bi.qa0102ab.isChecked() ? "2" : bi.qa0102a97.isChecked() ? "97" : "0");
        qoc1.put("qa0102b", bi.qa0102ba.isChecked() ? "1" : bi.qa0102bb.isChecked() ? "2" : bi.qa0102b98.isChecked() ? "98" : "0");
        qoc1.put("qa0102c", bi.qa0102c.getText().toString().trim().length() > 0 ? bi.qa0102c.getText().toString() : "0");

        qoc1.put("qa0103a", bi.qa0103aa.isChecked() ? "1" : bi.qa0103ab.isChecked() ? "2" : bi.qa0103a97.isChecked() ? "97" : "0");
        qoc1.put("qa0103b", bi.qa0103ba.isChecked() ? "1" : bi.qa0103bb.isChecked() ? "2" : bi.qa0103b98.isChecked() ? "98" : "0");
        qoc1.put("qa0103c", bi.qa0103c.getText().toString().trim().length() > 0 ? bi.qa0103c.getText().toString() : "0");

        qoc1.put("qa0104a", bi.qa0104aa.isChecked() ? "1" : bi.qa0104ab.isChecked() ? "2" : bi.qa0104a97.isChecked() ? "97" : "0");
        qoc1.put("qa0104b", bi.qa0104ba.isChecked() ? "1" : bi.qa0104bb.isChecked() ? "2" : bi.qa0104b98.isChecked() ? "98" : "0");
        qoc1.put("qa0104c", bi.qa0104c.getText().toString().trim().length() > 0 ? bi.qa0104c.getText().toString() : "0");

        qoc1.put("qa0105a", bi.qa0105aa.isChecked() ? "1" : bi.qa0105ab.isChecked() ? "2" : bi.qa0105a97.isChecked() ? "97" : "0");
        qoc1.put("qa0105b", bi.qa0105ba.isChecked() ? "1" : bi.qa0105bb.isChecked() ? "2" : bi.qa0105b98.isChecked() ? "98" : "0");
        qoc1.put("qa0105c", bi.qa0105c.getText().toString().trim().length() > 0 ? bi.qa0105c.getText().toString() : "0");

        qoc1.put("qa0106a", bi.qa0106aa.isChecked() ? "1" : bi.qa0106ab.isChecked() ? "2" : bi.qa0106a97.isChecked() ? "97" : "0");
        qoc1.put("qa0106b", bi.qa0106ba.isChecked() ? "1" : bi.qa0106bb.isChecked() ? "2" : bi.qa0106b98.isChecked() ? "98" : "0");
        qoc1.put("qa0106c", bi.qa0106c.getText().toString().trim().length() > 0 ? bi.qa0106c.getText().toString() : "0");

        qoc1.put("qa0107a", bi.qa0107aa.isChecked() ? "1" : bi.qa0107ab.isChecked() ? "2" : bi.qa0107a97.isChecked() ? "97" : "0");
        qoc1.put("qa0107b", bi.qa0107ba.isChecked() ? "1" : bi.qa0107bb.isChecked() ? "2" : bi.qa0107b98.isChecked() ? "98" : "0");
        qoc1.put("qa0107c", bi.qa0107c.getText().toString().trim().length() > 0 ? bi.qa0107c.getText().toString() : "0");

        qoc1.put("qa0108a", bi.qa0108aa.isChecked() ? "1" : bi.qa0108ab.isChecked() ? "2" : bi.qa0108a97.isChecked() ? "97" : "0");
        qoc1.put("qa0108b", bi.qa0108ba.isChecked() ? "1" : bi.qa0108bb.isChecked() ? "2" : bi.qa0108b98.isChecked() ? "98" : "0");
        qoc1.put("qa0108c", bi.qa0108c.getText().toString().trim().length() > 0 ? bi.qa0108c.getText().toString() : "0");

        qoc1.put("qa0109a", bi.qa0109aa.isChecked() ? "1" : bi.qa0109ab.isChecked() ? "2" : bi.qa0109a97.isChecked() ? "97" : "0");
        qoc1.put("qa0109b", bi.qa0109ba.isChecked() ? "1" : bi.qa0109bb.isChecked() ? "2" : bi.qa0109b98.isChecked() ? "98" : "0");
        qoc1.put("qa0109c", bi.qa0109c.getText().toString().trim().length() > 0 ? bi.qa0109c.getText().toString() : "0");


        qoc1.put("qa0201a", bi.qa0201aa.isChecked() ? "1" : bi.qa0201ab.isChecked() ? "2" : bi.qa0201a97.isChecked() ? "97" : "0");
        qoc1.put("qa0201b", bi.qa0201ba.isChecked() ? "1" : bi.qa0201bb.isChecked() ? "2" : bi.qa0201b98.isChecked() ? "98" : "0");
        qoc1.put("qa0201c", bi.qa0201c.getText().toString().trim().length() > 0 ? bi.qa0201c.getText().toString() : "0");

        qoc1.put("qa0202a", bi.qa0202aa.isChecked() ? "1" : bi.qa0202ab.isChecked() ? "2" : bi.qa0202a97.isChecked() ? "97" : "0");
        qoc1.put("qa0202b", bi.qa0202ba.isChecked() ? "1" : bi.qa0202bb.isChecked() ? "2" : bi.qa0202b98.isChecked() ? "98" : "0");
        qoc1.put("qa0202c", bi.qa0202c.getText().toString().trim().length() > 0 ? bi.qa0202c.getText().toString() : "0");

        
        qoc1.put("qa0301a", bi.qa0301aa.isChecked() ? "1" : bi.qa0301ab.isChecked() ? "2" : bi.qa0301a97.isChecked() ? "97" : "0");
        qoc1.put("qa0301b", bi.qa0301ba.isChecked() ? "1" : bi.qa0301bb.isChecked() ? "2" : bi.qa0301b98.isChecked() ? "98" : "0");
        qoc1.put("qa0301c", bi.qa0301c.getText().toString().trim().length() > 0 ? bi.qa0301c.getText().toString() : "0");

        qoc1.put("qa0302a", bi.qa0302aa.isChecked() ? "1" : bi.qa0302ab.isChecked() ? "2" : bi.qa0302a97.isChecked() ? "97" : "0");
        qoc1.put("qa0302b", bi.qa0302ba.isChecked() ? "1" : bi.qa0302bb.isChecked() ? "2" : bi.qa0302b98.isChecked() ? "98" : "0");
        qoc1.put("qa0302c", bi.qa0302c.getText().toString().trim().length() > 0 ? bi.qa0302c.getText().toString() : "0");

        qoc1.put("qa0303a", bi.qa0303aa.isChecked() ? "1" : bi.qa0303ab.isChecked() ? "2" : bi.qa0303a97.isChecked() ? "97" : "0");
        qoc1.put("qa0303b", bi.qa0303ba.isChecked() ? "1" : bi.qa0303bb.isChecked() ? "2" : bi.qa0303b98.isChecked() ? "98" : "0");
        qoc1.put("qa0303c", bi.qa0303c.getText().toString().trim().length() > 0 ? bi.qa0303c.getText().toString() : "0");

        qoc1.put("qa0304a", bi.qa0304aa.isChecked() ? "1" : bi.qa0304ab.isChecked() ? "2" : bi.qa0304a97.isChecked() ? "97" : "0");
        qoc1.put("qa0304b", bi.qa0304ba.isChecked() ? "1" : bi.qa0304bb.isChecked() ? "2" : bi.qa0304b98.isChecked() ? "98" : "0");
        qoc1.put("qa0304c", bi.qa0304c.getText().toString().trim().length() > 0 ? bi.qa0304c.getText().toString() : "0");

        qoc1.put("qa0305a", bi.qa0305aa.isChecked() ? "1" : bi.qa0305ab.isChecked() ? "2" : bi.qa0305a97.isChecked() ? "97" : "0");
        qoc1.put("qa0305b", bi.qa0305ba.isChecked() ? "1" : bi.qa0305bb.isChecked() ? "2" : bi.qa0305b98.isChecked() ? "98" : "0");
        qoc1.put("qa0305c", bi.qa0305c.getText().toString().trim().length() > 0 ? bi.qa0305c.getText().toString() : "0");



        qoc1.put("qa0401a", bi.qa0401aa.isChecked() ? "1" : bi.qa0401ab.isChecked() ? "2" : bi.qa0401a97.isChecked() ? "97" : "0");
        qoc1.put("qa0401b", bi.qa0401ba.isChecked() ? "1" : bi.qa0401bb.isChecked() ? "2" : bi.qa0401b98.isChecked() ? "98" : "0");
        qoc1.put("qa0401c", bi.qa0401c.getText().toString().trim().length() > 0 ? bi.qa0401c.getText().toString() : "0");

        qoc1.put("qa0402a", bi.qa0402aa.isChecked() ? "1" : bi.qa0402ab.isChecked() ? "2" : bi.qa0402a97.isChecked() ? "97" : "0");
        qoc1.put("qa0402b", bi.qa0402ba.isChecked() ? "1" : bi.qa0402bb.isChecked() ? "2" : bi.qa0402b98.isChecked() ? "98" : "0");
        qoc1.put("qa0402c", bi.qa0402c.getText().toString().trim().length() > 0 ? bi.qa0402c.getText().toString() : "0");

        qoc1.put("qa0403a", bi.qa0403aa.isChecked() ? "1" : bi.qa0403ab.isChecked() ? "2" : bi.qa0403a97.isChecked() ? "97" : "0");
        qoc1.put("qa0403b", bi.qa0403ba.isChecked() ? "1" : bi.qa0403bb.isChecked() ? "2" : bi.qa0403b98.isChecked() ? "98" : "0");
        qoc1.put("qa0403c", bi.qa0403c.getText().toString().trim().length() > 0 ? bi.qa0403c.getText().toString() : "0");

        qoc1.put("qa0404a", bi.qa0404aa.isChecked() ? "1" : bi.qa0404ab.isChecked() ? "2" : bi.qa0404a97.isChecked() ? "97" : "0");
        qoc1.put("qa0404b", bi.qa0404ba.isChecked() ? "1" : bi.qa0404bb.isChecked() ? "2" : bi.qa0404b98.isChecked() ? "98" : "0");
        qoc1.put("qa0404c", bi.qa0404c.getText().toString().trim().length() > 0 ? bi.qa0404c.getText().toString() : "0");



        qoc1.put("qa0501a", bi.qa0501aa.isChecked() ? "1" : bi.qa0501ab.isChecked() ? "2" : bi.qa0501a97.isChecked() ? "97" : "0");
        qoc1.put("qa0501b", bi.qa0501ba.isChecked() ? "1" : bi.qa0501bb.isChecked() ? "2" : bi.qa0501b98.isChecked() ? "98" : "0");
        qoc1.put("qa0501c", bi.qa0501c.getText().toString().trim().length() > 0 ? bi.qa0501c.getText().toString() : "0");

        qoc1.put("qa0502a", bi.qa0502aa.isChecked() ? "1" : bi.qa0502ab.isChecked() ? "2" : bi.qa0502a97.isChecked() ? "97" : "0");
        qoc1.put("qa0502b", bi.qa0502ba.isChecked() ? "1" : bi.qa0502bb.isChecked() ? "2" : bi.qa0502b98.isChecked() ? "98" : "0");
        qoc1.put("qa0502c", bi.qa0502c.getText().toString().trim().length() > 0 ? bi.qa0502c.getText().toString() : "0");

        qoc1.put("qa0503a", bi.qa0503aa.isChecked() ? "1" : bi.qa0503ab.isChecked() ? "2" : bi.qa0503a97.isChecked() ? "97" : "0");
        qoc1.put("qa0503b", bi.qa0503ba.isChecked() ? "1" : bi.qa0503bb.isChecked() ? "2" : bi.qa0503b98.isChecked() ? "98" : "0");
        qoc1.put("qa0503c", bi.qa0503c.getText().toString().trim().length() > 0 ? bi.qa0503c.getText().toString() : "0");

        qoc1.put("qa0504a", bi.qa0504aa.isChecked() ? "1" : bi.qa0504ab.isChecked() ? "2" : bi.qa0504a97.isChecked() ? "97" : "0");
        qoc1.put("qa0504b", bi.qa0504ba.isChecked() ? "1" : bi.qa0504bb.isChecked() ? "2" : bi.qa0504b98.isChecked() ? "98" : "0");
        qoc1.put("qa0504c", bi.qa0504c.getText().toString().trim().length() > 0 ? bi.qa0504c.getText().toString() : "0");


        /*preFix.equals("QOC");
        JSONObject json_qoc1 = GeneratorClass.getContainerJSON(bi.llqoc1, true, preFix);*/

        fc.setSqoc1(String.valueOf(qoc1));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qa0101aa.isChecked()){
            bi.qa0101b.clearCheck();
            bi.qa0101c.setEnabled(false);
        } else {
            bi.qa0101c.setEnabled(true);
        }

        if (!bi.qa0102aa.isChecked()){
            bi.qa0102b.clearCheck();
            bi.qa0102c.setEnabled(false);
        } else {
            bi.qa0102c.setEnabled(true);
        }

        if (!bi.qa0103aa.isChecked()){
            bi.qa0103b.clearCheck();
            bi.qa0103c.setEnabled(false);
        } else {
            bi.qa0103c.setEnabled(true);
        }

        if (!bi.qa0104aa.isChecked()){
            bi.qa0104b.clearCheck();
            bi.qa0104c.setEnabled(false);
        } else {
            bi.qa0104c.setEnabled(true);
        }

        if (!bi.qa0105aa.isChecked()){
            bi.qa0105b.clearCheck();
            bi.qa0105c.setEnabled(false);
        } else {
            bi.qa0105c.setEnabled(true);
        }

        if (!bi.qa0106aa.isChecked()){
            bi.qa0106b.clearCheck();
            bi.qa0106c.setEnabled(false);
        } else {
            bi.qa0106c.setEnabled(true);
        }

        if (!bi.qa0107aa.isChecked()){
            bi.qa0107b.clearCheck();
            bi.qa0107c.setEnabled(false);
        } else {
            bi.qa0107c.setEnabled(true);
        }

        if (!bi.qa0108aa.isChecked()){
            bi.qa0108b.clearCheck();
            bi.qa0108c.setEnabled(false);
        } else {
            bi.qa0108c.setEnabled(true);
        }

        if (!bi.qa0109aa.isChecked()){
            bi.qa0109b.clearCheck();
            bi.qa0109c.setEnabled(false);
        } else {
            bi.qa0109c.setEnabled(true);
        }

        
        if (!bi.qa0201aa.isChecked()){
            bi.qa0201b.clearCheck();
            bi.qa0201c.setEnabled(false);
        } else {
            bi.qa0201c.setEnabled(true);
        }

        if (!bi.qa0202aa.isChecked()){
            bi.qa0202b.clearCheck();
            bi.qa0202c.setEnabled(false);
        } else {
            bi.qa0202c.setEnabled(true);
        }


        if (!bi.qa0301aa.isChecked()){
            bi.qa0301b.clearCheck();
            bi.qa0301c.setEnabled(false);
        } else {
            bi.qa0301c.setEnabled(true);
        }

        if (!bi.qa0302aa.isChecked()){
            bi.qa0302b.clearCheck();
            bi.qa0302c.setEnabled(false);
        } else {
            bi.qa0302c.setEnabled(true);
        }

        if (!bi.qa0303aa.isChecked()){
            bi.qa0303b.clearCheck();
            bi.qa0103c.setEnabled(false);
        } else {
            bi.qa0103c.setEnabled(true);
        }

        if (!bi.qa0304aa.isChecked()){
            bi.qa0304b.clearCheck();
            bi.qa0304c.setEnabled(false);
        } else {
            bi.qa0304c.setEnabled(true);
        }

        if (!bi.qa0305aa.isChecked()){
            bi.qa0305b.clearCheck();
            bi.qa0305c.setEnabled(false);
        } else {
            bi.qa0305c.setEnabled(true);
        }

        
        if (!bi.qa0401aa.isChecked()){
            bi.qa0401b.clearCheck();
            bi.qa0401c.setEnabled(false);
        } else {
            bi.qa0401c.setEnabled(true);
        }

        if (!bi.qa0402aa.isChecked()){
            bi.qa0402b.clearCheck();
            bi.qa0402c.setEnabled(false);
        } else {
            bi.qa0402c.setEnabled(true);
        }

        if (!bi.qa0403aa.isChecked()){
            bi.qa0403b.clearCheck();
            bi.qa0403c.setEnabled(false);
        } else {
            bi.qa0403c.setEnabled(true);
        }

        if (!bi.qa0404aa.isChecked()){
            bi.qa0404b.clearCheck();
            bi.qa0404c.setEnabled(false);
        } else {
            bi.qa0404c.setEnabled(true);
        }

        
        if (!bi.qa0501aa.isChecked()){
            bi.qa0501b.clearCheck();
            bi.qa0501c.setEnabled(false);
        } else {
            bi.qa0501c.setEnabled(true);
        }

        if (!bi.qa0502aa.isChecked()){
            bi.qa0502b.clearCheck();
            bi.qa0502c.setEnabled(false);
        } else {
            bi.qa0502c.setEnabled(true);
        }

        if (!bi.qa0503aa.isChecked()){
            bi.qa0503b.clearCheck();
            bi.qa0503c.setEnabled(false);
        } else {
            bi.qa0503c.setEnabled(true);
        }

        if (!bi.qa0504aa.isChecked()){
            bi.qa0504b.clearCheck();
            bi.qa0504c.setEnabled(false);
        } else {
            bi.qa0504c.setEnabled(true);
        }
    }

    void events_call() {

        bi.qa0101a.setOnCheckedChangeListener(this);
        bi.qa0102a.setOnCheckedChangeListener(this);
        bi.qa0103a.setOnCheckedChangeListener(this);
        bi.qa0104a.setOnCheckedChangeListener(this);
        bi.qa0105a.setOnCheckedChangeListener(this);
        bi.qa0106a.setOnCheckedChangeListener(this);
        bi.qa0107a.setOnCheckedChangeListener(this);
        bi.qa0108a.setOnCheckedChangeListener(this);
        bi.qa0109a.setOnCheckedChangeListener(this);

        bi.qa0201a.setOnCheckedChangeListener(this);
        bi.qa0202a.setOnCheckedChangeListener(this);

        bi.qa0301a.setOnCheckedChangeListener(this);
        bi.qa0302a.setOnCheckedChangeListener(this);
        bi.qa0303a.setOnCheckedChangeListener(this);
        bi.qa0304a.setOnCheckedChangeListener(this);
        bi.qa0305a.setOnCheckedChangeListener(this);

        bi.qa0401a.setOnCheckedChangeListener(this);
        bi.qa0402a.setOnCheckedChangeListener(this);
        bi.qa0403a.setOnCheckedChangeListener(this);
        bi.qa0404a.setOnCheckedChangeListener(this);

        bi.qa0501a.setOnCheckedChangeListener(this);
        bi.qa0502a.setOnCheckedChangeListener(this);
        bi.qa0503a.setOnCheckedChangeListener(this);
        bi.qa0504a.setOnCheckedChangeListener(this);

    }
}
