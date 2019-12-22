package adapters;

import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.Group;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sample.own.my.onlydatabinding.R;

public class AdapterDaysTime extends RecyclerView.Adapter<AdapterDaysTime.ViewholderDaysTime> {


    Context mcon;

   public List<Daystimepojos> mydata;

    public AdapterDaysTime(Context con) {
        mcon = con;

        mydata = new ArrayList<>();

        mydata.add(new Daystimepojos("Sunday"));
        mydata.add(new Daystimepojos("Monday"));
        mydata.add(new Daystimepojos("Tuesday"));
        mydata.add(new Daystimepojos("Wednesday"));
        mydata.add(new Daystimepojos("Thursday"));
        mydata.add(new Daystimepojos("Friday"));
        mydata.add(new Daystimepojos("Saturday"));

    }



    @NonNull
    @Override
    public ViewholderDaysTime onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewholderDaysTime(LayoutInflater.from(mcon).inflate(R.layout.rowdayofweektie, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderDaysTime viewholderDaysTime, int i) {


        viewholderDaysTime.selected.setText(mydata.get(i).getDayonweek());

        if (mydata.get(i).getIsselcted()) {

            viewholderDaysTime.selected.setChecked(true);



            viewholderDaysTime.timegroup.setVisibility(View.VISIBLE);

        } else{ viewholderDaysTime.selected.setChecked(false);

            viewholderDaysTime.timegroup.setVisibility(View.GONE);}



        if (mydata.get(i).getClsoetime() != null) {
            viewholderDaysTime.closepicker.setText(mydata.get(i).getClsoetime());

        } else {

            viewholderDaysTime.closepicker.setText("");
        }


        if (mydata.get(i).getOpentime() != null) {
            viewholderDaysTime.openpicker.setText(mydata.get(i).getOpentime());

        } else {

            viewholderDaysTime.openpicker.setText("");
        }

    }


    @Override
    public int getItemCount() {
        return mydata.size();
    }

    class ViewholderDaysTime extends RecyclerView.ViewHolder {

        CheckBox selected;
        TextView openpicker;
        TextView closepicker;

        Group timegroup;

        public ViewholderDaysTime(@NonNull View itemView) {
            super(itemView);


            selected = itemView.findViewById(R.id.chkday);
            openpicker = itemView.findViewById(R.id.pickopentime);
            closepicker = itemView.findViewById(R.id.pickcloseime);
            timegroup = itemView.findViewById(R.id.group);




            selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {




                    if(isChecked) {
                        mydata.get(getAdapterPosition()).setIsselcted(true);


                        timegroup.setVisibility(View.VISIBLE);

                    }
                    else {
                        mydata.get(getAdapterPosition()).setIsselcted(false);


                        timegroup.setVisibility(View.GONE);

                    }





                }
            });


            openpicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tiemPicker((TextView) v,getAdapterPosition());
                }
            });

            closepicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tiemPicker((TextView) v, getAdapterPosition());
                }
            });

        }




    }
    public void tiemPicker(final TextView ttt, final int i) {
        // Get Current Time
        Calendar c = Calendar.getInstance();

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(mcon,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


                        ttt.setText(+hourOfDay + ":" + minute);

                        if(i==100)
                            return;



                        if (ttt.getId()==R.id.pickopentime)
                            mydata.get(i).setOpentime(ttt.getText().toString());

                        else
                            mydata.get(i).setClsoetime(ttt.getText().toString());





                    }
                }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
        timePickerDialog.show();
    }


}
