import java.util.*;

public class tabela {

    private Map<String, ArrayList<Character>> table;

    public tabela() {
        this.table = new HashMap<>();
    }

    public Map<String, ArrayList<Character>> getTable() { return table; }

    public int transfInt(String var, Character valor) {
        if (var.startsWith("~"))
            return valor.compareTo('V') == 0 ? 0 : 1;
        else
            return valor.compareTo('V') == 0 ? 1 : 0;
    }

    // public Character verf_operator(String var1, Character valor1, Character op, String var2, Character valor2) {
    //     int resultado = -1;
    //     int v1 = transfInt(var1, valor1);
    //     int v2 = transfInt(var2, valor2);

    //     if (op == 'v') resultado = v1 + v2;
    //     else if (op == '^') resultado = v1 * v2;
        
    //     if (resultado > 0) return 'V';
    //     else return 'F';
    // }

    public void program() {
        // ArrayList<Character> firstElement = new ArrayList<>(List.of('V','V','V','V','F','F','F','F'));
        // ArrayList<Character> secondElement = new ArrayList<>(List.of('V','V','F','F','V','V','F','F'));
        // ArrayList<Character> thirdElement = new ArrayList<>(List.of('V','F','V','F','V','F','V','F'));
    }
}
