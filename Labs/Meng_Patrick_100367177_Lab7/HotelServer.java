import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class HotelServer {

	public static void main(String[] args) throws IOException {
		
	      Hotel hotel = new Hotel();
	      final int PORT = 1181;
	      ServerSocket server = new ServerSocket(PORT);
	      
	      while (true)
	      {
	         System.out.println("Waiting for clients to connect...");
	         Socket client = server.accept();
	         System.out.println("Client connected.");
	         
	         HotelService service = new HotelService(client, hotel);
	         Thread t = new Thread(service);
	         t.start();
	      }	      
	}
}

class HotelService implements Runnable, Protocol{
	
	private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private Hotel hotel;

	
	public HotelService(Socket client, Hotel hotel){
		this.client = client;
		this.hotel = hotel;
	}
	
	
	@Override
	public void run() {
		try
	      {
	         in = new DataInputStream(client.getInputStream());
	         out = new DataOutputStream(client.getOutputStream());
	         doService();            
	        
	      }
	      catch (IOException exception)
	      {
	         System.out.println("something is wrong");
	         // do nothing
	      } 
	      finally
	      {
	         try{
	            client.close();
	         }  
	         catch (IOException exception){
	            // do nothing
	         }  
	      }
	}


	private void doService() throws IOException {
		String command = "";
		String name = "";
		int first, last;
		out.writeUTF("Welcome, client !!");
		
		//HANDLE USER COMMAND FIRST
		command = in.readUTF();
		if (!command.equals(USER)) {
     	   out.writeUTF("Error: Must input the \"USER\" first. Closing Connection");
     	   out.flush();
     	   command = QUIT;
        }
		else {
			name = in.readUTF(); 
	        out.writeUTF("Hello, " + name);
	        out.flush();
		}
		/////////////////////////////////////
		
			while(!command.equals(QUIT)){  
		         command = in.readUTF();
		         switch(command){
		            case USER:
		               name = in.readUTF(); 
		               out.writeUTF("Hello, " + name);
		               out.flush();
		            break; 
	
		            case RESERVE:           
		               first = in.readInt();
			           last = in.readInt(); 
		               if(hotel.requestReservation(name,  first, last)) {
		            	   out.writeUTF("Reservation made: " + name + " from " + first + " through " + last);
		               }
		               else {
		            	   out.writeUTF("Reservation unsuccessful: " + name + " from " + first + " through " + last);
		               }
		               out.flush();
		            break;   
	
		            case CANCEL:
		               if(hotel.cancelReservation(name)) {
		            	   out.writeUTF("Reservations successfully canceled for " + name);
		               }
		               else {
		            	   out.writeUTF("Reservations not canceled for " + name + ", no current reservation.");
		               }
		               out.flush();
		            break;
	
		            case AVAIL:
		               out.writeUTF(hotel.reservationInformation());
		               out.flush();
		            break;
		            
		            case QUIT:
		            	out.writeUTF("Closing Connection");
		            	out.flush();
		            break;
	
		            default:
		               out.writeUTF("Invalid command: Closing Connection");
		               out.flush();
		               command = QUIT;
		         }
		      }
		
		
	}
	
}

