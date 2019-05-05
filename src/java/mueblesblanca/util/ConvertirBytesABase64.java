/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ConvertirBytesABase64 {

    public String convertirABase64(InputStream in, Blob blob) {
        String imageString = "";
        try {
            if (in != null) {
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = new BASE64Encoder().encode(imageBytes);

                inputStream.close();
                outputStream.close();

                imageString = base64Image;
            }
        } catch (Exception e) {
        }
        return imageString;
    }

}
