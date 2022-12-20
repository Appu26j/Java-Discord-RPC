package apple26j;

import com.sun.jna.Structure;

import java.util.*;

public class DiscordUser extends Structure
{
    public String UserId, Username, Discriminator, Avatar;

    @Override
    public List<String> getFieldOrder ()
    {
        return Arrays.asList("UserId", "Username", "Discriminator", "Avatar");
    }
}
