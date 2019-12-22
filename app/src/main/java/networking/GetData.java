package networking;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import sample.own.my.onlydatabinding.BR;

public class GetData extends BaseObservable
{

    public GetData(String name, String rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    String name;
    String rollno;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }




    @Bindable
    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
        notifyPropertyChanged(BR.rollno);
    }
}
