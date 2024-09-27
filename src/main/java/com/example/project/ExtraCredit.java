package com.example.project;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ExtraCredit 
{


    public static String calculateTip(int people, int percent, double cost, String items) 
    {
        StringBuilder result = new StringBuilder();

        //You must use these  variable in your calculations
        //DO NOT DELETE ANY OF THE CODE BELOW      
        DecimalFormat formatting = new DecimalFormat("#.##");
        // DecimalFormat converts it to a string so it can be rounded to the hundredths place
        // I reconvert the rounded string back into double type by parsing

        String tipAmountString = formatting.format(cost * (percent / 100.0));
        Double tipAmount = Double.parseDouble(tipAmountString);
        // tippedAmount is the tip amount

        String totalString = formatting.format(tipAmount + cost);
        double total = Double.parseDouble(totalString);
        // total is the cost of the bill after the tip is factored in

        String perPersonCost = formatting.format(cost / people);
        // perPersonCost is the cost per person before tip
        String perPersonTip = formatting.format(tipAmount / people);
        // perPersonTip is the tip given by each person
        String perPersonTotal = formatting.format(((cost * (percent / 100.0)) + cost) / people);
        // perPersonTotal is the cost per person after tip 
        // couldn't round as rounding leads to a rounding error down the line

        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + "\n"); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%" + "\n");
        result.append("Total tip: $" + tipAmount + "\n");
        result.append("Total Bill with tip: $" + total + "\n");
        result.append("Per person cost before tip: $" + perPersonCost + "\n");
        result.append("Tip per person: $" + perPersonTip + "\n");
        result.append("Total cost per person: $" + perPersonTotal + "\n");
        result.append("-------------------------------\n");
        //the two lines  should go below result.append("-------------------------------\n"); 
        result.append("Items ordered:\n" + items);
        
        return result.toString();
    }
                                   
    public static void main(String[] args) 
    {
        int people = 2;
        int percent = 5;
        double cost = 29.56;
        String items = "";
        
        boolean quit = false;

        Scanner scan = new Scanner(System.in);

        while (quit == false)
        {
            System.out.println("Enter an item name or type -1 to finish: ");
            String itemAppend = scan.nextLine();

            if (itemAppend.equals("-1"))
            {
                quit = true;
            }
            else
            {
                items += itemAppend + "\n";
            }
            // checks if itemAppend is -1, quits if it is, before adding the food item into items
        }

        System.out.println(calculateTip(people, percent, cost, items));
        scan.close();
    }
}
