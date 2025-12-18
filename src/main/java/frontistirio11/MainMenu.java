package frontistirio11;

import frontistirio11.examples.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static List<Example> buildExamples() {
        List<Example> xs = new ArrayList<Example>();

        xs.add(new Example01_StudentComparableTreeSet());
        xs.add(new Example02_StudentComparatorTreeSet());
        xs.add(new Example03_ParenthesesMatchingStack());
        xs.add(new Example04_PostfixExpressionEvaluator());
        xs.add(new Example05_HashCollisionResolution());
        xs.add(new Example06_TinyArrayImplementation());
        xs.add(new Example07_TinyCloneAndIterator());
        xs.add(new Example08_TinyToArrayStackConversion());
        xs.add(new Example09_ArrayStackToLinkedTinyConversion());
        xs.add(new Example10_ListOfListsWithoutGenerics());
        xs.add(new Example11_ListOfListsWithGenerics());
        xs.add(new Example12_GenericsSubtyping());
        xs.add(new Example13_WildcardsPrintCollection());
        xs.add(new Example14_WildcardsExtendsMapRegistry());
        xs.add(new Example15_ExamCollectionsQuestion());
        // Two "overview" demos so the menu has 17 entries
        xs.add(new Example16_SetsOverview());
        xs.add(new Example17_MapsOverview());

        return xs;
    }

    public static void main(String[] args)
    {
        List<Example> examples = buildExamples();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("____________________________________________________________");
            System.out.println("|            [HY252]  Object Oriented Programming           |");
            System.out.println("|                      Frontistirio 11                      |");
            System.out.println("|-----------------------------------------------------------|");
            System.out.println("| Institution: Department of Computer Science - UoC         |");
            System.out.println("| Subject: Java Framework Collection                        |");
            System.out.println("| Authors: Christos Polimatidis, Ioannis Chatziantoniou     |");
            System.out.println("| Date: 19/12/2025                                          |");
            System.out.println("|___________________________________________________________|");
            System.out.println();

            for (int i = 0; i < examples.size(); i++) {
                System.out.printf("[%d] %s%n", i + 1, examples.get(i).title());
            }
            System.out.println("[18] Exit");
            System.out.println();
            System.out.print("Choose a number between (1~" + (examples.size() + 1) + "): ");

            if (!sc.hasNextLine()) {
                    System.out.println();
                    System.out.println("No more input. Exiting.");
                    break;
                }

                String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please type a number.");
                System.out.println();
                continue;
            }

            if (choice == 18) {
                System.out.println("Bye!");
                break;
            }

            if (choice < 1 || choice > examples.size()) {
                System.out.println();
                System.out.println("Please pick a number inside the range 1~18 :)");
                System.out.println();
                continue;
            }

            System.out.println();
            Example ex = examples.get(choice - 1);
            System.out.println("=== " + ex.title() + " ===");
            try {
                ex.run();
            } catch (Exception e) {
                System.out.println("Demo ended with exception: " + e);
                e.printStackTrace(System.out);
            }
            System.out.println();
        }
    }
}
