import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FunctionClient {
    static String hostname = "localhost";

    public static void main(String[] args) {


        String rawNumbers;
        System.out.println("Enter Values for processing: ");
        Scanner scanner = new Scanner(System.in);
        rawNumbers = scanner.nextLine();

        // Convert into an array
        ArrayList<String> numbersString = new ArrayList<String>(Arrays.asList(rawNumbers.split(" ")));


        ArrayList<Integer> numbersInt = new ArrayList<>();
        // Parse Into integers
        try {
            numbersInt = numbersString.stream().map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException ne) {
            System.out.println("Please enter a valid number");
        }


        numbersInt.size();

        try {
            Registry registry = LocateRegistry.getRegistry(hostname);

            Functions functionsStub = (Functions) registry.lookup("MyFunction");

            System.out.println(functionsStub.getMedian(numbersInt));
            System.out.println(functionsStub.getMode(numbersInt));
            System.out.println(functionsStub.getMean(numbersInt));
            System.out.println(functionsStub.getAsc(numbersInt));

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
