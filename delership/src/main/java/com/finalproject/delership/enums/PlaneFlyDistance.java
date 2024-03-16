package com.finalproject.delership.enums;

public enum PlaneFlyDistance {
    SHORT("Short", "S"),
    MID("Mid", "M"),
    LONG("Long", "L");

    private String label;

    private String value;

    PlaneFlyDistance(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static PlaneFlyDistance getEnum(String s) {
        for (PlaneFlyDistance item : PlaneFlyDistance.values()) {
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
