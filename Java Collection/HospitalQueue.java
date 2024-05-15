import java.util.*;
public class HospitalQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> patientQueue = new ArrayDeque<>();
        boolean continueLoop = true;
        while(continueLoop){
            System.out.println("\n=====================================");
            System.out.println("HOSPITAL QUEUE SYSTEM"); 
            System.out.println("=====================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.println("\n=====================================");
            switch (choice) {
                case 1:
                    System.out.println("ADDING PATIENT TO QUEUE");
                    System.out.println("=====================================");
                    System.out.print("Enter the patient name: ");
                    input.nextLine();
                    String patientName = input.nextLine();
                    patientQueue.add(patientName);
                    break;
                case 2:
                    System.out.println("REMOVED PATIENT TO QUEUE");
                    System.out.println("=====================================");
                    System.out.print("Enter the amount of patient to remove: ");
                    int amount = input.nextInt();

                    for (int i = 0; i < amount; i++) {
                        String removed = patientQueue.poll();
                        System.out.printf("%s is removed from queue\n", removed);
                    }
                    
                    break;
                case 3:
                    System.out.println("VIEWING PATIENT IN QUEUE");
                    System.out.println("=====================================");
                    for(int i = 0; i < patientQueue.size(); i++){
                        System.out.printf("%d. %s\n", i + 1, patientQueue.toArray()[i]);
                    }

                    break;
                case 4:
                    continueLoop = false;
                    break;
                default:
                    break;
            }
        }
    }
}