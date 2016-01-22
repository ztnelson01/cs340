package server;

/**
 * 
 * Polls the ServerInterface to check for updated game model
 *
 */
public class ServerPoller {
	/**
	 * proxy server the poller polls for new information
	 */
	private ServerInterface server;
	
	public ServerPoller(ServerInterface server){
		this.server = server;
	};
	/**
	 * Allows you to change between ServerProxy and MockServerProxy for testing
	 * @param server
	 */
	public void setServer(ServerInterface server){
		this.server = server;
		return;
	};
	/**
	 * Polls the server for updates in game model, if update is found, poller will update game model
	 * @parm versionID ID of current version of client game model
	 */
	public void poll(int versionID){
		return;
	};
}
