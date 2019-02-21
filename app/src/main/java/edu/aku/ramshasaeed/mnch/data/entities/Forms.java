package edu.aku.ramshasaeed.mnch.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FORMS)
public class Forms implements Serializable {

    @Ignore
    private final String _projectName = "mnch";
    @Ignore
    private final String _surveyType = "";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uid = "";
    private String uuid = "";
    private String formType = "";
    private String formDate = ""; // Date
/*    private String district = "";
    private String tehsil = "";
    private String ucs = "";
    private String uen = ""; */
    private String username = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String shfa = "";     // Health Facility Assesment Section
    private String srsd = "";     // Routine Service Delivery Section
    private String sqoc1 = "";     // Quality of Care
    private String sinfo = "";     // Info Activity
    private String starttime = "";
    private String endtime = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";

    @Ignore
    public Forms(Forms forms) {

        this.uid = forms.uid;
        this.uuid = forms.uuid;
        this.formDate = forms.formDate;
        this.formType = forms.formType;
        this.username = forms.username;
        this.istatus = forms.istatus;
        this.istatus88x = forms.istatus88x;
        this.shfa = forms.shfa;
        this.srsd = forms.srsd;
        this.sqoc1 = forms.sqoc1;
        this.sinfo = forms.sinfo;
        this.starttime = forms.starttime;
        this.endtime = forms.endtime;
        this.gpsLat = forms.gpsLat;
        this.gpsLng = forms.gpsLng;
        this.gpsDT = forms.gpsDT;
        this.gpsAcc = forms.gpsAcc;
        this.gpsElev = forms.gpsElev;
        this.deviceID = forms.deviceID;
        this.devicetagID = forms.devicetagID;
        this.synced = forms.synced;
        this.synced_date = forms.synced_date;
        this.appversion = forms.appversion;

    }

    public Forms() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getShfa() {
        return shfa;
    }

    public void setShfa(String shfa) {
        this.shfa = shfa;
    }

    public String getSrsd() {
        return srsd;
    }

    public void setSrsd(String srsd) {
        this.srsd = srsd;
    }


    public String getSqoc1() {
        return sqoc1;
    }

    public void setSqoc1(String sqoc1) {
        this.sqoc1 = sqoc1;
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    @Ignore
    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("projectName", this._projectName);
        json.put("_id", this.id == 0 ? JSONObject.NULL : this.id);
        json.put("uid", this.uid == null ? JSONObject.NULL : this.uid);
        json.put("uuid", this.uuid == null ? JSONObject.NULL : this.uuid);
        json.put("formType", this.formType == null ? JSONObject.NULL : this.formType);
        json.put("formDate", this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put("username", this.username == null ? JSONObject.NULL : this.username);
        json.put("starttime", this.starttime == null ? JSONObject.NULL : this.starttime);
        json.put("endtime", this.endtime == null ? JSONObject.NULL : this.endtime);
        json.put("gpsLat", this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put("gpsLng", this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put("gpsDT", this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put("gpsAcc", this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put("gpsElev", this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put("deviceID", this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put("devicetagID", this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put("appversion", this.appversion == null ? JSONObject.NULL : this.appversion);

        if (!this.shfa.equals("")) {
            json.put("shfa", this.shfa.equals("") ? JSONObject.NULL : new JSONObject(this.shfa));
        }
        if (!this.srsd.equals("")) {
            json.put("srsd", this.srsd.equals("") ? JSONObject.NULL : new JSONObject(this.srsd));
        }
        if (!this.sinfo.equals("")) {
            json.put("sinfo", this.sinfo.equals("") ? JSONObject.NULL : new JSONObject(this.sinfo));
        }
        if (!this.sqoc1.equals("")) {
            json.put("sqoc1", this.sqoc1.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc1));
        }


        return json;
    }


}
