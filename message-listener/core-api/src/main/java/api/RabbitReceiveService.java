package api;

public interface RabbitReceiveService {

    void receiveMessage(String message, String queueName);
}
