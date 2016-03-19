import java.util.List;

public interface Executor {

    // �������� ���� �� ����������. ��������� ����� ����� �������� ����� ����� getValidResults().
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task task);

    // �������� ���� �� ���������� � ��������� ����������. ��������� ����� ����� ������� � ValidResults ���� validator.isValid ������ true ��� ����� ����������
    // ��������� ����� ����� ������� � InvalidResults ���� validator.isValid ������ false ��� ����� ����������
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task task, Validator validator);

    // ��������� ��� ���������� �����
    void execute();

    // �������� �������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List getValidResults();

    // �������� ���������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List getInvalidResults();

}