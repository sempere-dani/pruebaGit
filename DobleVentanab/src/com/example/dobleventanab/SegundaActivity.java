package com.example.dobleventanab;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda);
		
		//Capturaremos el intent de la primera pagina
		Intent primera=getIntent();
		
		//Recuperamos y colocamos la info de los datos
		//Identificar los campos con informacion
		final TextView usu = (TextView)findViewById(R.id.textUsuario);
		final TextView pas = (TextView)findViewById(R.id.textPassword2);
		
		//Colocamos la informacion
		usu.setText(primera.getStringExtra("user"));
		pas.setText(primera.getStringExtra("passw"));
	
		//Preparamos el boton de vuelta
		final Button boton = (Button)findViewById(R.id.button1);
		boton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				//Creamos el intent
				Intent devolucion = new Intent();
				devolucion.putExtra("txt","Comprobado OK");
				setResult(RESULT_OK,devolucion);
				finish();
				
			}
			
		});
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.segunda, menu);
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
