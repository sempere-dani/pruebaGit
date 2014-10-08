package com.example.dobleventana;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {
	private static final String TAG = "segunda ventana";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		//Capturamos el Intent de la otra ventana
		Intent first = getIntent();
		
		//Recuperamos y colocamos la info de cada uno de los datos
		final TextView user = (TextView)findViewById(R.id.usuario2);
		final TextView psswd = (TextView)findViewById(R.id.pss2);
		final Button boton = (Button)findViewById(R.id.button1);
		
		boton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				//Crear el intent
				Intent devolucion=new Intent();
				
				//En el intent enviamos la info de la primera ventana
				devolucion.putExtra("txt", "Comprobado ok");
				setResult(RESULT_OK,devolucion);
				//startActivity(second);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
