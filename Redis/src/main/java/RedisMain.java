import redis.clients.jedis.Jedis;

/**
 * Created by hatim.lokhandwala on 31/07/19.
 */
public class RedisMain {


	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("connected to redis");
		System.out.println("Ping reply from jedis " + jedis.ping());
		jedis.set("company", "flipkart");
		System.out.println(jedis.get("company"));

	}
}
