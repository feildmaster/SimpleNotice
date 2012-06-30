import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;

public class adl extends oe {
    private boolean f = false;
    private lg g;
    public String a;
    private Minecraft h;
    private je i;
    private boolean j = false;
    public za b = new za(null);
    private Map k = new HashMap();
    public List c = new ArrayList();
    public int d = 20;
    Random e = new Random();

    public adl(Minecraft paramMinecraft, String paramString, int paramInt) throws IOException {
        this.h = paramMinecraft;
        Socket localSocket = new Socket(InetAddress.getByName(paramString), paramInt);
        this.g = new lg(localSocket, "Client", this);
        SimpleNotice.get().set(h).set(this); // SimpleNotice
    }

    public void b() {
        if (!this.f) {
            this.g.b();
        }
        this.g.a();
    }

    public void a(aec paramaec) {
        this.h.c = new rk(this.h, this);
        this.h.K.a(gv.i, 1);

        this.i = new je(this, new fj(0L, paramaec.d, false, false, paramaec.c), paramaec.e, paramaec.f);
        this.i.F = true;
        this.h.a(this.i);
        this.h.h.aB = paramaec.e;
        this.h.a(new ez(this));
        this.h.h.f = paramaec.a;
        this.d = paramaec.h;

        ((rk) this.h.c).a(paramaec.d == 1);

        SimpleNotice.get().sendRegister(); // SimpleNotice
    }

    public void a(jp paramjp) {
        double d1 = paramjp.b / 32.0D;
        double d2 = paramjp.c / 32.0D;
        double d3 = paramjp.d / 32.0D;
        fq localfq = new fq(this.i, d1, d2, d3, new aan(paramjp.h, paramjp.i, paramjp.j));
        localfq.r = (paramjp.e / 128.0D);
        localfq.s = (paramjp.f / 128.0D);
        localfq.t = (paramjp.g / 128.0D);
        localfq.ah = paramjp.b;
        localfq.ai = paramjp.c;
        localfq.aj = paramjp.d;

        this.i.a(paramjp.a, localfq);
    }

    public void a(np paramnp) {
        double d1 = paramnp.b / 32.0D;
        double d2 = paramnp.c / 32.0D;
        double d3 = paramnp.d / 32.0D;
        Object localObject = null;
        if (paramnp.h == 10) {
            localObject = new ama(this.i, d1, d2, d3, 0);
        } else if (paramnp.h == 11) {
            localObject = new ama(this.i, d1, d2, d3, 1);
        } else if (paramnp.h == 12) {
            localObject = new ama(this.i, d1, d2, d3, 2);
        } else if (paramnp.h == 90) {
            localObject = new act(this.i, d1, d2, d3);
        } else if (paramnp.h == 60) {
            localObject = new nm(this.i, d1, d2, d3);
        } else if (paramnp.h == 61) {
            localObject = new uq(this.i, d1, d2, d3);
        } else if (paramnp.h == 65) {
            localObject = new adw(this.i, d1, d2, d3);
        } else if (paramnp.h == 72) {
            localObject = new va(this.i, d1, d2, d3);
        } else if (paramnp.h == 63) {
            localObject = new bt(this.i, d1, d2, d3, paramnp.e / 8000.0D, paramnp.f / 8000.0D, paramnp.g / 8000.0D);
            paramnp.i = 0;
        } else if (paramnp.h == 64) {
            localObject = new qb(this.i, d1, d2, d3, paramnp.e / 8000.0D, paramnp.f / 8000.0D, paramnp.g / 8000.0D);
            paramnp.i = 0;
        } else if (paramnp.h == 62) {
            localObject = new qe(this.i, d1, d2, d3);
        } else if (paramnp.h == 73) {
            localObject = new bj(this.i, d1, d2, d3, paramnp.i);
            paramnp.i = 0;
        } else if (paramnp.h == 75) {
            localObject = new hf(this.i, d1, d2, d3);
            paramnp.i = 0;
        } else if (paramnp.h == 1) {
            localObject = new ep(this.i, d1, d2, d3);
        } else if (paramnp.h == 50) {
            localObject = new agg(this.i, d1, d2, d3);
        } else if (paramnp.h == 51) {
            localObject = new el(this.i, d1, d2, d3);
        } else if (paramnp.h == 70) {
            localObject = new abf(this.i, d1, d2, d3, pb.E.bO);
        } else if (paramnp.h == 71) {
            localObject = new abf(this.i, d1, d2, d3, pb.F.bO);
        } else if (paramnp.h == 74) {
            localObject = new abf(this.i, d1, d2, d3, pb.bK.bO);
        }
        if (localObject != null) {
            ((nn) localObject).ah = paramnp.b;
            ((nn) localObject).ai = paramnp.c;
            ((nn) localObject).aj = paramnp.d;
            ((nn) localObject).u = 0.0F;
            ((nn) localObject).v = 0.0F;
            nn[] arrayOfnn = ((nn) localObject).Z();
            if (arrayOfnn != null) {
                int m = paramnp.a - ((nn) localObject).f;
                for (int n = 0; n < arrayOfnn.length; n++) {
                    arrayOfnn[n].f += m;
                }
            }
            ((nn) localObject).f = paramnp.a;
            this.i.a(paramnp.a, (nn) localObject);
            if (paramnp.i > 0) {
                if (paramnp.h == 60) {
                    nn localnn = a(paramnp.i);
                    if ((localnn instanceof acq)) {
                        ((nm) localObject).c = ((acq) localnn);
                    }
                }

                ((nn) localObject).a(paramnp.e / 8000.0D, paramnp.f / 8000.0D, paramnp.g / 8000.0D);
            }
        }
    }

    public void a(lj paramlj) {
        bz localbz = new bz(this.i, paramlj.b, paramlj.c, paramlj.d, paramlj.e);
        localbz.ah = paramlj.b;
        localbz.ai = paramlj.c;
        localbz.aj = paramlj.d;
        localbz.u = 0.0F;
        localbz.v = 0.0F;
        localbz.f = paramlj.a;
        this.i.a(paramlj.a, localbz);
    }

    public void a(wz paramwz) {
        double d1 = paramwz.b / 32.0D;
        double d2 = paramwz.c / 32.0D;
        double d3 = paramwz.d / 32.0D;
        d locald = null;
        if (paramwz.e == 1) {
            locald = new d(this.i, d1, d2, d3);
        }
        if (locald != null) {
            locald.ah = paramwz.b;
            locald.ai = paramwz.c;
            locald.aj = paramwz.d;
            locald.u = 0.0F;
            locald.v = 0.0F;
            locald.f = paramwz.a;
            this.i.e(locald);
        }
    }

    public void a(qc paramqc) {
        mk localmk = new mk(this.i, paramqc.b, paramqc.c, paramqc.d, paramqc.e, paramqc.f);
        this.i.a(paramqc.a, localmk);
    }

    public void a(yn paramyn) {
        nn localnn = a(paramyn.a);
        if (localnn == null) {
            return;
        }
        localnn.a(paramyn.b / 8000.0D, paramyn.c / 8000.0D, paramyn.d / 8000.0D);
    }

    public void a(pf parampf) {
        nn localnn = a(parampf.a);
        if ((localnn != null) && (parampf.b() != null)) {
            localnn.y().a(parampf.b());
        }
    }

    public void a(iy paramiy) {
        double d1 = paramiy.c / 32.0D;
        double d2 = paramiy.d / 32.0D;
        double d3 = paramiy.e / 32.0D;
        float f1 = paramiy.f * 360 / 256.0F;
        float f2 = paramiy.g * 360 / 256.0F;
        rv localrv = new rv(this.h.f, paramiy.b);
        localrv.N = localrv.l = localrv.ah = paramiy.c;
        localrv.O = localrv.m = localrv.ai = paramiy.d;
        localrv.P = localrv.n = localrv.aj = paramiy.e;

        int m = paramiy.h;

        if (m == 0) {
            localrv.ap.a[localrv.ap.c] = null;
        } else {
            localrv.ap.a[localrv.ap.c] = new aan(m, 1, 0);
        }

        localrv.b(d1, d2, d3, f1, f2);
        this.i.a(paramiy.a, localrv);
    }

    public void a(mr parammr) {
        nn localnn = a(parammr.a);
        if (localnn == null) {
            return;
        }
        localnn.ah = parammr.b;
        localnn.ai = parammr.c;
        localnn.aj = parammr.d;
        double d1 = localnn.ah / 32.0D;
        double d2 = localnn.ai / 32.0D + 0.015625D;
        double d3 = localnn.aj / 32.0D;
        float f1 = parammr.e * 360 / 256.0F;
        float f2 = parammr.f * 360 / 256.0F;
        localnn.a(d1, d2, d3, f1, f2, 3);
    }

    public void a(aip paramaip) {
        nn localnn = a(paramaip.a);
        if (localnn == null) {
            return;
        }
        localnn.ah += paramaip.b;
        localnn.ai += paramaip.c;
        localnn.aj += paramaip.d;
        double d1 = localnn.ah / 32.0D;
        double d2 = localnn.ai / 32.0D;
        double d3 = localnn.aj / 32.0D;
        float f1 = paramaip.g ? paramaip.e * 360 / 256.0F : localnn.u;
        float f2 = paramaip.g ? paramaip.f * 360 / 256.0F : localnn.v;
        localnn.a(d1, d2, d3, f1, f2, 3);
    }

    public void a(aji paramaji) {
        nn localnn = a(paramaji.a);
        if (localnn == null) {
            return;
        }
        float f1 = paramaji.b * 360 / 256.0F;
        localnn.f(f1);
    }

    public void a(agx paramagx) {
        this.i.b(paramagx.a);
    }

    public void a(gg paramgg) {
        vq localvq = this.h.h;

        double d1 = localvq.o;
        double d2 = localvq.p;
        double d3 = localvq.q;
        float f1 = localvq.u;
        float f2 = localvq.v;

        if (paramgg.h) {
            d1 = paramgg.a;
            d2 = paramgg.b;
            d3 = paramgg.c;
        }
        if (paramgg.i) {
            f1 = paramgg.e;
            f2 = paramgg.f;
        }

        localvq.Q = 0.0F;
        localvq.r = (localvq.s = localvq.t = 0.0D);
        localvq.b(d1, d2, d3, f1, f2);
        paramgg.a = localvq.o;
        paramgg.b = localvq.y.b;
        paramgg.c = localvq.q;
        paramgg.d = localvq.p;
        this.g.a(paramgg);
        if (!this.j) {
            this.h.h.l = this.h.h.o;
            this.h.h.m = this.h.h.p;
            this.h.h.n = this.h.h.q;
            this.j = true;
            this.h.a((vp) null);
        }
    }

    public void a(ahc paramahc) {
        this.i.a(paramahc.a, paramahc.b, paramahc.c);
    }

    public void a(akt paramakt) {
        int m = paramakt.a * 16;
        int n = paramakt.b * 16;
        if (paramakt.c == null) {
            return;
        }

        DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramakt.c));
        try {
            for (int i1 = 0; i1 < paramakt.d; i1++) {
                int i2 = localDataInputStream.readShort();
                int i3 = localDataInputStream.readShort();
                int i4 = (i3 & 0xFFF) >> 4;
                int i5 = i3 & 0xF;

                int i6 = i2 >> 12 & 0xF;
                int i7 = i2 >> 8 & 0xF;
                int i8 = i2 & 0xFF;

                this.i.c(i6 + m, i8, i7 + n, i4, i5);
            }
        } catch (IOException localIOException) {
        }
    }

    public void a(sz paramsz) {
        this.i.a(paramsz.a << 4, 0, paramsz.b << 4, (paramsz.a << 4) + 15, 256, (paramsz.b << 4) + 15);

        ack localack = this.i.d(paramsz.a, paramsz.b);
        if ((paramsz.f) && (localack == null)) {
            this.i.a(paramsz.a, paramsz.b, true);
            localack = this.i.d(paramsz.a, paramsz.b);
        }

        if (localack != null) {
            localack.a(paramsz.e, paramsz.c, paramsz.d, paramsz.f);
            this.i.c(paramsz.a << 4, 0, paramsz.b << 4, (paramsz.a << 4) + 15, 256, (paramsz.b << 4) + 15);

            if ((!paramsz.f) || (!(this.i.t instanceof ms))) {
                localack.n();
            }
        }
    }

    public void a(ol paramol) {
        this.i.c(paramol.a, paramol.b, paramol.c, paramol.d, paramol.e);
    }

    public void a(amg paramamg) {
        this.g.a("disconnect.kicked", new Object[0]);
        this.f = true;
        this.h.a((xd) null);
        this.h.a(new dw("disconnect.disconnected", "disconnect.genericReason", new Object[]{paramamg.a}));
    }

    public void a(String paramString, Object[] paramArrayOfObject) {
        if (this.f) {
            return;
        }
        this.f = true;
        this.h.a((xd) null);
        this.h.a(new dw("disconnect.lost", paramString, paramArrayOfObject));
    }

    public void b(abs paramabs) {
        if (this.f) {
            return;
        }
        this.g.a(paramabs);
        this.g.c();
    }

    public void c(abs paramabs) {
        if (this.f) {
            return;
        }
        this.g.a(paramabs);
    }

    public void a(vv paramvv) {
        nn localnn = a(paramvv.a);
        Object localObject = (acq) a(paramvv.b);
        if (localObject == null) {
            localObject = this.h.h;
        }
        if (localnn != null) {
            if ((localnn instanceof bz)) {
                this.i.a(localnn, "random.orb", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            } else {
                this.i.a(localnn, "random.pop", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            this.h.j.a(new ws(this.h.f, localnn, (nn) localObject, -0.5F));
            this.i.b(paramvv.a);
        }
    }

    public void a(afd paramafd) {
        this.h.w.a(paramafd.a);
    }

    public void a(kc paramkc) {
        nn localnn = a(paramkc.a);
        if (localnn == null) {
            return;
        }
        Object localObject;
        if (paramkc.b == 1) {
            localObject = (yw) localnn;
            ((yw) localObject).ax();
        } else if (paramkc.b == 2) {
            localnn.k();
        } else if (paramkc.b == 3) {
            localObject = (yw) localnn;
            ((yw) localObject).a(false, false, false);
        } else if (paramkc.b == 4) {
            localObject = (yw) localnn;
            ((yw) localObject).ab();
        } else if (paramkc.b == 6) {
            this.h.j.a(new fs(this.h.f, localnn));
        } else if (paramkc.b == 7) {
            localObject = new fs(this.h.f, localnn, "magicCrit");
            this.h.j.a((rt) localObject);
        } else if ((paramkc.b != 5) || (!(localnn instanceof rv)));
    }

    public void a(abj paramabj) {
        nn localnn = a(paramabj.a);
        if (localnn == null) {
            return;
        }
        if (paramabj.e == 0) {
            yw localyw = (yw) localnn;
            localyw.d(paramabj.b, paramabj.c, paramabj.d);
        }
    }

    public void a(jf paramjf) {
        int m = 1;
        String str1 = paramjf.a;
        if ((str1 == null) || (str1.trim().length() == 0)) {
            m = 0;
        } else if (!str1.equals("-")) {
            try {
                Long.parseLong(str1, 16);
            } catch (NumberFormatException localNumberFormatException) {
                m = 0;
            }
        }

        if (m == 0) {
            this.g.a("disconnect.genericReason", new Object[]{"The server responded with an invalid server key"});
        } else if (paramjf.a.equals("-")) {
            c(new aec(this.h.k.b, 29));
        } else {
            try {
                URL localURL = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + this.h.k.b + "&sessionId=" + this.h.k.c + "&serverId=" + paramjf.a);
                BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localURL.openStream()));
                String str2 = localBufferedReader.readLine();
                localBufferedReader.close();

                if (str2.equalsIgnoreCase("ok")) {
                    c(new aec(this.h.k.b, 29));
                } else {
                    this.g.a("disconnect.loginFailedInfo", new Object[]{str2});
                }
            } catch (Exception localException) {
                this.g.a("disconnect.genericReason", new Object[]{"Internal client error: " + localException.toString()});
            }
        }
    }

    public void c() {
        this.f = true;
        this.g.a();
        this.g.a("disconnect.closed", new Object[0]);
    }

    public void a(aay paramaay) {
        double d1 = paramaay.c / 32.0D;
        double d2 = paramaay.d / 32.0D;
        double d3 = paramaay.e / 32.0D;
        float f1 = paramaay.f * 360 / 256.0F;
        float f2 = paramaay.g * 360 / 256.0F;
        acq localacq = (acq) aao.a(paramaay.b, this.h.f);
        localacq.ah = paramaay.c;
        localacq.ai = paramaay.d;
        localacq.aj = paramaay.e;
        localacq.bf = (paramaay.h * 360 / 256.0F);
        nn[] arrayOfnn = localacq.Z();
        if (arrayOfnn != null) {
            int m = paramaay.a - localacq.f;
            for (int n = 0; n < arrayOfnn.length; n++) {
                arrayOfnn[n].f += m;
            }
        }

        localacq.f = paramaay.a;

        localacq.b(d1, d2, d3, f1, f2);
        this.i.a(paramaay.a, localacq);

        List localList = paramaay.b();
        if (localList != null) {
            localacq.y().a(localList);
        }
    }

    public void a(zf paramzf) {
        this.h.f.a(paramzf.a);
    }

    public void a(agl paramagl) {
        this.h.h.a(new uh(paramagl.a, paramagl.b, paramagl.c));
        this.h.f.B().a(paramagl.a, paramagl.b, paramagl.c);
    }

    public void a(adv paramadv) {
        Object localObject = a(paramadv.a);
        nn localnn = a(paramadv.b);

        if (paramadv.a == this.h.h.f) {
            localObject = this.h.h;
        }
        if (localObject == null) {
            return;
        }

        ((nn) localObject).h(localnn);
    }

    public void a(gt paramgt) {
        nn localnn = a(paramgt.a);
        if (localnn != null) {
            localnn.a(paramgt.b);
        }
    }

    private nn a(int paramInt) {
        if (paramInt == this.h.h.f) {
            return this.h.h;
        }
        return this.i.a(paramInt);
    }

    public void a(ds paramds) {
        this.h.h.d(paramds.a);
        this.h.h.aF().a(paramds.b);
        this.h.h.aF().b(paramds.c);
    }

    public void a(ih paramih) {
        this.h.h.a(paramih.a, paramih.b, paramih.c);
    }

    public void a(kx paramkx) {
        if (paramkx.a != this.h.h.aB) {
            this.j = false;
            this.i = new je(this, new fj(0L, paramkx.d, false, false, paramkx.e), paramkx.a, paramkx.b);
            this.i.F = true;
            this.h.a(this.i);
            this.h.h.aB = paramkx.a;
            this.h.a(new ez(this));
        }

        this.h.a(true, paramkx.a, false);
        ((rk) this.h.c).a(paramkx.d == 1);
    }

    public void a(ags paramags) {
        agh localagh = new agh(this.h.f, null, paramags.a, paramags.b, paramags.c, paramags.d);
        localagh.g = paramags.e;
        localagh.a(true);
    }

    public void a(gr paramgr) {
        vq localvq = this.h.h;
        switch (paramgr.b) {
            case 0:
                localvq.a(new me(paramgr.c, paramgr.d));
                localvq.ar.f = paramgr.a;
                break;
            case 2:
                localvq.a(new ahg());
                localvq.ar.f = paramgr.a;
                break;
            case 5:
                localvq.a(new amc());
                localvq.ar.f = paramgr.a;
                break;
            case 3:
                localvq.a(new az());
                localvq.ar.f = paramgr.a;
                break;
            case 1:
                localvq.a(gk.c(localvq.o), gk.c(localvq.p), gk.c(localvq.q));
                localvq.ar.f = paramgr.a;
                break;
            case 4:
                localvq.c(gk.c(localvq.o), gk.c(localvq.p), gk.c(localvq.q));
                localvq.ar.f = paramgr.a;
        }
    }

    public void a(fu paramfu) {
        vq localvq = this.h.h;
        if (paramfu.a == -1) {
            localvq.ap.b(paramfu.c);
        } else if ((paramfu.a == 0) && (paramfu.b >= 36) && (paramfu.b < 45)) {
            aan localaan = localvq.aq.b(paramfu.b).b();
            if ((paramfu.c != null) && ((localaan == null) || (localaan.a < paramfu.c.a))) {
                paramfu.c.b = 5;
            }

            localvq.aq.a(paramfu.b, paramfu.c);
        } else if (paramfu.a == localvq.ar.f) {
            localvq.ar.a(paramfu.b, paramfu.c);
        }
    }

    public void a(kn paramkn) {
        dd localdd = null;
        vq localvq = this.h.h;
        if (paramkn.a == 0) {
            localdd = localvq.aq;
        } else if (paramkn.a == localvq.ar.f) {
            localdd = localvq.ar;
        }
        if (localdd != null) {
            if (paramkn.c) {
                localdd.a(paramkn.b);
            } else {
                localdd.b(paramkn.b);
                c(new kn(paramkn.a, paramkn.b, true));
            }
        }
    }

    public void a(abl paramabl) {
        vq localvq = this.h.h;
        if (paramabl.a == 0) {
            localvq.aq.a(paramabl.b);
        } else if (paramabl.a == localvq.ar.f) {
            localvq.ar.a(paramabl.b);
        }
    }

    public void a(ee paramee) {
        SimpleNotice.get().recievePacket(paramee); // SimpleNotice
    }

    public void a(aiu paramaiu) {
        if (this.h.f.j(paramaiu.a, paramaiu.b, paramaiu.c)) {
            kw localkw = this.h.f.b(paramaiu.a, paramaiu.b, paramaiu.c);
            if ((localkw instanceof sc)) {
                sc localsc = (sc) localkw;
                if (localsc.a()) {
                    for (int m = 0; m < 4; m++) {
                        localsc.a[m] = paramaiu.d[m];
                    }
                    localsc.j();
                }
            }
        }
    }

    public void a(ait paramait) {
        if (this.h.f.j(paramait.a, paramait.b, paramait.c)) {
            kw localkw = this.h.f.b(paramait.a, paramait.b, paramait.c);

            if ((localkw != null)
                    && (paramait.d == 1) && ((localkw instanceof cj))) {
                ((cj) localkw).a(aao.a(paramait.e));
            }
        }
    }

    public void a(jl paramjl) {
        vq localvq = this.h.h;
        a(paramjl);
        if ((localvq.ar != null) && (localvq.ar.f == paramjl.a)) {
            localvq.ar.a(paramjl.b, paramjl.c);
        }
    }

    public void a(ta paramta) {
        nn localnn = a(paramta.a);
        if (localnn != null) {
            localnn.b(paramta.b, paramta.c, paramta.d);
        }
    }

    public void a(add paramadd) {
        this.h.h.af();
    }

    public void a(qi paramqi) {
        this.h.f.f(paramqi.a, paramqi.b, paramqi.c, paramqi.d, paramqi.e);
    }

    public void a(us paramus) {
        vq localvq = this.h.h;
        int m = paramus.b;
        if ((m >= 0) && (m < us.a.length)
                && (us.a[m] != null)) {
            localvq.b(us.a[m]);
        }

        if (m == 1) {
            this.i.B().b(true);
            this.i.k(1.0F);
        } else if (m == 2) {
            this.i.B().b(false);
            this.i.k(0.0F);
        } else if (m == 3) {
            ((rk) this.h.c).a(paramus.c == 1);
        } else if (m == 4) {
            this.h.a(new c());
        }
    }

    public void a(ai paramai) {
        if (paramai.a == yr.bd.bQ) {
            ra.a(paramai.b, this.h.f).a(paramai.c);
        } else {
            System.out.println("Unknown itemid: " + paramai.b);
        }
    }

    public void a(ej paramej) {
        this.h.f.g(paramej.a, paramej.c, paramej.d, paramej.e, paramej.b);
    }

    public void a(kk paramkk) {
        ((ahv) this.h.h).b(gv.a(paramkk.a), paramkk.b);
    }

    public void a(wb paramwb) {
        nn localnn = a(paramwb.a);
        if ((localnn == null) || (!(localnn instanceof acq))) {
            return;
        }

        ((acq) localnn).b(new alg(paramwb.b, paramwb.d, paramwb.c));
    }

    public void a(ado paramado) {
        nn localnn = a(paramado.a);
        if ((localnn == null) || (!(localnn instanceof acq))) {
            return;
        }

        ((acq) localnn).m(paramado.b);
    }

    public boolean a() {
        return false;
    }

    public void a(wj paramwj) {
        ah localah = (ah) this.k.get(paramwj.a);
        if ((localah == null) && (paramwj.b)) {
            localah = new ah(paramwj.a);
            this.k.put(paramwj.a, localah);
            this.c.add(localah);
        }
        if ((localah != null) && (!paramwj.b)) {
            this.k.remove(paramwj.a);
            this.c.remove(localah);
        }
        if ((paramwj.b) && (localah != null)) {
            localah.b = paramwj.c;
        }
    }

    public void a(acw paramacw) {
        c(new acw(paramacw.a));
    }

    public void a(ym paramym) {
        vq localvq = this.h.h;
        localvq.aT.b = paramym.b;
        localvq.aT.d = paramym.d;
        localvq.aT.a = paramym.a;
        localvq.aT.c = paramym.c;
    }
}