import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;
import lt.itakademija.exam.TruckManager;

public class TrManager implements TruckManager{
	
	private List<Truck> trucks = new ArrayList<>();
	private List<Packet> packets = new ArrayList<>();

	@Override
	public void assignTruck(Truck truck, Packet packet) {
		
		packet.assignTruck(truck);
	}

	@Override
	public List<Packet> getPackets(String truckId) {
		
		return getTruckById(truckId).getPackets();
	}

	@Override
	public int getTotalTruckCapacity() {

		return trucks.stream()
				     .mapToInt(Truck::getCapacity)
		             .sum();
	}

	@Override
	public Truck getTruckById(String id) {
		
		return trucks.stream()
					 .filter(p -> p.getId().equals(id))
					 .findAny()
					 .orElse(null);
	}

	@Override
	public List<Truck> getTrucks() {
		
		return trucks;
	}

	@Override
	public Packet registerPacket(String id, int volume) {
		
		if(id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if(volume <= 0) {
			throw new IllegalArgumentException();
		}
		
		Packet p = new Packet(id, volume);
		packets.add(p);
		return p;
	}

	@Override
	public Truck registerTruck(String id, int capacity) {
		
		if(id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if(capacity <= 0) {
			throw new IllegalArgumentException();
		}
		
		Truck t = new Truck(id,capacity);
		trucks.add(t);
		
		return t;
	}


	public double getAveragePackageVolume() {
		
		return  packets.stream()
		               .collect(Collectors.averagingDouble(p -> p.getVolume()));
	}
	
	public double getAveragePackageVolumeByTruckId(String truckId) {

		
		return getPackets(truckId).stream()
								  .mapToDouble(Packet::getVolume)
								  .average()
								  .orElse(0.0);	 
	}
	
	public double getMaxPackageVolume() {
		
		return packets.stream()
				      .mapToDouble(Packet::getVolume)
				      .max()
				      .getAsDouble();
	}
	
	
	public double getMinPackageVolume() {

		return packets.stream()
				      .mapToDouble(Packet::getVolume)
				      .min()
				      .getAsDouble();
	}
}
