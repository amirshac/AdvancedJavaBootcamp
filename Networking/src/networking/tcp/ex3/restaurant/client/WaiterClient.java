package networking.tcp.ex3.restaurant.client;

import java.util.Random;

import com.google.gson.Gson;

import networking.tcp.TcpClient.TcpClient;
import networking.tcp.ex3.restaurant.server.DishDB;
import networking.tcp.ex3.restaurant.server.DishName;
import networking.tcp.ex3.restaurant.server.Order;
import networking.tcp.ex3.restaurant.server.OrderPrice;

public class WaiterClient extends TcpClient{

	protected Order order;
	protected OrderPrice orderPrice;
	protected Gson gson;

	
	public WaiterClient(String serverName, int serverPort) {
		super(serverName, serverPort);
		gson = new Gson();
	}
	
	public WaiterClient() {
		super();
		gson = new Gson();
	}
	
	protected void generateRandomOrder() {
		Random random = new Random();
		int numberOfDishes = random.nextInt(1, 4);
		
		order = new Order();
		for (int i=0; i<numberOfDishes; i++)
			order.addDish(DishDB.getRandomDish());
	}
	
	protected void sendOrder() {
		String jsonOrderString = gson.toJson(order);
		sendLineToServer(jsonOrderString);
	}
	
	protected void getResponseFromServer() {
		String response = getLineFromServer();
		System.out.println(response);
		orderPrice = gson.fromJson(response, OrderPrice.class);
		System.out.println(orderPrice);
	}
	
	public void go() {
		generateRandomOrder();
		startClient();
		sendOrder();
		getResponseFromServer();
		closeConnections();
	}

}
