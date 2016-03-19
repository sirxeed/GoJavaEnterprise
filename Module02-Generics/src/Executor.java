import java.util.List;

public interface Executor<T> {

    // �������� ���� �� ����������. ��������� ����� ����� �������� ����� �����
    //      getValidResults().
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task <? extends T> task);

    // �������� ���� �� ���������� � ��������� ����������. ��������� ����� �����
    //      ������� � ValidResults ���� validator.isValid ������ true ��� �����
    //      ����������
    // ��������� ����� ����� ������� � InvalidResults ���� validator.isValid ������
    //      false ��� ����� ����������
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task <? extends T> task, Validator <? super T> validator);

    // ��������� ��� ���������� �����
    void execute();

    // �������� �������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getValidResults();

    // �������� ���������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getInvalidResults();

}