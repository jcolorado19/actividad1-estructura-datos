import java.util.Scanner;

public class CensoFamiliar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de familias: ");
        int numFamilias = scanner.nextInt();
        
        while (numFamilias <= 0) {
            System.out.println("El número de familias debe ser mayor a 0. Ingrese nuevamente: ");
            numFamilias = scanner.nextInt();
        }
        
        // Arrays para almacenar los valores solicitados
        double[] agua = new double[numFamilias];
        double[] luz = new double[numFamilias];
        double[] gas = new double[numFamilias];
        int[] estratos = new int[numFamilias];
        
        // Recolección de datos
        for (int i = 0; i < numFamilias; i++) {
            System.out.println("\nFamilia " + (i+1));
            System.out.println("Ingrese el estrato (1, 2, 3 o mayor): ");
            estratos[i] = scanner.nextInt();
            
            System.out.println("Ingrese el valor del agua: ");
            agua[i] = scanner.nextDouble();
            
            System.out.println("Ingrese el valor de la luz: ");
            luz[i] = scanner.nextDouble();
            
            System.out.println("Ingrese el valor del gas: ");
            gas[i] = scanner.nextDouble();
        }
        
        // Cálculo de descuentos y totales
        double totalAgua = 0, totalLuz = 0, totalGas = 0;
        
        for (int i = 0; i < numFamilias; i++) {
            double descuento;
            
            if (estratos[i] == 1) {
                descuento = 0.20;
            } else if (estratos[i] == 2) {
                descuento = 0.15;
            } else {
                descuento = 0.09;
            }
            
            agua[i] = agua[i] * (1 - descuento);
            luz[i] = luz[i] * (1 - descuento);
            gas[i] = gas[i] * (1 - descuento);
            
            totalAgua += agua[i];
            totalLuz += luz[i];
            totalGas += gas[i];
        }
        
        // Mostrar resultados
        System.out.println("\nTotales a pagar por servicio:");
        System.out.printf("Total Agua: $%.2f%n", totalAgua);
        System.out.printf("Total Luz: $%.2f%n", totalLuz);
        System.out.printf("Total Gas: $%.2f%n", totalGas);
        System.out.printf("Total General: $%.2f%n", (totalAgua + totalLuz + totalGas));
        
        // Mostrar totales por familia
        System.out.println("\nTotales a pagar por cada familia:");
        for (int i = 0; i < numFamilias; i++) {
            System.out.println("\nFamilia " + (i+1) + ":");
            System.out.printf("Agua: $%.2f%n", agua[i]);
            System.out.printf("Luz: $%.2f%n", luz[i]);
            System.out.printf("Gas: $%.2f%n", gas[i]);
            System.out.printf("Total Familia: $%.2f%n", (agua[i] + luz[i] + gas[i]));
        }
        
        scanner.close();
    }
}
