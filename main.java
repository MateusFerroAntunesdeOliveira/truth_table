// import java.util.ArrayList;
// import java.util.Scanner;

class Main {
    public static Character printBit(boolean p) {
        if (p)
            return 'V';
        else
            return 'F';
    }

    public void formula(String formulaCerta) {
        System.out.println("( " + formulaCerta + " )");
    }

    public void tabela1var(String formulaCerta) {
        boolean p, resposta;

        System.out.println("+---+");
        System.out.print  ("| p |");
        formula(formulaCerta);
        System.out.println();
        System.out.println("+---+");

        for (int i = 1; i >= 0; --i) {
            switch (i) {
            case 1:
                p = true;
                break;
            default:
                p = false;
            }

            resposta = (formulaCerta.charAt(0) == '~') ? !p : p;
            System.out.print("| " + printBit(p) + " |  ");
            System.out.println(printBit(resposta));
        }
        System.out.println("+---+");
    }

    public static void main(String[] args) {
        boolean p, q, r;
        System.out.println();
        System.out.println("+---+---+---+---------------+");
        System.out.println("| p | q | r |   p v q v r   |");
        System.out.println("+---+---+---+---------------+");

        for (int i = 1; i <= 8; ++i) {
            switch (i) {
            case 1:
                p = true;
                q = true;
                r = true;
                break;
            case 2:
                p = true;
                q = true;
                r = false;
                break;
            case 3:
                p = true;
                q = false;
                r = true;
                break;
            case 4:
                p = true;
                q = false;
                r = false;
                break;
            case 5:
                p = false;
                q = true;
                r = true;
                break;
            case 6:
                p = false;
                q = true;
                r = false;
                break;
            case 7:
                p = false;
                q = false;
                r = true;
                break;
            case 8:
                p = false;
                q = false;
                r = false;
                break;
            default:
                p = false;
                q = false;
                r = false;
            }
            System.out.print("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) + " |");
            System.out.println("       " + printBit(p || q || r) + "       |");
        }
        System.out.println("+---+---+---+---------------+");
        System.out.println();
    }
}
