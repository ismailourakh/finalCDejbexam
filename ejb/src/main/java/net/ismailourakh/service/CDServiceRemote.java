import java.util.List;

public interface CDServiceRemote {
    void addCD(CD cd);
    void updateCD(CD cd);
    void removeCD(Long id);
    CD findCD(Long id);
    List<CD> findAllCDs();
}
