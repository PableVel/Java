package Collections;

import java.util.HashSet;
import java.util.*;

public class Main {

    public static void main (String[] args){
        Cliente cl1 = new Cliente("Pablito", "12342",43344322);
        Cliente cl2 = new Cliente("Jose","234012", 9832409);
        Cliente cl3 = new Cliente("penelope","234234",3457932);
        Cliente cl4 = new Cliente("Juanito", "949594",95940302);

        Set <Cliente> clientesBanco = new HashSet<Cliente>();

        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);

        HashMap<String,Integer> equipo = new HashMap<String, Integer>();

        equipo.put("Pablo", 10);
        equipo.put("Lalo", 0);
        equipo.put("Shampoo", 2);
        equipo.put("Mani", 1);


        List<String> myList = new ArrayList<String>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add("6");
        myList.add("7");


        String lola = "hola";
        lola.split("");
        String[] array = {"q","a"};

    }

}
