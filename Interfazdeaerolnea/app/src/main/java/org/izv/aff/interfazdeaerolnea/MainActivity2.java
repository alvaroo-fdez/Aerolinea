package org.izv.aff.interfazdeaerolnea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Recogo los intent de cada campo que he ido incluyendo desde la otra actividad
        String sp1V = getIntent().getStringExtra("sp1");
        String sp2V = getIntent().getStringExtra("sp2");
        TextView tv_viaje = findViewById(R.id.tv_viaje);

        TextView tv_name = findViewById(R.id.tv_name);
        String proV = getIntent().getStringExtra("pro");
        String nameV = getIntent().getStringExtra("name");

        //Simplemente un mensaje cordial al usuario con su prefijo y nombre
        tv_name.setText("Buenas " + proV + " " + nameV + ", un resumen de su pago:");

        //Añado el textview que luego usaré para incluir los campos
        TextView tv_resumen = findViewById(R.id.tv_descripcion);

        //Sigo recogiendo los intent de cada campo que he ido incluyendo desde la otra actividad
        String lastnameV = getIntent().getStringExtra("lastname");
        String addressV = getIntent().getStringExtra("address");
        String phoneV = getIntent().getStringExtra("phone");
        String emailV = getIntent().getStringExtra("email");
        String cbClassV = getIntent().getStringExtra("cbClass");
        String cbWindowV = getIntent().getStringExtra("cbWindow");
        String cbPetV = getIntent().getStringExtra("cbPet");
        String cbBrkV = getIntent().getStringExtra("cbBrk");
        String cbEatV = getIntent().getStringExtra("cbEat");
        String cbDinnerV = getIntent().getStringExtra("cbDinner");
        String rbSecV = getIntent().getStringExtra("rbSec");
        String swMV = getIntent().getStringExtra("swM");
        String accpreV = getIntent().getStringExtra("accpre");

        //Paso a int aquellos campos que deba tratar para hacer la factura
        int clase = Integer.parseInt(cbClassV);
        int ventana = Integer.parseInt(cbWindowV);
        int mascota = Integer.parseInt(cbPetV);
        int desayuno = Integer.parseInt(cbBrkV);
        int almuerzo = Integer.parseInt(cbEatV);
        int cena = Integer.parseInt(cbDinnerV);
        int seguro = Integer.parseInt(rbSecV);
        int movilidad = Integer.parseInt(swMV);
        int accesopre = Integer.parseInt(accpreV);
        int precioBase = 0;

        //Creo una semilla que sea un precio de base de vuelo de 50 euros al que añado dinero según la longitud de la ciudad indicada (para que no sean iguales todas las facturas)
        String seed = sp1V.toLowerCase(Locale.ROOT) + sp2V.toLowerCase(Locale.ROOT);
        precioBase = seed.length() + 50;
        tv_viaje.setText("Su viaje será desde "+sp1V+" hasta "+sp2V+" añadirán "+precioBase+" euros");

        //Declaro una factura, la que será la suma de todos los valores que he indicado anteriormente tratados
        int facturaTotal = clase+ventana+mascota+desayuno+almuerzo+cena+seguro+movilidad+accesopre+precioBase;

        //Hago un string de la factura total para poder pasarlo de esta actividad a una tercera y luego así con el intent poder mostrarlo sin errores
        String total = String.valueOf(facturaTotal);

        //Al segundo textView le añado todos los campos que he recogido del int de la primera actividad (los campos)
        tv_resumen.setText("Nombre: " + nameV + "\n"
                + "Apellido: " + lastnameV + "\n"
                + "Dirección:" + addressV + "\n"
                + "Teléfono: " + phoneV + "\n"
                + "E-mail: " + emailV + "\n"
                + "Primera clase: " + cbClassV + "\n"
                + "Ventana: " + cbWindowV + "\n"
                + "Mascota: " + cbPetV + "\n"
                + "Desayuno: " + cbBrkV + "\n"
                + "Almuerzo: " + cbEatV + "\n"
                + "Cena: " + cbDinnerV + "\n"
                + "Seguro adicional: " + rbSecV + "\n"
                + "Movilidad reducida: " + swMV + "\n"
                + "Acceso preferente: " + accpreV + "\n"
                + "Factura: "+facturaTotal);

        //Añado el boton de continuar, el cual al pulsarlo hará un intent del total explicado anteriormente hacia la 3 actividad
        Button btcontinue = findViewById(R.id.bt_continue);
        btcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("factura",total);
                startActivity(intent);
            }
        });

    }
}