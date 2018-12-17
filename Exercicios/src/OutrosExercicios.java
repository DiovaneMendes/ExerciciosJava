public class OutrosExercicios {

    OutrosExercicios(){

    }

    public boolean circulosEmColisoes(int [] circuloUm, int [] circuloDois){
        int r1 = circuloUm[0], x1 = circuloUm[1], y1 = circuloUm[2];
        int r2 = circuloDois[0], x2 = circuloDois[1], y2 = circuloDois[2];

        return ((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) < ((r1+r2)*(r1+r2));
    }

    public boolean numeroPrimo(int numero){
        int ok = 0;
        for (int i=1; i<=numero; i++){
            if(numero%i == 0){
                ok++;
            }
        }
        if(ok == 2) return true;
        return false;
    }

    public String mascaraNumeroCartaoMostraUltimosQuatro(String str){
        String montada;

        if(str.length() > 4){
            montada = str.substring(str.length()-4);

            for(int i=0; i < str.length()-4; i++){
                montada = "#" + montada;
            }

            return montada;
        }
        return str;
    }

    //double [][] matriz = {{0,2,-5,0}, {10,6,4,6}, {1,3.14,1,0}}; -> tem que retorna 3;
    //tem que mostrar numero inteiro e se for negativo, tem que tornar ele positivo
    public int mediaDeValoresMatriz(double [][] matriz){
        int soma = 0;
        int contador = 0;

        for (double[] n : matriz) {
            for (int i = 0; i < n.length; i++) {
                contador++;
                if (n[i] < 0){
                    n[i] = -(n[i]);
                }

                soma += n[i];
            }
        }
        return soma/contador;
    }

    public boolean validadorDeEmail(String email){
        String [] lista = email.split("");
        int indexArroba = 0;
        int indexPonto = 0;
        int indexAntesArroba = 0;
        boolean ok = true;

        if(email.contains("@") && email.contains(".")){
            for (int i=0; i<lista.length; i++){
                if(lista[i].equals("@")){
                    indexArroba = i;
                    ok = false;
                }

                if(ok){
                    indexAntesArroba++;
                }

                if(lista[i].equals(".")){
                    indexPonto = i;
                }
            }

            if(indexAntesArroba > 0 && indexArroba < indexPonto){
                return true;
            }
        }
        return false;
    }
}
