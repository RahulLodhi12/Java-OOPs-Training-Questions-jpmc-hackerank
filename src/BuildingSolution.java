import java.util.Arrays;
import java.util.Scanner;

interface Building {
    void floorCompleted(int floorNumber);

    void printStatus(int floorNumber);

    void printNumberOfFloors();
}

class School implements Building {
    int[] floors;

    public School(int n) {
        floors = new int[n];
        Arrays.fill(floors, 0);
        System.out.println("A school is being constructed");
    }

    @Override
    public void floorCompleted(int floorNumber) {
        int n = floors.length;
        if (floorNumber <= n) {
            floors[floorNumber-1] = 1;
            System.out.println("Constructor for floor number " + floorNumber + " completed in school");
        } else {
            System.out.println("Floor number " + floorNumber + " does not exist in school");
        }
    }

    @Override
    public void printStatus(int floorNumber) {
        int n = floors.length;
        if (floorNumber > n) {
            System.out.println("Floor number " + floorNumber + " does not exist in school");
        } else {
            if (floors[floorNumber] == 1) {
                System.out.println("Constructor for floor number " + floorNumber + " completed in school");
            } else {
                System.out.println("Constructor for floor number " + floorNumber + " not completed in school");
            }
        }
    }

    @Override
    public void printNumberOfFloors() {
        int n = floors.length;
        System.out.println("The school has " + n + " floors");
    }
}

class Hospital implements Building {
    int[] floors;

    public Hospital(int n) {
        floors = new int[n];
        Arrays.fill(floors, 0);
        System.out.println("A hospital is being constructed");
    }

    @Override
    public void floorCompleted(int floorNumber) {
        int n = floors.length;
        if (floorNumber <= n) {
            floors[floorNumber-1] = 1;
            System.out.println("Constructor for floor number " + floorNumber + " completed in hospital");
        } else {
            System.out.println("Floor number " + floorNumber + " does not exist in hospital");
        }
    }

    @Override
    public void printStatus(int floorNumber) {
        int n = floors.length;
        if (floorNumber > n) {
            System.out.println("Floor number " + floorNumber + " does not exist in hospital");
        } else {
            if (floors[floorNumber] == 1) {
                System.out.println("Constructor for floor number " + floorNumber + " completed in hospital");
            } else {
                System.out.println("Constructor for floor number " + floorNumber + " not completed in hospital");
            }
        }
    }

    @Override
    public void printNumberOfFloors() {
        int n = floors.length;
        System.out.println("The hospital has " + n + " floors");
    }
}

public class BuildingSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] floors  = sc.nextLine().split(" ");

        School school = new School(Integer.parseInt(floors[0]));
        Hospital hospital = new Hospital(Integer.parseInt(floors[1]));
        school.printNumberOfFloors();
        hospital.printNumberOfFloors();

        String[] floorNumbers = sc.nextLine().split(" ");
        for (int i = 0; i < floorNumbers.length; i++) {
            school.floorCompleted(Integer.parseInt(floorNumbers[i]));
        }

        floorNumbers = sc.nextLine().split(" ");
        for (int i = 0; i < floorNumbers.length; i++) {
            school.printStatus(Integer.parseInt(floorNumbers[i]));
        }

        floorNumbers = sc.nextLine().split(" ");
        for (int i = 0; i < floorNumbers.length; i++) {
            hospital.floorCompleted(Integer.parseInt(floorNumbers[i]));
        }

        floorNumbers = sc.nextLine().split(" ");
        for (int i = 0; i < floorNumbers.length; i++) {
            hospital.printStatus(Integer.parseInt(floorNumbers[i]));
        }

    }
}
