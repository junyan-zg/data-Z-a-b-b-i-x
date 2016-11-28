public class ZabbixJavaMySQLStatus {

	public static void main(String[] args) {
		try{
			// String commandStr = "ipconfig";
			String commandStr = "mysqladmin -uroot -proot ";
			switch (args[0]) {
			case "Uptime":
				commandStr += "status";
				System.out.println(ZabbixJavaCmd.exeCmd(commandStr).split(":")[1].split("T")[0]);
				break;
			case "Com_update":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_update");
				break;
			case "Slow_queries":
				commandStr += "status";
				System.out.println(ZabbixJavaCmd.exeCmd(commandStr).split(":")[4].split("O")[0]);
				break;
			case "Com_select":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_select");
				break;
			case "Com_rollback":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_rollback");
				break;
			case "Questions":
				commandStr += "status";
				System.out.println(ZabbixJavaCmd.exeCmd(commandStr).split(":")[3].split("S")[0]);
				break;
			case "Com_insert":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_insert");
				break;
			case "Com_delete":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_delete");
				break;
			case "Com_commit":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_commit");
				break;
			case "Bytes_sent":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Bytes_sent");
				break;
			case "Bytes_received":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Bytes_received");
				break;
			case "Com_begin":
				commandStr += "extended-status";
				print(ZabbixJavaCmd.exeCmd(commandStr),"Com_begin");
				break;
			}
		}catch(Exception e){}

	}
	public static void print(String str,String index){
		String[] split = str.split("\n");
		for (String target : split) {
			if (target.contains(index)) {
				System.out.println(target.split("\\|")[2]);
				return;
			}
		}
	}
}
