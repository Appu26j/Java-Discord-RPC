package apple26j.callbacks;

import com.sun.jna.Callback;

public interface ErroredCallback extends Callback
{
    void apply(int ErrorCode, String Message);
}
