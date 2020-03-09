import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;


public class TrManagerTest {

	
	@Test
	public void getAveragePackageVolume() {
		TrManager t = new TrManager();
		
		t.registerPacket("1", 1);
		t.registerPacket("1", 3);
		t.registerPacket("1", 5);
		
		double expectedAgv = 3.0;
		
		assertEquals(expectedAgv, t.getAveragePackageVolume(), 0.01);			
		
	}
	
	@Test
	public void getAveragePackageVolumeByTruckId() {
		
				
		TrManager tm = new TrManager();
		Truck t = tm.registerTruck("aaa", 12);
		
		Packet p = new Packet("111", 1);
		Packet p1 = new Packet("222", 2);
		Packet p2 = new Packet("333", 3);
		
		tm.assignTruck(t, p);
		tm.assignTruck(t, p1);
		tm.assignTruck(t, p2);
		double avgById = 2;
		
		assertEquals(avgById, tm.getAveragePackageVolumeByTruckId("aaa"), 0.01);
		
	}
	
	@Test
	public void getMaxPackageVolume() {
		TrManager t = new TrManager();
		
		t.registerPacket("1", 1);
		t.registerPacket("1", 3);
		t.registerPacket("1", 5);
		
		double max = 5.0;
		
		assertEquals(max, t.getMaxPackageVolume(), 0.01);
		
	}
	
	@Test
	public void getMinPackageVolume() {
		TrManager t = new TrManager();
		
		t.registerPacket("1", 1);
		t.registerPacket("1", 3);
		t.registerPacket("1", 5);
		
		double min = 1.0;
		
		assertEquals(min, t.getMinPackageVolume(), 0.01);
		
	}

}
