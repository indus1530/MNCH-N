package edu.aku.ramshasaeed.mnch.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

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
    private String formSubType = "";
    private String reportingMonth = "";


    /*    private String district = "";
        private String tehsil = "";
        private String ucs = "";
        private String uen = ""; */
    private String username = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus96x = ""; // Interview Status
    private String shfa = "";     // Health Facility Assesment Section
    private String srsd1 = "";     // Routine Service Delivery Section
    private String srsd2 = "";     // Routine Service Delivery Section
    private String srsd3 = "";     // Routine Service Delivery Section
    private String srsd4 = "";     // Routine Service Delivery Section
    private String srsd5 = "";     // Routine Service Delivery Section
    private String srsd6 = "";     // Routine Service Delivery Section
    private String srsd7 = "";     // Routine Service Delivery Section
    private String sdhmt = "";     // DHMT monitoring
    private String sqoc1 = "";     // Quality of Care One
    private String sqoc2 = "";     // Quality of Care Two
    private String sqoc3 = "";     // Quality of Care Three
    private String sqoc4 = "";     // Quality of Care Four
    private String sqoc5 = "";     // Quality of Care Five
    private String sqoc6 = "";     // Quality of Care Six
    private String sqoc7 = "";     // Quality of Care Seven
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
        this.formSubType = forms.formSubType;
        this.reportingMonth = forms.reportingMonth;
        this.username = forms.username;
        this.istatus = forms.istatus;
        this.istatus96x = forms.istatus96x;
        this.shfa = forms.shfa;
        this.srsd1 = forms.srsd1;
        this.srsd2 = forms.srsd2;
        this.srsd3 = forms.srsd3;
        this.srsd4 = forms.srsd4;
        this.srsd5 = forms.srsd5;
        this.srsd6 = forms.srsd6;
        this.srsd7 = forms.srsd7;
        this.sdhmt = forms.sdhmt;
        this.sqoc1 = forms.sqoc1;
        this.sqoc2 = forms.sqoc2;
        this.sqoc3 = forms.sqoc3;
        this.sqoc4 = forms.sqoc4;
        this.sqoc5 = forms.sqoc5;
        this.sqoc6 = forms.sqoc6;
        this.sqoc7 = forms.sqoc7;
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

    public String getReportingMonth() {
        return reportingMonth;
    }

    public void setReportingMonth(String reportingMonth) {
        this.reportingMonth = reportingMonth;
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

    public String getFormSubType() {
        return formSubType;
    }

    public void setFormSubType(String formSubType) {
        this.formSubType = formSubType;
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

    public String getIstatus96x() {
        return istatus96x;
    }

    public void setIstatus96x(String istatus96x) {
        this.istatus96x = istatus96x;
    }

    public String getShfa() {
        return shfa;
    }

    public void setShfa(String shfa) {
        this.shfa = shfa;
    }

    public String getSrsd1() {
        return srsd1;
    }

    public void setSrsd1(String srsd1) {
        this.srsd1 = srsd1;
    }

    public String getSrsd2() {
        return srsd2;
    }

    public void setSrsd2(String srsd2) {
        this.srsd2 = srsd2;
    }

    public String getSrsd3() {
        return srsd3;
    }

    public void setSrsd3(String srsd3) {
        this.srsd3 = srsd3;
    }

    public String getSrsd4() {
        return srsd4;
    }

    public void setSrsd4(String srsd4) {
        this.srsd4 = srsd4;
    }

    public String getSrsd5() {
        return srsd5;
    }

    public void setSrsd5(String srsd5) {
        this.srsd5 = srsd5;
    }

    public String getSrsd6() {
        return srsd6;
    }

    public void setSrsd6(String srsd6) {
        this.srsd6 = srsd6;
    }

    public String getSrsd7() {
        return srsd7;
    }

    public void setSrsd7(String srsd7) {
        this.srsd7 = srsd7;
    }


    public String getSqoc1() {
        return sqoc1;
    }

    public void setSqoc1(String sqoc1) {
        this.sqoc1 = sqoc1;
    }


    public String getSqoc2() {
        return sqoc2;
    }

    public void setSqoc2(String sqoc2) {
        this.sqoc2 = sqoc2;
    }


    public String getSqoc3() {
        return sqoc3;
    }

    public void setSqoc3(String sqoc3) {
        this.sqoc3 = sqoc3;
    }


    public String getSqoc4() {
        return sqoc4;
    }

    public void setSqoc4(String sqoc4) {
        this.sqoc4 = sqoc4;
    }


    public String getSqoc5() {
        return sqoc5;
    }

    public void setSqoc5(String sqoc5) {
        this.sqoc5 = sqoc5;
    }


    public String getSqoc6() {
        return sqoc6;
    }

    public void setSqoc6(String sqoc6) {
        this.sqoc6 = sqoc6;
    }


    public String getSqoc7() {
        return sqoc7;
    }

    public void setSqoc7(String sqoc7) {
        this.sqoc7 = sqoc7;
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

    public String getSdhmt() {
        return sdhmt;
    }

    public void setSdhmt(String sdhmt) {
        this.sdhmt = sdhmt;
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
        json.put("formSubType", this.formSubType == null ? JSONObject.NULL : this.formSubType);
        json.put("reportingMonth", this.reportingMonth == null ? JSONObject.NULL : this.reportingMonth);
        json.put("username", this.username == null ? JSONObject.NULL : this.username);
        json.put("istatus", this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put("istatus96x", this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
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
        if (!this.srsd1.equals("")) {
            json.put("srsd1", this.srsd1.equals("") ? JSONObject.NULL : new JSONObject(this.srsd1));
        }
        if (!this.srsd2.equals("")) {
            json.put("srsd2", this.srsd2.equals("") ? JSONObject.NULL : new JSONObject(this.srsd2));
        }
        if (!this.srsd3.equals("")) {
            json.put("srsd3", this.srsd3.equals("") ? JSONObject.NULL : new JSONObject(this.srsd3));
        }
        if (!this.srsd4.equals("")) {
            json.put("srsd4", this.srsd4.equals("") ? JSONObject.NULL : new JSONObject(this.srsd4));
        }
        if (!this.srsd5.equals("")) {
            json.put("srsd5", this.srsd5.equals("") ? JSONObject.NULL : new JSONObject(this.srsd5));
        }
        if (!this.srsd6.equals("")) {
            json.put("srsd6", this.srsd6.equals("") ? JSONObject.NULL : new JSONObject(this.srsd6));
        }
        if (!this.srsd7.equals("")) {
            json.put("srsd7", this.srsd7.equals("") ? JSONObject.NULL : new JSONObject(this.srsd7));
        }
        if (!this.sdhmt.equals("")) {
            json.put("sdhmt", this.sdhmt.equals("") ? JSONObject.NULL : new JSONObject(this.sdhmt));
        }
        if (!this.sinfo.equals("")) {
            json.put("sinfo", this.sinfo.equals("") ? JSONObject.NULL : new JSONObject(this.sinfo));
        }
        if (!this.sqoc1.equals("")) {
            json.put("sqoc1", this.sqoc1.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc1));
        }
        if (!this.sqoc2.equals("")) {
            json.put("sqoc2", this.sqoc2.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc2));
        }
        if (!this.sqoc3.equals("")) {
            json.put("sqoc3", this.sqoc3.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc3));
        }
        if (!this.sqoc4.equals("")) {
            json.put("sqoc4", this.sqoc4.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc4));
        }
        if (!this.sqoc5.equals("")) {
            json.put("sqoc5", this.sqoc5.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc5));
        }
        if (!this.sqoc6.equals("")) {
            json.put("sqoc6", this.sqoc6.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc6));
        }
        if (!this.sqoc7.equals("")) {
            json.put("sqoc7", this.sqoc7.equals("") ? JSONObject.NULL : new JSONObject(this.sqoc7));
        }

        return json;
    }


}
