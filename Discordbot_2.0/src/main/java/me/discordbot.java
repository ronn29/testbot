package me;


import commands.slashCommands;
import commands.slashcat;
import commands.test;
import commands.whoIsYourMaster;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;



import javax.security.auth.login.LoginException;

public class discordbot {
    public static String prefix = "?";



    public static void main(String[] args) throws LoginException {






//main method
        JDA jda = JDABuilder.createDefault(process.env.Token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_PRESENCES)
                .setMemberCachePolicy(MemberCachePolicy.ONLINE)
                .setChunkingFilter(ChunkingFilter.ALL)
                .enableCache(CacheFlag.ONLINE_STATUS)
                .setStatus(OnlineStatus.IDLE)
                .setActivity(Activity.watching("my self"))




                .build();


        jda.addEventListener(new slashCommands());
        jda.addEventListener(new slashcat());
        jda.addEventListener(new test());






        jda.addEventListener(new whoIsYourMaster());





    }


}
