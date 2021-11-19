package org.izv.aff.interfazdeaerolnea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ImageButton imgbt;
    private Button bt_fin;
    private EditText et_name;
    private Spinner sp_sr;
    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //El siguiente código es simplemente para agregarle funcionalidad a los spinner, Donde les añado a cada spinner según su id una serie de valores
        //que saco del archivo arrays.xml

        //Busco el primer spinner por si id
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //Indico de donde sacaré los valores y como mostrarlos
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Tratamiento, android.R.layout.simple_spinner_item);
        //Indico un adaptador con la forma en la que se dispondrán los valores del spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Le añado el adaptador a mi spinner
        spinner.setAdapter(adapter);
        //Le añado un listener al spinner
        spinner.setOnItemSelectedListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Busco el segundo spinner por si id
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        //Indico de donde sacaré los valores y como mostrarlos
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.CiudadOrigen, android.R.layout.simple_spinner_item);
        //Indico un adaptador con la forma en la que se dispondrán los valores del spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Le añado el adaptador a mi spinner
        spinner2.setAdapter(adapter2);
        //Le añado un listener al spinner
        spinner2.setOnItemSelectedListener(this);

        //Busco el tercer spinner por si id
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        //Indico de donde sacaré los valores y como mostrarlos
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.CiudadDestino, android.R.layout.simple_spinner_item);
        //Indico un adaptador con la forma en la que se dispondrán los valores del spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Le añado el adaptador a mi spinner
        spinner3.setAdapter(adapter3);
        //Le añado un listener al spinner
        spinner3.setOnItemSelectedListener(this);

        //Este ImageButton es el botón de acceso preferente
        imgbt = findViewById(R.id.imgBt);
        imgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hago un AlertDialog con su título y mensaje y con las opciones de ACEPTAR y CANCELAR
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("ACCESO PREFERENTE");
                builder.setMessage("¿Desea contratar el acceso preferente?");

                //Aquí indicamos que como opción positiva (Aceptar), nos deshabilite el ImageButton (para no poder contratar más de 1 vez el acceso preferente) y que nos muestre
                //un toast indicando que ha sido contratado
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        imgbt.setEnabled(false);
                        Toast toast =
                                Toast.makeText(getApplicationContext(),
                                        "ACCESO PREFERENTE CONTRATADO", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                //Como opción negativa (Cancelar), simplemente no hace nada y muestra un toast advirtiendo de que la opción se ha cancelado
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast =
                                Toast.makeText(getApplicationContext(),
                                        "OPERACIÓN CANCELADA", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                //Mostramos el AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //Añadimos al código el botón de finalizar compra y le damos utilidad
        bt_fin = findViewById(R.id.bt_fin);
        bt_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Añadimos todos los componentes que queremos que formen parte del código a los que daremos algún uso
                CheckBox cbClase = (CheckBox) findViewById(R.id.cb_1clase);
                CheckBox cbVentanilla = (CheckBox) findViewById(R.id.cb_ventanilla);
                CheckBox cbMascota = (CheckBox) findViewById(R.id.cb_mascota);
                CheckBox cbDesayuno = (CheckBox) findViewById(R.id.cb_comida1);
                CheckBox cbAlmuerzo = (CheckBox) findViewById(R.id.cb_comida2);
                CheckBox cbCena = (CheckBox) findViewById(R.id.cb_comida3);
                CheckBox cbTerminos = (CheckBox) findViewById(R.id.cb_term);
                Spinner sp_sr = findViewById(R.id.spinner);
                Spinner sp_1 = findViewById(R.id.spinner2);
                Spinner sp_2 = findViewById(R.id.spinner3);
                RadioButton rb = findViewById(R.id.radioButton);

                Switch sw = findViewById(R.id.switch1);

                EditText et_name = findViewById(R.id.et_name);
                EditText et_ap = findViewById(R.id.et_ap);
                EditText et_ad = findViewById(R.id.et_address);
                EditText et_ph = findViewById(R.id.et_phone);
                EditText et_mail = findViewById(R.id.et_mail);

                //Hago un string de cada campo, cogiendo la información introducida en cada campo
                String sp1 = sp_1.getSelectedItem().toString();
                String sp2 = sp_2.getSelectedItem().toString();
                String pro = sp_sr.getSelectedItem().toString();
                String name = et_name.getText().toString();
                String lastname = et_ap.getText().toString();
                String address = et_ad.getText().toString();
                String phone = et_ph.getText().toString();
                String email = et_mail.getText().toString();

                //Creamos el intent que ira desde nuestra actividad principal hasta la segunda clase (factura)
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                //Comprobamos si los checkBox y radioButton de nuestra app están seleccionados cuando queramos ir a la factura, donde ponemos un precio personalizado si está seleccionado
                //y si no lo está mandamos el mismo intent pero en 0
                if (cbClase.isChecked() == true) {
                    intent.putExtra("cbClass", "50");
                } else {
                    intent.putExtra("cbClass", "0");
                }
                if (cbVentanilla.isChecked() == true) {
                    intent.putExtra("cbWindow", "10");
                } else {
                    intent.putExtra("cbWindow", "0");
                }
                if (cbMascota.isChecked() == true) {
                    intent.putExtra("cbPet", "8");
                } else {
                    intent.putExtra("cbPet", "0");
                }
                if (cbDesayuno.isChecked() == true) {
                    intent.putExtra("cbBrk", "10");
                } else {
                    intent.putExtra("cbBrk", "0");
                }
                if (cbAlmuerzo.isChecked() == true) {
                    intent.putExtra("cbEat", "10");
                } else {
                    intent.putExtra("cbEat", "0");
                }
                if (cbCena.isChecked() == true) {
                    intent.putExtra("cbDinner", "10");
                } else {
                    intent.putExtra("cbDinner", "0");
                }
                if (rb.isChecked() == true) {
                    intent.putExtra("rbSec", "15");
                } else {
                    intent.putExtra("rbSec", "0");
                }
                if (sw.isChecked() == true) {
                    intent.putExtra("swM", "15");
                } else {
                    intent.putExtra("swM", "0");
                }
                //Esta comprobación es para el acceso preferente, como he mencionado anteriormente, deshabilito el ImageButton cuando es seleccionado, por lo que hago
                //una comprobación donde si no está habilitado que lo añada y si no, simplemente lo deje en 0€
                if (!imgbt.isEnabled()) {
                    intent.putExtra("accpre", "50");
                } else {
                    intent.putExtra("accpre", "0");
                }

                //Estos intent no necesitan comprobación, ya que es información que mandamos de los spinner que es obligatorio que estén completos de un valor del array
                intent.putExtra("sp1", sp1);
                intent.putExtra("sp2", sp2);
                intent.putExtra("pro", pro);

                //Aquí hago una comprobación de errores, donde según el campo que esté vacío, le pongo al usuario que falta por rellenar ese campo a la hora de facturar
                if (!name.isEmpty()) {
                    intent.putExtra("name", name);
                } else {
                    intent.putExtra("name", "Falta rellenar el nombre");
                }
                if (!lastname.isEmpty()) {
                    intent.putExtra("lastname", lastname);
                } else {
                    intent.putExtra("lastname", "Falta rellenar el apellido");
                }
                if (!address.isEmpty()) {
                    intent.putExtra("address", address);
                } else {
                    intent.putExtra("address", "Falta rellenar la dirección");
                }
                if (!phone.isEmpty()) {
                    intent.putExtra("phone", phone);
                } else {
                    intent.putExtra("phone", "Falta rellenar el teléfono");
                }
                if (!email.isEmpty()) {
                    intent.putExtra("email", email);
                } else {
                    intent.putExtra("email", "Falta rellenar el email");
                }

                //Esta comprobación de aquí es necesaria, ya que si no se aceptan los términos y condiciones de nuestra empresa, no podremos avanzar con la factura, por lo que
                //si ese checkBox no está chekeado, con un toast indicamos que es necesario que los acepte
                if (cbTerminos.isChecked() == true) {
                    startActivity(intent);
                } else {
                    Toast toast =
                            Toast.makeText(getApplicationContext(),
                                    "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos
        // HE DECIDIDO QUITARLE LA FUNCIONALIDAD AL MENÚ, YA QUE A PARTE DE TOAST NO TENGO OTRA FORMA DE DARLE USO SIENDO REALISTAS
        /*switch (id) {
            case R.id.item1:
                Toast toast =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.item2:
                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast2.show();
                break;
            case R.id.item3:
                Toast toast3 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast3.show();
                break;
            case R.id.item4:
                Toast toast4 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast4.show();
                break;
            case R.id.item5:
                Toast toast5 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast5.show();
                break;
            case R.id.item6:
                Toast toast6 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast6.show();
                break;
            case R.id.item7:
                Toast toast7 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast7.show();
                break;
            case R.id.item8:
                Toast toast8 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast8.show();
                break;
            case R.id.item9:
                Toast toast9 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast9.show();
                break;
            case R.id.item10:
                Toast toast10 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast10.show();
                break;
            case R.id.item11:
                Toast toast11 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast11.show();
                break;
            case R.id.item12:
                Toast toast12 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast12.show();
                break;
            case R.id.item13:
                Toast toast13 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast13.show();
                break;
            case R.id.item14:
                Toast toast14 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast14.show();
                break;
            case R.id.item15:
                Toast toast15 =
                        Toast.makeText(getApplicationContext(),
                                "DEBE ACEPTAR NUESTRA POLÍTICA PARA CONTINUAR", Toast.LENGTH_SHORT);
                toast15.show();
                break;
        }
*/
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;


    }

}
