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
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import model.UploadBean;

//import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@SessionScoped
@ManagedBean(name="fileUploadController")
public class FileUploadController implements Serializable{

   private String destination=".\\";
   private UploadBean upBean;
   private UploadedFile theFile;

    public FileUploadController() {
        upBean = new UploadBean();
    }
    
//    public void upload(FileUploadEvent event) {  
//        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        // Do what you want with the file        
//        try {
//            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    
    public void uploadFile() {
        FacesMessage msg = new FacesMessage("Success! ", theFile.getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file
        try {
            String courseNumber = upBean.getCourseNumber();
            String liveLink = returnFile(theFile.getFileName(), theFile.getInputstream());
            String keyWordOne = upBean.getKeyWordOne();
            String committeeChair = upBean.getCommitteeChair();
            String semesterComplete = upBean.getSemesterComplete();
            String studentName = upBean.getStudentName();
            String dateCompleted = upBean.getDateCompleted();
            String UserID = upBean.getUserID();
            
            //UploadBean newBean = new UploadBean(courseNumber,liveLink,keyWordOne,committeeChair,semesterComplete,studentName,dateCompleted,UserID);
            
            UploadDAOImpl upDAO = new UploadDAOImpl();
            upDAO.updateRecords(courseNumber,liveLink,keyWordOne,committeeChair,semesterComplete,studentName,dateCompleted,UserID);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void copyFile(String fileName, InputStream in) {
//           try {
//             
//                String relativeWebPath = "\\resources\\projects";
//                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//                String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
//                String absoluteFileName = absoluteDiskPath + "\\" + fileName;
//                File file = new File(absoluteFileName);
//
//                // write the inputStream to a FileOutputStream
//                OutputStream out = new FileOutputStream(file);
//             
//                int read = 0;
//                byte[] bytes = new byte[1024];
//             
//                while ((read = in.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                }
//             
//                in.close();
//                out.flush();
//                out.close();
//                
//                System.out.println("New file created at:" + file.getAbsolutePath());
//                } catch (IOException e) {
//                System.out.println(e.getMessage());
//                }
//    }
    
    public String returnFile(String fileName, InputStream in) {
        String absoluteFileName="";   
        try {
            String relativeWebPath = "\\resources\\projects";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
<<<<<<< HEAD
            absoluteFileName = "gfish2.it.ilstu.edu\\crsage\\projects\\" + fileName;
=======
            
            absoluteFileName = absoluteDiskPath + "\\" + fileName;
>>>>>>> origin/master
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

    /**
     * @return the upBean
     */
    public UploadBean getUpBean() {
        return upBean;
    }

    /**
     * @param upBean the upBean to set
     */
    public void setUpBean(UploadBean upBean) {
        this.upBean = upBean;
    }

    /**
     * @return the theFile
     */
    public UploadedFile getTheFile() {
        return theFile;
    }

    /**
     * @param theFile the theFile to set
     */
    public void setTheFile(UploadedFile theFile) {
        this.theFile = theFile;
    }
}