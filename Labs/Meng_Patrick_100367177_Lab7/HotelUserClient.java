import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HotelUserClient {

	public static void main(String[] args) {
		
		final int PORT = 1181;
		
	      try (Socket s = new Socket("localhost", PORT)) {
	    	  
	    	  Scanner sc = new Scanner(System.in);
	    	   
		      InputStream instream = s.getInputStream();
		      OutputStream outstream = s.getOutputStream();
		
		      DataInputStream in = new DataInputStream(instream);
		      DataOutputStream out = new DataOutputStream(outstream);
		      
		      System.out.println("Receiving: " + in.readUTF());
		      
		      String command = "USER", name = "";
		      int input, first, last;
		      
		      System.out.print("What's your name?: ");
		      name = sc.next();
		      out.writeUTF(command);
		      out.writeUTF(name);
		      out.flush();
		      System.out.println("Receiving: " + in.readUTF());
		      
		      while (!command.equals("QUIT")) {
		    	  System.out.println("------------");
		    	  System.out.println("Menu: ");
		    	  System.out.println("1. Reserve.");
		    	  System.out.println("2. Cancel.");
		    	  System.out.println("3. Availability.");
		    	  System.out.println("4. Change User Name.");
		    	  System.out.println("5. Quit.");
		    	  System.out.println("------------");
		    	  System.out.print("Your input (numeric): ");
		    	  input = sc.nextInt();
		    	  
		    	  switch(input) {
		    	  
		    	  case 1:
		    		  command = "RESERVE";
		    		  System.out.print("Day start: "); first = sc.nextInt();
		    		  System.out.print("Day end: "); last = sc.nextInt();
		    		  
		    		  out.writeUTF(command);
		    		  out.writeInt(first);
		    		  out.writeInt(last);
		    		  out.flush();
		    		  
			    	  System.out.println("\nReceiving: " + in.readUTF());
			    	  break;
			    	  
		    	  case 2:
		    		  command = "CANCEL";
		    		  out.writeUTF(command);
		    		  out.flush();
		    		  
			    	  System.out.println("\nReceiving: " + in.readUTF());
			    	  break;
			    	  
		    	  case 3:
		    		  command = "AVAIL";
		    		  out.writeUTF(command);
		    		  out.flush();		    	  
		    		  
			    	  System.out.println("\nReceiving: " + in.readUTF());	
			    	  break;
			    	  
		    	  case 4:
		    		  command = "USER";
		    		  System.out.print("What's your name?: ");
				      name = sc.next();
				      out.writeUTF(command);
				      out.writeUTF(name);
				      out.flush();
				      
				      System.out.println("\nReceiving: " + in.readUTF());	
			    	  break;
			    	  
		    	  case 5:
		    		  command = "QUIT";
		    		  out.writeUTF(command);
		    		  out.flush();	
		    		  
			    	  System.out.println("\nReceiving: " + in.readUTF());	
			    	  break;
			      default:
			    	  System.out.println("Invalid input.");
		    	  }    	  
		      }		          
	      } catch(IOException e) {
	    	  System.out.print("Error from HotelTestClient: ");
	    	  System.out.println(e.getStackTrace());
	      }
	      finally {

	      }

	}

}
