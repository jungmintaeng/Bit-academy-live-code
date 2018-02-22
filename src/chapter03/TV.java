package chapter03;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	/**
	 * Constructor
	 */
	public TV() {
		
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = (channel <= 255 && channel >= 1)? channel : 1;
		this.volume = (volume <= 100 && volume >= 0)? volume : 0;
		this.power = power;
	}
	
	/**
	 * getter
	 */
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public boolean isPower() {
		return power;
	}
	
	/**
	 * methods
	 */
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(channel < 1 || channel > 255)
			return;
		this.channel = channel;
	}
	
	public void channel(boolean up) {
		if(up & channel < 255) {
			channel++;
		}else if(!up & channel > 1) {
			channel--;
		}
	}
	
	public void volume(int volume) {
		if(volume < 0 || volume > 100)
			return;
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		if(up & volume < 100) {
			volume++;
		}else if(!up && volume > 0) {
			volume--;
		}
	}
	
	public void status() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "TV [channel=" + channel + ", volume=" + volume + ", power=" + (power?"ON":"OFF") + "]";
	}
}
