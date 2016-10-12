package ru.taxi.socket;

import android.content.res.Resources;
import android.os.AsyncTask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by kislitsin on 01.06.2016.
 */
public class Task extends AsyncTask<String, String, String> {

    protected final Resources mResources;

    private Boolean mResult;
    private String mProgressMessage;
    private IProgressTracker mProgressTracker;
    private String addressT;
    private String authT;
    private String commandT;
    private int portT;

    public Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    /* UI Thread */
    public Task(Resources resources, String address, int port, String auth, String command) {
        // Keep reference to resources
        mResources = resources;
        // Initialise initial pre-execute message
        mProgressMessage = resources.getString(R.string.task_starting);
        addressT = address;
        authT = auth;
        commandT = command;
        portT = port;
    }

    /* UI Thread */
    public void setProgressTracker(IProgressTracker progressTracker) {
        // Attach to progress tracker
        mProgressTracker = progressTracker;
        // Initialise progress tracker with current task state
        if (mProgressTracker != null) {
            mProgressTracker.onProgress(mProgressMessage);
            if (mResult != null) {
                mProgressTracker.onComplete();
            }
        }
    }

    /* UI Thread */
    @Override
    protected void onCancelled() {
        // Detach from progress tracker
        mProgressTracker = null;
    }

    /* UI Thread */
    @Override
    protected void onProgressUpdate(String... values) {
        // Update progress message
        mProgressMessage = values[0];
        // And send it to progress tracker
        if (mProgressTracker != null) {
            mProgressTracker.onProgress(mProgressMessage);
        }
    }
    /* Separate Thread */
    @Override
    protected String doInBackground(String... arg0) {
        // Working in separate thread
        for (int i = 10; i > 0; --i)
        {
            // Check if task is cancelled
            if (isCancelled()) {
                // This return causes onPostExecute call on UI thread
                return "1";
            }

            try {
                // This call causes onProgressUpdate call on UI thread
                publishProgress(mResources.getString(R.string.task_starting, i));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // This return causes onPostExecute call on UI thread
                return "2";
            }
        }
        // This return causes onPostExecute call on UI thread
        return "3";
    }

}
