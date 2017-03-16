package antonio.femxa.ahorcadoproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoriaActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        this.spCategorias = (Spinner) findViewById(R.id.spinner_categorias);

        loadSpinnerCategorias();


    }

    public void loadSpinnerCategorias() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spCategorias.setAdapter(adapter);

        this.spCategorias.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        if(pos!=0)
        {
            TypedArray array_categorias = getResources().obtainTypedArray(R.array.array_categorias);
            CharSequence [] array_especifico = array_categorias.getTextArray(pos);
            array_categorias.recycle();

            String palabra = palabraOculta(array_especifico);

            Log.d("MENSAJE2",palabra);

            Intent intent = new Intent(CategoriaActivity.this, TableroActivity.class);

            intent.putExtra("palabra_clave",palabra);

            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public String palabraOculta( CharSequence [] array_especifico){
        String palabra = null;

            int aleatoria = (int) (Math.random() * (array_especifico.length+1));
            Log.d("MENSAJE", aleatoria + "");
            palabra = array_especifico[aleatoria].toString();

        return palabra;

    }

}
