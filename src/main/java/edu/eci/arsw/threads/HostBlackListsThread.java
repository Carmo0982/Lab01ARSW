package edu.eci.arsw.threads;
import edu.eci.arsw.blacklistvalidator.HostBlackListsValidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;

public class HostBlackListsThread extends Thread {
    private String ipAddress;
    private int start;
    private int end;
    private HostBlacklistsDataSourceFacade skds;

    public HostBlackListsThread(String ipAddress, int start, int end, HostBlacklistsDataSourceFacade skds) {
        this.ipAddress = ipAddress;
        this.start = start;
        this.end = end;
        this.skds = skds;
    }

    LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    int ocurrencesCount = 0;
    int checkedListsCount=0;

    @Override
    public void run() {
        for (int i = start; i < end && ocurrencesCount< HostBlackListsValidator.BLACK_LIST_ALARM_COUNT; i++) {
            checkedListsCount++;

            if (skds.isInBlackListServer(i, ipAddress)) {
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
    }

    public int getOccurrencesCount() {
        return ocurrencesCount;

    }

    public int getCheckedListsCount() {
        return checkedListsCount;
    }

    public LinkedList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }
}
