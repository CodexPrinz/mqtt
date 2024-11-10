package com.projects.mqtt.controller;

import com.projects.mqtt.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    private final MqttService mqttService;

    public MqttController(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String topic, @RequestParam String message) throws MqttException {
        mqttService.publish(topic, message);
        return "Message published";
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String topic) throws MqttException {
        mqttService.subscribe(topic);
        return "Subscribed to topic: " + topic;
    }

}
