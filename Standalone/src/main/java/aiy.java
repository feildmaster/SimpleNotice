import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class aiy extends oo {
    private static tw d = new tw();
    private List e = new ArrayList();
    private List f = new ArrayList();
    private Random h = new Random();
    private Minecraft i;
    private int j = 0;
    private String k = "";
    private int l = 0;
    private boolean m = false;
    private int n = 0;
    private boolean o = false;
    public float b;
    float c = 1.0F;

    public aiy(Minecraft paramMinecraft) {
        this.i = paramMinecraft;
    }

    public void a(float paramFloat, boolean paramBoolean, int paramInt1, int paramInt2) {
        agd localagd = new agd(this.i.A, this.i.d, this.i.e);
        int i1 = localagd.a();
        int i2 = localagd.b();

        nl localnl = this.i.q;
        this.i.u.b();

        GL11.glEnable(3042);

        if (Minecraft.s()) {
            a(this.i.h.a(paramFloat), i1, i2);
        } else {
            GL11.glBlendFunc(770, 771);
        }

        aan localaan = this.i.h.ap.f(3);
        if ((this.i.A.E == 0) && (localaan != null) && (localaan.c == pb.ba.bO)) {
            b(i1, i2);
        }
        if (!this.i.h.a(aad.k)) {
            float f1 = this.i.h.aS + (this.i.h.aR - this.i.h.aS) * paramFloat;
            if (f1 > 0.0F) {
                b(f1, i1, i2);
            }
        }
        int i6;
        int i9;
        int i12;
        int i15;
        int i18;
        int i19;
        int i20;
        int i21;
        if (!this.i.c.e()) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBindTexture(3553, this.i.p.b("/gui/gui.png"));

            aak localaak = this.i.h.ap;

            this.g = -90.0F;
            b(i1 / 2 - 91, i2 - 22, 0, 0, 182, 22);
            b(i1 / 2 - 91 - 1 + localaak.c * 20, i2 - 22 - 1, 0, 22, 24, 22);

            GL11.glBindTexture(3553, this.i.p.b("/gui/icons.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            b(i1 / 2 - 7, i2 / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);

            int i4 = this.i.h.Y / 3 % 2 == 1 ? 1 : 0;
            if (this.i.h.Y < 10) {
                i4 = 0;
            }
            i6 = this.i.h.bb();
            int i7 = this.i.h.by;
            this.h.setSeed(this.j * 312871);

            i9 = 0;
            ne localne = this.i.h.aF();
            i12 = localne.a();
            int i13 = localne.b();

            f();
            int i16;
            if (this.i.c.d()) {
                i15 = i1 / 2 - 91;
                i16 = i1 / 2 + 91;

                i18 = this.i.h.aE();
                if (i18 > 0) {
                    i19 = 182;

                    i20 = (int) (this.i.h.aW * (i19 + 1));

                    i21 = i2 - 32 + 3;
                    b(i15, i21, 0, 64, i19, 5);
                    if (i20 > 0) {
                        b(i15, i21, 0, 69, i20, 5);
                    }
                }

                i19 = i2 - 39;
                i20 = i19 - 10;

                i21 = this.i.h.au();
                int i22 = -1;
                if (this.i.h.a(aad.l)) {
                    i22 = this.j % 25;
                }
                int i25;
                int i26;
                int i27;
                int i28;
                for (int i24 = 0; i24 < 10; i24++) {
                    if (i21 > 0) {
                        i25 = i15 + i24 * 8;
                        if (i24 * 2 + 1 < i21) {
                            b(i25, i20, 34, 9, 9, 9);
                        }
                        if (i24 * 2 + 1 == i21) {
                            b(i25, i20, 25, 9, 9, 9);
                        }
                        if (i24 * 2 + 1 > i21) {
                            b(i25, i20, 16, 9, 9, 9);
                        }
                    }

                    i25 = 16;
                    if (this.i.h.a(aad.u)) {
                        i25 += 36;
                    }

                    i26 = 0;
                    if (i4 != 0) {
                        i26 = 1;
                    }
                    i27 = i15 + i24 * 8;
                    i28 = i19;
                    if (i6 <= 4) {
                        i28 += this.h.nextInt(2);
                    }

                    if (i24 == i22) {
                        i28 -= 2;
                    }

                    int i29 = 0;
                    if (this.i.f.B().s()) {
                        i29 = 5;
                    }

                    b(i27, i28, 16 + i26 * 9, 9 * i29, 9, 9);
                    if (i4 != 0) {
                        if (i24 * 2 + 1 < i7) {
                            b(i27, i28, i25 + 54, 9 * i29, 9, 9);
                        }
                        if (i24 * 2 + 1 == i7) {
                            b(i27, i28, i25 + 63, 9 * i29, 9, 9);
                        }
                    }

                    if (i24 * 2 + 1 < i6) {
                        b(i27, i28, i25 + 36, 9 * i29, 9, 9);
                    }
                    if (i24 * 2 + 1 != i6) {
                        continue;
                    }
                    b(i27, i28, i25 + 45, 9 * i29, 9, 9);
                }

                for (int i24 = 0; i24 < 10; i24++) {
                    i25 = i19;

                    i26 = 16;
                    i27 = 0;
                    if (this.i.h.a(aad.s)) {
                        i26 += 36;
                        i27 = 13;
                    }

                    if ((this.i.h.aF().d() <= 0.0F)
                            && (this.j % (i12 * 3 + 1) == 0)) {
                        i25 += this.h.nextInt(3) - 1;
                    }

                    if (i9 != 0) {
                        i27 = 1;
                    }
                    i28 = i16 - i24 * 8 - 9;
                    b(i28, i25, 16 + i27 * 9, 27, 9, 9);
                    if (i9 != 0) {
                        if (i24 * 2 + 1 < i13) {
                            b(i28, i25, i26 + 54, 27, 9, 9);
                        }
                        if (i24 * 2 + 1 == i13) {
                            b(i28, i25, i26 + 63, 27, 9, 9);
                        }
                    }
                    if (i24 * 2 + 1 < i12) {
                        b(i28, i25, i26 + 36, 27, 9, 9);
                    }
                    if (i24 * 2 + 1 != i12) {
                        continue;
                    }
                    b(i28, i25, i26 + 45, 27, 9, 9);
                }

                if (this.i.h.a(acn.g)) {
                    int i24 = this.i.h.Y();

                    i25 = (int) Math.ceil((i24 - 2) * 10.0D / 300.0D);
                    i26 = (int) Math.ceil(i24 * 10.0D / 300.0D) - i25;

                    for (i27 = 0; i27 < i25 + i26; i27++) {
                        if (i27 < i25) {
                            b(i16 - i27 * 8 - 9, i20, 16, 18, 9, 9);
                        } else {
                            b(i16 - i27 * 8 - 9, i20, 25, 18, 9, 9);
                        }
                    }
                }
            }
            GL11.glDisable(3042);

            GL11.glEnable(32826);
            tf.c();

            for (i15 = 0; i15 < 9; i15++) {
                i16 = i1 / 2 - 90 + i15 * 20 + 2;
                i18 = i2 - 16 - 3;
                a(i15, i16, i18, paramFloat);
            }
            tf.a();
            GL11.glDisable(32826);
        }

        if (this.i.h.aB() > 0) {
            GL11.glDisable(2929);
            GL11.glDisable(3008);

            int i3 = this.i.h.aB();
            float f2 = i3 / 100.0F;
            if (f2 > 1.0F) {
                f2 = 1.0F - (i3 - 100) / 10.0F;
            }

            i6 = (int) (220.0F * f2) << 24 | 0x101020;
            a(0, 0, i1, i2, i6);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
        }

        if ((this.i.c.f()) && (this.i.h.aU > 0)) {
            int i5 = 0;
            i6 = i5 != 0 ? 16777215 : 8453920;

            String str1 = "" + this.i.h.aU;
            i9 = (i1 - localnl.a(str1)) / 2;
            int i10 = i2 - 31 - 4;

            localnl.b(str1, i9 + 1, i10, 0);
            localnl.b(str1, i9 - 1, i10, 0);
            localnl.b(str1, i9, i10 + 1, 0);
            localnl.b(str1, i9, i10 - 1, 0);
            localnl.b(str1, i9, i10, i6);
        }

        if (this.i.A.F) {
            GL11.glPushMatrix();
            if (Minecraft.J > 0L) {
                GL11.glTranslatef(0.0F, 32.0F, 0.0F);
            }

            localnl.a("Minecraft 1.2.5 (" + this.i.M + ")", 2, 2, 16777215);
            localnl.a(this.i.m(), 2, 12, 16777215);
            localnl.a(this.i.n(), 2, 22, 16777215);
            localnl.a(this.i.p(), 2, 32, 16777215);
            localnl.a(this.i.o(), 2, 42, 16777215);

            long l1 = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l3 = Runtime.getRuntime().freeMemory();
            long l4 = l2 - l3;

            String str2 = "Used memory: " + l4 * 100L / l1 + "% (" + l4 / 1024L / 1024L + "MB) of " + l1 / 1024L / 1024L + "MB";

            b(localnl, str2, i1 - localnl.a(str2) - 2, 2, 14737632);
            str2 = "Allocated memory: " + l2 * 100L / l1 + "% (" + l2 / 1024L / 1024L + "MB)";
            b(localnl, str2, i1 - localnl.a(str2) - 2, 12, 14737632);

            b(localnl, "x: " + this.i.h.o, 2, 64, 14737632);
            b(localnl, "y: " + this.i.h.p, 2, 72, 14737632);
            b(localnl, "z: " + this.i.h.q, 2, 80, 14737632);

            b(localnl, "f: " + (gk.c(this.i.h.u * 4.0F / 360.0F + 0.5D) & 0x3), 2, 88, 14737632);

            i19 = gk.c(this.i.h.o);
            i20 = gk.c(this.i.h.p);
            i21 = gk.c(this.i.h.q);
            if ((this.i.f != null) && (this.i.f.j(i19, i20, i21))) {
                ack localack = this.i.f.c(i19, i21);
                b(localnl, "lc: " + (localack.h() + 15) + " b: " + localack.a(i19 & 0xF, i21 & 0xF, this.i.f.i()).y + " bl: " + localack.a(wl.b, i19 & 0xF, i20, i21 & 0xF) + " sl: " + localack.a(wl.a, i19 & 0xF, i20, i21 & 0xF) + " rl: " + localack.c(i19 & 0xF, i20, i21 & 0xF, 0), 2, 96, 14737632);
            }

            if (!this.i.f.F) {
                b(localnl, "Seed: " + this.i.f.v(), 2, 112, 14737632);
            }

            GL11.glPopMatrix();
        }
        int i8;
        if (this.l > 0) {
            float f3 = this.l - paramFloat;
            i6 = (int) (f3 * 256.0F / 20.0F);
            if (i6 > 255) {
                i6 = 255;
            }
            if (i6 > 0) {
                GL11.glPushMatrix();
                GL11.glTranslatef(i1 / 2, i2 - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);

                i8 = 16777215;
                if (this.m) {
                    i8 = Color.HSBtoRGB(f3 / 50.0F, 0.7F, 0.6F) & 0xFFFFFF;
                }
                localnl.b(this.k, -localnl.a(this.k) / 2, -4, i8 + (i6 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }

        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, i2 - 48, 0.0F);

        a(localnl);

        GL11.glPopMatrix();

        NoticeGui.get().tick(); // SimpleNotice

        if (((this.i.h instanceof ahv)) && (this.i.A.y.e)) {
            adl localadl = ((ahv) this.i.h).cl;
            List localList = localadl.c;
            i8 = localadl.d;

            i9 = i8;
            int i11 = 1;
            while (i9 > 20) {
                i11++;
                i9 = (i8 + i11 - 1) / i11;
            }

            i12 = 300 / i11;
            if (i12 > 150) {
                i12 = 150;
            }

            int i14 = (i1 - i11 * i12) / 2;
            i15 = 10;
            a(i14 - 1, i15 - 1, i14 + i12 * i11, i15 + 9 * i9, -2147483648);

            for (int i17 = 0; i17 < i8; i17++) {
                i18 = i14 + i17 % i11 * i12;
                i19 = i15 + i17 / i11 * 9;

                a(i18, i19, i18 + i12 - 1, i19 + 8, 553648127);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);

                if (i17 < localList.size()) {
                    ah localah = (ah) localList.get(i17);
                    localnl.a(localah.a, i18, i19, 16777215);
                    this.i.p.b(this.i.p.b("/gui/icons.png"));
                    i21 = 0;
                    int i23 = 0;

                    if (localah.b < 0) {
                        i23 = 5;
                    } else if (localah.b < 150) {
                        i23 = 0;
                    } else if (localah.b < 300) {
                        i23 = 1;
                    } else if (localah.b < 600) {
                        i23 = 2;
                    } else if (localah.b < 1000) {
                        i23 = 3;
                    } else {
                        i23 = 4;
                    }
                    this.g += 100.0F;
                    b(i18 + i12 - 12, i19, 0 + i21 * 10, 176 + i23 * 8, 10, 8);
                    this.g -= 100.0F;
                }
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void a(nl paramnl) {
        int i1 = 10;
        int i2 = 0;
        int i3 = 0;
        int i4 = this.e.size();

        if (i4 <= 0) {
            return;
        }

        if (e()) {
            i1 = 20;
            i2 = 1;
        }
        int i9;
        int i10;
        int i5;
        for (i5 = 0; (i5 + this.n < this.e.size()) && (i5 < i1); i5++) {
            if ((((nt) this.e.get(i5)).b < 200) || (i2 != 0)) {
                nt localnt = (nt) this.e.get(i5 + this.n);
                double d1 = localnt.b / 200.0D;
                d1 = 1.0D - d1;
                d1 *= 10.0D;
                if (d1 < 0.0D) {
                    d1 = 0.0D;
                }
                if (d1 > 1.0D) {
                    d1 = 1.0D;
                }
                d1 *= d1;
                i9 = (int) (255.0D * d1);
                if (i2 != 0) {
                    i9 = 255;
                }

                i3++;

                if (i9 > 2) {
                    i10 = 3;
                    int i11 = -i5 * 9;
                    String str = localnt.a;
                    a(i10, i11 - 1, i10 + 320 + 4, i11 + 8, i9 / 2 << 24);
                    GL11.glEnable(3042);

                    paramnl.a(str, i10, i11, 16777215 + (i9 << 24));
                }
            }
        }

        if (i2 != 0) {
            GL11.glTranslatef(0.0F, paramnl.b, 0.0F);

            i5 = i4 * paramnl.b + i4;
            int i6 = i3 * paramnl.b + i3;
            int i7 = this.n * i6 / i4;
            int i8 = i6 * i6 / i5;

            if (i5 != i6) {
                i9 = i7 > 0 ? 170 : 96;
                i10 = this.o ? 13382451 : 3355562;

                a(0, -i7, 2, -i7 - i8, i10 + (i9 << 24));
                a(2, -i7, 1, -i7 - i8, 13421772 + (i9 << 24));
            }
        }
    }

    private void f() {
        if (or.c == null) {
            return;
        }

        oq localoq = or.c;
        or.c = null;

        nl localnl = this.i.q;

        agd localagd = new agd(this.i.A, this.i.d, this.i.e);
        int i1 = localagd.a();

        int i2 = 182;
        int i3 = i1 / 2 - i2 / 2;

        int i4 = (int) (localoq.x() / localoq.d() * (i2 + 1));

        int i5 = 12;
        b(i3, i5, 0, 74, i2, 5);
        b(i3, i5, 0, 74, i2, 5);
        if (i4 > 0) {
            b(i3, i5, 0, 79, i4, 5);
        }
        String str = "Boss health";
        localnl.a(str, i1 / 2 - localnl.a(str) / 2, i5 - 10, 16711935);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, this.i.p.b("/gui/icons.png"));
    }

    private void b(int paramInt1, int paramInt2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);

        GL11.glBindTexture(3553, this.i.p.b("%blur%/misc/pumpkinblur.png"));
        adz localadz = adz.a;
        localadz.b();
        localadz.a(0.0D, paramInt2, -90.0D, 0.0D, 1.0D);
        localadz.a(paramInt1, paramInt2, -90.0D, 1.0D, 1.0D);
        localadz.a(paramInt1, 0.0D, -90.0D, 1.0D, 0.0D);
        localadz.a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        localadz.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(float paramFloat, int paramInt1, int paramInt2) {
        paramFloat = 1.0F - paramFloat;
        if (paramFloat < 0.0F) {
            paramFloat = 0.0F;
        }
        if (paramFloat > 1.0F) {
            paramFloat = 1.0F;
        }
        this.c = (float) (this.c + (paramFloat - this.c) * 0.01D);

        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(this.c, this.c, this.c, 1.0F);
        GL11.glBindTexture(3553, this.i.p.b("%blur%/misc/vignette.png"));
        adz localadz = adz.a;
        localadz.b();
        localadz.a(0.0D, paramInt2, -90.0D, 0.0D, 1.0D);
        localadz.a(paramInt1, paramInt2, -90.0D, 1.0D, 1.0D);
        localadz.a(paramInt1, 0.0D, -90.0D, 1.0D, 0.0D);
        localadz.a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        localadz.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void b(float paramFloat, int paramInt1, int paramInt2) {
        if (paramFloat < 1.0F) {
            paramFloat *= paramFloat;
            paramFloat *= paramFloat;
            paramFloat = paramFloat * 0.8F + 0.2F;
        }

        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, paramFloat);
        GL11.glBindTexture(3553, this.i.p.b("/terrain.png"));

        float f1 = pb.be.bN % 16 / 16.0F;
        float f2 = pb.be.bN / 16 / 16.0F;
        float f3 = (pb.be.bN % 16 + 1) / 16.0F;
        float f4 = (pb.be.bN / 16 + 1) / 16.0F;
        adz localadz = adz.a;
        localadz.b();
        localadz.a(0.0D, paramInt2, -90.0D, f1, f4);
        localadz.a(paramInt1, paramInt2, -90.0D, f3, f4);
        localadz.a(paramInt1, 0.0D, -90.0D, f3, f2);
        localadz.a(0.0D, 0.0D, -90.0D, f1, f2);
        localadz.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
        aan localaan = this.i.h.ap.a[paramInt1];
        if (localaan == null) {
            return;
        }

        float f1 = localaan.b - paramFloat;
        if (f1 > 0.0F) {
            GL11.glPushMatrix();
            float f2 = 1.0F + f1 / 5.0F;
            GL11.glTranslatef(paramInt2 + 8, paramInt3 + 12, 0.0F);
            GL11.glScalef(1.0F / f2, (f2 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(paramInt2 + 8), -(paramInt3 + 12), 0.0F);
        }

        d.a(this.i.q, this.i.p, localaan, paramInt2, paramInt3);

        if (f1 > 0.0F) {
            GL11.glPopMatrix();
        }

        d.b(this.i.q, this.i.p, localaan, paramInt2, paramInt3);
    }

    public void a() {
        if (this.l > 0) {
            this.l -= 1;
        }
        this.j += 1;
        for (int i1 = 0; i1 < this.e.size(); i1++) {
            ((nt) this.e.get(i1)).b += 1;
        }
    }

    public void b() {
        this.e.clear();
        this.f.clear();
    }

    public void a(String paramString) {
        boolean bool = e();
        int i1 = 1;

        for (String str : (List<String>) this.i.q.c(paramString, 320)) {
            if ((bool) && (this.n > 0)) {
                this.o = true;
                a(1);
            }

            if (i1 == 0) {
                str = " " + str;
            }
            i1 = 0;
            this.e.add(0, new nt(str));
        }

        while (this.e.size() > 100) {
            this.e.remove(this.e.size() - 1);
        }
    }

    public List c() {
        return this.f;
    }

    public void d() {
        this.n = 0;
        this.o = false;
    }

    public void a(int paramInt) {
        this.n += paramInt;
        int i1 = this.e.size();

        if (this.n > i1 - 20) {
            this.n = (i1 - 20);
        }

        if (this.n <= 0) {
            this.n = 0;
            this.o = false;
        }
    }

    public dx a(int paramInt1, int paramInt2) {
        if (!e()) {
            return null;
        }
        agd localagd = new agd(this.i.A, this.i.d, this.i.e);

        paramInt2 = paramInt2 / localagd.c - 40;
        paramInt1 = paramInt1 / localagd.c - 3;

        if ((paramInt1 < 0) || (paramInt2 < 0)) {
            return null;
        }
        int i1 = Math.min(20, this.e.size());

        if ((paramInt1 <= 320) && (paramInt2 < this.i.q.b * i1 + i1)) {
            int i2 = paramInt2 / (this.i.q.b + 1) + this.n;
            return new dx(this.i.q, (nt) this.e.get(i2), paramInt1, paramInt2 - (i2 - this.n) * this.i.q.b + i2);
        }

        return null;
    }

    public void b(String paramString) {
        this.k = ("Now playing: " + paramString);
        this.l = 60;
        this.m = true;
    }

    public boolean e() {
        return this.i.s instanceof yf;
    }

    public void c(String paramString) {
        adn localadn = adn.a();
        String str = localadn.b(paramString);
        a(str);
    }
}