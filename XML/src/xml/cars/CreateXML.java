package xml.cars;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateXML {
	
	private static final String FILENAME = "myFiles/cars.xml";
	protected static List<Car> cars = new ArrayList<Car>();
	protected static List<Element> elements = new ArrayList<Element>();
	
	protected static void generateCarList() {
		cars.add(new Car("Lotus", "Esprit", 1958, new Plate(Color.YELLOW)));
		cars.add(new Car("Toyota", "Supra", 1932, new Plate(Color.GREEN)));
		cars.add(new Car("Pontiac", "Trans Am", 1981, new Plate(Color.WHITE)));
		cars.add(new Car("DeLorean", "DMC-12", 1985, new Plate(Color.WHITE)));
	}
	
	protected static void saveListToXML() {
		// root element
		Element carsRootElement = new Element("cars");
		Document document = new Document(carsRootElement);
		
		Element carElement;
		Element manufacturerElement;
		Element modelElement;
		Element yearElement;
		Element plateElement;
		Element plateNumberElement;
		Element plateColorElement;
		
		Car car;
		
		for (int i=0; i<cars.size(); i++) {
			car = cars.get(i);
			carElement = new Element("car");
			
			manufacturerElement = new Element("manufacturer");
			manufacturerElement.setText(car.manufacturer);
			modelElement = new Element("model");
			modelElement.setText(car.model);
			yearElement = new Element("year");
			yearElement.setText(String.format("%d",car.year));
			
			// <plate>
			plateElement = new Element("plate");
			plateNumberElement = new Element("platenumber");
			plateNumberElement.setText(String.format("%d",car.plate.number));
			plateColorElement = new Element("platecolor");
			plateColorElement.setText(car.plate.color.toString());
			
			plateElement.setAttribute(new Attribute("type", "unique"));
			plateElement.addContent(plateNumberElement);
			plateElement.addContent(plateColorElement);
			// </plate>
			
			carElement.addContent(manufacturerElement);
			carElement.addContent(modelElement);
			carElement.addContent(yearElement);
			carElement.addContent(plateElement);
			
			document.getRootElement().addContent(carElement);
		}
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		
		try {
			File outputFile = new File(FILENAME);
			OutputStream outputStream = new FileOutputStream(outputFile);
			xmlOutput.output(document, outputStream);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void run() {
		generateCarList();
		saveListToXML();
	}
}
