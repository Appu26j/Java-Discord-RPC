package apple26j.callbacks;

import com.sun.jna.Callback;

public interface SpectateGameCallback extends Callback
{
    void apply(String SpectateSecret);
}
