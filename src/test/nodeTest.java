package test;

import java.io.FileWriter;



import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
public class nodeTest {
	Document doc = null;
	public void loadDocument(){
		SAXReader saxReader= new SAXReader();
		try {
			doc = saxReader.read("src/收藏信息.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveXML(String path){
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(new FileWriter(path));
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showInfo(){
		Element root = doc.getRootElement();
		Iterator itBrand = root.elementIterator();
		while(itBrand.hasNext()){
			Element brandEle = (Element)itBrand.next();
			String brandStr = brandEle.attributeValue("name");
			Iterator itType = brandEle.elementIterator();
			while(itType.hasNext()){
				Element typeEle = (Element)itType.next();
				String typeStr = typeEle.attributeValue("name");
				System.out.println("手机品牌："+brandStr+"\n型号:"+typeStr);
			}
		}
	}
	public void addPhoneInfo(){
		Element root = doc.getRootElement();
		Element brandEle = root.addElement("Brand");
		brandEle.addAttribute("name","三星");
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name","NOTE4");
		this.saveXML("新的收藏信息.xml");
	}
	public void modifyPhoneInfo(){
		Element root = doc.getRootElement();
		int id=0;
		Iterator itBrand = root.elementIterator();
		while(itBrand.hasNext()){
			id++;
			Element brandEle = (Element)itBrand.next();
			brandEle.addAttribute("id",id+"");
		}
		this.saveXML("新的收藏信息.xml");
	}
	public void delPhoneInfo(){
		Element root = doc.getRootElement();
		Iterator itBrand = root.elementIterator();
		while(itBrand.hasNext()){
			Element brandEle = (Element)itBrand.next();
			if(brandEle.attributeValue("name").equals("三星")){
				brandEle.getParent().remove(brandEle);
			}
		}
	}
	public static void main(String[] args) {
		nodeTest parse = new nodeTest();
		parse.loadDocument();
		parse.addPhoneInfo();
		
		parse.modifyPhoneInfo();
		parse.showInfo();
		parse.delPhoneInfo();
	}
}


/*public static void main(String[] args) {
	new nodeTest().loadDocument();

}
public void loadDocument(){
	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc=builder.parse("NewFile.xml");;
		NodeList brandList=doc.getElementsByTagName("Brand");
		for(int i=0;i<brandList.getLength();i++)
		{
			System.out.println(brandList.getLength());
			Node brand=brandList.item(i);
			Element element=(Element) brand;
			String attrValue=element.getAttribute("name");
			System.out.println(attrValue);
			NodeList types =element.getChildNodes();				
			System.out.println("types::"+types.getLength());
			for(int j=0;j<types.getLength();j++)
			{
				
				Node tempType = types.item(j);
				if(tempType.getNodeType()==Node.ELEMENT_NODE) {
				Element typeElement=(Element)tempType;
				String type=typeElement.getAttribute("name");
				System.out.print("手机"+attrValue+type);
			}
				}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}*/