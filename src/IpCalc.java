package ipcalc;
/**
 * <h1>IPv4 address calculator</h1>
 * IpCalc is a useful command line tool to quickly
 * calculate network part and host part given
 * ip and subnet or CIDR. 
 * It can also print all IP addresses from a given
 * range. 
 *
 * Examples:
 * 		calculate network part and print number of hosts
 * 	$ ipcalc 192.168.2.0/24 
 *
 * 		print all hosts in a given network
 * 	$ ipcalc -pa 127.0.0-255.0-255 
 * 	$ ipcalc -pa 127.0.0.0-127.0.255.255
 * 	$ ipcalc -pa 127.0.0.0/16
 *
 * 		calculate network part and sub or supernet 
 * 	$ ipcalc 192.168.0.1 255.255.255.0 255.255.0.0
 * 	$ ipcalc 192.168.0.1/24/16
 *
 * Options:
 * 	-pa	--print-all
 * 			print all addresses from a given range
 *
 * 	-v --verbose
 * 			print binary representation
 *
 * 	-e --education
 * 			print info about IPv4 address space
 *
 * 	@author 	Wojtek Puchta
 *	@version	0.3 
 *	@since		2016-10-30
 */

public class IpCalc {

	static public int[] shifts = {24, 16, 8, 0};
	static public long getNetworkPart(long ip, long netMask) {
	/* @param ip, netMask 
	 * @return networkPart
	 */
		
		return ip & netMask;
	}

	static public long getHostPart(long ip, long netMask) {
	/* @param ip, netMask
	 * @return hostPart
	 */
		return ip ^ getNetworkPart(ip, netMask);
	}

	


	static public long subnetFromCidr(int cidr) {
	/* @param cidr = cidr integer, ex. 24
	 * @return subnet = subnet mas, ex. 4294967040
	 */
        long subnet = (1 << cidr) - 1; 
		return subnet << (32 - cidr); 
	}

	static public String ipAsString(long addr) {
	/* @param addr = ip address as Integer
	 * @return ipAddr = ip address as string (decimal dotted notation)
	 */
		String ipAddr = "";
		long mask;
		for (int i = 0; i < 4; i++) {
			mask = (long)Math.pow(2, shifts[i]+8) - 1;
			ipAddr +=  Long.toString((addr & mask) >> shifts[i]);
			if (i != 3) {
				ipAddr += ".";
			}
		}
		return ipAddr;
	}

	static public long ipAsInt(String addr) {

	/* @param addr in format "192.168.2.1"
	 * @return ip which is ip address as single long integer: 3232236033
	 */

		long partInt;
		long ip = 0;
		String[] parts = addr.split("\\.");
		for (int i = 0; i < 4; i++){
			partInt = Integer.valueOf(parts[i]);
			ip += partInt << shifts[i];
			}
		return ip;
		} 
	public static void main(String[] args) {
	/*
	 *
	 *
	
	String ipStr = "192.168.2.1";
	String netMaskStr = "255.255.255.0";
	long ip = ipAsInt(ipStr);	
	long netMask = ipAsInt(netMaskStr);
	System.out.println(ipAsString(getNetworkPart(ip, netMask)));
	System.out.println(ipAsString(getHostPart(ip, netMask)));
	System.out.println(ipAsString(netMask));
	*/	
	}

}
