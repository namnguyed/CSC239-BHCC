
import java.text.*;

public class Emprec implements Emprec_Iface {
int phoneNum;
String name;
String email;  
boolean membership;
String gender;
String stylist;
String services;


public Emprec (int phoneNum, String name, String email, boolean membership,
                 String gender, String stylist, String services)
{

this.name=name;
this.phoneNum=phoneNum;
this.email=email;
this.membership=membership;
this.gender = gender;
this.stylist=stylist;
this.services=services;
}


Emprec ( String phoneNum,String name, String email,String membership,
        String gender,String stylist,String services)
{

try {
this.phoneNum=Integer.parseInt(phoneNum);
this.name=name;
this.email=email;
this.membership=Boolean.valueOf(membership).booleanValue();
this.gender=gender;
this.stylist=stylist;
this.services=services;


}

catch(NumberFormatException errmsg)
{
System.out.println("Invalid format"+ errmsg);

  this.phoneNum = 0;
  this.name  = "";  
  this.email =" ";
  this.gender = " ";
  this.stylist= "";
  this.services = "";



}//catch

}//Emprec constructor !!!!

public double calc_regular_cost()
{
  double regular_cost = 0.00;
  
// calulate cost for junior stylist
if (stylist.equals("Junior") && services.equals("wash/blowdry"))
regular_cost = junior_stylist_rate * Wash_And_Blowdry_cost;
if (stylist.equals("Junior") && services.equals("Haircut"))
regular_cost = junior_stylist_rate * haircut_cost;
if (stylist.equals("Junior") && services.equals("Coloring"))
regular_cost = junior_stylist_rate * coloring_cost;
if (stylist.equals("Junior") && services.equals("Perming"))
regular_cost = junior_stylist_rate * Perming_cost;

//calculate cost for senior stylist
if (stylist.equals("Senior") && services.equals("wash/blowdry"))
regular_cost = senior_stylist_rate * Wash_And_Blowdry_cost;
if (stylist.equals("Senior") && services.equals("Haircut"))
regular_cost = senior_stylist_rate * haircut_cost;
if (stylist.equals("Senior") && services.equals("Coloring"))
regular_cost = senior_stylist_rate * coloring_cost;
if (stylist.equals("Senior") && services.equals("Perming"))
regular_cost = senior_stylist_rate * Perming_cost;

//calculate cost for master stylist
if (stylist.equals("Master") && services.equals("wash/blowdry"))
regular_cost = master_stylist_rate * Wash_And_Blowdry_cost;
if (stylist.equals("Master") && services.equals("Haircut"))
regular_cost = master_stylist_rate * haircut_cost;
if (stylist.equals("Master") && services.equals("Coloring"))
regular_cost = master_stylist_rate * coloring_cost;
if (stylist.equals("Master") && services.equals("Perming"))
regular_cost = master_stylist_rate * Perming_cost;


return  (regular_cost);

}// calc_regular_cost


public double calc_vip_cost ()
{

double vip_cost = calc_regular_cost()* vip_discount;

return (vip_cost);

}// calc_vip_cost

public double calc_hour_needed() {
double hour_needed = 0.0;

if (services.equals("wash/blowdry"))
hour_needed = Wash_And_Blowdry_hour;
if (services.equals("Haircut"))
hour_needed = haircut_hour;
if (services.equals("Coloring"))
hour_needed = coloring_hour;
if (services.equals("Curling"))
hour_needed = curling_hour;

return (hour_needed);
} // calc_hour_needed


public  String toString()
{
 
 NumberFormat fmt = NumberFormat.getCurrencyInstance();

return
        (   "\n Phone Number:\t\t"+ this.phoneNum +
            "\n Name:\t\t\t"+ this.name +
            "\n Email:\t\t\t"+ this.email +
            "\n Membership Status:\t" + (this.membership ? "VIP Member":"Regular Member" ) +
            "\n Stylist Gender:\t\t"+ gender +
            "\n Stylist Level:\t\t" + stylist +
            "\n Service:\t\t" + services +
            "\n Regular Cost:\t\t"+ fmt.format(calc_regular_cost()) +
            "\n VIP Cost:\t\t"+ fmt.format(calc_vip_cost()) +
            "\n Hours Required:\t\t"+ calc_hour_needed()
            
        );

    }//toString


}// HairSalon

