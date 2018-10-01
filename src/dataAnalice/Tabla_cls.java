/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataAnalice;

/**
 *
 * @author Wilfo Martel S.
 * e-mail:logica_Razon@hotmail.com
 * cel:082502692
 * Usa este código para fines educativos,comerciales ,etc.  pero respeta el autor del código.
 */
public class Tabla_cls {
String field;
String type;

public Tabla_cls(){}

    public Tabla_cls(String field, String type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }



}
