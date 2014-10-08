package com.example.dobleventana;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends ActionBarActivity {
	private static final String TAG = "Primera ventana";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		//Capturamos los diferentes Views de la 1ª pantalla
		 final Button boton = (Button)findViewById(R.id.button1);
		 final EditText user = (EditText)findViewById(R.id.editText1);
		 final EditText psswd = (EditText)findViewById(R.id.editText2);
		 
	        boton.setOnClickListener(new Button.OnClickListener(){

				@Override
				public void onClick(View v) {
					//Crear el intent
					Intent second=new Intent(
							FirstActivity.this,
							SecondActivity.class);
					
					//En el intent enviamos la info de la primera ventana
					second.putExtra("usuario", user.getText().toString());
					second.putExtra("contrasena", psswd.getText().toString());
					//startActivity(second);
					
					startActivityForResult(second,1);//espera q devuelva un resultado
														//>=0 on activity resolt
				}
	        	
	        });
	        Log.i(TAG, "onCreate");
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		final TextView comprobado=(TextView) findViewById(R.id.textView3);
		if(requestCode ==1){
			if(resultCode == RESULT_OK){
				String resultado=data.getStringExtra("txt");
				comprobado.setText(resultado);
				
			}
			if (resultCode== RESULT_CANCELED);
		}//onActivityResult
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
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
	protected void onStart(){
		super.onStart();
		Log.i(TAG, "onStart");
	}
}
