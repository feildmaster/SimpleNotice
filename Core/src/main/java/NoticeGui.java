import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

/* As much as I'd love to make this class work without ever updating, the lack of an API makes this impossible
 *
 * To demonstrate, the main class I hook into at the moment in the core:
 *  - FontRender (nl): Their functions, their class, the variable in which it's stored in (minecraft.q)... All of those can change.
 *      This can't be helped though, since the obfuscation will undoubtedly change these
 *      This is, however, simple to update, compared to a lot of other things
 */
public final class NoticeGui {
    private final static NoticeGui instance = new NoticeGui();
    private final static Logger logger = Logger.getLogger("NoticeGui");

    private final List<Notice> notices = new ArrayList<Notice>();
    private final double noticeTicks = 400D;
    private Minecraft minecraft;
    private boolean shade = true;
    private int limit = 5;
    private boolean attempted = false; // Flag for grabbing minecraft instance
    private boolean fade = true;
    private int position = 0; // 0 = Top Left, 1 = Top Right, 2 = Bottom Right

    private NoticeGui() {
        try {
            loadProperties();
        } catch(Exception ex) {
            logger.log(Level.FINE, "Error occurred when loading properties: ", ex.getCause());
        }
    }

    /**
     * Add a new notice
     *
     * @param notice The notice to display
     */
    public void addNotice(String notice) {
        if (notice == null || notice.length() == 0) return;

        notices.add(new Notice(notice));
    }

    /**
     * Increase notice ticks
     */
    public void tick() {
        // Don't attempt if we can't find minecraft
        if (getMinecraft() == null) return;

        displayNotices();

        for (int i = 0; i < notices.size(); i++) {
            if (notices.get(i).ticks++ > noticeTicks) {
                notices.remove(i--);
            }
        }
    }

    public void close() {
        notices.clear();
    }

    private void displayNotices() {
        //resolution, gamesettings, width, height
        agd resolution = new agd(minecraft.A, minecraft.d, minecraft.e);
        int position = minecraft.A.F ? 2 : this.position;

        float scaleX = position > 0 ? resolution.a() : 0;
        float scaleY = position > 1 ? resolution.b() - 8 : 0;

        GL11.glPushMatrix();
        GL11.glTranslatef(scaleX, scaleY, 0F);
        GL11.glScalef(0.75F, 0.8F, 0.8F);
        GL11.glEnable(GL11.GL_BLEND);

        for (int i = 0; i < notices.size() && i < limit; i++) {
            Notice notice = notices.get(notices.size() - 1 - i);

            // X Position
            int x;
            if (position > 0) {
                x = -minecraft.q.a(notice.message) - 3;
            } else {
                x = 3;
            }
            // Y Position
            int y;
            if (position > 1) {
                y = -i * 9 - 3;
            } else {
                y = i * 9 + 3;
            }

            // The transparency of the text, 256 = no transparency
            int alpha = 256;

            if (fade) {
                double fade = (double) notice.ticks / noticeTicks;
                fade = 1.0D - fade;
                fade *= 10D;

                if (fade < 0.0D) {
                    fade = 0.0D;
                } else if (fade > 1.0D) {
                    fade = 1.0D;
                }

                fade *= fade;

                alpha = (int) (255D * fade);

                if (alpha <= (noticeTicks / 100)) {
                    continue;
                }
            }

            if (shade) {
                minecraft.q.a(notice.message, x, y, 0xFFFFFF + (alpha << 24));
            } else {
                minecraft.q.b(notice.message, x, y, 0xFFFFFF + (alpha << 24));
            }
        }
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public Minecraft getMinecraft() {
        if (minecraft == null && !attempted) {
            for (Field field : Minecraft.class.getDeclaredFields()) {
                if (Minecraft.class.isAssignableFrom(field.getType())) {
                    try {
                        field.setAccessible(true);
                        minecraft = (Minecraft) field.get(null);
                    } catch (Exception ex) {
                        attempted = true; // Don't try again
                    }
                }
            }
        }
        return minecraft;
    }

    public static NoticeGui get() {
        return instance;
    }

    public static NoticeGui getInstance(Minecraft minecraft) {
        if (minecraft != null && instance.minecraft == null) {
            instance.minecraft = minecraft;
        }
        return instance;
    }

    private void loadProperties() throws IOException {
        Properties properties = new Properties();
        File config = new File(Minecraft.b(), "/config/SimpleNotice.properties");
        // Create parent directories
        if (config.getParentFile() != null) {
            config.getParentFile().mkdirs();
        }
        // Load file
        if (config.canRead()) {
            properties.load(new FileInputStream(config));
        }

        int modified = 0;

        StringBuilder comments = new StringBuilder();
        addLine(comments,
                "###########################",
                "SimpleNotice Configuration",
                "###########################");


        addLine(comments, "",
                "shade - Should text have shading?",
                "    Default: true",
                "    ----",
                "    true: Text will be shaded",
                "    false: Text will not be shaded");
        if (properties.containsKey("shade")) {
            shade = Boolean.valueOf(properties.getProperty("shade"));
        } else {
            properties.setProperty("shade", "true");
            modified++;
        }

        addLine(comments, "",
                "limit - Max amount of lines to display at once",
                "    Default: 5",
                "    Minimum: 4");
        if (properties.containsKey("limit")) {
            int value = Integer.valueOf(properties.getProperty("limit"));
            if (value >= 4) {
                limit = value;
            } else {
                properties.setProperty("limit", "5");
                modified++;
            }
        } else {
            properties.setProperty("limit", "5");
            modified++;
        }

        addLine(comments, "",
                "fade - Should text fade?",
                "    Default: true",
                "    ----",
                "    true: Text will fade",
                "    false: Text will not fade");
        if (properties.containsKey("fade")) {
            fade = Boolean.valueOf(properties.getProperty("fade"));
        } else {
            properties.setProperty("fade", "true");
            modified++;
        }

        addLine(comments, "",
                "position - The position of the notices",
                "    Default: 0",
                "    ----",
                "    0: Top left",
                "    1: Top right",
                "    2: Bottom right",
                "      - Automatically set when in debug mode");
        if (properties.containsKey("position")) {
            position = Integer.valueOf(properties.getProperty("position"));
        } else {
            properties.setProperty("position", "0");
            modified++;
        }

        if (modified > 0) {
            properties.store(new FileOutputStream(config), comments.toString());
        }
    }

    private void addLine(StringBuilder comments, String... lines) {
        for (String line : lines) {
            comments.append(line == null ? "" : line).append("\n");
        }
    }
}
