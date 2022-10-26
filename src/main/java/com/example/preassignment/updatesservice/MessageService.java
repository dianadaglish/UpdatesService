package com.example.preassignment.updatesservice;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    @Autowired
    private KafkaTemplate<String, EmployeeDTO> kafkaTemplate;

    @Value(value = "${employee.topic}")
    private String topicName;

    @Value(value = "${deadletter}")
    private String deadletter;

    public void processMessage(EmployeeDTO employee) {
        try{
            Preconditions.checkNotNull(employee.getId());
            Preconditions.checkNotNull(employee.getName());
            Preconditions.checkNotNull(employee.getPhone());
            Preconditions.checkNotNull(employee.getCity());
            Preconditions.checkNotNull(employee.getJavaExperience());
            Preconditions.checkNotNull(employee.getSpringExperience());
            sendMessage(employee);
        }catch (Exception e){
            sendMessageToDLQ(employee);
        }

    }
    private void sendMessage(EmployeeDTO employee) {
        System.out.println("Sending employee to employees_update topic");
        kafkaTemplate.send(topicName, employee);
    }

    private void sendMessageToDLQ(EmployeeDTO employee) {
        System.out.println("Sending employee to deadletter topic");
        kafkaTemplate.send(deadletter, employee);
    }
}
