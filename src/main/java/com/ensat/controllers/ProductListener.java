package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class ProductListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListener.class);

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Autowired
    private ProductService productService;

    @JmsListener(destination = "product.queue")
    public void receiveMessage(final Message jsonMessage) throws JMSException, IOException {
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            String messageData = textMessage.getText();
            try {
                Product product = OBJECT_MAPPER.readValue(messageData, Product.class);
                productService.saveProduct(product);
            } catch (Exception e) {
                LOGGER.error("", e);
            }
        }
    }
}
