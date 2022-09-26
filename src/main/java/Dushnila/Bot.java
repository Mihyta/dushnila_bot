package Dushnila;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    List<String> players = new ArrayList<>();
    List<String> words1 = new ArrayList<>();
    private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));
    @Override
    public void run() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
    private void process(Update update) {
        words1.add("Погнали!");
        words1.add("Мухлюем");
        words1.add("Вы готовы?!");
        words1.add("Ждемс");
        words1.add("Стартуем!");
        words1.add("Кто же, кто же?");
        words1.add("Выбираем");
        Message message = update.message();
        try {
        if (message != null) {
            long chatId = message.chat().id();
                if (message.text().equals("/registrationDBot")) {
                    players.add(message.from(). username());
                } else if (message.text().equals("/startDBot")) {
                    for (; ; ) {
 //                       String firstWord = words1.get((int) (Math.random() * words1.size()));
  //                      String firstName = players.get((int) (Math.random() * players.size()));
                        String firstWord = words1.get(0);
                        String firstName = players.get(0);
                        bot.execute(new SendMessage(chatId, firstWord));
                        Thread.sleep(2000);
                        bot.execute(new SendMessage(chatId, "..."));
                        Thread.sleep(2000);
                        bot.execute(new SendMessage(chatId, "Душнила дня " + "@" + firstName));
                        Thread.sleep(1000 * 30);
                    }
                }
            }
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
