package edu.aku.ramshasaeed.mnch.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.RMOperations.crudOperations;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.FormsDAO;
import edu.aku.ramshasaeed.mnch.data.DAO.GetFncDAO;
import edu.aku.ramshasaeed.mnch.data.entities.District;
import edu.aku.ramshasaeed.mnch.data.entities.Facility_provider;
import edu.aku.ramshasaeed.mnch.data.entities.Forms;
import edu.aku.ramshasaeed.mnch.data.entities.Tehsil;
import edu.aku.ramshasaeed.mnch.data.entities.UCs;
import edu.aku.ramshasaeed.mnch.databinding.ActivityRsdinfoBinding;
import edu.aku.ramshasaeed.mnch.get.db.GetAllDBData;
import edu.aku.ramshasaeed.mnch.validation.validatorClass;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;

public class RSDInfoActivity extends AppCompatActivity {
    ActivityRsdinfoBinding bi;
    public List<String> districtNames, tehsilNames, UCsName, facility_name;
    public List<String> districtCodes, tehsilCodes, UCsCodes, facility_code;
    public static Forms fc;
    private static final String TAG = RSDInfoActivity.class.getName();
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_rsdinfo);
        bi.setCallback(this);
        this.setTitle(R.string.module_one);

        type = getIntent().getStringExtra(MainApp.FORM_TYPE);

        tempVisible(this);
        bi.hfConsent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(bi.hfConsenta.isChecked()){
                    bi.btnNext.setVisibility(VISIBLE);
                }else{
                    bi.btnNext.setVisibility(GONE);
                }
            }
        });
    }

    private void tempVisible(final Context context) {


        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");
        Collection<District> districts = null;
        try {
            districts = (Collection<District>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getAllDistricts").execute().get();

            if (districts != null) {
                Toast.makeText(this, "District ID validate...", Toast.LENGTH_SHORT).show();
                for (District d : districts) {
                    districtNames.add(d.getDistrict_name());
                    districtCodes.add(d.getDistrict_code());
                }
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_dropdown_item, districtNames);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                // attaching data adapter to spinner
                bi.hfDistrict.setAdapter(dataAdapter);

            } else {
                Toast.makeText(this, "District not found!!", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        bi.hfDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.DistrictCode = districtCodes.get(position);

                facility_code = new ArrayList<>();
                facility_name = new ArrayList<>();
                tehsilNames = new ArrayList<>();
                UCsName = new ArrayList<>();


                facility_code.add("....");
                facility_name.add("....");
                UCsName.add("....");


                Collection<Facility_provider> facility_provider = null;
                try {
                    facility_provider = (Collection<Facility_provider>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getFacilityProvider").execute(MainApp.DistrictCode).get();

                    if (facility_provider != null) {
                        for (Facility_provider fp : facility_provider) {
                            facility_name.add(fp.getHf_name());
                            facility_code.add(fp.getHf_uen_code());
                            tehsilNames.add(fp.getHf_tehsil());
                            UCsName.add(fp.getHf_uc());
                        }
                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, facility_name);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        // attaching data adapter to spinner
                        bi.hfFacilityProvider.setAdapter(dataAdapter);
                        if (position == 0) {
                            bi.fldGrphfUc.setVisibility(GONE);

                        } else {
                            bi.fldGrphfUc.setVisibility(VISIBLE);

                        }

                    } else {
//                        Toast.makeText(this, "Tehsils not found!!", Toast.LENGTH_SHORT).show();
                        bi.fldGrphfUc.setVisibility(GONE);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.fldGrphfUc.setVisibility(GONE);

            }
        });

        /* bi.hfDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.DistrictCode = districtCodes.get(position);

                tehsilCodes = new ArrayList<>();
                tehsilNames = new ArrayList<>();


                tehsilCodes.add("....");
                tehsilNames.add("....");


                Collection<Tehsil> tehsils = null;
                try {
                    tehsils = (Collection<Tehsil>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getTehsil").execute(MainApp.DistrictCode).get();

                    if (tehsils != null) {
                        for (Tehsil t : tehsils) {
                            tehsilNames.add(t.getTehsil_name());
                            tehsilCodes.add(t.getTehsil_code());
                        }
                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, tehsilNames);

                        // Drop down layout style - list view with radio button
                        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        // attaching data adapter to spinner
                        bi.hfTehsil.setAdapter(dataAdapter1);
                        if (position == 0) {
                            bi.fldGrphfDistrict.setVisibility(GONE);

                        } else {
                            bi.fldGrphfDistrict.setVisibility(VISIBLE);

                        }

                    } else {
//                        Toast.makeText(this, "Tehsils not found!!", Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.fldGrphfDistrict.setVisibility(GONE);

            }
        });

        bi.hfTehsil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.tehsilCode = tehsilCodes.get(position);

                UCsCodes = new ArrayList<>();
                UCsName = new ArrayList<>();


                UCsCodes.add("....");
                UCsName.add("....");


                Collection<UCs> UCs = null;
                try {
                    UCs = (Collection<UCs>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUCs").execute(MainApp.tehsilCode).get();

                    if (UCs != null) {
                        for (UCs u : UCs) {
                            UCsName.add(u.getUCs_name());
                            UCsCodes.add(u.getUCs_code());
                        }
                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, UCsName);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        // attaching data adapter to spinner
                        bi.hfUc.setAdapter(dataAdapter);
                        if (position == 0) {
                            bi.fldGrphfTehsil.setVisibility(GONE);

                        } else {
                            bi.fldGrphfTehsil.setVisibility(VISIBLE);

                        }

                    } else {
//                        Toast.makeText(this, "Tehsils not found!!", Toast.LENGTH_SHORT).show();
                        bi.fldGrphfTehsil.setVisibility(GONE);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.fldGrphfTehsil.setVisibility(GONE);

            }
        });
        bi.hfUc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.facilityProviderCode = UCsCodes.get(position);

                facility_code = new ArrayList<>();
                facility_name = new ArrayList<>();


                facility_code.add("....");
                facility_name.add("....");


                Collection<Facility_provider> facility_provider = null;
                try {
                    facility_provider = (Collection<Facility_provider>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getFacilityProvider").execute(MainApp.facilityProviderCode).get();

                    if (facility_provider != null) {
                        for (Facility_provider fp : facility_provider) {
                            facility_name.add(fp.getProvider_name());
                            facility_code.add(fp.getProvider_code());
                        }
                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, facility_name);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        // attaching data adapter to spinner
                        bi.hfFacilityProvider.setAdapter(dataAdapter);
                        if (position == 0) {
                            bi.fldGrphfUc.setVisibility(GONE);

                        } else {
                            bi.fldGrphfUc.setVisibility(VISIBLE);

                        }

                    } else {
//                        Toast.makeText(this, "Tehsils not found!!", Toast.LENGTH_SHORT).show();
                        bi.fldGrphfUc.setVisibility(GONE);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.fldGrphfUc.setVisibility(GONE);

            }
        });
*/
        bi.hfFacilityProvider.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MainApp.facilityProviderCode = facility_code.get(position);
                MainApp.tehsilCode = tehsilNames.get(position);
                MainApp.ucCode = UCsName.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();
                startActivity(new Intent(RSDInfoActivity.this, type.equals(MainApp.QOC) ? Qoc9.class : RSDActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);
    }

    public boolean formValidation() {
        if (!validatorClass.EmptySpinner(this, bi.hfDistrict, getString(R.string.hf_district))) {
            return false;
        }
       /* if (!validatorClass.EmptySpinner(this, bi.hfTehsil, getString(R.string.hf_tehsil))) {
            return false;
        }
        if (!validatorClass.EmptySpinner(this, bi.hfUc, getString(R.string.hf_uc))) {
            return false;
        }*/
        if (!validatorClass.EmptySpinner(this, bi.hfFacilityProvider, getString(R.string.hf_uen))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.hfConsent, bi.hfConsenta, getString(R.string.hf_consent));
    }

    private void SaveDraft() throws JSONException {

        fc = new Forms();
        fc.setDevicetagID(MainApp.getTagName(this));
        fc.setFormType(type);
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setUsername(MainApp.userName);
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setDeviceID(MainApp.deviceId);


        setGPS(fc); // Set GPS


        JSONObject f01 = new JSONObject();
        f01.put("district_code", MainApp.DistrictCode);
        f01.put("tehsil_code", MainApp.tehsilCode);
        f01.put("uc_code", MainApp.ucCode);
        f01.put("facility_provider_code", MainApp.facilityProviderCode);
        f01.put("rs_consent", bi.hfConsenta.isChecked() ? "1"
                : bi.hfConsentb.isChecked() ? "2"
                : "0");
        fc.setSinfo(String.valueOf(f01));

    }

    public void setGPS(Forms fc) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above
            fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "insertForm").get();

            if (longID != 0) {
                fc.setId(longID.intValue());
                fc.setUid(MainApp.deviceId + fc.getId());

                longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

}
