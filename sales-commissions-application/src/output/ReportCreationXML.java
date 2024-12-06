package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.AgentSalesAccount;

public class ReportCreationXML extends ReportCreation{

	private Document document;
	
	public ReportCreationXML(AgentSalesAccount a, File reportFileXML){
			agent = a;
			reportFile = reportFileXML;
	}	
		
	protected void createFile() 
	{
		try
		{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
   	 		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
   	 		document = documentBuilder.newDocument();
		}
		catch (Exception ex) 
		{
            ex.printStackTrace();
        }
	}

	protected void writeFile() 
	{
		 try
		 {
			 Element agentElem = document.createElement("Agent");
		   	 document.appendChild(agentElem);
		   	 
		   
		   	 Element name = document.createElement("Name");
		   	 name.appendChild(document.createTextNode(agent.getName()));
		   	 agentElem.appendChild(name);
		   	 
		   	 Element afm = document.createElement("AFM");
		   	 afm.appendChild(document.createTextNode(agent.getAfm()));	
		   	 agentElem.appendChild(afm);
		   	 
		   	 Element totalSales = document.createElement("TotalSales");
		   	 totalSales.appendChild(document.createTextNode(Double.toString(agent.calculateTotalSales())));
		   	 agentElem.appendChild(totalSales);
		   	 
		   	 Element trouserSales = document.createElement("TrouserSales");
		   	 trouserSales.appendChild(document.createTextNode(Float.toString(agent.calculateSpecificKindSales("Trousers"))));
		   	 agentElem.appendChild(trouserSales);
		   	 
		   	 Element skirtsSales = document.createElement("SkirtsSales");
		   	 skirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateSpecificKindSales("Skirts"))));
		   	 agentElem.appendChild(skirtsSales);
		   	 
		   	 Element shirtsSales = document.createElement("ShirtsSales");
		   	 shirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateSpecificKindSales("Shirts"))));
		   	 agentElem.appendChild(shirtsSales);
		   	 
		   	 Element coatsSales = document.createElement("CoatsSales");
		   	 coatsSales.appendChild(document.createTextNode(Float.toString(agent.calculateSpecificKindSales("Coats"))));
		   	 agentElem.appendChild(coatsSales);
		   	 
		   	 Element commission = document.createElement("Commission");
		   	 commission.appendChild(document.createTextNode(Double.toString(agent.calculateCommission())));
		   	 agentElem.appendChild(commission);

		   	 		   	
		 	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer = transformerFactory.newTransformer();
			 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			 DOMSource domSource = new DOMSource(document);
			 StreamResult streamResult = new StreamResult(reportFile);
			 transformer.transform(domSource, streamResult);
		 }
		 catch (Exception ex) 
		 {
			 ex.printStackTrace();
	     }
		 
	 
	}
	
	protected void closeFile() {
		
	}

}

