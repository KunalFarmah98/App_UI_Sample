package com.apps.kunalfarmah.connect_my_match_assign;

import android.widget.ImageView;

public class Study {
    Integer imgID;
    String header;
    String  perc;

    public Study(Integer imgID, String header, String perc) {
        this.imgID = imgID;
        this.header = header;
        this.perc = perc;
    }

    public Integer getImgID() {
        return imgID;
    }

    public void setImgID(Integer imgID) {
        this.imgID = imgID;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPerc() {
        return perc;
    }

    public void setPerc(String perc) {
        this.perc = perc;
    }
}
