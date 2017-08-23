package co.edu.udea.compumovil.gr01_20172.labscm20172;

import android.app.DatePickerDialog;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private int año,mes,dia;
    private EditText txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtFecha = (EditText) findViewById(R.id.txtFecha);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtFecha:
                Toast.makeText(this, "putazo" , Toast.LENGTH_LONG).show();
                //Api > 23 :'(
                //date();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void date(){
        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        año = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtFecha.setText(dayOfMonth+"/"+(month)+"/"+year);
            }
        },dia,mes, año);
        datePickerDialog.show();


    }
}
