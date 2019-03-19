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
import edu.aku.ramshasaeed.mnch.databinding.ActivityQoc8Binding;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;
import static edu.aku.ramshasaeed.mnch.activities.RSDInfoActivity.fc;

public class Qoc8 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityQoc8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_qoc8);
        bi.setCallback(this);
        this.setTitle("Quality of Care 08");
        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(this, Qoc9.class));
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

        return validatorClass.EmptyCheckingContainer(this, bi.llqoc8);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc8 = new JSONObject();

        qoc8.put("qc1701a", bi.qc1701aa.isChecked() ? "1" : bi.qc1701ab.isChecked() ? "2" : "0");
        qoc8.put("qc1701b", bi.qc1701ba.isChecked() ? "1" : bi.qc1701bb.isChecked() ? "2" : bi.qc1701bc.isChecked() ? "3" : "0");
        qoc8.put("qc1701c", bi.qc1701c.getText().toString().trim().length() > 0 ? bi.qc1701c.getText().toString() : "0");
        qoc8.put("qc1701d", bi.qc1701d.getText().toString().trim().length() > 0 ? bi.qc1701d.getText().toString() : "0");

        qoc8.put("qc1702a", bi.qc1702aa.isChecked() ? "1" : bi.qc1702ab.isChecked() ? "2" : "0");
        qoc8.put("qc1702b", bi.qc1702ba.isChecked() ? "1" : bi.qc1702bb.isChecked() ? "2" : bi.qc1702bc.isChecked() ? "3" : "0");
        qoc8.put("qc1702c", bi.qc1702c.getText().toString().trim().length() > 0 ? bi.qc1702c.getText().toString() : "0");
        qoc8.put("qc1702d", bi.qc1702d.getText().toString().trim().length() > 0 ? bi.qc1702d.getText().toString() : "0");

        qoc8.put("qc1703a", bi.qc1703aa.isChecked() ? "1" : bi.qc1703ab.isChecked() ? "2" : "0");
        qoc8.put("qc1703b", bi.qc1703ba.isChecked() ? "1" : bi.qc1703bb.isChecked() ? "2" : bi.qc1703bc.isChecked() ? "3" : "0");
        qoc8.put("qc1703c", bi.qc1703c.getText().toString().trim().length() > 0 ? bi.qc1703c.getText().toString() : "0");
        qoc8.put("qc1703d", bi.qc1703d.getText().toString().trim().length() > 0 ? bi.qc1703d.getText().toString() : "0");

        qoc8.put("qc1704a", bi.qc1704aa.isChecked() ? "1" : bi.qc1704ab.isChecked() ? "2" : "0");
        qoc8.put("qc1704b", bi.qc1704ba.isChecked() ? "1" : bi.qc1704bb.isChecked() ? "2" : bi.qc1704bc.isChecked() ? "3" : "0");
        qoc8.put("qc1704c", bi.qc1704c.getText().toString().trim().length() > 0 ? bi.qc1704c.getText().toString() : "0");
        qoc8.put("qc1704d", bi.qc1704d.getText().toString().trim().length() > 0 ? bi.qc1704d.getText().toString() : "0");

        qoc8.put("qc1705a", bi.qc1705aa.isChecked() ? "1" : bi.qc1705ab.isChecked() ? "2" : "0");
        qoc8.put("qc1705b", bi.qc1705ba.isChecked() ? "1" : bi.qc1705bb.isChecked() ? "2" : bi.qc1705bc.isChecked() ? "3" : "0");
        qoc8.put("qc1705c", bi.qc1705c.getText().toString().trim().length() > 0 ? bi.qc1705c.getText().toString() : "0");
        qoc8.put("qc1705d", bi.qc1705d.getText().toString().trim().length() > 0 ? bi.qc1705d.getText().toString() : "0");

        qoc8.put("qc1706a", bi.qc1706aa.isChecked() ? "1" : bi.qc1706ab.isChecked() ? "2" : "0");
        qoc8.put("qc1706b", bi.qc1706ba.isChecked() ? "1" : bi.qc1706bb.isChecked() ? "2" : bi.qc1706bc.isChecked() ? "3" : "0");
        qoc8.put("qc1706c", bi.qc1706c.getText().toString().trim().length() > 0 ? bi.qc1706c.getText().toString() : "0");
        qoc8.put("qc1706d", bi.qc1706d.getText().toString().trim().length() > 0 ? bi.qc1706d.getText().toString() : "0");

        qoc8.put("qc1707a", bi.qc1707aa.isChecked() ? "1" : bi.qc1707ab.isChecked() ? "2" : "0");
        qoc8.put("qc1707b", bi.qc1707ba.isChecked() ? "1" : bi.qc1707bb.isChecked() ? "2" : bi.qc1707bc.isChecked() ? "3" : "0");
        qoc8.put("qc1707c", bi.qc1707c.getText().toString().trim().length() > 0 ? bi.qc1707c.getText().toString() : "0");
        qoc8.put("qc1707d", bi.qc1707d.getText().toString().trim().length() > 0 ? bi.qc1707d.getText().toString() : "0");

        qoc8.put("qc1708a", bi.qc1708aa.isChecked() ? "1" : bi.qc1708ab.isChecked() ? "2" : "0");
        qoc8.put("qc1708b", bi.qc1708ba.isChecked() ? "1" : bi.qc1708bb.isChecked() ? "2" : bi.qc1708bc.isChecked() ? "3" : "0");
        qoc8.put("qc1708c", bi.qc1708c.getText().toString().trim().length() > 0 ? bi.qc1708c.getText().toString() : "0");
        qoc8.put("qc1708d", bi.qc1708d.getText().toString().trim().length() > 0 ? bi.qc1708d.getText().toString() : "0");

        qoc8.put("qc1709a", bi.qc1709aa.isChecked() ? "1" : bi.qc1709ab.isChecked() ? "2" : "0");
        qoc8.put("qc1709b", bi.qc1709ba.isChecked() ? "1" : bi.qc1709bb.isChecked() ? "2" : bi.qc1709bc.isChecked() ? "3" : "0");
        qoc8.put("qc1709c", bi.qc1709c.getText().toString().trim().length() > 0 ? bi.qc1709c.getText().toString() : "0");
        qoc8.put("qc1709d", bi.qc1709d.getText().toString().trim().length() > 0 ? bi.qc1709d.getText().toString() : "0");



        qoc8.put("qc1801a", bi.qc1801aa.isChecked() ? "1" : bi.qc1801ab.isChecked() ? "2" : "0");
        qoc8.put("qc1801b", bi.qc1801ba.isChecked() ? "1" : bi.qc1801bb.isChecked() ? "2" : bi.qc1801bc.isChecked() ? "3" : "0");
        qoc8.put("qc1801c", bi.qc1801c.getText().toString().trim().length() > 0 ? bi.qc1801c.getText().toString() : "0");
        qoc8.put("qc1801d", bi.qc1801d.getText().toString().trim().length() > 0 ? bi.qc1801d.getText().toString() : "0");

        qoc8.put("qc1802a", bi.qc1802aa.isChecked() ? "1" : bi.qc1802ab.isChecked() ? "2" : "0");
        qoc8.put("qc1802b", bi.qc1802ba.isChecked() ? "1" : bi.qc1802bb.isChecked() ? "2" : bi.qc1802bc.isChecked() ? "3" : "0");
        qoc8.put("qc1802c", bi.qc1802c.getText().toString().trim().length() > 0 ? bi.qc1802c.getText().toString() : "0");
        qoc8.put("qc1802d", bi.qc1802d.getText().toString().trim().length() > 0 ? bi.qc1802d.getText().toString() : "0");

        qoc8.put("qc1803a", bi.qc1803aa.isChecked() ? "1" : bi.qc1803ab.isChecked() ? "2" : "0");
        qoc8.put("qc1803b", bi.qc1803ba.isChecked() ? "1" : bi.qc1803bb.isChecked() ? "2" : bi.qc1803bc.isChecked() ? "3" : "0");
        qoc8.put("qc1803c", bi.qc1803c.getText().toString().trim().length() > 0 ? bi.qc1803c.getText().toString() : "0");
        qoc8.put("qc1803d", bi.qc1803d.getText().toString().trim().length() > 0 ? bi.qc1803d.getText().toString() : "0");

        qoc8.put("qc1804a", bi.qc1804aa.isChecked() ? "1" : bi.qc1804ab.isChecked() ? "2" : "0");
        qoc8.put("qc1804b", bi.qc1804ba.isChecked() ? "1" : bi.qc1804bb.isChecked() ? "2" : bi.qc1804bc.isChecked() ? "3" : "0");
        qoc8.put("qc1804c", bi.qc1804c.getText().toString().trim().length() > 0 ? bi.qc1804c.getText().toString() : "0");
        qoc8.put("qc1804d", bi.qc1804d.getText().toString().trim().length() > 0 ? bi.qc1804d.getText().toString() : "0");

        qoc8.put("qc1805a", bi.qc1805aa.isChecked() ? "1" : bi.qc1805ab.isChecked() ? "2" : "0");
        qoc8.put("qc1805b", bi.qc1805ba.isChecked() ? "1" : bi.qc1805bb.isChecked() ? "2" : bi.qc1805bc.isChecked() ? "3" : "0");
        qoc8.put("qc1805c", bi.qc1805c.getText().toString().trim().length() > 0 ? bi.qc1805c.getText().toString() : "0");
        qoc8.put("qc1805d", bi.qc1805d.getText().toString().trim().length() > 0 ? bi.qc1805d.getText().toString() : "0");

        qoc8.put("qc1806a", bi.qc1806aa.isChecked() ? "1" : bi.qc1806ab.isChecked() ? "2" : "0");
        qoc8.put("qc1806b", bi.qc1806ba.isChecked() ? "1" : bi.qc1806bb.isChecked() ? "2" : bi.qc1806bc.isChecked() ? "3" : "0");
        qoc8.put("qc1806c", bi.qc1806c.getText().toString().trim().length() > 0 ? bi.qc1806c.getText().toString() : "0");
        qoc8.put("qc1806d", bi.qc1806d.getText().toString().trim().length() > 0 ? bi.qc1806d.getText().toString() : "0");

        qoc8.put("qc1807a", bi.qc1807aa.isChecked() ? "1" : bi.qc1807ab.isChecked() ? "2" : "0");
        qoc8.put("qc1807b", bi.qc1807ba.isChecked() ? "1" : bi.qc1807bb.isChecked() ? "2" : bi.qc1807bc.isChecked() ? "3" : "0");
        qoc8.put("qc1807c", bi.qc1807c.getText().toString().trim().length() > 0 ? bi.qc1807c.getText().toString() : "0");
        qoc8.put("qc1807d", bi.qc1807d.getText().toString().trim().length() > 0 ? bi.qc1807d.getText().toString() : "0");

        qoc8.put("qc1808a", bi.qc1808aa.isChecked() ? "1" : bi.qc1808ab.isChecked() ? "2" : "0");
        qoc8.put("qc1808b", bi.qc1808ba.isChecked() ? "1" : bi.qc1808bb.isChecked() ? "2" : bi.qc1808bc.isChecked() ? "3" : "0");
        qoc8.put("qc1808c", bi.qc1808c.getText().toString().trim().length() > 0 ? bi.qc1808c.getText().toString() : "0");
        qoc8.put("qc1808d", bi.qc1808d.getText().toString().trim().length() > 0 ? bi.qc1808d.getText().toString() : "0");



        qoc8.put("qc1901a", bi.qc1901aa.isChecked() ? "1" : bi.qc1901ab.isChecked() ? "2" : "0");
        qoc8.put("qc1901b", bi.qc1901ba.isChecked() ? "1" : bi.qc1901bb.isChecked() ? "2" : bi.qc1901bc.isChecked() ? "3" : "0");
        qoc8.put("qc1901c", bi.qc1901c.getText().toString().trim().length() > 0 ? bi.qc1901c.getText().toString() : "0");
        qoc8.put("qc1901d", bi.qc1901d.getText().toString().trim().length() > 0 ? bi.qc1901d.getText().toString() : "0");

        qoc8.put("qc1902a", bi.qc1902aa.isChecked() ? "1" : bi.qc1902ab.isChecked() ? "2" : "0");
        qoc8.put("qc1902b", bi.qc1902ba.isChecked() ? "1" : bi.qc1902bb.isChecked() ? "2" : bi.qc1902bc.isChecked() ? "3" : "0");
        qoc8.put("qc1902c", bi.qc1902c.getText().toString().trim().length() > 0 ? bi.qc1902c.getText().toString() : "0");
        qoc8.put("qc1902d", bi.qc1902d.getText().toString().trim().length() > 0 ? bi.qc1902d.getText().toString() : "0");

        qoc8.put("qc1903a", bi.qc1903aa.isChecked() ? "1" : bi.qc1903ab.isChecked() ? "2" : "0");
        qoc8.put("qc1903b", bi.qc1903ba.isChecked() ? "1" : bi.qc1903bb.isChecked() ? "2" : bi.qc1903bc.isChecked() ? "3" : "0");
        qoc8.put("qc1903c", bi.qc1903c.getText().toString().trim().length() > 0 ? bi.qc1903c.getText().toString() : "0");
        qoc8.put("qc1903d", bi.qc1903d.getText().toString().trim().length() > 0 ? bi.qc1903d.getText().toString() : "0");

        qoc8.put("qc1904a", bi.qc1904aa.isChecked() ? "1" : bi.qc1904ab.isChecked() ? "2" : "0");
        qoc8.put("qc1904b", bi.qc1904ba.isChecked() ? "1" : bi.qc1904bb.isChecked() ? "2" : bi.qc1904bc.isChecked() ? "3" : "0");
        qoc8.put("qc1904c", bi.qc1904c.getText().toString().trim().length() > 0 ? bi.qc1904c.getText().toString() : "0");
        qoc8.put("qc1904d", bi.qc1904d.getText().toString().trim().length() > 0 ? bi.qc1904d.getText().toString() : "0");

        qoc8.put("qc1905a", bi.qc1905aa.isChecked() ? "1" : bi.qc1905ab.isChecked() ? "2" : "0");
        qoc8.put("qc1905b", bi.qc1905ba.isChecked() ? "1" : bi.qc1905bb.isChecked() ? "2" : bi.qc1905bc.isChecked() ? "3" : "0");
        qoc8.put("qc1905c", bi.qc1905c.getText().toString().trim().length() > 0 ? bi.qc1905c.getText().toString() : "0");
        qoc8.put("qc1905d", bi.qc1905d.getText().toString().trim().length() > 0 ? bi.qc1905d.getText().toString() : "0");



        qoc8.put("qc2001a", bi.qc2001aa.isChecked() ? "1" : bi.qc2001ab.isChecked() ? "2" : "0");
        qoc8.put("qc2001b", bi.qc2001ba.isChecked() ? "1" : bi.qc2001bb.isChecked() ? "2" : bi.qc2001bc.isChecked() ? "3" : "0");
        qoc8.put("qc2001c", bi.qc2001c.getText().toString().trim().length() > 0 ? bi.qc2001c.getText().toString() : "0");
        qoc8.put("qc2001d", bi.qc2001d.getText().toString().trim().length() > 0 ? bi.qc2001d.getText().toString() : "0");

        qoc8.put("qc2002a", bi.qc2002aa.isChecked() ? "1" : bi.qc2002ab.isChecked() ? "2" : "0");
        qoc8.put("qc2002b", bi.qc2002ba.isChecked() ? "1" : bi.qc2002bb.isChecked() ? "2" : bi.qc2002bc.isChecked() ? "3" : "0");
        qoc8.put("qc2002c", bi.qc2002c.getText().toString().trim().length() > 0 ? bi.qc2002c.getText().toString() : "0");
        qoc8.put("qc2002d", bi.qc2002d.getText().toString().trim().length() > 0 ? bi.qc2002d.getText().toString() : "0");

        qoc8.put("qc2003a", bi.qc2003aa.isChecked() ? "1" : bi.qc2003ab.isChecked() ? "2" : "0");
        qoc8.put("qc2003b", bi.qc2003ba.isChecked() ? "1" : bi.qc2003bb.isChecked() ? "2" : bi.qc2003bc.isChecked() ? "3" : "0");
        qoc8.put("qc2003c", bi.qc2003c.getText().toString().trim().length() > 0 ? bi.qc2003c.getText().toString() : "0");
        qoc8.put("qc2003d", bi.qc2003d.getText().toString().trim().length() > 0 ? bi.qc2003d.getText().toString() : "0");

        qoc8.put("qc2004a", bi.qc2004aa.isChecked() ? "1" : bi.qc2004ab.isChecked() ? "2" : "0");
        qoc8.put("qc2004b", bi.qc2004ba.isChecked() ? "1" : bi.qc2004bb.isChecked() ? "2" : bi.qc2004bc.isChecked() ? "3" : "0");
        qoc8.put("qc2004c", bi.qc2004c.getText().toString().trim().length() > 0 ? bi.qc2004c.getText().toString() : "0");
        qoc8.put("qc2004d", bi.qc2004d.getText().toString().trim().length() > 0 ? bi.qc2004d.getText().toString() : "0");


        fc.setSqoc1(String.valueOf(qoc8));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.qc1701aa.isChecked()){
            bi.qc1701b.clearCheck();
            bi.qc1701c.setEnabled(true);
        } else {
            bi.qc1701c.setEnabled(false);
        }

        if (!bi.qc1702aa.isChecked()){
            bi.qc1702b.clearCheck();
            bi.qc1702c.setEnabled(true);
        } else {
            bi.qc1702c.setEnabled(false);
        }

        if (!bi.qc1703aa.isChecked()){
            bi.qc1703b.clearCheck();
            bi.qc1703c.setEnabled(true);
        } else {
            bi.qc1703c.setEnabled(false);
        }

        if (!bi.qc1704aa.isChecked()){
            bi.qc1704b.clearCheck();
            bi.qc1704c.setEnabled(true);
        } else {
            bi.qc1704c.setEnabled(false);
        }

        if (!bi.qc1705aa.isChecked()){
            bi.qc1705b.clearCheck();
            bi.qc1705c.setEnabled(true);
        } else {
            bi.qc1705c.setEnabled(false);
        }

        if (!bi.qc1706aa.isChecked()){
            bi.qc1706b.clearCheck();
            bi.qc1706c.setEnabled(true);
        } else {
            bi.qc1706c.setEnabled(false);
        }

        if (!bi.qc1707aa.isChecked()){
            bi.qc1707b.clearCheck();
            bi.qc1707c.setEnabled(true);
        } else {
            bi.qc1707c.setEnabled(false);
        }

        if (!bi.qc1708aa.isChecked()){
            bi.qc1708b.clearCheck();
            bi.qc1708c.setEnabled(true);
        } else {
            bi.qc1708c.setEnabled(false);
        }

        if (!bi.qc1709aa.isChecked()){
            bi.qc1709b.clearCheck();
            bi.qc1709c.setEnabled(true);
        } else {
            bi.qc1709c.setEnabled(false);
        }


        if (!bi.qc1801aa.isChecked()){
            bi.qc1801b.clearCheck();
            bi.qc1801c.setEnabled(true);
        } else {
            bi.qc1801c.setEnabled(false);
        }

        if (!bi.qc1802aa.isChecked()){
            bi.qc1802b.clearCheck();
            bi.qc1802c.setEnabled(true);
        } else {
            bi.qc1802c.setEnabled(false);
        }

        if (!bi.qc1803aa.isChecked()){
            bi.qc1803b.clearCheck();
            bi.qc1803c.setEnabled(true);
        } else {
            bi.qc1803c.setEnabled(false);
        }

        if (!bi.qc1804aa.isChecked()){
            bi.qc1804b.clearCheck();
            bi.qc1804c.setEnabled(true);
        } else {
            bi.qc1804c.setEnabled(false);
        }

        if (!bi.qc1805aa.isChecked()){
            bi.qc1805b.clearCheck();
            bi.qc1805c.setEnabled(true);
        } else {
            bi.qc1805c.setEnabled(false);
        }

        if (!bi.qc1806aa.isChecked()){
            bi.qc1806b.clearCheck();
            bi.qc1806c.setEnabled(true);
        } else {
            bi.qc1806c.setEnabled(false);
        }

        if (!bi.qc1807aa.isChecked()){
            bi.qc1807b.clearCheck();
            bi.qc1807c.setEnabled(true);
        } else {
            bi.qc1807c.setEnabled(false);
        }

        if (!bi.qc1808aa.isChecked()){
            bi.qc1808b.clearCheck();
            bi.qc1808c.setEnabled(true);
        } else {
            bi.qc1808c.setEnabled(false);
        }


        if (!bi.qc1901aa.isChecked()){
            bi.qc1901b.clearCheck();
            bi.qc1901c.setEnabled(true);
        } else {
            bi.qc1901c.setEnabled(false);
        }

        if (!bi.qc1902aa.isChecked()){
            bi.qc1902b.clearCheck();
            bi.qc1902c.setEnabled(true);
        } else {
            bi.qc1902c.setEnabled(false);
        }

        if (!bi.qc1903aa.isChecked()){
            bi.qc1903b.clearCheck();
            bi.qc1903c.setEnabled(true);
        } else {
            bi.qc1903c.setEnabled(false);
        }

        if (!bi.qc1904aa.isChecked()){
            bi.qc1904b.clearCheck();
            bi.qc1904c.setEnabled(true);
        } else {
            bi.qc1904c.setEnabled(false);
        }

        if (!bi.qc1905aa.isChecked()){
            bi.qc1905b.clearCheck();
            bi.qc1905c.setEnabled(true);
        } else {
            bi.qc1905c.setEnabled(false);
        }


        if (!bi.qc2001aa.isChecked()){
            bi.qc2001b.clearCheck();
            bi.qc2001c.setEnabled(true);
        } else {
            bi.qc2001c.setEnabled(false);
        }

        if (!bi.qc2002aa.isChecked()){
            bi.qc2002b.clearCheck();
            bi.qc2002c.setEnabled(true);
        } else {
            bi.qc2002c.setEnabled(false);
        }

        if (!bi.qc2003aa.isChecked()){
            bi.qc2003b.clearCheck();
            bi.qc2003c.setEnabled(true);
        } else {
            bi.qc2003c.setEnabled(false);
        }

        if (!bi.qc2004aa.isChecked()){
            bi.qc2004b.clearCheck();
            bi.qc2004c.setEnabled(true);
        } else {
            bi.qc2004c.setEnabled(false);
        }

    }

    void events_call() {

        bi.qc1701a.setOnCheckedChangeListener(this);
        bi.qc1702a.setOnCheckedChangeListener(this);
        bi.qc1703a.setOnCheckedChangeListener(this);
        bi.qc1704a.setOnCheckedChangeListener(this);
        bi.qc1705a.setOnCheckedChangeListener(this);
        bi.qc1706a.setOnCheckedChangeListener(this);
        bi.qc1707a.setOnCheckedChangeListener(this);
        bi.qc1708a.setOnCheckedChangeListener(this);
        bi.qc1709a.setOnCheckedChangeListener(this);

        bi.qc1801a.setOnCheckedChangeListener(this);
        bi.qc1802a.setOnCheckedChangeListener(this);
        bi.qc1803a.setOnCheckedChangeListener(this);
        bi.qc1804a.setOnCheckedChangeListener(this);
        bi.qc1805a.setOnCheckedChangeListener(this);
        bi.qc1806a.setOnCheckedChangeListener(this);
        bi.qc1807a.setOnCheckedChangeListener(this);
        bi.qc1808a.setOnCheckedChangeListener(this);

        bi.qc1901a.setOnCheckedChangeListener(this);
        bi.qc1902a.setOnCheckedChangeListener(this);
        bi.qc1903a.setOnCheckedChangeListener(this);
        bi.qc1904a.setOnCheckedChangeListener(this);
        bi.qc1905a.setOnCheckedChangeListener(this);

        bi.qc2001a.setOnCheckedChangeListener(this);
        bi.qc2002a.setOnCheckedChangeListener(this);
        bi.qc2003a.setOnCheckedChangeListener(this);
        bi.qc2004a.setOnCheckedChangeListener(this);

    }

}
