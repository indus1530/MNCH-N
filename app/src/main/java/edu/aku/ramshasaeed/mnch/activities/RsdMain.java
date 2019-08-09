package edu.aku.ramshasaeed.mnch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.entities.Forms;

public class RsdMain extends AppCompatActivity {
    public static Forms fc;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rsd_main);
        type = getIntent().getStringExtra(MainApp.FORM_TYPE);
        this.setTitle("DHIS Data-Validation Tools for Decision Making");

    }


    public void openForm(View v) {

        OpenFormFunc(v.getId());

        /*if (!MainApp._IP.equals("f38158")) {

//        if (spAreas.getSelectedItemPosition() != 0) {

            *//*     if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null && !MainApp.userName.equals("0000")) {*//*
            if (versionAppContract.getVersioncode() != null) {
                if (MainApp.versionCode < Integer.valueOf(versionAppContract.getVersioncode())) {
                    if (sharedPrefDownload.getBoolean("flag", true) && file.exists()) {
//                    InstallNewApp(newVer, preVer);
                        showDialog(newVer, preVer);
                    } else {
                        OpenFormFunc(v.getId());
                    }
                } else {
                    OpenFormFunc(v.getId());
                }
            } else {
                Toast.makeText(this, "Sync data!!", Toast.LENGTH_SHORT).show();
            }

     *//*   } else {

            builder = new AlertDialog.Builder(MainActivity.this);
            ImageView img = new ImageView(getApplicationContext());
            img.setImageResource(R.drawable.tagimg);
            img.setPadding(0, 15, 0, 15);
            builder.setCustomTitle(img);

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    if (!m_Text.equals("")) {
                        editor.putString("tagName", m_Text);
                        editor.commit();

                        if (!MainApp.userName.equals("0000")) {
                            Intent oF = new Intent(MainActivity.this, F1Section01Activity.class);
                            startActivity(oF);
                        }
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }*//*
//        } else {
//            Toast.makeText(getApplicationContext(), "Please select data from combobox!!", Toast.LENGTH_LONG).show();
//        }
        } else {
            OpenFormFunc(v.getId());
        }*/
    }

    private void OpenFormFunc(int id) {
        Intent oF = new Intent();
        if (!MainApp.userName.equals("0000")) {
            switch (id) {
                case R.id.form01:
                    oF = new Intent(RsdMain.this, Rsd01.class);
                    MainApp.formSubtype = "f1";
                    break;
                case R.id.form02:
                    oF = new Intent(RsdMain.this, Rsd02.class);
                    MainApp.formSubtype = "f2";
                    break;
                case R.id.form03:
                    oF = new Intent(RsdMain.this, Rsd03.class);
                    MainApp.formSubtype = "f3";
                    break;
                case R.id.form04:
                    oF = new Intent(RsdMain.this, Rsd04.class);
                    MainApp.formSubtype = "f4";
                    break;
                case R.id.form05:
                    oF = new Intent(RsdMain.this, Rsd05.class);
                    MainApp.formSubtype = "f5";
                    break;
                case R.id.form06:
                    oF = new Intent(RsdMain.this, Rsd06.class);
                    MainApp.formSubtype = "f6";
                    break;
                case R.id.form07:
                    oF = new Intent(RsdMain.this, Rsd07.class);
                    MainApp.formSubtype = "f7";
                    break;

            }
            startActivity(oF);
        } else {
            Toast.makeText(getApplicationContext(), "Please login Again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
