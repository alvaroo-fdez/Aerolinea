package org.izv.aff.interfazdeaerolnea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Declaro el textView y le añado el intent total de la factura hecho en el activity anterior
        TextView tvF = findViewById(R.id.tvpago);
        String facturaV = getIntent().getStringExtra("factura");
        tvF.setText(facturaV);

        //Como no puede hacer nada más la aplicación, le indico que al pulsar el botón pagar me muestre un snackbar, donde si intentas reintentar te muestra un toast
        Button btpago = findViewById(R.id.btpago);
        btpago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "No estoy programado para pagar", Snackbar.LENGTH_LONG)
                        .setActionTextColor(getResources().getColor(R.color.primaryColor))
                        .setAction("Reintentar", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast toast =
                                        Toast.makeText(getApplicationContext(),
                                                "No te dejo pagar", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        })
                        .show();
            }
        });
    }
}
