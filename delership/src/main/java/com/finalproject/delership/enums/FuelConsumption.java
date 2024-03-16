package com.finalproject.delership.enums;

public enum FuelConsumption {

    AVGAS("Avgas", "AV"),
    JET_FUEL("Jet Fuel", "JF");

    private String label;

    private String value;

    FuelConsumption(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static FuelConsumption getEnum(String s) {
        for (FuelConsumption item : FuelConsumption.values()) {
            if (item.value.equals(s)) {
                return item;
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }
    public String getLabel() {
        return label;
    }
}
