package commands;
import java.util.Scanner;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class test extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Scanner scan = new Scanner(System.in);
        String msg = event.getMessage().getContentRaw();

        if(msg.equalsIgnoreCase("STATUS")){

            event.getChannel().sendMessage("NAME: ").queue();
            String name = scan.nextLine();
            event.getChannel().sendMessageFormat("NAME: %s", name).queue();

        }

    }
}
