package com.finalproject.delership.enums;

public enum PlaneSpeed {

    SLOW("Slow", "S"),
    MID("Mid", "M"),
    HIGH("High", "H");

    private String label;

    private String value;

    PlaneSpeed(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static PlaneSpeed getEnum(String s) {
        for (PlaneSpeed item : PlaneSpeed.values()) {
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
