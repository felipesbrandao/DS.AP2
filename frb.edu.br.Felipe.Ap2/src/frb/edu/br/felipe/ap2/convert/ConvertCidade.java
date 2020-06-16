package frb.edu.br.felipe.ap2.convert;

import frb.edu.br.felipe.ap2.entidades.Cidade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Map;

@FacesConverter(value="convertcidade")
public class ConvertCidade implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

        if(value == null || !value.matches("\\d+")) {
            return null;
        }

        return this.getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value != null && !value.equals("")) {
            Cidade cidade = (Cidade) value;

            if(cidade.getCidade_id() != null) {
                this.addAttribute(uiComponent, cidade);
                return cidade.getCidade_id().toString();
            }
        }

        return null;
    }

    private Map<String, Object> getAttributesFrom(UIComponent componente) {
        return componente.getAttributes();
    }

    private void addAttribute(UIComponent componente, Cidade cidade) {
        this.getAttributesFrom(componente).put(cidade.getCidade_id().toString(), cidade);
    }
}
