package ru.taxi.socket;

/**
 * Created by kislitsin on 01.06.2016.
 */
public interface IProgressTracker {

        // Updates progress message
        void onProgress(String message);
        // Notifies about task completeness
        void onComplete();
    }

