import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicios_34_y_35 {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);

        rotarNumerosEnArray(lista, 22, 'd');
        tablaDeMultiplicar();
    }


    public static void rotarNumerosEnArray(List<Integer> lista, int cantidadDeRotaciones, char direccion){
        /*
        Rotación de elementos: Implementa un programa que rote los elementos de
        un arreglo hacia la izquierda o la derecha una cierta cantidad de posiciones.
         */

        int nVecesNecesarias = cantidadDeRotaciones%lista.size();
        if (direccion == 'l' || direccion == 'i'){
            Collections.rotate(lista, -nVecesNecesarias);
        }else {
            Collections.rotate(lista, nVecesNecesarias);
        }
        System.out.println(lista);
    }

    public static void tablaDeMultiplicar(){
        /*
         * 35. Tabla de multiplicar: Crea un programa que imprima las tablas de multiplicar
         * del 1 al 10. Usa para esto una matriz
         */

        int[] num = new int[10];
        num[0]=1;
        num[1]=2;
        num[2]=3;
        num[3]=4;
        num[4]=5;
        num[5]=6;
        num[6]=7;
        num[7]=8;
        num[8]=9;
        num[9]=10;

        for (int n1: num){
            for (int n2: num){
                System.out.println(n1 + "x" + n2 + "= " + (n1*n2));
            }
            System.out.println("---------");
        }
    }
}
