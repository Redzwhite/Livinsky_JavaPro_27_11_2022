package homework12.Task_0;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList {

    private List<String> list = new ArrayList();

    public String get(final int index) {
        synchronized (list) {
            return list.get(index);
        }
    }


        public void add (final String value){
            synchronized(list) {
                list.add(value);
            }
        }

    public String remove (final int index) {
        synchronized (list) {
            return list.remove(index);
        }
    }

    }

