# Discord RPC, in Java.
This library uses JNA.

### How is this library unique from others?   
Unlike other libraries, this library follows the original library's syntax.   
This would mean that developers by whom used the Discord RPC library from C++, would find it much more easier to use it in Java.   
Other libraries, such as Vatuu's Discord RPC, have other classes such as 'builders' and more, which are not in the original library.  
This library is also very lightweight.  
This library supports Windows, MacOS and Linux.     
This library by default checks for null objects and empty strings, in an attempt to avoid native errors. If you want to disable it, just add: Discord.TRY_TO_AVOID_NATIVE_ERRORS = false; to your code.

### Example code for using the Discord RPC:

```
DiscordEventHandlers DiscordEventHandlers = new DiscordEventHandlers();
DiscordEventHandlers.ReadyCallback = DiscordUser -> System.out.println(DiscordUser.Username + "#" + DiscordUser.Discriminator);
Discord.Initialize("ApplicationId", DiscordEventHandlers, 1, "");
DiscordRichPresence DiscordRichPresence = new DiscordRichPresence();
DiscordRichPresence.State = "Apple Client";
DiscordRichPresence.Details = "Idle";
DiscordRichPresence.LargeImageKey = "image";
DiscordRichPresence.LargeImageText = "Apple Client";
Discord.UpdatePresence(DiscordRichPresence);
Runtime.getRuntime().addShutdownHook(new Thread(Discord::Shutdown));

while (true)
{
    Discord.RunCallbacks();
}
```
*(You have to change the ApplicationId to your application ID, and probably put the while loop in a thread)*
