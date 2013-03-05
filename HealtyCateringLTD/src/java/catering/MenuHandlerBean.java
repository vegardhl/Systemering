/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catering;

import javax.inject.Named;

import java.io.Serializable; 
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.ExternalContext;

@Named("menuhandler")
@SessionScoped

/**
 * Fungerer som en mal for alle scene klassene. Denne klassen inneholder
 * metoder som forenkler de forskjellige sceneklassene.
 * @author Team 6
 */
public class MenuHandlerBean implements Serializable {
    
}
