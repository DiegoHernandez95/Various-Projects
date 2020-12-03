// Create a class named Apartment
// must hold an apartment number, number of bedrooms, number of baths, and rent amount.
// Create a constructor that accepts values for each data field(aptnum, bednum, bathnum, rentamt)
// prompt user to enter a minumum number of bedrooms, bathrooms, and maximum amount of rent user is willing to pay.
// Display data for all the Apartment objects that meet the user's criteria or an appropriate message if no such apartments are available.
// Save files as Apartment.java and TestApartments.java
import java.util.Scanner;
public class TestApartments
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Apartment apts[] = new Apartment[5];
        apts[0] = new Apartment(100, 1, 1, 500);
        apts[1] = new Apartment(101, 1, 2, 750);
        apts[2] = new Apartment(102, 2, 2.5, 1000);
        apts[3] = new Apartment(103, 3, 2, 1500);
        apts[4] = new Apartment(104, 3, 3, 1750);
        int bednum = 0; 
        double bathnum = 0; 
        double rentamt = 0;
        
        System.out.println("Please enter minimum number of bedrooms:");
        bednum = input.nextInt();
        System.out.println("Please enter minimum number of bathrooms:");
        bathnum = input.nextDouble();
        System.out.println("Please enter maximum amount of rent:");
        rentamt = input.nextDouble();
        System.out.println("Based on your criteria, here are the apartments available:\n");
        
        int ctr = 0;
        
        for(int i = 0; i < apts.length; i++)
        {
            if(apts[i].getBednum() >= bednum && apts[i].getBathnum() >= bathnum && apts[i].getRentamt() <= rentamt)
            {
                apts[i].apartmentData();
                ctr = 1;
            }
        } // end for loop
        
        if (ctr == 0)
        {
            System.out.println("I'm sorry no apartments exist within your given criteria.");
        } // end if
    } // end main
} // end TestApartments
