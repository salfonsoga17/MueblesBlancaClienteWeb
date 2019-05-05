package mueblesblanca.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum UsuarioEnum {
    USUARIO_DEFAULT(90020);

    protected static final Map<Integer, UsuarioEnum> mapByID = new HashMap<Integer, UsuarioEnum>();
    protected static final Map<String, UsuarioEnum> mapByNAME = new HashMap<String, UsuarioEnum>();

    static {
        for (UsuarioEnum s : EnumSet.allOf(UsuarioEnum.class)) {
            mapByID.put(s.getIndex(), s);
            mapByNAME.put(s.name(), s);
        }
    }

    private int index;

    UsuarioEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getIndexString() {
        return String.valueOf(index);
    }

    public static UsuarioEnum get(int id) {
        return mapByID.get(id);
    }

    public static UsuarioEnum get(String name) {
        return mapByNAME.get(name);
    }

}
