import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UtilizandoStreams {

    UtilizandoStreams(){

    }

    public int numeroFaltanteUmADez(int[] numeros){
        return 55 - Arrays.stream(numeros)
                          .sum();
    }

    public String[] filtraNumerosEMantemOrdenamento(String[] str){
        List<String> apoioUm = Arrays.stream(str)
                .filter(n -> Pattern.compile("[0-9]+")
                        .matcher(n)
                        .find())
                .collect(Collectors.toList());

        List<String> resultado = new ArrayList<>();

        for (String s : apoioUm){
            if(!resultado.contains(s)){
                resultado.add(s);
            }
        }

        return resultado.stream()
                .toArray(String[]::new);
    }

    public int ordenaDescrecente(final int numero){
        String apoio = "";
        List<Integer> ordem = Arrays.stream(String
                .valueOf(numero)
                .split(""))
                .mapToInt(n -> Integer.parseInt(n))
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        Collections.reverse(ordem);

        for (Integer n : ordem){
            apoio+=n;
        }

        return Integer.parseInt(apoio);
    }

    public int[] somaDeHorasMinutosSegundos(String[] str) {
        int[][] times = new int[str.length][];
        int index = 0;
        for (String timeStr : str) {
            times[index++] = Arrays.stream(timeStr.split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int seconds = Arrays.stream(times)
                .mapToInt(time -> time[2])
                .sum();
        int minutes = Arrays.stream(times)
                .mapToInt(time -> time[1])
                .sum();
        int hours = Arrays.stream(times)
                .mapToInt(time -> time[0])
                .sum();

        minutes += seconds / 60;
        hours += minutes / 60;

        return new int[] {hours, minutes % 60, seconds % 60};
    }

    public int[] contaPositivosESomaNegativos(int[] numero){

        if(numero != null && numero.length > 0) {
            long contaPositivos = Arrays.stream(numero)
                    .filter(s -> s > 0)
                    .count();

            int somaNegativos = Arrays.stream(numero)
                    .filter(s -> s < 0)
                    .sum();

            return new int[]{(int)contaPositivos, somaNegativos};
        }

        return new int[]{};
    }

    public int converteParaBinarioERetornaQuantUm(int numero){
        int d = numero;
        long uns = 0;

        if (numero!=0) {
            StringBuffer binario = new StringBuffer();

            while (d > 0) {
                int b = d % 2;
                binario.append(b);
                d = d >> 1;
            }

            String oi = binario.reverse().toString();

            uns = Arrays.stream(oi
                    .split(""))
                    .mapToInt(s -> Integer.parseInt(s))
                    .filter(s -> s == 1)
                    .count();

            return (int) uns;
        }
        return 0;
    }

    public int[] semRepetirEOrdenada(int[] n){
        return Arrays.stream(n)
                .boxed()
                .mapToInt(Integer::intValue)
                .distinct()
                .sorted()
                .toArray();
    }

    public boolean somaDivisivelPorNove(int numero){
        int soma = Arrays.stream(String
                .valueOf(numero)
                .split(""))
                .mapToInt(n -> Integer.parseInt(n))
                .sum();

        if(soma%9 == 0) return true;

        return false;
    }

    public String reverteOrdemStringComMaisDeCincoLetras(String str){
        StringBuilder resultado = new StringBuilder();
        String [] quebraString = str.split(" ");

        for (int i = 0; i < quebraString.length; i++) {
            if(quebraString[i].length() >= 5){
                List<String> revertendo = Arrays.stream(quebraString[i].split(""))
                        .collect(Collectors.toList());
                Collections.reverse(revertendo);

                if(i != quebraString.length){
                    resultado.append(" ");
                }

                for (String s : revertendo){
                    resultado.append(s);
                }

            }else{
                resultado.append(" " + quebraString[i] + " ");
            }
        }

        if(resultado.substring(resultado.length()-1, resultado.length()).equals(" ")){
            resultado.delete(resultado.length()-1, resultado.length());
        }

        if(resultado.substring(0,1).equals(" ")) {
            resultado.delete(0,1);
        }

        return resultado.toString().replaceAll("  ", " ");
    }
}
