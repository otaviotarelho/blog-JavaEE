/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Form {

    private String nome;
    private Locale localizacao;
    private static final Locale[] countries = {Locale.ENGLISH, Locale.forLanguageTag("pt-br")};

    /**
     * Creates a new instance of Form
     */
    public Form() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Locale getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Locale localizacao) {
        this.localizacao = localizacao;
    }

    public void mudouIdioma(ValueChangeEvent event) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) event.getNewValue());
    }

    public List<SelectItem> getIdiomasSuportados() {
        List<SelectItem> idiomas = new ArrayList<>();
        for (Locale loc : countries) {
            idiomas.add(new SelectItem(loc,
                    loc.getDisplayLanguage()));
        }
        return idiomas;
    }
}
