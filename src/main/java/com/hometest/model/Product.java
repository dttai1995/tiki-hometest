package com.hometest.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private BigDecimal marketPrice;
    private BigDecimal salePrice;
    private Picture mainPic;
    private List<Picture> galleryPics;
    private List<AttributeValue> customAttributes;


    public Product() {
        this.customAttributes = new ArrayList<>();
    }

    // Getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public List<AttributeValue> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(List<AttributeValue> customAttributes) {
        this.customAttributes = customAttributes;
    }


    public List<Picture> getGalleryPics() throws IOException {
        // Lazy-fetching
        for (Picture pic : galleryPics) {
            pic.getData();
        }
        return galleryPics;

    }

    public Picture getMainPic() throws IOException {
        for (Picture pic : galleryPics) {

        }
        Picture picture = galleryPics.get(0);
        picture.getData();
        return picture;
    }

    public void setMainPic(Picture mainPic) {
        this.mainPic = mainPic;
    }

    public void setGalleryPics(List<Picture> galleryPics) {
        this.galleryPics = galleryPics;
    }


    public <T> void setAttribute(Attribute<T> attribute, T value) {
        AttributeValue<T> attributeValue
                = getAttributeValue(attribute);

        if (attributeValue != null) {
            attributeValue.setValue(value);
        } else {
            AttributeValue<T> newAttributeValue = new AttributeValue<>();
            newAttributeValue.setValue(value);
            newAttributeValue.setAttribute(attribute);
            customAttributes.add(newAttributeValue);
        }
    }

    public <T> T getAttribute(Attribute<T> attribute) {
        for (AttributeValue attributeValue : customAttributes) {
            if (attribute.equals(attributeValue.getAttribute()))
                return (T) attributeValue.getValue();
        }
        return null;
    }

    private <T> AttributeValue<T> getAttributeValue(Attribute<T> attribute) {
        for (AttributeValue attributeValue : customAttributes) {
            if (attribute.equals(attributeValue.getAttribute()))
                return attributeValue;
        }
        return null;

    }
}
