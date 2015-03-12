package br.edu.puccampinas.conversor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends ActionBarActivity implements View.OnClickListener{

    //Objetos que serão manipulados.
    private EditText editTemperature;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //atribuindo o layout para a Activity.
        setContentView(R.layout.activity_main);

        //referencias para os objetos do layout.
        editTemperature = (EditText)this.findViewById(R.id.editTemperature);
        btnConvert = (Button)this.findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    //tratador de cliques.
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConvert:
                //obter o valor informado.
                try {
                    Double valor = Double.parseDouble(editTemperature.getText().toString());
                    Temperature tConverter = new Temperature();
                    tConverter.setScale(Temperature.Scale.FAHRENHEIT);
                    tConverter.setValue(valor);
                    Temperature convertida = Conversor.converter(tConverter,Temperature.Scale.CELSIUS);
                    Toast.makeText(Main.this, "Em Celsius: " + convertida.getValue().toString(),Toast.LENGTH_LONG).show();

                } catch (NullPointerException e){
                    Toast.makeText(Main.this, "Temperatura não informada", Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e){
                    Toast.makeText(Main.this, "Formato de temperatura inválido. Use como exemplo: 100.50",Toast.LENGTH_LONG).show();
                    editTemperature.setText("");
                }
                break;
        }
    }
}
