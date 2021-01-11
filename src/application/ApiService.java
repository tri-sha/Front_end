package application;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiService {

	@GET("/get-users")
    	Call<List<User>> getallusers();
	
	
}
