package lab6.udp;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import javax.swing.JOptionPane;
import lab6.controllers.LocaleController;

public class Utils {
public static byte[] intToBytes( final int i ) {
        ByteBuffer bb = ByteBuffer.allocate(4); 
        bb.putInt(i); 
        return bb.array();
    }
    
    public static byte[] serializeObject(Object o) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        byte[] result = null;
        try {
          out = new ObjectOutputStream(bos);
          out.writeObject(o);
          out.flush();
          result = bos.toByteArray();
        } catch (IOException ex) {}
        finally {
          try {
            bos.close();
          } catch (IOException ex) {}
        }
        return result;
    }
    public static Object deserializeObject(byte[] b) {
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        ObjectInput in = null;
        Object result = null;
        try {
          in = new ObjectInputStream(bis);
          result = in.readObject();
        } catch (IOException ex) {ex.printStackTrace();}
         catch (ClassNotFoundException ex) {ex.printStackTrace();}
        finally {
          try {
            if (in != null) {
              in.close();
            }
          } catch (IOException ex) {ex.printStackTrace();}
        }
        return result;
    }
    public static byte[] joinByteArrays(List<byte[]> chunks) {
        int totalLength = 0;
        for (byte[] chunk : chunks) {
            totalLength += chunk.length;
        }

        byte[] result = new byte[totalLength];
        int offset = 0;
        for (byte[] chunk : chunks) {
            System.arraycopy(chunk, 0, result, offset, chunk.length);
            offset += chunk.length;
        }

        return result;
    }
    public static byte checkFirst4Bytes(byte[] arr) {
        if(arr.length < 4) return (byte)255;
        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3])
            return arr[0];
        return (byte)255;
    }
    public static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
    public static boolean checkForError(Component node, ServerCommand request) {
        if(request.type == ServerCommandType.ERROR) {
            JOptionPane.showMessageDialog(node, Utils.convert(request), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public static Object convert(ServerCommand command) {
        return (Object)Utils.deserializeObject(command.data);
    }
}
