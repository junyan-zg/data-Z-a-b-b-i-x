
public class ZabbixJavaRedisInfo {
	
	public static void main(String[] args) {
		try{
			if (args.length == 1 || "".equals(args[1])) {
				args = new String[]{"6379",args[0]};
			}
			String host = " -h 127.0.0.1 ";
			String port = "-p " + args[0];
			String commandStr = "D:\\redis\\redis-cli.exe" + host + port + " info";
			switch (args[1]) {
			case "version":
				print(ZabbixJavaCmd.exeCmd(commandStr),"redis_version");
				break;
			case "uptime":
				print(ZabbixJavaCmd.exeCmd(commandStr),"uptime_in_seconds");
				break;
			case "connected_clients":
				print(ZabbixJavaCmd.exeCmd(commandStr),"connected_clients");
				break;
			case "used_memory":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_memory");
				break;
			case "used_memory_rss":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_memory_rss");
				break;
			case "used_memory_peak":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_memory_peak");
				break;
			case "used_memory_lua":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_memory_lua");
				break;
			case "used_cpu_sys":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_cpu_sys");
				break;
			case "used_cpu_user":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_cpu_user");
				break;
			case "used_cpu_sys_children":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_cpu_sys_children");
				break;
			case "used_cpu_user_children":
				print(ZabbixJavaCmd.exeCmd(commandStr),"used_cpu_user_children");
				break;
			case "rdb_last_bgsave_status":
				System.out.println(getValue(ZabbixJavaCmd.exeCmd(commandStr),"rdb_last_bgsave_status").indexOf("ok") != -1 ? 1 : 0);
				break;
			case "aof_last_bgrewrite_status":
				System.out.println(getValue(ZabbixJavaCmd.exeCmd(commandStr),"aof_last_bgrewrite_status").indexOf("ok") != -1 ? 1 : 0);
				break;
			case "aof_last_write_status":
				System.out.println(getValue(ZabbixJavaCmd.exeCmd(commandStr),"aof_last_write_status").indexOf("ok") != -1 ? 1 : 0);
				break;
			case "expires":
				System.out.println(getValue(ZabbixJavaCmd.exeCmd(commandStr),"db0").split(",")[1].split("=")[1]);
				break;
			case "avg_ttl":
				System.out.println(getValue(ZabbixJavaCmd.exeCmd(commandStr),"db0").split(",")[2].split("=")[1]);
				break;
			}
		}catch(Exception e){}
	}
	
	public static void print(String str,String index){
		String[] split = str.split("\n");
		for (String target : split) {
			if (target.contains(index)) {
				System.out.println(target.split(":")[1]);
				return;
			}
		}
	}
	public static String getValue(String str,String index){
		String[] split = str.split("\n");
		for (String target : split) {
			if (target.contains(index)) {
				return target.split(":")[1];
			}
		}
		return "";
	}
}