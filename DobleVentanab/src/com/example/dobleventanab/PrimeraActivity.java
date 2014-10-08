package com.example.dobleventanab;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrimeraActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primera);
		
		//Identificar los campos con informacion
		
		final EditText usuario = (EditText)findViewById(R.id.editUsuario);
		final EditText pass = (EditText)findViewById(R.id.editPassword);
		final Button boton = (Button)findViewById(R.id.button1);
		
		boton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				//Definimos el intent
				
				Intent segunda = new Intent(
						PrimeraActivity.this,SegundaActivity.class
						);
				
				//Recoger la informacion
				segunda.putExtra("user", usuario.getText().toString());
				segunda.putExtra("passw", pass.getText().toString());
			//startActivity(segunda);
				startActivityForResult(segunda,1);
			}
			
		});
		
		
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		final TextView comprobado=(TextView) findViewById(R.id.textView1);
		if(requestCode ==1){
			if(resultCode == RESULT_OK){
				String resultado=data.getStringExtra("txt");
				comprobado.setText(resultado);
				
			}
			if (resultCode== RESULT_CANCELED){
			}
			}
		}//onActivityResult

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.primera, menu);
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
