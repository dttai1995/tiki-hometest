package com.hometest.model;


public class Attribute<T> {
    private Long attributeId;
    private Class<T> type;
    public String attributeName;

    public Attribute() {
    }

    public Attribute(Long attributeId, String attributeName) {
        this.attributeId = attributeId;
        this.attributeName = attributeName;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }


    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
