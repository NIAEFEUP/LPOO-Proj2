package Engine;


import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

import Server.Server;


/**
 *
 */
public class RemoteTrackController implements Observer, TrackController{
    private Track track;
    private AtomicInteger rowLeft;
    private AtomicInteger rowRight;

    public RemoteTrackController(Track track, Server server){
        this.track = track;
        server.addObserver(this);
        track.getCanoe().addObserver(server);
        rowLeft.set(0);
        rowRight.set(0);
    }

    @Override
    public void update(Observable o, Object arg) {
        int playerNr = (int) arg;
        switch (playerNr){
            case Server.LEFT_SIDE:
                rowLeft.incrementAndGet();
                break;
            case Server.RIGHT_SIDE:
                rowRight.incrementAndGet();
                break;
        }
    }

    @Override
    public void processInput() {
        while (rowLeft.get() > 0) {
            track.getCanoe().rowLeft();
            rowLeft.decrementAndGet();
        }
        while (rowRight.get() > 0) {
            track.getCanoe().rowRight();
            rowRight.decrementAndGet();
        }
    }
}