public interface Task<T> {

    // ������ ��������� ���� �� ����������
    void execute();

    // ���������� ��������� ����������
    Object getResult();
}