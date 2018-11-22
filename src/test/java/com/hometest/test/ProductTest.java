package com.hometest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hometest.model.*;
import org.junit.jupiter.api.Test;
import sun.security.krb5.Config;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductTest {

    @Test
    public void testCustomAttribute() throws IOException {
        Product product1 = new Product();
        product1.setName("Iphone X 64Gb Black");
        product1.setMarketPrice(new BigDecimal("1099"));
        product1.setSalePrice(new BigDecimal("999"));
        Attribute<String> description = new Attribute<>(1L, "description");
        Attribute<String> origin = new Attribute<>(2L, "origin");
        Attribute<Date> factoryDate = new Attribute<>(3L, "factoryDate");
        Attribute<Float> weight = new Attribute<>(4L, "weight");

        Attribute<String> color = new Attribute<>(5L, "color");
        Attribute<String> storage = new Attribute<>(6L, "storage");
        product1.setAttribute(description
                , "Sample description 1");
        product1.setAttribute(origin
                , "China");
        product1.setAttribute(factoryDate
                , new Date(123456123L));
        product1.setAttribute(weight
                , 1.1f);
        product1.setAttribute(color, "BLACK");
        product1.setAttribute(storage, "64GB");
        Picture pic1_1 = new Picture(true, "1-black.png");
        Picture pic2_1 = new Picture(false, "2-black.png");
        Picture pic3_1 = new Picture(false, "3-black.jpg");
        product1.setGalleryPics(Arrays.asList(pic1_1, pic2_1, pic3_1));


        Product product2 = new Product();
        product2.setName("Iphone X 64Gb Black");
        product2.setMarketPrice(new BigDecimal("1099"));
        product2.setSalePrice(new BigDecimal("999"));
        product2.setAttribute(description
                , "Sample description 2");
        product2.setAttribute(origin
                , "US");
        product2.setAttribute(factoryDate
                , new Date(123456321L));
        product2.setAttribute(weight
                , 2.2f);
        product2.setAttribute(color, "YELLOW");
        product2.setAttribute(storage, "128GB");
        Picture pic1_2 = new Picture(true, "1-gold.jpg");
        Picture pic2_2 = new Picture(false, "2-gold.jpeg");
        Picture pic3_2 = new Picture(false, "3-gold.jpg");
        product2.setGalleryPics(Arrays.asList(pic1_2, pic2_2, pic3_2));

        // Verify the attributes of product
        assertEquals(product1.getAttribute(description), "Sample description 1");
        assertEquals(product1.getAttribute(origin), "China");
        assertEquals(product1.getAttribute(factoryDate), new Date(123456123L));
        assertEquals(product1.getAttribute(weight).floatValue(), 1.1f);
        assertEquals(product2.getAttribute(description), "Sample description 2");
        assertEquals(product2.getAttribute(origin), "US");
        assertEquals(product2.getAttribute(factoryDate), new Date(123456321L));
        assertEquals(product2.getAttribute(weight).floatValue(), 2.2f);
    }

    @Test
    public void testConfiguredProduct() throws IOException {
        ConfigurableProduct configurableProduct = new ConfigurableProduct();
        Attribute<String> color = new Attribute<>(5L, "color");
        Attribute<String> storage = new Attribute<>(6L, "storage");
        AttributeSet attributeSet = new AttributeSet();
        Set<Attribute> attrSet = new HashSet<>();;
        attrSet.add(color);
        attrSet.add(storage);
        attributeSet.setAttributeSet(attrSet);
        configurableProduct.setAttributeSet(attributeSet);
        Product product1 = new Product();
        product1.setName("Iphone X 64Gb Black");
        product1.setMarketPrice(new BigDecimal("1099"));
        product1.setSalePrice(new BigDecimal("999"));
        product1.setAttribute(color, "BLACK");
        product1.setAttribute(storage, "64GB");


        Product product2 = new Product();
        product2.setName("Iphone X 64Gb Black");
        product2.setMarketPrice(new BigDecimal("1099"));
        product2.setSalePrice(new BigDecimal("999"));
        product2.setAttribute(color, "YELLOW");
        product2.setAttribute(storage, "128GB");

        // Can set other attributes here
        configurableProduct.addProduct(product1);
        configurableProduct.addProduct(product2);
//        System.out.println(configurableProduct.showOption());
        assertEquals("Iphone X 64Gb Black: color - BLACK storage - 64GB \nIphone X 64Gb Black: color - YELLOW storage - 128GB \n", configurableProduct.showOption());
    }


}
