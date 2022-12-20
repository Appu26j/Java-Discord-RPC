package apple26j;

import com.sun.jna.*;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

public class Discord
{
    public static boolean TRY_TO_AVOID_NATIVE_ERRORS = true;
    private static final String dllPath;

    static
    {
        dllPath = loadDLL();
    }

    public static void Initialize(String ApplicationId, DiscordEventHandlers DiscordEventHandlers, int AutoRegister, String OptionalSteamId)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(ApplicationId, DiscordEventHandlers))
            {
                throw new NullPointerException();
            }

            if (isStringEmpty(ApplicationId))
            {
                throw new IllegalArgumentException();
            }
        }

        DLL.INSTANCE.Discord_Initialize(ApplicationId, DiscordEventHandlers, AutoRegister, OptionalSteamId);
    }

    public static void Register(String ApplicationId, String Command)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(ApplicationId, Command))
            {
                throw new NullPointerException();
            }

            if (isStringEmpty(ApplicationId, Command))
            {
                throw new IllegalArgumentException();
            }
        }

        DLL.INSTANCE.Discord_Register(ApplicationId, Command);
    }

    public static void RegisterSteamGame(String ApplicationId, String SteamId)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(ApplicationId, SteamId))
            {
                throw new NullPointerException();
            }

            if (isStringEmpty(ApplicationId, SteamId))
            {
                throw new IllegalArgumentException();
            }
        }

        DLL.INSTANCE.Discord_RegisterSteamGame(ApplicationId, SteamId);
    }

    public static void UpdateHandlers(DiscordEventHandlers DiscordEventHandlers)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(DiscordEventHandlers))
            {
                throw new NullPointerException();
            }
        }

        DLL.INSTANCE.Discord_UpdateHandlers(DiscordEventHandlers);
    }

    public static void Shutdown()
    {
        DLL.INSTANCE.Discord_Shutdown();
    }

    public static void RunCallbacks()
    {
        DLL.INSTANCE.Discord_RunCallbacks();
    }

    public static void UpdatePresence(DiscordRichPresence DiscordRichPresence)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(DiscordRichPresence))
            {
                throw new NullPointerException();
            }
        }

        DLL.INSTANCE.Discord_UpdatePresence(DiscordRichPresence);
    }

    public static void ClearPresence()
    {
        DLL.INSTANCE.Discord_ClearPresence();
    }

    public static void Respond(String UserId, int Reply)
    {
        if (TRY_TO_AVOID_NATIVE_ERRORS)
        {
            if (isNull(UserId))
            {
                throw new NullPointerException();
            }

            if (isStringEmpty(UserId))
            {
                throw new IllegalArgumentException();
            }
        }

        DLL.INSTANCE.Discord_Respond(UserId, Reply);
    }

    private static boolean isNull(Object... objects)
    {
        boolean foundNullObject = false;

        for (Object object : objects)
        {
            if (object == null)
            {
                foundNullObject = true;
                break;
            }
        }

        return foundNullObject;
    }

    private static boolean isStringEmpty(String... strings)
    {
        boolean foundEmptyString = false;

        for (String string : strings)
        {
            if (string.isEmpty())
            {
                foundEmptyString = true;
                break;
            }
        }

        return foundEmptyString;
    }

    private static String loadDLL()
    {
        return Platform.isWindows() ? Platform.is64Bit() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc-x64.dll").exists() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc-x64.dll").getAbsolutePath() : getFilePath(Objects.requireNonNull(DLL.class.getResourceAsStream("natives/windows/discord-rpc-x64.dll")), "discord-rpc-x64.dll") : new File(System.getProperty("java.io.tmpdir"), "discord-rpc-x86.dll").exists() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc-x86.dll").getAbsolutePath() : getFilePath(Objects.requireNonNull(DLL.class.getResourceAsStream("natives/windows/discord-rpc-x86.dll")), "discord-rpc-x86.dll") : Platform.isMac() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc.dylib").exists() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc.dylib").getAbsolutePath() : getFilePath(Objects.requireNonNull(DLL.class.getResourceAsStream("natives/mac/discord-rpc.dylib")), "discord-rpc.dylib") : new File(System.getProperty("java.io.tmpdir"), "discord-rpc.so").exists() ? new File(System.getProperty("java.io.tmpdir"), "discord-rpc.so").getAbsolutePath() : getFilePath(Objects.requireNonNull(DLL.class.getResourceAsStream("natives/linux/discord-rpc.so")), "discord-rpc.so");
    }

    private static String getFilePath(InputStream inputStream, String fileName)
    {
        File file = new File(System.getProperty("java.io.tmpdir"), fileName);
        try { file.createNewFile(); } catch (Exception ignored) { }

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));)
        {
            byte [] bytes = new byte[4096];
            int read;

            while ((read = inputStream.read(bytes)) != -1)
            {
                bufferedOutputStream.write(bytes, 0, read);
            }

            return file.getAbsolutePath();
        }

        catch (Exception ignored)
        {
            return null;
        }
    }

    public static String getDLLPath ()
    {
        return dllPath;
    }
}

interface DLL extends Library
{
    DLL INSTANCE = Native.load(Discord.getDLLPath(), DLL.class);
    void Discord_Initialize(String ApplicationId, DiscordEventHandlers DiscordEventHandlers, int AutoRegister, String OptionalSteamId);
    void Discord_Register(String ApplicationId, String Command);
    void Discord_RegisterSteamGame(String ApplicationId, String SteamId);
    void Discord_UpdateHandlers(DiscordEventHandlers DiscordEventHandlers);
    void Discord_Shutdown();
    void Discord_RunCallbacks();
    void Discord_UpdatePresence(DiscordRichPresence DiscordRichPresence);
    void Discord_ClearPresence();
    void Discord_Respond(String UserId, int Reply);
}
