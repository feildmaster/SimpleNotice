import java.nio.charset.Charset;
import net.minecraft.client.Minecraft;

public class SimpleNotice {
    private static final SimpleNotice instance = new SimpleNotice();
    private static adl netHandler;
    private static Minecraft minecraft;

    private SimpleNotice() {}

    public static SimpleNotice get() {
        return instance;
    }

    public SimpleNotice set(adl handler) {
        if (netHandler == null && handler != null) {
            netHandler = handler;
        }
        return this;
    }

    public SimpleNotice set(Minecraft game) {
        if (minecraft == null && game != null) {
            minecraft = game;
            NoticeGui.getInstance(minecraft);
        }
        return this;
    }

    public void sendRegister() {
        if (netHandler == null) return;

        ee register = new ee();
        register.a = "REGISTER";
        register.c = "SimpleNotice".getBytes(Charset.forName("UTF-8"));
        register.b = register.c.length;

        netHandler.c(register);
    }

    public void recievePacket(ee Packet250) {
        if ("SimpleNotice".equals(Packet250.a)) {
            NoticeGui.get().addNotice(new String(Packet250.c, Charset.forName("UTF-8")));
        }
    }
}
