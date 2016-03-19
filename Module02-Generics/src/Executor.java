import java.util.List;

public interface Executor<T> {

    // �������� ���� �� ����������. ��������� ����� ����� �������� ����� �����
    //      getValidResults().
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task <? extends T> task) throws Exception;

    // �������� ���� �� ���������� � ��������� ����������. ��������� ����� �����
    //      ������� � ValidResults ���� validator.isValid ������ true ��� �����
    //      ����������
    // ��������� ����� ����� ������� � InvalidResults ���� validator.isValid ������
    //      false ��� ����� ����������
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task <? extends T> task, Validator <? super T> validator) throws Exception;

    // ��������� ��� ���������� �����
    void execute();

    // �������� �������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getValidResults() throws Exception;

    // �������� ���������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getInvalidResults() throws Exception;

}