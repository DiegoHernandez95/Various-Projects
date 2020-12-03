// Create a class named Apartment
// must hold an apartment number, number of bedrooms, number of baths, and rent amount.
// Create a constructor that accepts values for each data field(aptnum, bednum, bathnum, rentamt)
// prompt user to enter a minumum number of bedrooms, bathrooms, and maximum amount of rent user is willing to pay.
// Display data for all the Apartment objects that meet the user's criteria or an appropriate message if no such apartments are available.
// Save files as Apartment.java and TestApartments.java
public class Apartment
{
       private int aptnum = 0;
       private int bednum = 0;
       private double bathnum = 0;
       private double rentamt = 0;
       
       public Apartment(int aptnum, int bednum, double bathnum, double rentamt)
       {
           this.aptnum = aptnum;
           this.bednum = bednum;
           this.bathnum = bathnum;
           this.rentamt = rentamt;
       } // end Apartment
       public int getAptnum()
       {
           return aptnum;
       } // end getAptnum
       public int getBednum()
       {
           return bednum;
       } // end setBednum
       public double getBathnum()
       {
           return bathnum;
       } // end getBathnum
       public double getRentamt()
       {
           return rentamt;
       } // end getRentamt
       
       public void apartmentData()
       {
           System.out.println("Apartment Number: " + aptnum);
           System.out.println("Number of beds: " + bednum);
           System.out.println("Number of baths: " + bathnum);
           System.out.println("Rent amount is: " + rentamt + "\n");
       } // end displayData
       
}
