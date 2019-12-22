package sample.own.my.onlydatabinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import networking.GetData;
import sample.own.my.onlydatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    GetData fdff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser("Dff");
        fdff = new GetData("ds", "dsds");
        binding.setMynetworking(fdff);
        binding.iifff.getMynetworking();





    }


    @BindingAdapter("hihi")
    public static void myvoid(TextView mytext, String getData) {


        Log.i("fdfd", "dfdfdf");


    }


}
