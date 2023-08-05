import java.util.*;

public class Ejercicios_23_al_33 {

    public static void main(String[] args) {

        String texto = "Este texto es una muestra para ser usada en los diferentes métodos";

        contadorDePalabras(texto);

        reemplazarUnaLetraPorOtra(texto, 'e', 'i');

        separandoCadaPalabra(texto);
        contadorDeLetras(texto);
        organizarPalabrasAlfabeticamente(texto);

        int[] numeros = {5, 8, 4, 3, 1, 6, 2, 3, 2};

        sumaTodosLosElementos(numeros);
        encotrarElValorMaximo(numeros);
        eliminarDuplicadosDeUnaLista(numeros);
        ordenarEnterosAscendentemente(numeros);
        buscarUnElementoEnUnaLista(numeros, 1);
        enumerarCadaElemento(numeros);

    }


    public static void contadorDePalabras(String texto){
        String textoLimpio = texto.replaceAll("\\s+", " ").trim();
        int contador = 1;
        for (int i=0; i<textoLimpio.length(); i++){
            if (textoLimpio.charAt(i) == ' '){
                contador++;
            }
        }
        System.out.println("El texto introducido contiene " + contador + " palabras.");
    }

    public static void reemplazarUnaLetraPorOtra(String texto, char palabraVieja, char reemplazo){
        String cadenaCambiada = texto.replaceAll(String.valueOf(palabraVieja), String.valueOf(reemplazo));
        System.out.println(cadenaCambiada);
    }

    public static void separandoCadaPalabra(String texto){
        Arrays.stream(texto.split(" |, ")).forEach(System.out::println);
    }

    public static void contadorDeLetras(String texto){
        String textoLimpio = texto.replaceAll(" ", "").trim();
        System.out.println("La cantidad de letras en la oración es de: " + textoLimpio.length());
    }

    public static void organizarPalabrasAlfabeticamente(String texto){
        String[] listaPalabras = Arrays.stream(texto.split(", | ")).sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(listaPalabras));
    }

    public static void sumaTodosLosElementos(int[] numeros){
        OptionalInt reduce = Arrays.stream(numeros).reduce(Integer::sum);
        if (reduce.isPresent()){
            System.out.println("El resultado de sumar todos los elementos en el array es: " + reduce.getAsInt());
        } else {
            System.out.println("La lista está vacía.");
        }
    }

    public static void encotrarElValorMaximo(int[] numeros){
        int numMax = Integer.MIN_VALUE;
        for (int numero : numeros) {
            if (numero > numMax) {
                numMax = numero;
            }
        }
        System.out.println("El número máximo es: " + numMax);
    }

    public static void eliminarDuplicadosDeUnaLista(int[] numeros){
        int[] listaSinDuplicados = new int[numeros.length];
        int indiceLista = 0;
        boolean repetido;
        for (int numero : numeros) {
            int contador = 0;
            repetido = false;
            while (contador < numeros.length && !repetido) {
                if (numero == listaSinDuplicados[contador]) {
                    repetido = true;
                }
                contador++;
            }
            if (!repetido) {
                listaSinDuplicados[indiceLista] = numero;
                indiceLista++;
            }
        }
        System.out.print("La lista sin duplicados es: ");
        for (int i=0; i<indiceLista; i++){
            System.out.print(listaSinDuplicados[i] + " ");
        }
        System.out.println();
    }

    public static void ordenarEnterosAscendentemente(int[] numeros) {
        int temporal;
        for (int i=0; i<numeros.length-1; i++){
            for (int j=0; j<numeros.length-1; j++){
                if (numeros[j]>numeros[j+1]){
                    temporal = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temporal;
                }
            }
        }
        System.out.print("La lista de números ordenada es: ");
        System.out.println(Arrays.toString(numeros));
    }

    public static void buscarUnElementoEnUnaLista(int[] numeros, int elemento){
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i=0; i<numeros.length; i++){
            if (elemento == numeros[i]){
                indices.add(i);
            }
        }
        if (indices.isEmpty()){
            System.out.println("El elemento indicado no se encuentra en la lista.");
        }else if(indices.size()== 1) {
            System.out.println("El elemento se encuentra en la posición: " + indices.get(0));
        }else {
            System.out.print("""
        El elemento buscado se encuentra varias veces en la lista, las posiciones donde está son:
        """);
            indices.forEach(x -> System.out.print(x + " "));
        }
    }

    public static void enumerarCadaElemento(int[] numeros){
        Arrays.sort(numeros);
        int contador=1;
        int temp = numeros[0];

        for (int i=0; i<numeros.length; i++){
            if (temp == numeros[i]){
                contador++;
            } else {
                System.out.printf("El número %d se encuentra %d veces", temp, contador);
                temp = numeros[i];
                contador = 1;
                System.out.println();
            }
        }
    }

}
