package edu.eci.arsw.threads;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListsThread extends Thread {
    private static final int BLACK_LIST_ALARM_COUNT=5;
    private String ipAddress;
    private int start;
    private int end;

    public HostBlackListsThread(String ipAddress, int start, int end, HostBlacklistsDataSourceFacade skds) {
        this.ipAddress = ipAddress;
        this.start = start;
        this.end = end;


    }

    @Override
    public void run() {
        int ocurrencesCount = 0;

        for (int i=0;i < end && ocurrencesCount<BLACK_LIST_ALARM_COUNT;i++) {

            if (skds.isInBlackListServer(i, ipaddress)){
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
    }

    public int countOccurrences() {
        return 0;
    }
}
