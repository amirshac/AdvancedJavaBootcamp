package networking.tcp.ex3.restaurant.server;

import com.google.gson.Gson;

import networking.tcp.TcpServer.TcpServer;

public class RegisterServer extends TcpServer {
	
	Gson gson;
	
	public RegisterServer() {
		super();
		gson = new Gson();
	}
	
	public RegisterServer(int port) {
		super(port);
		gson = new Gson();
	}
	
	@Override
	public void go() {
		while (serverActive) {
			waitForConnection();
			String orderJsonString = getLineFromClient();
			Order order = gson.fromJson(orderJsonString, Order.class);
			
			System.out.println("Server got order>");
			System.out.println(order);
			
			OrderPrice orderPrice = new OrderPrice(calculateOrderPrice(order)); 
			String orderPriceJsonString = gson.toJson(orderPrice);
			System.out.println("Server sends price>" + orderPrice);
			sendLineToClient(orderPriceJsonString);
		}
	}
	
	protected double calculateOrderPrice(Order order) {
		double sum = 0.0;
		sum = order.getDishes().stream().map(dish->dish.getPrice()).reduce(0.0, (a,b) -> a+b);
		return sum;
	}

}
