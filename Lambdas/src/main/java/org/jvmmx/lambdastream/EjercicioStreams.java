package org.jvmmx.lambdastream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioStreams {
    
    private static final String PALABRA = "[- .:;,¡!]";
    
    /**
     * Cuenta las líneas del archivo usando el reader provisto
     */
    private void ejercicio1() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
        long x = reader.lines().count();
        System.out.println(x);
        }
    }

    /**
     * Crea una lista de palabras sin duplicados del archivo provisto en reader
     * Tip: Ya se cuenta con la expresión PALABRA
     */
    private void ejercicio2() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){

            List<String> palabras =
                    reader.lines()
                    .flatMap(s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                            .map(String::toLowerCase)
                    .distinct().collect(Collectors.toList());

            System.out.println(palabras);


        }
    }
    
    /**
     * Crea una lista de palabras en minusculas y sin duplicados 
     * del archivo provisto en reader y ordenadas alfabéticamente
     */
    private void ejercicio3() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            List<String> palabras = reader.lines().flatMap(s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim)
                    .filter(s->!s.isEmpty())
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted().collect(Collectors.toList());
            System.out.println(palabras);

        }
    }
    
    /**
     * Modifica el ejercicio3 para que las palabras esten ordenadas por longitud
     */
    private void ejercicio4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){

            List<String> palabras = reader.lines().flatMap(s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim)
                    .filter(s->!s.isEmpty())
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted((o1, o2) -> o1.length()-o2.length())
                    .collect(Collectors.toList());
            System.out.println(palabras);

        }
    }
    
    /**
     * Has un histograma de cada palabra que aparece, todas en minúsculas
     */
    private void ejercicio5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){

            Map<String, Integer> palabras =
                    reader.lines().flatMap(s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim)
                    .filter(s->!s.isEmpty())
                    .map(String::toLowerCase).collect(Collectors.toMap(Function.identity(), s -> 1, (a,b)->a+b));
            System.out.println(palabras);
        }
    }
    
    /**
     * Complementa el código para la clase RandomWords 
     * con una lista de 1000 palabras agrupalas por longitud
     */
    private void ejercicio6() throws IOException {
        RandomWords rand = new RandomWords();
        List<String> list = rand.createList(1000);
        double[] xxx = {1,2,3,4};
        Arrays.stream(xxx).max().stream().sum();
        OptionalDouble maxN = Arrays.stream(xxx).max();

        Map<Integer,List<String>> palabrasLongitud =
                list.stream()
                        .collect(Collectors.groupingBy(s->s.length()));
        String str = "jjjjj";

        int[] t = {1,2,3,4,5};
        int hh = Arrays.stream(t).reduce((i,j) -> i*j).getAsInt();

        String[] w = str.split("");
        String x = Arrays.stream(w).distinct().sorted().collect(Collectors.joining(""));
        //long numX = w.stream().filter(s->s.toLowerCase()=="x").count().get();
        //int numO = (int)w.stream().filter(s->s.toLowerCase()=="o").count();

        
    }
    
    
    public static void main(String[] args) throws IOException {
        EjercicioStreams es = new EjercicioStreams();
        System.out.println("Lambdas y Stream API EjercicioStreams");
        System.out.println("Ejercicio 1");
        es.ejercicio1();
        System.out.println("Ejercicio 2");
        es.ejercicio2();
        System.out.println("Ejercicio 3");
        es.ejercicio3();
        System.out.println("Ejercicio 4");
        es.ejercicio4();
        System.out.println("Ejercicio 5");
        es.ejercicio5();
        System.out.println("Ejercicio 6");
        //es.ejercicio6();
    }
    
}
