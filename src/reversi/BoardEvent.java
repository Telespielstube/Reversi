/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.util.EventObject;
/**
 *
 * @author marta
 */
public class BoardEvent extends EventObject {
    public final static int GAME_OVER = 1000;
    public final static int INVALID_MOVE = 1001;
    private int eventCode;
    
    /* The BoardEvent constructor.
     * 
     */
    public BoardEvent(Object source, int eventCode) {
        super(source);
        this.eventCode = eventCode;
    }
    
    /* The method getEventCode returns the fitting code for each event.
     * 
     * @return eventCode    returns the fitting code for each event.
     * 
     */ 
    public int getEventCode() {
        return eventCode;
    }

    
}
