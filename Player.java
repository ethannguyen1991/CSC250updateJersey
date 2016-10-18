public class Player
{
	
	private int jersey_number;
	private int rating;
	

	Player(int jerseyNumber, int rating)
	{
		this.jersey_number = jerseyNumber;
		this.rating = rating;
	}
	
	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating) 
	{
		if(rating >= 0)
		{
			this.rating = rating;
		}
	}

	public int getJerseyNumber() 
	{
		return jersey_number;
	}

	
	
}