package com.finalproject.delership.enums;

public enum PlaneType {

    PERSONAL("Personal", "P"),
    BUSINESS("Business", "B"),
    SPECIALIZED("Specialized", "S");

    private String label;

    private String value;

    PlaneType(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static PlaneType getEnum(String s) {
        for (PlaneType item : PlaneType.values()) {
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
