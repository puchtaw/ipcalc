package ipcalc;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class IpCalcTest {
    private IpCalc IPcalc;

    @BeforeClass
    static public void startTest() {
        System.out.println("Starting test...");
    }

    @Before
    public void setUp() {
	    IpCalc IPcalc = new IpCalc();
    }

    @Test
    public void getNetworkPartReturnsCorrectValue0() {
        long ip = IPcalc.ipAsInt("192.168.2.1");
        long netMask = IPcalc.ipAsInt("255.255.255.0");
        long expected = IPcalc.ipAsInt("192.168.2.0");
        long networkPart = IPcalc.getNetworkPart(ip, netMask);

        
        assertEquals(expected, networkPart);
    }

    @Test
    public void getNetworkPartReturnsCorrectValue1() {
        long ip = IPcalc.ipAsInt("192.168.0.1");
        long netMask = IPcalc.ipAsInt("255.255.255.0");
        long expected = IPcalc.ipAsInt("192.168.0.0");
        long networkPart = IPcalc.getNetworkPart(ip, netMask);
        assertEquals(expected, networkPart);
    }

    @Test 
    public void getNetworkPartReturnsCorrectValue2() {
        long ip = IPcalc.ipAsInt("192.168.0.1");
        long netMask = IPcalc.subnetFromCidr(16);
        long expected = IPcalc.ipAsInt("192.168.0.0");
        long networkPart = IPcalc.getNetworkPart(ip, netMask);
        assertEquals(expected, networkPart);
    }

	@Test
	public void ipAsIntReturnsCorrectValue0() {
		long ipasint = IPcalc.ipAsInt("192.168.2.1");    
		long expected = 3232236033L;
		assertEquals(expected, ipasint);
	}

	@Test
	public void ipAsIntReturnsCorrectValue1() {
		long ipasint = IPcalc.ipAsInt("255.255.255.255");    
		long expected = 4294967295L;
		assertEquals(expected, ipasint);
	}

    @Test
    public void ipAsStringReturnsCorrectValue2() {
        String ipasstring = IPcalc.ipAsString(3232236033L);
        String expected = "192.168.2.1";
        assertEquals(expected, ipasstring);
        
    }

    @Test
    public void ipAsStringReturnsCorrectValue3() {
        String ipasstring = IPcalc.ipAsString(0L);
        String expected = "0.0.0.0";
        assertEquals(expected, ipasstring);
    }


    @Test
    public void subnetFromCidrReturnsCorrectValue0() {
        long subnet = IPcalc.subnetFromCidr(24);
        long expected = IPcalc.ipAsInt("255.255.255.0");
        assertEquals(expected, subnet);
    }

    @Test
    public void subnetFromCidrReturnsCorrectValue1() {
        long subnet = IPcalc.subnetFromCidr(16);
        long expected = IPcalc.ipAsInt("255.255.0.0");
        assertEquals(expected, subnet);
    }

    @Test
    public void subnetFromCidrReturnsCorrectValue2() {
        long subnet = IPcalc.subnetFromCidr(11);
        long expected = IPcalc.ipAsInt("255.224.0.0");
        assertEquals(expected, subnet);
    }

}
