package core.service;

import api.RabbitReceiveService;
import core.configuration.RabbitMQConfiguration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitReceiveListener {

    @NonNull
    private final RabbitReceiveService rabbitReceiveService;

    @RabbitListener(queues = RabbitMQConfiguration.DAILY_QUEUE_NAME)
    public void receiveDailyMessage(String message) {
        rabbitReceiveService.receiveMessage(message, RabbitMQConfiguration.DAILY_QUEUE_NAME);
    }


    @RabbitListener(queues = RabbitMQConfiguration.ALERT_QUEUE_NAME)
    public void receiveAlertMessage(String message) {
        rabbitReceiveService.receiveMessage(message, RabbitMQConfiguration.ALERT_QUEUE_NAME);
    }

    @RabbitListener(queues = RabbitMQConfiguration.ERROR_QUEUE_NAME)
    public void receiveErrorMessage(String message) {
        rabbitReceiveService.receiveMessage(message, RabbitMQConfiguration.ERROR_QUEUE_NAME);
    }
}
