package com.amandazaine.carpostdatastorage.message;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;
import com.amandazaine.carpostdatastorage.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "car-post-group")
    public void listening(CarPostDTO carPostDTO) {
        LOG.info("Informação de novo CarPost recebida: ", carPostDTO);
        carPostService.createCarPost(carPostDTO);
    }
}
