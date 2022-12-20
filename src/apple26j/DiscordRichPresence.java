package apple26j;

import com.sun.jna.Structure;

import java.util.*;

public class DiscordRichPresence extends Structure
{
    public String State, Details, LargeImageKey, LargeImageText, SmallImageKey, SmallImageText, PartyId, SpectateSecret, JoinSecret;
    public long StartTimestamp, EndTimestamp;
    public int PartySize, PartyMax;

    @Override
    public List<String> getFieldOrder ()
    {
        return Arrays.asList("State", "Details", "StartTimestamp", "EndTimestamp", "LargeImageKey", "LargeImageText", "SmallImageKey", "SmallImageText", "PartyId", "PartySize", "PartyMax", "JoinSecret", "SpectateSecret");
    }
}
