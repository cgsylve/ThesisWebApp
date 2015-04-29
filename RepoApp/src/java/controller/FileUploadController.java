/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UploadDAOImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import model.UploadBean;

import org.primefaces.event.FileUploadEvent;
 
@ManagedBean(name="fileUploadController")
public class FileUploadController {
   private String destination=".\\";
   UploadBean uBean = new UploadBean();

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void uploadFile(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file
        try {
            uBean.setLiveLink(returnFile(event.getFile().getFileName(), event.getFile().getInputstream()));
            UploadDAOImpl upDAO = new UploadDAOImpl();
            upDAO.updateRecords(uBean);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(String fileName, InputStream in) {
           try {
             
                String relativeWebPath = "\\resources\\projects";
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
                String absoluteFileName = absoluteDiskPath + "\\" + fileName;
                File file = new File(absoluteFileName);

                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(file);
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
                
                System.out.println("New file created at:" + file.getAbsolutePath());
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
    public String returnFile(String fileName, InputStream in) {
        String absoluteFileName="";   
        try {
            String relativeWebPath = "\\resources\\projects";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
            absoluteFileName = absoluteDiskPath + "\\" + fileName;
            File file = new File(absoluteFileName);

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created at:" + file.getAbsolutePath());
            } catch (IOException e) {
            System.out.println(e.getMessage());
            }
        return absoluteFileName;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
