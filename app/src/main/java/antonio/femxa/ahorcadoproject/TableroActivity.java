package antonio.femxa.ahorcadoproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TableroActivity extends AppCompatActivity {

    private String palabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        palabra = getIntent().getStringExtra("palabra_clave");

        Log.d("MENSAJE",palabra);

        View v = findViewById(R.id.textView2);
        TextView textView = (TextView) v;

        textView.setText(palabra);

    }

}
