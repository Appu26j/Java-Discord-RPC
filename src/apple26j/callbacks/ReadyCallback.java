package apple26j.callbacks;

import apple26j.DiscordUser;
import com.sun.jna.Callback;

public interface ReadyCallback extends Callback
{
    void apply(DiscordUser DiscordUser);
}
