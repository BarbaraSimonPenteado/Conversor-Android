package br.edu.puccampinas.conversor;

public class Temperature {

    public enum Scale {
        CELSIUS, FAHRENHEIT, KELVIN
    }

    private Scale scale;
    private Double value;

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}