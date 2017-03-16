package antonio.femxa.ahorcadoproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TableroActivity extends AppCompatActivity {

    private String palabra;
    private int[] array_pics = {R.drawable.ic_cuerda, R.drawable.ic_cabeza, R.drawable.ic_cuerpo, R.drawable.ic_brazo, R.drawable.ic_brazos, R.drawable.ic_pierna};
    private static int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        contador = 0;

        palabra = getIntent().getStringExtra("palabra_clave");

        ImageView imageView = (ImageView) findViewById(R.id.imagenes_ahorcado);
        imageView.setImageResource(array_pics[contador]);

        View v = findViewById(R.id.textView2);
        TextView textView = (TextView) v;

        textView.setText(palabra);

    }

    public void escribirNumero(View boton){
        // declaramos variables y hacemos el casteo del boton para usarle
        String palabra = getPalabra();
        Log.d("MENSAJE",palabra);
        Button btnPulsado = (Button) boton;
        String pulsado=  btnPulsado.getText().toString();//cogemos el texto del boton pulsado
       // String palabra="ISABEL";//nos creamos un string que le pasaremos al metodo

        //nos creamos una variable boleana que nos dara si es falso o verdadero con lo que salga del metodo
        // haremos una condicion if en la que nos dira si la encuentra que cambie el texto del boton y lo ponga del color verde
        //sino que la ponga de color rojo y no deje pulsarla otra vez la deshabilita
        palabra = palabra.toUpperCase();
        boolean encontrada=buscarLetra(pulsado, palabra);
        if(encontrada)
        {
            btnPulsado.setTextColor(Color.rgb(34, 153, 84));
        }
        else
        {
            btnPulsado.setTextColor(Color.RED);
            btnPulsado.setEnabled(false);
            contador++;
            if(contador == 6)
            {
                Intent intent = new Intent(TableroActivity.this, DerrotaActivity.class);

                startActivity(intent);
            }
            else
            {
                ImageView imageView = (ImageView) findViewById(R.id.imagenes_ahorcado);
                imageView.setImageResource(array_pics[contador]);
            }
        }


    }

    public boolean  buscarLetra(String letra, String palabra){
        boolean encontrado = false;
        char letrita= letra.charAt(0);
        for(int i=0; i<palabra.length(); i++){
            if(letrita == palabra.charAt(i)){
                encontrado=true;
            }
        }

        return encontrado;
    }

    public String getPalabra(){
        return palabra;
    }
}


