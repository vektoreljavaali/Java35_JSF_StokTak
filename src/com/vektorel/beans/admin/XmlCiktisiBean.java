package com.vektorel.beans.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vektorel.dal.tblurundao;
import com.vektorel.models.tblurun;

@SuppressWarnings("deprecation")
@ManagedBean(name="xmlciktisiBean")
@SessionScoped
public class XmlCiktisiBean {

	tblurundao db = new tblurundao();
	
	
	private List<tblurun> liste = new ArrayList<>();

	public void xmldonustur() {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("exchangeData");
			doc.appendChild(rootElement);

			Element staff = doc.createElement("exchangeHeader");
			rootElement.appendChild(staff);

			staff.setAttribute("version", "1.1");

			// XML Ana Nod kýsmý oluþturuluyorç
			Element urunler = doc.createElement("Urunler");
			rootElement.appendChild(urunler);

			// VT deki tüm ürünler 
			//<Ürünler>
			// <urun ID=1, AD="dsad"/>
			// <urun />
			// ...
			//</Ürünler> Nod u nun içine eklenir.
			for (tblurun item : getListe()) {
				Element urun = doc.createElement("urun");
				urunler.appendChild(urun);
				urun.setAttribute("ID", item.getId()+"");
				urun.setAttribute("AD", item.getAd()+"");
				urun.setAttribute("FIYAT", item.getFiyat()+"");
				urun.setAttribute("BARKOD", item.getBarkod()+"");
				urun.setAttribute("KDV", item.getKdv()+"");
									
			}
			
			// Local bir noktaya XML dosyasýný kayýt eder.
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("d:\\test.xml"));
		    transformer.transform(source, result);

		    // ÝSTENÝLEN BÝR DOSYANIN ÝNDÝRÝLMESÝNÝ SAÐLAR
			File file = new File("d:\\test.xml");
			InputStream fis = new FileInputStream(file);
			byte[] buf = new byte[(int) file.length()];
			int offset = 0;
			int numRead = 0;
			while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
				offset += numRead;
			}
			fis.close();
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();

			response.setContentType("text/xml");
			response.setHeader("Content-Disposition", "attachment;filename=UrunListesi.xml");
			response.getOutputStream().write(buf);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			FacesContext.getCurrentInstance().responseComplete();
			// KOD SONU....
			
		}
		catch(Exception ex) {
			System.out.println("Hata.....: "+ ex.toString());			
		}
		
	}
	
	public List<tblurun> getListe() {
		return db.listele(new tblurun());
	}

	public void setListe(List<tblurun> liste) {
		this.liste = liste;
	}
	
	
	
	
	
}
