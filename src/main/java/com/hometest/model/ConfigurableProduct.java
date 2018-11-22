package com.hometest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConfigurableProduct extends Product {

    private AttributeSet attributeSet;
    private List<Product> childProduct;

    public ConfigurableProduct() {
        super();
        childProduct = new ArrayList<>();
    }

    public void addProduct(Product product) {
        Set<Attribute> attrs = attributeSet.getAttributeSet();
        for (Attribute att : attrs) {
            if (product.getAttribute(att) == null) {
                System.out.println("Product must have value for attribute in attribute set");
                return;
            }
        }

        childProduct.add(product);
    }

    public List<Product> getChildProduct() {
        return childProduct;
    }

    public void setChildProduct(List<Product> childProduct) {
        this.childProduct = childProduct;
    }

    public AttributeSet getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        this.attributeSet = attributeSet;
    }

    public String showOption() {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Attribute> attrs = attributeSet.getAttributeSet();
        for (Product product : childProduct) {
            stringBuilder.append(product.getName() + ": ");
            for (Attribute att : attrs) {
                stringBuilder.append(att.getAttributeName() + " - " + product.getAttribute(att)+" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
