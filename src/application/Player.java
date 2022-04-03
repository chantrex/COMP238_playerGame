package application;


import application.PlayerData;

//this class represents a Customer object
public class Player {
	//customer's properties
	
	private String playerID,firstName, lastName, address, city, province, postalCode;
	String record[] = new String[7]; //holds the data for the current record
	private PlayerData playerData = null;
	
	//no-argument constructor
	public Player() throws Exception{
		playerData = new PlayerData();
		// load the current record
		record=playerData.loadCurrentRecord("Select * from player");
		//populate the instance variables
		playerID = record[0];
		firstName=record[1];
		lastName = record[2];
		address=record[3];
		city=record[4];
		province = record[5];
		postalCode=record[6];
	}
	// 7-argument constructor
	public Player(String playerID, String firstName,String lastname, String address, String city, String province, String postalCode)
	{
		 this.playerID=playerID;
		 this.firstName=firstName;
		 this.lastName=firstName;
		 this.address=address;
		 this.city=city;
		 this.province=province;
		 this.postalCode=postalCode;
	}
	//setter and getter methods
	public String getPlayerID()
	{
		return playerID;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getAddress()
	{
		return address;
	}
	public String getCity()
	{
		return city;
	}
	public String getProvince()
	{
		return province;
	}
	public String getPostalCode()
	{
		return postalCode;
	}
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public void setProvince(String province)
	{
		this.province=province;
	}
	public void setPostalCode(String postalCode)
	{
		this.postalCode=postalCode;
	}
	//
	//Business methods for Player object
	//
	// - Navigational methods
	public String[] moveToNext()
	{
		 record=playerData.moveNext();
		 refreshPlayerData(record);
		 return record;
	}
	public String[] moveToLast()
	{
		 record=playerData.moveLast();
		 //refresh customer's data with current record's data
		 refreshPlayerData(record);
		 return record;
	}
	public String[] moveToPrevious()
	{
		 record=playerData.movePrevious();
		 refreshPlayerData(record);
		 return record;
	}
	public String[] moveToFirst()
	{
		 record=playerData.moveFirst();
		 refreshPlayerData(record);
		 return record;
	}
	// - database manipulation methods
	public void savePlayer(String[] row)
	{
		 refreshPlayerData(row);
		 playerData.saveRow(row);
	}
	public void updatePlayer(String[] row)
	{
		 refreshPlayerData(row);
		 playerData.updateRow(row);
	}
	public void deletePlayer()
	{
		playerData.deleteRow();
	}
	public void refreshPlayerData(String data[])
	{
		 this.playerID=data[0];
		 this.firstName=data[1];
		 this.lastName=data[2];
		 this.address=data[3];
		 this.city=data[4];
		 this.province=data[5];
		 this.postalCode=data[6];
	}

} // end of Player
