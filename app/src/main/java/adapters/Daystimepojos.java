package adapters;

import android.os.Parcel;
import android.os.Parcelable;

public class Daystimepojos implements Parcelable {


    String dayonweek;

    String opentime;
    String clsoetime;

    boolean isselcted;

    public Daystimepojos(String dayonweek, String opentime, String clsoetime, boolean isselcted) {
        this.dayonweek = dayonweek;
        this.opentime = opentime;
        this.clsoetime = clsoetime;
        this.isselcted = isselcted;
    }




    public  void  setDefault()
    {

        dayonweek="";
        opentime="";
        clsoetime="";
        isselcted=false;

    }





    public Daystimepojos(String dayofweek) {
    this.dayonweek=dayofweek
    ;
    }

    public String getDayonweek() {
        return dayonweek;
    }

    public void setDayonweek(String dayonweek) {
        this.dayonweek = dayonweek;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getClsoetime() {
        return clsoetime;
    }

    public void setClsoetime(String clsoetime) {
        this.clsoetime = clsoetime;
    }

    public boolean getIsselcted() {
        return isselcted;
    }

    public void setIsselcted(boolean isselcted) {
        this.isselcted = isselcted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dayonweek);
        dest.writeString(this.opentime);
        dest.writeString(this.clsoetime);
        dest.writeByte(this.isselcted ? (byte) 1 : (byte) 0);
    }

    protected Daystimepojos(Parcel in) {
        this.dayonweek = in.readString();
        this.opentime = in.readString();
        this.clsoetime = in.readString();
        this.isselcted = in.readByte() != 0;
    }

    public static final Creator<Daystimepojos> CREATOR = new Creator<Daystimepojos>() {
        @Override
        public Daystimepojos createFromParcel(Parcel source) {
            return new Daystimepojos(source);
        }

        @Override
        public Daystimepojos[] newArray(int size) {
            return new Daystimepojos[size];
        }
    };
}
