/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author Huan_Nguyen
 */

 
@ManagedBean
public class FileDownloadController {
     
    //private StreamedContent file;
     
    public FileDownloadController() {        
        //InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
        //file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
    }
 
    public StreamedContent returnFile() throws Exception {
        StreamedContent download=new DefaultStreamedContent();
        Map<String,String> params = 
            FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String fileLink = params.get("theLink");
        //String fileLinkFixed = fileLink.replaceAll("\\", "\\\\");
        System.out.println("HIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHIHI");
        System.out.println(fileLink);
        File theFile = new File(fileLink);
        InputStream input = new FileInputStream(theFile);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        download = new DefaultStreamedContent(input, externalContext.getMimeType(theFile.getName()), theFile.getName());
        System.out.println("PREP = " + download.getName());
        //int cutAt = fileLink.lastIndexOf('\\');
        //String fileName = fileLink.substring(cutAt);
        //System.out.println(fileName);      
        return download;
    }
    
    
//    public StreamedContent getFile() {
//        return file;
//    }
}