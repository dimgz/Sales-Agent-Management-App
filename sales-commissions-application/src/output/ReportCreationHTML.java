package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import data.AgentSalesAccount;


public class ReportCreationHTML extends ReportCreation{

	private Document document;
	
	public ReportCreationHTML(AgentSalesAccount a, File reportFileHTML){
			agent = a;
			reportFile = reportFileHTML;
	}	
		
	protected void createFile() 
	{
		try
		{
			document = new Document("html");
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
			 Element htmlElem = document.createElement("html");
			 document.appendChild(htmlElem);
			
			 document.append("<style>\r\n"
			 		+ "    body {\r\n"
			 		+ "      font-family: Arial, sans-serif;\r\n"
			 		+ "      background-color: #f4f4f4;\r\n"
			 		+ "      margin: 20px;\r\n"
			 		+ "    }\r\n"
			 		+ "\r\n"
			 		+ "	h1 {\r\n"
			 		+ "	  text-align: center;\r\n"
			 		+ "	}\r\n"
			 		+ "	\r\n"
			 		+ "    h2 {\r\n"
			 		+ "      color: rgb(0, 128, 192);\r\n"
			 		+ "      text-align: center;\r\n"
			 		+ "    }\r\n"
			 		+ "\r\n"
			 		+ "    h4 {\r\n"
			 		+ "      color: rgb(0, 128, 192);\r\n"
			 		+ "      text-align: center;\r\n"
			 		+ "    }\r\n"
			 		+ "    \r\n"
			 		+ "    b{\r\n"
			 		+ "    	color: rgb(0, 128, 192);\r\n"
			 		+ "    }\r\n"
			 		+ "    \r\n"
			 		+ "    div{\r\n"
			 		+ "    background-color: rgb(192, 192, 192);\r\n"
			 		+ "    padding: 10px;\r\n"
			 		+ "    margin-bottom: 20px;\r\n"
			 		+ "    border-radius: 20px;     \r\n"
			 		+ "    }\r\n"
			 		+ "\r\n"
			 		+ "  </style>");
			 
		   	 Element bodyElem = document.createElement("body");
		   	 htmlElem.appendChild(bodyElem);
		   	 
		   	 Element h1Elem = document.createElement("h1");
		   	 h1Elem.text("Report");
		   	 bodyElem.appendChild(h1Elem);
		   	 
		   	 Element h2Elem = document.createElement("h2");
		   	 bodyElem.appendChild(h2Elem);
		   	 Element b1Elem = document.createElement("b");
		   	 h2Elem.appendChild(b1Elem);
		   	 b1Elem.text("Name: ");
		   	 h2Elem.append(agent.getName());
		   	 
		   	 Element h4Elem = document.createElement("h4");
		   	 bodyElem.appendChild(h4Elem);
		   	 Element b2Elem = document.createElement("b");
		   	 h4Elem.appendChild(b2Elem);
		   	 b2Elem.text("AFM: ");
		   	 h4Elem.append(agent.getAfm());
		   	 
		   	 Element hrElem = document.createElement("hr");
		   	 bodyElem.appendChild(hrElem);
		   	 
		   	 Element divElem = document.createElement("div");
		   	 bodyElem.appendChild(divElem);
		   	 
		   	 Element p1Elem = document.createElement("p");
		   	 divElem.appendChild(p1Elem);
		   	 Element b3Elem = document.createElement("b");
		   	 p1Elem.appendChild(b3Elem);
		   	 b3Elem.text("Total Sales: ");
		   	 p1Elem.append(Double.toString(agent.calculateTotalSales()));
		   	 
		   	 Element p2Elem = document.createElement("p");
		   	 divElem.appendChild(p2Elem);
		   	 Element b4Elem = document.createElement("b");
		   	 p2Elem.appendChild(b4Elem);
		   	 b4Elem.text("Trouser Sales: ");
		   	 p2Elem.append(Float.toString(agent.calculateSpecificKindSales("Trousers")));
		   	 
		   	 Element p3Elem = document.createElement("p");
		   	 divElem.appendChild(p3Elem);
		   	 Element b5Elem = document.createElement("b");
		   	 p3Elem.appendChild(b5Elem);		   	
		   	 b5Elem.text("Skirt Sales: ");
		   	 p3Elem.append(Float.toString(agent.calculateSpecificKindSales("Skirts")));
		   	 
		   	 Element p4Elem = document.createElement("p");
		   	 divElem.appendChild(p4Elem);
		   	 Element b6Elem = document.createElement("b");
		   	 p4Elem.appendChild(b6Elem);		   	 
		   	 b6Elem.text("Shirt Sales: ");
		   	 p4Elem.append(Float.toString(agent.calculateSpecificKindSales("Shirts")));
		   	 
		   	 Element p5Elem = document.createElement("p");
		   	 divElem.appendChild(p5Elem);
		   	 Element b7Elem = document.createElement("b");
		   	 p5Elem.appendChild(b7Elem);		   	 
		   	 b7Elem.text("Coat Sales: ");
		   	 p5Elem.append(Float.toString(agent.calculateSpecificKindSales("Coats")));
		   	 
		   	 Element p6Elem = document.createElement("p");
		   	 divElem.appendChild(p6Elem);
		   	 Element b8Elem = document.createElement("b");
		   	 p6Elem.appendChild(b8Elem);		   	 
		   	 b8Elem.text("Commission: ");
		   	 p6Elem.append(Double.toString(agent.calculateCommission()));
		   	 
		   	 	 
		 }
		 catch (Exception ex) 
		 {
			 ex.printStackTrace();
	     }
		 
	 
	}
	
	protected void closeFile() throws IOException 
	{
		FileWriter writer = new FileWriter(reportFile);
	   	writer.write(document.outerHtml());
	    writer.close();
	}

}

