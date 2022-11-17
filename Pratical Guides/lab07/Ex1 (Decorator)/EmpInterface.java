import java.util.Date;

public interface EmpInterface {
    void start(Date sDate);
    void terminate(Date tDate);
    void work();
    String getName();
}