package br.edu.puccampinas.conversor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Objetos que serão manipulados.
    private TextView tvResult;
    private Spinner spModes;
    private EditText etTemperature;
    private Button btnConvert;
    private Temperature tConverter;
    private Temperature tConvertida;
    private Scale de;
    private Scale para;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //atribuindo o layout para a Activity.
        setContentView(R.layout.activity_main);

        //preparando os objetos de temperatura
        tConverter = new Temperature();
        tConvertida = new Temperature();

        //referencias para os objetos do layout.
        etTemperature = (EditText)this.findViewById(R.id.etTemperature);
        btnConvert = (Button)this.findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);

        spModes = (Spinner)this.findViewById(R.id.spModes);
        spModes.setOnItemSelectedListener(this);

        tvResult = (TextView)this.findViewById(R.id.tvResult);
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

                try {
                    Double valor = Double.parseDouble(etTemperature.getText().toString());
                    tConverter.setValue(valor);
                    tvResult.setText(Conversor.converter(tConverter,para).toString());
                } catch (NullPointerException ex){
                    Toast.makeText(Main.this,"Informe uma temperatura",Toast.LENGTH_LONG).show();
                } catch(NumberFormatException ex){
                    Toast.makeText(Main.this,"Informe uma temperatura válida",Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    private void atribuiDePara(Scale de, Scale para){
        this.de = de;
        this.para = para;
        tConverter.setScale(de);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        tvResult.setText("");
        etTemperature.setText("");

        switch (position){
            case 0:
                atribuiDePara(Scale.FAHRENHEIT, Scale.CELSIUS);
                break;
            case 1:
                atribuiDePara(Scale.FAHRENHEIT, Scale.KELVIN);
                break;
            case 2:
                atribuiDePara(Scale.CELSIUS, Scale.FAHRENHEIT);
                break;
            case 3:
                atribuiDePara(Scale.CELSIUS, Scale.KELVIN);
                break;
            case 4:
                atribuiDePara(Scale.KELVIN, Scale.CELSIUS);
                break;
            case 5:
                atribuiDePara(Scale.KELVIN, Scale.FAHRENHEIT);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
