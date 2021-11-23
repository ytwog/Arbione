import org.junit.Test;

public class BotServiceTest {
    @Test
    public void sendMessageTest() {
        BotService botService = new BotService();
        botService.sendMessage("Test test");
    }
}