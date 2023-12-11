
public interface Emprec_Iface{
  
  //define and initialize costs
  
  public double vip_discount = 0.90;

  public double junior_stylist_rate = 1.00;
  public double senior_stylist_rate = 1.50;
  public double master_stylist_rate = 2.00;
  
  public double Wash_And_Blowdry_cost = 30.00;
  public double haircut_cost = 50.00;
  public double coloring_cost = 100.00;
  public double Perming_cost = 120.00;
  
  public double Wash_And_Blowdry_hour = 0.50;
  public double haircut_hour = 1.00;
  public double coloring_hour= 3.00;
  public double curling_hour = 2.50;
  
  
  
  public double calc_regular_cost();
  
  public double calc_vip_cost();
  
  public double calc_hour_needed();
  
}


