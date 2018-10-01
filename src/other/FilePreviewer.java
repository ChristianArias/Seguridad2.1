/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SELECTED_FILE_CHANGED_PROPERTY;

/**
 *
 * @author Christian
 */
    public class FilePreviewer extends JComponent implements PropertyChangeListener {

        ImageIcon thumbnail = null;

        @SuppressWarnings("LeakingThisInConstructor")
        public FilePreviewer(JFileChooser fc) {
            setPreferredSize(new Dimension(200, 100));
            fc.addPropertyChangeListener(this);
        }

        public void loadImage(File f) {
            if (f == null) {
                thumbnail = null;
            } else {
                ImageIcon tmpIcon = new ImageIcon(f.getPath());
                if (tmpIcon.getIconWidth() > 150) {
                    thumbnail = new ImageIcon(
                            tmpIcon.getImage().getScaledInstance(150, -1,
                            Image.SCALE_DEFAULT));
                } else {
                    thumbnail = tmpIcon;
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();
            if (SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
                if (isShowing()) {
                    loadImage((File) e.getNewValue());
                    repaint();
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            if (thumbnail != null) {
                int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
                int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;
                if (y < 0) {
                    y = 0;
                }

                if (x < 5) {
                    x = 5;
                }
                thumbnail.paintIcon(this, g, x, y);
            }
        }
    }
