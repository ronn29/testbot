package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.emoji.EmojiAddedEvent;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.restaction.pagination.ReactionPaginationAction;
import net.dv8tion.jda.api.utils.TimeFormat;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static me.discordbot.prefix;

public class whoIsYourMaster extends ListenerAdapter {

    public whoIsYourMaster() {
        super();
    }

    @Override
    public String toString() {
        return "whoIsYourMaster{}";
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String name = event.getMember().getUser().getAsMention();
        String mention = event.getMember().getUser().getAvatarUrl();


        if (message.contains(prefix +"date")){
            //event.getChannel().sendTyping().queue();
            event.getMessage().addReaction(Emoji.fromUnicode("📆")).queue();
            event.getChannel().sendMessage("Current Date: " + TimeFormat.DATE_LONG.now()).queue();


        }
        else if  (message.contains(prefix +"time")) {
            
            event.getMessage().addReaction(Emoji.fromUnicode("⌛")).queue();
            event.getChannel().sendMessage("Current Time: " + TimeFormat.TIME_SHORT.now()).queue();
        }

        else if (message.equalsIgnoreCase(prefix + "avatar")) {
            String avatar = event.getMember().getUser().getAvatar().getUrl(256);
            event.getChannel().sendMessage(avatar).queue();
        }
        else if (message.equals(prefix + "say")) {
            String msg = event.getMessage().getContentDisplay();


            event.getChannel().sendMessage("message:"+ msg).queue();

        }
        else if (message.contains("joke")) {
            event.getMessage().delete().queue();
        }


        else if (message.equalsIgnoreCase("hee")) {

            event.getGuildChannel().sendMessage("hoo").queue();

        }
        else if (message.equals("test")) {
            event.getMessage().addReaction(Emoji.fromUnicode("👋")).queue();

     
        }
        else if (message.equalsIgnoreCase(prefix + "hi")){

            event.getChannel().sendMessage("hello :wave: " + name).queue();
        }
        else if (message.equalsIgnoreCase("hey")) {
            event.getChannel().sendMessage("sup bro").queue();
        }
        else if (message.equalsIgnoreCase("test")) {
            event.getMessage().addReaction(Emoji.fromUnicode("✔")).queue();

        }
        else if (message.equalsIgnoreCase("hi")) {
            event.getMessage().addReaction(Emoji.fromUnicode("👋")).queue();
        }
        else if (message.equalsIgnoreCase(prefix + "ping")) {
            long ping = event.getJDA().getGatewayPing();

            long newping = ping / 5;

            event.getChannel().sendMessage("Pong! " + newping + "ms").queue();




        }
        else if (message.equalsIgnoreCase("random")) {
            event.getChannel().sendMessage("random message").queue();
        }
        else if (message.equalsIgnoreCase("goodnight")) {
            String user = event.getAuthor().getAsMention();

            event.getChannel().sendMessage("goodnight " + user).queue();
        }
        else if(message.equalsIgnoreCase("embed")){

            event.getChannel().sendMessageEmbeds(exampleEmbed().build()).queue();
            String name1 = event.getAuthor().getAvatarUrl();
        }




    }

    public static EmbedBuilder exampleEmbed() {



        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor("");
        builder.setTitle("I am an Embed");
        builder.setDescription("test1");
        builder.setColor(Color.GREEN);

        return builder;

    }

}
