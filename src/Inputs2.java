/**
 * Keyboard Input Library
 * Andrew Errity v0.2 (2015-Oct-01)
 * GoToLoop v1.0.4 (2015-Oct-22)
 *
 * https://Forum.Processing.org/two/discussion/13175/
 * do-whille-is-not-working-how-it-suppose-to#Item_12
 *
 * https://GitHub.com/aerrity/Inputs/blob/master/src/Inputs.java
 * https://Gist.GitHub.com/GoToLoop/bba0c288aaeeb5ef9bb1
 */

package iadt.creative;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public final class Inputs {
  protected static final String TITLE = "Input required!", CHOOSE = "Choose one:";
  protected static final int CHARS = 25;

  protected static final JTextField field = new JTextField(CHARS);
  protected static final JLabel label = new JLabel();
  protected static final JPanel panel = new JPanel(new BorderLayout(5, 2));

  static {
    panel.add(label, BorderLayout.WEST);
    panel.add(field);
  }

  protected static final JDialog dialog = new JOptionPane(panel, QUESTION_MESSAGE) {
    @Override public final void selectInitialValue() {
      field.requestFocusInWindow();
    }
  }
  .createDialog(null, TITLE);

  public static final String readString(final String txt) {
    label.setText(txt);
    field.setText("");

    dialog.setVisible(true);
    return field.getText();
  }

  public static final boolean readBoolean(final String label) {
    return showConfirmDialog(null, label, CHOOSE, YES_NO_OPTION) == YES_OPTION;
  }

  public static final byte readByte(final String label) {
    return readByte(label, Byte.MIN_VALUE);
  }

  public static final byte readByte(final String label, final int failValue) {
    try {
      return Byte.parseByte(readString(label));
    }
    catch (final NumberFormatException ex) {
      return (byte) failValue;
    }
  }

  public static final short readShort(final String label) {
    return readShort(label, Short.MIN_VALUE);
  }

  public static final short readShort(final String label, final int failValue) {
    try {
      return Short.parseShort(readString(label));
    }
    catch (final NumberFormatException ex) {
      return (short) failValue;
    }
  }

  public static final int readInt(final String label) {
    return readInt(label, Integer.MIN_VALUE);
  }

  public static final int readInt(final String label, final int failValue) {
    try {
      return Integer.parseInt(readString(label));
    }
    catch (final NumberFormatException ex) {
      return failValue;
    }
  }

  public static final long readLong(final String label) {
    return readLong(label, Long.MIN_VALUE);
  }

  public static final long readLong(final String label, final long failValue) {
    try {
      return Long.parseLong(readString(label));
    }
    catch (final NumberFormatException ex) {
      return failValue;
    }
  }

  public static final float readFloat(final String label) {
    return readFloat(label, Float.MIN_VALUE);
  }

  public static final float readFloat(final String label, final float failValue) {
    try {
      return Float.parseFloat(readString(label));
    }
    catch (final NumberFormatException ex) {
      return failValue;
    }
  }

  public static final double readDouble(final String label) {
    return readDouble(label, Double.MIN_VALUE);
  }

  public static final double readDouble(final String label, final double failValue) {
    try {
      return Double.parseDouble(readString(label));
    }
    catch (final NumberFormatException ex) {
      return failValue;
    }
  }
}
