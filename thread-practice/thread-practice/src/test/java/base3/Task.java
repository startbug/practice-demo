package base3;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 10:05
 */
public class Task implements Delayed {

    /**
     * 任务名称
     */
    private String name;

    /**
     * 什么时间点执行
     */
    private Long time;

    /**
     * @param name
     * @param delay 单位毫秒
     */
    public Task(String name, Long delay) {
        this.name = name;
        this.time = System.currentTimeMillis() + delay;
    }

    /**
     * 设置任务什么时候可以出任务队列
     * @param unit the time unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - System.currentTimeMillis(), TimeUnit.NANOSECONDS);
    }

    /**
     * 两个任务在插入到延迟队列时的比较方式
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.time - ((Task) o).getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
