import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BotService {
    private TelegramBot bot;
    private String BOT_TOKEN;

    public BotService() {
        // Create your bot passing the token received from @BotFather
        bot = new TelegramBot(BOT_TOKEN);

        // Register for updates
        bot.setUpdatesListener(updates -> {
            // ... process updates
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }



    public void sendMessage(String str) {
        GetUpdates getUpdates = new GetUpdates().limit(100).offset(0).timeout(0);

        GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
        List<Update> updates = updatesResponse.updates();

        if(updates != null) {
            for (Update update : updates) {
                // Send messages
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, str));
            }
        }
    }
}
