package edu.eci.arsw.threads;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListsThread extends Thread {
    private String ipAddress;

    public HostBlackListsThread(String ipAddress, int start, int end, HostBlacklistsDataSourceFacade skds) {
        this.ipAddress = ipAddress;

    }

    @Override
    public void run() {


    }

    public int countOccurrences() {
        return 0;
    }
}
