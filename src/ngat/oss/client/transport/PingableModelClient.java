package ngat.oss.client.transport;

public interface PingableModelClient {
	
	public void ping() throws Exception;;
	public String getURLOfService() throws Exception;
	
}
