package ru.taxi.socket;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by kislitsin on 29.04.2016.
 */
public class Client extends AsyncTask<Void, Void, String> {

    PrintWriter printWriter;
    String dstAddress;
    int dstPort;
    String buffer = "auth:login=`1503`;pass=`112511`";
    String textBuffer = null;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    private boolean success;
    private String response;
    private static final String TAG = "myLogs";

    Client(String addr, int port, String textBuffer) {
        dstAddress = addr;
        dstPort = port;
        this.textBuffer = textBuffer;
    }

    @Override
    protected String doInBackground(Void... arg0) {

        Socket socket = null;
        dataOutputStream = null;
        //DataInputStream dataInputStream = null;
        dataInputStream = null;

        try {

            socket = new Socket(dstAddress, dstPort);
            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            //-----------
/*
           byte[] buf2 = "00000002 mechanic_get_car:nomer=`а048ку77`".getBytes("UTF-8");
            //  buf = "00000003 mechanic_sample:id=`а048ку77`".getBytes("UTF-8");
            dataOutputStream.write(buf2, 0, buf2.length);


            TimeUnit.SECONDS.sleep(2);

            byte[] bt1 = new byte[4096];
            dataInputStream.read(bt1);
            String st0 = new String(bt1);


            buffer = st0;
            Log.d(TAG, buffer);
*/
            //----------------------------------------------------------------

            //byte[] buf = new byte[100];
          byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`45`;ver=`3.12`;rc=`0`;pass=`45`".getBytes("UTF-8");
         //   byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`2192`;ver=`1.00`;rc=`0`;pass=`1234`".getBytes("UTF-8");
          //  byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`3711`;ver=`1.00`;rc=`0`;pass=`12365`".getBytes("UTF-8");

            dataOutputStream.write(buf, 0, buf.length);



            // transfer JSONObject as String to the server
          //  dataOutputStream.writeUTF(buffer);

            // Thread will wait till server replies
            byte[] b = new byte[34000];
         dataInputStream.read(b);
            String a = " ";
            // for each byte in the buffer
            /*
            for (byte d:b) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }
            */
            a = new String(b);
Log.d(TAG, a);


            byte[] buf1  = textBuffer.getBytes("UTF-8");

            dataOutputStream.write(buf1, 0, buf1.length);

            TimeUnit.SECONDS.sleep(3);

            dataInputStream.read(b);
           String st1 = new String(b);
//%%%%%%
                int startIndex = st1.indexOf("\tАв");
                int endIndex = st1.indexOf("\t\t");
                String endString = st1.substring(startIndex+1, endIndex-1);

//%%%%%%%%%%%%%


//-----------

            buf = "00000002 mechanic_get_car:nomer=`а048ку77`".getBytes("UTF-8");
          //  buf = "00000003 mechanic_sample:id=`а048ку77`".getBytes("UTF-8");
            dataOutputStream.write(buf, 0, buf.length);




            TimeUnit.SECONDS.sleep(2);

byte[] bt = new byte[4096];
            dataInputStream.read(bt);
            String st = new String(bt);
            /*
            a = " ";
            // for each byte in the buffer
            for (byte d:bt) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }
*/
            buffer = st;
            Log.d(TAG, a);

            //----------------------------------------------------------------
          //  dataInputStream.read(bt);
          //  String s =new String(bt);
          //  buffer = st + s;
/*
//-----------
            byte[] btt = new byte[300];
            buf = "00000003 mechanic_images:name=`1191_bodyfront.jpg`;nomer=`а048ку77`".getBytes("UTF-8");
            dataOutputStream.write(buf, 0, buf.length);

            dataInputStream.read(btt);
            a = " ";
            // for each byte in the buffer
            for (byte d:btt) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }

            Log.d(TAG, a);
            //--------------------------
*/
            /*
            byte[] btt = new byte[300];
            buf = "00000004 ver_upd".getBytes("UTF-8");
            dataOutputStream.write(buf, 0, buf.length);

            dataInputStream.read(btt);
            a = " ";
            // for each byte in the buffer
            for (byte d:btt) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }

            Log.d(TAG, a);

            */

            //--------------------------

            //  buf = "00000002 mechanic_get_car:nomer=`а048ку77`".getBytes("UTF-8");
            //buf = "00000003 mechanic_sample".getBytes("UTF-8");
         //   buf = "00000003 mechanic_ver_check".getBytes("UTF-8");
         //   dataOutputStream.write(buf, 0, buf.length);



/*
            TimeUnit.SECONDS.sleep(2);

            byte[] bt1 = new byte[496];
            dataInputStream.read(bt1);
            String st1 = new String(bt1);
            buffer = st1;
            Log.d(TAG, a);
*/

            //--------------------------------------------------

            buf = textBuffer.getBytes("UTF-8");
            dataOutputStream.write(buf, 0, buf.length);



        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            buffer = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            buffer = "IOException: " + e.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
    @Override
    protected void onPostExecute(String resJSON) {
        int b = resJSON.indexOf("{");
        if(b<0) b =9;
        String c = resJSON.substring(b);
        resJSON = c;


        b = resJSON.indexOf("=car");
        c = resJSON.substring(0, b+6);
        resJSON = c;


        JSONObject dataJsonObj = null;
String result = "";

        try {
            result = URLDecoder.decode(resJSON, "UTF-8").toString();
           // result = URLDecoder.decode(str, "UTF-8").toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
           // JSONObject dJ = new JSONObject(sample);
           // dataJsonObj = new JSONObject(str);


            JSONObject json = new JSONObject(result);
            JSONArray namearray = json.names();
            String id = json.getString("id");
            String url = json.getString("url");
            String mileage = json.getString("mileage");
            JSONArray liststatus = json.getJSONArray("statuslist");
for(int i = 0; i < liststatus.length(); i++) {
    JSONObject feature = liststatus.getJSONObject(i);

    String idf = feature.getString("ID");
    String element = feature.getString("element");
    String status = feature.getString("status");

}
            JSONArray viewingoptions = json.getJSONArray("viewingoptions");
for(int i = 0; i < viewingoptions.length(); i++){
    String vo = viewingoptions.getString(i);
    Log.d(TAG, vo);
}

          // JSONArray statuslist = new JSONArray(str);

        } catch (JSONException je) {
            je.printStackTrace();
        }
    }
    }
