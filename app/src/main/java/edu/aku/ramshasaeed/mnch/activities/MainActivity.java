package edu.aku.ramshasaeed.mnch.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    String DirectoryName;
    private boolean updata = false;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    String _dtToday = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

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

        bi.navView.setNavigationItemSelectedListener(this);

    }

    private void displayFormsStatus() {
        Collection<Forms> todaysForms = null;
//        Collection<Forms> unsyncedForms = null;
        try {
//            unsyncedForms = (Collection<Forms>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute().get();
            todaysForms = (Collection<Forms>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getTodaysForms").execute("%"+_dtToday+"%").get();
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
                formID = formID + "\n"+fc.getId();
                completestatus = completestatus + "\n"+iStatus;
                syncedStatus = syncedStatus + "\n"+(fc.getSynced() == null || fc.getSynced().equals("") ? "Not Synced" : "Synced");
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

/*
        SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
       rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
        rSumText += "\r\n";
        rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
        rSumText += "\r\n";
        rSumText += "\r\n";
        rSumText += "Unsynced Forms: \t" + unsyncedForms.size();
        rSumText += "\r\n";

        Log.d(TAG, "onCreate: " + rSumText);
        mainBinding.recordSummary.setText(rSumText);
        */
    }

    @Override
    public void onBackPressed() {
        if (bi.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            bi.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            finish();
            Intent i = new Intent(MainActivity.this, RSDInfoActivity.class);
            i.putExtra(MainApp.FORM_TYPE,MainApp.RSD);
            startActivity(i);
        } else if (id == R.id.navQOC ) {
//            Toast.makeText(this, "This Form is Under Construction!", Toast.LENGTH_SHORT).show();
            finish();

            //startActivity(new Intent(MainActivity.this, RSDInfoActivity.class));
            Intent i = new Intent(MainActivity.this, RSDInfoActivity.class);
            i.putExtra(MainApp.FORM_TYPE,MainApp.QOC);
            startActivity(i);

        } else if (id == R.id.nav_dhmt) {
            finish();

            Intent i = new Intent(MainActivity.this, RSDInfoActivity.class);
            i.putExtra(MainApp.FORM_TYPE,MainApp.DHMT);
            startActivity(i);

        } else if (id == R.id.nav_upload) {
            uploadData();

        } else if (id == R.id.nav_download) {
            //TODO implement

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
                Toast.makeText(this,"You are not allowed to avail this feature!!",Toast.LENGTH_SHORT).show();
            }

        }


        bi.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
                    /*Toast.makeText(MainActivity.this, "Sync Tehsil", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Tehsil", MainApp._HOST_URL + CONSTANTS.URL_TEHSIL).execute();
                    Toast.makeText(MainActivity.this, "Sync UCs", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "UCs", MainApp._HOST_URL + CONSTANTS.URL_UCS).execute();*/
                    /*Toast.makeText(MainActivity.this, "Sync Facility Provider", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "FacilityProvider", MainApp._HOST_URL + CONSTANTS.URL_HEALTH_FACILITY).execute();*/
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

    public void dbBackup() {

        sharedPref = getSharedPreferences("qoc_uen", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", true)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

            if (dt != new SimpleDateFormat("dd-MM-yy").format(new Date())) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

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
                        /*File dbFile = new File(this.getDatabasePath(AppDatabase.Sub_DBConnection.DATABASE_NAME).getAbsolutePath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator +
                                AppDatabase.Sub_DBConnection.DATABASE_NAME + ".db";

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();*/

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
                        MainApp._HOST_URL + CONSTANTS.URL_FORMS.replace(".php", CONSTANTS.URL_RSD), rsdcollection
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
                        MainApp._HOST_URL + CONSTANTS.URL_FORMS.replace(".php", CONSTANTS.URL_QOC), qoccollection
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
                        MainApp._HOST_URL + CONSTANTS.URL_FORMS.replace(".php", CONSTANTS.URL_DHMT), dhmtcollection
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

}
