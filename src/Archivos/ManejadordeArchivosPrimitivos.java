package Archivos;

import CINE.Pelicula;

import java.io.*;
import java.io.IOException;
/**
 * Clase encargada de manejar el fluja de datos de los archivos con datos primitivos
 * @author Motta
 */
public class ManejadordeArchivosPrimitivos {
    public static void persistenciaArchivo(String nombrearchivo, Pelicula lapeli, int entradasvendidas,float precioentrada)
    {

//     //Los parametros aun pueden cambiar

        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombrearchivo+".dat");
            dataOutputStream = new DataOutputStream(fileOutputStream);


            dataOutputStream.writeUTF(lapeli.getNombre());
            dataOutputStream.writeInt(entradasvendidas);
            dataOutputStream.writeFloat(entradasvendidas*precioentrada);


        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fileOutputStream!=null)
                    fileOutputStream.close();

                if (dataOutputStream!=null)
                        dataOutputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
    }
    public static void depersistenciaArchivos(String nombrearchivo)
    {
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(nombrearchivo+".dat");
            dataInputStream = new DataInputStream(fileInputStream);

            while (true)
            {
                String unString = dataInputStream.readUTF();
                float unflotante = dataInputStream.readFloat();
                int unEntero = dataInputStream.readInt();

                System.out.println(" "+unString+ unflotante + " "+unEntero );

                System.out.println();

            }
        }
        catch (EOFException ex)
        {
            System.out.println("FIN del archivo");
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fileInputStream!=null)
                    fileInputStream.close();

                if (dataInputStream!=null)
                    dataInputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
    }
}
