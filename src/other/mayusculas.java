/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author black
 */
public class mayusculas {
    
    public String firstMayusculas(String cadena){
        char[] c = cadena.toCharArray();
        if(cadena.length()!=0){
            c[0] = Character.toUpperCase(c[0]);
            for (int i = 0; i < cadena.length()- 2; i++)
                if (c[i] == ' ' || c[i] == '.' || c[i] == ',')
                    c[i + 1] = Character.toUpperCase(c[i + 1]);
        }
        return new String(c);
    }
    
    
}
/*


        char[] caracteres = texto.toCharArray();
             for (int i = 0; i < texto.length()- 2; i++)
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
        return String.valueOf(caracteres);

*/