package input;

import java.io.File;

import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class HTMLInput extends Input 
{

	private Document doc;
	 
	public HTMLInput(File receiptFileHTML ){
		inputFile = receiptFileHTML;
		
	}

	protected void openFile() 
	{
    	try 
    	{
			doc = Jsoup.parse(inputFile);

		} 
    	catch (Exception e) {
        	JOptionPane.showMessageDialog
			(null,"Παρουσιαστηκε σφάλμα κατα την προσπέλαση του αρχείου."); 
		}
		
	}

	protected void readData()
	{
        Elements nodeLst = doc.select("body");
		  
        
    	name =  nodeLst.first().select("h2").text().trim().replace("Name: ", "");
    	afm = nodeLst.first().select("h4").text().trim().replace("AFM: ", "");
    	addAgent();

    	Elements receiptsNodeList = nodeLst.first().select("div");
    	
        int size = receiptsNodeList.size();
        for(int i=0; i<size; i++)
        {
        	
        	Elements receiptValuesNodes = receiptsNodeList.get(i).getElementsByTag("p"); 
        	
        	receiptID = Integer.parseInt(receiptValuesNodes.get(0).text().trim().replace("ReceiptID: ", ""));
        	
        	date = receiptValuesNodes.get(1).text().trim().replace("Date: ", "");
        	
        	kind = receiptValuesNodes.get(2).text().trim().replace("Kind: ", "");
        	
        	sales = Double.parseDouble( receiptValuesNodes.get(3).text().trim().replace("Sales: ", ""));
        		
        	items = Integer.parseInt(receiptValuesNodes.get(4).text().trim().replace("Items: ", ""));
        		
        	companyName = receiptValuesNodes.get(5).text().trim().replace("Company: ", "");
        	
        	companyCountry = receiptValuesNodes.get(6).text().trim().replace("Country: ", "");
        	
        	companyCity = receiptValuesNodes.get(7).text().trim().replace("City: ", "");
        	
        	companyStreet = receiptValuesNodes.get(8).text().trim().replace("Street: ", "");
        	
        	companyStreetNumber =Integer.parseInt( receiptValuesNodes.get(9).text().trim().replace("Number: ", ""));
        	
        	addReceipt();
        	
        }
        
	}
	
	protected void closeFile() {
		
	}
	

}
