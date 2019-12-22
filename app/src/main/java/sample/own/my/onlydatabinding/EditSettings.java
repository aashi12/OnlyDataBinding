package sample.own.my.onlydatabinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapters.AdapterDaysTime;
import adapters.Daystimepojos;

public class EditSettings extends AppCompatActivity {


    RecyclerView myrecy;
    Switch everyfdayswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_settings);
        myrecy = findViewById(R.id.recyday);


        findViewById(R.id.rowsingle).findViewById(R.id.chkday).setVisibility(View.GONE);


        findViewById(R.id.rowsingle).findViewById(R.id.pickopentime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myadapter.tiemPicker((TextView) v, 100);
            }
        });

        findViewById(R.id.rowsingle).findViewById(R.id.pickcloseime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myadapter.tiemPicker((TextView) v, 100);
            }
        });


        everyfdayswitch = (Switch) findViewById(R.id.swtevery);


        everyfdayswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    myrecy.setVisibility(View.GONE);
                    findViewById(R.id.rowsingle).setVisibility(View.VISIBLE);


                } else {

//                    myrecy.setVisibility(View.VISIBLE);
//                    findViewById(R.id.rowsingle).setVisibility(View.GONE);
                    myrecy.setVisibility(View.VISIBLE);
                    findViewById(R.id.rowsingle).setVisibility(View.GONE);

                }

            }
        });
        populatedpter();
        findViewById(R.id.btnsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<Daystimepojos> myfinaldata = new ArrayList<>();


                if (everyfdayswitch.isChecked()) {


                    return;
                }


                for (Daystimepojos day : myadapter.mydata) {
                    if (day.getIsselcted())
                        myfinaldata.add(day);
                }


            }
        });
    }


    AdapterDaysTime myadapter;

    private void populatedpter() {

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        myrecy.setLayoutManager(llm);

        myadapter = new AdapterDaysTime(this);
        myrecy.setAdapter(myadapter);

    }
}
