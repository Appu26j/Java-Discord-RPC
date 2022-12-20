package apple26j.callbacks;

import com.sun.jna.Callback;

public interface DisconnectedCallback extends Callback
{
    void apply(int ErrorCode, String Message);
}
