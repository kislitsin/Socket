package ru.taxi.socket;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * Created by kislitsin on 17.05.2016.
 */
public class HttpUpLoader extends AsyncTask<Void, Void, Integer> {

    private static final String TAG = "[ HttpFileUploader ] ";

    private String urlPath;
    private String filePath;
    private String fileName;
    private boolean removeAfterSuccess;
    //MainActivity ma = new MainActivity();
    Socket socket;



    public HttpUpLoader(String urlPath, String filePath, String fileName) {
        this.urlPath = urlPath;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    @Override
    protected void onPreExecute() {


        Log.d(TAG, "preExecute----+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++_______________");
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
      //  ma.hideProgressBar();
        Log.d(TAG, "PostExecute-------------------------------------------------------------------------------------------------------");
    }


    @Override
    protected Integer doInBackground (Void... arg0) {

        File file = null;
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;


        DataOutputStream dOutputStream;
        DataInputStream dInputStream;


       // BufferedOutputStream outputStream = null;
        //DataInputStream inputStream = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary =  "*****";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1*1024*1024;



        try{


            socket = null;
            dOutputStream = null;
            //DataInputStream dataInputStream = null;
            dInputStream = null;


            file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);

            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();






            // Allow Inputs &amp; Outputs.
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            // Set HTTP method to POST.
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);

            outputStream = new DataOutputStream( connection.getOutputStream() );
           // outputStream = new BufferedOutputStream( connection.getOutputStream() );
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream.writeBytes("Content-Disposition: form-data; name=\"userfile\";filename=\"" + fileName + "\"" + lineEnd);
            outputStream.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // Read file
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(lineEnd);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            // Responses from the server (code and message)
            int serverResponseCode = connection.getResponseCode();
            if (serverResponseCode == 200 && removeAfterSuccess && file != null) {
                file.delete();
            }


            fileInputStream.close();
            outputStream.flush();
            outputStream.close();

            //--------------------------------------------------------------------------------------------
            socket = new Socket("ip.cbzt.ru", 4443);

            dOutputStream = new DataOutputStream(
                    socket.getOutputStream());
            dInputStream = new DataInputStream(socket.getInputStream());

            //  byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`1503`;ver=`3.11`;rc=`0`;pass=`112511`".getBytes("UTF-8");
            byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`2192`;ver=`3.11`;rc=`0`;pass=`1234`".getBytes("UTF-8");


            dOutputStream.write(buf, 0, buf.length);
            byte[] b = new byte[300];
            dInputStream.read(b);
            String a = " ";
            // for each byte in the buffer
            for (byte d:b) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }


//-----------------------------------------------------------------------

            return (serverResponseCode == 200) ? 1 : 0;

        }catch (Exception e){
            Log.d(TAG,  "Exception : " + e.getMessage() + " while sending to " + urlPath);
        }



    return 0;
    }


}
