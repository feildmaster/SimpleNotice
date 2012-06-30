import net.minecraft.client.Minecraft;

public class mod_SimpleNotice extends BaseMod {
    @Override
    public void load() {
        // Register channel
        ModLoader.registerPacketChannel(this, "SimpleNotice");
        // Listen to ticks
        ModLoader.setInGameHook(this, true, false);
    }

    @Override
    public boolean onTickInGame(float tick, Minecraft game) {
        NoticeGui.getInstance(game).tick();
        return true;
    }

    @Override
    public void receiveCustomPacket(ee Packet250) {
        NoticeGui.get().addNotice(new String(Packet250.c, java.nio.charset.Charset.forName("UTF-8")));
    }

    @Override
    public void serverDisconnect() {
        NoticeGui.get().close();
    }

    @Override
    public String getVersion() {
        return "1.3 (core: 1.1)";
    }
}
