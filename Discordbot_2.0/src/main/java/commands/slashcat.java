package commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

public class slashcat extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();

        if (command.equals("cat")) {
            OptionMapping option = event.getOption("test1");
            String type = option.getAsString();

            String msg1 = option.getAsString();
            switch (type.toLowerCase()){
                case "cat1" -> {
                    msg1 = "https://http.cat/100.jpg";
                }
                case "cat2" -> {
                    msg1 = "https://http.cat/101.jpg";
                }
                case "cat3" -> {
                    msg1 = "https://http.cat/102.jpg";
                }
            }
            event.reply(type).queue();

        }
    }
    public void onGuildReady(GuildReadyEvent event) {
        JDA jda = event.getJDA();
        OptionData opt1 = new OptionData(OptionType.STRING,"test1", "test2",true)
                .addChoice("cat1","https://http.cat/100.jpg")
                .addChoice("cat2","https://http.cat/101.jpg")
                .addChoice("cat3","https://http.cat/102.jpg");
        jda.upsertCommand("cat", ".....").addOptions(opt1).setGuildOnly(true).queue();
        event.getGuild().updateCommands().addCommands().queue();
    }

}
