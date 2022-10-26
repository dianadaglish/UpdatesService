package com.example.preassignment.updatesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.google.common.base.Preconditions;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "app_updates", groupId = "group_id", containerFactory = "employeeKafkaListenerContainerFactory")

    // Method
    public void
    consume(EmployeeDTO employee)
    {
        // Print statement
        System.out.println("message = " + employee);

        messageService.processMessage(employee);
    }

    @Autowired
    private MessageService messageService;
}
