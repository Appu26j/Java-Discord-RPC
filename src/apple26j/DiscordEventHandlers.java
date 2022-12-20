package apple26j;

import apple26j.callbacks.*;
import com.sun.jna.Structure;

import java.util.*;

public class DiscordEventHandlers extends Structure
{
    public ReadyCallback ReadyCallback;
    public DisconnectedCallback DisconnectedCallback;
    public JoinRequestCallback JoinRequestCallback;
    public JoinGameCallback JoinGameCallback;
    public ErroredCallback ErroredCallback;
    public SpectateGameCallback SpectateGameCallback;

    @Override
    public List<String> getFieldOrder()
    {
        return Arrays.asList("ReadyCallback", "DisconnectedCallback", "JoinRequestCallback", "JoinGameCallback", "ErroredCallback", "SpectateGameCallback");
    }
}
