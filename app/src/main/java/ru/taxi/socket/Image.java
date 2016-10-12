package ru.taxi.socket;

/**
 @author Created by Kislitsin on 06.06.2016.
 @version 1.01
 */
public class Image {
    private String path;
    private String name;

    /** new object
      * @param path path of Image
      * @param name this name of Image file
      * @see Image#Image(String, String)
     */


public Image (String path, String name) {
    this.name = name;
    this.path = path;
}

    /**
     *
     * @return The path of Image which you get by <b>{@link #setPath}</b>
     */
    public String getPath() {return path;}
    public String getName() {return name;}

    /**
     *
     * @param path set path of Image
     */
    public void setPath(String path) {this.path = path;}

    /**
     *
     * @param name set name Image
     */
    public void setName (String name) {this.name = name;}


}
