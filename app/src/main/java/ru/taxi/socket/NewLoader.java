package ru.taxi.socket;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by kislitsin on 06.06.2016.
 */
public class NewLoader extends AsyncTask<Image, Integer, Integer> {

    Socket socket = null;
    Boolean removeAfterSuccess = false;
  ProgressDialog mProgress;
   public MainActivity activity;

    // Конструктор
    public NewLoader (MainActivity a) {
        this.activity = a;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Create ProgressBar
        mProgress = new ProgressDialog(activity);
        // Set your ProgressBar Title
        mProgress.setTitle("Downloads");
        //mProgressDialog.setIcon(R.drawable.dwnload);
        // Set your ProgressBar Message
        mProgress.setMessage("Updating App Version, Please Wait!");
        mProgress.setIndeterminate(false);
        mProgress.setMax(10);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // Show ProgressBar
        mProgress.setCancelable(false);
        //  mProgressDialog.setCanceledOnTouchOutside(false);
        mProgress.show();
    }


    @Override
    protected Integer doInBackground(Image... images) {
        File file = null;
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;

        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary =  "*****";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1*1024*1024;

        DataOutputStream socketDataOutputStream = null;
        DataInputStream socketDataInputStream = null;


        try {
            int cnt = 0;
            socket = new Socket("ip.cbzt.ru", 4443);
            if (socket == null) return 5;

            socketDataInputStream = new DataInputStream(socket.getInputStream());
            socketDataOutputStream = new DataOutputStream(socket.getOutputStream());
            byte[] buf = "00000001 auth:screenSize=`4.07269`;platform=`android`;model=`m4_open_cis`;devid=`6cf9da7c2e914a22`;login=`2192`;ver=`1.01`;rc=`0`;pass=`1234`".getBytes("UTF-8");
            socketDataOutputStream.write(buf, 0, buf.length);

            // Thread will wait till server replies
            byte[] b = new byte[300];
            socketDataInputStream.read(b);
            String a = " ";
            // for each byte in the buffer
            for (byte d:b) {
                // convert byte into character
                char c = (char) d;
                a = a + c;
            }
if(a.contains("success=`1`") && a.contains("buket=`3`")) {

} else {return 3;}// auth error


            for (Image img : images) {
                // загружаем файл
                file = new File(img.getPath());
                FileInputStream fileInputStream = new FileInputStream(file);

                URL url = new URL("http://ip.cbzt.ru/upload_file.php?t=car");
                connection = (HttpURLConnection) url.openConnection();
                if (connection == null) return 6;
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
                outputStream.writeBytes("Content-Disposition: form-data; name=\"userfile\";filename=\"" + img.getName() + "\"" + lineEnd);
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

                byte[] btt = new byte[300];
                String tx = "00000003 mechanic_images:name=`" +img.getName()+"`;nomer=`а048ку77`;date=`20170220`";
                buf = tx.getBytes("UTF-8");
                socketDataOutputStream.write(buf, 0, buf.length);

                socketDataInputStream.read(btt);
                a = " ";
                // for each byte in the buffer
                for (byte d:btt) {
                    // convert byte into character
                    char c = (char) d;
                    a = a + c;
                }
/*
                if(a.contains("ord_lst_get_begin")) {
                    socketDataInputStream.read(btt);
                    a = " ";
                    // for each byte in the buffer
                    for (byte d:btt) {
                        // convert byte into character
                        char c = (char) d;
                        a = a + c;
                    }
                }

                */
    if(a.contains("status=`ok`")) {} else return 4;



                // выводим промежуточные результаты
                publishProgress(++cnt);
            }
            // разъединяемся
            TimeUnit.SECONDS.sleep(1);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("New", "Exception " + e.getMessage() + " while sending to ");
            return 1;
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return 2;
                }
            }
        }
        return 0;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
          //  activity.responseTextView.setText("ЗАГРУЖЕНО  -  " + values[0].toString() + "файлов из 12...");
        mProgress.setProgress(values[0]);

    }
    protected void onPostExecute(Integer res) {
        activity.hideProgressBar();
       // if(res != 0) { activity.responseTextView.setText("MISTAKE!!!!!    " + res.toString());}
        mProgress.dismiss();
    }

}
