package service;

import api.RabbitReceiveService;
import org.springframework.stereotype.Service;

@Service
public class RabbitReceiveServiceImpl implements RabbitReceiveService {

    @Override
    public void receiveMessage(String message, String queueName) {
        System.out.println("Получено сообщение " + message + " из очереди " + queueName);
    }
}
