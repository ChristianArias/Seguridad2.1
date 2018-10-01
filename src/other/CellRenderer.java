package other;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //establecemos el fondo blanco o vacío
    //    setBackground(null);
        //COnstructor de la clase DefaultTableCellRenderer
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JLabel lb = (JLabel)super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column/* params from above */);
        String tx = String.valueOf(table.getModel().getValueAt(row, 1));
        String t = String.valueOf(table.getModel().getValueAt(row, column));
        lb.setToolTipText("<html>Doble click para editar "+tx+"<br>Texto: "+t+"</html>");
        //
        if(value instanceof JButton){ return (JButton)value; }
        //
        int align = DefaultTableCellRenderer.CENTER;
        //Alinea el contenido de la tabla al centro
        ((DefaultTableCellRenderer)cellComponent).setHorizontalAlignment(align);
        //Establecemos las filas que queremos cambiar el color. == 0 para pares y != 0 para impares
        boolean oddRow = (row % 2 != 0);
        Color c = new Color(226,226,226);        
        if (oddRow) { setBackground(c); }else{ setBackground(Color.white); }
        return this;
    }

}