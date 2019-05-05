package mueblesblanca.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EstadoEnum {
    ACTIVO(1), INACTIVO(2), ELIMINADO(3), SELECCIONE(0);

    protected static final Map<Integer, EstadoEnum> mapByID = new HashMap<Integer, EstadoEnum>();
    protected static final Map<String, EstadoEnum> mapByNAME = new HashMap<String, EstadoEnum>();

    static {
        for (EstadoEnum s : EnumSet.allOf(EstadoEnum.class)) {
            mapByID.put(s.getIndex(), s);
            mapByNAME.put(s.name(), s);
        }
    }

    private int index;

    EstadoEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getIndexString() {
        return String.valueOf(index);
    }

    public static EstadoEnum get(int id) {
        return mapByID.get(id);
    }

    public static EstadoEnum get(String name) {
        return mapByNAME.get(name);
    }

}
