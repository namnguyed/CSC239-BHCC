import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ReadAnAppointment extends Frame implements ActionListener {


Emprec Customer;


private TextField  PhoneNumField, NameField, EmailField,MembershipField, 
                GenderField, StylistField, ServicesField,
                   RegularCostField, VipCostField, HoursField;;


private Button next,   // get next record in file
               done;   // quit program

//Application other pieces
private DataInputStream input;


//Constructor -- initialize the Frame 
public ReadAnAppointment()
{
super( "Confirm Your Appoinment !!!" );

// Open the file
try {
   input = new DataInputStream(
               new FileInputStream( "appointment.dat" ) );
}
catch ( IOException e ) {
   System.err.println( "File not opened properly\n" +
                       e.toString() );
   System.exit( 1 );
}      

setSize( 500, 400 );
setLayout( new GridLayout( 11,2 ) );
setBackground(Color.LIGHT_GRAY);

// Get the size of the screen and center the window
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int x = (((screenSize.width - this.getWidth()) / 1) / 2); 
int y = (((screenSize.height - this.getHeight()) / 2) / 2);
this.setLocation(x, y);



// create the components of the Frame
add( new Label( " Phone Number" ) );
PhoneNumField = new TextField( 20 );
PhoneNumField.setEditable( false );
add(  PhoneNumField);

add( new Label( " Name" ) );
NameField = new TextField( 20 );
NameField.setEditable( false );
add(  NameField );      

add( new Label( " Email" ) );
EmailField = new TextField( 20 );
EmailField.setEditable( false );
add( EmailField );
  
add( new Label( " Membership Status" ) );
MembershipField = new TextField( 20 );
MembershipField.setEditable( false );
add( MembershipField);

add( new Label( " Stylist Gender" ) );
GenderField = new TextField( 20 );
GenderField.setEditable( false );
add( GenderField );

add( new Label( " Stylist Level" ) );
StylistField = new TextField( 20 );
StylistField.setEditable( false );
add( StylistField );

add( new Label( " Service" ) );
ServicesField = new TextField( 20 );
ServicesField.setEditable( false );
add( ServicesField );

add( new Label( " Regular Cost" ) );
RegularCostField = new TextField( 20 );
RegularCostField.setEditable( false );
add( RegularCostField );
 
add( new Label( " VIP Cost" ) );
VipCostField = new TextField( 20 );
VipCostField.setEditable( false );
add( VipCostField);

add( new Label( " Hours Required" ) );
HoursField = new TextField( 20 );
HoursField.setEditable( false );
add( HoursField);
  
  
next = new Button( "Next" );
next.addActionListener( this );
add( next );      

done = new Button( "Done" );
done.addActionListener( this );
add( done );       

setVisible( true );  
}

public void actionPerformed( ActionEvent e )
{
if ( e.getSource() == next )
   readRecord();
else
   closeFile();
}

public void readRecord()
{
int phoneNum;
String name;
String email;
boolean membership;
String gender;
String stylist;
String services;

// input the values from the file
try {
   phoneNum = input.readInt();
   name = input.readUTF();
   email = input.readUTF();
   membership = input.readBoolean();
   gender = input.readUTF();
   stylist = input.readUTF(); 
   services = input.readUTF();

   
   String membershipValue;
    if(membership){
        membershipValue = "VIP Member";
    }else{
        membershipValue = "Regular Member";
    }
   

    Customer =new Emprec(phoneNum, name, email, membership,gender,stylist,services);


  System.out.println(Customer ); //toString()
    
   // represent dollars sign in the text field
   NumberFormat fmt = NumberFormat.getCurrencyInstance();
  
   PhoneNumField.setText( String.valueOf( phoneNum ) );
   NameField.setText( name );
   EmailField.setText( email );
   MembershipField.setText( membershipValue );
   
   GenderField.setText( gender);
   StylistField.setText(stylist );
   ServicesField.setText(services);
   
   RegularCostField.setText( String.valueOf( fmt.format(Customer.calc_regular_cost()))); //format text
   VipCostField.setText( String.valueOf( fmt.format(Customer.calc_vip_cost()))); //format text
   HoursField.setText( String.valueOf( Customer.calc_hour_needed())); 

}
catch ( EOFException eof ) {
   closeFile();
}
catch ( IOException e ) {
   System.err.println( "Error during read from file\n" +
                       e.toString() );
   System.exit( 1 );
}
}


private void closeFile()
{
try {
   input.close();
   System.exit( 0 );
}
catch ( IOException e ) {
   System.err.println( "Error closing file\n" +
                       e.toString() );
   System.exit( 1 );
}
}

public static void main( String args[] )
{
new ReadAnAppointment();
}
}


