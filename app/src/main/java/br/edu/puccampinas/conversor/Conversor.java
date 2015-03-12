package br.edu.puccampinas.conversor;

/**
 * Created by mateusdias on 12/03/15.
 */
public class Conversor {

    public static Temperature converter(Temperature t, Temperature.Scale e){

        Temperature converted = new Temperature();
        //°F = °C × 1,8 + 32
        if((t.getScale() == Temperature.Scale.CELSIUS) && (e == Temperature.Scale.FAHRENHEIT)){
            //de C para F
            converted.setValue((t.getValue() * 1.8) + 32.0);
            converted.setScale(Temperature.Scale.FAHRENHEIT);
        } else {
            //de F para C
            converted.setValue((t.getValue() -32) / 1.8);
            converted.setScale(Temperature.Scale.CELSIUS);
        }
        return converted;
    }


}
