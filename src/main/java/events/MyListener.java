package events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        if (content.equals("electro"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Duerme mrd!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        if (content.equals("ducados"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("ya tienes los creditos ?").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        if (content.equals("gofio"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Joder esto esta roto tio").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }

        if (content.equals("confirma!"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Confirmo "+event.getMember().getNickname()).queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
    }
}
