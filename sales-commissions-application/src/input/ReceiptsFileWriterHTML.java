package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReceiptsFileWriterHTML  extends ReceiptsFileWriter
{
	private Document doc;
	
	public  void setFileToAppend(File fileToAppend) 
	{	
		this.fileToAppend = fileToAppend;	
	}

	public void openFile() throws IOException
	{
		doc = Jsoup.parse(fileToAppend);
	}

	public void writeData() throws IOException
	{
		
		Element body = doc.select("body").first();
		
		Element divElem = doc.createElement("div");
		body.appendChild(divElem);
		
		Element p1Elem = doc.createElement("p");
	   	divElem.appendChild(p1Elem);
	   	Element b1Elem = doc.createElement("b").text("ReceiptID: ");
	   	p1Elem.appendChild(b1Elem);
		p1Elem.append(Integer.toString(receipt.getReceiptID()));
		
		Element p2Elem = doc.createElement("p");
	   	divElem.appendChild(p2Elem);
	   	Element b2Elem = doc.createElement("b").text("Date: ");
	   	p2Elem.appendChild(b2Elem);
		p2Elem.append(receipt.getDate());
		
		Element p3Elem = doc.createElement("p");
	   	divElem.appendChild(p3Elem);
	   	Element b3Elem = doc.createElement("b").text("Kind: ");
	   	p3Elem.appendChild(b3Elem);
		p3Elem.append(receipt.getKind());
		
		Element p4Elem = doc.createElement("p");
	   	divElem.appendChild(p4Elem);
	   	Element b4Elem = doc.createElement("b").text("Sales: ");
	   	p4Elem.appendChild(b4Elem);
		p4Elem.append(Double.toString(receipt.getSales()));
		
		Element p5Elem = doc.createElement("p");
	   	divElem.appendChild(p5Elem);
	   	Element b5Elem = doc.createElement("b").text("Items: ");
	   	p5Elem.appendChild(b5Elem);
		p5Elem.append(Integer.toString(receipt.getItems()));
	
		Element p6Elem = doc.createElement("p");
	   	divElem.appendChild(p6Elem);
	   	Element b6Elem = doc.createElement("b").text("Company: ");
	   	p6Elem.appendChild(b6Elem);
		p6Elem.append(receipt.getCompany().getName());
		
		Element p7Elem = doc.createElement("p");
	   	divElem.appendChild(p7Elem);
	   	Element b7Elem = doc.createElement("b").text("Country: ");
	   	p7Elem.appendChild(b7Elem);
		p7Elem.append(receipt.getCompany().getCompanyAddress().getCountry());
		
		Element p8Elem = doc.createElement("p");
	   	divElem.appendChild(p8Elem);
	   	Element b8Elem = doc.createElement("b").text("City: ");
	   	p8Elem.appendChild(b8Elem);
		p8Elem.append(receipt.getCompany().getCompanyAddress().getCity());
		
		Element p9Elem = doc.createElement("p");
	   	divElem.appendChild(p9Elem);
	   	Element b9Elem = doc.createElement("b").text("Street: ");
	   	p9Elem.appendChild(b9Elem);
		p9Elem.append(receipt.getCompany().getCompanyAddress().getStreet());
		
		Element p10Elem = doc.createElement("p");
	   	divElem.appendChild(p10Elem);
	   	Element b10Elem = doc.createElement("b").text("Number: ");
	   	p10Elem.appendChild(b10Elem);
		p10Elem.append(Integer.toString(receipt.getCompany().getCompanyAddress().getStreetNumber()));
		
	}

	public void closeFile() throws IOException  
	{
		FileWriter writer = new FileWriter(fileToAppend);
        writer.write(doc.outerHtml());
        writer.close();
	}


}
