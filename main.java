// import java.util.ArrayList;
// import java.util.Scanner;

class Main {
    public static Character printBit(boolean p) {
        if (p) return 'V';
        else return 'F';
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
                p = true; q = true; r = true;
                break;
            case 2:
                p = true; q = true; r = false;
                break;
            case 3:
                p = true; q = false; r = true;
                break;
            case 4:
                p = true; q = false; r = false;
                break;
            case 5:
                p = false; q = true; r = true;
                break;
            case 6:
                p = false; q = true; r = false;
                break;
            case 7:
                p = false; q = false; r = true;
                break;
            case 8:
                p = false; q = false; r = false;
            default:
                p = false; q = false; r = false;
            }
            System.out.print("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) + " |");
            System.out.println("       " + printBit(p || q || r) + "       |");
        }
        System.out.println("+---+---+---+---------------+");
        System.out.println();
    }
}
