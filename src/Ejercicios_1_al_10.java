import java.util.Scanner;

public class Ejercicios_1_al_10 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion=0;
        while(opcion != 12) {
            listaDeOpciones();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("""
                            *** Se realizarán las 4 operaciones matemáticas básicas ***
                               *** por lo cual necesitará introducir dos números ***
                            """);
                    sumaRestaMultiplicaDivide();
                }
                case 2 -> {
                    System.out.println("Se determinará si el número ingresado es par o impar.");
                    System.out.print("Por favor, introduzca un número: ");
                    determinarParImpar(entrada.nextInt());
                }
                case 3 -> {
                    System.out.print("""
                            Para calcular el périmetro y el área de un circulo,
                                por favor proporcione el radio del circulo.
                            """);
                    System.out.print("Radio: ");
                    calcularRadioYPerimetro(entrada.nextDouble());
                }
                case 4 -> {
                    System.out.println("Ingresa tu edad.");
                    calcularMayorDeEdad(entrada.nextInt());
                }
                case 5 -> {
                    System.out.print("Por favor ingresa dos números por medio de la consola.");
                    determinarNumeroMayor();
                }
                case 6 -> {
                    System.out.println("Ingrese un número, el que quiera.");
                    positivoNegativoCero(entrada.nextDouble());
                }
                case 7 -> {
                    System.out.println("""
                            Crearé una tabla de multiplicar de cualquier número, será multiplicada desde el 1
                                           hasta el 10, puedes ingresar el número que desees.
                            """);
                    multiplicarHastaDiez(entrada.nextInt());
                }
                case 8 -> {
                    System.out.println("""
                            En este juego deberás ingresar números entre el uno y el 100, se generará
                                       un número aleatorio, el cúal deberás adivinar.
                                                  ¡¡Buena suerte!!
                            """);
                    adivinaElNumero();
                }
                case 9 -> {
                    System.out.println("Calcularemos el factorial de un número entero, por favor introdúcelo" +
                            "a continuación.");
                    calcularFactorial(entrada.nextInt());
                }
                case 10 -> {
                    System.out.println("Acá simplemente procedemos a imprimir los primeros 20 número de la serie" +
                            "Fibonacci.");
                    primerosVeinteNumerosSerieFibonacci();
                }
                case 11 -> {
                    System.out.print("Ingrese lado a = ");
                    double a = entrada.nextDouble();
                    System.out.print("Ingrese lado b = ");
                    double b = entrada.nextDouble();
                    System.out.print("Ingrese lado c = ");
                    double c = entrada.nextDouble();
                    obtenerAreaDeTrianguloHeron(a, b, c);
                }
            }

            System.out.println("¿Desea continuar? (y/n)");
            String continuar = entrada.next();

            if (continuar.equalsIgnoreCase("n")) break;

        }


    }

    private static void listaDeOpciones() {
        System.out.println("Ingrese un número para escoger una de las siguientes opciones: ");
        System.out.println("""
                1. Operaciones matemáticas.
                2. Determinar par o impar.
                3. Área y perímetro de un circulo.
                4. ¿Eres mayor o menor de edad?
                5. Ingresa dos números, te diremos cuál es mayor.
                6. ¿El número ingresado será positivo o negativo?
                7. Tabla de multiplicar del número dado hasta el 10.
                8. Un minijuego de adivinar un número.
                9. Calcular factorial de número dado.
                10. Los primeros 20 números de la serie Fibonacci.
                11. Area del triángulo usando formula de Herón.
                12. Terminar programa.
                """);
        System.out.print("Opción: ");
    }

    static Scanner entrada = new Scanner(System.in);
    static int numero1;
    static int numero2;

    public static void sumaRestaMultiplicaDivide(){
        System.out.print("Por favor introduzca el primer número: ");
        numero1 = entrada.nextInt();

        System.out.print("Por favor introduzca el segundo número: ");
        numero2 = entrada.nextInt();

        System.out.println("Los resultados de las operaciones básicas con " + numero1 + " y " + numero2 + " son: ");
        System.out.println("Suma= " + (numero1+numero2));
        System.out.println("Resta= " + (numero1-numero2));
        System.out.println("Multiplicación= " + (numero1*numero2));
        System.out.print("División= ");
        System.out.printf("%.2f",((double)numero1/(double)numero2));
        System.out.println();
    }

    public static void determinarParImpar(int num){
        if (num%2 == 0){
            System.out.println("El número " + num + " es par");
        } else {
            System.out.println("El número " + num + " es impar");
        }
    }

    public static void calcularRadioYPerimetro(double radioCirculo){
        System.out.print("El área del circulo es: ");
        System.out.printf("%.2f", Math.PI*(Math.pow(radioCirculo, 2)));

        System.out.println();

        System.out.print("El perímetro del circulo es: ");
        System.out.printf("%.2f", 2 * radioCirculo * Math.PI);
        System.out.println();
    }

    public static void calcularMayorDeEdad(int edad){
        if (edad < 0 || edad > 130){
            System.out.println("La edad ingresada no es válida");
        } else if (edad < 18) {
            System.out.println("El usuario es menor de edad");
        } else {
            System.out.println("El usuario es mayor de edad");
        }
    }

    public static void determinarNumeroMayor(){
        System.out.print("Por favor introduzca el primer número: ");
        numero1 = entrada.nextInt();

        System.out.print("Por favor introduzca el segundo número: ");
        numero2 = entrada.nextInt();

        if (numero1 > numero2){
            System.out.printf("El número %d es mayor que el número %d", numero1, numero2);
        } else if (numero1 == numero2){
            System.out.println("Los dos números tienen igual valor");
        } else {
            System.out.printf("El número %d es menor que el número %d", numero1, numero2);
        }
    }

    public static void positivoNegativoCero(double num){
        if (num<0) System.out.println("El número es negativo.");
        else if (num==0) System.out.println("El número ingresado es 0");
        else System.out.println("El número es positivo.");
    }

    public static void multiplicarHastaDiez(int num){
        if (num<0) {
            System.out.println("El número debe ser positivo");
            return;
        }
        for (int i=0; i<=10; i++){
            System.out.println(num + "x" + i + " = " + num*i);
        }
    }

    public static void adivinaElNumero(){
        System.out.print("ingresa un número entre uno y 100: ");

        int numeroRandom = (int)(Math.random()*100);
        int numeroIngresado;
        do{
            numeroIngresado = entrada.nextInt();

            if (numeroIngresado<numeroRandom){
                System.out.print("Deberías ingresar un número mayor: ");
            } else if (numeroIngresado > numeroRandom){
                System.out.print("Sería mejor que ingreses un número menor: ");
            } else {
                System.out.println("¡¡Eso es!! El número deseado era " + numeroRandom);
            }

        } while (numeroRandom!= numeroIngresado);
    }

    public static void calcularFactorial(int num){
        int resultado =1;
        for (int i=num; i>0; i--){
            resultado*= i;
        }
        System.out.println(resultado);
    }

    public static void primerosVeinteNumerosSerieFibonacci(){
        int[] serieFibonacci = new int[20];
        serieFibonacci[0] = 0;
        serieFibonacci[1] = 1;

        for (int i= 2; i<20; i++){
            serieFibonacci[i] = serieFibonacci[i-1] + serieFibonacci[i-2];
        }
        for (int i=0; i<20; i++){
            System.out.print(serieFibonacci[i]);
            if (i<19){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void obtenerAreaDeTrianguloHeron(double ladoA, double ladoB, double ladoC){
        double semiperimetro = (ladoA + ladoB + ladoC)/2;
        double area = Math.sqrt(semiperimetro*(semiperimetro-ladoA)*(semiperimetro-ladoB)
        *(semiperimetro-ladoC));


        String mensaje = String.format("""
                El triángulo dado con lados:
                a = %.2fcm
                b = %.2fcm
                c = %.2fcm
                tiene un semiperímetro de %.2fcm
                Y al usar la formula de Herón para calcular el resultado,
                obtenemos que el triángulo tiene un área = %.2fcm²
                """, ladoA, ladoB, ladoC, semiperimetro, area);
        System.out.println(mensaje);
    }

}
