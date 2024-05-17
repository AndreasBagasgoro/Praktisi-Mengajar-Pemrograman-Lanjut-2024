import java.io.*;
import java.util.*;

public class HospitalQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> patientQueue = new ArrayDeque<>();
        boolean continueLoop = true;
        
        // Load queue data from file when the program starts
        loadQueueData(patientQueue);
        
        while (continueLoop) {
            try {
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
                        if (amount < 0 || amount > patientQueue.size()) {
                            throw new IllegalArgumentException("Invalid amount of patients to remove");
                        }
                        for (int i = 0; i < amount; i++) {
                            String removed = patientQueue.poll();
                            System.out.printf("%s is removed from queue\n", removed);
                        }
                        break;
                    case 3:
                        System.out.println("VIEWING PATIENT IN QUEUE");
                        System.out.println("=====================================");
                        int count = 1;
                        for (String patient : patientQueue) {
                            System.out.printf("%d. %s\n", count++, patient);
                        }
                        break;
                    case 4:
                        continueLoop = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                input.next(); // Clear the invalid input
            } finally {
                System.out.println("Terima kasih");
            }
        }
        
        // Save queue data to file when the program ends
        saveQueueData(patientQueue);
    }
    
    private static void saveQueueData(Queue<String> patientQueue) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("queue_data.txt"))) {
            for (String patient : patientQueue) {
                writer.println(patient);
            }
        } catch (IOException e) {
            System.err.println("Error saving queue data: " + e.getMessage());
        }
    }
    
    private static void loadQueueData(Queue<String> patientQueue) {
        try (Scanner scanner = new Scanner(new File("queue_data.txt"))) {
            while (scanner.hasNextLine()) {
                patientQueue.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Queue data file not found, do nothing
            System.err.println("Queue data file not found. Creating a new one.");
        }
    }
}

