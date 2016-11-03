/**
 * Usage: 
 * 	ipcalc [OPTIONS] ip_addr subntmsk - print all addr in a subnet given subnet mask, ex 192.168.2.0 255.255.255.0
 * 	ipcalc [OPTIONS] ip_addr/CIDR - print all addr in a network specified by CIDR, ex. 192.168.2.0/24
 *
 */

import java.util.Arrays;

public class iplc {
	public long ip;
	public long subnet;

	public IpCalc(long addr, long subn) {
		ip = addr;
		subnet = subn;
	}

	public void getNetworkRangeFromList(int[] ips) {
		for (ip : ips){
			System.out.println(ip);
	}

	public long getNetworkFromCidr(long ip, int cidr){
		return 10;
		
	}

	public long getNetwork(long ip, long subnet) {

	}

	public long getHost(long ip, long subnet) {

	}

	private long cidrSum(long cidr) {

	}

	
	static private long ipAsInt (String addr){
		long partInt;
		String[] parts = addr.split("\\.");
		int[] shifts = {24, 16, 8, 0};
		for (int i = 0; i < 4; i++){
			partInt = Integer.valueOf(parts[i]);
			ip += partInt << shifts[i];
			}
		return ip
		}
	
	static private long[] resolveCidr(String addr_rng){
		long[] ret = {0};
		return ret;
	}

	static private void resolveRangeRange(String addr_rng) {
		
	}


	static private String resolveRangeRange(String prefix, int min, int max) {
		String newPrefix;
		newPrefix = prefix + Integer.valueOf(min) + '.';
		if (min <= max) {
			suffix = resolveRangeRange(newPrefix, min+1, max);
			return resolveRangeRange(newPrefix) 
		}
		else {
		}

	}
	
	static private String resolveRangeRange(int[] ranges
		


	static private long[]  resolveRangeRange(String addr_rng) {
		String[] parts = addr_rng.split("\\.");
		String[] ranges = new String[4];
		int[] rangeInt = new int[4];
		int rangeMin;
		int rangeMax;
		int[][] intRanges = new int[4][2];
		for (int i = 0; i < 4; i++) {
			ranges[i] = parts.split("-");
			rangeMin = ranges[i][0] + 1;
			rangeMax = ranges[i][1 % ranges[i].length];
		}
	}

	static private long[] resolveSubnet(String add_rng) {
		long[] ret = {0};
		return ret;
	}



	public static void main( String[] args ){
		String ipAddr = "192.168.2.1";
		IpCalc IpCalc = new ipcalc(ipAddr);
		System.out.println(IpCalc.ip);

	
	}
}









