package com.pruebas;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MiPrueba {

    @Test(priority = 1,description = "Descripción")
    void pruebaInicial(){
        System.out.println("Todo verde");
        Assert.assertEquals(1,1);
    }

    @Test(priority = 2)
    void prueba2(){
        System.out.println("Todo verde");
    }

    @Test(priority = 3)
    void prueba3(){
        System.out.println("Todo verde");
    }


}
