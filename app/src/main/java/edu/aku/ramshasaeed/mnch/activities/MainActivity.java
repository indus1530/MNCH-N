package edu.aku.ramshasaeed.mnch.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.core.CONSTANTS;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.AppDatabase;
import edu.aku.ramshasaeed.mnch.data.DAO.GetFncDAO;
import edu.aku.ramshasaeed.mnch.data.entities.Forms;
import edu.aku.ramshasaeed.mnch.databinding.ActivityMainBinding;
import edu.aku.ramshasaeed.mnch.get.db.GetAllDBData;
import edu.aku.ramshasaeed.mnch.get.server.GetAllData;
import edu.aku.ramshasaeed.mnch.sync.SyncAllData;
import im.dino.dbinspector.activities.DbInspectorActivity;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding bi;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    AlertDialog.Builder builder;
    String m_Text = "";
    String DirectoryName;
    private boolean updata = false;
    private Boolean exit = false;
    String dtToday = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime());
    String _dtToday = new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);
        setSupportActionBar(bi.appbarmain.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, bi.drawerLayout, bi.appbarmain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        bi.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        dbBackup();
        displayFormsStatus();
        loadTagDialog();

        bi.navView.setNavigationItemSelectedListener(this);

    }

    private void displayFormsStatus() {
        Collection<Forms> todaysForms = null;
        Collection<Forms> unsyncedForms = null;
        try {
            unsyncedForms = (Collection<Forms>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute().get();
            todaysForms = (Collection<Forms>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getTodaysForms").execute("%" + _dtToday + "%").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    /*    rSumText += "TODAY'S RECORDS SUMMARY\r\n";

        rSumText += "=======================\r\n";
        rSumText += "\r\n";
        rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
        rSumText += "\r\n";*/
        String formID = "", completestatus = "", syncedStatus = "";
        if (todaysForms.size() > 0) {
//            rSumText += "\tFORMS' LIST: \r\n";
            String iStatus;
//            rSumText += "--------------------------------------------------\r\n";
//            rSumText += "[ Form_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
//            rSumText += "--------------------------------------------------\r\n";
            for (Forms fc : todaysForms) {
                if (fc.getIstatus() != null) {
                    switch (fc.getIstatus()) {
                        case "1":
                            iStatus = "\tComplete";
                            break;
                        case "2":
                            iStatus = "\tIncomplete";
                            break;
                        default:
                            iStatus = "\tN/A";
                    }
                } else {
                    iStatus = "\tN/A";
                }
                formID = formID + "\n" + fc.getId();
                completestatus = completestatus + "\n" + iStatus;
                syncedStatus = syncedStatus + "\n" + (fc.getSynced() == null || fc.getSynced().equals("") ? "Not Synced" : "Synced");
              /*  rSumText += fc.getId();

                rSumText += " " + iStatus + " ";

                rSumText += (fc.getSynced() == null ? "\t\tNot Synced" : "\t\tSynced");
                rSumText += "\r\n";
                rSumText += "--------------------------------------------------\r\n";*/
            }
        }
//        Setting Text in  UI
        bi.appbarmain.contentmain.formId.setText(formID);
        bi.appbarmain.contentmain.completeStatus.setText(completestatus);
        bi.appbarmain.contentmain.syncStatus.setText(syncedStatus);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hfa) {
            Toast.makeText(this, "This Form is Under Construction!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_rsd) {
            startingActivities(1);
        } else if (id == R.id.navQOC) {
            startingActivities(2);
        } else if (id == R.id.nav_dhmt) {
            startingActivities(3);
        } else if (id == R.id.nav_upload) {
            uploadData();
        } else if (id == R.id.nav_download) {
            // Require permissions INTERNET & ACCESS_NETWORK_STATE
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                new syncData(this).execute();
            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_opendb) {
            if (MainApp.admin) {
                Intent dbmanager = new Intent(getApplicationContext(), DbInspectorActivity.class);
                startActivity(dbmanager);
            } else {
                Toast.makeText(this, "You are not allowed to avail this feature!!", Toast.LENGTH_SHORT).show();
            }

        }


        bi.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startingActivities(int flag) {
        if (loadTagDialog()) return;

        Intent i = new Intent(MainActivity.this, RSDInfoActivity.class);
        if (flag == 1)
            i.putExtra(MainApp.FORM_TYPE, MainApp.RSD);
        else if (flag == 2)
            i.putExtra(MainApp.FORM_TYPE, MainApp.QOC);
        else if (flag == 3)
            i.putExtra(MainApp.FORM_TYPE, MainApp.DHMT);

        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if (bi.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            bi.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (exit) {
                finish(); // finish activity
                startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);

            }
        }
    }

    public void dbBackup() {

        sharedPref = getSharedPreferences("qoc_uen", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", true)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

            if (dt != new SimpleDateFormat("dd-MM-yyyy").format(new Date())) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

                editor.commit();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "DMU-QOC-UEN");
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {

                        String dbFileName = this.getDatabasePath(AppDatabase.Sub_DBConnection.DATABASE_NAME).getAbsolutePath();
                        String outFileName = DirectoryName + File.separator + AppDatabase.Sub_DBConnection.DATABASE_NAME + ".db";

                        File currentDB = new File(dbFileName);
                        File backupDB = new File(outFileName);

                        FileChannel src = new FileInputStream(currentDB).getChannel();
                        FileChannel dst = new FileOutputStream(backupDB).getChannel();
                        dst.transferFrom(src, 0, src.size());
                        src.close();
                        dst.close();


                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void uploadData() {

        if (!updata) {
            updata = true;

            // Require permissions INTERNET & ACCESS_NETWORK_STATE
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

//            new SyncDevice(this).execute();
                Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();

//                Upload Form
                /*RSD Forms Upload*/
                Collection rsdcollection = null;
                try {
                    rsdcollection = new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute(MainApp.RSD).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new SyncAllData(
                        this,
                        "RSDForms",
                        "updateSyncedForms",
                        Forms.class,
                        MainApp._HOST_URL + CONSTANTS.URL_RSD, rsdcollection
                ).execute();

                /*QOC Forms Upload*/
                Collection qoccollection = null;
                try {
                    qoccollection = new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute(MainApp.QOC).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new SyncAllData(
                        this,
                        "QOCForms",
                        "updateSyncedForms",
                        Forms.class,
                        MainApp._HOST_URL + CONSTANTS.URL_QOC, qoccollection
                ).execute();

                /*DHMT Forms Upload*/
                Collection dhmtcollection = null;
                try {
                    dhmtcollection = new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute(MainApp.DHMT).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new SyncAllData(
                        this,
                        "DHMTForms",
                        "updateSyncedForms",
                        Forms.class,
                        MainApp._HOST_URL + CONSTANTS.URL_DHMT, dhmtcollection
                ).execute();

                SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = syncPref.edit();

                editor.putString("LastUpSyncServer", dtToday);

                editor.apply();

            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
            updata = false;
        }

    }

    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    Toast.makeText(MainActivity.this, "Sync Users", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "User", MainApp._HOST_URL + CONSTANTS.URL_USERS).execute();
                    Toast.makeText(MainActivity.this, "Sync District", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "District", MainApp._HOST_URL + CONSTANTS.URL_DISTRICT).execute();
                    Toast.makeText(MainActivity.this, "Sync Facility Provider", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "FacilityProvider", MainApp._HOST_URL + CONSTANTS.URL_HEALTH_FACILITY).execute();
                    /*Toast.makeText(MainActivity.this, "Sync Tehsil", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Tehsil", MainApp._HOST_URL + CONSTANTS.URL_TEHSIL).execute();
                    Toast.makeText(MainActivity.this, "Sync UCs", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "UCs", MainApp._HOST_URL + CONSTANTS.URL_UCS).execute();*/
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    editor.putBoolean("flag", true);
                    editor.commit();

                    dbBackup();

                }
            }, 1200);
        }
    }

    private boolean loadTagDialog() {

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();
        if (!sharedPref.contains("tagName") && sharedPref.getString("tagName", null) == null) {

            builder = new AlertDialog.Builder(MainActivity.this);
            ImageView img = new ImageView(getApplicationContext());
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
                        dialog.dismiss();

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

            return true;
        }
        return false;
    }

}
