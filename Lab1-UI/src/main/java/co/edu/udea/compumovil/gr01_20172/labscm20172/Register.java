package co.edu.udea.compumovil.gr01_20172.labscm20172;

import android.app.DatePickerDialog;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static co.edu.udea.compumovil.gr01_20172.labscm20172.R.string.txtPass2Reg;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private int año,mes,dia,tel;

    private ArrayList list;

    private EditText txtFecha,
            txtNombresReg,
            txtApellidosReg,
            txtCorreoReg,
            txtPassReg,
            txtPass2reg,
            txtTel,
            txtDir,
            txtCiudad;

    private RadioButton rbMasculino, rbFemenino;

    private Button btnPhotoText, btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtNombresReg = (EditText) findViewById(R.id.txtNombres);
        txtApellidosReg = (EditText) findViewById(R.id.txtApellidos);
        txtCorreoReg = (EditText) findViewById(R.id.txtCorreo);
        txtPassReg = (EditText) findViewById(R.id.txtPass);
        txtPass2reg = (EditText) findViewById(R.id.txtPass2);
        txtTel = (EditText) findViewById(R.id.txtTel);
        txtDir = (EditText) findViewById(R.id.txtDir);
        txtCiudad = (EditText) findViewById(R.id.txtCiudad);


        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);


        btnRegistrar = (Button) findViewById(R.id.btnReg);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtFecha:
                date();
                break;
            case R.id.btnReg:
                //Todo lleno


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
                txtFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },dia,mes, año);
        datePickerDialog.show();


    }

    /*
    public ArrayList toList(){
        ArrayList listAux = new ArrayList();
        listAux.add(txtNombresReg.getText());
        listAux.add(txtApellidosReg.getText());
        listAux.add(txtCorreoReg.getText());
        listAux.add(txtFecha.getText());
        listAux.add(txtTel.getText());
        listAux.add(txtDir.getText());
        listAux.add(txtPassReg.getText());
        listAux.add(txtPass2reg.getText());
        listAux.add(txtCiudad.getText());

        return listAux;
    }*/


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbMasculino:
                if (checked)
                    Toast.makeText(this, "Todo un Machote!", Toast.LENGTH_LONG).show();
                    break;
            case R.id.rbFemenino:
                if (checked)
                    Toast.makeText(this, "Toda una MachotA!", Toast.LENGTH_LONG).show();
                    break;
        }
    }


    /*
     txtFecha,
            txtNombresReg,
            txtApellidosReg,
            txtCorreoReg,
            txtPassReg,
            txtpass2reg,
            txtTel,
            txtDir,
            txtCiudad;
     */

}
