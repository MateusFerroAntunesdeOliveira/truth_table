import java.util.Scanner;

class Main {
    public static Character printBit(boolean p) {
        if (p) return 'V';
        else return 'F';
    }

    public void formula(String formulaCerta) {
        System.out.println(" " + formulaCerta + " |");
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
                p = true; break;
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
            System.out.println(" | " + printBit(resposta));
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
            System.out.println(" | " + printBit(resposta));
        }
        System.out.println("+---+---+---+");
    }

    private boolean formula1var(String formula) {
        if ((formula.charAt(0) == 'p' && formula.length() == 1) || formula.charAt(0) == '~' && formula.charAt(1) == 'p') {
            tabela1var(formula);
            return true;
        }
        else return false;
    }

    private boolean formula2var(String formula) {
        boolean formulaOk = false;

        //-> Tamanho 3
        if (formula.length() == 3) {
            if (formula.charAt(0) == 'p' && formula.charAt(2) == 'q') {
                if (formula.charAt(1) == '^' || formula.charAt(1) == 'v')
                formulaOk = true;
            } else formulaOk = false;
        }

        //-> Tamanho 4
        if (formula.length() == 4) {
            if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == 'q') {
                if (formula.charAt(2) == '^' || formula.charAt(2) == 'v')
                formulaOk = true;
            }
            else if (formula.charAt(0) == 'p' && formula.charAt(2) == '~' && formula.charAt(3) == 'q') {
                if (formula.charAt(1) == '^' || formula.charAt(1) == 'v')
                formulaOk = true;
            }
            else formulaOk = false;
        }

        //-> Tamanho 5
        if (formula.length() == 5) {
            if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == '~' && formula.charAt(4) == 'q') {
                if (formula.charAt(2) == '^' || formula.charAt(2) == 'v')
                formulaOk = true;
            }
            else formulaOk = false;
        }

        //-> Tamanho fora do esperado...
        else formulaOk = false;

        tabela2var(formula);
        return formulaOk;
    }

    private boolean formula3var(String formula) {
        boolean formulaOk = true;

        //-> Tamanho 5
        if (formula.length() == 5) {
            if (formula.charAt(0) == 'p' && formula.charAt(2) == 'q' && formula.charAt(4) == 'r') {
                if ((formula.charAt(1) == '^' || formula.charAt(1) == 'v') &&
                    (formula.charAt(3) == '^' || formula.charAt(3) == 'v'))
                formulaOk = true;
            }
            else formulaOk = false;
        }

        //-> Tamanho 6
        if (formula.length() == 6) {
            if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == 'q' && formula.charAt(5) == 'r') {
                if ((formula.charAt(2) == '^' || formula.charAt(2) == 'v') &&
                    (formula.charAt(4) == '^' || formula.charAt(4) == 'v'))
                    formulaOk = true;
            }
            else if (formula.charAt(0) == 'p' && formula.charAt(2) == '~' && formula.charAt(3) == 'q' && formula.charAt(5) == 'r') {
                if ((formula.charAt(1) == '^' || formula.charAt(1) == 'v') &&
                    (formula.charAt(4) == '^' || formula.charAt(4) == 'v'))
                    formulaOk = true;
            }
            else if (formula.charAt(0) == 'p' && formula.charAt(2) == 'q' && formula.charAt(4) == '~' && formula.charAt(5) == 'r') {
                if ((formula.charAt(1) == '^' || formula.charAt(1) == 'v') &&
                    (formula.charAt(3) == '^' || formula.charAt(3) == 'v'))
                    formulaOk = true;
            }
            else formulaOk = false;
        } 
        
        //-> Tamanho 7
        if (formula.length() == 7) {
            if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == '~' && formula.charAt(4) == 'q' && formula.charAt(6) == 'r') {
                if ((formula.charAt(2) == '^' || formula.charAt(2) == 'v') &&
                    (formula.charAt(5) == '^' || formula.charAt(5) == 'v'))
                    formulaOk = true;
            }
            else if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == 'q' && formula.charAt(5) == '~' && formula.charAt(6) == 'r') {
                if ((formula.charAt(2) == '^' || formula.charAt(2) == 'v') &&
                    (formula.charAt(4) == '^' || formula.charAt(4) == 'v'))
                    formulaOk = true;
            }
            else if (formula.charAt(0) == 'p' && formula.charAt(2) == '~' && formula.charAt(3) == 'q' && formula.charAt(5) == '~' && formula.charAt(6) == 'r') {
                if ((formula.charAt(1) == '^' || formula.charAt(1) == 'v') &&
                    (formula.charAt(4) == '^' || formula.charAt(4) == 'v'))
                    formulaOk = true;
            }
            else formulaOk = false;
        } 

        //-> Tamanho 8
        if (formula.length() == 8) {
            if (formula.charAt(0) == '~' && formula.charAt(1) == 'p' && formula.charAt(3) == '~' && formula.charAt(4) == 'q' && formula.charAt(6) == '~' && formula.charAt(7) == 'r') {
                if ((formula.charAt(2) == '^' || formula.charAt(2) == 'v') &&
                    (formula.charAt(5) == '^' || formula.charAt(5) == 'v'))
                    formulaOk = true;
            }
            else formulaOk = false;
        } 

        //-> Tamanho fora do esperado...
        else formulaOk = false;

        tabela3var(formula);
        return formulaOk;
    }

    static String menu() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("|                                   |");
        System.out.println("|  Operacoes permitidas: v = OU     |");
        System.out.println("|  Operacoes permitidas: ^ = E      |");
        System.out.println("|  Operacoes permitidas: ~ = NOT    |");
        System.out.println("|                                   |");
        System.out.println("|  Variaveis permitidas: p | q | r  |");
        System.out.println("|                                   |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("                                   ");
        System.out.print  ("Agora, digite a formula: ");
        
        String formula = teclado.nextLine().toLowerCase();
        return formula;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Main newTable = new Main();
        boolean tabelaOk = false;
        String formula = menu();

        //TODO Verificar as exceções e tratar fórmulas mal formadas (FMFs)

        switch(formula.length()) {
            case 1:
            case 2:
                tabelaOk = newTable.formula1var(formula);
                break;
            case 3:
            case 4:
                tabelaOk = newTable.formula2var(formula);
                break;
            case 5:
                if (formula.charAt(4) == 'r') tabelaOk = newTable.formula3var(formula);
                else tabelaOk = newTable.formula2var(formula);
                break;
            case 6:
            case 7:
            case 8:
                tabelaOk = newTable.formula3var(formula);
                break;
            default:
                tabelaOk = false;
            if (!tabelaOk) {
                System.out.println("\n=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("  FORMULA INCORRETA  ");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=\n");
                formula = menu();
            }
        }
        teclado.close();
    }
}
