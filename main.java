// import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.print("| " + printBit(p) + " | ");
            System.out.println(printBit(resposta));
        }
        System.out.println("+---+");
    }

    public void tabela2var(String formulaCerta) {
        boolean p, q, resposta = true;

        System.out.println("+---+---+");
        System.out.print  ("| p | q |");
        formula(formulaCerta);
        System.out.println();
        System.out.println("+---+---+");
        
        for (int i = 3; i >= 0; --i) {
            switch (i) {
            case 3:
                p = true; q = true; break;
            case 2:
                p = true; q = false; break;
            case 1:
                p = false; q = true; break;
            default:
                p = false; q = false;
            }

            if (formulaCerta.length() == 3) resposta = formulaCerta.charAt(1) == '^' ? p && q : p || q;
            else if (formulaCerta.length() == 4) {
                if (formulaCerta.charAt(0) == '~') resposta = formulaCerta.charAt(2) == '^' ? (!p && q) : (!p || q);
                else if (formulaCerta.charAt(2) == '~') resposta = formulaCerta.charAt(1) == '^' ? (p && !q) : (p || !q);
            }
            else if (formulaCerta.length() == 5) resposta = formulaCerta.charAt(2) == '^' ? (!p && !q) : (!p || !q);
            
            System.out.print  ("| " + printBit(p) + " | " + printBit(q) );
            System.out.println("| " + printBit(resposta));
        }
        System.out.println("+---+---+");
    }

    public void tabela3var(String formulaCerta) {
        boolean p, q, r, resposta = true;

        System.out.println("+---+---+---+");
        System.out.print  ("| p | q | r |");
        formula(formulaCerta);
        System.out.println();
        System.out.println("+---+---+---+");
        
        for (int i = 7; i >= 0; --i) {
            switch (i) {
                case 7:
                p = true; q = true; r = true; break;
                case 6:
                p = true; q = true; r = false; break;
                case 5:
                p = true; q = false; r = true; break;
                case 4:
                p = true; q = false; r = false; break;
                case 3:
                p = false; q = true; r = true; break;
                case 2:
                p = false; q = true; r = false; break;
                case 1:
                p = false; q = false; r = true; break;
                default:
                p = false; q = false; r = false;
            }
            
            //-> Tamanho 5
            if (formulaCerta.length() == 5) {
                if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(3) == '^')
                    resposta = p && q && r;
                else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(3) == '^')
                    resposta = p || q && r;
                else if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(3) == 'v')
                    resposta = p && q || r;
                else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(3) == 'v')
                    resposta = p || q || r;
            }
            //-> Tamanho 6
            else if (formulaCerta.length() == 6) {
                if (formulaCerta.charAt(0) == '~') {
                    if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(4) == '^')
                        resposta = !p && q && r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(4) == '^')
                        resposta = !p || q && r;
                    else if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(4) == 'v')
                        resposta = !p && q || r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(4) == 'v')
                        resposta = !p || q || r;
                }
                else if (formulaCerta.charAt(2) == '~') {
                    if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(4) == '^')
                        resposta = p && !q && r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(4) == '^')
                        resposta = p || !q && r;
                    else if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(4) == 'v')
                        resposta = p && !q || r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(4) == 'v')
                        resposta = p || !q || r;
                }
                else if (formulaCerta.charAt(4) == '~') {
                    if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(3) == '^')
                        resposta = p && q && !r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(3) == '^')
                        resposta = p || q && !r;
                    else if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(3) == 'v')
                        resposta = p && q || !r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(3) == 'v')
                        resposta = p || q || !r;
                }
            }
            //-> Tamanho 7
            else if (formulaCerta.length() == 7) {
                if (formulaCerta.charAt(0) == '~' && formulaCerta.charAt(3) == '~') {
                    if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(5) == '^')
                        resposta = !p && !q && r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(5) == '^')
                        resposta = !p || !q && r;
                    else if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(5) == 'v')
                        resposta = !p && !q || r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(5) == 'v')
                        resposta = !p || !q || r;
                }
                else if (formulaCerta.charAt(0) == '~' && formulaCerta.charAt(5) == '~') {
                    if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(4) == '^')
                        resposta = !p && q && !r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(4) == '^')
                        resposta = !p || q && !r;
                    else if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(4) == 'v')
                        resposta = !p && q || !r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(4) == 'v')
                        resposta = !p || q || !r;
                }
                else if (formulaCerta.charAt(2) == '~' && formulaCerta.charAt(5) == '~') {
                    if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(4) == '^')
                        resposta = p && !q && !r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(4) == '^')
                        resposta = p || !q && !r;
                    else if (formulaCerta.charAt(1) == '^' && formulaCerta.charAt(4) == 'v')
                        resposta = p && !q || !r;
                    else if (formulaCerta.charAt(1) == 'v' && formulaCerta.charAt(4) == 'v')
                        resposta = p || !q || !r;
                }
            }
            //-> Tamanho 8
            else if (formulaCerta.length() == 8) {
                if (formulaCerta.charAt(0) == '~' && formulaCerta.charAt(3) == '~' && formulaCerta.charAt(6) == '~') {
                    if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(5) == '^')
                        resposta = !p && !q && !r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(5) == '^')
                        resposta = !p || !q && !r;
                    else if (formulaCerta.charAt(2) == '^' && formulaCerta.charAt(5) == 'v')
                        resposta = !p && !q || !r;
                    else if (formulaCerta.charAt(2) == 'v' && formulaCerta.charAt(5) == 'v')
                        resposta = !p || !q || !r;
                }
            }

            System.out.print  ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
            System.out.println("| " + printBit(resposta));
        }
        System.out.println("+---+---+---+");
    }

    boolean formula1var(String formula) {
        if ((formula.charAt(0) == 'p' || formula.charAt(0) == 'q' || formula.charAt(0) == 'r') && formula.length() == 1) {
            tabela1var(formula);
            return true;
        } 
        else if ((formula.charAt(0) == '~' && formula.charAt(1) == 'p') || 
                 (formula.charAt(0) == '~' && formula.charAt(1) == 'q') || 
                 (formula.charAt(0) == '~' && formula.charAt(1) == 'r')) {
                    tabela1var(formula);
                    return true;
                 }
        
        else return false;
    }

    //TODO boolean formula2var(String formula) {}

    //TODO boolean formula3var(String formula) {}

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String formula;

        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("|                                   |");
        System.out.println("|  Operacoes permitidas: v = OU     |");
        System.out.println("|  Operacoes permitidas: ^ = E      |");
        System.out.println("|  Operacoes permitidas: ~ = ¬      |");
        System.out.println("|                                   |");
        System.out.println("|  Variaveis permitidas: p - q - r  |");
        System.out.println("|                                   |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("                                   ");
        System.out.print  ("Agora, digite a formula: ");
        formula = teclado.nextLine().toLowerCase();

        switch(formula.length()) {
            case 1:
                System.out.println("Formula: " + formula + "\n");
                break;
            default:
        }

        teclado.close();
    }
}
