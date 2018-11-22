package com.hometest.model;


public class AttributeValue<T>{
    private Attribute<T> attribute;
    private T value;

    public Attribute<T> getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute<T> attribute) {
        this.attribute = attribute;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
