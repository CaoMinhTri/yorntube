/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yorntube.persistence;

/**
 *
 * @author plthan
 */
public class VideoType {
    private long type_id;
    private String type;

    /**
     * @return the type_id
     */
    public long getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
