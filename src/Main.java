import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean running = true;
        String choice = "";

        while (running)
        {
            displayMenu(list);
            choice = SafeInput.getRegExString(in, "Choose an option", "[AaDdPpQq]".toUpperCase());

            if (choice.equals("A"))
            {
                addItem(list, in);
            } else if (choice.equals("D"))
            {
                deleteItem(list, in);
            } else if (choice.equals("P"))
            {
                printList(list);
            } else if (choice.equals("Q"))
            {
                running = !SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
            }

        }
    }

    private static void printList(ArrayList<String> list)
    {
        if (list.isEmpty())
        {
            System.out.println("The list is empty");
        } else
        {
            for (String item : list)
            {
                System.out.println(item);
            }
        }
    }

    private static void printNumberedList(ArrayList<String> list)
    {
        int index = 1;
        for(String item : list)
        {
            System.out.println(index++ + ". " + item);
        }
    }

    private static void displayMenu(ArrayList<String> list)
    {
        System.out.println("\n--- Menu ---");
        printList(list);
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print (i.e Display) the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(ArrayList<String> list , Scanner pipe)
    {
        String item = SafeInput.getNonZeroLenString(pipe, "Enter item to add to the list");
        list.add(item);
        System.out.println("The item has been added to the list!");
    }

    private static void deleteItem(ArrayList<String> list, Scanner pipe)
    {
        if (list.isEmpty())
        {
            System.out.println("The list is already empty. There is nothing to delete!");
            return;
        }
        printNumberedList(list);
        int index = SafeInput.getRangedInt(pipe, "Enter the number of the item you wish to delete!", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("The item has been removed");
    }

}