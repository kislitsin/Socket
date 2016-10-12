package ru.taxi.socket;

/**
 * Created by kislitsin on 01.06.2016.
 */
public interface OnTaskCompleteListener {
    // Notifies about task completeness
    void onTaskComplete(Task task);
}
