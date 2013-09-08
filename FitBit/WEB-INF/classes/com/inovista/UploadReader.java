package com.inovista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;




/**
 * Servlet implementation class UploadReader
 */
@WebServlet("/UploadReader")
public class UploadReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UploadReader() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("IN POST");
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
			JsonStreamParser parser = new JsonStreamParser(stringBuilder.toString());
			JsonElement element;
			 synchronized (parser) {  // synchronize on an object shared by threads
				   if (parser.hasNext()) {
				     element = parser.next();
				     				     
				   //  System.out.println("E " + element.isJsonObject());
				     if( element.isJsonObject()){
				    	 JsonArray ja =  ((JsonObject)element).getAsJsonArray("records");				    	

			    	    Iterator<JsonElement> iterator = ja.iterator();
			    	    String clientIP = request.getRemoteAddr();
			    	    ArrayList<String> names = new ArrayList<String>();
			    	    ArrayList<String> values = new ArrayList<String>();
			    	    ArrayList<String> tsList = new ArrayList<String>();
			    	    while (iterator.hasNext()) {
			    	        Object obj = iterator.next();
			    	        if( obj instanceof JsonObject){
			    	        	JsonElement el = ((JsonObject)obj).get("name");
			    	        	String name = el.getAsString();
			    	        	if( name == null)
			    	        		name = "";
			    	        	names.add( name );
			    	        	el =((JsonObject)obj).get("value");
			    	        	String value = el.getAsString();
			    	        	if( value == null)
			    	        		value = "";
			    	        	values.add( value );
			    	        	el = ((JsonObject)obj).get("timestamp");
			    	        	String timeStamp = el.getAsString();
			    	        	if( timeStamp == null)
			    	        		timeStamp = "";
			    	        	tsList.add( timeStamp );
			    	        //	System.out.println("N "+name+"V " + value +" T " +timeStamp);
			    			//	updateDbase( stringBuilder.toString());
			    	        }
			    	        
			    	    }
	    				updateDbase( names, values, tsList, clientIP );

				     }
				   }
				 }

		} 
		catch (IOException ex) {
			throw ex;
		} 
		catch(SQLException sqex){
			log("Problem updating the database :  " + sqex.getErrorCode() + " : " + sqex.getLocalizedMessage());
		}
		
		finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
	}
//	private void updateDbase(String jsonValues) throws SQLException{
	private void updateDbase(ArrayList<String> names, ArrayList<String> values, ArrayList<String>  timeStamps, String clientIP ) throws SQLException{
		Connection con = getConnection();
		if( con != null && !con.isClosed()){
			PreparedStatement insert = con.prepareStatement( sSQLInsert );
			for( int i=0; i<names.size(); i++){
				insert.setString(1, names.get(i));
				insert.setString(2, values.get(i));
				insert.setString(3, timeStamps.get(i));
				insert.setString(4, clientIP);
				
				int colsUpdated = insert.executeUpdate();
				log("Cols Updated : " + colsUpdated);
			}
			
		}
	}
	private java.sql.Connection getConnection() throws SQLException{
		if( currentConnection == null || currentConnection.isClosed()){
		    try {
		        Class.forName(driver).newInstance();
		     }
		     catch (Exception ex){
		        log("Check classpath. Cannot load db driver: " + driver);
		     }

		     try {
		    	 currentConnection = DriverManager.getConnection(url, user, password);
		    	 
		     }
		     catch (SQLException e){
		        log( "Driver loaded, but cannot connect to db: " + password);
		     }

		}
		return currentConnection;
	}
	public void destroy(){
		if( currentConnection != null){
			try{
				currentConnection.close();
			}
			catch(SQLException sqex){
				//ignore
			}
			currentConnection = null;
		}
	} 
	private String sSQLInsert = "insert into FORDOPENXC.JSON_SPLIT(Name, Value,JS_Timestamp, ID ) values (?, ?, ? ,?)";
//	private String sSQLInsert = "insert into FORDOPENXC.CAR_RAW_DATA(DATA) values (?)";
	private java.sql.Connection currentConnection;
	private String driver = "com.sap.db.jdbc.Driver";
	private String url = "jdbc:sap://shaopenxchana.sapvcm.com:30015?reconnect=true";
	private String user = "fordxc";
	private String password = "Inovista123";

}
