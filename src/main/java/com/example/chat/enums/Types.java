package com.example.chat.enums;

public enum Types {
    MESSAGE("Message");

    final public String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
