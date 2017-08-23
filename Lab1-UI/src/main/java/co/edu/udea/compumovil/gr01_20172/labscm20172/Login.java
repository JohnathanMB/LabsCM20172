package co.edu.udea.compumovil.gr01_20172.labscm20172;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import gun0912.tedbottompicker.TedBottomPicker;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView registrar = (TextView) findViewById(R.id.lblRegistrar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lblRegistrar:
                Toast.makeText(this, "puto", Toast.LENGTH_LONG).show();

                toRegister();
                break;


        }
    }

    public void toRegister(){
        Intent iRegister = new Intent(getApplicationContext(), Register.class);
        startActivity(iRegister);
    }
}
