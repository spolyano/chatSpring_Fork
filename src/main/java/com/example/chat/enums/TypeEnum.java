package com.example.chat.enums;

public enum TypeEnum {
    MESSAGE("Message");

    final public String type;

    TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
