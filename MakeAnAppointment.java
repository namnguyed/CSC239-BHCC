	import java.io.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.awt.Choice;

	public class MakeAnAppointment  extends Frame
	             implements ActionListener {

	 
	 
	   private TextField PhoneNumField,NameField, EmailField, MembershipField;
	                 
	   private Choice GenderField, StylistField, ServicesFiled;
	   				

	   private Button enter, // send record to file
	                  done;  // quit program

	   // Application other pieces
	   private DataOutputStream output;  

	   public MakeAnAppointment()
	   {
	      super( "Welcome To Bear Hair Salon !!!" );

	      // Open the file
	      try {
	         output = new DataOutputStream(
	                  new FileOutputStream( "appointment.dat" ) );
	      }
	      catch ( IOException e ) {
	         System.err.println( "File not opened properly\n" +
	                             e.toString() );
	         System.exit( 1 );
	      }      
	 
	      setSize( 500, 350 );
	      setLayout( new GridLayout( 8, 2 ) );
	     
	   
	      // Get the size of the screen
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (((screenSize.width - this.getWidth()) / 1) / 2); 
			int y = (((screenSize.height - this.getHeight()) / 2) / 2);
			this.setLocation(x, y);

	      // create the components of the Frame
	      add( new Label( " Phone Number" ) );
	       PhoneNumField = new TextField(  );
	      add(  PhoneNumField ); 
	      
	      add( new Label( " Name" ) );
	       NameField = new TextField(  );
	      add(  NameField );       
	      
	      add( new Label( " Email" ) );
	       EmailField = new TextField(  );
	      add(  EmailField );      

	      add( new Label( " Membership Status" ) );
	      MembershipField = new TextField(  );
	      add( MembershipField );
	     
	      add( new Label( " Stylist Gender" ) );
	      GenderField = new Choice();//create an object
	      //add data to a list
	      GenderField.add("Female");
	      GenderField.add("Male");
	      GenderField.add("Any");
	      add( GenderField );
	      
	      add( new Label( " Stylist Level" ) );
	      StylistField = new Choice();
	        //add data to a list
	      StylistField.add("Junior");
	      StylistField.add("Senior");
	      StylistField.add("Master");
	      add(StylistField );
	        
	      add( new Label( " Services" ) );
	      ServicesFiled= new Choice();
	        //add data to a list
	      ServicesFiled.add("wash/blowdry");
	      ServicesFiled.add("Haircut");
	      ServicesFiled.add("Coloring");
	      ServicesFiled.add("Perming");
	      add(ServicesFiled);
	     
	      
	      
	      enter = new Button( "Enter" );
	      enter.addActionListener( this );
	      add( enter );      

	      done = new Button( "Done" );
	      done.addActionListener( this );
	      add( done );       
 
	 setVisible( true ); 
	 PhoneNumField.requestFocus();
	 
	   }

	   public void actionPerformed( ActionEvent e )
	   {
	       if ( e.getSource() == enter ) addRecord();

	      if ( e.getSource() == done ) {
	         try {
	            output.close();
	         }
	         catch ( IOException io ) {
	            System.err.println( "File not closed properly\n" +
	                                io.toString() );
	                         System.exit( 1 );
	         }

	         System.exit( 0 );
	      }
	   }


	   public void addRecord()
	   {
	      int PhoneNum = 0;
	      boolean MemberTemp;
	      String genderTemp;
	      String StylistTemp;
	      String ServicesTemp;

	         if ( ! PhoneNumField.getText().equals( "" ) ) {

	            // output the values to the file
	            try {
	            	PhoneNum = Integer.parseInt( PhoneNumField.getText());

	               if ( PhoneNum > 0 ) {
	                  output.writeInt( PhoneNum );
	                  output.writeUTF( NameField.getText() );
	                  output.writeUTF( EmailField.getText() );
	               
	               MemberTemp = Boolean.parseBoolean(MembershipField.getText());
		           output.writeBoolean( MemberTemp );
		           
		           genderTemp = GenderField.getSelectedItem(); //get string
		           output.writeUTF( genderTemp ); //change to write UTF
	             
		           StylistTemp = StylistField.getSelectedItem(); //get string
	               output.writeUTF(  StylistTemp ); //change to write UTF
	               
	               ServicesTemp = ServicesFiled.getSelectedItem(); //get string
	               output.writeUTF(  ServicesTemp ); //change to write UTF
		           
		          

	            // clear the TextFields
		        PhoneNumField.setText( "" );
	            NameField.setText( "" );
	            EmailField.setText( "" );
	            MembershipField.setText("");
	            GenderField.select(0); 
	            StylistField.select(0);
	            ServicesFiled.select(0);
	        
	               }
	            }
	          
	            catch ( NumberFormatException nfe ) {
	                System.err.println(
	                   "You must enter an integer phone number" );
	             }
	      
	         catch ( IOException io ) {
	            System.err.println(
	               "Error during write to file\n" +
	               io.toString() );
	            System.exit( 1 );
	         }
	      }
	   }

	   
	   public static void main( String args[] )
	   {
	      new MakeAnAppointment();
	   }
	}




