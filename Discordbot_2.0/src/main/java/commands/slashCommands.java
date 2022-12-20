package commands;

import net.dv8tion.jda.api.JDA;


import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;


public class slashCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("who")) {
            String user = event.getUser().getAsTag();
            event.reply("You are " + user).queue();


        } else if (command.equals("avatar")) {
            String user1 = event.getMember().getUser().getAvatar().getUrl(256);
            event.getChannel().sendTyping().queue();

            event.reply(user1).setEphemeral(true).queue();
        } else if (command.equals("gm")) {
            //String user2 = event.getUser().getAsMention();
            event.reply(
                    "https://tenor.com/view/good-morning-gif-25152264").queue();

        } else if (command.equals("prefix")) {

            event.reply("my prefix: `?`").queue();

        } else if (command.equals(("commands"))) {
            String date = "date";
            String time = "time";
            event.reply("Bot commands : " + date + " , " + time).queue();

        } else if (command.equals("message")) {
            OptionMapping messageOption = event.getOption("message");
            String msg = messageOption.getAsString();

            MessageChannel channel;
            OptionMapping channelOption = event.getOption("channel");
            if (channelOption != null) {
                channel = channelOption.getAsChannel().asGuildMessageChannel();
            }else {
                channel = event.getChannel();
            }

            channel.sendMessage(msg).queue();
            event.reply("message sent! :white_check_mark:").setEphemeral(true).queue();

        }
        else if (command.equals("pick")) {
            OptionMapping option = event.getOption("type");
            String type = option.getAsString();

            String msg1 = option.getAsString();
            switch (type.toLowerCase()){
                case "apple" -> {
                    msg1 = "you picked a red apple!!!";
                }
                case "banana" -> {
                    msg1 = "you pick a ellow banana!!!";
                }
            }
            event.reply(type).queue();


        }

        else if (command.equals("create")) {

            OptionMapping optionMapping1 = event.getOption("channel name");
            String channel = optionMapping1.getChannelType().toString();

            event.getGuild().createTextChannel(channel).queue();
        }

    }
    @Override
    public void onGuildReady(GuildReadyEvent event) {

//basic slashcComs
        JDA jda = event.getJDA();
        jda.upsertCommand("who", ".....").setGuildOnly(true).queue();
        jda.upsertCommand("avatar", "will send your avatar").setGuildOnly(true).queue();
        jda.upsertCommand("gm", "will send a gif").setGuildOnly(true).queue();
        jda.upsertCommand("prefix", "bot prefix").setGuildOnly(true).queue();
        jda.upsertCommand("commands", "bot commands").setGuildOnly(true).queue();

//message [context] [channel]
        OptionData opt1 = new OptionData(OptionType.STRING,"message", "type the message you want to send", true);
        OptionData opt2 = new OptionData(OptionType.CHANNEL ,"channel", "the channel you want to send this message",false)
                .setChannelTypes(ChannelType.TEXT);
        OptionData opt3 = new OptionData(OptionType.STRING, "type", "pick a fruit",true)
                .addChoice("apple", "you picked a red apple!!!")
                .addChoice("banana","you pick a yellow banana!!!");
        OptionData opt4 = new OptionData(OptionType.STRING, "test", "test", true);

        jda.upsertCommand("message", "the bot will send your message").addOptions(opt1, opt2).setGuildOnly(true).queue();

        jda.upsertCommand("pick","pick a fruit").addOptions(opt3).setGuildOnly(true).queue();

        jda.upsertCommand("create", "channel name").addOptions(opt4).setGuildOnly(true).queue();

        event.getGuild().updateCommands().addCommands().queue();






    }


}



