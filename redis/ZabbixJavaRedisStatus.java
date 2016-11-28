
public class ZabbixJavaRedisStatus {
	
	public static void main(String[] args) {
		try{
			if (args.length == 0 || "".equals(args[0])) {
				args = new String[]{"6379"};
			}
			String host = " -h 127.0.0.1 ";
			String port = "-p " + args[0];
			String commandStr = "D:\\redis\\redis-cli.exe" + host + port + " ping";
			System.out.println(ZabbixJavaCmd.exeCmd(commandStr).indexOf("PONG") != -1 ? 1 : 0);
		}catch(Exception e){}
	}
}