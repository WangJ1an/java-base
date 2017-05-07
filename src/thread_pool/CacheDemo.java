package thread_pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 1 on 2017/3/20.
 */
public class CacheDemo {

    private Map<String,Object> cache = new HashMap<>();

    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key) {
        rwl.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (value == null) {
                        value = "aaaaa"; //实际是去queryDB，查询数据库
                    }
                } finally {
                    rwl.readLock().lock();
                }
                rwl.writeLock().unlock();
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
