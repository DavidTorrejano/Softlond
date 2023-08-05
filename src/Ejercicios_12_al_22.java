import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Scanner;


public class Ejercicios_12_al_22 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;
        while(opcion != 12) {
            listaDeOpciones();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("""
                            *** Por favor ingrese un número entero positivo, y le diremos si es primo o no ***
                            """);
                    System.out.print("Número: ");
                    boolean primo = determinarNumeroPrimo(entrada.nextInt());
                    if (primo) System.out.println("El número ingresado es primo");
                    else System.out.println("El número ingresado no es primo.");
                }
                case 2 -> {
                    System.out.println("Por favor ingrese un número con los decimales que quiera" +
                            "\nluego, ingrese la cantidad de decimales a los que desea redondear.");
                    System.out.print("Por favor, introduzca un número: ");
                    double numero = entrada.nextDouble();
                    System.out.print("Por favor ingrese la cantidad de decimales deseados: ");
                    int cantidad = entrada.nextInt();
                    redondearNumeroDecimal(numero, cantidad);
                }
                case 3 -> {
                    System.out.print("""
                            Calcularemos si el número dado es un número perfecto
                            """);
                    System.out.print("Número: ");
                    numeroPerfecto(entrada.nextInt());
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("Veremos si el número es capicúa. \nIngresa el número: ");
                    numeroCapicua(entrada.nextInt());
                }
                case 5 -> {
                    System.out.print("Devolveré la cantidad de números específicados de la serie Fibonacci.");
                    System.out.println("Por favor ingrese la cantidad: ");
                    serieFibonacciNumeroDado(entrada.nextInt());
                }
                case 6 -> {
                    System.out.print("Ingrese el inicio del rango: ");
                    int inicioRango = entrada.nextInt();
                    System.out.print("Ingrese el final del rango: ");
                    int finalRango = entrada.nextInt();
                    numerosPrimosEnRango(inicioRango, finalRango);
                    System.out.println();
                }
                case 7 -> {
                    System.out.print("""
                            La clave generada no es realmente segura, no deberías usarla:
                            """);
                    contrasenaAleatoria();

                    System.out.println();
                }
                case 8 -> {
                    System.out.print("""
                              Idealmente, estamos esperando un nombre, sin embargo,
                            devolverá todo texto tanto en mayúscula como en minúscula
                            """);
                    System.out.print("Nombre: ");
                    entrada.nextLine();
                    nombreMayusMinus(entrada.nextLine());

                }
                case 9 -> {
                    System.out.println("Todo texto será devuelto inverso.");
                    System.out.println("Ingresa el texto: ");
                    entrada.nextLine();
                    imprimeTextoInvertido(entrada.nextLine());
                }
                case 10 -> {
                    System.out.println("""
                            Devolveremos un número indicando la cantidad de veces que
                               una palabra específica se repite dentro del texto.
                            """);
                    System.out.print("Ingresa el texto: ");
                    entrada.nextLine();
                    String texto = entrada.nextLine();
                    System.out.print("Ingresa la letra: ");
                    String letra = entrada.nextLine();
                    contadorDeCaracteres(texto, letra.charAt(0));
                    System.out.println();
                }
                case 11 -> {
                    System.out.println("Un texto palindrome es el que se lee igual en cualquier sentido.");
                    System.out.println("Ingresa tu texto: ");
                    entrada.nextLine();
                    averiguarFrasePalindromeONo(entrada.nextLine());
                }

            }
            if (opcion!=12) {
                System.out.println("¿Desea continuar? (y/n)");
                String continuar = entrada.next();

                if (continuar.equalsIgnoreCase("n")) break;
            }

        }
    }

    private static void listaDeOpciones() {
        System.out.println("Ingrese un número para escoger una de las siguientes opciones: ");
        System.out.println("""
                1. Determinar si un número es primo o no.
                2. Redondear un número con n decimales, a la cantidad de decimales deseados.
                3. Verificar si el número dado es un número perfecto o no.
                4. Verifica si el número ingresado es un número capicúa o no.
                5. Devuelve la cantidad de números ingresados de la serie Fibonacci.
                6. Devuelve todos lo números primos en un rango dado.
                7. Devuelve una contraseña aleatoria de 8 caracteres.
                8. Devuelve el nombre ingresado tanto en mayúscula como en minúsculas.
                9. Imprime el texto ingresado pero invertido.
                10. Cuenta la cantidad de veces que una letra dada se repite en el texto ingresado.
                11. Verifica si un texto ingresado es palindrome o no.
                12. Terminar programa.
                """);
        System.out.print("Opción: ");
    }


    public static boolean determinarNumeroPrimo(int numero){
        int contador = 0;
        for (int i=numero; i>0; i--){
            if (numero%i==0){
                contador++;
            }
        }
        return contador <= 2;
    }

    public static void redondearNumeroDecimal(double numero, int decimalesDeseados){
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimalesDeseados, RoundingMode.HALF_UP);
        System.out.println(bd.doubleValue());
    }

    public static void numeroPerfecto(int numero){
        int contador = 0;
        for (int i=numero-1; i>0; i--){
            if (numero%i==0 && contador<=numero){
                contador+=i;
            }else if (contador > numero)break;

        }
        if (contador== numero){
            System.out.printf("El número %d, es un número perfecto.", numero);
            System.out.println();
        }else {
            System.out.printf("El número %d, no es un número perfecto.", numero);
        }

    }

    public static void numeroCapicua(int numero){
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(numero));
        int numeroReverso = Integer.parseInt(stringBuilder.reverse().toString());
        if (numero == numeroReverso){
            System.out.println("El número dado, es un número capicúa.");
            System.out.println(numero + " == " + numeroReverso);
        } else {
            System.out.println("El número dado no es un número Capicúa.");
            System.out.println(numero + " != " + numeroReverso);
        }
    }

    public static void serieFibonacciNumeroDado(int numero){
        int[] serieFibonacci = new int[numero];
        serieFibonacci[0] = 0;
        serieFibonacci[1] = 1;

        for (int i= 2; i<numero; i++){
            serieFibonacci[i] = serieFibonacci[i-1] + serieFibonacci[i-2];
        }
        for (int i=0; i<numero; i++){
            System.out.print(serieFibonacci[i]);
            if (i<numero-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void numerosPrimosEnRango(int desde, int hasta){
        if (desde>hasta)return;
        int[] rangoNumeros = new int[(hasta-desde)/2];
        int contador = 0;

        for (int i = desde; i<hasta; i++) {
            boolean primo = determinarNumeroPrimo(i);
            if (primo){
                rangoNumeros[contador] = i;
                contador++;
            }
        }
        System.out.print("En el rango de números dados hay los siguientes números primos:" +
                "\n[");
        for (int i=0; i<rangoNumeros.length; i++){
            if (rangoNumeros[i] != 0) {
                System.out.print(rangoNumeros[i]);
                if (rangoNumeros[i+1] != 0){
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
    }

    public static void contrasenaAleatoria(){
        final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
        final String NUMEROS = "0123456789";

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder contraseña = new StringBuilder();
        String caracteres = MAYUSCULAS + MINUSCULAS + NUMEROS;

        for (int i=0; i<8; i++){
            int indice = secureRandom.nextInt(caracteres.length());
            contraseña.append(caracteres.charAt(indice));
        }
        System.out.println(contraseña);
    }

    public static void nombreMayusMinus(String nombreUsuario){
        System.out.println(nombreUsuario.toUpperCase());
        System.out.println(nombreUsuario.toLowerCase());
    }

    public static void imprimeTextoInvertido(String texto){
        StringBuilder builder = new StringBuilder(texto);
        System.out.println(builder.reverse());
    }

    public static void contadorDeCaracteres(String texto, char letra){
        int contador = 0;
        for (int i=0; i<texto.length(); i++){
            if (texto.charAt(i) == letra){
                contador++;
            }
        }
        if (contador == 0){
            System.out.println("La letra indicada no se encuentra en la cadena de texto");
        } else {
            System.out.printf("La cadena de texto contiene %d veces, la letra %c.", contador, letra);
        }
    }

    public static void averiguarFrasePalindromeONo(String frase){
        StringBuilder cadena = new StringBuilder(frase);
        String invertido = cadena.reverse().toString();
        if (frase.equalsIgnoreCase(invertido)){
            System.out.println("La frase ingresada es un Palindrome.");
            System.out.println(frase + " == " + invertido);
        } else {
            System.out.println("La frase ingresada no es Palindrome.");
            System.out.println(frase + " != " + invertido);
        }
    }
}
