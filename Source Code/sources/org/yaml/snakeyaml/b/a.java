package org.yaml.snakeyaml.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: Resolver */
public class a {
    public static final Pattern fjF = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern fjG = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern fjH = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern fjI = Pattern.compile("^(?:<<)$");
    public static final Pattern fjJ = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern fjK = Pattern.compile("^$");
    public static final Pattern fjL = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern fjM = Pattern.compile("^(?:=)$");
    public static final Pattern fjN = Pattern.compile("^(?:!|&|\\*)$");
    protected Map<Character, List<b>> fjO = new HashMap();

    protected void bEB() {
        a(h.fja, fjF, "yYnNtTfFoO");
        a(h.fiX, fjH, "-+0123456789");
        a(h.fiY, fjG, "-+0123456789.");
        a(h.fiS, fjI, "<");
        a(h.fjb, fjJ, "~nN\u0000");
        a(h.fjb, fjK, null);
        a(h.fiZ, fjL, "0123456789");
        a(h.fiR, fjN, "!&*");
    }

    public a() {
        bEB();
    }

    public void a(h hVar, Pattern pattern, String str) {
        if (str == null) {
            List list = (List) this.fjO.get(null);
            if (list == null) {
                list = new ArrayList();
                this.fjO.put(null, list);
            }
            list.add(new b(hVar, pattern));
            return;
        }
        for (char valueOf : str.toCharArray()) {
            Object valueOf2 = Character.valueOf(valueOf);
            if (valueOf2.charValue() == 0) {
                valueOf2 = null;
            }
            List list2 = (List) this.fjO.get(valueOf2);
            if (list2 == null) {
                list2 = new ArrayList();
                this.fjO.put(valueOf2, list2);
            }
            list2.add(new b(hVar, pattern));
        }
    }

    public h a(NodeId nodeId, String str, boolean z) {
        if (nodeId == NodeId.scalar && z) {
            h bDJ;
            List list;
            if (str.length() == 0) {
                list = (List) this.fjO.get(Character.valueOf(0));
            } else {
                list = (List) this.fjO.get(Character.valueOf(str.charAt(0)));
            }
            if (list != null) {
                for (b bVar : list) {
                    bDJ = bVar.bDJ();
                    if (bVar.bEC().matcher(str).matches()) {
                        return bDJ;
                    }
                }
            }
            if (this.fjO.containsKey(null)) {
                for (b bVar2 : (List) this.fjO.get(null)) {
                    bDJ = bVar2.bDJ();
                    if (bVar2.bEC().matcher(str).matches()) {
                        return bDJ;
                    }
                }
            }
        }
        switch (nodeId) {
            case scalar:
                return h.fjc;
            case sequence:
                return h.fjd;
            default:
                return h.fje;
        }
    }
}
