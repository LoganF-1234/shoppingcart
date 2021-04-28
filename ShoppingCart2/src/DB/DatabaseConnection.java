package DB;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import main.*;

public class DatabaseConnection {
	
	Connection connection = getConnection();
    ArrayList<String> usernames;
    ArrayList<String> itemNames;
    String[] itemNamesArray;
    String password;

    	
        // Create Table
		//createTable()
	
        // INSERT (connection, id, type, name, price, amount, description)
        //insertitems(connection,"Fruit","Strawberries",3.89, 30, "16oz Container");
        //insert(connection,"Fruit", "Green Apples",1.29, 30, "1lb of Ripe Apples");
        //insert(connection,"Cereal","Kapn Krunch",10.99, 15, "Berry flavorful!");
        //insert(connection,"Cereal", "Cheerios", 9.99, 15, "Need lower cholesterol?");
        //insert(connection,"Protein", "Venison Burgers", 8.95, 20, "Pack of 3.");
        //insert(connection,"Protein", "Vension Burgers", 79.95, 2, "Pack of 30.");
        //insert(connection,"Electronics", "Wireless Charger", 9.99, 10, "Qi supported.");
        //insert(connection,"Electronics", "Power Brick", 14.99, 10, "20W MagSafe.");
        
        //INSERT (connection, firstname, lastname, position, address, username, password, salary);
        //insertusers(connection, "Gary", "Vee", "Manager", "CA", "GaryVee", "password", 65000);
        //insertusers(connection, "Tom", "Jefferson", "Employee", "CA", "ToJeff01", "password", 75000);
       // insertusers(connection, "Cristian", "Jeffries", "Employee", "CA", "CrJeff02", "password", 80000);
        //insertusers(connection, "Logan", "Ferrera", "Employee", "CA", "LoFerr03", "password", 76000);
        
        //SELECT
        //select(connection, "items");

        // UPDATE(connection, id, amount)
        //update(connection, );

        // DELETE (connection, id)
        //delete(connection, 14);
               
        /* Close the connection once we are finished
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    */

    public void createTable(Connection connection)
    {
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sqlCommand =
                    "CREATE TABLE items(ID SERIAL PRIMARY KEY NOT NULL, "
                    + "TYPE TEXT NOT NULL, "
                    + "NAME TEXT NOT NULL, "
                    + "PRICE DECIMAL(12,2) NOT NULL, "
                    + "AMOUNT SMALLINT, "
                    + "DESCRIPTION TEXT NOT NULL);";
            statement.executeUpdate(sqlCommand);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Created...");
    }

    public void insertitems(Connection connection, String type, String name, double price, int amount, String description)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "INSERT INTO items("
                    + "TYPE, "
                    + "NAME, "
                    + "PRICE, "
                    + "AMOUNT, "
                    + "DESCRIPTION) ";
            sqlCommand += String.format("VALUES('%s', '%s', %.2f, %d, '%s');",type,name,price,amount,description);
            statement.executeUpdate(sqlCommand);
            statement.close();
            connection.commit();
            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    
    public void insertusers(Connection connection, String firstname, String lastname, String position, String address, String username, String password, int salary) {
    	Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "INSERT INTO users("+
                        "FIRSTNAME, "+
                        "LASTNAME, "+
                        "POSITION, "+
                        "ADDRESS, "+
                        "USERNAME, "+
                        "PASSWORD, "+
                        "SALARY"+
                    ") ";
            sqlCommand += String.format("VALUES('%s', '%s', '%s', '%s', '%s', '%s', %d);",firstname,lastname,position,address,username, password, salary );
            statement.executeUpdate(sqlCommand);
            statement.close();
            connection.commit();
            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }    	
    }
    

    public void select(Connection connection, String table)
    {
    	final String items = "items";
    	final String users = "users";
        Statement statement = null;
        try{
            statement = connection.createStatement();
            
            if (table.compareTo(items) == 0) {
            String sqlCommand =
                    "SELECT * FROM items;";
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");

                System.out.println(String.format("ID = %d\n TYPE = %s\n NAME = %s\n PRICE = %.2f\n AMOUNT = %d\n DESCRIPTION = %s\n",id,type,name,price,amount,description));
            }}else
            
            if (table.compareTo(users) == 0) {
            	
            String sqlCommand =
                        "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
            	int id = resultSet.getInt("id");
            	String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String position = resultSet.getString("position");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int salary = resultSet.getInt("salary");
                System.out.println(String.format("ID = %d\n FIRSTNAME = %s\n LASTNAME = %s\n POSITION = %s\n ADDRESS = %s\n USERNAME = %s\n PASSWORD = %s\n SALARY = %s",id,firstname,lastname,position,address,username,password, salary));            	
            	
            }
            resultSet.close();
            statement.close();
            System.out.println("Data Selected...");
            }}
        	catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    
    //return login information for Zero_Login
  /*  public String selectUserNameForLogin(Connection connection, String username) {
    	  Statement statement = null;
          try{
              statement = connection.createStatement();
              String sqlCommand = "SELECT username FROM users WHERE username = " + username.toString();
              String result = "";
              ResultSet resultSet = statement.executeQuery(sqlCommand);
              while(resultSet.next()) {
            	  String user = resultSet.getString("username");
            	  if(user == username) {
            		  result = username;
            	  }   	  
              }
              return result;
  
          } catch (Exception e) {
              e.printStackTrace();
              System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
              System.exit(0);
              return null;
          }
    } */

    
    public void update(Connection connection, String table, int id, int amount)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "UPDATE items amount = "+amount+"where ID = "+id+";";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Updated...");


            select(connection, table);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public void delete(Connection connection, String table, int id)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "DELETE from items where ID = "+id+";";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Deleted...");
            
            
            select(connection, table);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }


	public Connection getConnection() {
		Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/shoppingcart",
                    "postgres",
                    "logan2002"
            );
            System.out.println("Opened Database Successfully!");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
        }
        return connection;
	}
	
	public ArrayList<String> getUsernames(Connection connection) {   
        Statement statement = null;        
        try {
        usernames = new ArrayList<String>();
        statement = connection.createStatement();
       // select(connection, "users");
        String sqlCommand =
                 "SELECT username FROM users;";
        ResultSet resultSet = statement.executeQuery(sqlCommand);    

        while (resultSet.next()) {
            usernames.add(resultSet.getString("username"));
        }
        
        //statement.executeUpdate(sqlCommand); //ERROR CALLING CATCH ~ REDUNDANT
        //connection.commit(); //ERROR CALLING CATCH
        statement.close();
        System.out.println("Username fetched..");
        }catch (Exception e) {
            System.err.println(e.getClass());
        }
        
        return usernames;
    }

	public String findUser(String username) {
		getUsernames(connection); //ERROR HERE
		String user = "";
		for(int i =0; i< usernames.size(); i++) {
			if(usernames.get(i).equals(username)) {
				user += username;
				System.out.println("Logged in as:" + user);
			}
		}
		return user;
	}
	
	public boolean userInArray(String username) {
		if(findUser(username).equals(username)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public ArrayList<String> getItemnames(Connection connection) {   
        Statement statement = null;        
        try {
        itemNames = new ArrayList<String>();
        statement = connection.createStatement();
       // select(connection, "users");
        String sqlCommand =
                 "SELECT * FROM items ORDER BY id ASC;";
        ResultSet resultSet = statement.executeQuery(sqlCommand);    

        int i = 0;
        while (resultSet.next()) {
            //itemNames.add(resultSet.getString("name"));
//            System.out.print(resultSet.getInt(1));
//            System.out.print(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getInt(4));
//            System.out.println(resultSet.getInt(5));
//            System.out.println(resultSet.getString(6));
            itemNames.add(i, Integer.toString(resultSet.getInt(1)));
            i++;
            itemNames.add(i, resultSet.getString(2));
            i++;
            itemNames.add(i, resultSet.getString(3));
            i++;
            itemNames.add(i, Float.toString(resultSet.getFloat(4)));
            i++;
            itemNames.add(i, Integer.toString(resultSet.getInt(5)));
            i++;
            itemNames.add(i, resultSet.getString(6));
            i++;
        }
        
        //statement.executeUpdate(sqlCommand); REDUNDANT
        //connection.commit();
        statement.close();
        System.out.println("Item name fetched..");
        }catch (Exception e) {
            System.err.println(e.getClass());
        }
        
        return itemNames;
    }
	
	//USED FOR COMBOBOX IN TWO_SHOPPINGCART
	public String[] itemNamesArray(Connection connection) {
		 Statement statement = null;        
	        try {
	        itemNamesArray = new String[100];
	        statement = connection.createStatement();
	       // select(connection, "users");
	        String sqlCommand =
	                 "SELECT * FROM items ORDER BY id ASC;";
	        ResultSet resultSet = statement.executeQuery(sqlCommand);    

	        int i = 0;
	        while (resultSet.next()) {	        	
	        	itemNamesArray[i] = resultSet.getString(3);
	            i++;
	           
	        } 
	        statement.close();
	        System.out.println("Item name fetched..");
	        }catch (Exception e) {
	            System.err.println(e.getClass());
	        }
	        
	        return itemNamesArray;
	        
	}
	
	//USED FOR COMBOBOX IN TWO_SHOPPINGCART
		public String[] itemsDatabaseArray(Connection connection) {
			 Statement statement = null;        
		        try {
		        itemNamesArray = new String[100];
		        statement = connection.createStatement();
		       // select(connection, "users");
		        String sqlCommand =
		                 "SELECT * FROM items ORDER BY id ASC;";
		        ResultSet resultSet = statement.executeQuery(sqlCommand);    

		        int i = 0;
		        while (resultSet.next()) {	        	
		        	 itemNamesArray[i] = Integer.toString(resultSet.getInt(1));
		             i++;
		             itemNamesArray[i] =resultSet.getString(2);
		             i++;
		             itemNamesArray[i] = resultSet.getString(3);
		             i++;
		             itemNamesArray[i] = Float.toString(resultSet.getFloat(4));
		             i++;
		             itemNamesArray[i] = Integer.toString(resultSet.getInt(5));
		             i++;
		             itemNamesArray[i] = resultSet.getString(6);
		             i++;
		        	
		           
		        } 
		        statement.close();
		        System.out.println("Item name fetched..");
		        }catch (Exception e) {
		            System.err.println(e.getClass());
		        }
		        
		        return itemNamesArray;
		        
		}
	
	public String getItemName(int num) {
		getItemnames(connection);
		return itemNames.get(num);
	}
	
	public ArrayList<String> decodeInfo(String info){
		
		
		int lastComma=info.indexOf(',');
		int lastPeriod = 0;
		int incremental = 0;
		int groupNumber = 1;
		boolean madeIt = false;
		String smaller = info;
		
		ArrayList<String> finalList = new ArrayList<String>();
		
		String group = info;
		
		while(madeIt == false) {
			
			
			try {
			smaller = info.substring(lastComma+1, smaller.length());
			if(smaller.contains(",") == true) {
				System.out.println(smaller);
				groupNumber++;
				lastComma = info.indexOf(',', lastComma+1);
			}
			
			else {
				madeIt = false;
			}
			}
			catch(StringIndexOutOfBoundsException arg) {
				madeIt = true;
			}
		}
		

		System.out.println(groupNumber);
		for(int f = 0; f < groupNumber; f++) {
		
			for(int i = 0; i < 3; i++) {
				
				try {
				finalList.add(incremental,group.substring(lastPeriod+1, group.indexOf('/', lastPeriod+1)));
				lastPeriod = group.indexOf('/', lastPeriod+1);
				incremental++;
				}
				catch(StringIndexOutOfBoundsException arg) {
					
				}
			}

			lastPeriod = group.indexOf('/', lastPeriod+1);
		}
		for(int i =0; i < finalList.size(); i++) {
			System.out.println(finalList.get(i));
		}
		
		return finalList;

	}
	
	public String setShoppingCartInfo(String item, String cost, String amount) {
		String info = "/"+item+"/"+cost+"/"+amount+"/,";
		return info;
	}
	
	
	
	public void addShoppingCart(String user, String info, String status) {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "INSERT INTO cart(id, user, info) VALUES("+user+", '"+info+"', '"+status+"' );";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Updated...");


            select(connection, "cart");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
	}
	
    public void updateCart(Connection connection, String user, String info)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            
            
            String sqlCommand =
                    "UPDATE cart SET info = '"+main.info+"' WHERE username = '"+user+"';";
            System.out.println(main.info);
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Updated...");


            select(connection, "cart");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    public ArrayList<String> grabCart(Connection connection) {   
        Statement statement = null;        
        try {
        itemNames = new ArrayList<String>();
        statement = connection.createStatement();
       // select(connection, "users");
        String sqlCommand =
                 "SELECT * FROM cart;";
        ResultSet resultSet = statement.executeQuery(sqlCommand);    
        int i = 0;
        while (resultSet.next()) {
            //itemNames.add(resultSet.getString("name"));
//            System.out.print(resultSet.getInt(1));
//            System.out.print(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getInt(4));
//            System.out.println(resultSet.getInt(5));
//            System.out.println(resultSet.getString(6));
            itemNames.add(i, resultSet.getString(1));
            i++;
            itemNames.add(i, resultSet.getString(2));
            i++;
            itemNames.add(i, resultSet.getString(3));
            i++;

        }
        
        //statement.executeUpdate(sqlCommand);
        //connection.commit();
        statement.close();
        }catch (Exception e) {
            System.err.println(e.getClass());
        }
        
        return itemNames;
    }
    
    public String getPassword(Connection connection, String user) {
        Statement statement = null;
        try{
        	password ="";
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            
            
            String sqlCommand =
                    "SELECT password FROM users WHERE username = '"+user+"';";
            ResultSet resultSet = statement.executeQuery(sqlCommand);    
            while(resultSet.next()) {
            	password = resultSet.getString(1);
            }
            // statement.execute
            connection.commit();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        
        return password;
    }
    
    public boolean usernameWithPassword(Connection connection, String user) {
    	//using the username see if the password corresponding is correct
    	return true;
    }
}