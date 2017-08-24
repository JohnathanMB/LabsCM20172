package co.edu.udea.compumovil.gr01_20172.labscm20172;

import android.app.DatePickerDialog;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import android.app.Dialog;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.text.Editable;
import android.text.Layout;
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

    private ConstraintLayout layout;
    private int año,mes,dia;
    private String nombres , apellidos, sexo,correo, fecha, pass, pass2, tel, dir, ciudad;
    private Boolean full;

    private ArrayList list, keys;

    private EditText txtFecha,
            txtNombresReg,
            txtApellidosReg,
            txtCorreoReg,
            txtPass2reg,
            txtPassReg,
            txtTel,
            txtDir,
            txtCiudad;

    private RadioButton rbMasculino, rbFemenino;

    private Button btnPhotoText, btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        layout = (ConstraintLayout) findViewById(R.id.activity_register);
        full = true;

        txtNombresReg = (EditText) findViewById(R.id.txtNombres);
        txtApellidosReg = (EditText) findViewById(R.id.txtApellidos);
        txtCorreoReg = (EditText) findViewById(R.id.txtCorreo);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtPassReg = (EditText) findViewById(R.id.txtPass);
        txtPass2reg = (EditText) findViewById(R.id.txtPass2);
        txtTel = (EditText) findViewById(R.id.txtTel);
        txtDir = (EditText) findViewById(R.id.txtDir);
        txtCiudad = (EditText) findViewById(R.id.txtCiudad);

        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);


        btnRegistrar = (Button) findViewById(R.id.btnReg);


    }

    private void keys(){
        keys = new ArrayList();
        keys.add("FOTO");
        keys.add("NOMBRE");
        keys.add("APELLIDO");
        keys.add("SEXO");
        keys.add("FECHA");
        keys.add("TELEFONO");
        keys.add("DIRECCION");
        keys.add("CORREO");
        keys.add("PASS");
        keys.add("PASS2");
        keys.add("CIUDAD");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtFecha:
                date();

                fecha = txtFecha.getText().toString();
                if(fecha.equals("")){
                    txtFecha.setError("Llenar Campo");
                    full = false;
                }
                Toast.makeText(this, fecha, Toast.LENGTH_SHORT).show();

                //return;
                break;


            case R.id.btnReg:
                full = isComplete();
                if(full==false){
                    Snackbar snackbar = Snackbar.make(layout, "REGISTRO INCOMPLETO", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    break;
                }else {
                    Snackbar snackbar2 = Snackbar.make(layout, "REGISTRO COMPLETO", Snackbar.LENGTH_SHORT);
                    snackbar2.show();
                    break;
                }
        }
    }

    public Boolean isComplete(){
        Boolean fullAux = true;




        nombres = txtNombresReg.getText().toString();
        if (nombres.equals("")){
            txtNombresReg.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, nombres, Toast.LENGTH_SHORT).show();


        apellidos = txtApellidosReg.getText().toString();
        if (apellidos.equals("")){
            txtApellidosReg.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, apellidos, Toast.LENGTH_SHORT).show();


        correo = txtCorreoReg.getText().toString();
        if (correo.equals("")){
            txtCorreoReg.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, correo, Toast.LENGTH_SHORT).show();


        pass = txtPassReg.getText().toString();
        if (pass.equals("")){
            txtPassReg.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show();


        pass2 = txtPass2reg.getText().toString();
        if (pass2.equals("")) {
            txtPass2reg.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, pass2, Toast.LENGTH_SHORT).show();


        tel = txtTel.getText().toString();
        if (tel.equals("")) {
            txtTel.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, tel, Toast.LENGTH_SHORT).show();


        dir = txtDir.getText().toString();
        if (dir.equals("")) {
            txtDir.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, dir, Toast.LENGTH_SHORT).show();


        ciudad = txtCiudad.getText().toString();
        if (ciudad.equals("")){
            txtCiudad.setError("Llenar Campo");
            fullAux = false;
        }
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show();

        return fullAux;
    }



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
        },dia ,mes ,año);
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

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbMasculino:
                if (checked)
                    sexo= "Masculino";
                    Toast.makeText(this, "Todo un Machote!", Toast.LENGTH_LONG).show();
                    break;
            case R.id.rbFemenino:
                if (checked)
                    sexo = "Femenino";
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
