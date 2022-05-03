package javabootcamp.oop.abstraction;
import java.time.LocalTime;

public interface Appliable {
	// methods
	public LocalTime turnOn();
	public long turnOffSec(LocalTime on);
}
