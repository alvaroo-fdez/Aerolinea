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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AlertDialog1 extends AppCompatActivity {
    private ImageButton imgbt1, imgbt2;
    private Button bt_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbt1 = findViewById(R.id.imgbt1);
        imgbt2 = findViewById(R.id.imgbt2);

        imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast =
                        Toast.makeText(getApplicationContext(),
                                "Cancelado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast =
                        Toast.makeText(getApplicationContext(),
                                "Aceptado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
